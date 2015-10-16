package com.baidu.tieba.frs;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.frs.cr;
import com.baidu.tieba.tbadkCore.ChildViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct implements ViewPager.OnPageChangeListener {
    final /* synthetic */ cr aXL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cr crVar) {
        this.aXL = crVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        cr.a aVar;
        int fD;
        IndicatorView indicatorView;
        IndicatorView indicatorView2;
        cr.a aVar2;
        aVar = this.aXL.aXI;
        fD = aVar.fD(i);
        if (fD == i) {
            indicatorView = this.aXL.apA;
            if (indicatorView != null) {
                indicatorView2 = this.aXL.apA;
                aVar2 = this.aXL.aXI;
                indicatorView2.setPosition(aVar2.fE(i));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ed edVar;
        ChildViewPager childViewPager;
        ChildViewPager childViewPager2;
        ChildViewPager childViewPager3;
        if (i != 1) {
            if (i == 0) {
                edVar = this.aXL.aXH;
                int count = edVar.getCount();
                if (count >= 2) {
                    childViewPager = this.aXL.aXG;
                    int currentItem = childViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        childViewPager3 = this.aXL.aXG;
                        childViewPager3.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        childViewPager2 = this.aXL.aXG;
                        childViewPager2.setCurrentItem(1, false);
                    }
                    this.aXL.Mo();
                    return;
                }
                return;
            }
            return;
        }
        this.aXL.Mp();
    }
}
