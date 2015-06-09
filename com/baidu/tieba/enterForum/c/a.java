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
    private static a aFm;
    private WindowManager.LayoutParams aFj;
    private ImageView aFk;
    private boolean aFl;
    private int aFn;
    private boolean aFo;
    private int mHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a HU() {
        if (aFm == null) {
            synchronized (a.class) {
                if (aFm == null) {
                    aFm = new a();
                }
            }
        }
        return aFm;
    }

    private a() {
    }

    public void i(Context context, int i) {
        this.aFo = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.aFn = i;
    }

    public void destroy() {
        this.aFo = false;
        aFm = null;
    }

    public boolean HV() {
        return this.aFl;
    }

    public void a(Context context, View view, int i, int i2) {
        if (view != null) {
            this.aFl = true;
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

    public void I(int i, int i2) {
        HW();
        J(i, i2);
        this.mWindowManager.updateViewLayout(this.aFk, this.aFj);
    }

    private void HW() {
        if (!this.aFo) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        HW();
        if (bitmap != null) {
            J(i, i2);
            this.aFk = new ImageView(context);
            this.aFk.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && c(activity.getWindow().getDecorView())) {
                    try {
                        this.mWindowManager.addView(this.aFk, this.aFj);
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

    private boolean c(View view) {
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

    private void HX() {
        this.aFj = new WindowManager.LayoutParams();
        this.aFj.format = -3;
        this.aFj.gravity = 51;
        this.aFj.alpha = 1.0f;
        this.aFj.width = -2;
        this.aFj.height = -2;
        this.aFj.flags = 24;
    }

    private void J(int i, int i2) {
        if (this.aFj == null) {
            HX();
        }
        this.aFj.x = i - (this.mWidth / 2);
        this.aFj.y = (i2 - (this.mHeight / 2)) - this.aFn;
    }

    public void HY() {
        if (this.aFk != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.aFk);
            }
            this.aFk = null;
        }
        this.aFl = false;
    }
}
