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
    private static a cJB;
    private ImageView cJA;
    private int cJC;
    private boolean cJD;
    private WindowManager.LayoutParams cJz;
    private int mHeight;
    private boolean mIsDragging;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a akX() {
        if (cJB == null) {
            synchronized (a.class) {
                if (cJB == null) {
                    cJB = new a();
                }
            }
        }
        return cJB;
    }

    private a() {
    }

    public void k(Context context, int i) {
        this.cJD = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.cJC = i;
    }

    public void destroy() {
        this.cJD = false;
        cJB = null;
    }

    public boolean akY() {
        return this.mIsDragging;
    }

    public void a(Context context, View view2, int i, int i2) {
        Bitmap createBitmap;
        if (view2 != null) {
            this.mIsDragging = true;
            view2.setPressed(true);
            view2.setDrawingCacheEnabled(true);
            Bitmap drawingCache = view2.getDrawingCache();
            if (drawingCache != null && (createBitmap = Bitmap.createBitmap(drawingCache)) != null) {
                this.mWidth = createBitmap.getWidth();
                this.mHeight = createBitmap.getHeight();
                a(context, createBitmap, i, i2);
                view2.destroyDrawingCache();
                view2.setDrawingCacheEnabled(false);
            }
        }
    }

    public void at(int i, int i2) {
        akZ();
        au(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.cJA, this.cJz);
        }
    }

    private void akZ() {
        if (!this.cJD) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        akZ();
        if (bitmap != null) {
            au(i, i2);
            this.cJA = new ImageView(context);
            this.cJA.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.cJA, this.cJz);
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

    private boolean p(View view2) {
        IBinder windowToken;
        if (view2 != null && (windowToken = view2.getWindowToken()) != null) {
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

    private void ala() {
        this.cJz = new WindowManager.LayoutParams();
        this.cJz.format = -3;
        this.cJz.gravity = 51;
        this.cJz.alpha = 1.0f;
        this.cJz.width = -2;
        this.cJz.height = -2;
        this.cJz.flags = 24;
    }

    private void au(int i, int i2) {
        if (this.cJz == null) {
            ala();
        }
        this.cJz.x = i - (this.mWidth / 2);
        this.cJz.y = (i2 - (this.mHeight / 2)) - this.cJC;
    }

    public void alb() {
        if (this.cJA != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.cJA);
            }
            this.cJA = null;
        }
        this.mIsDragging = false;
    }
}
