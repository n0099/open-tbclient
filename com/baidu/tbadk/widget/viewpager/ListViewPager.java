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
    private float aNX;
    private float aSS;
    private float aST;
    private float aSU;
    private boolean akp;
    private d.c akr;
    private GestureDetector mGestureDetector;

    public ListViewPager(Context context) {
        super(context);
        this.akp = false;
        init();
    }

    public ListViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akp = false;
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
            if (ListViewPager.this.akr != null) {
                ListViewPager.this.akr.ls();
            }
            return Math.abs(f) > Math.abs(f2);
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (k(motionEvent)) {
            return true;
        }
        if (this.akp) {
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
            aQ(true);
        }
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e2) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.akp) {
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
                if (this.akr != null) {
                    this.akr.ls();
                }
                this.aNX = motionEvent.getX();
                this.aSS = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.akr != null) {
                    this.akr.ls();
                }
                this.aNX = 0.0f;
                this.aSS = 0.0f;
                this.aST = 0.0f;
                this.aSU = 0.0f;
                break;
            case 2:
                if (this.akr != null) {
                    this.akr.ls();
                }
                this.aST = motionEvent.getX() - this.aNX;
                this.aSU = motionEvent.getY() - this.aSS;
                this.aNX = motionEvent.getX();
                this.aSS = motionEvent.getY();
                if (getCurrentItem() != 0 && Math.abs(this.aST) > Math.abs(this.aSU)) {
                    aQ(true);
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

    private void aQ(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean k(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        return motionEvent.getPointerId(action) == -1 || action == -1 || action >= motionEvent.getPointerCount();
    }

    public void setSwipeControlInterface(d.c cVar) {
        this.akr = cVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.akp = z;
    }
}
