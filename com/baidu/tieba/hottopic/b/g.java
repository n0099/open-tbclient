package com.baidu.tieba.hottopic.b;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.hottopic.a.m;
import com.baidu.tieba.hottopic.b.e;
import com.baidu.tieba.hottopic.view.RelateForumViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements ViewPager.OnPageChangeListener {
    final /* synthetic */ e bpQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.bpQ = eVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        m mVar;
        RelateForumViewPager relateForumViewPager;
        RelateForumViewPager relateForumViewPager2;
        RelateForumViewPager relateForumViewPager3;
        if (i != 1) {
            if (i == 0) {
                mVar = this.bpQ.bpL;
                int count = mVar.getCount();
                if (count >= 2) {
                    relateForumViewPager = this.bpQ.bpI;
                    int currentItem = relateForumViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        relateForumViewPager3 = this.bpQ.bpI;
                        relateForumViewPager3.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        relateForumViewPager2 = this.bpQ.bpI;
                        relateForumViewPager2.setCurrentItem(1, false);
                    }
                    this.bpQ.Mo();
                    return;
                }
                return;
            }
            return;
        }
        this.bpQ.Mp();
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
        aVar = this.bpQ.bpM;
        if (aVar != null) {
            aVar2 = this.bpQ.bpM;
            gE = aVar2.gE(i);
            if (gE == i) {
                indicatorView = this.bpQ.apz;
                if (indicatorView != null) {
                    indicatorView2 = this.bpQ.apz;
                    aVar3 = this.bpQ.bpM;
                    fE = aVar3.fE(i);
                    indicatorView2.setPosition(fE);
                }
            }
        }
    }
}
