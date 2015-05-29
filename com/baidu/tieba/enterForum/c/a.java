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
    private static a aFl;
    private WindowManager.LayoutParams aFi;
    private ImageView aFj;
    private boolean aFk;
    private int aFm;
    private boolean aFn;
    private int mHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a HT() {
        if (aFl == null) {
            synchronized (a.class) {
                if (aFl == null) {
                    aFl = new a();
                }
            }
        }
        return aFl;
    }

    private a() {
    }

    public void i(Context context, int i) {
        this.aFn = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.aFm = i;
    }

    public void destroy() {
        this.aFn = false;
        aFl = null;
    }

    public boolean HU() {
        return this.aFk;
    }

    public void a(Context context, View view, int i, int i2) {
        if (view != null) {
            this.aFk = true;
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
        HV();
        J(i, i2);
        this.mWindowManager.updateViewLayout(this.aFj, this.aFi);
    }

    private void HV() {
        if (!this.aFn) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        HV();
        if (bitmap != null) {
            J(i, i2);
            this.aFj = new ImageView(context);
            this.aFj.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && c(activity.getWindow().getDecorView())) {
                    try {
                        this.mWindowManager.addView(this.aFj, this.aFi);
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

    private void HW() {
        this.aFi = new WindowManager.LayoutParams();
        this.aFi.format = -3;
        this.aFi.gravity = 51;
        this.aFi.alpha = 1.0f;
        this.aFi.width = -2;
        this.aFi.height = -2;
        this.aFi.flags = 24;
    }

    private void J(int i, int i2) {
        if (this.aFi == null) {
            HW();
        }
        this.aFi.x = i - (this.mWidth / 2);
        this.aFi.y = (i2 - (this.mHeight / 2)) - this.aFm;
    }

    public void HX() {
        if (this.aFj != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.aFj);
            }
            this.aFj = null;
        }
        this.aFk = false;
    }
}
