package com.baidu.tieba.editortool;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class r extends PagerAdapter {
    final /* synthetic */ EmotionTabContentView a;
    private ArrayList<View> b;

    public r(EmotionTabContentView emotionTabContentView, ArrayList<View> arrayList) {
        this.a = emotionTabContentView;
        this.b = new ArrayList<>();
        this.b = arrayList;
    }

    @Override // android.support.v4.view.PagerAdapter
    public final int getCount() {
        return this.b.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.b.get(i));
    }

    @Override // android.support.v4.view.PagerAdapter
    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = this.b.get(i);
        viewGroup.addView(view);
        return view;
    }
}
