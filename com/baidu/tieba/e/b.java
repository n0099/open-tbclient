package com.baidu.tieba.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.e.a {
    private ScaleGestureDetector aRV;
    private a crg;

    /* loaded from: classes.dex */
    public interface a {
        void ex(boolean z);
    }

    public b(Context context) {
        this.aRV = new ScaleGestureDetector(context, new C0098b());
    }

    public void a(a aVar) {
        this.crg = aVar;
    }

    /* renamed from: com.baidu.tieba.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0098b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean crh;

        private C0098b() {
            this.crh = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.crh = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.crg != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.crh && scaleFactor > 1.0f) {
                    this.crh = true;
                    b.this.crg.ex(true);
                } else if (!this.crh && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.crh = true;
                    b.this.crg.ex(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.crh = true;
        }
    }

    @Override // com.baidu.tieba.e.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.aRV.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
