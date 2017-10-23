package com.baidu.tieba.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.e.a {
    private ScaleGestureDetector aOG;
    private a caw;

    /* loaded from: classes.dex */
    public interface a {
        void eb(boolean z);
    }

    public b(Context context) {
        this.aOG = new ScaleGestureDetector(context, new C0082b());
    }

    public void a(a aVar) {
        this.caw = aVar;
    }

    /* renamed from: com.baidu.tieba.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0082b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean cax;

        private C0082b() {
            this.cax = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.cax = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.caw != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.cax && scaleFactor > 1.0f) {
                    this.cax = true;
                    b.this.caw.eb(true);
                } else if (!this.cax && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.cax = true;
                    b.this.caw.eb(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.cax = true;
        }
    }

    @Override // com.baidu.tieba.e.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.aOG.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
