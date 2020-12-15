package com.baidu.tieba.ala.anchortask.viewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class MyPagerAdapter extends PagerAdapter {
    Context context;
    private ArrayList<View> gCd;

    public MyPagerAdapter(Context context, ArrayList<View> arrayList) {
        this.context = context;
        this.gCd = arrayList;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.gCd.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.addView(this.gCd.get(i));
        return this.gCd.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.gCd.get(i));
    }
}
