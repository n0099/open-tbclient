package com.baidu.tieba.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.f.a {
    private ScaleGestureDetector bvk;
    private a bvl;

    /* loaded from: classes.dex */
    public interface a {
        void db(boolean z);
    }

    public c(Context context) {
        this.bvk = new ScaleGestureDetector(context, new b(this, null));
    }

    public void a(a aVar) {
        this.bvl = aVar;
    }

    /* loaded from: classes.dex */
    private final class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean bvm;

        private b() {
            this.bvm = false;
        }

        /* synthetic */ b(c cVar, b bVar) {
            this();
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.bvm = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && c.this.bvl != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.bvm && scaleFactor > 1.0f) {
                    this.bvm = true;
                    c.this.bvl.db(true);
                } else if (!this.bvm && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.bvm = true;
                    c.this.bvl.db(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.bvm = true;
        }
    }

    @Override // com.baidu.tieba.f.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.bvk.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
