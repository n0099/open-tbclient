package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes22.dex */
public class RecommendViewPager extends ViewPager {
    private float jMn;
    private float jMo;

    public RecommendViewPager(@NonNull Context context) {
        super(context);
        this.jMn = 0.0f;
        this.jMo = 0.0f;
    }

    public RecommendViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jMn = 0.0f;
        this.jMo = 0.0f;
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
                this.jMn = motionEvent.getX();
                this.jMo = motionEvent.getY();
                break;
            case 1:
            case 3:
                requestParentInterceptTouchEvent(false);
                break;
            case 2:
                float abs = Math.abs(motionEvent.getX() - this.jMn);
                float abs2 = Math.abs(motionEvent.getY() - this.jMo);
                this.jMn = motionEvent.getX();
                this.jMo = motionEvent.getY();
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
