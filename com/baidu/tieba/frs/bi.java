package com.baidu.tieba.frs;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.frs.bh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements ViewPager.OnPageChangeListener {
    final /* synthetic */ bh aWA;
    private final /* synthetic */ bh.a aWB;
    private final /* synthetic */ IndicatorView aWC;
    private final /* synthetic */ dd aWD;
    private final /* synthetic */ ViewPager aWE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bh bhVar, bh.a aVar, IndicatorView indicatorView, dd ddVar, ViewPager viewPager) {
        this.aWA = bhVar;
        this.aWB = aVar;
        this.aWC = indicatorView;
        this.aWD = ddVar;
        this.aWE = viewPager;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int fl;
        int fm;
        fl = this.aWB.fl(i);
        if (fl == i && this.aWC != null) {
            IndicatorView indicatorView = this.aWC;
            fm = this.aWB.fm(i);
            indicatorView.setPosition(fm);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        int count;
        if (i == 0 && (count = this.aWD.getCount()) > 1) {
            int currentItem = this.aWE.getCurrentItem();
            int i2 = count - 2;
            if (currentItem < 1) {
                this.aWE.setCurrentItem(i2, false);
                this.aWE.invalidate();
            } else if (currentItem > i2) {
                this.aWE.setCurrentItem(1, false);
                this.aWE.invalidate();
            }
        }
    }
}
