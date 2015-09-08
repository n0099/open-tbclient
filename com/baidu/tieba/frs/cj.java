package com.baidu.tieba.frs;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.frs.ch;
import com.baidu.tieba.tbadkCore.ChildViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ch aYg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(ch chVar) {
        this.aYg = chVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        ch.a aVar;
        int fy;
        IndicatorView indicatorView;
        IndicatorView indicatorView2;
        ch.a aVar2;
        aVar = this.aYg.aYd;
        fy = aVar.fy(i);
        if (fy == i) {
            indicatorView = this.aYg.aqZ;
            if (indicatorView != null) {
                indicatorView2 = this.aYg.aqZ;
                aVar2 = this.aYg.aYd;
                indicatorView2.setPosition(aVar2.fz(i));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        dk dkVar;
        ChildViewPager childViewPager;
        ChildViewPager childViewPager2;
        ChildViewPager childViewPager3;
        if (i != 1) {
            if (i == 0) {
                dkVar = this.aYg.aYc;
                int count = dkVar.getCount();
                if (count >= 2) {
                    childViewPager = this.aYg.aYb;
                    int currentItem = childViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        childViewPager3 = this.aYg.aYb;
                        childViewPager3.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        childViewPager2 = this.aYg.aYb;
                        childViewPager2.setCurrentItem(1, false);
                    }
                    this.aYg.Mp();
                    return;
                }
                return;
            }
            return;
        }
        this.aYg.Mq();
    }
}
