package com.baidu.tieba.enterForum.c;

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
    private static a bHv;
    private WindowManager bC;
    private WindowManager.LayoutParams bHs;
    private ImageView bHt;
    private boolean bHu;
    private int bHw;
    private boolean bHx;
    private int mHeight;
    private int mWidth;

    public static a XX() {
        if (bHv == null) {
            synchronized (a.class) {
                if (bHv == null) {
                    bHv = new a();
                }
            }
        }
        return bHv;
    }

    private a() {
    }

    public void j(Context context, int i) {
        this.bHx = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.bC = (WindowManager) context.getSystemService("window");
        this.bHw = i;
    }

    public void destroy() {
        this.bHx = false;
        bHv = null;
    }

    public boolean XY() {
        return this.bHu;
    }

    public void a(Context context, View view, int i, int i2) {
        if (view != null) {
            this.bHu = true;
            view.setPressed(false);
            view.setDrawingCacheEnabled(true);
            Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
            this.mWidth = createBitmap.getWidth();
            this.mHeight = createBitmap.getHeight();
            a(context, createBitmap, i, i2);
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
        }
    }

    public void ac(int i, int i2) {
        XZ();
        ad(i, i2);
        this.bC.updateViewLayout(this.bHt, this.bHs);
    }

    private void XZ() {
        if (!this.bHx) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        XZ();
        if (bitmap != null) {
            ad(i, i2);
            this.bHt = new ImageView(context);
            this.bHt.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        this.bC.addView(this.bHt, this.bHs);
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

    private void Ya() {
        this.bHs = new WindowManager.LayoutParams();
        this.bHs.format = -3;
        this.bHs.gravity = 51;
        this.bHs.alpha = 1.0f;
        this.bHs.width = -2;
        this.bHs.height = -2;
        this.bHs.flags = 24;
    }

    private void ad(int i, int i2) {
        if (this.bHs == null) {
            Ya();
        }
        this.bHs.x = i - (this.mWidth / 2);
        this.bHs.y = (i2 - (this.mHeight / 2)) - this.bHw;
    }

    public void Yb() {
        if (this.bHt != null) {
            if (this.bC != null) {
                this.bC.removeView(this.bHt);
            }
            this.bHt = null;
        }
        this.bHu = false;
    }
}
