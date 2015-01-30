package com.baidu.tbadk.editortool;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l extends PagerAdapter {
    final /* synthetic */ EmotionTabContentView Yl;
    private ArrayList<View> Yp;

    public l(EmotionTabContentView emotionTabContentView, ArrayList<View> arrayList) {
        this.Yl = emotionTabContentView;
        this.Yp = new ArrayList<>();
        this.Yp = arrayList;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.Yp.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.Yp.get(i));
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = this.Yp.get(i);
        viewGroup.addView(view);
        return view;
    }
}
