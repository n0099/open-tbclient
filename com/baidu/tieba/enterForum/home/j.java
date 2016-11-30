package com.baidu.tieba.enterForum.home;

import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements ViewPager.OnPageChangeListener {
    final /* synthetic */ f bJJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(f fVar) {
        this.bJJ = fVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        FragmentTabWidget fragmentTabWidget;
        fragmentTabWidget = this.bJJ.bJG;
        fragmentTabWidget.g(i, true);
        this.bJJ.ht(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
