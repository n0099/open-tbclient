package com.baidu.tieba.enterForum.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.enterForum.recommend.RecommendFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class EnterForumTabPagerAdapter extends FragmentPagerAdapter {
    private BaseFragment eDn;
    private boolean isPrimary;
    private List<a> mFragments;
    private int mPrimaryPosition;

    /* loaded from: classes4.dex */
    public static class a {
        public Fragment fragment;
        public String title;
    }

    public EnterForumTabPagerAdapter(FragmentManager fragmentManager, List<a> list) {
        super(fragmentManager);
        this.mPrimaryPosition = -1;
        this.mFragments = new ArrayList();
        if (list != null && list.size() > 0) {
            this.mFragments.addAll(list);
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.mFragments == null || i < 0 || i >= this.mFragments.size() || this.mFragments.get(i) == null) {
            return null;
        }
        return this.mFragments.get(i).fragment;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public long getItemId(int i) {
        return (this.mFragments == null || i < 0 || i >= this.mFragments.size() || this.mFragments.get(i) == null) ? super.getItemId(i) : this.mFragments.get(i).hashCode();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.mFragments != null) {
            return this.mFragments.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (this.mFragments == null || i < 0 || i >= this.mFragments.size() || this.mFragments.get(i) == null) {
            return null;
        }
        return this.mFragments.get(i).title;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.isPrimary && this.mPrimaryPosition != i) {
            if (this.mPrimaryPosition != -1) {
                ((BaseFragment) getItem(this.mPrimaryPosition)).setPrimary(false);
            }
            this.mPrimaryPosition = i;
            if (obj instanceof BaseFragment) {
                BaseFragment baseFragment = (BaseFragment) obj;
                baseFragment.setPrimary(true);
                this.eDn = baseFragment;
            }
        }
    }

    public int aWI() {
        if (this.eDn instanceof EnterForumFragment) {
            return 1;
        }
        if (this.eDn instanceof RecommendFragment) {
            return 2;
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
    }
}
