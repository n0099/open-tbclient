package com.baidu.tieba.homepage.framework.indicator;

import android.support.v4.view.ViewPager;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ScrollFragmentTabHost cAs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cAs = scrollFragmentTabHost;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        a aVar;
        aVar = this.cAs.cAm;
        aVar.onPageScrolled(i, f, i2);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        ScrollFragmentTabHost.a aVar;
        ScrollFragmentTabHost.a aVar2;
        aVar = this.cAs.cAo;
        if (aVar != null) {
            aVar2 = this.cAs.cAo;
            aVar2.kk(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
