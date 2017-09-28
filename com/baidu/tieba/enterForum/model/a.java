package com.baidu.tieba.enterForum.model;

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
    private static a cdu;
    private WindowManager.LayoutParams cdr;
    private ImageView cds;
    private boolean cdt;
    private int cdv;
    private boolean cdw;
    private int mHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a acZ() {
        if (cdu == null) {
            synchronized (a.class) {
                if (cdu == null) {
                    cdu = new a();
                }
            }
        }
        return cdu;
    }

    private a() {
    }

    public void m(Context context, int i) {
        this.cdw = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.cdv = i;
    }

    public void destroy() {
        this.cdw = false;
        cdu = null;
    }

    public boolean ada() {
        return this.cdt;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.cdt = true;
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

    public void as(int i, int i2) {
        adb();
        at(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.cds, this.cdr);
        }
    }

    private void adb() {
        if (!this.cdw) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        adb();
        if (bitmap != null) {
            at(i, i2);
            this.cds = new ImageView(context);
            this.cds.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.cds, this.cdr);
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

    private void adc() {
        this.cdr = new WindowManager.LayoutParams();
        this.cdr.format = -3;
        this.cdr.gravity = 51;
        this.cdr.alpha = 1.0f;
        this.cdr.width = -2;
        this.cdr.height = -2;
        this.cdr.flags = 24;
    }

    private void at(int i, int i2) {
        if (this.cdr == null) {
            adc();
        }
        this.cdr.x = i - (this.mWidth / 2);
        this.cdr.y = (i2 - (this.mHeight / 2)) - this.cdv;
    }

    public void add() {
        if (this.cds != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.cds);
            }
            this.cds = null;
        }
        this.cdt = false;
    }
}
