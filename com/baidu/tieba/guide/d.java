package com.baidu.tieba.guide;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import com.baidu.tieba.model.ao;
import com.baidu.tieba.view.RightSlideViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements ViewPager.OnPageChangeListener {
    final /* synthetic */ NewUserGuideActivity aKR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NewUserGuideActivity newUserGuideActivity) {
        this.aKR = newUserGuideActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        RightSlideViewPager rightSlideViewPager;
        if (i == 1) {
            rightSlideViewPager = this.aKR.aKP;
            rightSlideViewPager.setTag(null);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ao aoVar;
        aoVar = this.aKR.aKL;
        if (aoVar.TO() && i == 0 && f > 0.0f) {
            this.aKR.Ix();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        RightSlideViewPager rightSlideViewPager;
        rightSlideViewPager = this.aKR.aKP;
        j jVar = (j) ((FragmentPagerAdapter) rightSlideViewPager.getAdapter()).getItem(0);
        if (i == 0) {
            jVar.Iz();
        } else {
            jVar.IA();
        }
    }
}
