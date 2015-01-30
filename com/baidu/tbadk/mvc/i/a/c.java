package com.baidu.tbadk.mvc.i.a;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class c extends PagerAdapter {
    private a afi;

    public c(a aVar) {
        this.afi = aVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.afi.getChildCount();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        this.afi.a(i, viewGroup, this.afi.dK(i));
        return this.afi.dH(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.afi.h(i, false);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
