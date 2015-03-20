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
    private static a aDb;
    private WindowManager.LayoutParams aCY;
    private ImageView aCZ;
    private boolean aDa;
    private int aDc;
    private boolean aDd;
    private int mHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a GL() {
        if (aDb == null) {
            synchronized (a.class) {
                if (aDb == null) {
                    aDb = new a();
                }
            }
        }
        return aDb;
    }

    private a() {
    }

    public void i(Context context, int i) {
        this.aDd = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.aDc = i;
    }

    public boolean GM() {
        return this.aDa;
    }

    public void a(Context context, View view, int i, int i2) {
        if (view != null) {
            this.aDa = true;
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
        GN();
        I(i, i2);
        this.mWindowManager.updateViewLayout(this.aCZ, this.aCY);
    }

    private void GN() {
        if (!this.aDd) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        GN();
        if (bitmap != null) {
            I(i, i2);
            this.aCZ = new ImageView(context);
            this.aCZ.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && c(activity.getWindow().getDecorView())) {
                    try {
                        this.mWindowManager.addView(this.aCZ, this.aCY);
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

    private void GO() {
        this.aCY = new WindowManager.LayoutParams();
        this.aCY.format = -3;
        this.aCY.gravity = 51;
        this.aCY.alpha = 1.0f;
        this.aCY.width = -2;
        this.aCY.height = -2;
        this.aCY.flags = 24;
    }

    private void I(int i, int i2) {
        if (this.aCY == null) {
            GO();
        }
        this.aCY.x = i - (this.mWidth / 2);
        this.aCY.y = (i2 - (this.mHeight / 2)) - this.aDc;
    }

    public void GP() {
        if (this.aCZ != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.aCZ);
            }
            this.aCZ = null;
        }
        this.aDa = false;
    }
}
