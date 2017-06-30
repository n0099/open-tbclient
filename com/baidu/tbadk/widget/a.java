package com.baidu.tbadk.widget;

import android.support.v4.view.ViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements ViewPager.OnPageChangeListener {
    final /* synthetic */ CustomViewPager aKF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CustomViewPager customViewPager) {
        this.aKF = customViewPager;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        this.aKF.isScrolling = i == 1;
        if (i == 2) {
            this.aKF.mDirection = 0;
        }
        onPageChangeListener = this.aKF.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.aKF.mOnPageChangeListener;
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
        z = this.aKF.isScrolling;
        if (z) {
            i3 = this.aKF.aKE;
            if (i3 > i2) {
                this.aKF.mDirection = -1;
            } else {
                i4 = this.aKF.aKE;
                if (i4 < i2) {
                    this.aKF.mDirection = 1;
                } else {
                    i5 = this.aKF.aKE;
                    if (i5 == i2) {
                        this.aKF.mDirection = 0;
                    }
                }
            }
        }
        this.aKF.aKE = i2;
        onPageChangeListener = this.aKF.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.aKF.mOnPageChangeListener;
            onPageChangeListener2.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.aKF.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.aKF.mOnPageChangeListener;
            onPageChangeListener2.onPageSelected(i);
        }
    }
}
