package com.baidu.tieba.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.e.a {
    private ScaleGestureDetector bFT;
    private a dkq;

    /* loaded from: classes.dex */
    public interface a {
        void fi(boolean z);
    }

    public b(Context context) {
        this.bFT = new ScaleGestureDetector(context, new C0109b());
    }

    public void a(a aVar) {
        this.dkq = aVar;
    }

    /* renamed from: com.baidu.tieba.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0109b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean dkr;

        private C0109b() {
            this.dkr = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.dkr = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.dkq != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.dkr && scaleFactor > 1.0f) {
                    this.dkr = true;
                    b.this.dkq.fi(true);
                } else if (!this.dkr && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.dkr = true;
                    b.this.dkq.fi(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.dkr = true;
        }
    }

    @Override // com.baidu.tieba.e.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.bFT.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
