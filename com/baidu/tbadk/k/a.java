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
    private b aJy;
    private InterfaceC0074a aJz = null;
    private WindowManager mWindowManager;

    /* renamed from: com.baidu.tbadk.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0074a {
        void fo(int i);
    }

    public a(Context context) {
        this.aJy = null;
        this.mWindowManager = null;
        this.aJy = new b(context);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
    }

    private void Gf() {
        try {
            this.mWindowManager.removeView(this.aJy);
        } catch (Throwable th) {
        }
    }

    private void Gg() {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 0, -3);
            layoutParams.gravity = 51;
            layoutParams.height = 1;
            layoutParams.width = 1;
            this.mWindowManager.addView(this.aJy, layoutParams);
        } catch (Throwable th) {
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        Gf();
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        super.start();
        Gf();
        Gg();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tbadk.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ck()) {
                    a.this.aJy.invalidate();
                    a.this.aJy.post(this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ImageView {
        private int aJB;
        private final Paint mPaint;
        private long mStartTime;

        public b(Context context) {
            super(context);
            this.mStartTime = -1L;
            this.aJB = 0;
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
                this.aJB = 0;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            super.draw(canvas);
            if (elapsedRealtime - this.mStartTime > 1000) {
                this.mStartTime = elapsedRealtime;
                if (a.this.aJz != null) {
                    a.this.aJz.fo(this.aJB);
                } else {
                    com.baidu.adp.a.a.d.E(this.aJB);
                }
                this.aJB = 0;
            }
            this.aJB++;
        }
    }

    public void a(InterfaceC0074a interfaceC0074a) {
        if (this.aJz == null) {
            this.aJz = interfaceC0074a;
        }
    }
}
