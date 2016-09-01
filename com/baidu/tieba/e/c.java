package com.baidu.tieba.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.e.a {
    private ScaleGestureDetector bkV;
    private a bkW;

    /* loaded from: classes.dex */
    public interface a {
        void cM(boolean z);
    }

    public c(Context context) {
        this.bkV = new ScaleGestureDetector(context, new b(this, null));
    }

    public void a(a aVar) {
        this.bkW = aVar;
    }

    /* loaded from: classes.dex */
    private final class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean bkX;

        private b() {
            this.bkX = false;
        }

        /* synthetic */ b(c cVar, b bVar) {
            this();
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.bkX = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && c.this.bkW != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.bkX && scaleFactor > 1.0f) {
                    this.bkX = true;
                    c.this.bkW.cM(true);
                } else if (!this.bkX && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.bkX = true;
                    c.this.bkW.cM(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.bkX = true;
        }
    }

    @Override // com.baidu.tieba.e.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.bkV.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
