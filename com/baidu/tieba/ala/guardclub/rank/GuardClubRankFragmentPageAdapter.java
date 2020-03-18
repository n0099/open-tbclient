package com.baidu.tieba.ala.guardclub.rank;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
/* loaded from: classes3.dex */
public class GuardClubRankFragmentPageAdapter extends FragmentPagerAdapter {
    public Fragment aoy;
    private Fragment[] aoz;

    public GuardClubRankFragmentPageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public void a(Fragment... fragmentArr) {
        this.aoz = fragmentArr;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.aoz[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.aoz.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        this.aoy = (Fragment) obj;
        super.setPrimaryItem(viewGroup, i, obj);
    }
}
