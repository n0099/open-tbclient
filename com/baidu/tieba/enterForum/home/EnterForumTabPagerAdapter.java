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
public class EnterForumTabPagerAdapter extends FragmentPagerAdapter implements d.a.i0.b1.n.a {

    /* renamed from: e  reason: collision with root package name */
    public List<a> f15207e;

    /* renamed from: f  reason: collision with root package name */
    public int f15208f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragment f15209g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15210h;

    /* renamed from: i  reason: collision with root package name */
    public FragmentManager f15211i;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f15212a;

        /* renamed from: b  reason: collision with root package name */
        public String f15213b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f15214c;

        /* renamed from: d  reason: collision with root package name */
        public String f15215d;
    }

    public EnterForumTabPagerAdapter(FragmentManager fragmentManager, List<a> list) {
        super(fragmentManager);
        this.f15208f = -1;
        this.f15211i = fragmentManager;
        this.f15207e = list;
    }

    @Override // d.a.i0.b1.n.a
    public boolean a(int i2) {
        List<a> list = this.f15207e;
        if (list == null || i2 < 0 || i2 >= list.size() || this.f15207e.get(i2) == null || !(this.f15207e.get(i2).f15212a instanceof EnterForumTabFeedFragment)) {
            return false;
        }
        return this.f15207e.get(i2).f15214c;
    }

    public String b() {
        BaseFragment baseFragment = this.f15209g;
        if (baseFragment instanceof BaseFragment) {
            return baseFragment.getCurrentPageKey();
        }
        return null;
    }

    public void c(boolean z) {
        this.f15210h = z;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<a> list = this.f15207e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        List<a> list = this.f15207e;
        if (list == null || i2 < 0 || i2 >= list.size() || this.f15207e.get(i2) == null) {
            return null;
        }
        return this.f15207e.get(i2).f15212a;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public long getItemId(int i2) {
        List<a> list = this.f15207e;
        if (list != null && i2 >= 0 && i2 < list.size() && this.f15207e.get(i2) != null) {
            return this.f15207e.get(i2).hashCode();
        }
        return super.getItemId(i2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return this.f15211i.getFragments().contains(obj) ? -1 : -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        List<a> list = this.f15207e;
        if (list == null || i2 < 0 || i2 >= list.size() || this.f15207e.get(i2) == null) {
            return null;
        }
        return this.f15207e.get(i2).f15213b;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        int i3;
        super.setPrimaryItem(viewGroup, i2, obj);
        if (!this.f15210h || (i3 = this.f15208f) == i2) {
            return;
        }
        if (i3 != -1) {
            ((BaseFragment) getItem(i3)).setPrimary(false);
        }
        this.f15208f = i2;
        if (obj instanceof BaseFragment) {
            BaseFragment baseFragment = (BaseFragment) obj;
            baseFragment.setPrimary(true);
            this.f15209g = baseFragment;
        }
    }
}
