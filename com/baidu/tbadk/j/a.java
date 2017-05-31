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
    private b aFw;
    private InterfaceC0048a aFx = null;
    private WindowManager jn;

    /* renamed from: com.baidu.tbadk.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0048a {
        void eY(int i);
    }

    public a(Context context) {
        this.aFw = null;
        this.jn = null;
        this.aFw = new b(context);
        this.jn = (WindowManager) context.getSystemService("window");
    }

    private void Fi() {
        try {
            this.jn.removeView(this.aFw);
        } catch (Throwable th) {
        }
    }

    private void Fj() {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 0, -3);
            layoutParams.gravity = 51;
            layoutParams.height = 1;
            layoutParams.width = 1;
            this.jn.addView(this.aFw, layoutParams);
        } catch (Throwable th) {
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        Fi();
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        super.start();
        Fi();
        Fj();
        new Handler(Looper.getMainLooper()).post(new com.baidu.tbadk.j.b(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ImageView {
        private int aFz;
        private final Paint mPaint;
        private long mStartTime;

        public b(Context context) {
            super(context);
            this.mStartTime = -1L;
            this.aFz = 0;
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
                this.aFz = 0;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            super.draw(canvas);
            if (elapsedRealtime - this.mStartTime > 1000) {
                this.mStartTime = elapsedRealtime;
                if (a.this.aFx != null) {
                    a.this.aFx.eY(this.aFz);
                } else {
                    com.baidu.adp.a.a.d.F(this.aFz);
                }
                this.aFz = 0;
            }
            this.aFz++;
        }
    }

    public void a(InterfaceC0048a interfaceC0048a) {
        if (this.aFx == null) {
            this.aFx = interfaceC0048a;
        }
    }
}
