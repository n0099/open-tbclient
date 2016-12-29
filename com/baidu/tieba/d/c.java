package com.baidu.tieba.d;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.d.a {
    private ScaleGestureDetector bnx;
    private a bny;

    /* loaded from: classes.dex */
    public interface a {
        void cU(boolean z);
    }

    public c(Context context) {
        this.bnx = new ScaleGestureDetector(context, new b(this, null));
    }

    public void a(a aVar) {
        this.bny = aVar;
    }

    /* loaded from: classes.dex */
    private final class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean bnz;

        private b() {
            this.bnz = false;
        }

        /* synthetic */ b(c cVar, b bVar) {
            this();
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.bnz = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && c.this.bny != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.bnz && scaleFactor > 1.0f) {
                    this.bnz = true;
                    c.this.bny.cU(true);
                } else if (!this.bnz && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.bnz = true;
                    c.this.bny.cU(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.bnz = true;
        }
    }

    @Override // com.baidu.tieba.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.bnx.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
