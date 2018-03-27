package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class j extends PagerAdapter {
    private List<p> eAn = new ArrayList();
    public CreateGroupStepActivity ezB;

    public j(CreateGroupStepActivity createGroupStepActivity) {
        this.ezB = createGroupStepActivity;
    }

    public List<p> getList() {
        return this.eAn;
    }

    public p pQ(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.eAn.get(i);
    }

    public void a(p pVar) {
        this.eAn.add(pVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.eAn.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.eAn.get(i).getView(), 0);
        return this.eAn.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.eAn.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
