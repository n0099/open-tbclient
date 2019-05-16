package com.baidu.tieba.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.f.a {
    private ScaleGestureDetector cHh;
    private a eOC;

    /* loaded from: classes.dex */
    public interface a {
        void iY(boolean z);
    }

    public b(Context context) {
        this.cHh = new ScaleGestureDetector(context, new C0303b());
    }

    public void a(a aVar) {
        this.eOC = aVar;
    }

    /* renamed from: com.baidu.tieba.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0303b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean eOD;

        private C0303b() {
            this.eOD = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.eOD = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.eOC != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.eOD && scaleFactor > 1.0f) {
                    this.eOD = true;
                    b.this.eOC.iY(true);
                } else if (!this.eOD && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.eOD = true;
                    b.this.eOC.iY(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.eOD = true;
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
