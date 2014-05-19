package com.baidu.tieba.im.live.mylive;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
/* loaded from: classes.dex */
class l extends FragmentPagerAdapter {
    private Fragment[] a;

    public l(FragmentManager fragmentManager, Fragment[] fragmentArr) {
        super(fragmentManager);
        this.a = fragmentArr;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.a.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.a[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        return super.getItemPosition(obj);
    }
}
