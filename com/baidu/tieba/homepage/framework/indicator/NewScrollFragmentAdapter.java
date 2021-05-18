package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.ConcernFragment;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.gamevideo.GameVideoFragment;
import com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment;
import com.baidu.tieba.homepage.personalize.PersonalizeFragment;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.homepage.video.VideoTabFragment;
import d.a.c.e.d.l;
import d.a.j0.b.d;
import d.a.j0.c1.b.c;
import d.a.j0.s.c.x;
import d.a.j0.z0.b0;
import d.a.j0.z0.f0;
import d.a.j0.z0.h0;
import d.a.k0.q0.o0;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {

    /* renamed from: f  reason: collision with root package name */
    public Context f16347f;

    /* renamed from: g  reason: collision with root package name */
    public ConcernFragment f16348g;

    /* renamed from: h  reason: collision with root package name */
    public PersonalizeFragment f16349h;

    /* renamed from: i  reason: collision with root package name */
    public HotTopicTabFragment f16350i;
    public BaseFragment j;
    public GameVideoFragment k;
    public VideoTabFragment l;
    public o0 m;
    public String n;
    public String o;
    public boolean p;
    public int q;
    public b0 r;
    public int s;
    public d.a.k0.a1.c.f.a t;
    public b u;
    public int v;
    public boolean w;
    public List<b> x;

    /* loaded from: classes4.dex */
    public class a extends f0<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f16351a;

        public a(int i2) {
            this.f16351a = i2;
        }

        @Override // d.a.j0.z0.f0
        public Object doInBackground() {
            l<String> h2 = d.a.j0.r.r.a.f().h(NewScrollFragmentAdapter.this.n, TbadkCoreApplication.getCurrentAccount());
            if (h2 != null) {
                h2.e(NewScrollFragmentAdapter.this.o, Integer.toString(this.f16351a), 43200000L);
                return null;
            }
            return null;
        }
    }

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, d.a.k0.a1.c.b bVar, ConcernPageView.l lVar) {
        super(fragmentManager);
        this.n = "recommendFrsLastReadTabPositionNamespace";
        this.o = "recommendFrsLastReadTabPositionKey";
        this.p = false;
        this.q = -1;
        this.s = -1;
        this.v = -1;
        this.w = false;
        this.x = new ArrayList();
        this.f16347f = context;
        if (this.t == null) {
            this.t = new d.a.k0.a1.c.f.a();
        }
        List<x> b2 = this.t.b();
        List<b> arrayList = new ArrayList<>();
        if (this.f16348g == null) {
            this.f16348g = new ConcernFragment(context);
            g(2);
        }
        this.f16348g.J0(lVar);
        if (d.h() && TbadkCoreApplication.isLogin() && d.a.j0.r.d0.b.j().k("key_home_concern_all_status", 0) == 1) {
            arrayList.add(u(this.f16348g, 0, r(R.string.attention_person)));
        } else {
            arrayList.add(u(this.f16348g, 0, r(R.string.tab_name_concern)));
        }
        if (this.f16349h == null) {
            this.f16349h = new PersonalizeFragment(context);
            g(1);
        }
        this.f16349h.K0(bVar);
        arrayList.add(u(this.f16349h, 1, r(R.string.tab_name_recommend)));
        for (x xVar : b2) {
            int i2 = xVar.f50468a;
            String str = xVar.f50469b;
            String str2 = xVar.f50470c;
            boolean z = xVar.f50472e;
            if (!xVar.a()) {
                if (i2 == 101) {
                    Fragment homePageTabFeedFragment = new HomePageTabFeedFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString(LowFlowsActivityConfig.TAB_CODE, str2);
                    bundle.putString("tab_name", str);
                    homePageTabFeedFragment.setArguments(bundle);
                    arrayList.add(w(homePageTabFeedFragment, xVar));
                } else if (i2 == 5) {
                    if (this.f16350i == null) {
                        g(3);
                        HotTopicTabFragment hotTopicTabFragment = new HotTopicTabFragment(context);
                        this.f16350i = hotTopicTabFragment;
                        arrayList.add(v(hotTopicTabFragment, i2, str, z));
                    }
                } else if (i2 == 8) {
                    if (this.l == null) {
                        this.l = new VideoTabFragment();
                        g(5);
                        arrayList.add(w(this.l, xVar));
                    }
                } else if (i2 == 6) {
                    if (this.j == null) {
                        g(4);
                        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class);
                        if (runTask != null && runTask.getData() != null) {
                            BaseFragment baseFragment = (BaseFragment) runTask.getData();
                            this.j = baseFragment;
                            b w = w(baseFragment, xVar);
                            this.u = w;
                            arrayList.add(w);
                        }
                    }
                } else if (i2 == 7 && this.k == null) {
                    GameVideoFragment gameVideoFragment = new GameVideoFragment();
                    this.k = gameVideoFragment;
                    arrayList.add(w(gameVideoFragment, xVar));
                    TiebaStatic.log(new StatisticItem("c13483").param("obj_type", "2"));
                }
            }
        }
        this.x.clear();
        f(arrayList);
    }

    public void A() {
        if (this.u == null || ListUtils.isEmpty(this.x)) {
            return;
        }
        int indexOf = this.x.indexOf(this.u);
        if (this.u == null || indexOf < 0) {
            return;
        }
        this.w = true;
        this.v = indexOf;
        this.x.remove(indexOf);
        notifyDataSetChanged();
        c(false, this.u.f16353a);
        this.w = false;
    }

    public void B() {
        b bVar = this.u;
        if (bVar == null || this.v < 0) {
            return;
        }
        this.w = true;
        if (this.x.indexOf(bVar) == -1) {
            this.x.add(this.v, this.u);
            notifyDataSetChanged();
        }
        c(true, this.u.f16353a);
        this.w = false;
    }

    public void F(int i2) {
        h0.b(new a(i2), null);
    }

    public void G(boolean z) {
        if (this.m instanceof BaseFragment) {
            if (!z) {
                int position = ListUtils.getPosition(b(), (BaseFragment) this.m);
                if (position < 0) {
                    position = m(1);
                }
                F(position);
                h();
            }
            ((BaseFragment) this.m).setPrimary(z);
        }
    }

    public void H(ScrollFragmentTabHost scrollFragmentTabHost) {
        PersonalizeFragment personalizeFragment = this.f16349h;
        if (personalizeFragment != null) {
            personalizeFragment.L0(scrollFragmentTabHost);
        }
        HotTopicTabFragment hotTopicTabFragment = this.f16350i;
        if (hotTopicTabFragment != null) {
            hotTopicTabFragment.K0(scrollFragmentTabHost);
        }
        ConcernFragment concernFragment = this.f16348g;
        if (concernFragment != null) {
            concernFragment.K0(scrollFragmentTabHost);
        }
    }

    public void I(int i2) {
        if (this.s == i2) {
            this.q = -1;
        } else {
            this.q = i2;
        }
    }

    public void J(String str) {
    }

    public void K() {
        PersonalizeFragment personalizeFragment = this.f16349h;
        if (personalizeFragment != null) {
            personalizeFragment.O0();
        }
    }

    public void L() {
        ConcernFragment concernFragment = this.f16348g;
        if (concernFragment != null) {
            concernFragment.L0();
        }
    }

    public void M(DataRes dataRes, boolean z) {
        ConcernFragment concernFragment = this.f16348g;
        if (concernFragment != null) {
            concernFragment.M0(dataRes, z);
        }
    }

    public void N(String str, int i2, int i3) {
        ConcernFragment concernFragment;
        PersonalizeFragment personalizeFragment;
        if (i3 == 1 && (personalizeFragment = this.f16349h) != null && this.m == personalizeFragment) {
            personalizeFragment.Q0(str, i2);
        }
        if (i3 != 0 || (concernFragment = this.f16348g) == null) {
            return;
        }
        concernFragment.N0(str, i2);
    }

    public void O(tbclient.Personalized.DataRes dataRes, boolean z, boolean z2) {
        PersonalizeFragment personalizeFragment = this.f16349h;
        if (personalizeFragment != null) {
            personalizeFragment.P0(dataRes, z, z2);
        }
    }

    public void P() {
        PersonalizeFragment personalizeFragment = this.f16349h;
        if (personalizeFragment != null) {
            personalizeFragment.I0();
        }
    }

    public void f(List<b> list) {
        if (this.x == null || list == null || list.size() <= 0) {
            return;
        }
        this.x.addAll(list);
        notifyDataSetChanged();
        if (c.d()) {
            A();
        }
    }

    public final void g(int i2) {
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LIVE_TAB_SHOW);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_type", i2);
        TiebaStaticHelper.addYYParam(statisticItem);
        TiebaStatic.log(statisticItem);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<b> list = this.x;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i2) {
        List<b> list = this.x;
        if (list == null || i2 < 0 || i2 >= list.size() || this.x.get(i2) == null) {
            return null;
        }
        return this.x.get(i2).f16353a;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return (this.w || b() == null || !b().contains(obj)) ? -2 : -1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        List<b> list = this.x;
        if (list == null || i2 < 0 || i2 >= list.size() || this.x.get(i2) == null) {
            return null;
        }
        return this.x.get(i2).f16354b;
    }

    public final void h() {
        PersonalizeFragment personalizeFragment = this.f16349h;
        if (personalizeFragment != null && this.m == personalizeFragment) {
            personalizeFragment.H0();
        }
        ConcernFragment concernFragment = this.f16348g;
        if (concernFragment == null || this.m != concernFragment) {
            return;
        }
        concernFragment.G0();
    }

    public void i() {
        Fragment item = getItem(this.s);
        if (item instanceof o0) {
            ((o0) item).p();
        }
    }

    public String j() {
        o0 o0Var = this.m;
        if (o0Var instanceof BaseFragment) {
            return ((BaseFragment) o0Var).getCurrentPageKey();
        }
        return null;
    }

    public int k() {
        return this.t.a();
    }

    public int l() {
        for (int i2 = 0; i2 < this.x.size(); i2++) {
            if (this.x.get(i2).f16356d == 5) {
                return i2;
            }
        }
        return -1;
    }

    @Deprecated
    public int m(int i2) {
        for (int i3 = 0; i3 < this.x.size(); i3++) {
            if (this.x.get(i3).f16356d == i2) {
                return i3;
            }
        }
        return q();
    }

    public int n(int i2) {
        b bVar = (b) ListUtils.getItem(this.x, i2);
        if (bVar != null) {
            return bVar.f16356d;
        }
        return 1;
    }

    public void o(d.a.k0.a1.c.d dVar) {
        if (this.p) {
            return;
        }
        this.p = true;
        dVar.a(1);
    }

    public void onPageScrolled(int i2, float f2, int i3) {
        int i4 = this.q;
        if (i4 == -1 || (i2 == i4 && f2 == 0.0f)) {
            Fragment fragment = (Fragment) ListUtils.getItem(b(), i2 - 1);
            Fragment fragment2 = (Fragment) ListUtils.getItem(b(), i2);
            Fragment fragment3 = (Fragment) ListUtils.getItem(b(), i2 + 1);
            this.q = -1;
            if (f2 == 0.0f) {
                if (fragment instanceof o0) {
                    ((o0) fragment).G();
                }
                if (fragment3 instanceof o0) {
                    ((o0) fragment3).G();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof o0) {
                ((o0) fragment).u();
            }
            if (fragment2 instanceof o0) {
                ((o0) fragment2).u();
            }
            if (fragment3 instanceof o0) {
                ((o0) fragment3).u();
            }
        }
    }

    public int p(String str) {
        for (int i2 = 0; i2 < this.x.size(); i2++) {
            b bVar = this.x.get(i2);
            if (!TextUtils.isEmpty(str) && str.equals(bVar.f16355c)) {
                return i2;
            }
        }
        return q();
    }

    public int q() {
        for (int i2 = 0; i2 < this.x.size(); i2++) {
            if (this.x.get(i2).f16356d == 1) {
                return i2;
            }
        }
        return 0;
    }

    public final String r(int i2) {
        return TbadkCoreApplication.getInst().getString(i2);
    }

    public boolean s() {
        return this.f16348g != null;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        super.setPrimaryItem(viewGroup, i2, obj);
        if (obj != null && this.s != i2) {
            o0 o0Var = this.m;
            if (o0Var instanceof BaseFragment) {
                ((BaseFragment) o0Var).setPrimary(false);
            }
            this.s = i2;
            VoiceManager a2 = d.a.k0.d3.p0.b.a(this.f16347f);
            if (a2 != null) {
                a2.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i2 == 0) {
                ((PersonalizeFragment) obj).t();
            }
            if (obj instanceof o0) {
                ((o0) obj).s();
            }
        }
        if (obj instanceof o0) {
            o0 o0Var2 = (o0) obj;
            this.m = o0Var2;
            o0Var2.y(this.r);
        }
    }

    public boolean t() {
        return this.f16350i != null;
    }

    public b u(Fragment fragment, int i2, String str) {
        return new b(fragment, i2, str);
    }

    public b v(Fragment fragment, int i2, String str, boolean z) {
        return new b(fragment, i2, str, z);
    }

    public b w(Fragment fragment, x xVar) {
        return new b(fragment, xVar.f50468a, xVar.f50469b);
    }

    public void x(int i2) {
        PersonalizeFragment personalizeFragment;
        if (i2 != 1 || (personalizeFragment = this.f16349h) == null) {
            return;
        }
        personalizeFragment.J0();
    }

    public void y(int i2) {
        o0 o0Var = this.m;
        if (o0Var != null) {
            o0Var.H();
        }
    }

    public void z() {
        o0 o0Var = this.m;
        if (o0Var != null) {
            o0Var.p();
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f16353a;

        /* renamed from: b  reason: collision with root package name */
        public String f16354b;

        /* renamed from: c  reason: collision with root package name */
        public String f16355c;

        /* renamed from: d  reason: collision with root package name */
        public int f16356d;

        public b(Fragment fragment, int i2, String str) {
            this.f16353a = fragment;
            this.f16356d = i2;
            this.f16354b = str;
            this.f16355c = str;
        }

        public b(Fragment fragment, int i2, String str, boolean z) {
            this.f16353a = fragment;
            this.f16356d = i2;
            this.f16354b = str;
            this.f16355c = str;
        }
    }
}
