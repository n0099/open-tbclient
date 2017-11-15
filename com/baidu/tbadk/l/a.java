package com.baidu.tbadk.l;

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
    private b aIQ;
    private InterfaceC0061a aIR = null;
    private WindowManager mWindowManager;

    /* renamed from: com.baidu.tbadk.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0061a {
        void fp(int i);
    }

    public a(Context context) {
        this.aIQ = null;
        this.mWindowManager = null;
        this.aIQ = new b(context);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
    }

    private void FX() {
        try {
            this.mWindowManager.removeView(this.aIQ);
        } catch (Throwable th) {
        }
    }

    private void FY() {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 0, -3);
            layoutParams.gravity = 51;
            layoutParams.height = 1;
            layoutParams.width = 1;
            this.mWindowManager.addView(this.aIQ, layoutParams);
        } catch (Throwable th) {
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        FX();
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        super.start();
        FX();
        FY();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tbadk.l.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ck()) {
                    a.this.aIQ.invalidate();
                    a.this.aIQ.post(this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ImageView {
        private int aIT;
        private final Paint mPaint;
        private long mStartTime;

        public b(Context context) {
            super(context);
            this.mStartTime = -1L;
            this.aIT = 0;
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
                this.aIT = 0;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            super.draw(canvas);
            if (elapsedRealtime - this.mStartTime > 1000) {
                this.mStartTime = elapsedRealtime;
                if (a.this.aIR != null) {
                    a.this.aIR.fp(this.aIT);
                } else {
                    com.baidu.adp.a.a.d.F(this.aIT);
                }
                this.aIT = 0;
            }
            this.aIT++;
        }
    }

    public void a(InterfaceC0061a interfaceC0061a) {
        if (this.aIR == null) {
            this.aIR = interfaceC0061a;
        }
    }
}
