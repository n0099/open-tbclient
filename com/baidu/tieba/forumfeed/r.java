package com.baidu.tieba.forumfeed;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tieba.square.ak;
/* loaded from: classes.dex */
public final class r extends FragmentPagerAdapter {
    private final com.baidu.tbadk.core.d[] a;
    private final int b;

    public r(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.a = new com.baidu.tbadk.core.d[]{new ak(), new a()};
        this.b = this.a.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public final Fragment getItem(int i) {
        if (i < 0 || i >= this.b) {
            return null;
        }
        return this.a[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public final int getCount() {
        return this.b;
    }
}
