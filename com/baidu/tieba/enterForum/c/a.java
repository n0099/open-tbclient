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
    private static a bbH;
    private WindowManager.LayoutParams bbE;
    private ImageView bbF;
    private boolean bbG;
    private int bbI;
    private boolean bbJ;
    private WindowManager lB;
    private int mHeight;
    private int mWidth;

    public static a NT() {
        if (bbH == null) {
            synchronized (a.class) {
                if (bbH == null) {
                    bbH = new a();
                }
            }
        }
        return bbH;
    }

    private a() {
    }

    public void h(Context context, int i) {
        this.bbJ = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.lB = (WindowManager) context.getSystemService("window");
        this.bbI = i;
    }

    public void destroy() {
        this.bbJ = false;
        bbH = null;
    }

    public boolean NU() {
        return this.bbG;
    }

    public void a(Context context, View view, int i, int i2) {
        if (view != null) {
            this.bbG = true;
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

    public void Q(int i, int i2) {
        NV();
        R(i, i2);
        this.lB.updateViewLayout(this.bbF, this.bbE);
    }

    private void NV() {
        if (!this.bbJ) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        NV();
        if (bitmap != null) {
            R(i, i2);
            this.bbF = new ImageView(context);
            this.bbF.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        this.lB.addView(this.bbF, this.bbE);
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

    private void NW() {
        this.bbE = new WindowManager.LayoutParams();
        this.bbE.format = -3;
        this.bbE.gravity = 51;
        this.bbE.alpha = 1.0f;
        this.bbE.width = -2;
        this.bbE.height = -2;
        this.bbE.flags = 24;
    }

    private void R(int i, int i2) {
        if (this.bbE == null) {
            NW();
        }
        this.bbE.x = i - (this.mWidth / 2);
        this.bbE.y = (i2 - (this.mHeight / 2)) - this.bbI;
    }

    public void NX() {
        if (this.bbF != null) {
            if (this.lB != null) {
                this.lB.removeView(this.bbF);
            }
            this.bbF = null;
        }
        this.bbG = false;
    }
}
