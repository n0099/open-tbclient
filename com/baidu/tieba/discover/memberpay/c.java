package com.baidu.tieba.discover.memberpay;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes.dex */
public class c extends PagerAdapter {
    private List<View> UO;
    private MemberPayActivity aoA;

    public c(MemberPayActivity memberPayActivity, List<View> list) {
        this.aoA = memberPayActivity;
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
        super.destroyItem(viewGroup, i, obj);
        viewGroup.removeAllViews();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        return super.getItemPosition(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.addView(this.UO.get(i));
        return this.UO.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        for (View view : this.UO) {
            this.aoA.getLayoutMode().L(i == 1);
            this.aoA.getLayoutMode().h(view);
        }
    }
}
