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
    private static a aUM;
    private WindowManager.LayoutParams aUJ;
    private ImageView aUK;
    private boolean aUL;
    private int aUN;
    private boolean aUO;
    private WindowManager lB;
    private int mHeight;
    private int mWidth;

    public static a Ko() {
        if (aUM == null) {
            synchronized (a.class) {
                if (aUM == null) {
                    aUM = new a();
                }
            }
        }
        return aUM;
    }

    private a() {
    }

    public void j(Context context, int i) {
        this.aUO = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.lB = (WindowManager) context.getSystemService("window");
        this.aUN = i;
    }

    public void destroy() {
        this.aUO = false;
        aUM = null;
    }

    public boolean Kp() {
        return this.aUL;
    }

    public void a(Context context, View view, int i, int i2) {
        if (view != null) {
            this.aUL = true;
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
        Kq();
        U(i, i2);
        this.lB.updateViewLayout(this.aUK, this.aUJ);
    }

    private void Kq() {
        if (!this.aUO) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        Kq();
        if (bitmap != null) {
            U(i, i2);
            this.aUK = new ImageView(context);
            this.aUK.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && d(activity.getWindow().getDecorView())) {
                    try {
                        this.lB.addView(this.aUK, this.aUJ);
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

    private void Kr() {
        this.aUJ = new WindowManager.LayoutParams();
        this.aUJ.format = -3;
        this.aUJ.gravity = 51;
        this.aUJ.alpha = 1.0f;
        this.aUJ.width = -2;
        this.aUJ.height = -2;
        this.aUJ.flags = 24;
    }

    private void U(int i, int i2) {
        if (this.aUJ == null) {
            Kr();
        }
        this.aUJ.x = i - (this.mWidth / 2);
        this.aUJ.y = (i2 - (this.mHeight / 2)) - this.aUN;
    }

    public void Ks() {
        if (this.aUK != null) {
            if (this.lB != null) {
                this.lB.removeView(this.aUK);
            }
            this.aUK = null;
        }
        this.aUL = false;
    }
}
