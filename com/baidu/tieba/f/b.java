package com.baidu.tieba.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.f.a {
    private ScaleGestureDetector bnI;
    private a doI;

    /* loaded from: classes.dex */
    public interface a {
        void fY(boolean z);
    }

    public b(Context context) {
        this.bnI = new ScaleGestureDetector(context, new C0215b());
    }

    public void a(a aVar) {
        this.doI = aVar;
    }

    /* renamed from: com.baidu.tieba.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0215b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean doJ;

        private C0215b() {
            this.doJ = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.doJ = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.doI != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.doJ && scaleFactor > 1.0f) {
                    this.doJ = true;
                    b.this.doI.fY(true);
                } else if (!this.doJ && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.doJ = true;
                    b.this.doI.fY(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.doJ = true;
        }
    }

    @Override // com.baidu.tieba.f.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.bnI.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
