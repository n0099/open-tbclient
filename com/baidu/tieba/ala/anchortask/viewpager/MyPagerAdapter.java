package com.baidu.tieba.ala.anchortask.viewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class MyPagerAdapter extends PagerAdapter {
    Context context;
    private ArrayList<View> gCb;

    public MyPagerAdapter(Context context, ArrayList<View> arrayList) {
        this.context = context;
        this.gCb = arrayList;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.gCb.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.addView(this.gCb.get(i));
        return this.gCb.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.gCb.get(i));
    }
}
