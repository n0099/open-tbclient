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
    private static a aQV;
    private WindowManager.LayoutParams aQS;
    private ImageView aQT;
    private boolean aQU;
    private int aQW;
    private boolean aQX;
    private WindowManager lB;
    private int mHeight;
    private int mWidth;

    public static a JV() {
        if (aQV == null) {
            synchronized (a.class) {
                if (aQV == null) {
                    aQV = new a();
                }
            }
        }
        return aQV;
    }

    private a() {
    }

    public void j(Context context, int i) {
        this.aQX = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.lB = (WindowManager) context.getSystemService("window");
        this.aQW = i;
    }

    public void destroy() {
        this.aQX = false;
        aQV = null;
    }

    public boolean JW() {
        return this.aQU;
    }

    public void a(Context context, View view, int i, int i2) {
        if (view != null) {
            this.aQU = true;
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

    public void T(int i, int i2) {
        JX();
        U(i, i2);
        this.lB.updateViewLayout(this.aQT, this.aQS);
    }

    private void JX() {
        if (!this.aQX) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        JX();
        if (bitmap != null) {
            U(i, i2);
            this.aQT = new ImageView(context);
            this.aQT.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && d(activity.getWindow().getDecorView())) {
                    try {
                        this.lB.addView(this.aQT, this.aQS);
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

    private boolean d(View view) {
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

    private void JY() {
        this.aQS = new WindowManager.LayoutParams();
        this.aQS.format = -3;
        this.aQS.gravity = 51;
        this.aQS.alpha = 1.0f;
        this.aQS.width = -2;
        this.aQS.height = -2;
        this.aQS.flags = 24;
    }

    private void U(int i, int i2) {
        if (this.aQS == null) {
            JY();
        }
        this.aQS.x = i - (this.mWidth / 2);
        this.aQS.y = (i2 - (this.mHeight / 2)) - this.aQW;
    }

    public void JZ() {
        if (this.aQT != null) {
            if (this.lB != null) {
                this.lB.removeView(this.aQT);
            }
            this.aQT = null;
        }
        this.aQU = false;
    }
}
