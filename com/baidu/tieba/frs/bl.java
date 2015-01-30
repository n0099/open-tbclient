package com.baidu.tieba.frs;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
class bl implements ViewPager.OnPageChangeListener {
    final /* synthetic */ bk aER;
    private final /* synthetic */ bn aES;
    private final /* synthetic */ ViewPager aET;
    private final /* synthetic */ IndicatorView aEU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bk bkVar, bn bnVar, ViewPager viewPager, IndicatorView indicatorView) {
        this.aER = bkVar;
        this.aES = bnVar;
        this.aET = viewPager;
        this.aEU = indicatorView;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int eP;
        int eQ;
        eP = this.aES.eP(i);
        if (eP != i) {
            this.aET.setCurrentItem(eP, false);
        } else if (this.aEU != null) {
            IndicatorView indicatorView = this.aEU;
            eQ = this.aES.eQ(i);
            indicatorView.setPosition(eQ);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
