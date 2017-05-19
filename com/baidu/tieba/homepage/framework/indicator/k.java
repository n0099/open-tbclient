package com.baidu.tieba.homepage.framework.indicator;

import android.support.v4.view.ViewPager;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ScrollFragmentTabHost cua;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cua = scrollFragmentTabHost;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        a aVar;
        aVar = this.cua.ctU;
        aVar.onPageScrolled(i, f, i2);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        ScrollFragmentTabHost.a aVar;
        ScrollFragmentTabHost.a aVar2;
        aVar = this.cua.ctW;
        if (aVar != null) {
            aVar2 = this.cua.ctW;
            aVar2.jL(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
