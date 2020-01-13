package com.baidu.tieba.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.f.a {
    private a fPe;
    private ScaleGestureDetector mScaleGestureDetector;

    /* loaded from: classes.dex */
    public interface a {
        void bc(boolean z);
    }

    public b(Context context) {
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new C0493b());
    }

    public void a(a aVar) {
        this.fPe = aVar;
    }

    /* renamed from: com.baidu.tieba.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0493b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean aua;

        private C0493b() {
            this.aua = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.aua = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.fPe != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.aua && scaleFactor > 1.0f) {
                    this.aua = true;
                    b.this.fPe.bc(true);
                } else if (!this.aua && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.aua = true;
                    b.this.fPe.bc(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.aua = true;
        }
    }

    @Override // com.baidu.tieba.f.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.mScaleGestureDetector.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
