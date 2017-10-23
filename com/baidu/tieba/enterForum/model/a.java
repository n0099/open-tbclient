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
    private static a cdi;
    private WindowManager.LayoutParams cdf;
    private ImageView cdg;
    private boolean cdh;
    private int cdj;
    private boolean cdk;
    private int mHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a acV() {
        if (cdi == null) {
            synchronized (a.class) {
                if (cdi == null) {
                    cdi = new a();
                }
            }
        }
        return cdi;
    }

    private a() {
    }

    public void l(Context context, int i) {
        this.cdk = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.cdj = i;
    }

    public void destroy() {
        this.cdk = false;
        cdi = null;
    }

    public boolean acW() {
        return this.cdh;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.cdh = true;
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

    public void as(int i, int i2) {
        acX();
        at(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.cdg, this.cdf);
        }
    }

    private void acX() {
        if (!this.cdk) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        acX();
        if (bitmap != null) {
            at(i, i2);
            this.cdg = new ImageView(context);
            this.cdg.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.cdg, this.cdf);
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

    private void acY() {
        this.cdf = new WindowManager.LayoutParams();
        this.cdf.format = -3;
        this.cdf.gravity = 51;
        this.cdf.alpha = 1.0f;
        this.cdf.width = -2;
        this.cdf.height = -2;
        this.cdf.flags = 24;
    }

    private void at(int i, int i2) {
        if (this.cdf == null) {
            acY();
        }
        this.cdf.x = i - (this.mWidth / 2);
        this.cdf.y = (i2 - (this.mHeight / 2)) - this.cdj;
    }

    public void acZ() {
        if (this.cdg != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.cdg);
            }
            this.cdg = null;
        }
        this.cdh = false;
    }
}
