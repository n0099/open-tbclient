package com.baidu.tbadk.widget.multiItemViewPager;

import android.support.v4.view.ViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements ViewPager.OnPageChangeListener {
    final /* synthetic */ MultiItemViewPager aCI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MultiItemViewPager multiItemViewPager) {
        this.aCI = multiItemViewPager;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.aCI != null) {
            this.aCI.invalidate();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager viewPager;
        ViewPager viewPager2;
        ViewPager viewPager3;
        ViewPager viewPager4;
        ViewPager viewPager5;
        ViewPager viewPager6;
        ViewPager viewPager7;
        ViewPager viewPager8;
        ViewPager viewPager9;
        ViewPager viewPager10;
        ViewPager viewPager11;
        ViewPager viewPager12;
        switch (i) {
            case 0:
                viewPager = this.aCI.mViewPager;
                int currentItem = viewPager.getCurrentItem();
                viewPager2 = this.aCI.mViewPager;
                if (currentItem == viewPager2.getAdapter().getCount() - 2) {
                    viewPager12 = this.aCI.mViewPager;
                    viewPager12.setCurrentItem(2, false);
                    return;
                }
                viewPager3 = this.aCI.mViewPager;
                int currentItem2 = viewPager3.getCurrentItem();
                viewPager4 = this.aCI.mViewPager;
                if (currentItem2 == viewPager4.getAdapter().getCount() - 1) {
                    viewPager11 = this.aCI.mViewPager;
                    viewPager11.setCurrentItem(3, false);
                    return;
                }
                viewPager5 = this.aCI.mViewPager;
                if (viewPager5.getCurrentItem() == 1) {
                    viewPager9 = this.aCI.mViewPager;
                    viewPager10 = this.aCI.mViewPager;
                    viewPager9.setCurrentItem(viewPager10.getAdapter().getCount() - 3, false);
                    return;
                }
                viewPager6 = this.aCI.mViewPager;
                if (viewPager6.getCurrentItem() == 0) {
                    viewPager7 = this.aCI.mViewPager;
                    viewPager8 = this.aCI.mViewPager;
                    viewPager7.setCurrentItem((viewPager8.getAdapter().getCount() - 3) - 1, false);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
