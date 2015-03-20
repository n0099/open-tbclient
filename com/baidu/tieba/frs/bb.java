package com.baidu.tieba.frs;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
class bb implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ba aKO;
    private final /* synthetic */ bd aKP;
    private final /* synthetic */ ViewPager aKQ;
    private final /* synthetic */ IndicatorView aKR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar, bd bdVar, ViewPager viewPager, IndicatorView indicatorView) {
        this.aKO = baVar;
        this.aKP = bdVar;
        this.aKQ = viewPager;
        this.aKR = indicatorView;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int eK;
        int eL;
        eK = this.aKP.eK(i);
        if (eK != i) {
            this.aKQ.setCurrentItem(eK, false);
        } else if (this.aKR != null) {
            IndicatorView indicatorView = this.aKR;
            eL = this.aKP.eL(i);
            indicatorView.setPosition(eL);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
