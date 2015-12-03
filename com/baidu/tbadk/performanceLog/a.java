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
    private b axp;
    private InterfaceC0055a axq = null;
    private WindowManager lB;

    /* renamed from: com.baidu.tbadk.performanceLog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0055a {
        void eI(int i);
    }

    public a(Context context) {
        this.axp = null;
        this.lB = null;
        this.axp = new b(context);
        this.lB = (WindowManager) context.getSystemService("window");
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            this.lB.removeView(this.axp);
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        super.start();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 0, -3);
        layoutParams.gravity = 51;
        layoutParams.height = 1;
        layoutParams.width = 1;
        try {
            this.lB.removeView(this.axp);
        } catch (Exception e) {
        }
        this.lB.addView(this.axp, layoutParams);
        new Handler(Looper.getMainLooper()).post(new com.baidu.tbadk.performanceLog.b(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ImageView {
        private int axs;
        private final Paint mPaint;
        private long mStartTime;

        public b(Context context) {
            super(context);
            this.mStartTime = -1L;
            this.axs = 0;
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
                this.axs = 0;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            super.draw(canvas);
            if (elapsedRealtime - this.mStartTime > 1000) {
                this.mStartTime = elapsedRealtime;
                if (a.this.axq != null) {
                    a.this.axq.eI(this.axs);
                } else {
                    com.baidu.adp.a.a.d.s(this.axs);
                }
                this.axs = 0;
            }
            this.axs++;
        }
    }

    public void a(InterfaceC0055a interfaceC0055a) {
        if (this.axq == null) {
            this.axq = interfaceC0055a;
        }
    }
}
