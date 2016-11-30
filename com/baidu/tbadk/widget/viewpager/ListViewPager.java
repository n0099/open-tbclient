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
    private float aGZ;
    private float aKF;
    private float aKG;
    private float aKH;
    private boolean afl;
    private f.c afn;
    private GestureDetector mGestureDetector;

    public ListViewPager(Context context) {
        super(context);
        this.afl = false;
        init();
    }

    public ListViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afl = false;
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
            if (ListViewPager.this.afn != null) {
                ListViewPager.this.afn.ld();
            }
            return Math.abs(f) > Math.abs(f2);
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (h(motionEvent)) {
            return true;
        }
        if (this.afl) {
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
        if (this.afl) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (Exception e) {
                return false;
            }
        }
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
            case 5:
            case 6:
                if (this.afn != null) {
                    this.afn.ld();
                }
                this.aGZ = motionEvent.getX();
                this.aKF = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.afn != null) {
                    this.afn.ld();
                }
                this.aGZ = 0.0f;
                this.aKF = 0.0f;
                this.aKG = 0.0f;
                this.aKH = 0.0f;
                break;
            case 2:
                if (this.afn != null) {
                    this.afn.ld();
                }
                this.aKG = motionEvent.getX() - this.aGZ;
                this.aKH = motionEvent.getY() - this.aKF;
                this.aGZ = motionEvent.getX();
                this.aKF = motionEvent.getY();
                if (getCurrentItem() != 0 && Math.abs(this.aKG) > Math.abs(this.aKH)) {
                    aP(true);
                    break;
                }
                break;
        }
        if (h(motionEvent)) {
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

    private boolean h(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        return motionEvent.getPointerId(action) == -1 || action == -1 || action >= motionEvent.getPointerCount();
    }

    public void setSwipeControlInterface(f.c cVar) {
        this.afn = cVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.afl = z;
    }
}
