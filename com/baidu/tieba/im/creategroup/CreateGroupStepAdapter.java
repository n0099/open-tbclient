package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class CreateGroupStepAdapter extends PagerAdapter {
    public CreateGroupStepActivity iwR;
    private List<o> ixD = new ArrayList();

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.iwR = createGroupStepActivity;
    }

    public List<o> getList() {
        return this.ixD;
    }

    public o xv(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.ixD.get(i);
    }

    public void a(o oVar) {
        this.ixD.add(oVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.ixD.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.ixD.get(i).getView(), 0);
        return this.ixD.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.ixD.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
