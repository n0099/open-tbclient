package com.baidu.tieba.guide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
/* loaded from: classes.dex */
public class r extends FragmentPagerAdapter {
    private final com.baidu.tieba.j[] a;
    private final int b;

    public r(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.a = new com.baidu.tieba.j[]{new l(), new o()};
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
