package com.baidu.tieba.ala.alasquare.recent_history;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class AlaRecentHistoryAdapter extends AbsTabPagerAdapter {
    private static final String[] fxv = {TbadkCoreApplication.getInst().getResources().getString(R.string.square_recent_tab_title_living), TbadkCoreApplication.getInst().getResources().getString(R.string.square_recent_tab_title_whole)};
    private static final int[] fxw = {100, 200};
    private Fragment[] aQH;

    public AlaRecentHistoryAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.aQH = new Fragment[2];
        this.aQH[0] = AlaRecentHistoryFragment.qu(0);
        this.aQH[1] = AlaRecentHistoryFragment.qu(1);
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public int getPageType(int i) {
        return fxw[i];
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public String getTabTitle(int i) {
        return fxv[i];
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.aQH[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }
}
