package com.baidu.tieba.ala.alasquare.recent_history;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class AlaRecentHistoryAdapter extends AbsTabPagerAdapter {
    private static final String[] gwh = {TbadkCoreApplication.getInst().getResources().getString(R.string.square_recent_tab_title_living), TbadkCoreApplication.getInst().getResources().getString(R.string.square_recent_tab_title_whole)};
    private static final int[] gwi = {100, 200};
    private Fragment[] bgH;

    public AlaRecentHistoryAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.bgH = new Fragment[2];
        this.bgH[0] = AlaRecentHistoryFragment.vb(0);
        this.bgH[1] = AlaRecentHistoryFragment.vb(1);
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public int getPageType(int i) {
        return gwi[i];
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public String getTabTitle(int i) {
        return gwh[i];
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.bgH[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }
}
