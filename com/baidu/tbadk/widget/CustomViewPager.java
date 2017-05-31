package com.baidu.tbadk.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class CustomViewPager extends TbViewPager {
    private boolean aJo;
    private int aJp;
    private boolean isScrolling;
    private int mDirection;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    public CustomViewPager(Context context) {
        super(context);
        this.aJo = true;
        this.mDirection = 0;
        this.isScrolling = false;
        this.aJp = -1;
        init();
    }

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aJo = true;
        this.mDirection = 0;
        this.isScrolling = false;
        this.aJp = -1;
        init();
    }

    private void init() {
        super.setOnPageChangeListener(new a(this));
    }

    public void setScrollable(boolean z) {
        this.aJo = z;
    }

    @Override // android.support.v4.view.ViewPager
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public int getDirection() {
        return this.mDirection;
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.aJo) {
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
