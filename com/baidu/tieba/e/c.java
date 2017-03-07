package com.baidu.tieba.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.e.a {
    private ScaleGestureDetector bCq;
    private a bCr;

    /* loaded from: classes.dex */
    public interface a {
        void db(boolean z);
    }

    public c(Context context) {
        this.bCq = new ScaleGestureDetector(context, new b(this, null));
    }

    public void a(a aVar) {
        this.bCr = aVar;
    }

    /* loaded from: classes.dex */
    private final class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean bCs;

        private b() {
            this.bCs = false;
        }

        /* synthetic */ b(c cVar, b bVar) {
            this();
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.bCs = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && c.this.bCr != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.bCs && scaleFactor > 1.0f) {
                    this.bCs = true;
                    c.this.bCr.db(true);
                } else if (!this.bCs && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.bCs = true;
                    c.this.bCr.db(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.bCs = true;
        }
    }

    @Override // com.baidu.tieba.e.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.bCq.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
