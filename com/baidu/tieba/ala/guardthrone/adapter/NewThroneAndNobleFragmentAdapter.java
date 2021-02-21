package com.baidu.tieba.ala.guardthrone.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.live.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class NewThroneAndNobleFragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<BaseFragment> grG;

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.grG == null) {
            return null;
        }
        return this.grG.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.grG != null) {
            return this.grG.size();
        }
        return 0;
    }
}
