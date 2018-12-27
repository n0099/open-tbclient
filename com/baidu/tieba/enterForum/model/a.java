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
    private static a drU;
    private WindowManager.LayoutParams drR;
    private ImageView drS;
    private boolean drT;
    private boolean mHasInited;
    private int mHeight;
    private int mStatusBarHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a awi() {
        if (drU == null) {
            synchronized (a.class) {
                if (drU == null) {
                    drU = new a();
                }
            }
        }
        return drU;
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
        drU = null;
    }

    public boolean isDragging() {
        return this.drT;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.drT = true;
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
        awj();
        aI(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.drS, this.drR);
        }
    }

    private void awj() {
        if (!this.mHasInited) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        awj();
        if (bitmap != null) {
            aI(i, i2);
            this.drS = new ImageView(context);
            this.drS.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && z(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.drS, this.drR);
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

    private void awk() {
        this.drR = new WindowManager.LayoutParams();
        this.drR.format = -3;
        this.drR.gravity = 51;
        this.drR.alpha = 1.0f;
        this.drR.width = -2;
        this.drR.height = -2;
        this.drR.flags = 24;
    }

    private void aI(int i, int i2) {
        if (this.drR == null) {
            awk();
        }
        this.drR.x = i - (this.mWidth / 2);
        this.drR.y = (i2 - (this.mHeight / 2)) - this.mStatusBarHeight;
    }

    public void awl() {
        if (this.drS != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.drS);
            }
            this.drS = null;
        }
        this.drT = false;
    }
}
