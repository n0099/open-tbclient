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
    private b aIN;
    private InterfaceC0063a aIO = null;
    private WindowManager mWindowManager;

    /* renamed from: com.baidu.tbadk.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0063a {
        void ff(int i);
    }

    public a(Context context) {
        this.aIN = null;
        this.mWindowManager = null;
        this.aIN = new b(context);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
    }

    private void Gb() {
        try {
            this.mWindowManager.removeView(this.aIN);
        } catch (Throwable th) {
        }
    }

    private void Gc() {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 0, -3);
            layoutParams.gravity = 51;
            layoutParams.height = 1;
            layoutParams.width = 1;
            this.mWindowManager.addView(this.aIN, layoutParams);
        } catch (Throwable th) {
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        Gb();
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        super.start();
        Gb();
        Gc();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tbadk.l.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ck()) {
                    a.this.aIN.invalidate();
                    a.this.aIN.post(this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ImageView {
        private int aIQ;
        private final Paint mPaint;
        private long mStartTime;

        public b(Context context) {
            super(context);
            this.mStartTime = -1L;
            this.aIQ = 0;
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
                this.aIQ = 0;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            super.draw(canvas);
            if (elapsedRealtime - this.mStartTime > 1000) {
                this.mStartTime = elapsedRealtime;
                if (a.this.aIO != null) {
                    a.this.aIO.ff(this.aIQ);
                } else {
                    com.baidu.adp.a.a.d.F(this.aIQ);
                }
                this.aIQ = 0;
            }
            this.aIQ++;
        }
    }

    public void a(InterfaceC0063a interfaceC0063a) {
        if (this.aIO == null) {
            this.aIO = interfaceC0063a;
        }
    }
}
