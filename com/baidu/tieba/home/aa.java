package com.baidu.tieba.home;

import android.support.v4.view.ViewPager;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends ViewPager.SimpleOnPageChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ z f1111a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.f1111a = zVar;
    }

    @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.bq
    public void b(int i) {
        ViewPager viewPager;
        ViewPager viewPager2;
        RecommendPagerAdapter recommendPagerAdapter;
        ViewPager viewPager3;
        ViewPager viewPager4;
        ViewPager viewPager5;
        ViewPager viewPager6;
        RecommendPagerAdapter recommendPagerAdapter2;
        ViewPager viewPager7;
        if (i == 0) {
            viewPager2 = this.f1111a.e;
            int currentItem = viewPager2.getCurrentItem();
            if (currentItem < 1) {
                viewPager6 = this.f1111a.e;
                recommendPagerAdapter2 = this.f1111a.f;
                viewPager6.a(recommendPagerAdapter2.getCount() - 2, false);
                viewPager7 = this.f1111a.e;
                viewPager7.invalidate();
            } else {
                recommendPagerAdapter = this.f1111a.f;
                if (currentItem > recommendPagerAdapter.getCount() - 2) {
                    viewPager3 = this.f1111a.e;
                    viewPager3.a(1, false);
                    viewPager4 = this.f1111a.e;
                    viewPager4.invalidate();
                }
            }
            viewPager5 = this.f1111a.e;
            viewPager5.requestDisallowInterceptTouchEvent(false);
        } else if (i == 1) {
            viewPager = this.f1111a.e;
            viewPager.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.bq
    public void a_(int i) {
        RecommendPagerAdapter recommendPagerAdapter;
        recommendPagerAdapter = this.f1111a.f;
        ((View) recommendPagerAdapter.d.get(i)).invalidate();
    }
}
