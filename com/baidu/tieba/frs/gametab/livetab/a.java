package com.baidu.tieba.frs.gametab.livetab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;
/* loaded from: classes.dex */
public class a extends FragmentPagerAdapter {
    private int[] bci;
    private List<Fragment> list;

    public a(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.bci = new int[]{0, 1, 2};
    }

    public void aa(List<Fragment> list) {
        this.list = list;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.list.size() > i) {
            return this.list.get(i);
        }
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.list != null) {
            return this.list.size();
        }
        return 0;
    }
}
