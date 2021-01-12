package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes2.dex */
public class RecommendViewPager extends ViewPager {
    private float jUY;
    private float jUZ;

    public RecommendViewPager(@NonNull Context context) {
        super(context);
        this.jUY = 0.0f;
        this.jUZ = 0.0f;
    }

    public RecommendViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jUY = 0.0f;
        this.jUZ = 0.0f;
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
                this.jUY = motionEvent.getX();
                this.jUZ = motionEvent.getY();
                break;
            case 1:
            case 3:
                requestParentInterceptTouchEvent(false);
                break;
            case 2:
                float abs = Math.abs(motionEvent.getX() - this.jUY);
                float abs2 = Math.abs(motionEvent.getY() - this.jUZ);
                this.jUY = motionEvent.getX();
                this.jUZ = motionEvent.getY();
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
