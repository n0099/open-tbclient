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
    private static a bHw;
    private WindowManager.LayoutParams bHt;
    private ImageView bHu;
    private boolean bHv;
    private int bHx;
    private boolean bHy;
    private WindowManager jn;
    private int mHeight;
    private int mWidth;

    public static a Xc() {
        if (bHw == null) {
            synchronized (a.class) {
                if (bHw == null) {
                    bHw = new a();
                }
            }
        }
        return bHw;
    }

    private a() {
    }

    public void m(Context context, int i) {
        this.bHy = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.jn = (WindowManager) context.getSystemService("window");
        this.bHx = i;
    }

    public void destroy() {
        this.bHy = false;
        bHw = null;
    }

    public boolean Xd() {
        return this.bHv;
    }

    public void a(Context context, View view, int i, int i2) {
        if (view != null) {
            this.bHv = true;
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
        Xe();
        ae(i, i2);
        this.jn.updateViewLayout(this.bHu, this.bHt);
    }

    private void Xe() {
        if (!this.bHy) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        Xe();
        if (bitmap != null) {
            ae(i, i2);
            this.bHu = new ImageView(context);
            this.bHu.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        this.jn.addView(this.bHu, this.bHt);
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

    private void Xf() {
        this.bHt = new WindowManager.LayoutParams();
        this.bHt.format = -3;
        this.bHt.gravity = 51;
        this.bHt.alpha = 1.0f;
        this.bHt.width = -2;
        this.bHt.height = -2;
        this.bHt.flags = 24;
    }

    private void ae(int i, int i2) {
        if (this.bHt == null) {
            Xf();
        }
        this.bHt.x = i - (this.mWidth / 2);
        this.bHt.y = (i2 - (this.mHeight / 2)) - this.bHx;
    }

    public void Xg() {
        if (this.bHu != null) {
            if (this.jn != null) {
                this.jn.removeView(this.bHu);
            }
            this.bHu = null;
        }
        this.bHv = false;
    }
}
