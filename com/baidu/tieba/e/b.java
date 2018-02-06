package com.baidu.tieba.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.e.a {
    private ScaleGestureDetector bIf;
    private a dnB;

    /* loaded from: classes.dex */
    public interface a {
        void fr(boolean z);
    }

    public b(Context context) {
        this.bIf = new ScaleGestureDetector(context, new C0143b());
    }

    public void a(a aVar) {
        this.dnB = aVar;
    }

    /* renamed from: com.baidu.tieba.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0143b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean dnC;

        private C0143b() {
            this.dnC = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.dnC = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.dnB != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.dnC && scaleFactor > 1.0f) {
                    this.dnC = true;
                    b.this.dnB.fr(true);
                } else if (!this.dnC && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.dnC = true;
                    b.this.dnB.fr(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.dnC = true;
        }
    }

    @Override // com.baidu.tieba.e.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.bIf.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
