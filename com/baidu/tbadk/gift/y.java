package com.baidu.tbadk.gift;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class y extends PagerAdapter {
    private List<View> UO;

    public y(List<View> list) {
        this.UO = new ArrayList();
        this.UO = list;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.UO == null) {
            return 0;
        }
        return this.UO.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (i >= 0 && i < getCount()) {
            viewGroup.removeView(this.UO.get(i));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        View view = this.UO.get(i);
        viewGroup.addView(view);
        return view;
    }
}
