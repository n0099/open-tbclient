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
    private b awC;
    private InterfaceC0047a awD = null;
    private WindowManager bC;

    /* renamed from: com.baidu.tbadk.performanceLog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0047a {
        void eI(int i);
    }

    public a(Context context) {
        this.awC = null;
        this.bC = null;
        this.awC = new b(context);
        this.bC = (WindowManager) context.getSystemService("window");
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            this.bC.removeView(this.awC);
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
            this.bC.removeView(this.awC);
        } catch (Exception e) {
        }
        this.bC.addView(this.awC, layoutParams);
        new Handler(Looper.getMainLooper()).post(new com.baidu.tbadk.performanceLog.b(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ImageView {
        private int awF;
        private final Paint mPaint;
        private long mStartTime;

        public b(Context context) {
            super(context);
            this.mStartTime = -1L;
            this.awF = 0;
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
                this.awF = 0;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            super.draw(canvas);
            if (elapsedRealtime - this.mStartTime > 1000) {
                this.mStartTime = elapsedRealtime;
                if (a.this.awD != null) {
                    a.this.awD.eI(this.awF);
                } else {
                    com.baidu.adp.a.a.d.q(this.awF);
                }
                this.awF = 0;
            }
            this.awF++;
        }
    }

    public void a(InterfaceC0047a interfaceC0047a) {
        if (this.awD == null) {
            this.awD = interfaceC0047a;
        }
    }
}
