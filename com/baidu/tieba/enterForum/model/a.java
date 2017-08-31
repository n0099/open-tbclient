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
    private static a ccB;
    private boolean ccA;
    private int ccC;
    private boolean ccD;
    private WindowManager.LayoutParams ccy;
    private ImageView ccz;
    private int mHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a adb() {
        if (ccB == null) {
            synchronized (a.class) {
                if (ccB == null) {
                    ccB = new a();
                }
            }
        }
        return ccB;
    }

    private a() {
    }

    public void o(Context context, int i) {
        this.ccD = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.ccC = i;
    }

    public void destroy() {
        this.ccD = false;
        ccB = null;
    }

    public boolean adc() {
        return this.ccA;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.ccA = true;
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

    public void aj(int i, int i2) {
        add();
        ak(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.ccz, this.ccy);
        }
    }

    private void add() {
        if (!this.ccD) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        add();
        if (bitmap != null) {
            ak(i, i2);
            this.ccz = new ImageView(context);
            this.ccz.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.ccz, this.ccy);
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

    private void ade() {
        this.ccy = new WindowManager.LayoutParams();
        this.ccy.format = -3;
        this.ccy.gravity = 51;
        this.ccy.alpha = 1.0f;
        this.ccy.width = -2;
        this.ccy.height = -2;
        this.ccy.flags = 24;
    }

    private void ak(int i, int i2) {
        if (this.ccy == null) {
            ade();
        }
        this.ccy.x = i - (this.mWidth / 2);
        this.ccy.y = (i2 - (this.mHeight / 2)) - this.ccC;
    }

    public void adf() {
        if (this.ccz != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.ccz);
            }
            this.ccz = null;
        }
        this.ccA = false;
    }
}
