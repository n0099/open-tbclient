package com.baidu.tieba.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.f.a {
    private ScaleGestureDetector bbM;
    private a cPX;

    /* loaded from: classes.dex */
    public interface a {
        void fc(boolean z);
    }

    public b(Context context) {
        this.bbM = new ScaleGestureDetector(context, new C0146b());
    }

    public void a(a aVar) {
        this.cPX = aVar;
    }

    /* renamed from: com.baidu.tieba.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0146b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean cPY;

        private C0146b() {
            this.cPY = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.cPY = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.cPX != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.cPY && scaleFactor > 1.0f) {
                    this.cPY = true;
                    b.this.cPX.fc(true);
                } else if (!this.cPY && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.cPY = true;
                    b.this.cPX.fc(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.cPY = true;
        }
    }

    @Override // com.baidu.tieba.f.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.bbM.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
