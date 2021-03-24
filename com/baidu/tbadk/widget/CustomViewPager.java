package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes3.dex */
public class CustomViewPager extends TbViewPager {
    public boolean i;
    public int j;
    public boolean k;
    public int l;
    public ViewPager.OnPageChangeListener m;

    /* loaded from: classes3.dex */
    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            CustomViewPager.this.k = i == 1;
            if (i == 2) {
                CustomViewPager.this.j = 0;
            }
            if (CustomViewPager.this.m != null) {
                CustomViewPager.this.m.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            if (CustomViewPager.this.k) {
                if (CustomViewPager.this.l > i2) {
                    CustomViewPager.this.j = -1;
                } else if (CustomViewPager.this.l < i2) {
                    CustomViewPager.this.j = 1;
                } else if (CustomViewPager.this.l == i2) {
                    CustomViewPager.this.j = 0;
                }
            }
            CustomViewPager.this.l = i2;
            if (CustomViewPager.this.m != null) {
                CustomViewPager.this.m.onPageScrolled(i, f2, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (CustomViewPager.this.m != null) {
                CustomViewPager.this.m.onPageSelected(i);
            }
        }
    }

    public CustomViewPager(Context context) {
        super(context);
        this.i = true;
        this.j = 0;
        this.k = false;
        this.l = -1;
        c();
    }

    private void c() {
        super.setOnPageChangeListener(new a());
    }

    @Override // androidx.viewpager.widget.ViewPager
    public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof NestedNoScrollViewPager) {
            return false;
        }
        return super.canScroll(view, z, i, i2, i3);
    }

    public int getDirection() {
        return this.j;
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.i) {
            if (getCurrentItem() != 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.i) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.m = onPageChangeListener;
    }

    public void setScrollable(boolean z) {
        this.i = z;
    }

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = true;
        this.j = 0;
        this.k = false;
        this.l = -1;
        c();
    }
}
