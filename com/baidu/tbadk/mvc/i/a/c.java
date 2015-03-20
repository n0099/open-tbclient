package com.baidu.tbadk.mvc.i.a;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class c extends PagerAdapter {
    private a anz;

    public c(a aVar) {
        this.anz = aVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.anz.getChildCount();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        this.anz.a(i, viewGroup, this.anz.dN(i));
        return this.anz.dK(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.anz.h(i, false);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
