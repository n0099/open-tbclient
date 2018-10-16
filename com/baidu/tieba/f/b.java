package com.baidu.tieba.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.f.a {
    private ScaleGestureDetector bjw;
    private a ded;

    /* loaded from: classes.dex */
    public interface a {
        void fL(boolean z);
    }

    public b(Context context) {
        this.bjw = new ScaleGestureDetector(context, new C0180b());
    }

    public void a(a aVar) {
        this.ded = aVar;
    }

    /* renamed from: com.baidu.tieba.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0180b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean dee;

        private C0180b() {
            this.dee = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.dee = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.ded != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.dee && scaleFactor > 1.0f) {
                    this.dee = true;
                    b.this.ded.fL(true);
                } else if (!this.dee && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.dee = true;
                    b.this.ded.fL(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.dee = true;
        }
    }

    @Override // com.baidu.tieba.f.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.bjw.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
