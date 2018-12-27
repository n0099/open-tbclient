package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class CreateGroupStepAdapter extends PagerAdapter {
    private List<o> eOX = new ArrayList();
    public CreateGroupStepActivity eOl;

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.eOl = createGroupStepActivity;
    }

    public List<o> getList() {
        return this.eOX;
    }

    public o pV(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.eOX.get(i);
    }

    public void a(o oVar) {
        this.eOX.add(oVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.eOX.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.eOX.get(i).getView(), 0);
        return this.eOX.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.eOX.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
