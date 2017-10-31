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
    private static a ckD;
    private WindowManager.LayoutParams ckA;
    private ImageView ckB;
    private boolean ckC;
    private int ckE;
    private boolean ckF;
    private int mHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a afd() {
        if (ckD == null) {
            synchronized (a.class) {
                if (ckD == null) {
                    ckD = new a();
                }
            }
        }
        return ckD;
    }

    private a() {
    }

    public void l(Context context, int i) {
        this.ckF = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.ckE = i;
    }

    public void destroy() {
        this.ckF = false;
        ckD = null;
    }

    public boolean afe() {
        return this.ckC;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.ckC = true;
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

    public void at(int i, int i2) {
        aff();
        au(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.ckB, this.ckA);
        }
    }

    private void aff() {
        if (!this.ckF) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        aff();
        if (bitmap != null) {
            au(i, i2);
            this.ckB = new ImageView(context);
            this.ckB.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.ckB, this.ckA);
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

    private void afg() {
        this.ckA = new WindowManager.LayoutParams();
        this.ckA.format = -3;
        this.ckA.gravity = 51;
        this.ckA.alpha = 1.0f;
        this.ckA.width = -2;
        this.ckA.height = -2;
        this.ckA.flags = 24;
    }

    private void au(int i, int i2) {
        if (this.ckA == null) {
            afg();
        }
        this.ckA.x = i - (this.mWidth / 2);
        this.ckA.y = (i2 - (this.mHeight / 2)) - this.ckE;
    }

    public void afh() {
        if (this.ckB != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.ckB);
            }
            this.ckB = null;
        }
        this.ckC = false;
    }
}
