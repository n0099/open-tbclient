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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
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
import d.b.c.e.d.l;
import d.b.i0.b.d;
import d.b.i0.c1.b.c;
import d.b.i0.s.c.x;
import d.b.i0.z0.b0;
import d.b.i0.z0.f0;
import d.b.i0.z0.h0;
import d.b.j0.q0.o0;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {

    /* renamed from: f  reason: collision with root package name */
    public Context f16774f;

    /* renamed from: g  reason: collision with root package name */
    public ConcernFragment f16775g;

    /* renamed from: h  reason: collision with root package name */
    public PersonalizeFragment f16776h;
    public HotTopicTabFragment i;
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
    public d.b.j0.a1.c.f.a t;
    public b u;
    public int v;
    public boolean w;
    public List<b> x;

    /* loaded from: classes4.dex */
    public class a extends f0<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f16777a;

        public a(int i) {
            this.f16777a = i;
        }

        @Override // d.b.i0.z0.f0
        public Object doInBackground() {
            l<String> h2 = d.b.i0.r.r.a.f().h(NewScrollFragmentAdapter.this.n, TbadkCoreApplication.getCurrentAccount());
            if (h2 != null) {
                h2.e(NewScrollFragmentAdapter.this.o, Integer.toString(this.f16777a), 43200000L);
                return null;
            }
            return null;
        }
    }

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, d.b.j0.a1.c.b bVar, ConcernPageView.l lVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.n = "recommendFrsLastReadTabPositionNamespace";
        this.o = "recommendFrsLastReadTabPositionKey";
        this.p = false;
        this.q = -1;
        this.s = -1;
        this.v = -1;
        this.w = false;
        this.x = new ArrayList();
        this.f16774f = context;
        if (this.t == null) {
            this.t = new d.b.j0.a1.c.f.a();
        }
        List<x> b2 = this.t.b();
        List<b> arrayList = new ArrayList<>();
        if (this.f16775g == null) {
            this.f16775g = new ConcernFragment(context);
        }
        this.f16775g.K0(lVar);
        if (d.h() && TbadkCoreApplication.isLogin() && d.b.i0.r.d0.b.j().k("key_home_concern_all_status", 0) == 1) {
            arrayList.add(y(this.f16775g, 0, v(R.string.attention_person)));
        } else {
            arrayList.add(y(this.f16775g, 0, v(R.string.tab_name_concern)));
        }
        if (this.f16776h == null) {
            this.f16776h = new PersonalizeFragment(context);
        }
        this.f16776h.L0(bVar);
        arrayList.add(y(this.f16776h, 1, v(R.string.tab_name_recommend)));
        for (x xVar : b2) {
            int i = xVar.f51994a;
            String str = xVar.f51995b;
            String str2 = xVar.f51996c;
            boolean z = xVar.f51998e;
            if (!xVar.a()) {
                if (i == 101) {
                    Fragment homePageTabFeedFragment = new HomePageTabFeedFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString(LowFlowsActivityConfig.TAB_CODE, str2);
                    bundle.putString("tab_name", str);
                    homePageTabFeedFragment.setArguments(bundle);
                    arrayList.add(A(homePageTabFeedFragment, xVar));
                } else if (i == 5) {
                    if (this.i == null) {
                        HotTopicTabFragment hotTopicTabFragment = new HotTopicTabFragment(context);
                        this.i = hotTopicTabFragment;
                        arrayList.add(z(hotTopicTabFragment, i, str, z));
                    }
                } else if (i == 8) {
                    if (this.l == null) {
                        VideoTabFragment videoTabFragment = new VideoTabFragment();
                        this.l = videoTabFragment;
                        arrayList.add(A(videoTabFragment, xVar));
                    }
                } else if (i == 6) {
                    if (this.j == null && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null && runTask.getData() != null) {
                        BaseFragment baseFragment = (BaseFragment) runTask.getData();
                        this.j = baseFragment;
                        b A = A(baseFragment, xVar);
                        this.u = A;
                        arrayList.add(A);
                    }
                } else if (i == 7 && this.k == null) {
                    GameVideoFragment gameVideoFragment = new GameVideoFragment();
                    this.k = gameVideoFragment;
                    arrayList.add(A(gameVideoFragment, xVar));
                    TiebaStatic.log(new StatisticItem("c13483").param("obj_type", "2"));
                }
            }
        }
        this.x.clear();
        j(arrayList);
    }

    public b A(Fragment fragment, x xVar) {
        return new b(fragment, xVar.f51994a, xVar.f51995b);
    }

    public void B(int i) {
        PersonalizeFragment personalizeFragment;
        if (i != 1 || (personalizeFragment = this.f16776h) == null) {
            return;
        }
        personalizeFragment.K0();
    }

    public void E(int i) {
        o0 o0Var = this.m;
        if (o0Var != null) {
            o0Var.b0();
        }
    }

    public void F() {
        o0 o0Var = this.m;
        if (o0Var != null) {
            o0Var.w();
        }
    }

    public void G() {
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
        f(false, this.u.f16779a);
        this.w = false;
    }

    public void I() {
        b bVar = this.u;
        if (bVar == null || this.v < 0) {
            return;
        }
        this.w = true;
        if (this.x.indexOf(bVar) == -1) {
            this.x.add(this.v, this.u);
            notifyDataSetChanged();
        }
        f(true, this.u.f16779a);
        this.w = false;
    }

    public void J(int i) {
        h0.b(new a(i), null);
    }

    public void K(boolean z) {
        if (this.m instanceof BaseFragment) {
            if (!z) {
                int position = ListUtils.getPosition(e(), (BaseFragment) this.m);
                if (position < 0) {
                    position = p(1);
                }
                J(position);
                k();
            }
            ((BaseFragment) this.m).setPrimary(z);
        }
    }

    public void L(ScrollFragmentTabHost scrollFragmentTabHost) {
        PersonalizeFragment personalizeFragment = this.f16776h;
        if (personalizeFragment != null) {
            personalizeFragment.M0(scrollFragmentTabHost);
        }
        HotTopicTabFragment hotTopicTabFragment = this.i;
        if (hotTopicTabFragment != null) {
            hotTopicTabFragment.L0(scrollFragmentTabHost);
        }
        ConcernFragment concernFragment = this.f16775g;
        if (concernFragment != null) {
            concernFragment.L0(scrollFragmentTabHost);
        }
    }

    public void M(int i) {
        if (this.s == i) {
            this.q = -1;
        } else {
            this.q = i;
        }
    }

    public void O(String str) {
    }

    public void P() {
        PersonalizeFragment personalizeFragment = this.f16776h;
        if (personalizeFragment != null) {
            personalizeFragment.P0();
        }
    }

    public void Q() {
        ConcernFragment concernFragment = this.f16775g;
        if (concernFragment != null) {
            concernFragment.M0();
        }
    }

    public void R(DataRes dataRes, boolean z) {
        ConcernFragment concernFragment = this.f16775g;
        if (concernFragment != null) {
            concernFragment.N0(dataRes, z);
        }
    }

    public void S(String str, int i, int i2) {
        ConcernFragment concernFragment;
        PersonalizeFragment personalizeFragment;
        if (i2 == 1 && (personalizeFragment = this.f16776h) != null && this.m == personalizeFragment) {
            personalizeFragment.R0(str, i);
        }
        if (i2 != 0 || (concernFragment = this.f16775g) == null) {
            return;
        }
        concernFragment.O0(str, i);
    }

    public void T(tbclient.Personalized.DataRes dataRes, boolean z, boolean z2) {
        PersonalizeFragment personalizeFragment = this.f16776h;
        if (personalizeFragment != null) {
            personalizeFragment.Q0(dataRes, z, z2);
        }
    }

    public void U() {
        PersonalizeFragment personalizeFragment = this.f16776h;
        if (personalizeFragment != null) {
            personalizeFragment.J0();
        }
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
    public Fragment getItem(int i) {
        List<b> list = this.x;
        if (list == null || i < 0 || i >= list.size() || this.x.get(i) == null) {
            return null;
        }
        return this.x.get(i).f16779a;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return (this.w || e() == null || !e().contains(obj)) ? -2 : -1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        List<b> list = this.x;
        if (list == null || i < 0 || i >= list.size() || this.x.get(i) == null) {
            return null;
        }
        return this.x.get(i).f16780b;
    }

    public void j(List<b> list) {
        if (this.x == null || list == null || list.size() <= 0) {
            return;
        }
        this.x.addAll(list);
        notifyDataSetChanged();
        if (c.d()) {
            G();
        }
    }

    public final void k() {
        PersonalizeFragment personalizeFragment = this.f16776h;
        if (personalizeFragment != null && this.m == personalizeFragment) {
            personalizeFragment.I0();
        }
        ConcernFragment concernFragment = this.f16775g;
        if (concernFragment == null || this.m != concernFragment) {
            return;
        }
        concernFragment.H0();
    }

    public void l() {
        Fragment item = getItem(this.s);
        if (item instanceof o0) {
            ((o0) item).w();
        }
    }

    public String m() {
        o0 o0Var = this.m;
        if (o0Var instanceof BaseFragment) {
            return ((BaseFragment) o0Var).getCurrentPageKey();
        }
        return null;
    }

    public int n() {
        return this.t.a();
    }

    public int o() {
        for (int i = 0; i < this.x.size(); i++) {
            if (this.x.get(i).f16782d == 5) {
                return i;
            }
        }
        return -1;
    }

    public void onPageScrolled(int i, float f2, int i2) {
        int i3 = this.q;
        if (i3 == -1 || (i == i3 && f2 == 0.0f)) {
            Fragment fragment = (Fragment) ListUtils.getItem(e(), i - 1);
            Fragment fragment2 = (Fragment) ListUtils.getItem(e(), i);
            Fragment fragment3 = (Fragment) ListUtils.getItem(e(), i + 1);
            this.q = -1;
            if (f2 == 0.0f) {
                if (fragment instanceof o0) {
                    ((o0) fragment).W();
                }
                if (fragment3 instanceof o0) {
                    ((o0) fragment3).W();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof o0) {
                ((o0) fragment).F();
            }
            if (fragment2 instanceof o0) {
                ((o0) fragment2).F();
            }
            if (fragment3 instanceof o0) {
                ((o0) fragment3).F();
            }
        }
    }

    @Deprecated
    public int p(int i) {
        for (int i2 = 0; i2 < this.x.size(); i2++) {
            if (this.x.get(i2).f16782d == i) {
                return i2;
            }
        }
        return u();
    }

    public int q(int i) {
        b bVar = (b) ListUtils.getItem(this.x, i);
        if (bVar != null) {
            return bVar.f16782d;
        }
        return 1;
    }

    public void r(d.b.j0.a1.c.d dVar) {
        if (this.p) {
            return;
        }
        this.p = true;
        dVar.a(1);
    }

    public int s(String str) {
        for (int i = 0; i < this.x.size(); i++) {
            b bVar = this.x.get(i);
            if (!TextUtils.isEmpty(str) && str.equals(bVar.f16781c)) {
                return i;
            }
        }
        return u();
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.s != i) {
            o0 o0Var = this.m;
            if (o0Var instanceof BaseFragment) {
                ((BaseFragment) o0Var).setPrimary(false);
            }
            this.s = i;
            VoiceManager a2 = d.b.j0.d3.p0.b.a(this.f16774f);
            if (a2 != null) {
                a2.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).E();
            }
            if (obj instanceof o0) {
                ((o0) obj).A();
            }
        }
        if (obj instanceof o0) {
            o0 o0Var2 = (o0) obj;
            this.m = o0Var2;
            o0Var2.K(this.r);
        }
    }

    public int u() {
        for (int i = 0; i < this.x.size(); i++) {
            if (this.x.get(i).f16782d == 1) {
                return i;
            }
        }
        return 0;
    }

    public final String v(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public boolean w() {
        return this.f16775g != null;
    }

    public boolean x() {
        return this.i != null;
    }

    public b y(Fragment fragment, int i, String str) {
        return new b(fragment, i, str);
    }

    public b z(Fragment fragment, int i, String str, boolean z) {
        return new b(fragment, i, str, z);
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f16779a;

        /* renamed from: b  reason: collision with root package name */
        public String f16780b;

        /* renamed from: c  reason: collision with root package name */
        public String f16781c;

        /* renamed from: d  reason: collision with root package name */
        public int f16782d;

        public b(Fragment fragment, int i, String str) {
            this.f16779a = fragment;
            this.f16782d = i;
            this.f16780b = str;
            this.f16781c = str;
        }

        public b(Fragment fragment, int i, String str, boolean z) {
            this.f16779a = fragment;
            this.f16782d = i;
            this.f16780b = str;
            this.f16781c = str;
        }
    }
}
