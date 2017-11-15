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
    private static a ckW;
    private WindowManager.LayoutParams ckT;
    private ImageView ckU;
    private boolean ckV;
    private int ckX;
    private boolean ckY;
    private int mHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a afr() {
        if (ckW == null) {
            synchronized (a.class) {
                if (ckW == null) {
                    ckW = new a();
                }
            }
        }
        return ckW;
    }

    private a() {
    }

    public void l(Context context, int i) {
        this.ckY = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.ckX = i;
    }

    public void destroy() {
        this.ckY = false;
        ckW = null;
    }

    public boolean afs() {
        return this.ckV;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.ckV = true;
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
        aft();
        au(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.ckU, this.ckT);
        }
    }

    private void aft() {
        if (!this.ckY) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        aft();
        if (bitmap != null) {
            au(i, i2);
            this.ckU = new ImageView(context);
            this.ckU.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.ckU, this.ckT);
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

    private void afu() {
        this.ckT = new WindowManager.LayoutParams();
        this.ckT.format = -3;
        this.ckT.gravity = 51;
        this.ckT.alpha = 1.0f;
        this.ckT.width = -2;
        this.ckT.height = -2;
        this.ckT.flags = 24;
    }

    private void au(int i, int i2) {
        if (this.ckT == null) {
            afu();
        }
        this.ckT.x = i - (this.mWidth / 2);
        this.ckT.y = (i2 - (this.mHeight / 2)) - this.ckX;
    }

    public void afv() {
        if (this.ckU != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.ckU);
            }
            this.ckU = null;
        }
        this.ckV = false;
    }
}
