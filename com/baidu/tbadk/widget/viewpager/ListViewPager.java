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
    private float bFd;
    private float bMv;
    private float bMw;
    private float bMx;
    private boolean bbd;
    private GestureDetector mGestureDetector;
    private d.c mSwipeControlInterface;

    public ListViewPager(Context context) {
        super(context);
        this.bbd = false;
        init();
    }

    public ListViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbd = false;
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
            if (ListViewPager.this.mSwipeControlInterface != null) {
                ListViewPager.this.mSwipeControlInterface.sJ();
            }
            return Math.abs(f) > Math.abs(f2);
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (x(motionEvent)) {
            return true;
        }
        if (this.bbd) {
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
            bB(true);
        }
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e2) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bbd) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Exception e) {
                return false;
            }
        }
        switch (motionEvent.getAction() & 255) {
            case 0:
            case 5:
            case 6:
                if (this.mSwipeControlInterface != null) {
                    this.mSwipeControlInterface.sJ();
                }
                this.bFd = motionEvent.getX();
                this.bMv = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.mSwipeControlInterface != null) {
                    this.mSwipeControlInterface.sJ();
                }
                this.bFd = 0.0f;
                this.bMv = 0.0f;
                this.bMw = 0.0f;
                this.bMx = 0.0f;
                break;
            case 2:
                if (this.mSwipeControlInterface != null) {
                    this.mSwipeControlInterface.sJ();
                }
                this.bMw = motionEvent.getX() - this.bFd;
                this.bMx = motionEvent.getY() - this.bMv;
                this.bFd = motionEvent.getX();
                this.bMv = motionEvent.getY();
                if (getCurrentItem() != 0 && Math.abs(this.bMw) > Math.abs(this.bMx)) {
                    bB(true);
                    break;
                }
                break;
        }
        if (x(motionEvent)) {
            return true;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e2) {
            return true;
        }
    }

    private void bB(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean x(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        return motionEvent.getPointerId(action) == -1 || action == -1 || action >= motionEvent.getPointerCount();
    }

    public void setSwipeControlInterface(d.c cVar) {
        this.mSwipeControlInterface = cVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.bbd = z;
    }
}
