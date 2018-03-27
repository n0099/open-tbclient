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
    private static a dpT;
    private WindowManager.LayoutParams dpQ;
    private ImageView dpR;
    private boolean dpS;
    private int dpU;
    private boolean dpV;
    private int mHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a aqJ() {
        if (dpT == null) {
            synchronized (a.class) {
                if (dpT == null) {
                    dpT = new a();
                }
            }
        }
        return dpT;
    }

    private a() {
    }

    public void z(Context context, int i) {
        this.dpV = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.dpU = i;
    }

    public void destroy() {
        this.dpV = false;
        dpT = null;
    }

    public boolean aqK() {
        return this.dpS;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.dpS = true;
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

    public void bq(int i, int i2) {
        aqL();
        br(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.dpR, this.dpQ);
        }
    }

    private void aqL() {
        if (!this.dpV) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        aqL();
        if (bitmap != null) {
            br(i, i2);
            this.dpR = new ImageView(context);
            this.dpR.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && aH(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.dpR, this.dpQ);
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

    private boolean aH(View view) {
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

    private void aqM() {
        this.dpQ = new WindowManager.LayoutParams();
        this.dpQ.format = -3;
        this.dpQ.gravity = 51;
        this.dpQ.alpha = 1.0f;
        this.dpQ.width = -2;
        this.dpQ.height = -2;
        this.dpQ.flags = 24;
    }

    private void br(int i, int i2) {
        if (this.dpQ == null) {
            aqM();
        }
        this.dpQ.x = i - (this.mWidth / 2);
        this.dpQ.y = (i2 - (this.mHeight / 2)) - this.dpU;
    }

    public void aqN() {
        if (this.dpR != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.dpR);
            }
            this.dpR = null;
        }
        this.dpS = false;
    }
}
