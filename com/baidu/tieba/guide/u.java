package com.baidu.tieba.guide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
/* loaded from: classes.dex */
public class u extends FragmentPagerAdapter {
    private final com.baidu.tbadk.core.d[] a;
    private final int b;

    public u(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.a = new com.baidu.tbadk.core.d[]{new m(), new p()};
        this.b = this.a.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i < 0 || i >= this.b) {
            return null;
        }
        return this.a[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.b;
    }
}
