package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class CreateGroupStepAdapter extends PagerAdapter {
    public CreateGroupStepActivity htP;
    private List<o> huB = new ArrayList();

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.htP = createGroupStepActivity;
    }

    public List<o> getList() {
        return this.huB;
    }

    public o wb(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.huB.get(i);
    }

    public void a(o oVar) {
        this.huB.add(oVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.huB.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.huB.get(i).getView(), 0);
        return this.huB.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.huB.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
