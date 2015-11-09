package com.baidu.tieba.hottopic.b;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.hottopic.a.m;
import com.baidu.tieba.hottopic.b.e;
import com.baidu.tieba.hottopic.view.RelateForumViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements ViewPager.OnPageChangeListener {
    final /* synthetic */ e bqF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.bqF = eVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        m mVar;
        RelateForumViewPager relateForumViewPager;
        RelateForumViewPager relateForumViewPager2;
        RelateForumViewPager relateForumViewPager3;
        if (i != 1) {
            if (i == 0) {
                mVar = this.bqF.bqA;
                int count = mVar.getCount();
                if (count >= 2) {
                    relateForumViewPager = this.bqF.bqx;
                    int currentItem = relateForumViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        relateForumViewPager3 = this.bqF.bqx;
                        relateForumViewPager3.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        relateForumViewPager2 = this.bqF.bqx;
                        relateForumViewPager2.setCurrentItem(1, false);
                    }
                    this.bqF.MA();
                    return;
                }
                return;
            }
            return;
        }
        this.bqF.MB();
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        e.a aVar;
        e.a aVar2;
        int gR;
        IndicatorView indicatorView;
        IndicatorView indicatorView2;
        e.a aVar3;
        int fM;
        aVar = this.bqF.bqB;
        if (aVar != null) {
            aVar2 = this.bqF.bqB;
            gR = aVar2.gR(i);
            if (gR == i) {
                indicatorView = this.bqF.ari;
                if (indicatorView != null) {
                    indicatorView2 = this.bqF.ari;
                    aVar3 = this.bqF.bqB;
                    fM = aVar3.fM(i);
                    indicatorView2.setPosition(fM);
                }
            }
        }
    }
}
