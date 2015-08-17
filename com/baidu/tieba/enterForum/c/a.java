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
    private static a aML;
    private WindowManager.LayoutParams aMI;
    private ImageView aMJ;
    private boolean aMK;
    private int aMM;
    private boolean aMN;
    private WindowManager lB;
    private int mHeight;
    private int mWidth;

    public static a IH() {
        if (aML == null) {
            synchronized (a.class) {
                if (aML == null) {
                    aML = new a();
                }
            }
        }
        return aML;
    }

    private a() {
    }

    public void j(Context context, int i) {
        this.aMN = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.lB = (WindowManager) context.getSystemService("window");
        this.aMM = i;
    }

    public void destroy() {
        this.aMN = false;
        aML = null;
    }

    public boolean II() {
        return this.aMK;
    }

    public void a(Context context, View view, int i, int i2) {
        if (view != null) {
            this.aMK = true;
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
        IJ();
        T(i, i2);
        this.lB.updateViewLayout(this.aMJ, this.aMI);
    }

    private void IJ() {
        if (!this.aMN) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        IJ();
        if (bitmap != null) {
            T(i, i2);
            this.aMJ = new ImageView(context);
            this.aMJ.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && d(activity.getWindow().getDecorView())) {
                    try {
                        this.lB.addView(this.aMJ, this.aMI);
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

    private void IK() {
        this.aMI = new WindowManager.LayoutParams();
        this.aMI.format = -3;
        this.aMI.gravity = 51;
        this.aMI.alpha = 1.0f;
        this.aMI.width = -2;
        this.aMI.height = -2;
        this.aMI.flags = 24;
    }

    private void T(int i, int i2) {
        if (this.aMI == null) {
            IK();
        }
        this.aMI.x = i - (this.mWidth / 2);
        this.aMI.y = (i2 - (this.mHeight / 2)) - this.aMM;
    }

    public void IL() {
        if (this.aMJ != null) {
            if (this.lB != null) {
                this.lB.removeView(this.aMJ);
            }
            this.aMJ = null;
        }
        this.aMK = false;
    }
}
