package com.baidu.tieba.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.e.a {
    private ScaleGestureDetector bWT;
    private a bWU;

    /* loaded from: classes.dex */
    public interface a {
        void ef(boolean z);
    }

    public b(Context context) {
        this.bWT = new ScaleGestureDetector(context, new C0081b());
    }

    public void a(a aVar) {
        this.bWU = aVar;
    }

    /* renamed from: com.baidu.tieba.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0081b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean bWV;

        private C0081b() {
            this.bWV = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.bWV = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.bWU != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.bWV && scaleFactor > 1.0f) {
                    this.bWV = true;
                    b.this.bWU.ef(true);
                } else if (!this.bWV && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.bWV = true;
                    b.this.bWU.ef(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.bWV = true;
        }
    }

    @Override // com.baidu.tieba.e.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.bWT.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
