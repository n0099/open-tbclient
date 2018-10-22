package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class CreateGroupStepAdapter extends PagerAdapter {
    private List<o> eDY = new ArrayList();
    public CreateGroupStepActivity eDm;

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.eDm = createGroupStepActivity;
    }

    public List<o> getList() {
        return this.eDY;
    }

    public o oV(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.eDY.get(i);
    }

    public void a(o oVar) {
        this.eDY.add(oVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.eDY.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.eDY.get(i).getView(), 0);
        return this.eDY.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.eDY.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
