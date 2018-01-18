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
    private static a dmN;
    private WindowManager.LayoutParams dmK;
    private ImageView dmL;
    private boolean dmM;
    private int dmO;
    private boolean dmP;
    private int mHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a apO() {
        if (dmN == null) {
            synchronized (a.class) {
                if (dmN == null) {
                    dmN = new a();
                }
            }
        }
        return dmN;
    }

    private a() {
    }

    public void y(Context context, int i) {
        this.dmP = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.dmO = i;
    }

    public void destroy() {
        this.dmP = false;
        dmN = null;
    }

    public boolean apP() {
        return this.dmM;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.dmM = true;
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
        apQ();
        bt(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.dmL, this.dmK);
        }
    }

    private void apQ() {
        if (!this.dmP) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        apQ();
        if (bitmap != null) {
            bt(i, i2);
            this.dmL = new ImageView(context);
            this.dmL.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && aH(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.dmL, this.dmK);
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

    private void apR() {
        this.dmK = new WindowManager.LayoutParams();
        this.dmK.format = -3;
        this.dmK.gravity = 51;
        this.dmK.alpha = 1.0f;
        this.dmK.width = -2;
        this.dmK.height = -2;
        this.dmK.flags = 24;
    }

    private void bt(int i, int i2) {
        if (this.dmK == null) {
            apR();
        }
        this.dmK.x = i - (this.mWidth / 2);
        this.dmK.y = (i2 - (this.mHeight / 2)) - this.dmO;
    }

    public void apS() {
        if (this.dmL != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.dmL);
            }
            this.dmL = null;
        }
        this.dmM = false;
    }
}
