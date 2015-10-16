package com.baidu.tieba.hottopic.b;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.hottopic.a.m;
import com.baidu.tieba.hottopic.b.e;
import com.baidu.tieba.hottopic.view.RelateForumViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements ViewPager.OnPageChangeListener {
    final /* synthetic */ e bqb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.bqb = eVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        m mVar;
        RelateForumViewPager relateForumViewPager;
        RelateForumViewPager relateForumViewPager2;
        RelateForumViewPager relateForumViewPager3;
        if (i != 1) {
            if (i == 0) {
                mVar = this.bqb.bpW;
                int count = mVar.getCount();
                if (count >= 2) {
                    relateForumViewPager = this.bqb.bpT;
                    int currentItem = relateForumViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        relateForumViewPager3 = this.bqb.bpT;
                        relateForumViewPager3.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        relateForumViewPager2 = this.bqb.bpT;
                        relateForumViewPager2.setCurrentItem(1, false);
                    }
                    this.bqb.Mo();
                    return;
                }
                return;
            }
            return;
        }
        this.bqb.Mp();
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        e.a aVar;
        e.a aVar2;
        int gE;
        IndicatorView indicatorView;
        IndicatorView indicatorView2;
        e.a aVar3;
        int fE;
        aVar = this.bqb.bpX;
        if (aVar != null) {
            aVar2 = this.bqb.bpX;
            gE = aVar2.gE(i);
            if (gE == i) {
                indicatorView = this.bqb.apA;
                if (indicatorView != null) {
                    indicatorView2 = this.bqb.apA;
                    aVar3 = this.bqb.bpX;
                    fE = aVar3.fE(i);
                    indicatorView2.setPosition(fE);
                }
            }
        }
    }
}
