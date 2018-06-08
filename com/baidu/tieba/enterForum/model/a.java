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
    private static a cSH;
    private WindowManager.LayoutParams cSF;
    private ImageView cSG;
    private int cSI;
    private boolean cSJ;
    private int mHeight;
    private boolean mIsDragging;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a apd() {
        if (cSH == null) {
            synchronized (a.class) {
                if (cSH == null) {
                    cSH = new a();
                }
            }
        }
        return cSH;
    }

    private a() {
    }

    public void k(Context context, int i) {
        this.cSJ = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.cSI = i;
    }

    public void destroy() {
        this.cSJ = false;
        cSH = null;
    }

    public boolean isDragging() {
        return this.mIsDragging;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.mIsDragging = true;
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

    public void av(int i, int i2) {
        ape();
        aw(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.cSG, this.cSF);
        }
    }

    private void ape() {
        if (!this.cSJ) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        ape();
        if (bitmap != null) {
            aw(i, i2);
            this.cSG = new ImageView(context);
            this.cSG.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.cSG, this.cSF);
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

    private void apf() {
        this.cSF = new WindowManager.LayoutParams();
        this.cSF.format = -3;
        this.cSF.gravity = 51;
        this.cSF.alpha = 1.0f;
        this.cSF.width = -2;
        this.cSF.height = -2;
        this.cSF.flags = 24;
    }

    private void aw(int i, int i2) {
        if (this.cSF == null) {
            apf();
        }
        this.cSF.x = i - (this.mWidth / 2);
        this.cSF.y = (i2 - (this.mHeight / 2)) - this.cSI;
    }

    public void apg() {
        if (this.cSG != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.cSG);
            }
            this.cSG = null;
        }
        this.mIsDragging = false;
    }
}
