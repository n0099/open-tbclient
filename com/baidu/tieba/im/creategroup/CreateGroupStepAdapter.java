package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class CreateGroupStepAdapter extends PagerAdapter {
    public CreateGroupStepActivity egw;
    private List<o> ehi = new ArrayList();

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.egw = createGroupStepActivity;
    }

    public List<o> getList() {
        return this.ehi;
    }

    public o ny(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.ehi.get(i);
    }

    public void a(o oVar) {
        this.ehi.add(oVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.ehi.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.ehi.get(i).getView(), 0);
        return this.ehi.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.ehi.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
