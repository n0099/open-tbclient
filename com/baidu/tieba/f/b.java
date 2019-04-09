package com.baidu.tieba.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.f.a {
    private ScaleGestureDetector cyY;
    private a eza;

    /* loaded from: classes.dex */
    public interface a {
        void it(boolean z);
    }

    public b(Context context) {
        this.cyY = new ScaleGestureDetector(context, new C0285b());
    }

    public void a(a aVar) {
        this.eza = aVar;
    }

    /* renamed from: com.baidu.tieba.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0285b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean ezb;

        private C0285b() {
            this.ezb = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.ezb = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.eza != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.ezb && scaleFactor > 1.0f) {
                    this.ezb = true;
                    b.this.eza.it(true);
                } else if (!this.ezb && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.ezb = true;
                    b.this.eza.it(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.ezb = true;
        }
    }

    @Override // com.baidu.tieba.f.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.cyY.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
