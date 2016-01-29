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
    private static a aWY;
    private WindowManager.LayoutParams aWV;
    private ImageView aWW;
    private boolean aWX;
    private int aWZ;
    private boolean aXa;
    private WindowManager lB;
    private int mHeight;
    private int mWidth;

    public static a Mf() {
        if (aWY == null) {
            synchronized (a.class) {
                if (aWY == null) {
                    aWY = new a();
                }
            }
        }
        return aWY;
    }

    private a() {
    }

    public void h(Context context, int i) {
        this.aXa = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.lB = (WindowManager) context.getSystemService("window");
        this.aWZ = i;
    }

    public void destroy() {
        this.aXa = false;
        aWY = null;
    }

    public boolean Mg() {
        return this.aWX;
    }

    public void a(Context context, View view, int i, int i2) {
        if (view != null) {
            this.aWX = true;
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
        Mh();
        T(i, i2);
        this.lB.updateViewLayout(this.aWW, this.aWV);
    }

    private void Mh() {
        if (!this.aXa) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        Mh();
        if (bitmap != null) {
            T(i, i2);
            this.aWW = new ImageView(context);
            this.aWW.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        this.lB.addView(this.aWW, this.aWV);
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

    private void Mi() {
        this.aWV = new WindowManager.LayoutParams();
        this.aWV.format = -3;
        this.aWV.gravity = 51;
        this.aWV.alpha = 1.0f;
        this.aWV.width = -2;
        this.aWV.height = -2;
        this.aWV.flags = 24;
    }

    private void T(int i, int i2) {
        if (this.aWV == null) {
            Mi();
        }
        this.aWV.x = i - (this.mWidth / 2);
        this.aWV.y = (i2 - (this.mHeight / 2)) - this.aWZ;
    }

    public void Mj() {
        if (this.aWW != null) {
            if (this.lB != null) {
                this.lB.removeView(this.aWW);
            }
            this.aWW = null;
        }
        this.aWX = false;
    }
}
