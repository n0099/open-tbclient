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
    private b aBp;
    private InterfaceC0048a aBq = null;
    private WindowManager bC;

    /* renamed from: com.baidu.tbadk.performanceLog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0048a {
        void fb(int i);
    }

    public a(Context context) {
        this.aBp = null;
        this.bC = null;
        this.aBp = new b(context);
        this.bC = (WindowManager) context.getSystemService("window");
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            this.bC.removeView(this.aBp);
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
            this.bC.removeView(this.aBp);
        } catch (Exception e) {
        }
        this.bC.addView(this.aBp, layoutParams);
        new Handler(Looper.getMainLooper()).post(new com.baidu.tbadk.performanceLog.b(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ImageView {
        private int aBs;
        private final Paint mPaint;
        private long mStartTime;

        public b(Context context) {
            super(context);
            this.mStartTime = -1L;
            this.aBs = 0;
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
                this.aBs = 0;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            super.draw(canvas);
            if (elapsedRealtime - this.mStartTime > 1000) {
                this.mStartTime = elapsedRealtime;
                if (a.this.aBq != null) {
                    a.this.aBq.fb(this.aBs);
                } else {
                    com.baidu.adp.a.a.d.G(this.aBs);
                }
                this.aBs = 0;
            }
            this.aBs++;
        }
    }

    public void a(InterfaceC0048a interfaceC0048a) {
        if (this.aBq == null) {
            this.aBq = interfaceC0048a;
        }
    }
}
