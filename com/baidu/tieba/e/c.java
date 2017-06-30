package com.baidu.tieba.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.e.a {
    private ScaleGestureDetector bQT;
    private a bQU;

    /* loaded from: classes.dex */
    public interface a {
        void dV(boolean z);
    }

    public c(Context context) {
        this.bQT = new ScaleGestureDetector(context, new b(this, null));
    }

    public void a(a aVar) {
        this.bQU = aVar;
    }

    /* loaded from: classes.dex */
    private final class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean bQV;

        private b() {
            this.bQV = false;
        }

        /* synthetic */ b(c cVar, b bVar) {
            this();
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.bQV = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && c.this.bQU != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.bQV && scaleFactor > 1.0f) {
                    this.bQV = true;
                    c.this.bQU.dV(true);
                } else if (!this.bQV && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.bQV = true;
                    c.this.bQU.dV(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.bQV = true;
        }
    }

    @Override // com.baidu.tieba.e.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.bQT.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
