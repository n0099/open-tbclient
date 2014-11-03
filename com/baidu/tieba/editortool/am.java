package com.baidu.tieba.editortool;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class am extends PagerAdapter {
    private ArrayList<View> RM;
    final /* synthetic */ PrivilegeTabContentView arJ;

    public am(PrivilegeTabContentView privilegeTabContentView, ArrayList<View> arrayList) {
        this.arJ = privilegeTabContentView;
        this.RM = new ArrayList<>();
        this.RM = arrayList;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.RM.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.RM.get(i));
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = this.RM.get(i);
        viewGroup.addView(view);
        return view;
    }
}
