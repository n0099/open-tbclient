package com.baidu.tieba.enterForum.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
/* loaded from: classes4.dex */
public class a {
    private static a dsD;
    private WindowManager.LayoutParams dsA;
    private ImageView dsB;
    private boolean dsC;
    private boolean mHasInited;
    private int mHeight;
    private int mStatusBarHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a awF() {
        if (dsD == null) {
            synchronized (a.class) {
                if (dsD == null) {
                    dsD = new a();
                }
            }
        }
        return dsD;
    }

    private a() {
    }

    public void o(Context context, int i) {
        this.mHasInited = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService(WindowConfig.JSON_WINDOW_KEY);
        this.mStatusBarHeight = i;
    }

    public void destroy() {
        this.mHasInited = false;
        dsD = null;
    }

    public boolean isDragging() {
        return this.dsC;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.dsC = true;
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

    public void aH(int i, int i2) {
        awG();
        aI(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.dsB, this.dsA);
        }
    }

    private void awG() {
        if (!this.mHasInited) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        awG();
        if (bitmap != null) {
            aI(i, i2);
            this.dsB = new ImageView(context);
            this.dsB.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && z(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.dsB, this.dsA);
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

    private boolean z(View view) {
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

    private void awH() {
        this.dsA = new WindowManager.LayoutParams();
        this.dsA.format = -3;
        this.dsA.gravity = 51;
        this.dsA.alpha = 1.0f;
        this.dsA.width = -2;
        this.dsA.height = -2;
        this.dsA.flags = 24;
    }

    private void aI(int i, int i2) {
        if (this.dsA == null) {
            awH();
        }
        this.dsA.x = i - (this.mWidth / 2);
        this.dsA.y = (i2 - (this.mHeight / 2)) - this.mStatusBarHeight;
    }

    public void awI() {
        if (this.dsB != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.dsB);
            }
            this.dsB = null;
        }
        this.dsC = false;
    }
}
