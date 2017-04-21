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
    private float aKX;
    private float aOs;
    private float aOt;
    private float aOu;
    private boolean ajt;
    private f.c ajv;
    private GestureDetector mGestureDetector;

    public ListViewPager(Context context) {
        super(context);
        this.ajt = false;
        init();
    }

    public ListViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajt = false;
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
            if (ListViewPager.this.ajv != null) {
                ListViewPager.this.ajv.lU();
            }
            return Math.abs(f) > Math.abs(f2);
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (k(motionEvent)) {
            return true;
        }
        if (this.ajt) {
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
        if (this.ajt) {
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
                if (this.ajv != null) {
                    this.ajv.lU();
                }
                this.aKX = motionEvent.getX();
                this.aOs = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.ajv != null) {
                    this.ajv.lU();
                }
                this.aKX = 0.0f;
                this.aOs = 0.0f;
                this.aOt = 0.0f;
                this.aOu = 0.0f;
                break;
            case 2:
                if (this.ajv != null) {
                    this.ajv.lU();
                }
                this.aOt = motionEvent.getX() - this.aKX;
                this.aOu = motionEvent.getY() - this.aOs;
                this.aKX = motionEvent.getX();
                this.aOs = motionEvent.getY();
                if (getCurrentItem() != 0 && Math.abs(this.aOt) > Math.abs(this.aOu)) {
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
        this.ajv = cVar;
    }

    public void setDisableParentEvent(boolean z) {
        this.ajt = z;
    }
}
