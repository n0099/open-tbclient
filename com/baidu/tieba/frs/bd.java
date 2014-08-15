package com.baidu.tieba.frs;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements ViewPager.OnPageChangeListener {
    final /* synthetic */ bc a;
    private final /* synthetic */ IndicatorView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bc bcVar, IndicatorView indicatorView) {
        this.a = bcVar;
        this.b = indicatorView;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.b != null) {
            this.b.setPosition(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }
}
