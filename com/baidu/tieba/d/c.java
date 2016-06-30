package com.baidu.tieba.d;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class c {
    private ScaleGestureDetector aYA;
    private a aYB;
    private InterfaceC0054c aYC;
    private float aYw;
    private float aYx;
    private Handler.Callback aYy = new d(this);
    private Handler mHandler = new Handler(this.aYy);

    /* loaded from: classes.dex */
    public interface a {
        void cp(boolean z);
    }

    /* renamed from: com.baidu.tieba.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0054c {
        void K(int i, int i2);

        void L(int i, int i2);
    }

    public c(Context context) {
        this.aYA = new ScaleGestureDetector(context, new b(this, null));
    }

    public void a(a aVar) {
        this.aYB = aVar;
    }

    /* loaded from: classes.dex */
    private final class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean aYE;

        private b() {
            this.aYE = false;
        }

        /* synthetic */ b(c cVar, b bVar) {
            this();
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.aYE = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && c.this.aYB != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.aYE && scaleFactor > 1.0f) {
                    this.aYE = true;
                    c.this.aYB.cp(true);
                } else if (!this.aYE && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.aYE = true;
                    c.this.aYB.cp(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.aYE = true;
        }
    }

    public void a(InterfaceC0054c interfaceC0054c) {
        this.aYC = interfaceC0054c;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aYA.onTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                this.aYx = motionEvent.getRawY();
                return true;
            case 1:
            default:
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i = (int) (rawX - this.aYw);
                int i2 = (int) (rawY - this.aYx);
                if (this.aYC != null) {
                    if (i2 > 0) {
                        O(i, i2);
                    } else {
                        P(i, i2);
                    }
                }
                this.aYw = rawX;
                this.aYx = rawY;
                return true;
        }
    }

    public void O(int i, int i2) {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(0)) {
            Message message = new Message();
            message.what = 0;
            message.arg1 = i;
            message.arg2 = i2;
            this.mHandler.sendMessageDelayed(message, 60L);
        }
    }

    public void P(int i, int i2) {
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
