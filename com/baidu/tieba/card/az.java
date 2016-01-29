package com.baidu.tieba.card;

import android.support.v4.view.ViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ay aRz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ay ayVar) {
        this.aRz = ayVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.aRz.aRy = i;
        this.aRz.setCurrentItem(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
