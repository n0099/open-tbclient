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
    private static a aMY;
    private WindowManager.LayoutParams aMV;
    private ImageView aMW;
    private boolean aMX;
    private int aMZ;
    private boolean aNa;
    private WindowManager lB;
    private int mHeight;
    private int mWidth;

    public static a Iv() {
        if (aMY == null) {
            synchronized (a.class) {
                if (aMY == null) {
                    aMY = new a();
                }
            }
        }
        return aMY;
    }

    private a() {
    }

    public void j(Context context, int i) {
        this.aNa = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.lB = (WindowManager) context.getSystemService("window");
        this.aMZ = i;
    }

    public void destroy() {
        this.aNa = false;
        aMY = null;
    }

    public boolean Iw() {
        return this.aMX;
    }

    public void a(Context context, View view, int i, int i2) {
        if (view != null) {
            this.aMX = true;
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
        Ix();
        T(i, i2);
        this.lB.updateViewLayout(this.aMW, this.aMV);
    }

    private void Ix() {
        if (!this.aNa) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        Ix();
        if (bitmap != null) {
            T(i, i2);
            this.aMW = new ImageView(context);
            this.aMW.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && d(activity.getWindow().getDecorView())) {
                    try {
                        this.lB.addView(this.aMW, this.aMV);
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

    private void Iy() {
        this.aMV = new WindowManager.LayoutParams();
        this.aMV.format = -3;
        this.aMV.gravity = 51;
        this.aMV.alpha = 1.0f;
        this.aMV.width = -2;
        this.aMV.height = -2;
        this.aMV.flags = 24;
    }

    private void T(int i, int i2) {
        if (this.aMV == null) {
            Iy();
        }
        this.aMV.x = i - (this.mWidth / 2);
        this.aMV.y = (i2 - (this.mHeight / 2)) - this.aMZ;
    }

    public void Iz() {
        if (this.aMW != null) {
            if (this.lB != null) {
                this.lB.removeView(this.aMW);
            }
            this.aMW = null;
        }
        this.aMX = false;
    }
}
