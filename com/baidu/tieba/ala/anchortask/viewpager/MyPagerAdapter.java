package com.baidu.tieba.ala.anchortask.viewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class MyPagerAdapter extends PagerAdapter {
    Context context;
    private ArrayList<View> gNM;

    public MyPagerAdapter(Context context, ArrayList<View> arrayList) {
        this.context = context;
        this.gNM = arrayList;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.gNM.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.addView(this.gNM.get(i));
        return this.gNM.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.gNM.get(i));
    }
}
