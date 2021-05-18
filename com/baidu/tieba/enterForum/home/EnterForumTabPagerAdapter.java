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
public class EnterForumTabPagerAdapter extends FragmentPagerAdapter implements d.a.j0.b1.n.a {

    /* renamed from: e  reason: collision with root package name */
    public List<a> f14522e;

    /* renamed from: f  reason: collision with root package name */
    public int f14523f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragment f14524g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14525h;

    /* renamed from: i  reason: collision with root package name */
    public FragmentManager f14526i;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f14527a;

        /* renamed from: b  reason: collision with root package name */
        public String f14528b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f14529c;

        /* renamed from: d  reason: collision with root package name */
        public String f14530d;
    }

    public EnterForumTabPagerAdapter(FragmentManager fragmentManager, List<a> list) {
        super(fragmentManager);
        this.f14523f = -1;
        this.f14526i = fragmentManager;
        this.f14522e = list;
    }

    @Override // d.a.j0.b1.n.a
    public boolean a(int i2) {
        List<a> list = this.f14522e;
        if (list == null || i2 < 0 || i2 >= list.size() || this.f14522e.get(i2) == null || !(this.f14522e.get(i2).f14527a instanceof EnterForumTabFeedFragment)) {
            return false;
        }
        return this.f14522e.get(i2).f14529c;
    }

    public String b() {
        BaseFragment baseFragment = this.f14524g;
        if (baseFragment instanceof BaseFragment) {
            return baseFragment.getCurrentPageKey();
        }
        return null;
    }

    public void c(boolean z) {
        this.f14525h = z;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<a> list = this.f14522e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        List<a> list = this.f14522e;
        if (list == null || i2 < 0 || i2 >= list.size() || this.f14522e.get(i2) == null) {
            return null;
        }
        return this.f14522e.get(i2).f14527a;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public long getItemId(int i2) {
        List<a> list = this.f14522e;
        if (list != null && i2 >= 0 && i2 < list.size() && this.f14522e.get(i2) != null) {
            return this.f14522e.get(i2).hashCode();
        }
        return super.getItemId(i2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return this.f14526i.getFragments().contains(obj) ? -1 : -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        List<a> list = this.f14522e;
        if (list == null || i2 < 0 || i2 >= list.size() || this.f14522e.get(i2) == null) {
            return null;
        }
        return this.f14522e.get(i2).f14528b;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        int i3;
        super.setPrimaryItem(viewGroup, i2, obj);
        if (!this.f14525h || (i3 = this.f14523f) == i2) {
            return;
        }
        if (i3 != -1) {
            ((BaseFragment) getItem(i3)).setPrimary(false);
        }
        this.f14523f = i2;
        if (obj instanceof BaseFragment) {
            BaseFragment baseFragment = (BaseFragment) obj;
            baseFragment.setPrimary(true);
            this.f14524g = baseFragment;
        }
    }
}
