package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class CreateGroupStepAdapter extends PagerAdapter {
    private List<o> iwQ = new ArrayList();
    public CreateGroupStepActivity iwe;

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.iwe = createGroupStepActivity;
    }

    public List<o> getList() {
        return this.iwQ;
    }

    public o xt(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.iwQ.get(i);
    }

    public void a(o oVar) {
        this.iwQ.add(oVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.iwQ.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.iwQ.get(i).getView(), 0);
        return this.iwQ.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.iwQ.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
