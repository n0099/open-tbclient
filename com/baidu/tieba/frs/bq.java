package com.baidu.tieba.frs;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
class bq implements ViewPager.OnPageChangeListener {
    final /* synthetic */ bp aCe;
    private final /* synthetic */ bs aCf;
    private final /* synthetic */ ViewPager aCg;
    private final /* synthetic */ IndicatorView aCh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar, bs bsVar, ViewPager viewPager, IndicatorView indicatorView) {
        this.aCe = bpVar;
        this.aCf = bsVar;
        this.aCg = viewPager;
        this.aCh = indicatorView;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int eL;
        int eM;
        eL = this.aCf.eL(i);
        if (eL != i) {
            this.aCg.setCurrentItem(eL, false);
        } else if (this.aCh != null) {
            IndicatorView indicatorView = this.aCh;
            eM = this.aCf.eM(i);
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
