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
    private static a cZg;
    private WindowManager.LayoutParams cZd;
    private ImageView cZe;
    private boolean cZf;
    private boolean cZh;
    private int mHeight;
    private int mStatusBarHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a aqN() {
        if (cZg == null) {
            synchronized (a.class) {
                if (cZg == null) {
                    cZg = new a();
                }
            }
        }
        return cZg;
    }

    private a() {
    }

    public void n(Context context, int i) {
        this.cZh = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.mStatusBarHeight = i;
    }

    public void destroy() {
        this.cZh = false;
        cZg = null;
    }

    public boolean isDragging() {
        return this.cZf;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.cZf = true;
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

    public void aB(int i, int i2) {
        aqO();
        aC(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.cZe, this.cZd);
        }
    }

    private void aqO() {
        if (!this.cZh) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        aqO();
        if (bitmap != null) {
            aC(i, i2);
            this.cZe = new ImageView(context);
            this.cZe.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && z(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.cZe, this.cZd);
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

    private void aqP() {
        this.cZd = new WindowManager.LayoutParams();
        this.cZd.format = -3;
        this.cZd.gravity = 51;
        this.cZd.alpha = 1.0f;
        this.cZd.width = -2;
        this.cZd.height = -2;
        this.cZd.flags = 24;
    }

    private void aC(int i, int i2) {
        if (this.cZd == null) {
            aqP();
        }
        this.cZd.x = i - (this.mWidth / 2);
        this.cZd.y = (i2 - (this.mHeight / 2)) - this.mStatusBarHeight;
    }

    public void aqQ() {
        if (this.cZe != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.cZe);
            }
            this.cZe = null;
        }
        this.cZf = false;
    }
}
