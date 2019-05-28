package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class CreateGroupStepAdapter extends PagerAdapter {
    private List<o> gwO = new ArrayList();
    public CreateGroupStepActivity gwc;

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.gwc = createGroupStepActivity;
    }

    public List<o> getList() {
        return this.gwO;
    }

    public o uJ(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.gwO.get(i);
    }

    public void a(o oVar) {
        this.gwO.add(oVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.gwO.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.gwO.get(i).getView(), 0);
        return this.gwO.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.gwO.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
