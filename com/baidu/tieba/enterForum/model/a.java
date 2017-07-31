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
    private static a bYS;
    private WindowManager.LayoutParams bYP;
    private ImageView bYQ;
    private boolean bYR;
    private int bYT;
    private boolean bYU;
    private WindowManager jn;
    private int mHeight;
    private int mWidth;

    public static a abK() {
        if (bYS == null) {
            synchronized (a.class) {
                if (bYS == null) {
                    bYS = new a();
                }
            }
        }
        return bYS;
    }

    private a() {
    }

    public void n(Context context, int i) {
        this.bYU = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.jn = (WindowManager) context.getSystemService("window");
        this.bYT = i;
    }

    public void destroy() {
        this.bYU = false;
        bYS = null;
    }

    public boolean abL() {
        return this.bYR;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.bYR = true;
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

    public void ak(int i, int i2) {
        abM();
        al(i, i2);
        if (this.jn != null) {
            this.jn.updateViewLayout(this.bYQ, this.bYP);
        }
    }

    private void abM() {
        if (!this.bYU) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        abM();
        if (bitmap != null) {
            al(i, i2);
            this.bYQ = new ImageView(context);
            this.bYQ.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        if (this.jn != null) {
                            this.jn.addView(this.bYQ, this.bYP);
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

    private void abN() {
        this.bYP = new WindowManager.LayoutParams();
        this.bYP.format = -3;
        this.bYP.gravity = 51;
        this.bYP.alpha = 1.0f;
        this.bYP.width = -2;
        this.bYP.height = -2;
        this.bYP.flags = 24;
    }

    private void al(int i, int i2) {
        if (this.bYP == null) {
            abN();
        }
        this.bYP.x = i - (this.mWidth / 2);
        this.bYP.y = (i2 - (this.mHeight / 2)) - this.bYT;
    }

    public void abO() {
        if (this.bYQ != null) {
            if (this.jn != null) {
                this.jn.removeView(this.bYQ);
            }
            this.bYQ = null;
        }
        this.bYR = false;
    }
}
