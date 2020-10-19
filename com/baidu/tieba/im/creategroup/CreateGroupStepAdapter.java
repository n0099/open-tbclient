package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class CreateGroupStepAdapter extends PagerAdapter {
    public CreateGroupStepActivity jHH;
    private List<o> jIt = new ArrayList();

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.jHH = createGroupStepActivity;
    }

    public List<o> getList() {
        return this.jIt;
    }

    public o Cb(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.jIt.get(i);
    }

    public void a(o oVar) {
        this.jIt.add(oVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.jIt.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.jIt.get(i).getView(), 0);
        return this.jIt.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.jIt.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
