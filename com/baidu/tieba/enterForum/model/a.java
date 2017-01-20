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
    private static a byg;
    private WindowManager bC;
    private WindowManager.LayoutParams byd;
    private ImageView bye;
    private boolean byf;
    private int byh;
    private boolean byi;
    private int mHeight;
    private int mWidth;

    public static a UF() {
        if (byg == null) {
            synchronized (a.class) {
                if (byg == null) {
                    byg = new a();
                }
            }
        }
        return byg;
    }

    private a() {
    }

    public void k(Context context, int i) {
        this.byi = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.bC = (WindowManager) context.getSystemService("window");
        this.byh = i;
    }

    public void destroy() {
        this.byi = false;
        byg = null;
    }

    public boolean UG() {
        return this.byf;
    }

    public void a(Context context, View view, int i, int i2) {
        if (view != null) {
            this.byf = true;
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

    public void X(int i, int i2) {
        UH();
        Y(i, i2);
        this.bC.updateViewLayout(this.bye, this.byd);
    }

    private void UH() {
        if (!this.byi) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        UH();
        if (bitmap != null) {
            Y(i, i2);
            this.bye = new ImageView(context);
            this.bye.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        this.bC.addView(this.bye, this.byd);
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

    private void UI() {
        this.byd = new WindowManager.LayoutParams();
        this.byd.format = -3;
        this.byd.gravity = 51;
        this.byd.alpha = 1.0f;
        this.byd.width = -2;
        this.byd.height = -2;
        this.byd.flags = 24;
    }

    private void Y(int i, int i2) {
        if (this.byd == null) {
            UI();
        }
        this.byd.x = i - (this.mWidth / 2);
        this.byd.y = (i2 - (this.mHeight / 2)) - this.byh;
    }

    public void UJ() {
        if (this.bye != null) {
            if (this.bC != null) {
                this.bC.removeView(this.bye);
            }
            this.bye = null;
        }
        this.byf = false;
    }
}
