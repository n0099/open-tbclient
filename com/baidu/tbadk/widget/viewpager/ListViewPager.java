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
    private float aOt;
    private float aSj;
    private float aSk;
    private float aSl;
    private boolean akB;
    private d.c akD;
    private GestureDetector mGestureDetector;

    public ListViewPager(Context context) {
        super(context);
        this.akB = false;
        init();
    }

    public ListViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akB = false;
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
            if (ListViewPager.this.akD != null) {
                ListViewPager.this.akD.lq();
            }
            return Math.abs(f) > Math.abs(f2);
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (k(motionEvent)) {
            return true;
        }
        if (this.akB) {
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
        if (this.akB) {
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
                if (this.akD != null) {
                    this.akD.lq();
                }
                this.aOt = motionEvent.getX();
                this.aSj = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.akD != null) {
                    this.akD.lq();
                }
                this.aOt = 0.0f;
                this.aSj = 0.0f;
                this.aSk = 0.0f;
                this.aSl = 0.0f;
                break;
            case 2:
                if (this.akD != null) {
                    this.akD.lq();
                }
                this.aSk = motionEvent.getX() - this.aOt;
                this.aSl = motionEvent.getY() - this.aSj;
                this.aOt = motionEvent.getX();
                this.aSj = motionEvent.getY();
                if (getCurrentItem() != 0 && Math.abs(this.aSk) > Math.abs(this.aSl)) {
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
        this.akD = cVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.akB = z;
    }
}
