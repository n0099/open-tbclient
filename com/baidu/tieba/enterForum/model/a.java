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
    private static a dsE;
    private WindowManager.LayoutParams dsB;
    private ImageView dsC;
    private boolean dsD;
    private boolean mHasInited;
    private int mHeight;
    private int mStatusBarHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a awF() {
        if (dsE == null) {
            synchronized (a.class) {
                if (dsE == null) {
                    dsE = new a();
                }
            }
        }
        return dsE;
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
        dsE = null;
    }

    public boolean isDragging() {
        return this.dsD;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.dsD = true;
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
            this.mWindowManager.updateViewLayout(this.dsC, this.dsB);
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
            this.dsC = new ImageView(context);
            this.dsC.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && z(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.dsC, this.dsB);
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
        this.dsB = new WindowManager.LayoutParams();
        this.dsB.format = -3;
        this.dsB.gravity = 51;
        this.dsB.alpha = 1.0f;
        this.dsB.width = -2;
        this.dsB.height = -2;
        this.dsB.flags = 24;
    }

    private void aI(int i, int i2) {
        if (this.dsB == null) {
            awH();
        }
        this.dsB.x = i - (this.mWidth / 2);
        this.dsB.y = (i2 - (this.mHeight / 2)) - this.mStatusBarHeight;
    }

    public void awI() {
        if (this.dsC != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.dsC);
            }
            this.dsC = null;
        }
        this.dsD = false;
    }
}
