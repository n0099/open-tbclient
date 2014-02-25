package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class m extends PagerAdapter {
    public CreateGroupStepActivity a;
    private List<x> b = new ArrayList();

    public m(CreateGroupStepActivity createGroupStepActivity) {
        this.a = createGroupStepActivity;
    }

    public List<x> a() {
        return this.b;
    }

    public x a(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.b.get(i);
    }

    public void a(x xVar) {
        this.b.add(xVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.b.get(i).a(), 0);
        return this.b.get(i).a();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.b.get(i).a());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
