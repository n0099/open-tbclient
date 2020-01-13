package com.baidu.tieba.ala.guardclub.rank;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
public class GuardClubRankFragmentPageAdapter extends FragmentPagerAdapter {
    public Fragment ama;
    private Fragment[] amb;

    public GuardClubRankFragmentPageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public void a(Fragment... fragmentArr) {
        this.amb = fragmentArr;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.amb[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.amb.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        this.ama = (Fragment) obj;
        super.setPrimaryItem(viewGroup, i, obj);
    }
}
