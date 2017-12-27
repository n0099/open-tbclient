package com.baidu.tieba.enterForum.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes2.dex */
public class a {
    private static a dim;
    private WindowManager.LayoutParams dij;
    private ImageView dik;
    private boolean dil;
    private int din;
    private boolean dio;
    private int mHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a aoL() {
        if (dim == null) {
            synchronized (a.class) {
                if (dim == null) {
                    dim = new a();
                }
            }
        }
        return dim;
    }

    private a() {
    }

    public void y(Context context, int i) {
        this.dio = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.din = i;
    }

    public void destroy() {
        this.dio = false;
        dim = null;
    }

    public boolean aoM() {
        return this.dil;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.dil = true;
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

    public void bs(int i, int i2) {
        aoN();
        bt(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.dik, this.dij);
        }
    }

    private void aoN() {
        if (!this.dio) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        aoN();
        if (bitmap != null) {
            bt(i, i2);
            this.dik = new ImageView(context);
            this.dik.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && aH(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.dik, this.dij);
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

    private boolean aH(View view) {
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

    private void aoO() {
        this.dij = new WindowManager.LayoutParams();
        this.dij.format = -3;
        this.dij.gravity = 51;
        this.dij.alpha = 1.0f;
        this.dij.width = -2;
        this.dij.height = -2;
        this.dij.flags = 24;
    }

    private void bt(int i, int i2) {
        if (this.dij == null) {
            aoO();
        }
        this.dij.x = i - (this.mWidth / 2);
        this.dij.y = (i2 - (this.mHeight / 2)) - this.din;
    }

    public void aoP() {
        if (this.dik != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.dik);
            }
            this.dik = null;
        }
        this.dil = false;
    }
}
