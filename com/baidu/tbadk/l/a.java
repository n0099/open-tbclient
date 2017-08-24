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
    private b aJj;
    private InterfaceC0060a aJk = null;
    private WindowManager jn;

    /* renamed from: com.baidu.tbadk.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0060a {
        void ff(int i);
    }

    public a(Context context) {
        this.aJj = null;
        this.jn = null;
        this.aJj = new b(context);
        this.jn = (WindowManager) context.getSystemService("window");
    }

    private void Gd() {
        try {
            this.jn.removeView(this.aJj);
        } catch (Throwable th) {
        }
    }

    private void Ge() {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 0, -3);
            layoutParams.gravity = 51;
            layoutParams.height = 1;
            layoutParams.width = 1;
            this.jn.addView(this.aJj, layoutParams);
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
                    a.this.aJj.invalidate();
                    a.this.aJj.post(this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ImageView {
        private int aJm;
        private final Paint mPaint;
        private long mStartTime;

        public b(Context context) {
            super(context);
            this.mStartTime = -1L;
            this.aJm = 0;
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
                this.aJm = 0;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            super.draw(canvas);
            if (elapsedRealtime - this.mStartTime > 1000) {
                this.mStartTime = elapsedRealtime;
                if (a.this.aJk != null) {
                    a.this.aJk.ff(this.aJm);
                } else {
                    com.baidu.adp.a.a.d.I(this.aJm);
                }
                this.aJm = 0;
            }
            this.aJm++;
        }
    }

    public void a(InterfaceC0060a interfaceC0060a) {
        if (this.aJk == null) {
            this.aJk = interfaceC0060a;
        }
    }
}
