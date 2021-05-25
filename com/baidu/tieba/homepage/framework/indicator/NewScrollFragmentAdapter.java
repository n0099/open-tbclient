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
import d.a.m0.b.d;
import d.a.m0.c1.b.e;
import d.a.m0.s.c.y;
import d.a.m0.z0.b0;
import d.a.m0.z0.f0;
import d.a.m0.z0.h0;
import d.a.n0.r0.o0;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {

    /* renamed from: f  reason: collision with root package name */
    public Context f16250f;

    /* renamed from: g  reason: collision with root package name */
    public ConcernFragment f16251g;

    /* renamed from: h  reason: collision with root package name */
    public PersonalizeFragment f16252h;

    /* renamed from: i  reason: collision with root package name */
    public HotTopicTabFragment f16253i;
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
    public d.a.n0.b1.c.f.a t;
    public List<b> u;
    public List<b> v;

    /* loaded from: classes4.dex */
    public class a extends f0<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f16254a;

        public a(int i2) {
            this.f16254a = i2;
        }

        @Override // d.a.m0.z0.f0
        public Object doInBackground() {
            l<String> h2 = d.a.m0.r.r.a.f().h(NewScrollFragmentAdapter.this.n, TbadkCoreApplication.getCurrentAccount());
            if (h2 != null) {
                h2.e(NewScrollFragmentAdapter.this.o, Integer.toString(this.f16254a), 43200000L);
                return null;
            }
            return null;
        }
    }

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, d.a.n0.b1.c.b bVar, ConcernPageView.l lVar) {
        super(fragmentManager);
        this.n = "recommendFrsLastReadTabPositionNamespace";
        this.o = "recommendFrsLastReadTabPositionKey";
        this.p = false;
        this.q = -1;
        this.s = -1;
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.f16250f = context;
        if (this.t == null) {
            this.t = new d.a.n0.b1.c.f.a();
        }
        List<y> b2 = this.t.b();
        this.v.clear();
        if (this.f16251g == null) {
            this.f16251g = new ConcernFragment(context);
            e(2);
        }
        this.f16251g.J0(lVar);
        if (d.h() && TbadkCoreApplication.isLogin() && d.a.m0.r.d0.b.j().k("key_home_concern_all_status", 0) == 1) {
            this.v.add(s(this.f16251g, 0, p(R.string.attention_person)));
        } else {
            this.v.add(s(this.f16251g, 0, p(R.string.tab_name_concern)));
        }
        if (this.f16252h == null) {
            this.f16252h = new PersonalizeFragment(context);
            e(1);
        }
        this.f16252h.K0(bVar);
        this.v.add(s(this.f16252h, 1, p(R.string.tab_name_recommend)));
        for (y yVar : b2) {
            int i2 = yVar.f50544a;
            String str = yVar.f50545b;
            String str2 = yVar.f50546c;
            boolean z = yVar.f50548e;
            if (!yVar.a()) {
                if (i2 == 101) {
                    Fragment homePageTabFeedFragment = new HomePageTabFeedFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString(LowFlowsActivityConfig.TAB_CODE, str2);
                    bundle.putString("tab_name", str);
                    homePageTabFeedFragment.setArguments(bundle);
                    this.v.add(u(homePageTabFeedFragment, yVar));
                } else if (i2 == 5) {
                    if (this.f16253i == null) {
                        e(3);
                        HotTopicTabFragment hotTopicTabFragment = new HotTopicTabFragment(context);
                        this.f16253i = hotTopicTabFragment;
                        this.v.add(t(hotTopicTabFragment, i2, str, z));
                    }
                } else if (i2 == 8) {
                    if (this.l == null) {
                        this.l = new VideoTabFragment();
                        e(5);
                        this.v.add(u(this.l, yVar));
                    }
                } else if (i2 == 6) {
                    if (this.j == null) {
                        e(4);
                        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class);
                        if (runTask != null && runTask.getData() != null) {
                            BaseFragment baseFragment = (BaseFragment) runTask.getData();
                            this.j = baseFragment;
                            this.v.add(u(baseFragment, yVar));
                        }
                    }
                } else if (i2 == 7 && this.k == null) {
                    GameVideoFragment gameVideoFragment = new GameVideoFragment();
                    this.k = gameVideoFragment;
                    this.v.add(u(gameVideoFragment, yVar));
                    TiebaStatic.log(new StatisticItem("c13483").param("obj_type", "2"));
                }
            }
        }
        K();
        notifyDataSetChanged();
    }

    public void A(ScrollFragmentTabHost scrollFragmentTabHost) {
        PersonalizeFragment personalizeFragment = this.f16252h;
        if (personalizeFragment != null) {
            personalizeFragment.L0(scrollFragmentTabHost);
        }
        HotTopicTabFragment hotTopicTabFragment = this.f16253i;
        if (hotTopicTabFragment != null) {
            hotTopicTabFragment.K0(scrollFragmentTabHost);
        }
        ConcernFragment concernFragment = this.f16251g;
        if (concernFragment != null) {
            concernFragment.K0(scrollFragmentTabHost);
        }
    }

    public void B(int i2) {
        if (this.s == i2) {
            this.q = -1;
        } else {
            this.q = i2;
        }
    }

    public void F(String str) {
    }

    public void G() {
        PersonalizeFragment personalizeFragment = this.f16252h;
        if (personalizeFragment != null) {
            personalizeFragment.O0();
        }
    }

    public void H() {
        ConcernFragment concernFragment = this.f16251g;
        if (concernFragment != null) {
            concernFragment.L0();
        }
    }

    public void I(DataRes dataRes, boolean z) {
        ConcernFragment concernFragment = this.f16251g;
        if (concernFragment != null) {
            concernFragment.M0(dataRes, z);
        }
    }

    public void J(String str, int i2, int i3) {
        ConcernFragment concernFragment;
        PersonalizeFragment personalizeFragment;
        if (i3 == 1 && (personalizeFragment = this.f16252h) != null && this.m == personalizeFragment) {
            personalizeFragment.Q0(str, i2);
        }
        if (i3 != 0 || (concernFragment = this.f16251g) == null) {
            return;
        }
        concernFragment.N0(str, i2);
    }

    public void K() {
        Fragment fragment;
        this.u.clear();
        boolean d2 = e.d();
        for (b bVar : this.v) {
            if (!d2 || ((fragment = bVar.f16256a) != this.f16253i && fragment != this.j && fragment != this.k && fragment != this.l)) {
                this.u.add(bVar);
            }
        }
    }

    public void L(tbclient.Personalized.DataRes dataRes, boolean z, boolean z2) {
        PersonalizeFragment personalizeFragment = this.f16252h;
        if (personalizeFragment != null) {
            personalizeFragment.P0(dataRes, z, z2);
        }
    }

    public void M() {
        PersonalizeFragment personalizeFragment = this.f16252h;
        if (personalizeFragment != null) {
            personalizeFragment.I0();
        }
    }

    public final void e(int i2) {
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LIVE_TAB_SHOW);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_type", i2);
        TiebaStaticHelper.addYYParam(statisticItem);
        TiebaStatic.log(statisticItem);
    }

    public final void f() {
        PersonalizeFragment personalizeFragment = this.f16252h;
        if (personalizeFragment != null && this.m == personalizeFragment) {
            personalizeFragment.H0();
        }
        ConcernFragment concernFragment = this.f16251g;
        if (concernFragment == null || this.m != concernFragment) {
            return;
        }
        concernFragment.G0();
    }

    public void g() {
        Fragment item = getItem(this.s);
        if (item instanceof o0) {
            ((o0) item).p();
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
        return this.u.get(i2).f16256a;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return (b() == null || !b().contains(obj)) ? -2 : -1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        List<b> list = this.u;
        if (list == null || i2 < 0 || i2 >= list.size() || this.u.get(i2) == null) {
            return null;
        }
        return this.u.get(i2).f16257b;
    }

    public String h() {
        o0 o0Var = this.m;
        if (o0Var instanceof BaseFragment) {
            return ((BaseFragment) o0Var).getCurrentPageKey();
        }
        return null;
    }

    public int i() {
        return this.t.a();
    }

    public int j() {
        for (int i2 = 0; i2 < this.u.size(); i2++) {
            if (this.u.get(i2).f16259d == 5) {
                return i2;
            }
        }
        return -1;
    }

    @Deprecated
    public int k(int i2) {
        for (int i3 = 0; i3 < this.u.size(); i3++) {
            if (this.u.get(i3).f16259d == i2) {
                return i3;
            }
        }
        return o();
    }

    public int l(int i2) {
        b bVar = (b) ListUtils.getItem(this.u, i2);
        if (bVar != null) {
            return bVar.f16259d;
        }
        return 1;
    }

    public void m(d.a.n0.b1.c.d dVar) {
        if (this.p) {
            return;
        }
        this.p = true;
        dVar.a(1);
    }

    public int n(String str) {
        for (int i2 = 0; i2 < this.u.size(); i2++) {
            b bVar = this.u.get(i2);
            if (!TextUtils.isEmpty(str) && str.equals(bVar.f16258c)) {
                return i2;
            }
        }
        return o();
    }

    public int o() {
        for (int i2 = 0; i2 < this.u.size(); i2++) {
            if (this.u.get(i2).f16259d == 1) {
                return i2;
            }
        }
        return 0;
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

    public final String p(int i2) {
        return TbadkCoreApplication.getInst().getString(i2);
    }

    public boolean q() {
        return this.f16251g != null;
    }

    public boolean r() {
        return this.f16253i != null;
    }

    public b s(Fragment fragment, int i2, String str) {
        return new b(fragment, i2, str);
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
            VoiceManager a2 = d.a.n0.e3.p0.b.a(this.f16250f);
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

    public b t(Fragment fragment, int i2, String str, boolean z) {
        return new b(fragment, i2, str, z);
    }

    public b u(Fragment fragment, y yVar) {
        return new b(fragment, yVar.f50544a, yVar.f50545b);
    }

    public void v(int i2) {
        PersonalizeFragment personalizeFragment;
        if (i2 != 1 || (personalizeFragment = this.f16252h) == null) {
            return;
        }
        personalizeFragment.J0();
    }

    public void w(int i2) {
        o0 o0Var = this.m;
        if (o0Var != null) {
            o0Var.H();
        }
    }

    public void x() {
        o0 o0Var = this.m;
        if (o0Var != null) {
            o0Var.p();
        }
    }

    public void y(int i2) {
        h0.b(new a(i2), null);
    }

    public void z(boolean z) {
        if (this.m instanceof BaseFragment) {
            if (!z) {
                int position = ListUtils.getPosition(b(), (BaseFragment) this.m);
                if (position < 0) {
                    position = k(1);
                }
                y(position);
                f();
            }
            ((BaseFragment) this.m).setPrimary(z);
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f16256a;

        /* renamed from: b  reason: collision with root package name */
        public String f16257b;

        /* renamed from: c  reason: collision with root package name */
        public String f16258c;

        /* renamed from: d  reason: collision with root package name */
        public int f16259d;

        public b(Fragment fragment, int i2, String str) {
            this.f16256a = fragment;
            this.f16259d = i2;
            this.f16257b = str;
            this.f16258c = str;
        }

        public b(Fragment fragment, int i2, String str, boolean z) {
            this.f16256a = fragment;
            this.f16259d = i2;
            this.f16257b = str;
            this.f16258c = str;
        }
    }
}
