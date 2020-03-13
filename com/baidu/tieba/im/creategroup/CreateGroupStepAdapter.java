package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class CreateGroupStepAdapter extends PagerAdapter {
    private List<o> hwO = new ArrayList();
    public CreateGroupStepActivity hwc;

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.hwc = createGroupStepActivity;
    }

    public List<o> getList() {
        return this.hwO;
    }

    public o wh(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.hwO.get(i);
    }

    public void a(o oVar) {
        this.hwO.add(oVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.hwO.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.hwO.get(i).getView(), 0);
        return this.hwO.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.hwO.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
