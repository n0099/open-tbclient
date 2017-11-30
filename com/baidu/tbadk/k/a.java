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
    private b aJr;
    private InterfaceC0061a aJs = null;
    private WindowManager mWindowManager;

    /* renamed from: com.baidu.tbadk.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0061a {
        void fo(int i);
    }

    public a(Context context) {
        this.aJr = null;
        this.mWindowManager = null;
        this.aJr = new b(context);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
    }

    private void Ge() {
        try {
            this.mWindowManager.removeView(this.aJr);
        } catch (Throwable th) {
        }
    }

    private void Gf() {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 0, -3);
            layoutParams.gravity = 51;
            layoutParams.height = 1;
            layoutParams.width = 1;
            this.mWindowManager.addView(this.aJr, layoutParams);
        } catch (Throwable th) {
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        Ge();
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        super.start();
        Ge();
        Gf();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tbadk.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ck()) {
                    a.this.aJr.invalidate();
                    a.this.aJr.post(this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ImageView {
        private int aJu;
        private final Paint mPaint;
        private long mStartTime;

        public b(Context context) {
            super(context);
            this.mStartTime = -1L;
            this.aJu = 0;
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
                this.aJu = 0;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            super.draw(canvas);
            if (elapsedRealtime - this.mStartTime > 1000) {
                this.mStartTime = elapsedRealtime;
                if (a.this.aJs != null) {
                    a.this.aJs.fo(this.aJu);
                } else {
                    com.baidu.adp.a.a.d.F(this.aJu);
                }
                this.aJu = 0;
            }
            this.aJu++;
        }
    }

    public void a(InterfaceC0061a interfaceC0061a) {
        if (this.aJs == null) {
            this.aJs = interfaceC0061a;
        }
    }
}
