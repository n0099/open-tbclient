package com.baidu.tieba.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.f.a {
    private ScaleGestureDetector aSN;
    private a cFy;

    /* loaded from: classes.dex */
    public interface a {
        void eW(boolean z);
    }

    public b(Context context) {
        this.aSN = new ScaleGestureDetector(context, new C0132b());
    }

    public void a(a aVar) {
        this.cFy = aVar;
    }

    /* renamed from: com.baidu.tieba.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0132b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean cFz;

        private C0132b() {
            this.cFz = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.cFz = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.cFy != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.cFz && scaleFactor > 1.0f) {
                    this.cFz = true;
                    b.this.cFy.eW(true);
                } else if (!this.cFz && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.cFz = true;
                    b.this.cFy.eW(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.cFz = true;
        }
    }

    @Override // com.baidu.tieba.f.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.aSN.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
