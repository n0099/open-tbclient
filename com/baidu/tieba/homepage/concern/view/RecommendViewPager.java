package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes22.dex */
public class RecommendViewPager extends ViewPager {
    private float jrX;
    private float jrY;

    public RecommendViewPager(@NonNull Context context) {
        super(context);
        this.jrX = 0.0f;
        this.jrY = 0.0f;
    }

    public RecommendViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jrX = 0.0f;
        this.jrY = 0.0f;
    }

    public void requestParentInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int currentItem = getCurrentItem();
        boolean z = (currentItem == 0 || currentItem == (getAdapter() == null ? 0 : getAdapter().getCount()) + (-1)) ? false : true;
        switch (motionEvent.getAction()) {
            case 0:
                this.jrX = motionEvent.getX();
                this.jrY = motionEvent.getY();
                break;
            case 1:
            case 3:
                requestParentInterceptTouchEvent(false);
                break;
            case 2:
                float abs = Math.abs(motionEvent.getX() - this.jrX);
                float abs2 = Math.abs(motionEvent.getY() - this.jrY);
                this.jrX = motionEvent.getX();
                this.jrY = motionEvent.getY();
                if (abs2 / abs < 1.0f && z) {
                    requestParentInterceptTouchEvent(true);
                    break;
                } else {
                    requestParentInterceptTouchEvent(false);
                    break;
                }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
