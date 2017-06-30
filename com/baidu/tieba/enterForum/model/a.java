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
    private static a bTy;
    private boolean bTA;
    private WindowManager.LayoutParams bTv;
    private ImageView bTw;
    private boolean bTx;
    private int bTz;
    private WindowManager jn;
    private int mHeight;
    private int mWidth;

    public static a aaT() {
        if (bTy == null) {
            synchronized (a.class) {
                if (bTy == null) {
                    bTy = new a();
                }
            }
        }
        return bTy;
    }

    private a() {
    }

    public void n(Context context, int i) {
        this.bTA = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.jn = (WindowManager) context.getSystemService("window");
        this.bTz = i;
    }

    public void destroy() {
        this.bTA = false;
        bTy = null;
    }

    public boolean aaU() {
        return this.bTx;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.bTx = true;
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
        aaV();
        al(i, i2);
        if (this.jn != null) {
            this.jn.updateViewLayout(this.bTw, this.bTv);
        }
    }

    private void aaV() {
        if (!this.bTA) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        aaV();
        if (bitmap != null) {
            al(i, i2);
            this.bTw = new ImageView(context);
            this.bTw.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        if (this.jn != null) {
                            this.jn.addView(this.bTw, this.bTv);
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

    private void aaW() {
        this.bTv = new WindowManager.LayoutParams();
        this.bTv.format = -3;
        this.bTv.gravity = 51;
        this.bTv.alpha = 1.0f;
        this.bTv.width = -2;
        this.bTv.height = -2;
        this.bTv.flags = 24;
    }

    private void al(int i, int i2) {
        if (this.bTv == null) {
            aaW();
        }
        this.bTv.x = i - (this.mWidth / 2);
        this.bTv.y = (i2 - (this.mHeight / 2)) - this.bTz;
    }

    public void aaX() {
        if (this.bTw != null) {
            if (this.jn != null) {
                this.jn.removeView(this.bTw);
            }
            this.bTw = null;
        }
        this.bTx = false;
    }
}
