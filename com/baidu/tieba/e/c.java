package com.baidu.tieba.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.e.a {
    private ScaleGestureDetector bEA;
    private a bEB;

    /* loaded from: classes.dex */
    public interface a {
        void dn(boolean z);
    }

    public c(Context context) {
        this.bEA = new ScaleGestureDetector(context, new b(this, null));
    }

    public void a(a aVar) {
        this.bEB = aVar;
    }

    /* loaded from: classes.dex */
    private final class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean bEC;

        private b() {
            this.bEC = false;
        }

        /* synthetic */ b(c cVar, b bVar) {
            this();
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.bEC = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && c.this.bEB != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.bEC && scaleFactor > 1.0f) {
                    this.bEC = true;
                    c.this.bEB.dn(true);
                } else if (!this.bEC && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.bEC = true;
                    c.this.bEB.dn(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.bEC = true;
        }
    }

    @Override // com.baidu.tieba.e.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.bEA.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
