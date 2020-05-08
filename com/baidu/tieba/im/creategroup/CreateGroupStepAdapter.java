package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class CreateGroupStepAdapter extends PagerAdapter {
    public CreateGroupStepActivity ihv;
    private List<o> iih = new ArrayList();

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.ihv = createGroupStepActivity;
    }

    public List<o> getList() {
        return this.iih;
    }

    public o wN(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.iih.get(i);
    }

    public void a(o oVar) {
        this.iih.add(oVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.iih.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.iih.get(i).getView(), 0);
        return this.iih.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.iih.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
