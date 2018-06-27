package com.baidu.tbadk.widget;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class TbViewPager extends ViewPager {
    private float aYk;
    private boolean azL;
    private int mDuration;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public class a extends Scroller {
        public a(Context context) {
            super(context);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4, int i5) {
            super.startScroll(i, i2, i3, i4, TbViewPager.this.mDuration);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4) {
            super.startScroll(i, i2, i3, i4, TbViewPager.this.mDuration);
        }

        public void b(ViewPager viewPager) {
            try {
                Field declaredField = ViewPager.class.getDeclaredField("mScroller");
                declaredField.setAccessible(true);
                declaredField.set(viewPager, this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setViewPagerScroll(int i) {
        this.mDuration = i;
        new a(getContext()).b(this);
    }

    public void setViewPagerScroll() {
        setViewPagerScroll(600);
    }

    public int getScrollingDuration() {
        return this.mDuration;
    }

    public TbViewPager(Context context) {
        super(context);
        this.azL = false;
        this.mDuration = 600;
        init();
    }

    public TbViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azL = false;
        this.mDuration = 600;
        init();
    }

    private void init() {
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        this.azL = z;
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (q(motionEvent)) {
            return true;
        }
        if (motionEvent.getPointerCount() > 1 && this.azL) {
            requestDisallowInterceptTouchEvent(false);
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            requestDisallowInterceptTouchEvent(true);
            return dispatchTouchEvent;
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (q(motionEvent)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
            case 5:
            case 6:
                aZ(true);
                this.aYk = motionEvent.getX();
                break;
            case 1:
            case 3:
                aZ(false);
                this.aYk = 0.0f;
                break;
            case 2:
                float x = motionEvent.getX() - this.aYk;
                if (getCurrentItem() == 0) {
                    if (x >= this.mTouchSlop) {
                        aZ(false);
                        break;
                    } else {
                        aZ(true);
                        break;
                    }
                } else if (getCurrentItem() == getAdapter().getCount() - 1) {
                    if (x <= (-this.mTouchSlop)) {
                        aZ(false);
                        break;
                    } else {
                        aZ(true);
                        break;
                    }
                }
                break;
        }
        if (q(motionEvent)) {
            return true;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    private boolean q(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        return motionEvent.getPointerId(action) == -1 || action == -1 || action >= motionEvent.getPointerCount();
    }

    private void aZ(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
