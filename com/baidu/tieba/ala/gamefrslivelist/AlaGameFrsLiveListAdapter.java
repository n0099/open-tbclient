package com.baidu.tieba.ala.gamefrslivelist;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;
/* loaded from: classes9.dex */
public class AlaGameFrsLiveListAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;

    public AlaGameFrsLiveListAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public void cq(List<Fragment> list) {
        this.list = list;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.list.size() > i) {
            return this.list.get(i);
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.list != null) {
            return this.list.size();
        }
        return 0;
    }
}
