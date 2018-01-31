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
    private b bxE;
    private InterfaceC0088a bxF = null;
    private WindowManager mWindowManager;

    /* renamed from: com.baidu.tbadk.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0088a {
        void ij(int i);
    }

    public a(Context context) {
        this.bxE = null;
        this.mWindowManager = null;
        this.bxE = new b(context);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
    }

    private void Nu() {
        try {
            this.mWindowManager.removeView(this.bxE);
        } catch (Throwable th) {
        }
    }

    private void Nv() {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 0, -3);
            layoutParams.gravity = 51;
            layoutParams.height = 1;
            layoutParams.width = 1;
            this.mWindowManager.addView(this.bxE, layoutParams);
        } catch (Throwable th) {
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        Nu();
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        super.start();
        Nu();
        Nv();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tbadk.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.jP()) {
                    a.this.bxE.invalidate();
                    a.this.bxE.post(this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ImageView {
        private int bxH;
        private final Paint mPaint;
        private long mStartTime;

        public b(Context context) {
            super(context);
            this.mStartTime = -1L;
            this.bxH = 0;
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
                this.bxH = 0;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            super.draw(canvas);
            if (elapsedRealtime - this.mStartTime > 1000) {
                this.mStartTime = elapsedRealtime;
                if (a.this.bxF != null) {
                    a.this.bxF.ij(this.bxH);
                } else {
                    com.baidu.adp.a.a.d.cy(this.bxH);
                }
                this.bxH = 0;
            }
            this.bxH++;
        }
    }

    public void a(InterfaceC0088a interfaceC0088a) {
        if (this.bxF == null) {
            this.bxF = interfaceC0088a;
        }
    }
}
