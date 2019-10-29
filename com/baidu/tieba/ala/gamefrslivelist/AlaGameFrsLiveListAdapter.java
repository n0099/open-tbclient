package com.baidu.tieba.ala.gamefrslivelist;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;
/* loaded from: classes6.dex */
public class AlaGameFrsLiveListAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;

    public AlaGameFrsLiveListAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public void bs(List<Fragment> list) {
        this.list = list;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.list.size() > i) {
            return this.list.get(i);
        }
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.list != null) {
            return this.list.size();
        }
        return 0;
    }
}
