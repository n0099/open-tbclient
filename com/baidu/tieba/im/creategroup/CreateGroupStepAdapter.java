package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class CreateGroupStepAdapter extends PagerAdapter {
    public CreateGroupStepActivity eEF;
    private List<o> eFr = new ArrayList();

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.eEF = createGroupStepActivity;
    }

    public List<o> getList() {
        return this.eFr;
    }

    public o po(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.eFr.get(i);
    }

    public void a(o oVar) {
        this.eFr.add(oVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.eFr.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.eFr.get(i).getView(), 0);
        return this.eFr.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.eFr.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
