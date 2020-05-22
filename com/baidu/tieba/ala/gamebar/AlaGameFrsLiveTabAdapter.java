package com.baidu.tieba.ala.gamebar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaGameFrsLiveTabAdapter extends FragmentPagerAdapter {
    private int[] fwa;
    private List<Fragment> list;

    public AlaGameFrsLiveTabAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.fwa = new int[]{0, 1};
    }

    public void bx(List<Fragment> list) {
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
