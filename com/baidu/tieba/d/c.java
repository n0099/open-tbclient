package com.baidu.tieba.d;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.d.a {
    private ScaleGestureDetector bli;
    private a blj;

    /* loaded from: classes.dex */
    public interface a {
        void cN(boolean z);
    }

    public c(Context context) {
        this.bli = new ScaleGestureDetector(context, new b(this, null));
    }

    public void a(a aVar) {
        this.blj = aVar;
    }

    /* loaded from: classes.dex */
    private final class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean blk;

        private b() {
            this.blk = false;
        }

        /* synthetic */ b(c cVar, b bVar) {
            this();
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.blk = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && c.this.blj != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.blk && scaleFactor > 1.0f) {
                    this.blk = true;
                    c.this.blj.cN(true);
                } else if (!this.blk && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.blk = true;
                    c.this.blj.cN(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.blk = true;
        }
    }

    @Override // com.baidu.tieba.d.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.bli.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
