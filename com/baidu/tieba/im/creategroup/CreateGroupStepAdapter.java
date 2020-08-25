package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public class CreateGroupStepAdapter extends PagerAdapter {
    private List<o> jkM = new ArrayList();
    public CreateGroupStepActivity jka;

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.jka = createGroupStepActivity;
    }

    public List<o> getList() {
        return this.jkM;
    }

    public o AU(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.jkM.get(i);
    }

    public void a(o oVar) {
        this.jkM.add(oVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.jkM.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.jkM.get(i).getView(), 0);
        return this.jkM.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.jkM.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
