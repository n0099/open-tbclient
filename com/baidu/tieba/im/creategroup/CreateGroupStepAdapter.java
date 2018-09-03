package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class CreateGroupStepAdapter extends PagerAdapter {
    private List<o> eoQ = new ArrayList();
    public CreateGroupStepActivity eod;

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.eod = createGroupStepActivity;
    }

    public List<o> getList() {
        return this.eoQ;
    }

    public o nT(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.eoQ.get(i);
    }

    public void a(o oVar) {
        this.eoQ.add(oVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.eoQ.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.eoQ.get(i).getView(), 0);
        return this.eoQ.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.eoQ.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
