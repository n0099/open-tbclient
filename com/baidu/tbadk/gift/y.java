package com.baidu.tbadk.gift;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class y extends PagerAdapter {
    private List<View> UK;

    public y(List<View> list) {
        this.UK = new ArrayList();
        this.UK = list;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.UK == null) {
            return 0;
        }
        return this.UK.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (i >= 0 && i < getCount()) {
            viewGroup.removeView(this.UK.get(i));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        View view = this.UK.get(i);
        viewGroup.addView(view);
        return view;
    }
}
