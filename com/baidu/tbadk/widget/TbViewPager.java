package com.baidu.tbadk.widget;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import com.baidu.tbadk.TbConfig;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class TbViewPager extends ViewPager {
    private int HV;
    private float aNX;
    private boolean aoJ;
    private int mTouchSlop;

    /* loaded from: classes.dex */
    public class a extends Scroller {
        public a(Context context) {
            super(context);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4, int i5) {
            super.startScroll(i, i2, i3, i4, TbViewPager.this.HV);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4) {
            super.startScroll(i, i2, i3, i4, TbViewPager.this.HV);
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
        this.HV = i;
        new a(getContext()).b(this);
    }

    public int getScrollingDuration() {
        return this.HV;
    }

    public TbViewPager(Context context) {
        super(context);
        this.aoJ = false;
        this.HV = TbConfig.POST_IMAGE_SMALL;
        init();
    }

    public TbViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aoJ = false;
        this.HV = TbConfig.POST_IMAGE_SMALL;
        init();
    }

    private void init() {
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        this.aoJ = z;
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (k(motionEvent)) {
            return true;
        }
        if (motionEvent.getPointerCount() > 1 && this.aoJ) {
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
        if (k(motionEvent)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
            case 5:
            case 6:
                aQ(true);
                this.aNX = motionEvent.getX();
                break;
            case 1:
            case 3:
                aQ(false);
                this.aNX = 0.0f;
                break;
            case 2:
                float x = motionEvent.getX() - this.aNX;
                if (getCurrentItem() == 0) {
                    if (x >= this.mTouchSlop) {
                        aQ(false);
                        break;
                    } else {
                        aQ(true);
                        break;
                    }
                } else if (getCurrentItem() == getAdapter().getCount() - 1) {
                    if (x <= (-this.mTouchSlop)) {
                        aQ(false);
                        break;
                    } else {
                        aQ(true);
                        break;
                    }
                }
                break;
        }
        if (k(motionEvent)) {
            return true;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    private boolean k(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        return motionEvent.getPointerId(action) == -1 || action == -1 || action >= motionEvent.getPointerCount();
    }

    private void aQ(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
