package com.baidu.tieba.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.f.a {
    private a iFu;
    private ScaleGestureDetector mScaleGestureDetector;

    /* loaded from: classes.dex */
    public interface a {
        void dd(boolean z);
    }

    public b(Context context) {
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new C0712b());
    }

    public void a(a aVar) {
        this.iFu = aVar;
    }

    /* renamed from: com.baidu.tieba.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0712b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean bGZ;

        private C0712b() {
            this.bGZ = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.bGZ = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.iFu != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.bGZ && scaleFactor > 1.0f) {
                    this.bGZ = true;
                    b.this.iFu.dd(true);
                } else if (!this.bGZ && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.bGZ = true;
                    b.this.iFu.dd(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.bGZ = true;
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
