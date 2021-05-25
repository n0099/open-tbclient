package com.baidu.tieba.ala.alasquare.recent_history;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class AlaRecentHistoryAdapter extends AbsTabPagerAdapter {

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f13778b = {TbadkCoreApplication.getInst().getResources().getString(R.string.square_recent_tab_title_living), TbadkCoreApplication.getInst().getResources().getString(R.string.square_recent_tab_title_whole)};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f13779c = {100, 200};

    /* renamed from: a  reason: collision with root package name */
    public Fragment[] f13780a;

    public AlaRecentHistoryAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        Fragment[] fragmentArr = new Fragment[2];
        this.f13780a = fragmentArr;
        fragmentArr[0] = AlaRecentHistoryFragment.I0(0);
        this.f13780a[1] = AlaRecentHistoryFragment.I0(1);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 2;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        return this.f13780a[i2];
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public int getPageType(int i2) {
        return f13779c[i2];
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public String getTabTitle(int i2) {
        return f13778b[i2];
    }
}
