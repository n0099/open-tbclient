package com.baidu.tieba.frs;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
class bb implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ba aNf;
    private final /* synthetic */ bd aNg;
    private final /* synthetic */ IndicatorView aNh;
    private final /* synthetic */ ch aNi;
    private final /* synthetic */ ViewPager aNj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar, bd bdVar, IndicatorView indicatorView, ch chVar, ViewPager viewPager) {
        this.aNf = baVar;
        this.aNg = bdVar;
        this.aNh = indicatorView;
        this.aNi = chVar;
        this.aNj = viewPager;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int eY;
        int eZ;
        eY = this.aNg.eY(i);
        if (eY == i && this.aNh != null) {
            IndicatorView indicatorView = this.aNh;
            eZ = this.aNg.eZ(i);
            indicatorView.setPosition(eZ);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        int count;
        if (i == 0 && (count = this.aNi.getCount()) > 1) {
            int currentItem = this.aNj.getCurrentItem();
            int i2 = count - 2;
            if (currentItem < 1) {
                this.aNj.setCurrentItem(i2, false);
                this.aNj.invalidate();
            } else if (currentItem > i2) {
                this.aNj.setCurrentItem(1, false);
                this.aNj.invalidate();
            }
        }
    }
}
