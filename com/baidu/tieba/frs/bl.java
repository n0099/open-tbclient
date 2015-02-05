package com.baidu.tieba.frs;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
class bl implements ViewPager.OnPageChangeListener {
    final /* synthetic */ bk aEO;
    private final /* synthetic */ bn aEP;
    private final /* synthetic */ ViewPager aEQ;
    private final /* synthetic */ IndicatorView aER;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bk bkVar, bn bnVar, ViewPager viewPager, IndicatorView indicatorView) {
        this.aEO = bkVar;
        this.aEP = bnVar;
        this.aEQ = viewPager;
        this.aER = indicatorView;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int eP;
        int eQ;
        eP = this.aEP.eP(i);
        if (eP != i) {
            this.aEQ.setCurrentItem(eP, false);
        } else if (this.aER != null) {
            IndicatorView indicatorView = this.aER;
            eQ = this.aEP.eQ(i);
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
