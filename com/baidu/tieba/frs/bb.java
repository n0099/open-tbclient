package com.baidu.tieba.frs;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
class bb implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ba aKY;
    private final /* synthetic */ bd aKZ;
    private final /* synthetic */ ViewPager aLa;
    private final /* synthetic */ IndicatorView aLb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar, bd bdVar, ViewPager viewPager, IndicatorView indicatorView) {
        this.aKY = baVar;
        this.aKZ = bdVar;
        this.aLa = viewPager;
        this.aLb = indicatorView;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int eK;
        int eL;
        eK = this.aKZ.eK(i);
        if (eK != i) {
            this.aLa.setCurrentItem(eK, false);
        } else if (this.aLb != null) {
            IndicatorView indicatorView = this.aLb;
            eL = this.aKZ.eL(i);
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
