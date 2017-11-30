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
    private float aON;
    private float aWf;
    private float aWg;
    private float aWh;
    private boolean alh;
    private d.c alj;
    private GestureDetector mGestureDetector;

    public ListViewPager(Context context) {
        super(context);
        this.alh = false;
        init();
    }

    public ListViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alh = false;
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
            if (ListViewPager.this.alj != null) {
                ListViewPager.this.alj.lm();
            }
            return Math.abs(f) > Math.abs(f2);
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (k(motionEvent)) {
            return true;
        }
        if (this.alh) {
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
            aO(true);
        }
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e2) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.alh) {
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
                if (this.alj != null) {
                    this.alj.lm();
                }
                this.aON = motionEvent.getX();
                this.aWf = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.alj != null) {
                    this.alj.lm();
                }
                this.aON = 0.0f;
                this.aWf = 0.0f;
                this.aWg = 0.0f;
                this.aWh = 0.0f;
                break;
            case 2:
                if (this.alj != null) {
                    this.alj.lm();
                }
                this.aWg = motionEvent.getX() - this.aON;
                this.aWh = motionEvent.getY() - this.aWf;
                this.aON = motionEvent.getX();
                this.aWf = motionEvent.getY();
                if (getCurrentItem() != 0 && Math.abs(this.aWg) > Math.abs(this.aWh)) {
                    aO(true);
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

    private void aO(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean k(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        return motionEvent.getPointerId(action) == -1 || action == -1 || action >= motionEvent.getPointerCount();
    }

    public void setSwipeControlInterface(d.c cVar) {
        this.alj = cVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.alh = z;
    }
}
