package com.baidu.tieba.enterForum.home;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import java.util.List;
/* loaded from: classes2.dex */
public class EnterForumTabPagerAdapter extends FragmentPagerAdapter implements com.baidu.tbadk.widget.tab.a {
    private BaseFragment iDC;
    private boolean isPrimary;
    private FragmentManager mFragmentManager;
    private List<a> mFragments;
    private int mPrimaryPosition;

    /* loaded from: classes2.dex */
    public static class a {
        public Fragment fragment;
        public boolean iDD;
        public String tabName;
        public String title;
    }

    public EnterForumTabPagerAdapter(FragmentManager fragmentManager, List<a> list) {
        super(fragmentManager);
        this.mPrimaryPosition = -1;
        this.mFragmentManager = fragmentManager;
        this.mFragments = list;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.mFragments == null || i < 0 || i >= this.mFragments.size() || this.mFragments.get(i) == null) {
            return null;
        }
        return this.mFragments.get(i).fragment;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public long getItemId(int i) {
        return (this.mFragments == null || i < 0 || i >= this.mFragments.size() || this.mFragments.get(i) == null) ? super.getItemId(i) : this.mFragments.get(i).hashCode();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.mFragments != null) {
            return this.mFragments.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return this.mFragmentManager.getFragments().contains(obj) ? -1 : -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (this.mFragments == null || i < 0 || i >= this.mFragments.size() || this.mFragments.get(i) == null) {
            return null;
        }
        return this.mFragments.get(i).title;
    }

    @Override // com.baidu.tbadk.widget.tab.a
    public boolean sk(int i) {
        if (this.mFragments == null || i < 0 || i >= this.mFragments.size() || this.mFragments.get(i) == null || !(this.mFragments.get(i).fragment instanceof EnterForumTabFeedFragment)) {
            return false;
        }
        return this.mFragments.get(i).iDD;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
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
                this.iDC = baseFragment;
            }
        }
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
    }

    public String getCurrentPageKey() {
        if (this.iDC instanceof BaseFragment) {
            return this.iDC.getCurrentPageKey();
        }
        return null;
    }
}
