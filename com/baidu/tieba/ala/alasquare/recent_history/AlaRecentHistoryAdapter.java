package com.baidu.tieba.ala.alasquare.recent_history;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class AlaRecentHistoryAdapter extends AbsTabPagerAdapter {
    private static final String[] fgZ = {TbadkCoreApplication.getInst().getResources().getString(R.string.square_recent_tab_title_living), TbadkCoreApplication.getInst().getResources().getString(R.string.square_recent_tab_title_whole)};
    private static final int[] fha = {100, 200};
    private Fragment[] aMI;

    public AlaRecentHistoryAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.aMI = new Fragment[2];
        this.aMI[0] = AlaRecentHistoryFragment.pG(0);
        this.aMI[1] = AlaRecentHistoryFragment.pG(1);
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public int getPageType(int i) {
        return fha[i];
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public String getTabTitle(int i) {
        return fgZ[i];
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.aMI[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }
}
