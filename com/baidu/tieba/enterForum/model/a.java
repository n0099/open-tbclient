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
    private static a cdt;
    private WindowManager.LayoutParams cdq;
    private ImageView cdr;
    private boolean cds;
    private int cdu;
    private boolean cdv;
    private int mHeight;
    private int mWidth;
    private WindowManager mWindowManager;

    public static a adm() {
        if (cdt == null) {
            synchronized (a.class) {
                if (cdt == null) {
                    cdt = new a();
                }
            }
        }
        return cdt;
    }

    private a() {
    }

    public void n(Context context, int i) {
        this.cdv = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.cdu = i;
    }

    public void destroy() {
        this.cdv = false;
        cdt = null;
    }

    public boolean adn() {
        return this.cds;
    }

    public void a(Context context, View view, int i, int i2) {
        Bitmap createBitmap;
        if (view != null) {
            this.cds = true;
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

    public void an(int i, int i2) {
        ado();
        ao(i, i2);
        if (this.mWindowManager != null) {
            this.mWindowManager.updateViewLayout(this.cdr, this.cdq);
        }
    }

    private void ado() {
        if (!this.cdv) {
            BdLog.e("should do init first!");
        }
    }

    private void a(Context context, Bitmap bitmap, int i, int i2) {
        ado();
        if (bitmap != null) {
            ao(i, i2);
            this.cdr = new ImageView(context);
            this.cdr.setImageBitmap(bitmap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && activity.getWindow() != null && p(activity.getWindow().getDecorView())) {
                    try {
                        if (this.mWindowManager != null) {
                            this.mWindowManager.addView(this.cdr, this.cdq);
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

    private void adp() {
        this.cdq = new WindowManager.LayoutParams();
        this.cdq.format = -3;
        this.cdq.gravity = 51;
        this.cdq.alpha = 1.0f;
        this.cdq.width = -2;
        this.cdq.height = -2;
        this.cdq.flags = 24;
    }

    private void ao(int i, int i2) {
        if (this.cdq == null) {
            adp();
        }
        this.cdq.x = i - (this.mWidth / 2);
        this.cdq.y = (i2 - (this.mHeight / 2)) - this.cdu;
    }

    public void adq() {
        if (this.cdr != null) {
            if (this.mWindowManager != null) {
                this.mWindowManager.removeView(this.cdr);
            }
            this.cdr = null;
        }
        this.cds = false;
    }
}
