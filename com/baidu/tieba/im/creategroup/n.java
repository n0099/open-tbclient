package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n extends PagerAdapter {
    public CreateGroupStepActivity aSP;
    private List<y> aTE = new ArrayList();

    public n(CreateGroupStepActivity createGroupStepActivity) {
        this.aSP = createGroupStepActivity;
    }

    public List<y> getList() {
        return this.aTE;
    }

    public y fu(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.aTE.get(i);
    }

    public void a(y yVar) {
        this.aTE.add(yVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.aTE.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.aTE.get(i).getView(), 0);
        return this.aTE.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.aTE.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
