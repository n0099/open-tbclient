package com.baidu.tieba.ala.guardclub.rank;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
/* loaded from: classes4.dex */
public class GuardClubRankFragmentPageAdapter extends FragmentPagerAdapter {
    public Fragment aQG;
    private Fragment[] aQH;

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.aQH[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.aQH.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        this.aQG = (Fragment) obj;
        super.setPrimaryItem(viewGroup, i, obj);
    }
}
