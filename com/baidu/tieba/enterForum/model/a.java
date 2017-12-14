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
    private static a ctL;
    private WindowManager.LayoutParams ctI;
    private ImageView ctJ;
    private boolean ctK;
    private int ctM;
    private boolean ctN;
    private int mHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a ahl() {
        if (ctL == null) {
            synchronized (a.class) {
                if (ctL == null) {
                    ctL = new a();
                }
            }
        }
        return ctL;
    }

    private a() {
    }

    public void l(Context context, int i) {
        this.ctN = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.ctM = i;
    }

    public void destroy() {
        this.ctN = false;
        ctL = null;
    }

    public boolean ahm() {
        return this.ctK;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.ctK = true;
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

    public void at(int i, int i2) {
        ahn();
        au(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.ctJ, this.ctI);
        }
    }

    private void ahn() {
        if (!this.ctN) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        ahn();
        if (bitmap != null) {
            au(i, i2);
            this.ctJ = new ImageView(context);
            this.ctJ.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.ctJ, this.ctI);
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

    private void aho() {
        this.ctI = new WindowManager.LayoutParams();
        this.ctI.format = -3;
        this.ctI.gravity = 51;
        this.ctI.alpha = 1.0f;
        this.ctI.width = -2;
        this.ctI.height = -2;
        this.ctI.flags = 24;
    }

    private void au(int i, int i2) {
        if (this.ctI == null) {
            aho();
        }
        this.ctI.x = i - (this.mWidth / 2);
        this.ctI.y = (i2 - (this.mHeight / 2)) - this.ctM;
    }

    public void ahp() {
        if (this.ctJ != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.ctJ);
            }
            this.ctJ = null;
        }
        this.ctK = false;
    }
}
