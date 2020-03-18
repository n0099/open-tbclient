package com.baidu.tieba.ala.alasquare.recent_history;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class AlaRecentHistoryAdapter extends AbsTabPagerAdapter {
    private static final String[] eqE = {TbadkCoreApplication.getInst().getResources().getString(R.string.square_recent_tab_title_living), TbadkCoreApplication.getInst().getResources().getString(R.string.square_recent_tab_title_whole)};
    private static final int[] eqF = {100, 200};
    private Fragment[] aoz;

    public AlaRecentHistoryAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.aoz = new Fragment[2];
        this.aoz[0] = AlaRecentHistoryFragment.oK(0);
        this.aoz[1] = AlaRecentHistoryFragment.oK(1);
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public int getPageType(int i) {
        return eqF[i];
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public String getTabTitle(int i) {
        return eqE[i];
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.aoz[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }
}
