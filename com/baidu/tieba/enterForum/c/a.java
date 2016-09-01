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
    private static a bHn;
    private WindowManager bC;
    private WindowManager.LayoutParams bHk;
    private ImageView bHl;
    private boolean bHm;
    private int bHo;
    private boolean bHp;
    private int mHeight;
    private int mWidth;

    public static a XD() {
        if (bHn == null) {
            synchronized (a.class) {
                if (bHn == null) {
                    bHn = new a();
                }
            }
        }
        return bHn;
    }

    private a() {
    }

    public void k(Context context, int i) {
        this.bHp = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.bC = (WindowManager) context.getSystemService("window");
        this.bHo = i;
    }

    public void destroy() {
        this.bHp = false;
        bHn = null;
    }

    public boolean XE() {
        return this.bHm;
    }

    public void a(Context context, View view, int i, int i2) {
        if (view != null) {
            this.bHm = true;
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

    public void ab(int i, int i2) {
        XF();
        ac(i, i2);
        this.bC.updateViewLayout(this.bHl, this.bHk);
    }

    private void XF() {
        if (!this.bHp) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        XF();
        if (bitmap != null) {
            ac(i, i2);
            this.bHl = new ImageView(context);
            this.bHl.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        this.bC.addView(this.bHl, this.bHk);
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

    private void XG() {
        this.bHk = new WindowManager.LayoutParams();
        this.bHk.format = -3;
        this.bHk.gravity = 51;
        this.bHk.alpha = 1.0f;
        this.bHk.width = -2;
        this.bHk.height = -2;
        this.bHk.flags = 24;
    }

    private void ac(int i, int i2) {
        if (this.bHk == null) {
            XG();
        }
        this.bHk.x = i - (this.mWidth / 2);
        this.bHk.y = (i2 - (this.mHeight / 2)) - this.bHo;
    }

    public void XH() {
        if (this.bHl != null) {
            if (this.bC != null) {
                this.bC.removeView(this.bHl);
            }
            this.bHl = null;
        }
        this.bHm = false;
    }
}
