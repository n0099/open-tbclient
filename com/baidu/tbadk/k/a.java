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
    private b aJY;
    private InterfaceC0101a aJZ = null;
    private WindowManager mWindowManager;

    /* renamed from: com.baidu.tbadk.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0101a {
        void fg(int i);
    }

    public a(Context context) {
        this.aJY = null;
        this.mWindowManager = null;
        this.aJY = new b(context);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
    }

    private void GC() {
        try {
            this.mWindowManager.removeView(this.aJY);
        } catch (Throwable th) {
        }
    }

    private void GD() {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 0, -3);
            layoutParams.gravity = 51;
            layoutParams.height = 1;
            layoutParams.width = 1;
            this.mWindowManager.addView(this.aJY, layoutParams);
        } catch (Throwable th) {
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        GC();
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        super.start();
        GC();
        GD();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tbadk.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bT()) {
                    a.this.aJY.invalidate();
                    a.this.aJY.post(this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ImageView {
        private int aKb;
        private final Paint mPaint;
        private long mStartTime;

        public b(Context context) {
            super(context);
            this.mStartTime = -1L;
            this.aKb = 0;
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
                this.aKb = 0;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            super.draw(canvas);
            if (elapsedRealtime - this.mStartTime > 1000) {
                this.mStartTime = elapsedRealtime;
                if (a.this.aJZ != null) {
                    a.this.aJZ.fg(this.aKb);
                } else {
                    com.baidu.adp.a.a.d.y(this.aKb);
                }
                this.aKb = 0;
            }
            this.aKb++;
        }
    }

    public void a(InterfaceC0101a interfaceC0101a) {
        if (this.aJZ == null) {
            this.aJZ = interfaceC0101a;
        }
    }
}
