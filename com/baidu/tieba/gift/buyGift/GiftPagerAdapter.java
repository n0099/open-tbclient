package com.baidu.tieba.gift.buyGift;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class GiftPagerAdapter extends PagerAdapter {
    private List<View> bas;

    public GiftPagerAdapter(List<View> list) {
        this.bas = new ArrayList();
        this.bas = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.bas == null) {
            return 0;
        }
        return this.bas.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (i >= 0 && i < getCount()) {
            viewGroup.removeView(this.bas.get(i));
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        View view = this.bas.get(i);
        viewGroup.addView(view);
        return view;
    }
}
