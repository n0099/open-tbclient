package com.baidu.tieba.enterForum.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class a {
    private static a bvZ;
    private WindowManager bC;
    private WindowManager.LayoutParams bvW;
    private ImageView bvX;
    private boolean bvY;
    private int bwa;
    private boolean bwb;
    private int mHeight;
    private int mWidth;

    public static a SS() {
        if (bvZ == null) {
            synchronized (a.class) {
                if (bvZ == null) {
                    bvZ = new a();
                }
            }
        }
        return bvZ;
    }

    private a() {
    }

    public void i(Context context, int i) {
        this.bwb = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.bC = (WindowManager) context.getSystemService("window");
        this.bwa = i;
    }

    public void destroy() {
        this.bwb = false;
        bvZ = null;
    }

    public boolean ST() {
        return this.bvY;
    }

    public void a(Context context, View view, int i, int i2) {
        if (view != null) {
            this.bvY = true;
            view.setPressed(false);
            view.setDrawingCacheEnabled(true);
            Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
            this.mWidth = createBitmap.getWidth();
            this.mHeight = createBitmap.getHeight();
            a(context, createBitmap, i, i2);
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
        }
    }

    public void W(int i, int i2) {
        SU();
        X(i, i2);
        this.bC.updateViewLayout(this.bvX, this.bvW);
    }

    private void SU() {
        if (!this.bwb) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        SU();
        if (bitmap != null) {
            X(i, i2);
            this.bvX = new ImageView(context);
            this.bvX.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        this.bC.addView(this.bvX, this.bvW);
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

    private boolean p(View view) {
        IBinder windowToken;
        if (view != null && (windowToken = view.getWindowToken()) != null) {
            try {
                if (windowToken.isBinderAlive()) {
                    if (windowToken.pingBinder()) {
                        return true;
                    }
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    private void SV() {
        this.bvW = new WindowManager.LayoutParams();
        this.bvW.format = -3;
        this.bvW.gravity = 51;
        this.bvW.alpha = 1.0f;
        this.bvW.width = -2;
        this.bvW.height = -2;
        this.bvW.flags = 24;
    }

    private void X(int i, int i2) {
        if (this.bvW == null) {
            SV();
        }
        this.bvW.x = i - (this.mWidth / 2);
        this.bvW.y = (i2 - (this.mHeight / 2)) - this.bwa;
    }

    public void SW() {
        if (this.bvX != null) {
            if (this.bC != null) {
                this.bC.removeView(this.bvX);
            }
            this.bvX = null;
        }
        this.bvY = false;
    }
}
