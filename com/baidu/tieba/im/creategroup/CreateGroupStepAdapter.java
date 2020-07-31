package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public class CreateGroupStepAdapter extends PagerAdapter {
    public CreateGroupStepActivity iUZ;
    private List<o> iVL = new ArrayList();

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.iUZ = createGroupStepActivity;
    }

    public List<o> getList() {
        return this.iVL;
    }

    public o yA(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.iVL.get(i);
    }

    public void a(o oVar) {
        this.iVL.add(oVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.iVL.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.iVL.get(i).getView(), 0);
        return this.iVL.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.iVL.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
