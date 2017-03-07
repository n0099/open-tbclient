package com.baidu.tbadk.widget.viewpager;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.adp.widget.f;
/* loaded from: classes.dex */
public class ListViewPager extends ViewPager {
    private float aKF;
    private float aOa;
    private float aOb;
    private float aOc;
    private boolean aje;
    private f.c ajg;
    private GestureDetector mGestureDetector;

    public ListViewPager(Context context) {
        super(context);
        this.aje = false;
        init();
    }

    public ListViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aje = false;
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
            if (ListViewPager.this.ajg != null) {
                ListViewPager.this.ajg.lP();
            }
            return Math.abs(f) > Math.abs(f2);
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (g(motionEvent)) {
            return true;
        }
        if (this.aje) {
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
            aP(true);
        }
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e2) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aje) {
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
                if (this.ajg != null) {
                    this.ajg.lP();
                }
                this.aKF = motionEvent.getX();
                this.aOa = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.ajg != null) {
                    this.ajg.lP();
                }
                this.aKF = 0.0f;
                this.aOa = 0.0f;
                this.aOb = 0.0f;
                this.aOc = 0.0f;
                break;
            case 2:
                if (this.ajg != null) {
                    this.ajg.lP();
                }
                this.aOb = motionEvent.getX() - this.aKF;
                this.aOc = motionEvent.getY() - this.aOa;
                this.aKF = motionEvent.getX();
                this.aOa = motionEvent.getY();
                if (getCurrentItem() != 0 && Math.abs(this.aOb) > Math.abs(this.aOc)) {
                    aP(true);
                    break;
                }
                break;
        }
        if (g(motionEvent)) {
            return true;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e2) {
            return true;
        }
    }

    private void aP(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean g(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        return motionEvent.getPointerId(action) == -1 || action == -1 || action >= motionEvent.getPointerCount();
    }

    public void setSwipeControlInterface(f.c cVar) {
        this.ajg = cVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.aje = z;
    }
}
