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
    private static a bKp;
    private WindowManager bC;
    private WindowManager.LayoutParams bKm;
    private ImageView bKn;
    private boolean bKo;
    private int bKq;
    private boolean bKr;
    private int mHeight;
    private int mWidth;

    public static a YZ() {
        if (bKp == null) {
            synchronized (a.class) {
                if (bKp == null) {
                    bKp = new a();
                }
            }
        }
        return bKp;
    }

    private a() {
    }

    public void j(Context context, int i) {
        this.bKr = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.bC = (WindowManager) context.getSystemService("window");
        this.bKq = i;
    }

    public void destroy() {
        this.bKr = false;
        bKp = null;
    }

    public boolean Za() {
        return this.bKo;
    }

    public void a(Context context, View view, int i, int i2) {
        if (view != null) {
            this.bKo = true;
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

    public void ad(int i, int i2) {
        Zb();
        ae(i, i2);
        this.bC.updateViewLayout(this.bKn, this.bKm);
    }

    private void Zb() {
        if (!this.bKr) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        Zb();
        if (bitmap != null) {
            ae(i, i2);
            this.bKn = new ImageView(context);
            this.bKn.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        this.bC.addView(this.bKn, this.bKm);
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

    private void Zc() {
        this.bKm = new WindowManager.LayoutParams();
        this.bKm.format = -3;
        this.bKm.gravity = 51;
        this.bKm.alpha = 1.0f;
        this.bKm.width = -2;
        this.bKm.height = -2;
        this.bKm.flags = 24;
    }

    private void ae(int i, int i2) {
        if (this.bKm == null) {
            Zc();
        }
        this.bKm.x = i - (this.mWidth / 2);
        this.bKm.y = (i2 - (this.mHeight / 2)) - this.bKq;
    }

    public void Zd() {
        if (this.bKn != null) {
            if (this.bC != null) {
                this.bC.removeView(this.bKn);
            }
            this.bKn = null;
        }
        this.bKo = false;
    }
}
