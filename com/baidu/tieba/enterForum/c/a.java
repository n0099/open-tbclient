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
    private static a aMm;
    private WindowManager.LayoutParams aMj;
    private ImageView aMk;
    private boolean aMl;
    private int aMn;
    private boolean aMo;
    private WindowManager lB;
    private int mHeight;
    private int mWidth;

    public static a ID() {
        if (aMm == null) {
            synchronized (a.class) {
                if (aMm == null) {
                    aMm = new a();
                }
            }
        }
        return aMm;
    }

    private a() {
    }

    public void j(Context context, int i) {
        this.aMo = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.lB = (WindowManager) context.getSystemService("window");
        this.aMn = i;
    }

    public void destroy() {
        this.aMo = false;
        aMm = null;
    }

    public boolean IE() {
        return this.aMl;
    }

    public void a(Context context, View view, int i, int i2) {
        if (view != null) {
            this.aMl = true;
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

    public void S(int i, int i2) {
        IF();
        T(i, i2);
        this.lB.updateViewLayout(this.aMk, this.aMj);
    }

    private void IF() {
        if (!this.aMo) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        IF();
        if (bitmap != null) {
            T(i, i2);
            this.aMk = new ImageView(context);
            this.aMk.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && d(activity.getWindow().getDecorView())) {
                    try {
                        this.lB.addView(this.aMk, this.aMj);
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

    private boolean d(View view) {
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

    private void IG() {
        this.aMj = new WindowManager.LayoutParams();
        this.aMj.format = -3;
        this.aMj.gravity = 51;
        this.aMj.alpha = 1.0f;
        this.aMj.width = -2;
        this.aMj.height = -2;
        this.aMj.flags = 24;
    }

    private void T(int i, int i2) {
        if (this.aMj == null) {
            IG();
        }
        this.aMj.x = i - (this.mWidth / 2);
        this.aMj.y = (i2 - (this.mHeight / 2)) - this.aMn;
    }

    public void IH() {
        if (this.aMk != null) {
            if (this.lB != null) {
                this.lB.removeView(this.aMk);
            }
            this.aMk = null;
        }
        this.aMl = false;
    }
}
