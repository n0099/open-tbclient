package com.baidu.tieba.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.f.a {
    private ScaleGestureDetector cyV;
    private a ezo;

    /* loaded from: classes.dex */
    public interface a {
        void it(boolean z);
    }

    public b(Context context) {
        this.cyV = new ScaleGestureDetector(context, new C0285b());
    }

    public void a(a aVar) {
        this.ezo = aVar;
    }

    /* renamed from: com.baidu.tieba.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0285b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean ezp;

        private C0285b() {
            this.ezp = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.ezp = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.ezo != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.ezp && scaleFactor > 1.0f) {
                    this.ezp = true;
                    b.this.ezo.it(true);
                } else if (!this.ezp && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.ezp = true;
                    b.this.ezo.it(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.ezp = true;
        }
    }

    @Override // com.baidu.tieba.f.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.cyV.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
