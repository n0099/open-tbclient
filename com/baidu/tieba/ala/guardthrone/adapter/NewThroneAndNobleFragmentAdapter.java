package com.baidu.tieba.ala.guardthrone.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.live.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class NewThroneAndNobleFragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<BaseFragment> giT;

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.giT == null) {
            return null;
        }
        return this.giT.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.giT != null) {
            return this.giT.size();
        }
        return 0;
    }
}
