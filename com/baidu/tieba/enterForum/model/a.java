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
    private static a bZF;
    private WindowManager.LayoutParams bZC;
    private ImageView bZD;
    private boolean bZE;
    private int bZG;
    private boolean bZH;
    private WindowManager jn;
    private int mHeight;
    private int mWidth;

    public static a acb() {
        if (bZF == null) {
            synchronized (a.class) {
                if (bZF == null) {
                    bZF = new a();
                }
            }
        }
        return bZF;
    }

    private a() {
    }

    public void n(Context context, int i) {
        this.bZH = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.jn = (WindowManager) context.getSystemService("window");
        this.bZG = i;
    }

    public void destroy() {
        this.bZH = false;
        bZF = null;
    }

    public boolean acc() {
        return this.bZE;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.bZE = true;
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
        acd();
        al(i, i2);
        if (this.jn != null) {
            this.jn.updateViewLayout(this.bZD, this.bZC);
        }
    }

    private void acd() {
        if (!this.bZH) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        acd();
        if (bitmap != null) {
            al(i, i2);
            this.bZD = new ImageView(context);
            this.bZD.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        if (this.jn != null) {
                            this.jn.addView(this.bZD, this.bZC);
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

    private void ace() {
        this.bZC = new WindowManager.LayoutParams();
        this.bZC.format = -3;
        this.bZC.gravity = 51;
        this.bZC.alpha = 1.0f;
        this.bZC.width = -2;
        this.bZC.height = -2;
        this.bZC.flags = 24;
    }

    private void al(int i, int i2) {
        if (this.bZC == null) {
            ace();
        }
        this.bZC.x = i - (this.mWidth / 2);
        this.bZC.y = (i2 - (this.mHeight / 2)) - this.bZG;
    }

    public void acf() {
        if (this.bZD != null) {
            if (this.jn != null) {
                this.jn.removeView(this.bZD);
            }
            this.bZD = null;
        }
        this.bZE = false;
    }
}
