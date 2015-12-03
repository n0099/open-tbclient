package com.baidu.tieba.gift.buyGift;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s extends PagerAdapter {
    private List<View> aMs;

    public s(List<View> list) {
        this.aMs = new ArrayList();
        this.aMs = list;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.aMs == null) {
            return 0;
        }
        return this.aMs.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (i >= 0 && i < getCount()) {
            viewGroup.removeView(this.aMs.get(i));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        View view = this.aMs.get(i);
        viewGroup.addView(view);
        return view;
    }
}
