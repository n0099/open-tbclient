package com.baidu.tieba.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.e.a {
    private ScaleGestureDetector aRS;
    private a cqW;

    /* loaded from: classes.dex */
    public interface a {
        void ew(boolean z);
    }

    public b(Context context) {
        this.aRS = new ScaleGestureDetector(context, new C0084b());
    }

    public void a(a aVar) {
        this.cqW = aVar;
    }

    /* renamed from: com.baidu.tieba.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0084b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean cqX;

        private C0084b() {
            this.cqX = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.cqX = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.cqW != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.cqX && scaleFactor > 1.0f) {
                    this.cqX = true;
                    b.this.cqW.ew(true);
                } else if (!this.cqX && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.cqX = true;
                    b.this.cqW.ew(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.cqX = true;
        }
    }

    @Override // com.baidu.tieba.e.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.aRS.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
