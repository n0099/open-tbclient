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
    private static a cTs;
    private WindowManager.LayoutParams cTp;
    private ImageView cTq;
    private boolean cTr;
    private int cTt;
    private boolean cTu;
    private int mHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a aoY() {
        if (cTs == null) {
            synchronized (a.class) {
                if (cTs == null) {
                    cTs = new a();
                }
            }
        }
        return cTs;
    }

    private a() {
    }

    public void l(Context context, int i) {
        this.cTu = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.cTt = i;
    }

    public void destroy() {
        this.cTu = false;
        cTs = null;
    }

    public boolean isDragging() {
        return this.cTr;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.cTr = true;
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

    public void ax(int i, int i2) {
        aoZ();
        ay(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.cTq, this.cTp);
        }
    }

    private void aoZ() {
        if (!this.cTu) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        aoZ();
        if (bitmap != null) {
            ay(i, i2);
            this.cTq = new ImageView(context);
            this.cTq.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.cTq, this.cTp);
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

    private void apa() {
        this.cTp = new WindowManager.LayoutParams();
        this.cTp.format = -3;
        this.cTp.gravity = 51;
        this.cTp.alpha = 1.0f;
        this.cTp.width = -2;
        this.cTp.height = -2;
        this.cTp.flags = 24;
    }

    private void ay(int i, int i2) {
        if (this.cTp == null) {
            apa();
        }
        this.cTp.x = i - (this.mWidth / 2);
        this.cTp.y = (i2 - (this.mHeight / 2)) - this.cTt;
    }

    public void apb() {
        if (this.cTq != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.cTq);
            }
            this.cTq = null;
        }
        this.cTr = false;
    }
}
