package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class RelateForumViewPager extends ViewPager {
    private boolean azW;

    /* loaded from: classes.dex */
    public interface a {
        void destory();
    }

    public RelateForumViewPager(Context context) {
        super(context);
        this.azW = false;
    }

    public RelateForumViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azW = false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        this.azW = z;
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (i(motionEvent)) {
            return true;
        }
        if (motionEvent.getPointerCount() > 1 && this.azW) {
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
        if (i(motionEvent)) {
            return true;
        }
        be(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
            case 2:
            case 5:
            case 6:
                be(true);
                break;
            case 1:
            case 3:
                be(false);
                break;
        }
        if (i(motionEvent)) {
            return true;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    private boolean i(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        return motionEvent.getPointerId(action) == -1 || action == -1 || action >= motionEvent.getPointerCount();
    }

    private void be(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
