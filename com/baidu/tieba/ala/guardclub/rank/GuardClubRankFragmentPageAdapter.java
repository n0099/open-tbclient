package com.baidu.tieba.ala.guardclub.rank;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
/* loaded from: classes3.dex */
public class GuardClubRankFragmentPageAdapter extends FragmentPagerAdapter {
    public Fragment aGR;
    private Fragment[] aGS;

    public GuardClubRankFragmentPageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public void a(Fragment... fragmentArr) {
        this.aGS = fragmentArr;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.aGS[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.aGS.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        this.aGR = (Fragment) obj;
        super.setPrimaryItem(viewGroup, i, obj);
    }
}
