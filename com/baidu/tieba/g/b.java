package com.baidu.tieba.g;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.g.a {
    private a igU;
    private ScaleGestureDetector mScaleGestureDetector;

    /* loaded from: classes.dex */
    public interface a {
        void cI(boolean z);
    }

    public b(Context context) {
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new C0741b());
    }

    public void a(a aVar) {
        this.igU = aVar;
    }

    /* renamed from: com.baidu.tieba.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0741b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean byh;

        private C0741b() {
            this.byh = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.byh = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.igU != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.byh && scaleFactor > 1.0f) {
                    this.byh = true;
                    b.this.igU.cI(true);
                } else if (!this.byh && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.byh = true;
                    b.this.igU.cI(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.byh = true;
        }
    }

    @Override // com.baidu.tieba.g.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.mScaleGestureDetector.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
