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
    private static a bqt;
    private WindowManager bC;
    private WindowManager.LayoutParams bqq;
    private ImageView bqr;
    private boolean bqs;
    private int bqu;
    private boolean bqv;
    private int mHeight;
    private int mWidth;

    public static a Tm() {
        if (bqt == null) {
            synchronized (a.class) {
                if (bqt == null) {
                    bqt = new a();
                }
            }
        }
        return bqt;
    }

    private a() {
    }

    public void j(Context context, int i) {
        this.bqv = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.bC = (WindowManager) context.getSystemService("window");
        this.bqu = i;
    }

    public void destroy() {
        this.bqv = false;
        bqt = null;
    }

    public boolean Tn() {
        return this.bqs;
    }

    public void a(Context context, View view, int i, int i2) {
        if (view != null) {
            this.bqs = true;
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

    public void Y(int i, int i2) {
        To();
        Z(i, i2);
        this.bC.updateViewLayout(this.bqr, this.bqq);
    }

    private void To() {
        if (!this.bqv) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        To();
        if (bitmap != null) {
            Z(i, i2);
            this.bqr = new ImageView(context);
            this.bqr.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        this.bC.addView(this.bqr, this.bqq);
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

    private void Tp() {
        this.bqq = new WindowManager.LayoutParams();
        this.bqq.format = -3;
        this.bqq.gravity = 51;
        this.bqq.alpha = 1.0f;
        this.bqq.width = -2;
        this.bqq.height = -2;
        this.bqq.flags = 24;
    }

    private void Z(int i, int i2) {
        if (this.bqq == null) {
            Tp();
        }
        this.bqq.x = i - (this.mWidth / 2);
        this.bqq.y = (i2 - (this.mHeight / 2)) - this.bqu;
    }

    public void Tq() {
        if (this.bqr != null) {
            if (this.bC != null) {
                this.bC.removeView(this.bqr);
            }
            this.bqr = null;
        }
        this.bqs = false;
    }
}
