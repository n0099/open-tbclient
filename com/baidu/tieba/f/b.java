package com.baidu.tieba.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.f.a {
    private a iEd;
    private ScaleGestureDetector mScaleGestureDetector;

    /* loaded from: classes.dex */
    public interface a {
        void cZ(boolean z);
    }

    public b(Context context) {
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new C0728b());
    }

    public void a(a aVar) {
        this.iEd = aVar;
    }

    /* renamed from: com.baidu.tieba.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0728b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean bIb;

        private C0728b() {
            this.bIb = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.bIb = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.iEd != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.bIb && scaleFactor > 1.0f) {
                    this.bIb = true;
                    b.this.iEd.cZ(true);
                } else if (!this.bIb && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.bIb = true;
                    b.this.iEd.cZ(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.bIb = true;
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
