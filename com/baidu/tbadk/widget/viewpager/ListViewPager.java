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
    private float aLh;
    private float aOL;
    private float aOM;
    private float aON;
    private boolean aiQ;
    private f.c aiS;
    private GestureDetector mGestureDetector;

    public ListViewPager(Context context) {
        super(context);
        this.aiQ = false;
        init();
    }

    public ListViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiQ = false;
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
            if (ListViewPager.this.aiS != null) {
                ListViewPager.this.aiS.lB();
            }
            return Math.abs(f) > Math.abs(f2);
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (k(motionEvent)) {
            return true;
        }
        if (this.aiQ) {
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
            aR(true);
        }
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e2) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aiQ) {
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
                if (this.aiS != null) {
                    this.aiS.lB();
                }
                this.aLh = motionEvent.getX();
                this.aOL = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.aiS != null) {
                    this.aiS.lB();
                }
                this.aLh = 0.0f;
                this.aOL = 0.0f;
                this.aOM = 0.0f;
                this.aON = 0.0f;
                break;
            case 2:
                if (this.aiS != null) {
                    this.aiS.lB();
                }
                this.aOM = motionEvent.getX() - this.aLh;
                this.aON = motionEvent.getY() - this.aOL;
                this.aLh = motionEvent.getX();
                this.aOL = motionEvent.getY();
                if (getCurrentItem() != 0 && Math.abs(this.aOM) > Math.abs(this.aON)) {
                    aR(true);
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

    private void aR(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean k(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        return motionEvent.getPointerId(action) == -1 || action == -1 || action >= motionEvent.getPointerCount();
    }

    public void setSwipeControlInterface(f.c cVar) {
        this.aiS = cVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.aiQ = z;
    }
}
