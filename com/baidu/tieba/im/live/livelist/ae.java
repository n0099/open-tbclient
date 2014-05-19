package com.baidu.tieba.im.live.livelist;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
/* loaded from: classes.dex */
class ae extends FragmentPagerAdapter {
    private Fragment[] a;
    private int b;

    public ae(FragmentManager fragmentManager, Fragment[] fragmentArr) {
        super(fragmentManager);
        this.b = -1;
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

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.b != i) {
            if (this.b != -1) {
                ((com.baidu.tbadk.core.d) getItem(this.b)).b(false);
            }
            this.b = i;
            ((com.baidu.tbadk.core.d) obj).b(true);
        }
        super.setPrimaryItem(viewGroup, i, obj);
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
    }
}
