package com.baidu.tbadk.j;

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
    private b aGK;
    private InterfaceC0050a aGL = null;
    private WindowManager jn;

    /* renamed from: com.baidu.tbadk.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0050a {
        void fa(int i);
    }

    public a(Context context) {
        this.aGK = null;
        this.jn = null;
        this.aGK = new b(context);
        this.jn = (WindowManager) context.getSystemService("window");
    }

    private void FF() {
        try {
            this.jn.removeView(this.aGK);
        } catch (Throwable th) {
        }
    }

    private void FG() {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 0, -3);
            layoutParams.gravity = 51;
            layoutParams.height = 1;
            layoutParams.width = 1;
            this.jn.addView(this.aGK, layoutParams);
        } catch (Throwable th) {
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        FF();
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        super.start();
        FF();
        FG();
        new Handler(Looper.getMainLooper()).post(new com.baidu.tbadk.j.b(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ImageView {
        private int aGN;
        private final Paint mPaint;
        private long mStartTime;

        public b(Context context) {
            super(context);
            this.mStartTime = -1L;
            this.aGN = 0;
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
                this.aGN = 0;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            super.draw(canvas);
            if (elapsedRealtime - this.mStartTime > 1000) {
                this.mStartTime = elapsedRealtime;
                if (a.this.aGL != null) {
                    a.this.aGL.fa(this.aGN);
                } else {
                    com.baidu.adp.a.a.d.F(this.aGN);
                }
                this.aGN = 0;
            }
            this.aGN++;
        }
    }

    public void a(InterfaceC0050a interfaceC0050a) {
        if (this.aGL == null) {
            this.aGL = interfaceC0050a;
        }
    }
}
