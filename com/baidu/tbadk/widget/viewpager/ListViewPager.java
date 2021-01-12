package com.baidu.tbadk.widget.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.core.view.MotionEventCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.SwipeBackLayout;
/* loaded from: classes.dex */
public class ListViewPager extends ViewPager {
    private float fYr;
    private float fYs;
    private float fYt;
    private boolean feb;
    private float lastX;
    private GestureDetector mGestureDetector;
    private SwipeBackLayout.c mSwipeControlInterface;

    public ListViewPager(Context context) {
        super(context);
        this.feb = false;
        init();
    }

    public ListViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.feb = false;
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
                ListViewPager.this.mSwipeControlInterface.enableSwipeBack();
            }
            return Math.abs(f) > Math.abs(f2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (isInvalidPointer(motionEvent)) {
            return true;
        }
        if (this.feb) {
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
            requestParentInterceptTouchEvent(true);
        }
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e2) {
            return false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.feb) {
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
                    this.mSwipeControlInterface.enableSwipeBack();
                }
                this.lastX = motionEvent.getX();
                this.fYr = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.mSwipeControlInterface != null) {
                    this.mSwipeControlInterface.enableSwipeBack();
                }
                this.lastX = 0.0f;
                this.fYr = 0.0f;
                this.fYs = 0.0f;
                this.fYt = 0.0f;
                break;
            case 2:
                if (this.mSwipeControlInterface != null) {
                    this.mSwipeControlInterface.enableSwipeBack();
                }
                this.fYs = motionEvent.getX() - this.lastX;
                this.fYt = motionEvent.getY() - this.fYr;
                this.lastX = motionEvent.getX();
                this.fYr = motionEvent.getY();
                if (getCurrentItem() != 0 && Math.abs(this.fYs) > Math.abs(this.fYt)) {
                    requestParentInterceptTouchEvent(true);
                    break;
                }
                break;
        }
        if (isInvalidPointer(motionEvent)) {
            return true;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e2) {
            return true;
        }
    }

    private void requestParentInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean isInvalidPointer(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        return motionEvent.getPointerId(action) == -1 || action == -1 || action >= motionEvent.getPointerCount();
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        this.mSwipeControlInterface = cVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.feb = z;
    }
}
