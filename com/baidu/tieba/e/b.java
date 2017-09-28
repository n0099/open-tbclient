package com.baidu.tieba.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.e.a {
    private ScaleGestureDetector aOT;
    private a caI;

    /* loaded from: classes.dex */
    public interface a {
        void ec(boolean z);
    }

    public b(Context context) {
        this.aOT = new ScaleGestureDetector(context, new C0082b());
    }

    public void a(a aVar) {
        this.caI = aVar;
    }

    /* renamed from: com.baidu.tieba.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0082b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean caJ;

        private C0082b() {
            this.caJ = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.caJ = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.caI != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.caJ && scaleFactor > 1.0f) {
                    this.caJ = true;
                    b.this.caI.ec(true);
                } else if (!this.caJ && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.caJ = true;
                    b.this.caI.ec(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.caJ = true;
        }
    }

    @Override // com.baidu.tieba.e.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.aOT.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
