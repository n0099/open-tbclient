package com.baidu.tieba.frs;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class da extends PagerAdapter {
    private ArrayList<View> DV;

    public da(ArrayList<View> arrayList) {
        this.DV = arrayList;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.DV == null) {
            return 0;
        }
        return this.DV.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.DV == null) {
            return null;
        }
        viewGroup.addView(this.DV.get(i));
        return this.DV.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.DV != null) {
            viewGroup.removeView(this.DV.get(i));
        }
    }
}
