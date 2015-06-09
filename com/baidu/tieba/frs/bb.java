package com.baidu.tieba.frs;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
class bb implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ba aNg;
    private final /* synthetic */ bd aNh;
    private final /* synthetic */ IndicatorView aNi;
    private final /* synthetic */ ch aNj;
    private final /* synthetic */ ViewPager aNk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar, bd bdVar, IndicatorView indicatorView, ch chVar, ViewPager viewPager) {
        this.aNg = baVar;
        this.aNh = bdVar;
        this.aNi = indicatorView;
        this.aNj = chVar;
        this.aNk = viewPager;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int eY;
        int eZ;
        eY = this.aNh.eY(i);
        if (eY == i && this.aNi != null) {
            IndicatorView indicatorView = this.aNi;
            eZ = this.aNh.eZ(i);
            indicatorView.setPosition(eZ);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        int count;
        if (i == 0 && (count = this.aNj.getCount()) > 1) {
            int currentItem = this.aNk.getCurrentItem();
            int i2 = count - 2;
            if (currentItem < 1) {
                this.aNk.setCurrentItem(i2, false);
                this.aNk.invalidate();
            } else if (currentItem > i2) {
                this.aNk.setCurrentItem(1, false);
                this.aNk.invalidate();
            }
        }
    }
}
