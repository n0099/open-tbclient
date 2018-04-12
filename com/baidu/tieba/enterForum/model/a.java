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
    private static a cIv;
    private WindowManager.LayoutParams cIt;
    private ImageView cIu;
    private int cIw;
    private boolean cIx;
    private int mHeight;
    private boolean mIsDragging;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a akX() {
        if (cIv == null) {
            synchronized (a.class) {
                if (cIv == null) {
                    cIv = new a();
                }
            }
        }
        return cIv;
    }

    private a() {
    }

    public void k(Context context, int i) {
        this.cIx = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.cIw = i;
    }

    public void destroy() {
        this.cIx = false;
        cIv = null;
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

    public void au(int i, int i2) {
        akZ();
        av(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.cIu, this.cIt);
        }
    }

    private void akZ() {
        if (!this.cIx) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        akZ();
        if (bitmap != null) {
            av(i, i2);
            this.cIu = new ImageView(context);
            this.cIu.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.cIu, this.cIt);
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
        this.cIt = new WindowManager.LayoutParams();
        this.cIt.format = -3;
        this.cIt.gravity = 51;
        this.cIt.alpha = 1.0f;
        this.cIt.width = -2;
        this.cIt.height = -2;
        this.cIt.flags = 24;
    }

    private void av(int i, int i2) {
        if (this.cIt == null) {
            ala();
        }
        this.cIt.x = i - (this.mWidth / 2);
        this.cIt.y = (i2 - (this.mHeight / 2)) - this.cIw;
    }

    public void alb() {
        if (this.cIu != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.cIu);
            }
            this.cIu = null;
        }
        this.mIsDragging = false;
    }
}
