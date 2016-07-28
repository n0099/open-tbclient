package com.baidu.tieba.d;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class c {
    private InterfaceC0055c aZA;
    private float aZu;
    private float aZv;
    private ScaleGestureDetector aZy;
    private a aZz;
    private Handler.Callback aZw = new d(this);
    private Handler mHandler = new Handler(this.aZw);

    /* loaded from: classes.dex */
    public interface a {
        void cs(boolean z);
    }

    /* renamed from: com.baidu.tieba.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0055c {
        void K(int i, int i2);

        void L(int i, int i2);
    }

    public c(Context context) {
        this.aZy = new ScaleGestureDetector(context, new b(this, null));
    }

    public void a(a aVar) {
        this.aZz = aVar;
    }

    /* loaded from: classes.dex */
    private final class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean aZC;

        private b() {
            this.aZC = false;
        }

        /* synthetic */ b(c cVar, b bVar) {
            this();
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.aZC = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && c.this.aZz != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.aZC && scaleFactor > 1.0f) {
                    this.aZC = true;
                    c.this.aZz.cs(true);
                } else if (!this.aZC && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.aZC = true;
                    c.this.aZz.cs(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.aZC = true;
        }
    }

    public void a(InterfaceC0055c interfaceC0055c) {
        this.aZA = interfaceC0055c;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aZy.onTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                this.aZv = motionEvent.getRawY();
                return true;
            case 1:
            default:
                return true;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i = (int) (rawX - this.aZu);
                int i2 = (int) (rawY - this.aZv);
                if (this.aZA != null) {
                    if (i2 > 0) {
                        O(i, i2);
                    } else {
                        P(i, i2);
                    }
                }
                this.aZu = rawX;
                this.aZv = rawY;
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
