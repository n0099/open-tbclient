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
    private static a bHh;
    private WindowManager.LayoutParams bHe;
    private ImageView bHf;
    private boolean bHg;
    private int bHi;
    private boolean bHj;
    private WindowManager jn;
    private int mHeight;
    private int mWidth;

    public static a Ws() {
        if (bHh == null) {
            synchronized (a.class) {
                if (bHh == null) {
                    bHh = new a();
                }
            }
        }
        return bHh;
    }

    private a() {
    }

    public void m(Context context, int i) {
        this.bHj = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.jn = (WindowManager) context.getSystemService("window");
        this.bHi = i;
    }

    public void destroy() {
        this.bHj = false;
        bHh = null;
    }

    public boolean Wt() {
        return this.bHg;
    }

    public void a(Context context, View view, int i, int i2) {
        if (view != null) {
            this.bHg = true;
            view.setPressed(true);
            view.setDrawingCacheEnabled(true);
            Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
            this.mWidth = createBitmap.getWidth();
            this.mHeight = createBitmap.getHeight();
            a(context, createBitmap, i, i2);
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
        }
    }

    public void ae(int i, int i2) {
        Wu();
        af(i, i2);
        if (this.jn != null) {
            this.jn.updateViewLayout(this.bHf, this.bHe);
        }
    }

    private void Wu() {
        if (!this.bHj) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        Wu();
        if (bitmap != null) {
            af(i, i2);
            this.bHf = new ImageView(context);
            this.bHf.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        if (this.jn != null) {
                            this.jn.addView(this.bHf, this.bHe);
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

    private void Wv() {
        this.bHe = new WindowManager.LayoutParams();
        this.bHe.format = -3;
        this.bHe.gravity = 51;
        this.bHe.alpha = 1.0f;
        this.bHe.width = -2;
        this.bHe.height = -2;
        this.bHe.flags = 24;
    }

    private void af(int i, int i2) {
        if (this.bHe == null) {
            Wv();
        }
        this.bHe.x = i - (this.mWidth / 2);
        this.bHe.y = (i2 - (this.mHeight / 2)) - this.bHi;
    }

    public void Ww() {
        if (this.bHf != null) {
            if (this.jn != null) {
                this.jn.removeView(this.bHf);
            }
            this.bHf = null;
        }
        this.bHg = false;
    }
}
