package com.baidu.tieba.ala.guardclub.rank;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
/* loaded from: classes4.dex */
public class GuardClubRankFragmentPageAdapter extends FragmentPagerAdapter {
    public Fragment aYq;
    private Fragment[] aYr;

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.aYr[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.aYr.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        this.aYq = (Fragment) obj;
        super.setPrimaryItem(viewGroup, i, obj);
    }
}
