package com.baidu.tieba.ala.alasquare.recent_history;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class AlaRecentHistoryAdapter extends AbsTabPagerAdapter {
    private static final String[] gCE = {TbadkCoreApplication.getInst().getResources().getString(R.string.square_recent_tab_title_living), TbadkCoreApplication.getInst().getResources().getString(R.string.square_recent_tab_title_whole)};
    private static final int[] gCF = {100, 200};
    private Fragment[] bdx;

    public AlaRecentHistoryAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.bdx = new Fragment[2];
        this.bdx[0] = AlaRecentHistoryFragment.tG(0);
        this.bdx[1] = AlaRecentHistoryFragment.tG(1);
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public int getPageType(int i) {
        return gCF[i];
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public String getTabTitle(int i) {
        return gCE[i];
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.bdx[i];
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 2;
    }
}
