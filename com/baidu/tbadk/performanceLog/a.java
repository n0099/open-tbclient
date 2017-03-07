package com.baidu.tbadk.performanceLog;

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
    private b aFn;
    private InterfaceC0046a aFo = null;
    private WindowManager jn;

    /* renamed from: com.baidu.tbadk.performanceLog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0046a {
        void eY(int i);
    }

    public a(Context context) {
        this.aFn = null;
        this.jn = null;
        this.aFn = new b(context);
        this.jn = (WindowManager) context.getSystemService("window");
    }

    private void FM() {
        try {
            this.jn.removeView(this.aFn);
        } catch (Throwable th) {
        }
    }

    private void FN() {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 0, -3);
            layoutParams.gravity = 51;
            layoutParams.height = 1;
            layoutParams.width = 1;
            this.jn.addView(this.aFn, layoutParams);
        } catch (Throwable th) {
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        FM();
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        super.start();
        FM();
        FN();
        new Handler(Looper.getMainLooper()).post(new com.baidu.tbadk.performanceLog.b(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ImageView {
        private int aFq;
        private final Paint mPaint;
        private long mStartTime;

        public b(Context context) {
            super(context);
            this.mStartTime = -1L;
            this.aFq = 0;
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
                this.aFq = 0;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            super.draw(canvas);
            if (elapsedRealtime - this.mStartTime > 1000) {
                this.mStartTime = elapsedRealtime;
                if (a.this.aFo != null) {
                    a.this.aFo.eY(this.aFq);
                } else {
                    com.baidu.adp.a.a.d.H(this.aFq);
                }
                this.aFq = 0;
            }
            this.aFq++;
        }
    }

    public void a(InterfaceC0046a interfaceC0046a) {
        if (this.aFo == null) {
            this.aFo = interfaceC0046a;
        }
    }
}
