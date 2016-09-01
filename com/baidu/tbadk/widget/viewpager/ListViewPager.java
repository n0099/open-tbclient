package com.baidu.tbadk.widget.viewpager;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class ListViewPager extends ViewPager {
    private float aGK;
    private float aKn;
    private float aKo;
    private float aKp;
    private GestureDetector mGestureDetector;

    public ListViewPager(Context context) {
        super(context);
        init();
    }

    public ListViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.mGestureDetector = new GestureDetector((Context) null, new a(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        /* synthetic */ a(ListViewPager listViewPager, a aVar) {
            this();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return Math.abs(f) > Math.abs(f2);
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (g(motionEvent)) {
            return true;
        }
        if (getCurrentItem() != 0 && this.mGestureDetector.onTouchEvent(motionEvent)) {
            aN(true);
        }
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
            case 5:
            case 6:
                this.aGK = motionEvent.getX();
                this.aKn = motionEvent.getY();
                break;
            case 1:
            case 3:
                this.aGK = 0.0f;
                this.aKn = 0.0f;
                this.aKo = 0.0f;
                this.aKp = 0.0f;
                break;
            case 2:
                this.aKo = motionEvent.getX() - this.aGK;
                this.aKp = motionEvent.getY() - this.aKn;
                this.aGK = motionEvent.getX();
                this.aKn = motionEvent.getY();
                if (getCurrentItem() != 0 && Math.abs(this.aKo) > Math.abs(this.aKp)) {
                    aN(true);
                    break;
                }
                break;
        }
        if (g(motionEvent)) {
            return true;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    private void aN(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean g(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        return motionEvent.getPointerId(action) == -1 || action == -1 || action >= motionEvent.getPointerCount();
    }
}
