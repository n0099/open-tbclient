package com.baidu.tbadk.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class CustomViewPager extends TbViewPager {
    private boolean isScrolling;
    private int lastValue;
    private int mDirection;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private boolean scrollable;

    public CustomViewPager(Context context) {
        super(context);
        this.scrollable = true;
        this.mDirection = 0;
        this.isScrolling = false;
        this.lastValue = -1;
        init();
    }

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.scrollable = true;
        this.mDirection = 0;
        this.isScrolling = false;
        this.lastValue = -1;
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
                    if (CustomViewPager.this.lastValue > i2) {
                        CustomViewPager.this.mDirection = -1;
                    } else if (CustomViewPager.this.lastValue < i2) {
                        CustomViewPager.this.mDirection = 1;
                    } else if (CustomViewPager.this.lastValue == i2) {
                        CustomViewPager.this.mDirection = 0;
                    }
                }
                CustomViewPager.this.lastValue = i2;
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
        this.scrollable = z;
    }

    @Override // android.support.v4.view.ViewPager
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public int getDirection() {
        return this.mDirection;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.view.ViewPager
    public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof NestedNoScrollViewPager) {
            return false;
        }
        return super.canScroll(view, z, i, i2, i3);
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.scrollable) {
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
        if (this.scrollable) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }
}
