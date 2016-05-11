package com.baidu.tieba.c;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class c {
    private float aVb;
    private float aVc;
    private ScaleGestureDetector aVg;
    private a aVh;
    private InterfaceC0053c aVi;
    private Handler.Callback aVd = new d(this);
    private Handler mHandler = new Handler(this.aVd);

    /* loaded from: classes.dex */
    public interface a {
        void co(boolean z);
    }

    /* renamed from: com.baidu.tieba.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0053c {
        void O(int i, int i2);

        void P(int i, int i2);
    }

    public c(Context context) {
        this.aVg = new ScaleGestureDetector(context, new b(this, null));
    }

    public void a(a aVar) {
        this.aVh = aVar;
    }

    /* loaded from: classes.dex */
    private final class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean aVk;

        private b() {
            this.aVk = false;
        }

        /* synthetic */ b(c cVar, b bVar) {
            this();
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.aVk = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && c.this.aVh != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.aVk && scaleFactor > 1.0f) {
                    this.aVk = true;
                    c.this.aVh.co(true);
                } else if (!this.aVk && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.aVk = true;
                    c.this.aVh.co(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.aVk = true;
        }
    }

    public void a(InterfaceC0053c interfaceC0053c) {
        this.aVi = interfaceC0053c;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aVg.onTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                this.aVc = motionEvent.getRawY();
                return true;
            case 1:
            default:
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i = (int) (rawX - this.aVb);
                int i2 = (int) (rawY - this.aVc);
                if (this.aVi != null) {
                    if (i2 > 0) {
                        M(i, i2);
                    } else {
                        N(i, i2);
                    }
                }
                this.aVb = rawX;
                this.aVc = rawY;
                return true;
        }
    }

    public void M(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void N(int i, int i2) {
        this.mHandler.removeMessages(0);
        if (!this.mHandler.hasMessages(1)) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 100L);
        }
    }
}
