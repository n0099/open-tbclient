package com.baidu.tieba.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.f.a {
    private ScaleGestureDetector bbM;
    private a cPU;

    /* loaded from: classes.dex */
    public interface a {
        void fc(boolean z);
    }

    public b(Context context) {
        this.bbM = new ScaleGestureDetector(context, new C0145b());
    }

    public void a(a aVar) {
        this.cPU = aVar;
    }

    /* renamed from: com.baidu.tieba.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0145b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean cPV;

        private C0145b() {
            this.cPV = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.cPV = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.cPU != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.cPV && scaleFactor > 1.0f) {
                    this.cPV = true;
                    b.this.cPU.fc(true);
                } else if (!this.cPV && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.cPV = true;
                    b.this.cPU.fc(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.cPV = true;
        }
    }

    @Override // com.baidu.tieba.f.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.bbM.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
