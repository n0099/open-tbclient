package com.baidu.tbadk.mvc.i.a;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class c extends PagerAdapter {
    private a aeL;

    public c(a aVar) {
        this.aeL = aVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.aeL.getChildCount();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        this.aeL.a(i, viewGroup, this.aeL.dE(i));
        return this.aeL.dB(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.aeL.h(i, false);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
