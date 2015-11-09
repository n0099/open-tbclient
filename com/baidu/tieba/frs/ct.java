package com.baidu.tieba.frs;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.frs.cr;
import com.baidu.tieba.tbadkCore.ChildViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct implements ViewPager.OnPageChangeListener {
    final /* synthetic */ cr aXU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cr crVar) {
        this.aXU = crVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        cr.a aVar;
        int fL;
        IndicatorView indicatorView;
        IndicatorView indicatorView2;
        cr.a aVar2;
        aVar = this.aXU.aXR;
        fL = aVar.fL(i);
        if (fL == i) {
            indicatorView = this.aXU.ari;
            if (indicatorView != null) {
                indicatorView2 = this.aXU.ari;
                aVar2 = this.aXU.aXR;
                indicatorView2.setPosition(aVar2.fM(i));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ef efVar;
        ChildViewPager childViewPager;
        ChildViewPager childViewPager2;
        ChildViewPager childViewPager3;
        if (i != 1) {
            if (i == 0) {
                efVar = this.aXU.aXQ;
                int count = efVar.getCount();
                if (count >= 2) {
                    childViewPager = this.aXU.aXP;
                    int currentItem = childViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        childViewPager3 = this.aXU.aXP;
                        childViewPager3.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        childViewPager2 = this.aXU.aXP;
                        childViewPager2.setCurrentItem(1, false);
                    }
                    this.aXU.MA();
                    return;
                }
                return;
            }
            return;
        }
        this.aXU.MB();
    }
}
