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
    private static a diB;
    private boolean diA;
    private WindowManager.LayoutParams diy;
    private ImageView diz;
    private boolean mHasInited;
    private int mHeight;
    private int mStatusBarHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a atI() {
        if (diB == null) {
            synchronized (a.class) {
                if (diB == null) {
                    diB = new a();
                }
            }
        }
        return diB;
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
        diB = null;
    }

    public boolean isDragging() {
        return this.diA;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.diA = true;
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

    public void aG(int i, int i2) {
        atJ();
        aH(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.diz, this.diy);
        }
    }

    private void atJ() {
        if (!this.mHasInited) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        atJ();
        if (bitmap != null) {
            aH(i, i2);
            this.diz = new ImageView(context);
            this.diz.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && z(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.diz, this.diy);
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

    private void atK() {
        this.diy = new WindowManager.LayoutParams();
        this.diy.format = -3;
        this.diy.gravity = 51;
        this.diy.alpha = 1.0f;
        this.diy.width = -2;
        this.diy.height = -2;
        this.diy.flags = 24;
    }

    private void aH(int i, int i2) {
        if (this.diy == null) {
            atK();
        }
        this.diy.x = i - (this.mWidth / 2);
        this.diy.y = (i2 - (this.mHeight / 2)) - this.mStatusBarHeight;
    }

    public void atL() {
        if (this.diz != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.diz);
            }
            this.diz = null;
        }
        this.diA = false;
    }
}
