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
    private static a aDj;
    private WindowManager.LayoutParams aDg;
    private ImageView aDh;
    private boolean aDi;
    private int aDk;
    private boolean aDl;
    private int mHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a GR() {
        if (aDj == null) {
            synchronized (a.class) {
                if (aDj == null) {
                    aDj = new a();
                }
            }
        }
        return aDj;
    }

    private a() {
    }

    public void i(Context context, int i) {
        this.aDl = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.aDk = i;
    }

    public boolean GS() {
        return this.aDi;
    }

    public void a(Context context, View view, int i, int i2) {
        if (view != null) {
            this.aDi = true;
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

    public void H(int i, int i2) {
        GT();
        I(i, i2);
        this.mWindowManager.updateViewLayout(this.aDh, this.aDg);
    }

    private void GT() {
        if (!this.aDl) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        GT();
        if (bitmap != null) {
            I(i, i2);
            this.aDh = new ImageView(context);
            this.aDh.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && c(activity.getWindow().getDecorView())) {
                    try {
                        this.mWindowManager.addView(this.aDh, this.aDg);
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

    private boolean c(View view) {
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

    private void GU() {
        this.aDg = new WindowManager.LayoutParams();
        this.aDg.format = -3;
        this.aDg.gravity = 51;
        this.aDg.alpha = 1.0f;
        this.aDg.width = -2;
        this.aDg.height = -2;
        this.aDg.flags = 24;
    }

    private void I(int i, int i2) {
        if (this.aDg == null) {
            GU();
        }
        this.aDg.x = i - (this.mWidth / 2);
        this.aDg.y = (i2 - (this.mHeight / 2)) - this.aDk;
    }

    public void GV() {
        if (this.aDh != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.aDh);
            }
            this.aDh = null;
        }
        this.aDi = false;
    }
}
