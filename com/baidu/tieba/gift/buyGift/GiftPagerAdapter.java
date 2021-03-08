package com.baidu.tieba.gift.buyGift;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class GiftPagerAdapter extends PagerAdapter {
    private List<View> bbS;

    public GiftPagerAdapter(List<View> list) {
        this.bbS = new ArrayList();
        this.bbS = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.bbS == null) {
            return 0;
        }
        return this.bbS.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (i >= 0 && i < getCount()) {
            viewGroup.removeView(this.bbS.get(i));
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        View view = this.bbS.get(i);
        viewGroup.addView(view);
        return view;
    }
}
