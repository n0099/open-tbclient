package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public class CreateGroupStepAdapter extends PagerAdapter {
    private List<o> jkS = new ArrayList();
    public CreateGroupStepActivity jkg;

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.jkg = createGroupStepActivity;
    }

    public List<o> getList() {
        return this.jkS;
    }

    public o AU(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.jkS.get(i);
    }

    public void a(o oVar) {
        this.jkS.add(oVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.jkS.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.jkS.get(i).getView(), 0);
        return this.jkS.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.jkS.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
