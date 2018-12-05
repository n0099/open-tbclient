package com.baidu.tieba.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.f.a {
    private ScaleGestureDetector bnF;
    private a dlQ;

    /* loaded from: classes.dex */
    public interface a {
        void fW(boolean z);
    }

    public b(Context context) {
        this.bnF = new ScaleGestureDetector(context, new C0215b());
    }

    public void a(a aVar) {
        this.dlQ = aVar;
    }

    /* renamed from: com.baidu.tieba.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0215b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean dlR;

        private C0215b() {
            this.dlR = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.dlR = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.dlQ != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.dlR && scaleFactor > 1.0f) {
                    this.dlR = true;
                    b.this.dlQ.fW(true);
                } else if (!this.dlR && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.dlR = true;
                    b.this.dlQ.fW(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.dlR = true;
        }
    }

    @Override // com.baidu.tieba.f.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.bnF.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
