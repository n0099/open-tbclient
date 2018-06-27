package com.baidu.tbadk.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class CustomViewPager extends TbViewPager {
    private boolean aWM;
    private int aWN;
    private boolean isScrolling;
    private int mDirection;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    public CustomViewPager(Context context) {
        super(context);
        this.aWM = true;
        this.mDirection = 0;
        this.isScrolling = false;
        this.aWN = -1;
        init();
    }

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aWM = true;
        this.mDirection = 0;
        this.isScrolling = false;
        this.aWN = -1;
        init();
    }

    private void init() {
        super.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tbadk.widget.CustomViewPager.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                CustomViewPager.this.isScrolling = i == 1;
                if (i == 2) {
                    CustomViewPager.this.mDirection = 0;
                }
                if (CustomViewPager.this.mOnPageChangeListener != null) {
                    CustomViewPager.this.mOnPageChangeListener.onPageScrollStateChanged(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (CustomViewPager.this.isScrolling) {
                    if (CustomViewPager.this.aWN > i2) {
                        CustomViewPager.this.mDirection = -1;
                    } else if (CustomViewPager.this.aWN < i2) {
                        CustomViewPager.this.mDirection = 1;
                    } else if (CustomViewPager.this.aWN == i2) {
                        CustomViewPager.this.mDirection = 0;
                    }
                }
                CustomViewPager.this.aWN = i2;
                if (CustomViewPager.this.mOnPageChangeListener != null) {
                    CustomViewPager.this.mOnPageChangeListener.onPageScrolled(i, f, i2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (CustomViewPager.this.mOnPageChangeListener != null) {
                    CustomViewPager.this.mOnPageChangeListener.onPageSelected(i);
                }
            }
        });
    }

    public void setScrollable(boolean z) {
        this.aWM = z;
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
        if (this.aWM) {
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

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aWM) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }
}
