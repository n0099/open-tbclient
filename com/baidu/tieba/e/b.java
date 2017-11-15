package com.baidu.tieba.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.e.a {
    private ScaleGestureDetector aOV;
    private a ciq;

    /* loaded from: classes.dex */
    public interface a {
        void ef(boolean z);
    }

    public b(Context context) {
        this.aOV = new ScaleGestureDetector(context, new C0082b());
    }

    public void a(a aVar) {
        this.ciq = aVar;
    }

    /* renamed from: com.baidu.tieba.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0082b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean cir;

        private C0082b() {
            this.cir = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.cir = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.ciq != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.cir && scaleFactor > 1.0f) {
                    this.cir = true;
                    b.this.ciq.ef(true);
                } else if (!this.cir && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.cir = true;
                    b.this.ciq.ef(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.cir = true;
        }
    }

    @Override // com.baidu.tieba.e.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.aOV.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
