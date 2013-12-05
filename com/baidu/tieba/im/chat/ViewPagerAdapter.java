package com.baidu.tieba.im.chat;

import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.List;
/* loaded from: classes.dex */
public class ViewPagerAdapter extends android.support.v4.view.ae {

    /* renamed from: a  reason: collision with root package name */
    private List<View> f1535a;

    public ViewPagerAdapter(List<View> list) {
        this.f1535a = list;
    }

    @Override // android.support.v4.view.ae
    public int getCount() {
        return this.f1535a.size();
    }

    @Override // android.support.v4.view.ae
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.ae
    public int getItemPosition(Object obj) {
        return super.getItemPosition(obj);
    }

    @Override // android.support.v4.view.ae
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.f1535a.get(i));
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.f1535a.get(i));
        return this.f1535a.get(i);
    }
}
