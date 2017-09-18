package com.baidu.tieba.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.e.a {
    private ScaleGestureDetector caI;
    private a caJ;

    /* loaded from: classes.dex */
    public interface a {
        void ej(boolean z);
    }

    public b(Context context) {
        this.caI = new ScaleGestureDetector(context, new C0082b());
    }

    public void a(a aVar) {
        this.caJ = aVar;
    }

    /* renamed from: com.baidu.tieba.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0082b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean caK;

        private C0082b() {
            this.caK = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.caK = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.caJ != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.caK && scaleFactor > 1.0f) {
                    this.caK = true;
                    b.this.caJ.ej(true);
                } else if (!this.caK && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.caK = true;
                    b.this.caJ.ej(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.caK = true;
        }
    }

    @Override // com.baidu.tieba.e.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.caI.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
