package com.baidu.tieba.home;

import android.support.v4.view.ViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends ViewPager.SimpleOnPageChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ z f890a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar) {
        this.f890a = zVar;
    }

    @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.bq
    public void b(int i) {
        ViewPager viewPager;
        ViewPager viewPager2;
        TopicPagerAdapter topicPagerAdapter;
        ViewPager viewPager3;
        ViewPager viewPager4;
        ViewPager viewPager5;
        ViewPager viewPager6;
        TopicPagerAdapter topicPagerAdapter2;
        ViewPager viewPager7;
        if (i == 0) {
            viewPager2 = this.f890a.h;
            int currentItem = viewPager2.getCurrentItem();
            if (currentItem < 1) {
                viewPager6 = this.f890a.h;
                topicPagerAdapter2 = this.f890a.i;
                viewPager6.a(topicPagerAdapter2.getCount() - 2, false);
                viewPager7 = this.f890a.h;
                viewPager7.invalidate();
            } else {
                topicPagerAdapter = this.f890a.i;
                if (currentItem > topicPagerAdapter.getCount() - 2) {
                    viewPager3 = this.f890a.h;
                    viewPager3.a(1, false);
                    viewPager4 = this.f890a.h;
                    viewPager4.invalidate();
                }
            }
            viewPager5 = this.f890a.h;
            viewPager5.requestDisallowInterceptTouchEvent(false);
        } else if (i == 1) {
            viewPager = this.f890a.h;
            viewPager.requestDisallowInterceptTouchEvent(true);
        }
    }
}
