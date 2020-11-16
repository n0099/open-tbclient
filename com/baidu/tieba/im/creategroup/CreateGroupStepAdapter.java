package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class CreateGroupStepAdapter extends PagerAdapter {
    public CreateGroupStepActivity kaN;
    private List<o> kbz = new ArrayList();

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.kaN = createGroupStepActivity;
    }

    public List<o> getList() {
        return this.kbz;
    }

    public o Df(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.kbz.get(i);
    }

    public void a(o oVar) {
        this.kbz.add(oVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.kbz.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.kbz.get(i).getView(), 0);
        return this.kbz.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.kbz.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
