package com.baidu.tieba;

import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.List;
/* loaded from: classes.dex */
public class LabelAdapter extends android.support.v4.view.ae {

    /* renamed from: a  reason: collision with root package name */
    List f822a;

    public LabelAdapter(List list) {
        this.f822a = list;
    }

    @Override // android.support.v4.view.ae
    public int getCount() {
        return this.f822a.size();
    }

    @Override // android.support.v4.view.ae
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.ae
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView((View) this.f822a.get(i));
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView((View) this.f822a.get(i), 0);
        return this.f822a.get(i);
    }
}
