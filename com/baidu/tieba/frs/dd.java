package com.baidu.tieba.frs;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dd extends PagerAdapter {
    private ArrayList<View> Vb;

    public dd(ArrayList<View> arrayList) {
        this.Vb = arrayList;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.Vb == null) {
            return 0;
        }
        return this.Vb.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.Vb == null || i < 0 || i >= this.Vb.size()) {
            return null;
        }
        View view = this.Vb.get(i);
        if (view != null && view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        viewGroup.addView(view);
        return this.Vb.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.Vb != null && i >= 0 && i < this.Vb.size()) {
            viewGroup.removeView(this.Vb.get(i));
        }
    }
}
