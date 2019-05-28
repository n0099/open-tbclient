package com.baidu.tieba.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.f.a {
    private ScaleGestureDetector cHh;
    private a eOD;

    /* loaded from: classes.dex */
    public interface a {
        void iY(boolean z);
    }

    public b(Context context) {
        this.cHh = new ScaleGestureDetector(context, new C0303b());
    }

    public void a(a aVar) {
        this.eOD = aVar;
    }

    /* renamed from: com.baidu.tieba.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0303b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean eOE;

        private C0303b() {
            this.eOE = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.eOE = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.eOD != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.eOE && scaleFactor > 1.0f) {
                    this.eOE = true;
                    b.this.eOD.iY(true);
                } else if (!this.eOE && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.eOE = true;
                    b.this.eOD.iY(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.eOE = true;
        }
    }

    @Override // com.baidu.tieba.f.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.cHh.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
