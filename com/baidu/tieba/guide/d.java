package com.baidu.tieba.guide;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import com.baidu.tieba.view.RightSlideViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements ViewPager.OnPageChangeListener {
    final /* synthetic */ NewUserGuideActivity aMZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NewUserGuideActivity newUserGuideActivity) {
        this.aMZ = newUserGuideActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        RightSlideViewPager rightSlideViewPager;
        if (i == 1) {
            rightSlideViewPager = this.aMZ.aMX;
            rightSlideViewPager.setTag(null);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        com.baidu.tieba.model.o oVar;
        oVar = this.aMZ.aMT;
        if (oVar.Uo() && i == 0 && f > 0.0f) {
            this.aMZ.IS();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        RightSlideViewPager rightSlideViewPager;
        rightSlideViewPager = this.aMZ.aMX;
        j jVar = (j) ((FragmentPagerAdapter) rightSlideViewPager.getAdapter()).getItem(0);
        if (i == 0) {
            jVar.IU();
        } else {
            jVar.IV();
        }
    }
}
