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
    private b aJZ;
    private InterfaceC0101a aKa = null;
    private WindowManager mWindowManager;

    /* renamed from: com.baidu.tbadk.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0101a {
        void fg(int i);
    }

    public a(Context context) {
        this.aJZ = null;
        this.mWindowManager = null;
        this.aJZ = new b(context);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
    }

    private void GA() {
        try {
            this.mWindowManager.removeView(this.aJZ);
        } catch (Throwable th) {
        }
    }

    private void GB() {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 0, -3);
            layoutParams.gravity = 51;
            layoutParams.height = 1;
            layoutParams.width = 1;
            this.mWindowManager.addView(this.aJZ, layoutParams);
        } catch (Throwable th) {
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        GA();
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        super.start();
        GA();
        GB();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tbadk.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bT()) {
                    a.this.aJZ.invalidate();
                    a.this.aJZ.post(this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ImageView {
        private int aKc;
        private final Paint mPaint;
        private long mStartTime;

        public b(Context context) {
            super(context);
            this.mStartTime = -1L;
            this.aKc = 0;
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
                this.aKc = 0;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            super.draw(canvas);
            if (elapsedRealtime - this.mStartTime > 1000) {
                this.mStartTime = elapsedRealtime;
                if (a.this.aKa != null) {
                    a.this.aKa.fg(this.aKc);
                } else {
                    com.baidu.adp.a.a.d.y(this.aKc);
                }
                this.aKc = 0;
            }
            this.aKc++;
        }
    }

    public void a(InterfaceC0101a interfaceC0101a) {
        if (this.aKa == null) {
            this.aKa = interfaceC0101a;
        }
    }
}
