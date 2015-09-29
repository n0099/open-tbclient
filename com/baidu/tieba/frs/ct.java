package com.baidu.tieba.frs;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.frs.cr;
import com.baidu.tieba.tbadkCore.ChildViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct implements ViewPager.OnPageChangeListener {
    final /* synthetic */ cr aXA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cr crVar) {
        this.aXA = crVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        cr.a aVar;
        int fD;
        IndicatorView indicatorView;
        IndicatorView indicatorView2;
        cr.a aVar2;
        aVar = this.aXA.aXx;
        fD = aVar.fD(i);
        if (fD == i) {
            indicatorView = this.aXA.apz;
            if (indicatorView != null) {
                indicatorView2 = this.aXA.apz;
                aVar2 = this.aXA.aXx;
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
                edVar = this.aXA.aXw;
                int count = edVar.getCount();
                if (count >= 2) {
                    childViewPager = this.aXA.aXv;
                    int currentItem = childViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        childViewPager3 = this.aXA.aXv;
                        childViewPager3.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        childViewPager2 = this.aXA.aXv;
                        childViewPager2.setCurrentItem(1, false);
                    }
                    this.aXA.Mo();
                    return;
                }
                return;
            }
            return;
        }
        this.aXA.Mp();
    }
}
