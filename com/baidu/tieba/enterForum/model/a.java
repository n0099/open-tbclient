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
    private static a dqc;
    private WindowManager.LayoutParams dpZ;
    private ImageView dqa;
    private boolean dqb;
    private int dqd;
    private boolean dqe;
    private int mHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a aqJ() {
        if (dqc == null) {
            synchronized (a.class) {
                if (dqc == null) {
                    dqc = new a();
                }
            }
        }
        return dqc;
    }

    private a() {
    }

    public void z(Context context, int i) {
        this.dqe = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.dqd = i;
    }

    public void destroy() {
        this.dqe = false;
        dqc = null;
    }

    public boolean aqK() {
        return this.dqb;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.dqb = true;
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

    public void bq(int i, int i2) {
        aqL();
        br(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.dqa, this.dpZ);
        }
    }

    private void aqL() {
        if (!this.dqe) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        aqL();
        if (bitmap != null) {
            br(i, i2);
            this.dqa = new ImageView(context);
            this.dqa.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && aH(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.dqa, this.dpZ);
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

    private void aqM() {
        this.dpZ = new WindowManager.LayoutParams();
        this.dpZ.format = -3;
        this.dpZ.gravity = 51;
        this.dpZ.alpha = 1.0f;
        this.dpZ.width = -2;
        this.dpZ.height = -2;
        this.dpZ.flags = 24;
    }

    private void br(int i, int i2) {
        if (this.dpZ == null) {
            aqM();
        }
        this.dpZ.x = i - (this.mWidth / 2);
        this.dpZ.y = (i2 - (this.mHeight / 2)) - this.dqd;
    }

    public void aqN() {
        if (this.dqa != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.dqa);
            }
            this.dqa = null;
        }
        this.dqb = false;
    }
}
