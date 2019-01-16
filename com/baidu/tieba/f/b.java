package com.baidu.tieba.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.f.a {
    private ScaleGestureDetector bow;
    private a dpu;

    /* loaded from: classes.dex */
    public interface a {
        void gb(boolean z);
    }

    public b(Context context) {
        this.bow = new ScaleGestureDetector(context, new C0215b());
    }

    public void a(a aVar) {
        this.dpu = aVar;
    }

    /* renamed from: com.baidu.tieba.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0215b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean dpv;

        private C0215b() {
            this.dpv = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.dpv = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.dpu != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.dpv && scaleFactor > 1.0f) {
                    this.dpv = true;
                    b.this.dpu.gb(true);
                } else if (!this.dpv && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.dpv = true;
                    b.this.dpu.gb(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.dpv = true;
        }
    }

    @Override // com.baidu.tieba.f.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.bow.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
