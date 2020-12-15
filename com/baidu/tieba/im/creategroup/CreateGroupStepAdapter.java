package com.baidu.tieba.im.creategroup;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class CreateGroupStepAdapter extends PagerAdapter {
    public CreateGroupStepActivity kot;
    private List<o> kpf = new ArrayList();

    public CreateGroupStepAdapter(CreateGroupStepActivity createGroupStepActivity) {
        this.kot = createGroupStepActivity;
    }

    public List<o> getList() {
        return this.kpf;
    }

    public o DU(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.kpf.get(i);
    }

    public void a(o oVar) {
        this.kpf.add(oVar);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.kpf.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.kpf.get(i).getView(), 0);
        return this.kpf.get(i).getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.kpf.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
