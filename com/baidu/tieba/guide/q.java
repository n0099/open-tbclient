package com.baidu.tieba.guide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes.dex */
public class q extends FragmentPagerAdapter {
    private final BaseFragment[] aNM;
    private final int mCount;

    public q(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.aNM = new BaseFragment[]{new j(), new m()};
        this.mCount = this.aNM.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i < 0 || i >= this.mCount) {
            return null;
        }
        return this.aNM[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mCount;
    }
}
