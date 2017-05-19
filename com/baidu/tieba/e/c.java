package com.baidu.tieba.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.e.a {
    private ScaleGestureDetector bEH;
    private a bEI;

    /* loaded from: classes.dex */
    public interface a {
        void dp(boolean z);
    }

    public c(Context context) {
        this.bEH = new ScaleGestureDetector(context, new b(this, null));
    }

    public void a(a aVar) {
        this.bEI = aVar;
    }

    /* loaded from: classes.dex */
    private final class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean bEJ;

        private b() {
            this.bEJ = false;
        }

        /* synthetic */ b(c cVar, b bVar) {
            this();
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.bEJ = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && c.this.bEI != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.bEJ && scaleFactor > 1.0f) {
                    this.bEJ = true;
                    c.this.bEI.dp(true);
                } else if (!this.bEJ && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.bEJ = true;
                    c.this.bEI.dp(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.bEJ = true;
        }
    }

    @Override // com.baidu.tieba.e.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.bEH.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
