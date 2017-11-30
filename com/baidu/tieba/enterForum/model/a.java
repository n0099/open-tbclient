package com.baidu.tieba.enterForum.model;

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
    private static a ctC;
    private ImageView ctA;
    private boolean ctB;
    private int ctD;
    private boolean ctE;
    private WindowManager.LayoutParams ctz;
    private int mHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a ahd() {
        if (ctC == null) {
            synchronized (a.class) {
                if (ctC == null) {
                    ctC = new a();
                }
            }
        }
        return ctC;
    }

    private a() {
    }

    public void l(Context context, int i) {
        this.ctE = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.ctD = i;
    }

    public void destroy() {
        this.ctE = false;
        ctC = null;
    }

    public boolean ahe() {
        return this.ctB;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.ctB = true;
            view.setPressed(true);
            view.setDrawingCacheEnabled(true);
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null && (createBitmap = Bitmap.createBitmap(drawingCache)) != null) {
                this.mWidth = createBitmap.getWidth();
                this.mHeight = createBitmap.getHeight();
                a(context, createBitmap, i, i2);
                view.destroyDrawingCache();
                view.setDrawingCacheEnabled(false);
            }
        }
    }

    public void as(int i, int i2) {
        ahf();
        at(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.ctA, this.ctz);
        }
    }

    private void ahf() {
        if (!this.ctE) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        ahf();
        if (bitmap != null) {
            at(i, i2);
            this.ctA = new ImageView(context);
            this.ctA.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.ctA, this.ctz);
                        }
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

    private void ahg() {
        this.ctz = new WindowManager.LayoutParams();
        this.ctz.format = -3;
        this.ctz.gravity = 51;
        this.ctz.alpha = 1.0f;
        this.ctz.width = -2;
        this.ctz.height = -2;
        this.ctz.flags = 24;
    }

    private void at(int i, int i2) {
        if (this.ctz == null) {
            ahg();
        }
        this.ctz.x = i - (this.mWidth / 2);
        this.ctz.y = (i2 - (this.mHeight / 2)) - this.ctD;
    }

    public void ahh() {
        if (this.ctA != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.ctA);
            }
            this.ctA = null;
        }
        this.ctB = false;
    }
}
