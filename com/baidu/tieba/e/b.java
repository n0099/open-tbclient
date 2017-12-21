package com.baidu.tieba.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.e.a {
    private ScaleGestureDetector aRY;
    private a crk;

    /* loaded from: classes.dex */
    public interface a {
        void ex(boolean z);
    }

    public b(Context context) {
        this.aRY = new ScaleGestureDetector(context, new C0097b());
    }

    public void a(a aVar) {
        this.crk = aVar;
    }

    /* renamed from: com.baidu.tieba.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0097b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean crl;

        private C0097b() {
            this.crl = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.crl = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.crk != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.crl && scaleFactor > 1.0f) {
                    this.crl = true;
                    b.this.crk.ex(true);
                } else if (!this.crl && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.crl = true;
                    b.this.crk.ex(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.crl = true;
        }
    }

    @Override // com.baidu.tieba.e.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.aRY.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
