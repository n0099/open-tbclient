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
import com.baidu.tieba.homepage.tabfeed.h5.TabWebFragment;
import com.baidu.tieba.homepage.video.VideoTabFragment;
import d.a.c.e.d.l;
import d.a.n0.b.d;
import d.a.n0.c1.b.e;
import d.a.n0.s.c.y;
import d.a.n0.z0.b0;
import d.a.n0.z0.f0;
import d.a.n0.z0.h0;
import d.a.o0.r0.o0;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {

    /* renamed from: f  reason: collision with root package name */
    public Context f16400f;

    /* renamed from: g  reason: collision with root package name */
    public ConcernFragment f16401g;

    /* renamed from: h  reason: collision with root package name */
    public PersonalizeFragment f16402h;

    /* renamed from: i  reason: collision with root package name */
    public HotTopicTabFragment f16403i;
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
    public d.a.o0.b1.d.f.a t;
    public List<b> u;
    public List<b> v;

    /* loaded from: classes4.dex */
    public class a extends f0<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f16404a;

        public a(int i2) {
            this.f16404a = i2;
        }

        @Override // d.a.n0.z0.f0
        public Object doInBackground() {
            l<String> h2 = d.a.n0.r.r.a.f().h(NewScrollFragmentAdapter.this.n, TbadkCoreApplication.getCurrentAccount());
            if (h2 != null) {
                h2.e(NewScrollFragmentAdapter.this.o, Integer.toString(this.f16404a), 43200000L);
                return null;
            }
            return null;
        }
    }

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, d.a.o0.b1.d.b bVar, ConcernPageView.l lVar) {
        super(fragmentManager);
        this.n = "recommendFrsLastReadTabPositionNamespace";
        this.o = "recommendFrsLastReadTabPositionKey";
        this.p = false;
        this.q = -1;
        this.s = -1;
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.f16400f = context;
        if (this.t == null) {
            this.t = new d.a.o0.b1.d.f.a();
        }
        List<y> b2 = this.t.b();
        this.v.clear();
        if (this.f16401g == null) {
            this.f16401g = new ConcernFragment(context);
            i(2);
        }
        this.f16401g.M0(lVar);
        if (d.h() && TbadkCoreApplication.isLogin() && d.a.n0.r.d0.b.j().k("key_home_concern_all_status", 0) == 1) {
            this.v.add(w(this.f16401g, 0, t(R.string.attention_person)));
        } else {
            this.v.add(w(this.f16401g, 0, t(R.string.tab_name_concern)));
        }
        if (this.f16402h == null) {
            this.f16402h = new PersonalizeFragment(context);
            i(1);
        }
        this.f16402h.N0(bVar);
        this.v.add(w(this.f16402h, 1, t(R.string.tab_name_recommend)));
        for (y yVar : b2) {
            int i2 = yVar.f54327a;
            String str = yVar.f54328b;
            String str2 = yVar.f54329c;
            boolean z = yVar.f54332f;
            if (!yVar.a()) {
                if (i2 == 101 || i2 == 201) {
                    Fragment homePageTabFeedFragment = new HomePageTabFeedFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString(LowFlowsActivityConfig.TAB_CODE, str2);
                    bundle.putString("tab_name", str);
                    bundle.putInt("tab_type", i2);
                    homePageTabFeedFragment.setArguments(bundle);
                    this.v.add(y(homePageTabFeedFragment, yVar));
                } else if (i2 == 5) {
                    if (this.f16403i == null) {
                        i(3);
                        HotTopicTabFragment hotTopicTabFragment = new HotTopicTabFragment(context);
                        this.f16403i = hotTopicTabFragment;
                        this.v.add(x(hotTopicTabFragment, i2, str, z));
                    }
                } else if (i2 == 8) {
                    if (this.l == null) {
                        this.l = new VideoTabFragment();
                        i(5);
                        this.v.add(y(this.l, yVar));
                    }
                } else if (i2 == 6) {
                    if (this.j == null) {
                        i(4);
                        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class);
                        if (runTask != null && runTask.getData() != null) {
                            BaseFragment baseFragment = (BaseFragment) runTask.getData();
                            this.j = baseFragment;
                            this.v.add(y(baseFragment, yVar));
                        }
                    }
                } else if (i2 == 7) {
                    if (this.k == null) {
                        GameVideoFragment gameVideoFragment = new GameVideoFragment();
                        this.k = gameVideoFragment;
                        this.v.add(y(gameVideoFragment, yVar));
                        TiebaStatic.log(new StatisticItem("c13483").param("obj_type", "2"));
                    }
                } else if (i2 == 202 && !TextUtils.isEmpty(yVar.f54330d)) {
                    Fragment tabWebFragment = new TabWebFragment();
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(LowFlowsActivityConfig.TAB_CODE, str2);
                    bundle2.putString("tab_name", str);
                    bundle2.putString("tab_url", yVar.f54330d);
                    bundle2.putInt("tab_type", i2);
                    tabWebFragment.setArguments(bundle2);
                    this.v.add(y(tabWebFragment, yVar));
                }
            }
        }
        O();
        notifyDataSetChanged();
    }

    public void A(int i2) {
        o0 o0Var = this.m;
        if (o0Var != null) {
            o0Var.I();
        }
    }

    public void B() {
        o0 o0Var = this.m;
        if (o0Var != null) {
            o0Var.r();
        }
    }

    public void F(int i2) {
        h0.b(new a(i2), null);
    }

    public void G(boolean z) {
        if (this.m instanceof BaseFragment) {
            if (!z) {
                int position = ListUtils.getPosition(e(), (BaseFragment) this.m);
                if (position < 0) {
                    position = o(1);
                }
                F(position);
                j();
            }
            ((BaseFragment) this.m).setPrimary(z);
        }
    }

    public void H(ScrollFragmentTabHost scrollFragmentTabHost) {
        PersonalizeFragment personalizeFragment = this.f16402h;
        if (personalizeFragment != null) {
            personalizeFragment.O0(scrollFragmentTabHost);
        }
        HotTopicTabFragment hotTopicTabFragment = this.f16403i;
        if (hotTopicTabFragment != null) {
            hotTopicTabFragment.N0(scrollFragmentTabHost);
        }
        ConcernFragment concernFragment = this.f16401g;
        if (concernFragment != null) {
            concernFragment.N0(scrollFragmentTabHost);
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
        PersonalizeFragment personalizeFragment = this.f16402h;
        if (personalizeFragment != null) {
            personalizeFragment.R0();
        }
    }

    public void L() {
        ConcernFragment concernFragment = this.f16401g;
        if (concernFragment != null) {
            concernFragment.O0();
        }
    }

    public void M(DataRes dataRes, boolean z) {
        ConcernFragment concernFragment = this.f16401g;
        if (concernFragment != null) {
            concernFragment.P0(dataRes, z);
        }
    }

    public void N(String str, int i2, int i3) {
        ConcernFragment concernFragment;
        PersonalizeFragment personalizeFragment;
        if (i3 == 1 && (personalizeFragment = this.f16402h) != null && this.m == personalizeFragment) {
            personalizeFragment.T0(str, i2);
        }
        if (i3 != 0 || (concernFragment = this.f16401g) == null) {
            return;
        }
        concernFragment.Q0(str, i2);
    }

    public void O() {
        Fragment fragment;
        this.u.clear();
        boolean d2 = e.d();
        for (b bVar : this.v) {
            if (!d2 || ((fragment = bVar.f16406a) != this.f16403i && fragment != this.j && fragment != this.k && fragment != this.l)) {
                this.u.add(bVar);
            }
        }
    }

    public void P(tbclient.Personalized.DataRes dataRes, boolean z, boolean z2) {
        PersonalizeFragment personalizeFragment = this.f16402h;
        if (personalizeFragment != null) {
            personalizeFragment.S0(dataRes, z, z2);
        }
    }

    public void Q() {
        PersonalizeFragment personalizeFragment = this.f16402h;
        if (personalizeFragment != null) {
            personalizeFragment.L0();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<b> list = this.u;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i2) {
        List<b> list = this.u;
        if (list == null || i2 < 0 || i2 >= list.size() || this.u.get(i2) == null) {
            return null;
        }
        return this.u.get(i2).f16406a;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return (e() == null || !e().contains(obj)) ? -2 : -1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        List<b> list = this.u;
        if (list == null || i2 < 0 || i2 >= list.size() || this.u.get(i2) == null) {
            return null;
        }
        return this.u.get(i2).f16407b;
    }

    public final void i(int i2) {
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LIVE_TAB_SHOW);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_type", i2);
        TiebaStaticHelper.addYYParam(statisticItem);
        TiebaStatic.log(statisticItem);
    }

    public final void j() {
        PersonalizeFragment personalizeFragment = this.f16402h;
        if (personalizeFragment != null && this.m == personalizeFragment) {
            personalizeFragment.K0();
        }
        ConcernFragment concernFragment = this.f16401g;
        if (concernFragment == null || this.m != concernFragment) {
            return;
        }
        concernFragment.J0();
    }

    public void k() {
        Fragment item = getItem(this.s);
        if (item instanceof o0) {
            ((o0) item).r();
        }
    }

    public String l() {
        o0 o0Var = this.m;
        if (o0Var instanceof BaseFragment) {
            return ((BaseFragment) o0Var).getCurrentPageKey();
        }
        return null;
    }

    public int m() {
        return this.t.a();
    }

    public int n() {
        for (int i2 = 0; i2 < this.u.size(); i2++) {
            if (this.u.get(i2).f16409d == 5) {
                return i2;
            }
        }
        return -1;
    }

    @Deprecated
    public int o(int i2) {
        for (int i3 = 0; i3 < this.u.size(); i3++) {
            if (this.u.get(i3).f16409d == i2) {
                return i3;
            }
        }
        return s();
    }

    public void onPageScrolled(int i2, float f2, int i3) {
        int i4 = this.q;
        if (i4 == -1 || (i2 == i4 && f2 == 0.0f)) {
            Fragment fragment = (Fragment) ListUtils.getItem(e(), i2 - 1);
            Fragment fragment2 = (Fragment) ListUtils.getItem(e(), i2);
            Fragment fragment3 = (Fragment) ListUtils.getItem(e(), i2 + 1);
            this.q = -1;
            if (f2 == 0.0f) {
                if (fragment instanceof o0) {
                    ((o0) fragment).H();
                }
                if (fragment3 instanceof o0) {
                    ((o0) fragment3).H();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof o0) {
                ((o0) fragment).v();
            }
            if (fragment2 instanceof o0) {
                ((o0) fragment2).v();
            }
            if (fragment3 instanceof o0) {
                ((o0) fragment3).v();
            }
        }
    }

    public int p(int i2) {
        b bVar = (b) ListUtils.getItem(this.u, i2);
        if (bVar != null) {
            return bVar.f16409d;
        }
        return 1;
    }

    public void q(d.a.o0.b1.d.d dVar) {
        if (this.p) {
            return;
        }
        this.p = true;
        dVar.a(1);
    }

    public int r(String str) {
        for (int i2 = 0; i2 < this.u.size(); i2++) {
            b bVar = this.u.get(i2);
            if (!TextUtils.isEmpty(str) && str.equals(bVar.f16408c)) {
                return i2;
            }
        }
        return s();
    }

    public int s() {
        for (int i2 = 0; i2 < this.u.size(); i2++) {
            if (this.u.get(i2).f16409d == 1) {
                return i2;
            }
        }
        return 0;
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
            VoiceManager a2 = d.a.o0.e3.p0.b.a(this.f16400f);
            if (a2 != null) {
                a2.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i2 == 0) {
                ((PersonalizeFragment) obj).u();
            }
            if (obj instanceof o0) {
                ((o0) obj).t();
            }
        }
        if (obj instanceof o0) {
            o0 o0Var2 = (o0) obj;
            this.m = o0Var2;
            o0Var2.z(this.r);
        }
    }

    public final String t(int i2) {
        return TbadkCoreApplication.getInst().getString(i2);
    }

    public boolean u() {
        return this.f16401g != null;
    }

    public boolean v() {
        return this.f16403i != null;
    }

    public b w(Fragment fragment, int i2, String str) {
        return new b(fragment, i2, str);
    }

    public b x(Fragment fragment, int i2, String str, boolean z) {
        return new b(fragment, i2, str, z);
    }

    public b y(Fragment fragment, y yVar) {
        return new b(fragment, yVar.f54327a, yVar.f54328b);
    }

    public void z(int i2) {
        PersonalizeFragment personalizeFragment;
        if (i2 != 1 || (personalizeFragment = this.f16402h) == null) {
            return;
        }
        personalizeFragment.M0();
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f16406a;

        /* renamed from: b  reason: collision with root package name */
        public String f16407b;

        /* renamed from: c  reason: collision with root package name */
        public String f16408c;

        /* renamed from: d  reason: collision with root package name */
        public int f16409d;

        public b(Fragment fragment, int i2, String str) {
            this.f16406a = fragment;
            this.f16409d = i2;
            this.f16407b = str;
            this.f16408c = str;
        }

        public b(Fragment fragment, int i2, String str, boolean z) {
            this.f16406a = fragment;
            this.f16409d = i2;
            this.f16407b = str;
            this.f16408c = str;
        }
    }
}
