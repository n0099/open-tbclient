package com.baidu.tieba.home;

import android.support.v4.view.ViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends ViewPager.SimpleOnPageChangeListener {
    final /* synthetic */ z a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar) {
        this.a = zVar;
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
            viewPager2 = this.a.h;
            int currentItem = viewPager2.getCurrentItem();
            if (currentItem < 1) {
                viewPager6 = this.a.h;
                topicPagerAdapter2 = this.a.i;
                viewPager6.a(topicPagerAdapter2.getCount() - 2, false);
                viewPager7 = this.a.h;
                viewPager7.invalidate();
            } else {
                topicPagerAdapter = this.a.i;
                if (currentItem > topicPagerAdapter.getCount() - 2) {
                    viewPager3 = this.a.h;
                    viewPager3.a(1, false);
                    viewPager4 = this.a.h;
                    viewPager4.invalidate();
                }
            }
            viewPager5 = this.a.h;
            viewPager5.requestDisallowInterceptTouchEvent(false);
        } else if (i == 1) {
            viewPager = this.a.h;
            viewPager.requestDisallowInterceptTouchEvent(true);
        }
    }
}
