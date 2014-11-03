package com.baidu.tieba.frs;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
class bq implements ViewPager.OnPageChangeListener {
    final /* synthetic */ bp aCo;
    private final /* synthetic */ bs aCp;
    private final /* synthetic */ ViewPager aCq;
    private final /* synthetic */ IndicatorView aCr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar, bs bsVar, ViewPager viewPager, IndicatorView indicatorView) {
        this.aCo = bpVar;
        this.aCp = bsVar;
        this.aCq = viewPager;
        this.aCr = indicatorView;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int eL;
        int eM;
        eL = this.aCp.eL(i);
        if (eL != i) {
            this.aCq.setCurrentItem(eL, false);
        } else if (this.aCr != null) {
            IndicatorView indicatorView = this.aCr;
            eM = this.aCp.eM(i);
            indicatorView.setPosition(eM);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
