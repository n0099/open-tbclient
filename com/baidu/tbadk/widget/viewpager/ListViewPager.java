package com.baidu.tbadk.widget.viewpager;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.adp.widget.d;
/* loaded from: classes.dex */
public class ListViewPager extends ViewPager {
    private float aOq;
    private float aSg;
    private float aSh;
    private float aSi;
    private boolean akA;
    private d.c akC;
    private GestureDetector mGestureDetector;

    public ListViewPager(Context context) {
        super(context);
        this.akA = false;
        init();
    }

    public ListViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akA = false;
        init();
    }

    private void init() {
        this.mGestureDetector = new GestureDetector((Context) null, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (ListViewPager.this.akC != null) {
                ListViewPager.this.akC.lq();
            }
            return Math.abs(f) > Math.abs(f2);
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (k(motionEvent)) {
            return true;
        }
        if (this.akA) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (Exception e) {
                return false;
            }
        }
        if (getCurrentItem() != 0 && this.mGestureDetector.onTouchEvent(motionEvent)) {
            aS(true);
        }
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e2) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.akA) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Exception e) {
                return false;
            }
        }
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
            case 5:
            case 6:
                if (this.akC != null) {
                    this.akC.lq();
                }
                this.aOq = motionEvent.getX();
                this.aSg = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.akC != null) {
                    this.akC.lq();
                }
                this.aOq = 0.0f;
                this.aSg = 0.0f;
                this.aSh = 0.0f;
                this.aSi = 0.0f;
                break;
            case 2:
                if (this.akC != null) {
                    this.akC.lq();
                }
                this.aSh = motionEvent.getX() - this.aOq;
                this.aSi = motionEvent.getY() - this.aSg;
                this.aOq = motionEvent.getX();
                this.aSg = motionEvent.getY();
                if (getCurrentItem() != 0 && Math.abs(this.aSh) > Math.abs(this.aSi)) {
                    aS(true);
                    break;
                }
                break;
        }
        if (k(motionEvent)) {
            return true;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e2) {
            return true;
        }
    }

    private void aS(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean k(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        return motionEvent.getPointerId(action) == -1 || action == -1 || action >= motionEvent.getPointerCount();
    }

    public void setSwipeControlInterface(d.c cVar) {
        this.akC = cVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.akA = z;
    }
}
