package com.baidu.tieba.ala.guardthrone.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.live.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class NewThroneAndNobleFragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<BaseFragment> eWE;

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.eWE == null) {
            return null;
        }
        return this.eWE.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.eWE != null) {
            return this.eWE.size();
        }
        return 0;
    }
}
