package com.baidu.tbadk.widget;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class TbViewPager extends ViewPager {
    private float aFY;
    private boolean aih;
    private int mTouchSlop;

    public TbViewPager(Context context) {
        super(context);
        this.aih = false;
        init();
    }

    public TbViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aih = false;
        init();
    }

    private void init() {
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        this.aih = z;
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (d(motionEvent)) {
            return true;
        }
        if (motionEvent.getPointerCount() > 1 && this.aih) {
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
        if (d(motionEvent)) {
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
                aF(true);
                this.aFY = motionEvent.getX();
                break;
            case 1:
            case 3:
                aF(false);
                this.aFY = 0.0f;
                break;
            case 2:
                float x = motionEvent.getX() - this.aFY;
                if (getCurrentItem() == 0) {
                    if (x >= this.mTouchSlop) {
                        aF(false);
                        break;
                    } else {
                        aF(true);
                        break;
                    }
                } else if (getCurrentItem() == getAdapter().getCount() - 1) {
                    if (x <= (-this.mTouchSlop)) {
                        aF(false);
                        break;
                    } else {
                        aF(true);
                        break;
                    }
                }
                break;
        }
        if (d(motionEvent)) {
            return true;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    private boolean d(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        return motionEvent.getPointerId(action) == -1 || action == -1 || action >= motionEvent.getPointerCount();
    }

    private void aF(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
