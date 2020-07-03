package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class CreateGroupStepAdapter extends PagerAdapter {
    public CreateGroupStepActivity iNW;
    private List<o> iOI = new ArrayList();

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.iNW = createGroupStepActivity;
    }

    public List<o> getList() {
        return this.iOI;
    }

    public o yf(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.iOI.get(i);
    }

    public void a(o oVar) {
        this.iOI.add(oVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.iOI.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.iOI.get(i).getView(), 0);
        return this.iOI.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.iOI.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
