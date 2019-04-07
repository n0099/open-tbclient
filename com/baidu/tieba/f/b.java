package com.baidu.tieba.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.f.a {
    private ScaleGestureDetector cyX;
    private a eyZ;

    /* loaded from: classes.dex */
    public interface a {
        void it(boolean z);
    }

    public b(Context context) {
        this.cyX = new ScaleGestureDetector(context, new C0285b());
    }

    public void a(a aVar) {
        this.eyZ = aVar;
    }

    /* renamed from: com.baidu.tieba.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0285b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean eza;

        private C0285b() {
            this.eza = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.eza = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.eyZ != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.eza && scaleFactor > 1.0f) {
                    this.eza = true;
                    b.this.eyZ.it(true);
                } else if (!this.eza && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.eza = true;
                    b.this.eyZ.it(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.eza = true;
        }
    }

    @Override // com.baidu.tieba.f.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.cyX.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
