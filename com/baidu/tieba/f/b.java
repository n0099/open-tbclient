package com.baidu.tieba.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.f.a {
    private ScaleGestureDetector box;
    private a dpv;

    /* loaded from: classes.dex */
    public interface a {
        void gb(boolean z);
    }

    public b(Context context) {
        this.box = new ScaleGestureDetector(context, new C0215b());
    }

    public void a(a aVar) {
        this.dpv = aVar;
    }

    /* renamed from: com.baidu.tieba.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0215b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean dpw;

        private C0215b() {
            this.dpw = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.dpw = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.dpv != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.dpw && scaleFactor > 1.0f) {
                    this.dpw = true;
                    b.this.dpv.gb(true);
                } else if (!this.dpw && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.dpw = true;
                    b.this.dpv.gb(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.dpw = true;
        }
    }

    @Override // com.baidu.tieba.f.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.box.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
