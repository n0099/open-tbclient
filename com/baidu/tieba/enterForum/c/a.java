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
    private static a aMe;
    private WindowManager.LayoutParams aMb;
    private ImageView aMc;
    private boolean aMd;
    private int aMf;
    private boolean aMg;
    private WindowManager lB;
    private int mHeight;
    private int mWidth;

    public static a Ir() {
        if (aMe == null) {
            synchronized (a.class) {
                if (aMe == null) {
                    aMe = new a();
                }
            }
        }
        return aMe;
    }

    private a() {
    }

    public void j(Context context, int i) {
        this.aMg = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.lB = (WindowManager) context.getSystemService("window");
        this.aMf = i;
    }

    public void destroy() {
        this.aMg = false;
        aMe = null;
    }

    public boolean Is() {
        return this.aMd;
    }

    public void a(Context context, View view, int i, int i2) {
        if (view != null) {
            this.aMd = true;
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

    public void S(int i, int i2) {
        It();
        T(i, i2);
        this.lB.updateViewLayout(this.aMc, this.aMb);
    }

    private void It() {
        if (!this.aMg) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        It();
        if (bitmap != null) {
            T(i, i2);
            this.aMc = new ImageView(context);
            this.aMc.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && d(activity.getWindow().getDecorView())) {
                    try {
                        this.lB.addView(this.aMc, this.aMb);
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

    private void Iu() {
        this.aMb = new WindowManager.LayoutParams();
        this.aMb.format = -3;
        this.aMb.gravity = 51;
        this.aMb.alpha = 1.0f;
        this.aMb.width = -2;
        this.aMb.height = -2;
        this.aMb.flags = 24;
    }

    private void T(int i, int i2) {
        if (this.aMb == null) {
            Iu();
        }
        this.aMb.x = i - (this.mWidth / 2);
        this.aMb.y = (i2 - (this.mHeight / 2)) - this.aMf;
    }

    public void Iv() {
        if (this.aMc != null) {
            if (this.lB != null) {
                this.lB.removeView(this.aMc);
            }
            this.aMc = null;
        }
        this.aMd = false;
    }
}
