package com.baidu.tieba.enterForum.c;

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
    private static a aXQ;
    private WindowManager.LayoutParams aXN;
    private ImageView aXO;
    private boolean aXP;
    private int aXR;
    private boolean aXS;
    private WindowManager bC;
    private int mHeight;
    private int mWidth;

    public static a MI() {
        if (aXQ == null) {
            synchronized (a.class) {
                if (aXQ == null) {
                    aXQ = new a();
                }
            }
        }
        return aXQ;
    }

    private a() {
    }

    public void i(Context context, int i) {
        this.aXS = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.bC = (WindowManager) context.getSystemService("window");
        this.aXR = i;
    }

    public void destroy() {
        this.aXS = false;
        aXQ = null;
    }

    public boolean MJ() {
        return this.aXP;
    }

    public void a(Context context, View view, int i, int i2) {
        if (view != null) {
            this.aXP = true;
            view.setPressed(false);
            view.setDrawingCacheEnabled(true);
            Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
            this.mWidth = createBitmap.getWidth();
            this.mHeight = createBitmap.getHeight();
            a(context, createBitmap, i, i2);
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
        }
    }

    public void R(int i, int i2) {
        MK();
        S(i, i2);
        this.bC.updateViewLayout(this.aXO, this.aXN);
    }

    private void MK() {
        if (!this.aXS) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        MK();
        if (bitmap != null) {
            S(i, i2);
            this.aXO = new ImageView(context);
            this.aXO.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        this.bC.addView(this.aXO, this.aXN);
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

    private void ML() {
        this.aXN = new WindowManager.LayoutParams();
        this.aXN.format = -3;
        this.aXN.gravity = 51;
        this.aXN.alpha = 1.0f;
        this.aXN.width = -2;
        this.aXN.height = -2;
        this.aXN.flags = 24;
    }

    private void S(int i, int i2) {
        if (this.aXN == null) {
            ML();
        }
        this.aXN.x = i - (this.mWidth / 2);
        this.aXN.y = (i2 - (this.mHeight / 2)) - this.aXR;
    }

    public void MM() {
        if (this.aXO != null) {
            if (this.bC != null) {
                this.bC.removeView(this.aXO);
            }
            this.aXO = null;
        }
        this.aXP = false;
    }
}
