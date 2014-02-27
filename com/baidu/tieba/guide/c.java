package com.baidu.tieba.guide;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import com.baidu.tieba.model.bh;
import com.baidu.tieba.view.RightSlideViewPager;
/* loaded from: classes.dex */
final class c implements ViewPager.OnPageChangeListener {
    final /* synthetic */ NewUserGuideActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewUserGuideActivity newUserGuideActivity) {
        this.a = newUserGuideActivity;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageSelected(int i) {
        RightSlideViewPager rightSlideViewPager;
        if (i == 1) {
            rightSlideViewPager = this.a.i;
            rightSlideViewPager.setTag(null);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int i, float f, int i2) {
        bh bhVar;
        bhVar = this.a.d;
        if (bhVar.a() && i == 0 && f > 0.0f) {
            this.a.i();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int i) {
        RightSlideViewPager rightSlideViewPager;
        rightSlideViewPager = this.a.i;
        l lVar = (l) ((FragmentPagerAdapter) rightSlideViewPager.getAdapter()).getItem(0);
        if (i == 0) {
            lVar.a();
        } else {
            lVar.b();
        }
    }
}
