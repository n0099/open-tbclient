package com.baidu.tieba.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.f.a {
    private ScaleGestureDetector aSO;
    private a cGE;

    /* loaded from: classes.dex */
    public interface a {
        void eX(boolean z);
    }

    public b(Context context) {
        this.aSO = new ScaleGestureDetector(context, new C0132b());
    }

    public void a(a aVar) {
        this.cGE = aVar;
    }

    /* renamed from: com.baidu.tieba.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0132b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean cGF;

        private C0132b() {
            this.cGF = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.cGF = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.cGE != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.cGF && scaleFactor > 1.0f) {
                    this.cGF = true;
                    b.this.cGE.eX(true);
                } else if (!this.cGF && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.cGF = true;
                    b.this.cGE.eX(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.cGF = true;
        }
    }

    @Override // com.baidu.tieba.f.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.aSO.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
