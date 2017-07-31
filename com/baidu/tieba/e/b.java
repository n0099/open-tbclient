package com.baidu.tieba.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.e.a {
    private ScaleGestureDetector bWh;
    private a bWi;

    /* loaded from: classes.dex */
    public interface a {
        void ee(boolean z);
    }

    public b(Context context) {
        this.bWh = new ScaleGestureDetector(context, new C0080b());
    }

    public void a(a aVar) {
        this.bWi = aVar;
    }

    /* renamed from: com.baidu.tieba.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0080b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean bWj;

        private C0080b() {
            this.bWj = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.bWj = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.bWi != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.bWj && scaleFactor > 1.0f) {
                    this.bWj = true;
                    b.this.bWi.ee(true);
                } else if (!this.bWj && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.bWj = true;
                    b.this.bWi.ee(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.bWj = true;
        }
    }

    @Override // com.baidu.tieba.e.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.bWh.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
