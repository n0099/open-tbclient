package com.baidu.tieba.ala.guardclub.rank;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
/* loaded from: classes10.dex */
public class GuardClubRankFragmentPageAdapter extends FragmentPagerAdapter {
    public Fragment bdw;
    private Fragment[] bdx;

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.bdx[i];
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.bdx.length;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        this.bdw = (Fragment) obj;
        super.setPrimaryItem(viewGroup, i, obj);
    }
}
