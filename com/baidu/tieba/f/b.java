package com.baidu.tieba.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.f.a {
    private ScaleGestureDetector baJ;
    private a cPu;

    /* loaded from: classes.dex */
    public interface a {
        void fb(boolean z);
    }

    public b(Context context) {
        this.baJ = new ScaleGestureDetector(context, new C0147b());
    }

    public void a(a aVar) {
        this.cPu = aVar;
    }

    /* renamed from: com.baidu.tieba.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0147b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean cPv;

        private C0147b() {
            this.cPv = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.cPv = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.cPu != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.cPv && scaleFactor > 1.0f) {
                    this.cPv = true;
                    b.this.cPu.fb(true);
                } else if (!this.cPv && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.cPv = true;
                    b.this.cPu.fb(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.cPv = true;
        }
    }

    @Override // com.baidu.tieba.f.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.baJ.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
