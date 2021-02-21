package com.baidu.tieba.ala.anchortask.viewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class MyPagerAdapter extends PagerAdapter {
    Context context;
    private ArrayList<View> gMd;

    public MyPagerAdapter(Context context, ArrayList<View> arrayList) {
        this.context = context;
        this.gMd = arrayList;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.gMd.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.addView(this.gMd.get(i));
        return this.gMd.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.gMd.get(i));
    }
}
