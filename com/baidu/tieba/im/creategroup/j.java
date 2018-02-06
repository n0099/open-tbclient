package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class j extends PagerAdapter {
    private List<p> eAj = new ArrayList();
    public CreateGroupStepActivity ezx;

    public j(CreateGroupStepActivity createGroupStepActivity) {
        this.ezx = createGroupStepActivity;
    }

    public List<p> getList() {
        return this.eAj;
    }

    public p pP(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.eAj.get(i);
    }

    public void a(p pVar) {
        this.eAj.add(pVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.eAj.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.eAj.get(i).getView(), 0);
        return this.eAj.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.eAj.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
