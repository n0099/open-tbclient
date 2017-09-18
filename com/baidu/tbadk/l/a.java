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
    private b aIK;
    private InterfaceC0062a aIL = null;
    private WindowManager mWindowManager;

    /* renamed from: com.baidu.tbadk.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0062a {
        void ff(int i);
    }

    public a(Context context) {
        this.aIK = null;
        this.mWindowManager = null;
        this.aIK = new b(context);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
    }

    private void Gb() {
        try {
            this.mWindowManager.removeView(this.aIK);
        } catch (Throwable th) {
        }
    }

    private void Gc() {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 0, -3);
            layoutParams.gravity = 51;
            layoutParams.height = 1;
            layoutParams.width = 1;
            this.mWindowManager.addView(this.aIK, layoutParams);
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
                    a.this.aIK.invalidate();
                    a.this.aIK.post(this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ImageView {
        private int aIN;
        private final Paint mPaint;
        private long mStartTime;

        public b(Context context) {
            super(context);
            this.mStartTime = -1L;
            this.aIN = 0;
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
                this.aIN = 0;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            super.draw(canvas);
            if (elapsedRealtime - this.mStartTime > 1000) {
                this.mStartTime = elapsedRealtime;
                if (a.this.aIL != null) {
                    a.this.aIL.ff(this.aIN);
                } else {
                    com.baidu.adp.a.a.d.F(this.aIN);
                }
                this.aIN = 0;
            }
            this.aIN++;
        }
    }

    public void a(InterfaceC0062a interfaceC0062a) {
        if (this.aIL == null) {
            this.aIL = interfaceC0062a;
        }
    }
}
