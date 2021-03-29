package com.baidu.tieba.enterForum.home;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import java.util.List;
/* loaded from: classes4.dex */
public class EnterForumTabPagerAdapter extends FragmentPagerAdapter implements d.b.h0.b1.n.a {

    /* renamed from: e  reason: collision with root package name */
    public List<a> f15413e;

    /* renamed from: f  reason: collision with root package name */
    public int f15414f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragment f15415g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15416h;
    public FragmentManager i;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f15417a;

        /* renamed from: b  reason: collision with root package name */
        public String f15418b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f15419c;

        /* renamed from: d  reason: collision with root package name */
        public String f15420d;
    }

    public EnterForumTabPagerAdapter(FragmentManager fragmentManager, List<a> list) {
        super(fragmentManager);
        this.f15414f = -1;
        this.i = fragmentManager;
        this.f15413e = list;
    }

    public String e() {
        BaseFragment baseFragment = this.f15415g;
        if (baseFragment instanceof BaseFragment) {
            return baseFragment.getCurrentPageKey();
        }
        return null;
    }

    public void f(boolean z) {
        this.f15416h = z;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<a> list = this.f15413e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        List<a> list = this.f15413e;
        if (list == null || i < 0 || i >= list.size() || this.f15413e.get(i) == null) {
            return null;
        }
        return this.f15413e.get(i).f15417a;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public long getItemId(int i) {
        List<a> list = this.f15413e;
        if (list != null && i >= 0 && i < list.size() && this.f15413e.get(i) != null) {
            return this.f15413e.get(i).hashCode();
        }
        return super.getItemId(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return this.i.getFragments().contains(obj) ? -1 : -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        List<a> list = this.f15413e;
        if (list == null || i < 0 || i >= list.size() || this.f15413e.get(i) == null) {
            return null;
        }
        return this.f15413e.get(i).f15418b;
    }

    @Override // d.b.h0.b1.n.a
    public boolean h(int i) {
        List<a> list = this.f15413e;
        if (list == null || i < 0 || i >= list.size() || this.f15413e.get(i) == null || !(this.f15413e.get(i).f15417a instanceof EnterForumTabFeedFragment)) {
            return false;
        }
        return this.f15413e.get(i).f15419c;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        int i2;
        super.setPrimaryItem(viewGroup, i, obj);
        if (!this.f15416h || (i2 = this.f15414f) == i) {
            return;
        }
        if (i2 != -1) {
            ((BaseFragment) getItem(i2)).setPrimary(false);
        }
        this.f15414f = i;
        if (obj instanceof BaseFragment) {
            BaseFragment baseFragment = (BaseFragment) obj;
            baseFragment.setPrimary(true);
            this.f15415g = baseFragment;
        }
    }
}
