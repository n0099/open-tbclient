package com.baidu.tieba.discover.memberpay;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes.dex */
public class c extends PagerAdapter {
    private List<View> a;
    private MemberPayActivity b;

    public c(MemberPayActivity memberPayActivity, List<View> list) {
        this.b = memberPayActivity;
        this.a = list;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
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
        viewGroup.addView(this.a.get(i));
        return this.a.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
    }

    public void a(int i) {
        notifyDataSetChanged();
        for (View view : this.a) {
            this.b.getLayoutMode().a(i == 1);
            this.b.getLayoutMode().a(view);
        }
    }
}
