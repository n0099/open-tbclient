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
    private static a dpe;
    private WindowManager.LayoutParams dpb;
    private ImageView dpc;
    private boolean dpd;
    private boolean mHasInited;
    private int mHeight;
    private int mStatusBarHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a avt() {
        if (dpe == null) {
            synchronized (a.class) {
                if (dpe == null) {
                    dpe = new a();
                }
            }
        }
        return dpe;
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
        dpe = null;
    }

    public boolean isDragging() {
        return this.dpd;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.dpd = true;
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
        avu();
        aH(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.dpc, this.dpb);
        }
    }

    private void avu() {
        if (!this.mHasInited) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        avu();
        if (bitmap != null) {
            aH(i, i2);
            this.dpc = new ImageView(context);
            this.dpc.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && z(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.dpc, this.dpb);
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

    private void avv() {
        this.dpb = new WindowManager.LayoutParams();
        this.dpb.format = -3;
        this.dpb.gravity = 51;
        this.dpb.alpha = 1.0f;
        this.dpb.width = -2;
        this.dpb.height = -2;
        this.dpb.flags = 24;
    }

    private void aH(int i, int i2) {
        if (this.dpb == null) {
            avv();
        }
        this.dpb.x = i - (this.mWidth / 2);
        this.dpb.y = (i2 - (this.mHeight / 2)) - this.mStatusBarHeight;
    }

    public void avw() {
        if (this.dpc != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.dpc);
            }
            this.dpc = null;
        }
        this.dpd = false;
    }
}
