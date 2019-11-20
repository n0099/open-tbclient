package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class CreateGroupStepAdapter extends PagerAdapter {
    private List<o> gCT = new ArrayList();
    public CreateGroupStepActivity gCh;

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.gCh = createGroupStepActivity;
    }

    public List<o> getList() {
        return this.gCT;
    }

    public o tU(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.gCT.get(i);
    }

    public void a(o oVar) {
        this.gCT.add(oVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.gCT.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.gCT.get(i).getView(), 0);
        return this.gCT.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.gCT.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
