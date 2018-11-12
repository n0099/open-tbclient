package com.baidu.tieba.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.f.a {
    private ScaleGestureDetector bkh;
    private a dfj;

    /* loaded from: classes.dex */
    public interface a {
        void fV(boolean z);
    }

    public b(Context context) {
        this.bkh = new ScaleGestureDetector(context, new C0205b());
    }

    public void a(a aVar) {
        this.dfj = aVar;
    }

    /* renamed from: com.baidu.tieba.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0205b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean dfk;

        private C0205b() {
            this.dfk = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.dfk = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.dfj != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.dfk && scaleFactor > 1.0f) {
                    this.dfk = true;
                    b.this.dfj.fV(true);
                } else if (!this.dfk && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.dfk = true;
                    b.this.dfj.fV(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.dfk = true;
        }
    }

    @Override // com.baidu.tieba.f.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.bkh.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
