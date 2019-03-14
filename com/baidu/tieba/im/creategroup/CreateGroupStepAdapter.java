package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class CreateGroupStepAdapter extends PagerAdapter {
    private List<o> gfN = new ArrayList();
    public CreateGroupStepActivity gfb;

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.gfb = createGroupStepActivity;
    }

    public List<o> getList() {
        return this.gfN;
    }

    public o tG(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.gfN.get(i);
    }

    public void a(o oVar) {
        this.gfN.add(oVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.gfN.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.gfN.get(i).getView(), 0);
        return this.gfN.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.gfN.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
