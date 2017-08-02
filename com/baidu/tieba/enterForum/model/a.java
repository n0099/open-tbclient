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
    private static a bXM;
    private WindowManager.LayoutParams bXJ;
    private ImageView bXK;
    private boolean bXL;
    private int bXN;
    private boolean bXO;
    private WindowManager jn;
    private int mHeight;
    private int mWidth;

    public static a abF() {
        if (bXM == null) {
            synchronized (a.class) {
                if (bXM == null) {
                    bXM = new a();
                }
            }
        }
        return bXM;
    }

    private a() {
    }

    public void n(Context context, int i) {
        this.bXO = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.jn = (WindowManager) context.getSystemService("window");
        this.bXN = i;
    }

    public void destroy() {
        this.bXO = false;
        bXM = null;
    }

    public boolean abG() {
        return this.bXL;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.bXL = true;
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

    public void aj(int i, int i2) {
        abH();
        ak(i, i2);
        if (this.jn != null) {
            this.jn.updateViewLayout(this.bXK, this.bXJ);
        }
    }

    private void abH() {
        if (!this.bXO) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        abH();
        if (bitmap != null) {
            ak(i, i2);
            this.bXK = new ImageView(context);
            this.bXK.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        if (this.jn != null) {
                            this.jn.addView(this.bXK, this.bXJ);
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

    private void abI() {
        this.bXJ = new WindowManager.LayoutParams();
        this.bXJ.format = -3;
        this.bXJ.gravity = 51;
        this.bXJ.alpha = 1.0f;
        this.bXJ.width = -2;
        this.bXJ.height = -2;
        this.bXJ.flags = 24;
    }

    private void ak(int i, int i2) {
        if (this.bXJ == null) {
            abI();
        }
        this.bXJ.x = i - (this.mWidth / 2);
        this.bXJ.y = (i2 - (this.mHeight / 2)) - this.bXN;
    }

    public void abJ() {
        if (this.bXK != null) {
            if (this.jn != null) {
                this.jn.removeView(this.bXK);
            }
            this.bXK = null;
        }
        this.bXL = false;
    }
}
