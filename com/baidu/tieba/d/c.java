package com.baidu.tieba.d;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.d.a {
    private ScaleGestureDetector boe;
    private a bof;

    /* loaded from: classes.dex */
    public interface a {
        void cS(boolean z);
    }

    public c(Context context) {
        this.boe = new ScaleGestureDetector(context, new b(this, null));
    }

    public void a(a aVar) {
        this.bof = aVar;
    }

    /* loaded from: classes.dex */
    private final class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean bog;

        private b() {
            this.bog = false;
        }

        /* synthetic */ b(c cVar, b bVar) {
            this();
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.bog = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && c.this.bof != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.bog && scaleFactor > 1.0f) {
                    this.bog = true;
                    c.this.bof.cS(true);
                } else if (!this.bog && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.bog = true;
                    c.this.bof.cS(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.bog = true;
        }
    }

    @Override // com.baidu.tieba.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.boe.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
