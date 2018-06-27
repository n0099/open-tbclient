package com.baidu.tieba.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.f.a {
    private ScaleGestureDetector bbE;
    private a cNo;

    /* loaded from: classes.dex */
    public interface a {
        void fb(boolean z);
    }

    public b(Context context) {
        this.bbE = new ScaleGestureDetector(context, new C0148b());
    }

    public void a(a aVar) {
        this.cNo = aVar;
    }

    /* renamed from: com.baidu.tieba.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0148b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean cNp;

        private C0148b() {
            this.cNp = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.cNp = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.cNo != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.cNp && scaleFactor > 1.0f) {
                    this.cNp = true;
                    b.this.cNo.fb(true);
                } else if (!this.cNp && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.cNp = true;
                    b.this.cNo.fb(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.cNp = true;
        }
    }

    @Override // com.baidu.tieba.f.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.bbE.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
