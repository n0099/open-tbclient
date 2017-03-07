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
    private static a bFm;
    private WindowManager.LayoutParams bFj;
    private ImageView bFk;
    private boolean bFl;
    private int bFn;
    private boolean bFo;
    private WindowManager jn;
    private int mHeight;
    private int mWidth;

    public static a VD() {
        if (bFm == null) {
            synchronized (a.class) {
                if (bFm == null) {
                    bFm = new a();
                }
            }
        }
        return bFm;
    }

    private a() {
    }

    public void m(Context context, int i) {
        this.bFo = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.jn = (WindowManager) context.getSystemService("window");
        this.bFn = i;
    }

    public void destroy() {
        this.bFo = false;
        bFm = null;
    }

    public boolean VE() {
        return this.bFl;
    }

    public void a(Context context, View view, int i, int i2) {
        if (view != null) {
            this.bFl = true;
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

    public void ad(int i, int i2) {
        VF();
        ae(i, i2);
        this.jn.updateViewLayout(this.bFk, this.bFj);
    }

    private void VF() {
        if (!this.bFo) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        VF();
        if (bitmap != null) {
            ae(i, i2);
            this.bFk = new ImageView(context);
            this.bFk.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        this.jn.addView(this.bFk, this.bFj);
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

    private void VG() {
        this.bFj = new WindowManager.LayoutParams();
        this.bFj.format = -3;
        this.bFj.gravity = 51;
        this.bFj.alpha = 1.0f;
        this.bFj.width = -2;
        this.bFj.height = -2;
        this.bFj.flags = 24;
    }

    private void ae(int i, int i2) {
        if (this.bFj == null) {
            VG();
        }
        this.bFj.x = i - (this.mWidth / 2);
        this.bFj.y = (i2 - (this.mHeight / 2)) - this.bFn;
    }

    public void VH() {
        if (this.bFk != null) {
            if (this.jn != null) {
                this.jn.removeView(this.bFk);
            }
            this.bFk = null;
        }
        this.bFl = false;
    }
}
