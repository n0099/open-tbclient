package com.baidu.tbadk.mvc.i.a;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class c extends PagerAdapter {
    private a aff;

    public c(a aVar) {
        this.aff = aVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.aff.getChildCount();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        this.aff.a(i, viewGroup, this.aff.dK(i));
        return this.aff.dH(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.aff.h(i, false);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
