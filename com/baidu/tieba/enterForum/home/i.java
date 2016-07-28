package com.baidu.tieba.enterForum.home;

import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements ViewPager.OnPageChangeListener {
    final /* synthetic */ e bvs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.bvs = eVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        FragmentTabWidget fragmentTabWidget;
        fragmentTabWidget = this.bvs.bvo;
        fragmentTabWidget.g(i, true);
        this.bvs.gM(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
