package com.baidu.tieba.card;

import android.support.v4.view.ViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements ViewPager.OnPageChangeListener {
    final /* synthetic */ an aPB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar) {
        this.aPB = anVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aPB.aPA = i;
        this.aPB.setCurrentItem(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
