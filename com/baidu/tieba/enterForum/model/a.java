package com.baidu.tieba.enterForum.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes2.dex */
public class a {
    private static a dni;
    private WindowManager.LayoutParams dnf;
    private ImageView dng;
    private boolean dnh;
    private int dnj;
    private boolean dnk;
    private int mHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a apT() {
        if (dni == null) {
            synchronized (a.class) {
                if (dni == null) {
                    dni = new a();
                }
            }
        }
        return dni;
    }

    private a() {
    }

    public void y(Context context, int i) {
        this.dnk = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.dnj = i;
    }

    public void destroy() {
        this.dnk = false;
        dni = null;
    }

    public boolean apU() {
        return this.dnh;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.dnh = true;
            view.setPressed(true);
            view.setDrawingCacheEnabled(true);
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null && (createBitmap = Bitmap.createBitmap(drawingCache)) != null) {
                this.mWidth = createBitmap.getWidth();
                this.mHeight = createBitmap.getHeight();
                a(context, createBitmap, i, i2);
                view.destroyDrawingCache();
                view.setDrawingCacheEnabled(false);
            }
        }
    }

    public void bs(int i, int i2) {
        apV();
        bt(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.dng, this.dnf);
        }
    }

    private void apV() {
        if (!this.dnk) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        apV();
        if (bitmap != null) {
            bt(i, i2);
            this.dng = new ImageView(context);
            this.dng.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && aH(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.dng, this.dnf);
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

    private boolean aH(View view) {
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

    private void apW() {
        this.dnf = new WindowManager.LayoutParams();
        this.dnf.format = -3;
        this.dnf.gravity = 51;
        this.dnf.alpha = 1.0f;
        this.dnf.width = -2;
        this.dnf.height = -2;
        this.dnf.flags = 24;
    }

    private void bt(int i, int i2) {
        if (this.dnf == null) {
            apW();
        }
        this.dnf.x = i - (this.mWidth / 2);
        this.dnf.y = (i2 - (this.mHeight / 2)) - this.dnj;
    }

    public void apX() {
        if (this.dng != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.dng);
            }
            this.dng = null;
        }
        this.dnh = false;
    }
}
