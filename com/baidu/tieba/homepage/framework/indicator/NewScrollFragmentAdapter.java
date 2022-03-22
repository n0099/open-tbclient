package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import c.a.d.f.d.l;
import c.a.o0.c1.k0;
import c.a.o0.c1.n0;
import c.a.o0.s.c.z;
import c.a.p0.f1.o0;
import c.a.p0.q1.e.c;
import c.a.p0.q1.e.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes5.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public Context f33260f;

    /* renamed from: g  reason: collision with root package name */
    public ConcernFragment f33261g;

    /* renamed from: h  reason: collision with root package name */
    public PersonalizeFragment f33262h;
    public HotTopicTabFragment i;
    public BaseFragment j;
    public GameVideoFragment k;
    public VideoTabFragment l;
    public o0 m;
    public String n;
    public String o;
    public boolean p;
    public int q;
    public int r;
    public c.a.p0.q1.e.g.a s;
    public List<b> t;
    public List<b> u;

    /* loaded from: classes5.dex */
    public class a extends k0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NewScrollFragmentAdapter f33263b;

        public a(NewScrollFragmentAdapter newScrollFragmentAdapter, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newScrollFragmentAdapter, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33263b = newScrollFragmentAdapter;
            this.a = i;
        }

        @Override // c.a.o0.c1.k0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.o0.r.s.a.f();
                l<String> h2 = c.a.o0.r.s.a.h(this.f33263b.n, TbadkCoreApplication.getCurrentAccount());
                if (h2 != null) {
                    h2.e(this.f33263b.o, Integer.toString(this.a), 43200000L);
                    return null;
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, c cVar, ConcernPageView.l lVar) {
        super(fragmentManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, fragmentManager, cVar, lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((FragmentManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = "recommendFrsLastReadTabPositionNamespace";
        this.o = "recommendFrsLastReadTabPositionKey";
        this.p = false;
        this.q = -1;
        this.r = -1;
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.f33260f = context;
        if (this.s == null) {
            this.s = new c.a.p0.q1.e.g.a();
        }
        List<z> g2 = this.s.g();
        this.u.clear();
        j(context, cVar, lVar);
        k(context, g2);
        f();
        M();
        notifyDataSetChanged();
    }

    public void A(int i) {
        o0 o0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (o0Var = this.m) == null) {
            return;
        }
        o0Var.C();
    }

    public void B() {
        o0 o0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (o0Var = this.m) == null) {
            return;
        }
        o0Var.n();
    }

    public void C() {
        List<b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (list = this.u) == null) {
            return;
        }
        Iterator<b> it = list.iterator();
        while (it.hasNext()) {
            Fragment fragment = it.next().a;
            if (!(fragment instanceof ConcernFragment) && !(fragment instanceof PersonalizeFragment)) {
                it.remove();
            }
        }
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        c.a.p0.q1.e.g.a aVar = this.s;
        if (aVar == null) {
            this.s = new c.a.p0.q1.e.g.a();
        } else {
            aVar.j();
        }
        k(this.f33260f, this.s.g());
        f();
        M();
    }

    public void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            n0.b(new a(this, i), null);
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (this.m instanceof BaseFragment)) {
            if (!z) {
                int position = ListUtils.getPosition(b(), (BaseFragment) this.m);
                if (position < 0) {
                    position = n(1);
                }
                D(position);
                g();
            }
            ((BaseFragment) this.m).setPrimary(z);
        }
    }

    public void F(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, scrollFragmentTabHost) == null) {
            PersonalizeFragment personalizeFragment = this.f33262h;
            if (personalizeFragment != null) {
                personalizeFragment.K0(scrollFragmentTabHost);
            }
            HotTopicTabFragment hotTopicTabFragment = this.i;
            if (hotTopicTabFragment != null) {
                hotTopicTabFragment.K0(scrollFragmentTabHost);
            }
            ConcernFragment concernFragment = this.f33261g;
            if (concernFragment != null) {
                concernFragment.J0(scrollFragmentTabHost);
            }
        }
    }

    public void G(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            if (this.r == i) {
                this.q = -1;
            } else {
                this.q = i;
            }
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
        }
    }

    public void I() {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (personalizeFragment = this.f33262h) == null) {
            return;
        }
        personalizeFragment.M0();
    }

    public void J() {
        ConcernFragment concernFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (concernFragment = this.f33261g) == null) {
            return;
        }
        concernFragment.K0();
    }

    public void K(DataRes dataRes, boolean z) {
        ConcernFragment concernFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048586, this, dataRes, z) == null) || (concernFragment = this.f33261g) == null) {
            return;
        }
        concernFragment.L0(dataRes, z);
    }

    public void L(String str, int i, int i2) {
        ConcernFragment concernFragment;
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048587, this, str, i, i2) == null) {
            if (i2 == 1 && (personalizeFragment = this.f33262h) != null && this.m == personalizeFragment) {
                personalizeFragment.O0(str, i);
            }
            if (i2 != 0 || (concernFragment = this.f33261g) == null) {
                return;
            }
            concernFragment.M0(str, i);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.t.clear();
            for (b bVar : this.u) {
                this.t.add(bVar);
            }
        }
    }

    public void N(tbclient.Personalized.DataRes dataRes, boolean z, boolean z2) {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (personalizeFragment = this.f33262h) == null) {
            return;
        }
        personalizeFragment.N0(dataRes, z, z2);
    }

    public void O() {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (personalizeFragment = this.f33262h) == null) {
            return;
        }
        personalizeFragment.H0();
    }

    public final void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LIVE_TAB_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_type", i);
            TiebaStaticHelper.addYYParam(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void f() {
        List<b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (list = this.u) == null) {
            return;
        }
        for (b bVar : list) {
            if (bVar != null) {
                Fragment fragment = bVar.a;
                if (fragment instanceof BaseFragment) {
                    ((BaseFragment) fragment).setTbPageExtraPageTabName(bVar.f33265c);
                }
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            PersonalizeFragment personalizeFragment = this.f33262h;
            if (personalizeFragment != null && this.m == personalizeFragment) {
                personalizeFragment.G0();
            }
            ConcernFragment concernFragment = this.f33261g;
            if (concernFragment == null || this.m != concernFragment) {
                return;
            }
            concernFragment.F0();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            List<b> list = this.t;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            List<b> list = this.t;
            if (list == null || i < 0 || i >= list.size() || this.t.get(i) == null) {
                return null;
            }
            return this.t.get(i).a;
        }
        return (Fragment) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, obj)) == null) ? (b() == null || !b().contains(obj)) ? -2 : -1 : invokeL.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            List<b> list = this.t;
            if (list == null || i < 0 || i >= list.size() || this.t.get(i) == null) {
                return null;
            }
            return this.t.get(i).f33264b;
        }
        return (CharSequence) invokeI.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            c.a.p0.q1.e.g.a aVar = this.s;
            if (aVar == null) {
                return false;
            }
            return aVar.c();
        }
        return invokeV.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            Fragment item = getItem(this.r);
            if (item instanceof o0) {
                ((o0) item).n();
            }
        }
    }

    public final void j(Context context, c cVar, ConcernPageView.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048600, this, context, cVar, lVar) == null) {
            if (this.f33261g == null) {
                this.f33261g = new ConcernFragment(context);
                e(2);
            }
            this.f33261g.I0(lVar);
            if (UbsABTestHelper.isConcernForumCardShow() && TbadkCoreApplication.isLogin() && c.a.o0.r.j0.b.k().l("key_home_concern_all_status", 0) == 1) {
                this.u.add(w(this.f33261g, 0, u(R.string.obfuscated_res_0x7f0f02a8)));
            } else {
                this.u.add(w(this.f33261g, 0, u(R.string.obfuscated_res_0x7f0f131c)));
            }
            if (this.f33262h == null) {
                this.f33262h = new PersonalizeFragment(context);
                e(1);
            }
            this.f33262h.J0(cVar);
            this.u.add(w(this.f33262h, 1, u(R.string.obfuscated_res_0x7f0f1323)));
        }
    }

    public final void k(Context context, List<z> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, context, list) == null) {
            for (z zVar : list) {
                int i = zVar.a;
                String str = zVar.f11280b;
                String str2 = zVar.f11281c;
                boolean z = zVar.f11284f;
                if (!zVar.c()) {
                    if (i == 101 || i == 201) {
                        this.u.add(y(new HomePageTabFeedFragment(), zVar));
                    } else if (i == 5) {
                        if (this.i == null) {
                            e(3);
                            HotTopicTabFragment hotTopicTabFragment = new HotTopicTabFragment(context);
                            this.i = hotTopicTabFragment;
                            this.u.add(x(hotTopicTabFragment, i, str, str2, z));
                        }
                    } else if (i == 8) {
                        if (this.l == null) {
                            this.l = new VideoTabFragment();
                            e(5);
                            this.u.add(y(this.l, zVar));
                        }
                    } else if (i == 6) {
                        if (this.j == null) {
                            e(4);
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class);
                            if (runTask != null && runTask.getData() != null) {
                                BaseFragment baseFragment = (BaseFragment) runTask.getData();
                                this.j = baseFragment;
                                this.u.add(y(baseFragment, zVar));
                            }
                        }
                    } else if (i == 7) {
                        if (this.k == null) {
                            GameVideoFragment gameVideoFragment = new GameVideoFragment();
                            this.k = gameVideoFragment;
                            this.u.add(y(gameVideoFragment, zVar));
                            TiebaStatic.log(new StatisticItem("c13483").param("obj_type", "2"));
                        }
                    } else if (i == 202 && !TextUtils.isEmpty(zVar.f11282d)) {
                        Fragment tabWebFragment = new TabWebFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("tab_code", str2);
                        bundle.putString("tab_name", str);
                        bundle.putString("tab_url", zVar.f11282d);
                        bundle.putInt("tab_type", i);
                        tabWebFragment.setArguments(bundle);
                        this.u.add(y(tabWebFragment, zVar));
                    }
                }
            }
        }
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            o0 o0Var = this.m;
            if (o0Var instanceof BaseFragment) {
                return ((BaseFragment) o0Var).getCurrentPageKey();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.s.e() : invokeV.intValue;
    }

    @Deprecated
    public int n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
            for (int i2 = 0; i2 < this.t.size(); i2++) {
                if (this.t.get(i2).f33267e == i) {
                    return i2;
                }
            }
            return t();
        }
        return invokeI.intValue;
    }

    public String o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
            b bVar = (b) ListUtils.getItem(this.t, i);
            return bVar != null ? bVar.f33266d : "";
        }
        return (String) invokeI.objValue;
    }

    public void onPageScrolled(int i, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            int i3 = this.q;
            if (i3 == -1 || (i == i3 && f2 == 0.0f)) {
                Fragment fragment = (Fragment) ListUtils.getItem(b(), i - 1);
                Fragment fragment2 = (Fragment) ListUtils.getItem(b(), i);
                Fragment fragment3 = (Fragment) ListUtils.getItem(b(), i + 1);
                this.q = -1;
                if (f2 == 0.0f) {
                    if (fragment instanceof o0) {
                        ((o0) fragment).A();
                    }
                    if (fragment3 instanceof o0) {
                        ((o0) fragment3).A();
                    }
                    if (fragment2 != null) {
                        fragment2.setMenuVisibility(true);
                        fragment2.setUserVisibleHint(true);
                        return;
                    }
                    return;
                }
                if (fragment instanceof o0) {
                    ((o0) fragment).r();
                }
                if (fragment2 instanceof o0) {
                    ((o0) fragment2).r();
                }
                if (fragment3 instanceof o0) {
                    ((o0) fragment3).r();
                }
            }
        }
    }

    public int p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i)) == null) {
            b bVar = (b) ListUtils.getItem(this.t, i);
            if (bVar != null) {
                return bVar.f33267e;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public void q(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, eVar) == null) || this.p) {
            return;
        }
        this.p = true;
        eVar.a(1);
    }

    public int r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
            for (int i = 0; i < this.t.size(); i++) {
                b bVar = this.t.get(i);
                if (!TextUtils.isEmpty(str) && str.equals(bVar.f33266d)) {
                    return i;
                }
            }
            return t();
        }
        return invokeL.intValue;
    }

    public int s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            for (int i = 0; i < this.t.size(); i++) {
                b bVar = this.t.get(i);
                if (!TextUtils.isEmpty(str) && str.equals(bVar.f33265c)) {
                    return i;
                }
            }
            return t();
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048611, this, viewGroup, i, obj) == null) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (obj != null && this.r != i) {
                o0 o0Var = this.m;
                if (o0Var instanceof BaseFragment) {
                    ((BaseFragment) o0Var).setPrimary(false);
                }
                this.r = i;
                VoiceManager a2 = c.a.p0.a4.s0.b.a(this.f33260f);
                if (a2 != null) {
                    a2.stopPlay();
                }
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
                if ((obj instanceof PersonalizeFragment) && i == 0) {
                    ((PersonalizeFragment) obj).q();
                }
            }
            if (obj instanceof o0) {
                this.m = (o0) obj;
            }
        }
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            for (int i = 0; i < this.t.size(); i++) {
                if (this.t.get(i).f33267e == 1) {
                    return i;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final String u(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i)) == null) ? TbadkCoreApplication.getInst().getString(i) : (String) invokeI.objValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f33261g != null : invokeV.booleanValue;
    }

    public b w(Fragment fragment, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048615, this, fragment, i, str)) == null) ? new b(fragment, i, str) : (b) invokeLIL.objValue;
    }

    public b x(Fragment fragment, int i, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048616, this, new Object[]{fragment, Integer.valueOf(i), str, str2, Boolean.valueOf(z)})) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("tab_code", str2);
            bundle.putString("tab_name", str);
            bundle.putInt("tab_type", i);
            fragment.setArguments(bundle);
            return new b(fragment, i, str, str2, z);
        }
        return (b) invokeCommon.objValue;
    }

    public b y(Fragment fragment, z zVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048617, this, fragment, zVar)) == null) {
            Bundle arguments = fragment.getArguments();
            if (arguments == null) {
                arguments = new Bundle();
            }
            arguments.putString("tab_code", zVar.f11281c);
            arguments.putString("tab_name", zVar.f11280b);
            arguments.putInt("tab_type", zVar.a);
            fragment.setArguments(arguments);
            return new b(fragment, zVar.a, zVar.b(), zVar.f11280b, zVar.f11281c);
        }
        return (b) invokeLL.objValue;
    }

    public void z(int i) {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048618, this, i) == null) && i == 1 && (personalizeFragment = this.f33262h) != null) {
            personalizeFragment.I0();
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Fragment a;

        /* renamed from: b  reason: collision with root package name */
        public String f33264b;

        /* renamed from: c  reason: collision with root package name */
        public String f33265c;

        /* renamed from: d  reason: collision with root package name */
        public String f33266d;

        /* renamed from: e  reason: collision with root package name */
        public int f33267e;

        public b(Fragment fragment, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragment, Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fragment;
            this.f33267e = i;
            this.f33264b = str;
            this.f33265c = str;
        }

        public b(Fragment fragment, int i, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragment, Integer.valueOf(i), str, str2, str3};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = fragment;
            this.f33267e = i;
            this.f33264b = str2;
            this.f33264b = str;
            this.f33265c = str2;
            this.f33266d = str3;
        }

        public b(Fragment fragment, int i, String str, String str2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragment, Integer.valueOf(i), str, str2, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.a = fragment;
            this.f33267e = i;
            this.f33264b = str;
            this.f33265c = str;
            this.f33266d = str2;
        }
    }
}
