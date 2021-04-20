package com.baidu.tieba.gift.buyGift;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class GiftPagerAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<View> f16539a;

    public GiftPagerAdapter(List<View> list) {
        this.f16539a = new ArrayList();
        this.f16539a = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (i < 0 || i >= getCount()) {
            return;
        }
        viewGroup.removeView(this.f16539a.get(i));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<View> list = this.f16539a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        View view = this.f16539a.get(i);
        viewGroup.addView(view);
        return view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
