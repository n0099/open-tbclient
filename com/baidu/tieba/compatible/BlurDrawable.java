package com.baidu.tieba.compatible;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
/* loaded from: classes4.dex */
public class BlurDrawable {
    public static boolean enabled;
    public Bitmap mBitmapToBlur;
    public Allocation mBlurInput;
    public Allocation mBlurOutput;
    public ScriptIntrinsicBlur mBlurScript;
    public Bitmap mBlurredBitmap;
    public RenderScript mRenderScript;

    static {
        enabled = Build.VERSION.SDK_INT >= 17;
    }

    public BlurDrawable(Context context) {
        if (context == null) {
            return;
        }
        initializeRenderScript(context);
    }

    @TargetApi(17)
    private void initializeRenderScript(Context context) {
        try {
            if (enabled) {
                RenderScript create = RenderScript.create(context);
                this.mRenderScript = create;
                this.mBlurScript = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            enabled = false;
        }
    }

    @TargetApi(17)
    public void blur(Bitmap bitmap, Bitmap bitmap2) {
        if (enabled) {
            this.mBlurInput.copyFrom(bitmap);
            this.mBlurScript.setInput(this.mBlurInput);
            this.mBlurScript.forEach(this.mBlurOutput);
            this.mBlurOutput.copyTo(bitmap2);
        }
    }

    @TargetApi(17)
    public boolean drawBlur() {
        if (enabled && prepare()) {
            blur(this.mBitmapToBlur, this.mBlurredBitmap);
            Canvas canvas = new Canvas(this.mBlurredBitmap);
            Rect rect = new Rect(0, 0, this.mBlurredBitmap.getWidth(), this.mBlurredBitmap.getHeight());
            Paint paint = new Paint();
            paint.setColor(Color.parseColor("#4C000000"));
            canvas.drawRect(rect, paint);
            canvas.scale(0.0625f, 0.0625f);
        }
        return enabled;
    }

    public Bitmap getBlurredBitmap() {
        return this.mBlurredBitmap;
    }

    @TargetApi(17)
    public void init(int i, int i2, Bitmap bitmap) {
        if (enabled && i > 0 && i2 > 0 && bitmap != null) {
            try {
                this.mBlurScript.setRadius(i);
                Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                Matrix matrix = new Matrix();
                float f2 = 1.0f / i2;
                matrix.postScale(f2, f2);
                this.mBitmapToBlur = Bitmap.createBitmap(copy, 0, 0, copy.getWidth(), copy.getHeight(), matrix, true);
            } catch (Exception unused) {
            }
        }
    }

    @TargetApi(17)
    public void onDestroy() {
        if (enabled) {
            RenderScript renderScript = this.mRenderScript;
            if (renderScript != null) {
                renderScript.destroy();
            }
            Bitmap bitmap = this.mBitmapToBlur;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.mBitmapToBlur.recycle();
                this.mBitmapToBlur = null;
            }
            Bitmap bitmap2 = this.mBlurredBitmap;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                return;
            }
            this.mBlurredBitmap.recycle();
            this.mBlurredBitmap = null;
        }
    }

    public boolean prepare() {
        Bitmap bitmap = this.mBitmapToBlur;
        if (bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        this.mBlurredBitmap = Bitmap.createBitmap(this.mBitmapToBlur.getWidth(), this.mBitmapToBlur.getHeight(), Bitmap.Config.ARGB_8888);
        Allocation createFromBitmap = Allocation.createFromBitmap(this.mRenderScript, this.mBitmapToBlur, Allocation.MipmapControl.MIPMAP_NONE, 1);
        this.mBlurInput = createFromBitmap;
        this.mBlurOutput = Allocation.createTyped(this.mRenderScript, createFromBitmap.getType());
        return true;
    }
}
