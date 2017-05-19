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
    private b aFJ;
    private InterfaceC0048a aFK = null;
    private WindowManager jn;

    /* renamed from: com.baidu.tbadk.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0048a {
        void eX(int i);
    }

    public a(Context context) {
        this.aFJ = null;
        this.jn = null;
        this.aFJ = new b(context);
        this.jn = (WindowManager) context.getSystemService("window");
    }

    private void Fo() {
        try {
            this.jn.removeView(this.aFJ);
        } catch (Throwable th) {
        }
    }

    private void Fp() {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 0, -3);
            layoutParams.gravity = 51;
            layoutParams.height = 1;
            layoutParams.width = 1;
            this.jn.addView(this.aFJ, layoutParams);
        } catch (Throwable th) {
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        Fo();
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        super.start();
        Fo();
        Fp();
        new Handler(Looper.getMainLooper()).post(new com.baidu.tbadk.j.b(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ImageView {
        private int aFM;
        private final Paint mPaint;
        private long mStartTime;

        public b(Context context) {
            super(context);
            this.mStartTime = -1L;
            this.aFM = 0;
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
                this.aFM = 0;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            super.draw(canvas);
            if (elapsedRealtime - this.mStartTime > 1000) {
                this.mStartTime = elapsedRealtime;
                if (a.this.aFK != null) {
                    a.this.aFK.eX(this.aFM);
                } else {
                    com.baidu.adp.a.a.d.F(this.aFM);
                }
                this.aFM = 0;
            }
            this.aFM++;
        }
    }

    public void a(InterfaceC0048a interfaceC0048a) {
        if (this.aFK == null) {
            this.aFK = interfaceC0048a;
        }
    }
}
