package com.baidu.tieba.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.e.a {
    private ScaleGestureDetector aON;
    private a cic;

    /* loaded from: classes.dex */
    public interface a {
        void ea(boolean z);
    }

    public b(Context context) {
        this.aON = new ScaleGestureDetector(context, new C0082b());
    }

    public void a(a aVar) {
        this.cic = aVar;
    }

    /* renamed from: com.baidu.tieba.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0082b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean cie;

        private C0082b() {
            this.cie = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.cie = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.cic != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.cie && scaleFactor > 1.0f) {
                    this.cie = true;
                    b.this.cic.ea(true);
                } else if (!this.cie && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.cie = true;
                    b.this.cic.ea(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.cie = true;
        }
    }

    @Override // com.baidu.tieba.e.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.aON.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
