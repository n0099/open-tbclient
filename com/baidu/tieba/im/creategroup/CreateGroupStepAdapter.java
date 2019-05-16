package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class CreateGroupStepAdapter extends PagerAdapter {
    private List<o> gwN = new ArrayList();
    public CreateGroupStepActivity gwb;

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.gwb = createGroupStepActivity;
    }

    public List<o> getList() {
        return this.gwN;
    }

    public o uJ(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.gwN.get(i);
    }

    public void a(o oVar) {
        this.gwN.add(oVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.gwN.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.gwN.get(i).getView(), 0);
        return this.gwN.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.gwN.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
