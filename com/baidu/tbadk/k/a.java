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
    private b bxv;
    private InterfaceC0087a bxw = null;
    private WindowManager mWindowManager;

    /* renamed from: com.baidu.tbadk.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0087a {
        void ij(int i);
    }

    public a(Context context) {
        this.bxv = null;
        this.mWindowManager = null;
        this.bxv = new b(context);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
    }

    private void Ns() {
        try {
            this.mWindowManager.removeView(this.bxv);
        } catch (Throwable th) {
        }
    }

    private void Nt() {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 0, -3);
            layoutParams.gravity = 51;
            layoutParams.height = 1;
            layoutParams.width = 1;
            this.mWindowManager.addView(this.bxv, layoutParams);
        } catch (Throwable th) {
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        Ns();
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        super.start();
        Ns();
        Nt();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tbadk.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.jP()) {
                    a.this.bxv.invalidate();
                    a.this.bxv.post(this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ImageView {
        private int bxy;
        private final Paint mPaint;
        private long mStartTime;

        public b(Context context) {
            super(context);
            this.mStartTime = -1L;
            this.bxy = 0;
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
                this.bxy = 0;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            super.draw(canvas);
            if (elapsedRealtime - this.mStartTime > 1000) {
                this.mStartTime = elapsedRealtime;
                if (a.this.bxw != null) {
                    a.this.bxw.ij(this.bxy);
                } else {
                    com.baidu.adp.a.a.d.cy(this.bxy);
                }
                this.bxy = 0;
            }
            this.bxy++;
        }
    }

    public void a(InterfaceC0087a interfaceC0087a) {
        if (this.bxw == null) {
            this.bxw = interfaceC0087a;
        }
    }
}
