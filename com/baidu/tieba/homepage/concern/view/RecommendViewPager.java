package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes2.dex */
public class RecommendViewPager extends ViewPager {
    private float jZD;
    private float jZE;

    public RecommendViewPager(@NonNull Context context) {
        super(context);
        this.jZD = 0.0f;
        this.jZE = 0.0f;
    }

    public RecommendViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jZD = 0.0f;
        this.jZE = 0.0f;
    }

    public void requestParentInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int currentItem = getCurrentItem();
        boolean z = (currentItem == 0 || currentItem == (getAdapter() == null ? 0 : getAdapter().getCount()) + (-1)) ? false : true;
        switch (motionEvent.getAction()) {
            case 0:
                this.jZD = motionEvent.getX();
                this.jZE = motionEvent.getY();
                break;
            case 1:
            case 3:
                requestParentInterceptTouchEvent(false);
                break;
            case 2:
                float abs = Math.abs(motionEvent.getX() - this.jZD);
                float abs2 = Math.abs(motionEvent.getY() - this.jZE);
                this.jZD = motionEvent.getX();
                this.jZE = motionEvent.getY();
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
