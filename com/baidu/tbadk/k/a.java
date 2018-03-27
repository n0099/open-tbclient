package com.baidu.tbadk.k;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.WindowManager;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.a.a.a {
    private b bzB;
    private InterfaceC0112a bzC = null;
    private WindowManager mWindowManager;

    /* renamed from: com.baidu.tbadk.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0112a {
        void ig(int i);
    }

    public a(Context context) {
        this.bzB = null;
        this.mWindowManager = null;
        this.bzB = new b(context);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
    }

    private void Oa() {
        try {
            this.mWindowManager.removeView(this.bzB);
        } catch (Throwable th) {
        }
    }

    private void Ob() {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 0, -3);
            layoutParams.gravity = 51;
            layoutParams.height = 1;
            layoutParams.width = 1;
            this.mWindowManager.addView(this.bzB, layoutParams);
        } catch (Throwable th) {
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        Oa();
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        super.start();
        Oa();
        Ob();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tbadk.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.jP()) {
                    a.this.bzB.invalidate();
                    a.this.bzB.post(this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ImageView {
        private int bzE;
        private final Paint mPaint;
        private long mStartTime;

        public b(Context context) {
            super(context);
            this.mStartTime = -1L;
            this.bzE = 0;
            this.mPaint = new Paint();
            this.mPaint.setColor(0);
            this.mPaint.setAlpha(0);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setTextSize(1.0f);
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            if (this.mStartTime == -1) {
                this.mStartTime = SystemClock.elapsedRealtime();
                this.bzE = 0;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            super.draw(canvas);
            if (elapsedRealtime - this.mStartTime > 1000) {
                this.mStartTime = elapsedRealtime;
                if (a.this.bzC != null) {
                    a.this.bzC.ig(this.bzE);
                } else {
                    com.baidu.adp.a.a.d.cy(this.bzE);
                }
                this.bzE = 0;
            }
            this.bzE++;
        }
    }

    public void a(InterfaceC0112a interfaceC0112a) {
        if (this.bzC == null) {
            this.bzC = interfaceC0112a;
        }
    }
}
