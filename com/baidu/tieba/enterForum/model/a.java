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
    private static a ctP;
    private WindowManager.LayoutParams ctM;
    private ImageView ctN;
    private boolean ctO;
    private int ctQ;
    private boolean ctR;
    private int mHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a ahk() {
        if (ctP == null) {
            synchronized (a.class) {
                if (ctP == null) {
                    ctP = new a();
                }
            }
        }
        return ctP;
    }

    private a() {
    }

    public void l(Context context, int i) {
        this.ctR = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.ctQ = i;
    }

    public void destroy() {
        this.ctR = false;
        ctP = null;
    }

    public boolean ahl() {
        return this.ctO;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.ctO = true;
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
        ahm();
        au(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.ctN, this.ctM);
        }
    }

    private void ahm() {
        if (!this.ctR) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        ahm();
        if (bitmap != null) {
            au(i, i2);
            this.ctN = new ImageView(context);
            this.ctN.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.ctN, this.ctM);
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

    private void ahn() {
        this.ctM = new WindowManager.LayoutParams();
        this.ctM.format = -3;
        this.ctM.gravity = 51;
        this.ctM.alpha = 1.0f;
        this.ctM.width = -2;
        this.ctM.height = -2;
        this.ctM.flags = 24;
    }

    private void au(int i, int i2) {
        if (this.ctM == null) {
            ahn();
        }
        this.ctM.x = i - (this.mWidth / 2);
        this.ctM.y = (i2 - (this.mHeight / 2)) - this.ctQ;
    }

    public void aho() {
        if (this.ctN != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.ctN);
            }
            this.ctN = null;
        }
        this.ctO = false;
    }
}
