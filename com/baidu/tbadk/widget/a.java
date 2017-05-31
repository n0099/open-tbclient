package com.baidu.tbadk.widget;

import android.support.v4.view.ViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements ViewPager.OnPageChangeListener {
    final /* synthetic */ CustomViewPager aJq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CustomViewPager customViewPager) {
        this.aJq = customViewPager;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        this.aJq.isScrolling = i == 1;
        if (i == 2) {
            this.aJq.mDirection = 0;
        }
        onPageChangeListener = this.aJq.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.aJq.mOnPageChangeListener;
            onPageChangeListener2.onPageScrollStateChanged(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        boolean z;
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        int i3;
        int i4;
        int i5;
        z = this.aJq.isScrolling;
        if (z) {
            i3 = this.aJq.aJp;
            if (i3 > i2) {
                this.aJq.mDirection = -1;
            } else {
                i4 = this.aJq.aJp;
                if (i4 < i2) {
                    this.aJq.mDirection = 1;
                } else {
                    i5 = this.aJq.aJp;
                    if (i5 == i2) {
                        this.aJq.mDirection = 0;
                    }
                }
            }
        }
        this.aJq.aJp = i2;
        onPageChangeListener = this.aJq.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.aJq.mOnPageChangeListener;
            onPageChangeListener2.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.aJq.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.aJq.mOnPageChangeListener;
            onPageChangeListener2.onPageSelected(i);
        }
    }
}
