package com.baidu.tieba.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.e.a {
    private ScaleGestureDetector bHS;
    private a dnp;

    /* loaded from: classes.dex */
    public interface a {
        void fr(boolean z);
    }

    public b(Context context) {
        this.bHS = new ScaleGestureDetector(context, new C0144b());
    }

    public void a(a aVar) {
        this.dnp = aVar;
    }

    /* renamed from: com.baidu.tieba.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0144b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean dnq;

        private C0144b() {
            this.dnq = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.dnq = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.dnp != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.dnq && scaleFactor > 1.0f) {
                    this.dnq = true;
                    b.this.dnp.fr(true);
                } else if (!this.dnq && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.dnq = true;
                    b.this.dnp.fr(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.dnq = true;
        }
    }

    @Override // com.baidu.tieba.e.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.bHS.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
