package com.baidu.tieba.enterForum.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes2.dex */
public class a {
    private static a cTp;
    private WindowManager.LayoutParams cTm;
    private ImageView cTn;
    private boolean cTo;
    private boolean cTq;
    private int mHeight;
    private int mStatusBarHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a aoY() {
        if (cTp == null) {
            synchronized (a.class) {
                if (cTp == null) {
                    cTp = new a();
                }
            }
        }
        return cTp;
    }

    private a() {
    }

    public void l(Context context, int i) {
        this.cTq = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.mStatusBarHeight = i;
    }

    public void destroy() {
        this.cTq = false;
        cTp = null;
    }

    public boolean isDragging() {
        return this.cTo;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.cTo = true;
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

    public void ax(int i, int i2) {
        aoZ();
        ay(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.cTn, this.cTm);
        }
    }

    private void aoZ() {
        if (!this.cTq) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        aoZ();
        if (bitmap != null) {
            ay(i, i2);
            this.cTn = new ImageView(context);
            this.cTn.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.cTn, this.cTm);
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

    private void apa() {
        this.cTm = new WindowManager.LayoutParams();
        this.cTm.format = -3;
        this.cTm.gravity = 51;
        this.cTm.alpha = 1.0f;
        this.cTm.width = -2;
        this.cTm.height = -2;
        this.cTm.flags = 24;
    }

    private void ay(int i, int i2) {
        if (this.cTm == null) {
            apa();
        }
        this.cTm.x = i - (this.mWidth / 2);
        this.cTm.y = (i2 - (this.mHeight / 2)) - this.mStatusBarHeight;
    }

    public void apb() {
        if (this.cTn != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.cTn);
            }
            this.cTn = null;
        }
        this.cTo = false;
    }
}
