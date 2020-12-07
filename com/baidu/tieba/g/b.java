package com.baidu.tieba.g;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.g.a {
    private a irO;
    private ScaleGestureDetector mScaleGestureDetector;

    /* loaded from: classes.dex */
    public interface a {
        void cW(boolean z);
    }

    public b(Context context) {
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new C0757b());
    }

    public void a(a aVar) {
        this.irO = aVar;
    }

    /* renamed from: com.baidu.tieba.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0757b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean bDp;

        private C0757b() {
            this.bDp = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.bDp = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.irO != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.bDp && scaleFactor > 1.0f) {
                    this.bDp = true;
                    b.this.irO.cW(true);
                } else if (!this.bDp && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.bDp = true;
                    b.this.irO.cW(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.bDp = true;
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
