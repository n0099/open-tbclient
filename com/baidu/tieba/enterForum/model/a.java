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
    private static a bZE;
    private WindowManager.LayoutParams bZB;
    private ImageView bZC;
    private boolean bZD;
    private int bZF;
    private boolean bZG;
    private WindowManager jn;
    private int mHeight;
    private int mWidth;

    public static a acf() {
        if (bZE == null) {
            synchronized (a.class) {
                if (bZE == null) {
                    bZE = new a();
                }
            }
        }
        return bZE;
    }

    private a() {
    }

    public void n(Context context, int i) {
        this.bZG = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.jn = (WindowManager) context.getSystemService("window");
        this.bZF = i;
    }

    public void destroy() {
        this.bZG = false;
        bZE = null;
    }

    public boolean acg() {
        return this.bZD;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.bZD = true;
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
        ach();
        al(i, i2);
        if (this.jn != null) {
            this.jn.updateViewLayout(this.bZC, this.bZB);
        }
    }

    private void ach() {
        if (!this.bZG) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        ach();
        if (bitmap != null) {
            al(i, i2);
            this.bZC = new ImageView(context);
            this.bZC.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        if (this.jn != null) {
                            this.jn.addView(this.bZC, this.bZB);
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

    private void aci() {
        this.bZB = new WindowManager.LayoutParams();
        this.bZB.format = -3;
        this.bZB.gravity = 51;
        this.bZB.alpha = 1.0f;
        this.bZB.width = -2;
        this.bZB.height = -2;
        this.bZB.flags = 24;
    }

    private void al(int i, int i2) {
        if (this.bZB == null) {
            aci();
        }
        this.bZB.x = i - (this.mWidth / 2);
        this.bZB.y = (i2 - (this.mHeight / 2)) - this.bZF;
    }

    public void acj() {
        if (this.bZC != null) {
            if (this.jn != null) {
                this.jn.removeView(this.bZC);
            }
            this.bZC = null;
        }
        this.bZD = false;
    }
}
