package com.baidu.tieba.frs;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
class bm implements ViewPager.OnPageChangeListener {
    final /* synthetic */ bl aDP;
    private final /* synthetic */ bo aDQ;
    private final /* synthetic */ ViewPager aDR;
    private final /* synthetic */ IndicatorView aDS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bl blVar, bo boVar, ViewPager viewPager, IndicatorView indicatorView) {
        this.aDP = blVar;
        this.aDQ = boVar;
        this.aDR = viewPager;
        this.aDS = indicatorView;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int eJ;
        int eK;
        eJ = this.aDQ.eJ(i);
        if (eJ != i) {
            this.aDR.setCurrentItem(eJ, false);
        } else if (this.aDS != null) {
            IndicatorView indicatorView = this.aDS;
            eK = this.aDQ.eK(i);
            indicatorView.setPosition(eK);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
