package com.baidu.tieba.editortool;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class am extends PagerAdapter {
    private ArrayList<View> RI;
    final /* synthetic */ PrivilegeTabContentView arA;

    public am(PrivilegeTabContentView privilegeTabContentView, ArrayList<View> arrayList) {
        this.arA = privilegeTabContentView;
        this.RI = new ArrayList<>();
        this.RI = arrayList;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.RI.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.RI.get(i));
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = this.RI.get(i);
        viewGroup.addView(view);
        return view;
    }
}
