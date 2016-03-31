package com.baidu.tieba.enterForum.home;

import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements ViewPager.OnPageChangeListener {
    final /* synthetic */ e baY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.baY = eVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        FragmentTabWidget fragmentTabWidget;
        fragmentTabWidget = this.baY.baV;
        fragmentTabWidget.d(i, true);
        this.baY.gg(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
