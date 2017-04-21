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
    private b aFF;
    private InterfaceC0044a aFG = null;
    private WindowManager jn;

    /* renamed from: com.baidu.tbadk.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0044a {
        void fb(int i);
    }

    public a(Context context) {
        this.aFF = null;
        this.jn = null;
        this.aFF = new b(context);
        this.jn = (WindowManager) context.getSystemService("window");
    }

    private void Gk() {
        try {
            this.jn.removeView(this.aFF);
        } catch (Throwable th) {
        }
    }

    private void Gl() {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 0, -3);
            layoutParams.gravity = 51;
            layoutParams.height = 1;
            layoutParams.width = 1;
            this.jn.addView(this.aFF, layoutParams);
        } catch (Throwable th) {
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        Gk();
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        super.start();
        Gk();
        Gl();
        new Handler(Looper.getMainLooper()).post(new com.baidu.tbadk.j.b(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ImageView {
        private int aFI;
        private final Paint mPaint;
        private long mStartTime;

        public b(Context context) {
            super(context);
            this.mStartTime = -1L;
            this.aFI = 0;
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
                this.aFI = 0;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            super.draw(canvas);
            if (elapsedRealtime - this.mStartTime > 1000) {
                this.mStartTime = elapsedRealtime;
                if (a.this.aFG != null) {
                    a.this.aFG.fb(this.aFI);
                } else {
                    com.baidu.adp.a.a.d.F(this.aFI);
                }
                this.aFI = 0;
            }
            this.aFI++;
        }
    }

    public void a(InterfaceC0044a interfaceC0044a) {
        if (this.aFG == null) {
            this.aFG = interfaceC0044a;
        }
    }
}
