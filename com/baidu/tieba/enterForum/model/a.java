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
    private static a dpQ;
    private WindowManager.LayoutParams dpN;
    private ImageView dpO;
    private boolean dpP;
    private int dpR;
    private boolean dpS;
    private int mHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a aqI() {
        if (dpQ == null) {
            synchronized (a.class) {
                if (dpQ == null) {
                    dpQ = new a();
                }
            }
        }
        return dpQ;
    }

    private a() {
    }

    public void z(Context context, int i) {
        this.dpS = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.dpR = i;
    }

    public void destroy() {
        this.dpS = false;
        dpQ = null;
    }

    public boolean aqJ() {
        return this.dpP;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.dpP = true;
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
        aqK();
        br(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.dpO, this.dpN);
        }
    }

    private void aqK() {
        if (!this.dpS) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        aqK();
        if (bitmap != null) {
            br(i, i2);
            this.dpO = new ImageView(context);
            this.dpO.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && aH(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.dpO, this.dpN);
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

    private void aqL() {
        this.dpN = new WindowManager.LayoutParams();
        this.dpN.format = -3;
        this.dpN.gravity = 51;
        this.dpN.alpha = 1.0f;
        this.dpN.width = -2;
        this.dpN.height = -2;
        this.dpN.flags = 24;
    }

    private void br(int i, int i2) {
        if (this.dpN == null) {
            aqL();
        }
        this.dpN.x = i - (this.mWidth / 2);
        this.dpN.y = (i2 - (this.mHeight / 2)) - this.dpR;
    }

    public void aqM() {
        if (this.dpO != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.dpO);
            }
            this.dpO = null;
        }
        this.dpP = false;
    }
}
