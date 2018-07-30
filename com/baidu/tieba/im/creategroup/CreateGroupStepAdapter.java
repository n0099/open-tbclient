package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class CreateGroupStepAdapter extends PagerAdapter {
    private List<o> eoU = new ArrayList();
    public CreateGroupStepActivity eoi;

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.eoi = createGroupStepActivity;
    }

    public List<o> getList() {
        return this.eoU;
    }

    public o nT(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.eoU.get(i);
    }

    public void a(o oVar) {
        this.eoU.add(oVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.eoU.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.eoU.get(i).getView(), 0);
        return this.eoU.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.eoU.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
