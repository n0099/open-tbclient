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
    private b bxm;
    private InterfaceC0088a bxn = null;
    private WindowManager mWindowManager;

    /* renamed from: com.baidu.tbadk.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0088a {
        void in(int i);
    }

    public a(Context context) {
        this.bxm = null;
        this.mWindowManager = null;
        this.bxm = new b(context);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
    }

    private void NE() {
        try {
            this.mWindowManager.removeView(this.bxm);
        } catch (Throwable th) {
        }
    }

    private void NF() {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 0, -3);
            layoutParams.gravity = 51;
            layoutParams.height = 1;
            layoutParams.width = 1;
            this.mWindowManager.addView(this.bxm, layoutParams);
        } catch (Throwable th) {
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        NE();
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        super.start();
        NE();
        NF();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tbadk.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.jP()) {
                    a.this.bxm.invalidate();
                    a.this.bxm.post(this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ImageView {
        private int bxp;
        private final Paint mPaint;
        private long mStartTime;

        public b(Context context) {
            super(context);
            this.mStartTime = -1L;
            this.bxp = 0;
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
                this.bxp = 0;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            super.draw(canvas);
            if (elapsedRealtime - this.mStartTime > 1000) {
                this.mStartTime = elapsedRealtime;
                if (a.this.bxn != null) {
                    a.this.bxn.in(this.bxp);
                } else {
                    com.baidu.adp.a.a.d.cy(this.bxp);
                }
                this.bxp = 0;
            }
            this.bxp++;
        }
    }

    public void a(InterfaceC0088a interfaceC0088a) {
        if (this.bxn == null) {
            this.bxn = interfaceC0088a;
        }
    }
}
