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
    private float aYq;
    private boolean auO;
    private float bgH;
    private float bgI;
    private float bgJ;
    private GestureDetector mGestureDetector;
    private SwipeBackLayout.c mSwipeControlInterface;

    public ListViewPager(Context context) {
        super(context);
        this.auO = false;
        init();
    }

    public ListViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auO = false;
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
                ListViewPager.this.mSwipeControlInterface.nI();
            }
            return Math.abs(f) > Math.abs(f2);
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (r(motionEvent)) {
            return true;
        }
        if (this.auO) {
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
            aX(true);
        }
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e2) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.auO) {
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
                    this.mSwipeControlInterface.nI();
                }
                this.aYq = motionEvent.getX();
                this.bgH = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.mSwipeControlInterface != null) {
                    this.mSwipeControlInterface.nI();
                }
                this.aYq = 0.0f;
                this.bgH = 0.0f;
                this.bgI = 0.0f;
                this.bgJ = 0.0f;
                break;
            case 2:
                if (this.mSwipeControlInterface != null) {
                    this.mSwipeControlInterface.nI();
                }
                this.bgI = motionEvent.getX() - this.aYq;
                this.bgJ = motionEvent.getY() - this.bgH;
                this.aYq = motionEvent.getX();
                this.bgH = motionEvent.getY();
                if (getCurrentItem() != 0 && Math.abs(this.bgI) > Math.abs(this.bgJ)) {
                    aX(true);
                    break;
                }
                break;
        }
        if (r(motionEvent)) {
            return true;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e2) {
            return true;
        }
    }

    private void aX(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean r(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        return motionEvent.getPointerId(action) == -1 || action == -1 || action >= motionEvent.getPointerCount();
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        this.mSwipeControlInterface = cVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.auO = z;
    }
}
