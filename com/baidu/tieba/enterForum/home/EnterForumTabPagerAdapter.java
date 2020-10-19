package com.baidu.tieba.enterForum.home;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import java.util.List;
/* loaded from: classes22.dex */
public class EnterForumTabPagerAdapter extends FragmentPagerAdapter implements com.baidu.tbadk.widget.tab.a {
    private BaseFragment hRP;
    private boolean isPrimary;
    private FragmentManager mFragmentManager;
    private List<a> mFragments;
    private int mPrimaryPosition;

    /* loaded from: classes22.dex */
    public static class a {
        public boolean bdb;
        public Fragment fragment;
        public String tabName;
        public String title;
    }

    public EnterForumTabPagerAdapter(FragmentManager fragmentManager, List<a> list) {
        super(fragmentManager);
        this.mPrimaryPosition = -1;
        this.mFragmentManager = fragmentManager;
        this.mFragments = list;
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
    public int getItemPosition(@NonNull Object obj) {
        return this.mFragmentManager.getFragments().contains(obj) ? -1 : -2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (this.mFragments == null || i < 0 || i >= this.mFragments.size() || this.mFragments.get(i) == null) {
            return null;
        }
        return this.mFragments.get(i).title;
    }

    @Override // com.baidu.tbadk.widget.tab.a
    public boolean sj(int i) {
        if (this.mFragments == null || i < 0 || i >= this.mFragments.size() || this.mFragments.get(i) == null || !(this.mFragments.get(i).fragment instanceof EnterForumTabFeedFragment)) {
            return false;
        }
        return this.mFragments.get(i).bdb;
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
                this.hRP = baseFragment;
            }
        }
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
    }

    public String getCurrentPageKey() {
        if (this.hRP instanceof BaseFragment) {
            return this.hRP.getCurrentPageKey();
        }
        return null;
    }
}
