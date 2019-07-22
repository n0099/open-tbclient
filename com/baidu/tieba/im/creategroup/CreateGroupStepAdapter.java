package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class CreateGroupStepAdapter extends PagerAdapter {
    public CreateGroupStepActivity gCp;
    private List<o> gDb = new ArrayList();

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.gCp = createGroupStepActivity;
    }

    public List<o> getList() {
        return this.gDb;
    }

    public o vk(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.gDb.get(i);
    }

    public void a(o oVar) {
        this.gDb.add(oVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.gDb.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.gDb.get(i).getView(), 0);
        return this.gDb.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.gDb.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
