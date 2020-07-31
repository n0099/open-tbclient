package com.baidu.tieba.ala.guardthrone.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.live.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class NewThroneAndNobleFragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<BaseFragment> flY;

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.flY == null) {
            return null;
        }
        return this.flY.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.flY != null) {
            return this.flY.size();
        }
        return 0;
    }
}
