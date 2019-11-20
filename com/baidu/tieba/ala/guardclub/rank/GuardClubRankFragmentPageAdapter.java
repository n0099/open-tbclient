package com.baidu.tieba.ala.guardclub.rank;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
/* loaded from: classes6.dex */
public class GuardClubRankFragmentPageAdapter extends FragmentPagerAdapter {
    public Fragment adp;
    private Fragment[] adq;

    public GuardClubRankFragmentPageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public void a(Fragment... fragmentArr) {
        this.adq = fragmentArr;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.adq[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.adq.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        this.adp = (Fragment) obj;
        super.setPrimaryItem(viewGroup, i, obj);
    }
}
