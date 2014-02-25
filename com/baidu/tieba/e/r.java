package com.baidu.tieba.e;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tieba.square.am;
/* loaded from: classes.dex */
public class r extends FragmentPagerAdapter {
    private final com.baidu.tieba.j[] a;
    private final int b;

    public r(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.a = new com.baidu.tieba.j[]{new am(), new a()};
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
