package com.baidu.tieba.gift.buyGift;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s extends PagerAdapter {
    private List<View> bnr;

    public s(List<View> list) {
        this.bnr = new ArrayList();
        this.bnr = list;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.bnr == null) {
            return 0;
        }
        return this.bnr.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (i >= 0 && i < getCount()) {
            viewGroup.removeView(this.bnr.get(i));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        View view = this.bnr.get(i);
        viewGroup.addView(view);
        return view;
    }
}
