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
    private static a bFf;
    private WindowManager.LayoutParams bFc;
    private ImageView bFd;
    private boolean bFe;
    private int bFg;
    private boolean bFh;
    private WindowManager jn;
    private int mHeight;
    private int mWidth;

    public static a Wb() {
        if (bFf == null) {
            synchronized (a.class) {
                if (bFf == null) {
                    bFf = new a();
                }
            }
        }
        return bFf;
    }

    private a() {
    }

    public void m(Context context, int i) {
        this.bFh = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.jn = (WindowManager) context.getSystemService("window");
        this.bFg = i;
    }

    public void destroy() {
        this.bFh = false;
        bFf = null;
    }

    public boolean Wc() {
        return this.bFe;
    }

    public void a(Context context, View view, int i, int i2) {
        if (view != null) {
            this.bFe = true;
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
        Wd();
        ae(i, i2);
        this.jn.updateViewLayout(this.bFd, this.bFc);
    }

    private void Wd() {
        if (!this.bFh) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        Wd();
        if (bitmap != null) {
            ae(i, i2);
            this.bFd = new ImageView(context);
            this.bFd.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        this.jn.addView(this.bFd, this.bFc);
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

    private void We() {
        this.bFc = new WindowManager.LayoutParams();
        this.bFc.format = -3;
        this.bFc.gravity = 51;
        this.bFc.alpha = 1.0f;
        this.bFc.width = -2;
        this.bFc.height = -2;
        this.bFc.flags = 24;
    }

    private void ae(int i, int i2) {
        if (this.bFc == null) {
            We();
        }
        this.bFc.x = i - (this.mWidth / 2);
        this.bFc.y = (i2 - (this.mHeight / 2)) - this.bFg;
    }

    public void Wf() {
        if (this.bFd != null) {
            if (this.jn != null) {
                this.jn.removeView(this.bFd);
            }
            this.bFd = null;
        }
        this.bFe = false;
    }
}
