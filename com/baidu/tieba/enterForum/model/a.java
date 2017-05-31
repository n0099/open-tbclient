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
    private static a bMV;
    private WindowManager.LayoutParams bMS;
    private ImageView bMT;
    private boolean bMU;
    private int bMW;
    private boolean bMX;
    private WindowManager jn;
    private int mHeight;
    private int mWidth;

    public static a Xv() {
        if (bMV == null) {
            synchronized (a.class) {
                if (bMV == null) {
                    bMV = new a();
                }
            }
        }
        return bMV;
    }

    private a() {
    }

    public void m(Context context, int i) {
        this.bMX = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.jn = (WindowManager) context.getSystemService("window");
        this.bMW = i;
    }

    public void destroy() {
        this.bMX = false;
        bMV = null;
    }

    public boolean Xw() {
        return this.bMU;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.bMU = true;
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

    public void ae(int i, int i2) {
        Xx();
        af(i, i2);
        if (this.jn != null) {
            this.jn.updateViewLayout(this.bMT, this.bMS);
        }
    }

    private void Xx() {
        if (!this.bMX) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        Xx();
        if (bitmap != null) {
            af(i, i2);
            this.bMT = new ImageView(context);
            this.bMT.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        if (this.jn != null) {
                            this.jn.addView(this.bMT, this.bMS);
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

    private void Xy() {
        this.bMS = new WindowManager.LayoutParams();
        this.bMS.format = -3;
        this.bMS.gravity = 51;
        this.bMS.alpha = 1.0f;
        this.bMS.width = -2;
        this.bMS.height = -2;
        this.bMS.flags = 24;
    }

    private void af(int i, int i2) {
        if (this.bMS == null) {
            Xy();
        }
        this.bMS.x = i - (this.mWidth / 2);
        this.bMS.y = (i2 - (this.mHeight / 2)) - this.bMW;
    }

    public void Xz() {
        if (this.bMT != null) {
            if (this.jn != null) {
                this.jn.removeView(this.bMT);
            }
            this.bMT = null;
        }
        this.bMU = false;
    }
}
