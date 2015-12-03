package com.baidu.tieba.frs;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.frs.dh;
import com.baidu.tieba.tbadkCore.NewChildViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dj implements ViewPager.OnPageChangeListener {
    final /* synthetic */ dh bdU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dj(dh dhVar) {
        this.bdU = dhVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        dh.a aVar;
        int gi;
        IndicatorView indicatorView;
        IndicatorView indicatorView2;
        dh.a aVar2;
        aVar = this.bdU.bdR;
        gi = aVar.gi(i);
        if (gi == i) {
            indicatorView = this.bdU.agf;
            if (indicatorView != null) {
                indicatorView2 = this.bdU.agf;
                aVar2 = this.bdU.bdR;
                indicatorView2.setPosition(aVar2.db(i));
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ex exVar;
        NewChildViewPager newChildViewPager;
        NewChildViewPager newChildViewPager2;
        NewChildViewPager newChildViewPager3;
        if (i != 1) {
            if (i == 0) {
                exVar = this.bdU.bdQ;
                int count = exVar.getCount();
                if (count >= 2) {
                    newChildViewPager = this.bdU.bdP;
                    int currentItem = newChildViewPager.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        newChildViewPager3 = this.bdU.bdP;
                        newChildViewPager3.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        newChildViewPager2 = this.bdU.bdP;
                        newChildViewPager2.setCurrentItem(1, false);
                    }
                    this.bdU.wp();
                    return;
                }
                return;
            }
            return;
        }
        this.bdU.wq();
    }
}
