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
public class EnterForumTabPagerAdapter extends FragmentPagerAdapter implements d.b.i0.b1.n.a {

    /* renamed from: e  reason: collision with root package name */
    public List<a> f15084e;

    /* renamed from: f  reason: collision with root package name */
    public int f15085f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragment f15086g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15087h;
    public FragmentManager i;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f15088a;

        /* renamed from: b  reason: collision with root package name */
        public String f15089b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f15090c;

        /* renamed from: d  reason: collision with root package name */
        public String f15091d;
    }

    public EnterForumTabPagerAdapter(FragmentManager fragmentManager, List<a> list) {
        super(fragmentManager);
        this.f15085f = -1;
        this.i = fragmentManager;
        this.f15084e = list;
    }

    public String e() {
        BaseFragment baseFragment = this.f15086g;
        if (baseFragment instanceof BaseFragment) {
            return baseFragment.getCurrentPageKey();
        }
        return null;
    }

    public void f(boolean z) {
        this.f15087h = z;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<a> list = this.f15084e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        List<a> list = this.f15084e;
        if (list == null || i < 0 || i >= list.size() || this.f15084e.get(i) == null) {
            return null;
        }
        return this.f15084e.get(i).f15088a;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public long getItemId(int i) {
        List<a> list = this.f15084e;
        if (list != null && i >= 0 && i < list.size() && this.f15084e.get(i) != null) {
            return this.f15084e.get(i).hashCode();
        }
        return super.getItemId(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return this.i.getFragments().contains(obj) ? -1 : -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        List<a> list = this.f15084e;
        if (list == null || i < 0 || i >= list.size() || this.f15084e.get(i) == null) {
            return null;
        }
        return this.f15084e.get(i).f15089b;
    }

    @Override // d.b.i0.b1.n.a
    public boolean h(int i) {
        List<a> list = this.f15084e;
        if (list == null || i < 0 || i >= list.size() || this.f15084e.get(i) == null || !(this.f15084e.get(i).f15088a instanceof EnterForumTabFeedFragment)) {
            return false;
        }
        return this.f15084e.get(i).f15090c;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        int i2;
        super.setPrimaryItem(viewGroup, i, obj);
        if (!this.f15087h || (i2 = this.f15085f) == i) {
            return;
        }
        if (i2 != -1) {
            ((BaseFragment) getItem(i2)).setPrimary(false);
        }
        this.f15085f = i;
        if (obj instanceof BaseFragment) {
            BaseFragment baseFragment = (BaseFragment) obj;
            baseFragment.setPrimary(true);
            this.f15086g = baseFragment;
        }
    }
}
