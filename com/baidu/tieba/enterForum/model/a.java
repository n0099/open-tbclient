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
    private static a dhw;
    private WindowManager.LayoutParams dht;
    private ImageView dhu;
    private boolean dhv;
    private boolean mHasInited;
    private int mHeight;
    private int mStatusBarHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a auj() {
        if (dhw == null) {
            synchronized (a.class) {
                if (dhw == null) {
                    dhw = new a();
                }
            }
        }
        return dhw;
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
        dhw = null;
    }

    public boolean isDragging() {
        return this.dhv;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.dhv = true;
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

    public void aE(int i, int i2) {
        auk();
        aF(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.dhu, this.dht);
        }
    }

    private void auk() {
        if (!this.mHasInited) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        auk();
        if (bitmap != null) {
            aF(i, i2);
            this.dhu = new ImageView(context);
            this.dhu.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && z(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.dhu, this.dht);
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

    private void aul() {
        this.dht = new WindowManager.LayoutParams();
        this.dht.format = -3;
        this.dht.gravity = 51;
        this.dht.alpha = 1.0f;
        this.dht.width = -2;
        this.dht.height = -2;
        this.dht.flags = 24;
    }

    private void aF(int i, int i2) {
        if (this.dht == null) {
            aul();
        }
        this.dht.x = i - (this.mWidth / 2);
        this.dht.y = (i2 - (this.mHeight / 2)) - this.mStatusBarHeight;
    }

    public void aum() {
        if (this.dhu != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.dhu);
            }
            this.dhu = null;
        }
        this.dhv = false;
    }
}
