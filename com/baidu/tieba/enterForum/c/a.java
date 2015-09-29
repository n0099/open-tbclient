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
    private static a aLT;
    private WindowManager.LayoutParams aLQ;
    private ImageView aLR;
    private boolean aLS;
    private int aLU;
    private boolean aLV;
    private WindowManager lB;
    private int mHeight;
    private int mWidth;

    public static a Ir() {
        if (aLT == null) {
            synchronized (a.class) {
                if (aLT == null) {
                    aLT = new a();
                }
            }
        }
        return aLT;
    }

    private a() {
    }

    public void j(Context context, int i) {
        this.aLV = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.lB = (WindowManager) context.getSystemService("window");
        this.aLU = i;
    }

    public void destroy() {
        this.aLV = false;
        aLT = null;
    }

    public boolean Is() {
        return this.aLS;
    }

    public void a(Context context, View view, int i, int i2) {
        if (view != null) {
            this.aLS = true;
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
        It();
        T(i, i2);
        this.lB.updateViewLayout(this.aLR, this.aLQ);
    }

    private void It() {
        if (!this.aLV) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        It();
        if (bitmap != null) {
            T(i, i2);
            this.aLR = new ImageView(context);
            this.aLR.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && d(activity.getWindow().getDecorView())) {
                    try {
                        this.lB.addView(this.aLR, this.aLQ);
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

    private void Iu() {
        this.aLQ = new WindowManager.LayoutParams();
        this.aLQ.format = -3;
        this.aLQ.gravity = 51;
        this.aLQ.alpha = 1.0f;
        this.aLQ.width = -2;
        this.aLQ.height = -2;
        this.aLQ.flags = 24;
    }

    private void T(int i, int i2) {
        if (this.aLQ == null) {
            Iu();
        }
        this.aLQ.x = i - (this.mWidth / 2);
        this.aLQ.y = (i2 - (this.mHeight / 2)) - this.aLU;
    }

    public void Iv() {
        if (this.aLR != null) {
            if (this.lB != null) {
                this.lB.removeView(this.aLR);
            }
            this.aLR = null;
        }
        this.aLS = false;
    }
}
