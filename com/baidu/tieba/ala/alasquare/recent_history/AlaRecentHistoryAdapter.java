package com.baidu.tieba.ala.alasquare.recent_history;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class AlaRecentHistoryAdapter extends AbsTabPagerAdapter {
    private static final String[] fIN = {TbadkCoreApplication.getInst().getResources().getString(R.string.square_recent_tab_title_living), TbadkCoreApplication.getInst().getResources().getString(R.string.square_recent_tab_title_whole)};
    private static final int[] fIO = {100, 200};
    private Fragment[] aVV;

    public AlaRecentHistoryAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.aVV = new Fragment[2];
        this.aVV[0] = AlaRecentHistoryFragment.sG(0);
        this.aVV[1] = AlaRecentHistoryFragment.sG(1);
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public int getPageType(int i) {
        return fIO[i];
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public String getTabTitle(int i) {
        return fIN[i];
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.aVV[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }
}
