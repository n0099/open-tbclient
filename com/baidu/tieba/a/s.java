package com.baidu.tieba.a;

import android.support.v4.view.ViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements ViewPager.OnPageChangeListener {
    final /* synthetic */ r aMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.aMC = rVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aMC.aMB = i;
        this.aMC.setCurrentItem(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
