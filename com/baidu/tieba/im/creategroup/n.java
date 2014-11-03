package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n extends PagerAdapter {
    private List<y> aTS = new ArrayList();
    public CreateGroupStepActivity aTd;

    public n(CreateGroupStepActivity createGroupStepActivity) {
        this.aTd = createGroupStepActivity;
    }

    public List<y> getList() {
        return this.aTS;
    }

    public y fu(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.aTS.get(i);
    }

    public void a(y yVar) {
        this.aTS.add(yVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.aTS.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.aTS.get(i).getView(), 0);
        return this.aTS.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.aTS.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
