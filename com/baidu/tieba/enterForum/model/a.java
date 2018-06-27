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
    private static a cQF;
    private WindowManager.LayoutParams cQD;
    private ImageView cQE;
    private int cQG;
    private boolean cQH;
    private int mHeight;
    private boolean mIsDragging;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a aoy() {
        if (cQF == null) {
            synchronized (a.class) {
                if (cQF == null) {
                    cQF = new a();
                }
            }
        }
        return cQF;
    }

    private a() {
    }

    public void k(Context context, int i) {
        this.cQH = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.cQG = i;
    }

    public void destroy() {
        this.cQH = false;
        cQF = null;
    }

    public boolean isDragging() {
        return this.mIsDragging;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.mIsDragging = true;
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

    public void au(int i, int i2) {
        aoz();
        av(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.cQE, this.cQD);
        }
    }

    private void aoz() {
        if (!this.cQH) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        aoz();
        if (bitmap != null) {
            av(i, i2);
            this.cQE = new ImageView(context);
            this.cQE.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.cQE, this.cQD);
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

    private void aoA() {
        this.cQD = new WindowManager.LayoutParams();
        this.cQD.format = -3;
        this.cQD.gravity = 51;
        this.cQD.alpha = 1.0f;
        this.cQD.width = -2;
        this.cQD.height = -2;
        this.cQD.flags = 24;
    }

    private void av(int i, int i2) {
        if (this.cQD == null) {
            aoA();
        }
        this.cQD.x = i - (this.mWidth / 2);
        this.cQD.y = (i2 - (this.mHeight / 2)) - this.cQG;
    }

    public void aoB() {
        if (this.cQE != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.cQE);
            }
            this.cQE = null;
        }
        this.mIsDragging = false;
    }
}
