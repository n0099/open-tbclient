package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class CreateGroupStepAdapter extends PagerAdapter {
    public CreateGroupStepActivity gCY;
    private List<o> gDK = new ArrayList();

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.gCY = createGroupStepActivity;
    }

    public List<o> getList() {
        return this.gDK;
    }

    public o tV(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.gDK.get(i);
    }

    public void a(o oVar) {
        this.gDK.add(oVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.gDK.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.gDK.get(i).getView(), 0);
        return this.gDK.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.gDK.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
