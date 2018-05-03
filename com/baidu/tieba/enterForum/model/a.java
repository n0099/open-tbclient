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
    private static a cIs;
    private WindowManager.LayoutParams cIq;
    private ImageView cIr;
    private int cIt;
    private boolean cIu;
    private int mHeight;
    private boolean mIsDragging;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a akX() {
        if (cIs == null) {
            synchronized (a.class) {
                if (cIs == null) {
                    cIs = new a();
                }
            }
        }
        return cIs;
    }

    private a() {
    }

    public void k(Context context, int i) {
        this.cIu = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.cIt = i;
    }

    public void destroy() {
        this.cIu = false;
        cIs = null;
    }

    public boolean akY() {
        return this.mIsDragging;
    }

    public void a(Context context, View view2, int i, int i2) {
        Bitmap createBitmap;
        if (view2 != null) {
            this.mIsDragging = true;
            view2.setPressed(true);
            view2.setDrawingCacheEnabled(true);
            Bitmap drawingCache = view2.getDrawingCache();
            if (drawingCache != null && (createBitmap = Bitmap.createBitmap(drawingCache)) != null) {
                this.mWidth = createBitmap.getWidth();
                this.mHeight = createBitmap.getHeight();
                a(context, createBitmap, i, i2);
                view2.destroyDrawingCache();
                view2.setDrawingCacheEnabled(false);
            }
        }
    }

    public void at(int i, int i2) {
        akZ();
        au(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.cIr, this.cIq);
        }
    }

    private void akZ() {
        if (!this.cIu) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        akZ();
        if (bitmap != null) {
            au(i, i2);
            this.cIr = new ImageView(context);
            this.cIr.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.cIr, this.cIq);
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

    private boolean p(View view2) {
        IBinder windowToken;
        if (view2 != null && (windowToken = view2.getWindowToken()) != null) {
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

    private void ala() {
        this.cIq = new WindowManager.LayoutParams();
        this.cIq.format = -3;
        this.cIq.gravity = 51;
        this.cIq.alpha = 1.0f;
        this.cIq.width = -2;
        this.cIq.height = -2;
        this.cIq.flags = 24;
    }

    private void au(int i, int i2) {
        if (this.cIq == null) {
            ala();
        }
        this.cIq.x = i - (this.mWidth / 2);
        this.cIq.y = (i2 - (this.mHeight / 2)) - this.cIt;
    }

    public void alb() {
        if (this.cIr != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.cIr);
            }
            this.cIr = null;
        }
        this.mIsDragging = false;
    }
}
