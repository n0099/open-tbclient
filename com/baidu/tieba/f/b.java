package com.baidu.tieba.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.f.a {
    private ScaleGestureDetector cIC;
    private a eTD;

    /* loaded from: classes.dex */
    public interface a {
        void ji(boolean z);
    }

    public b(Context context) {
        this.cIC = new ScaleGestureDetector(context, new C0306b());
    }

    public void a(a aVar) {
        this.eTD = aVar;
    }

    /* renamed from: com.baidu.tieba.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0306b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean eTE;

        private C0306b() {
            this.eTE = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.eTE = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.eTD != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.eTE && scaleFactor > 1.0f) {
                    this.eTE = true;
                    b.this.eTD.ji(true);
                } else if (!this.eTE && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.eTE = true;
                    b.this.eTD.ji(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.eTE = true;
        }
    }

    @Override // com.baidu.tieba.f.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.cIC.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
