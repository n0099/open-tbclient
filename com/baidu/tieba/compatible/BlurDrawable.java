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
/* loaded from: classes12.dex */
public class BlurDrawable {
    private static boolean enabled;
    public Bitmap mBitmapToBlur;
    private Allocation mBlurInput;
    private Allocation mBlurOutput;
    private ScriptIntrinsicBlur mBlurScript;
    public Bitmap mBlurredBitmap;
    private RenderScript mRenderScript;

    static {
        enabled = Build.VERSION.SDK_INT >= 17;
    }

    public BlurDrawable(Context context) {
        if (context != null) {
            initializeRenderScript(context);
        }
    }

    @TargetApi(17)
    public void init(int i, int i2, Bitmap bitmap) {
        if (enabled && i > 0 && i2 > 0 && bitmap != null) {
            try {
                this.mBlurScript.setRadius(i);
                Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                Matrix matrix = new Matrix();
                matrix.postScale(1.0f / i2, 1.0f / i2);
                this.mBitmapToBlur = Bitmap.createBitmap(copy, 0, 0, copy.getWidth(), copy.getHeight(), matrix, true);
            } catch (Exception e) {
            }
        }
    }

    public Bitmap getBlurredBitmap() {
        return this.mBlurredBitmap;
    }

    @TargetApi(17)
    private void initializeRenderScript(Context context) {
        try {
            if (enabled) {
                this.mRenderScript = RenderScript.create(context);
                this.mBlurScript = ScriptIntrinsicBlur.create(this.mRenderScript, Element.U8_4(this.mRenderScript));
            }
        } catch (Exception e) {
            e.printStackTrace();
            enabled = false;
        }
    }

    protected boolean prepare() {
        if (this.mBitmapToBlur == null || this.mBitmapToBlur.isRecycled()) {
            return false;
        }
        this.mBlurredBitmap = Bitmap.createBitmap(this.mBitmapToBlur.getWidth(), this.mBitmapToBlur.getHeight(), Bitmap.Config.ARGB_8888);
        this.mBlurInput = Allocation.createFromBitmap(this.mRenderScript, this.mBitmapToBlur, Allocation.MipmapControl.MIPMAP_NONE, 1);
        this.mBlurOutput = Allocation.createTyped(this.mRenderScript, this.mBlurInput.getType());
        return true;
    }

    @TargetApi(17)
    protected void blur(Bitmap bitmap, Bitmap bitmap2) {
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

    @TargetApi(17)
    public void onDestroy() {
        if (enabled) {
            if (this.mRenderScript != null) {
                this.mRenderScript.destroy();
            }
            if (this.mBitmapToBlur != null && !this.mBitmapToBlur.isRecycled()) {
                this.mBitmapToBlur.recycle();
                this.mBitmapToBlur = null;
            }
            if (this.mBlurredBitmap != null && !this.mBlurredBitmap.isRecycled()) {
                this.mBlurredBitmap.recycle();
                this.mBlurredBitmap = null;
            }
        }
    }
}
