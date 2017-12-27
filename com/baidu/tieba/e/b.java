package com.baidu.tieba.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.e.a {
    private ScaleGestureDetector bFL;
    private a dfO;

    /* loaded from: classes.dex */
    public interface a {
        void fe(boolean z);
    }

    public b(Context context) {
        this.bFL = new ScaleGestureDetector(context, new C0110b());
    }

    public void a(a aVar) {
        this.dfO = aVar;
    }

    /* renamed from: com.baidu.tieba.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0110b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean dfP;

        private C0110b() {
            this.dfP = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.dfP = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.dfO != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.dfP && scaleFactor > 1.0f) {
                    this.dfP = true;
                    b.this.dfO.fe(true);
                } else if (!this.dfP && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.dfP = true;
                    b.this.dfO.fe(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.dfP = true;
        }
    }

    @Override // com.baidu.tieba.e.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.bFL.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
