package com.baidu.tieba.guide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes.dex */
public class q extends FragmentPagerAdapter {
    private final BaseFragment[] aLG;
    private final int mq;

    public q(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.aLG = new BaseFragment[]{new j(), new m()};
        this.mq = this.aLG.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i < 0 || i >= this.mq) {
            return null;
        }
        return this.aLG[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mq;
    }
}
