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
    private b azV;
    private InterfaceC0047a azW = null;
    private WindowManager bC;

    /* renamed from: com.baidu.tbadk.performanceLog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0047a {
        void fe(int i);
    }

    public a(Context context) {
        this.azV = null;
        this.bC = null;
        this.azV = new b(context);
        this.bC = (WindowManager) context.getSystemService("window");
    }

    private void Fs() {
        try {
            this.bC.removeView(this.azV);
        } catch (Throwable th) {
        }
    }

    private void Ft() {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 0, -3);
            layoutParams.gravity = 51;
            layoutParams.height = 1;
            layoutParams.width = 1;
            this.bC.addView(this.azV, layoutParams);
        } catch (Throwable th) {
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        Fs();
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        super.start();
        Fs();
        Ft();
        new Handler(Looper.getMainLooper()).post(new com.baidu.tbadk.performanceLog.b(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ImageView {
        private int azY;
        private final Paint mPaint;
        private long mStartTime;

        public b(Context context) {
            super(context);
            this.mStartTime = -1L;
            this.azY = 0;
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
                this.azY = 0;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            super.draw(canvas);
            if (elapsedRealtime - this.mStartTime > 1000) {
                this.mStartTime = elapsedRealtime;
                if (a.this.azW != null) {
                    a.this.azW.fe(this.azY);
                } else {
                    com.baidu.adp.a.a.d.H(this.azY);
                }
                this.azY = 0;
            }
            this.azY++;
        }
    }

    public void a(InterfaceC0047a interfaceC0047a) {
        if (this.azW == null) {
            this.azW = interfaceC0047a;
        }
    }
}
