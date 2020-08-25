package com.baidu.tieba.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.f.a {
    private a hrB;
    private ScaleGestureDetector mScaleGestureDetector;

    /* loaded from: classes2.dex */
    public interface a {
        void cp(boolean z);
    }

    public b(Context context) {
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new C0675b());
    }

    public void a(a aVar) {
        this.hrB = aVar;
    }

    /* renamed from: com.baidu.tieba.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private final class C0675b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean bkR;

        private C0675b() {
            this.bkR = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.bkR = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.hrB != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.bkR && scaleFactor > 1.0f) {
                    this.bkR = true;
                    b.this.hrB.cp(true);
                } else if (!this.bkR && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.bkR = true;
                    b.this.hrB.cp(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.bkR = true;
        }
    }

    @Override // com.baidu.tieba.f.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.mScaleGestureDetector.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
