package com.baidu.tbadk.widget.viewpager;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.adp.widget.SwipeBackLayout;
/* loaded from: classes.dex */
public class ListViewPager extends ViewPager {
    private boolean bZD;
    private float cGq;
    private float cRs;
    private float cRt;
    private float cRu;
    private GestureDetector mGestureDetector;
    private SwipeBackLayout.c mSwipeControlInterface;

    public ListViewPager(Context context) {
        super(context);
        this.bZD = false;
        init();
    }

    public ListViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bZD = false;
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
                ListViewPager.this.mSwipeControlInterface.oF();
            }
            return Math.abs(f) > Math.abs(f2);
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (v(motionEvent)) {
            return true;
        }
        if (this.bZD) {
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
            eA(true);
        }
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e2) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bZD) {
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
                    this.mSwipeControlInterface.oF();
                }
                this.cGq = motionEvent.getX();
                this.cRs = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.mSwipeControlInterface != null) {
                    this.mSwipeControlInterface.oF();
                }
                this.cGq = 0.0f;
                this.cRs = 0.0f;
                this.cRt = 0.0f;
                this.cRu = 0.0f;
                break;
            case 2:
                if (this.mSwipeControlInterface != null) {
                    this.mSwipeControlInterface.oF();
                }
                this.cRt = motionEvent.getX() - this.cGq;
                this.cRu = motionEvent.getY() - this.cRs;
                this.cGq = motionEvent.getX();
                this.cRs = motionEvent.getY();
                if (getCurrentItem() != 0 && Math.abs(this.cRt) > Math.abs(this.cRu)) {
                    eA(true);
                    break;
                }
                break;
        }
        if (v(motionEvent)) {
            return true;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e2) {
            return true;
        }
    }

    private void eA(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean v(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        return motionEvent.getPointerId(action) == -1 || action == -1 || action >= motionEvent.getPointerCount();
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        this.mSwipeControlInterface = cVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.bZD = z;
    }
}
