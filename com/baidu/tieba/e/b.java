package com.baidu.tieba.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.e.a {
    private ScaleGestureDetector bHV;
    private a dns;

    /* loaded from: classes.dex */
    public interface a {
        void fr(boolean z);
    }

    public b(Context context) {
        this.bHV = new ScaleGestureDetector(context, new C0144b());
    }

    public void a(a aVar) {
        this.dns = aVar;
    }

    /* renamed from: com.baidu.tieba.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private final class C0144b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private boolean dnt;

        private C0144b() {
            this.dnt = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.dnt = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.dns != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.dnt && scaleFactor > 1.0f) {
                    this.dnt = true;
                    b.this.dns.fr(true);
                } else if (!this.dnt && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.dnt = true;
                    b.this.dns.fr(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.dnt = true;
        }
    }

    @Override // com.baidu.tieba.e.a
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.bHV.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }
}
