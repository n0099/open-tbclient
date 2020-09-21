package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class CreateGroupStepAdapter extends PagerAdapter {
    public CreateGroupStepActivity jsK;
    private List<o> jtw = new ArrayList();

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.jsK = createGroupStepActivity;
    }

    public List<o> getList() {
        return this.jtw;
    }

    public o Bv(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.jtw.get(i);
    }

    public void a(o oVar) {
        this.jtw.add(oVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.jtw.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.jtw.get(i).getView(), 0);
        return this.jtw.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.jtw.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
