package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class CreateGroupStepAdapter extends PagerAdapter {
    private List<o> dVV = new ArrayList();
    public CreateGroupStepActivity dVj;

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.dVj = createGroupStepActivity;
    }

    public List<o> getList() {
        return this.dVV;
    }

    public o nm(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.dVV.get(i);
    }

    public void a(o oVar) {
        this.dVV.add(oVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.dVV.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view2, int i) {
        ((ViewPager) view2).addView(this.dVV.get(i).getView(), 0);
        return this.dVV.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view2, int i, Object obj) {
        ((ViewPager) view2).removeView(this.dVV.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view2, Object obj) {
        return view2 == obj;
    }
}
