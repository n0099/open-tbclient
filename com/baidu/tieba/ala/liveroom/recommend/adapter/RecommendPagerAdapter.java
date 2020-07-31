package com.baidu.tieba.ala.liveroom.recommend.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes4.dex */
public class RecommendPagerAdapter extends PagerAdapter {
    private List<View> gvT;

    public RecommendPagerAdapter(List<View> list) {
        this.gvT = list;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.gvT.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.addView(this.gvT.get(i));
        return this.gvT.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.gvT.get(i));
    }
}
