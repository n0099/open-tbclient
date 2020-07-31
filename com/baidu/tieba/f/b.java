package com.baidu.tieba.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.f.a {
    private a heI;
    private ScaleGestureDetector mScaleGestureDetector;

    /* loaded from: classes.dex */
    public interface a {
        void cg(boolean z);
    }

    public b(Context context) {
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new C0624b());
    }

    public void a(a aVar) {
        this.heI = aVar;
    }

    /* renamed from: com.baidu.tieba.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0624b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean bfh;

        private C0624b() {
            this.bfh = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.bfh = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.heI != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.bfh && scaleFactor > 1.0f) {
                    this.bfh = true;
                    b.this.heI.cg(true);
                } else if (!this.bfh && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.bfh = true;
                    b.this.heI.cg(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.bfh = true;
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
