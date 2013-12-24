package com.baidu.tieba.forumfeed;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.t;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.square.SquareActivity;
/* loaded from: classes.dex */
public class HomePagerAdapter extends FragmentPagerAdapter {
    private final BaseFragment[] a;
    private final int b;

    public HomePagerAdapter(t tVar) {
        super(tVar);
        this.a = new BaseFragment[]{new SquareActivity(), new ForumFeedActivity()};
        this.b = this.a.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment a(int i) {
        if (i < 0 || i >= this.b) {
            return null;
        }
        return this.a[i];
    }

    @Override // android.support.v4.view.ae
    public int getCount() {
        return this.b;
    }
}
