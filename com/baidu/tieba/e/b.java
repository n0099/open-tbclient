package com.baidu.tieba.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.e.a {
    private ScaleGestureDetector bWU;
    private a bWV;

    /* loaded from: classes.dex */
    public interface a {
        void ef(boolean z);
    }

    public b(Context context) {
        this.bWU = new ScaleGestureDetector(context, new C0081b());
    }

    public void a(a aVar) {
        this.bWV = aVar;
    }

    /* renamed from: com.baidu.tieba.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0081b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean bWW;

        private C0081b() {
            this.bWW = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.bWW = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.bWV != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.bWW && scaleFactor > 1.0f) {
                    this.bWW = true;
                    b.this.bWV.ef(true);
                } else if (!this.bWW && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.bWW = true;
                    b.this.bWV.ef(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.bWW = true;
        }
    }

    @Override // com.baidu.tieba.e.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.bWU.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
