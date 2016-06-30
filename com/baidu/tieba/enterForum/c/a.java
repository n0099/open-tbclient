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
    private static a btL;
    private WindowManager bC;
    private WindowManager.LayoutParams btI;
    private ImageView btJ;
    private boolean btK;
    private int btM;
    private boolean btN;
    private int mHeight;
    private int mWidth;

    public static a Sk() {
        if (btL == null) {
            synchronized (a.class) {
                if (btL == null) {
                    btL = new a();
                }
            }
        }
        return btL;
    }

    private a() {
    }

    public void i(Context context, int i) {
        this.btN = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.bC = (WindowManager) context.getSystemService("window");
        this.btM = i;
    }

    public void destroy() {
        this.btN = false;
        btL = null;
    }

    public boolean Sl() {
        return this.btK;
    }

    public void a(Context context, View view, int i, int i2) {
        if (view != null) {
            this.btK = true;
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

    public void V(int i, int i2) {
        Sm();
        W(i, i2);
        this.bC.updateViewLayout(this.btJ, this.btI);
    }

    private void Sm() {
        if (!this.btN) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        Sm();
        if (bitmap != null) {
            W(i, i2);
            this.btJ = new ImageView(context);
            this.btJ.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        this.bC.addView(this.btJ, this.btI);
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

    private void Sn() {
        this.btI = new WindowManager.LayoutParams();
        this.btI.format = -3;
        this.btI.gravity = 51;
        this.btI.alpha = 1.0f;
        this.btI.width = -2;
        this.btI.height = -2;
        this.btI.flags = 24;
    }

    private void W(int i, int i2) {
        if (this.btI == null) {
            Sn();
        }
        this.btI.x = i - (this.mWidth / 2);
        this.btI.y = (i2 - (this.mHeight / 2)) - this.btM;
    }

    public void So() {
        if (this.btJ != null) {
            if (this.bC != null) {
                this.bC.removeView(this.btJ);
            }
            this.btJ = null;
        }
        this.btK = false;
    }
}
