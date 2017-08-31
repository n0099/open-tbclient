package com.baidu.tieba.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.e.a {
    private ScaleGestureDetector bZQ;
    private a bZR;

    /* loaded from: classes.dex */
    public interface a {
        void ei(boolean z);
    }

    public b(Context context) {
        this.bZQ = new ScaleGestureDetector(context, new C0083b());
    }

    public void a(a aVar) {
        this.bZR = aVar;
    }

    /* renamed from: com.baidu.tieba.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0083b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean bZS;

        private C0083b() {
            this.bZS = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.bZS = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.bZR != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.bZS && scaleFactor > 1.0f) {
                    this.bZS = true;
                    b.this.bZR.ei(true);
                } else if (!this.bZS && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.bZS = true;
                    b.this.bZR.ei(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.bZS = true;
        }
    }

    @Override // com.baidu.tieba.e.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.bZQ.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
