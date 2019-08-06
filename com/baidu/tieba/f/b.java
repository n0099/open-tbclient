package com.baidu.tieba.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.f.a {
    private ScaleGestureDetector cIJ;
    private a eTK;

    /* loaded from: classes.dex */
    public interface a {
        void ji(boolean z);
    }

    public b(Context context) {
        this.cIJ = new ScaleGestureDetector(context, new C0306b());
    }

    public void a(a aVar) {
        this.eTK = aVar;
    }

    /* renamed from: com.baidu.tieba.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0306b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean eTL;

        private C0306b() {
            this.eTL = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.eTL = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.eTK != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.eTL && scaleFactor > 1.0f) {
                    this.eTL = true;
                    b.this.eTK.ji(true);
                } else if (!this.eTL && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.eTL = true;
                    b.this.eTK.ji(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.eTL = true;
        }
    }

    @Override // com.baidu.tieba.f.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.cIJ.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
