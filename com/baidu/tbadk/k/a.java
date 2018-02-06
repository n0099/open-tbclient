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
    private b bzL;
    private InterfaceC0111a bzM = null;
    private WindowManager mWindowManager;

    /* renamed from: com.baidu.tbadk.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0111a {
        void ig(int i);
    }

    public a(Context context) {
        this.bzL = null;
        this.mWindowManager = null;
        this.bzL = new b(context);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
    }

    private void Oa() {
        try {
            this.mWindowManager.removeView(this.bzL);
        } catch (Throwable th) {
        }
    }

    private void Ob() {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2006, 0, -3);
            layoutParams.gravity = 51;
            layoutParams.height = 1;
            layoutParams.width = 1;
            this.mWindowManager.addView(this.bzL, layoutParams);
        } catch (Throwable th) {
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        Oa();
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        super.start();
        Oa();
        Ob();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tbadk.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.jP()) {
                    a.this.bzL.invalidate();
                    a.this.bzL.post(this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ImageView {
        private int bzO;
        private final Paint mPaint;
        private long mStartTime;

        public b(Context context) {
            super(context);
            this.mStartTime = -1L;
            this.bzO = 0;
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
                this.bzO = 0;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            super.draw(canvas);
            if (elapsedRealtime - this.mStartTime > 1000) {
                this.mStartTime = elapsedRealtime;
                if (a.this.bzM != null) {
                    a.this.bzM.ig(this.bzO);
                } else {
                    com.baidu.adp.a.a.d.cy(this.bzO);
                }
                this.bzO = 0;
            }
            this.bzO++;
        }
    }

    public void a(InterfaceC0111a interfaceC0111a) {
        if (this.bzM == null) {
            this.bzM = interfaceC0111a;
        }
    }
}
