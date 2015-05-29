package com.baidu.tbadk.mvc.i.a;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class c extends PagerAdapter {
    private a aoK;

    public c(a aVar) {
        this.aoK = aVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.aoK.getChildCount();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        this.aoK.a(i, viewGroup, this.aoK.dX(i));
        return this.aoK.dU(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.aoK.h(i, false);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
