package com.baidu.tieba.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.e.a {
    private ScaleGestureDetector bGb;
    private a dkL;

    /* loaded from: classes.dex */
    public interface a {
        void fl(boolean z);
    }

    public b(Context context) {
        this.bGb = new ScaleGestureDetector(context, new C0110b());
    }

    public void a(a aVar) {
        this.dkL = aVar;
    }

    /* renamed from: com.baidu.tieba.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0110b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean dkM;

        private C0110b() {
            this.dkM = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.dkM = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.dkL != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.dkM && scaleFactor > 1.0f) {
                    this.dkM = true;
                    b.this.dkL.fl(true);
                } else if (!this.dkM && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.dkM = true;
                    b.this.dkL.fl(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.dkM = true;
        }
    }

    @Override // com.baidu.tieba.e.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.bGb.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
