package com.baidu.tbadk.l;

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
    private b aJi;
    private InterfaceC0060a aJj = null;
    private WindowManager jn;

    /* renamed from: com.baidu.tbadk.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0060a {
        void ff(int i);
    }

    public a(Context context) {
        this.aJi = null;
        this.jn = null;
        this.aJi = new b(context);
        this.jn = (WindowManager) context.getSystemService("window");
    }

    private void Gd() {
        try {
            this.jn.removeView(this.aJi);
        } catch (Throwable th) {
        }
    }

    private void Ge() {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 0, -3);
            layoutParams.gravity = 51;
            layoutParams.height = 1;
            layoutParams.width = 1;
            this.jn.addView(this.aJi, layoutParams);
        } catch (Throwable th) {
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        Gd();
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        super.start();
        Gd();
        Ge();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tbadk.l.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cv()) {
                    a.this.aJi.invalidate();
                    a.this.aJi.post(this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ImageView {
        private int aJl;
        private final Paint mPaint;
        private long mStartTime;

        public b(Context context) {
            super(context);
            this.mStartTime = -1L;
            this.aJl = 0;
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
                this.aJl = 0;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            super.draw(canvas);
            if (elapsedRealtime - this.mStartTime > 1000) {
                this.mStartTime = elapsedRealtime;
                if (a.this.aJj != null) {
                    a.this.aJj.ff(this.aJl);
                } else {
                    com.baidu.adp.a.a.d.I(this.aJl);
                }
                this.aJl = 0;
            }
            this.aJl++;
        }
    }

    public void a(InterfaceC0060a interfaceC0060a) {
        if (this.aJj == null) {
            this.aJj = interfaceC0060a;
        }
    }
}
