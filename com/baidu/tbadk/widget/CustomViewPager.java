package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class CustomViewPager extends TbViewPager {
    private boolean aAK;

    public CustomViewPager(Context context) {
        super(context);
        this.aAK = true;
    }

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aAK = true;
    }

    public void setScrollable(boolean z) {
        this.aAK = z;
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.aAK) {
            if (getCurrentItem() != 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}
