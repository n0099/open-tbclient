package com.baidu.tieba.forumfeed;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.t;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.square.SquareActivity;
/* loaded from: classes.dex */
public class HomePagerAdapter extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final BaseFragment[] f1340a;
    private final int b;

    public HomePagerAdapter(t tVar) {
        super(tVar);
        this.f1340a = new BaseFragment[]{new SquareActivity(), new ForumFeedActivity()};
        this.b = this.f1340a.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment a(int i) {
        if (i < 0 || i >= this.b) {
            return null;
        }
        return this.f1340a[i];
    }

    @Override // android.support.v4.view.ae
    public int getCount() {
        return this.b;
    }
}
