package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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
import com.baidu.tieba.homepage.personalize.PersonalizeWrapperFragment;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.homepage.tabfeed.h5.TabWebFragment;
import com.baidu.tieba.homepage.video.VideoTabFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cr4;
import com.repackage.de5;
import com.repackage.ge6;
import com.repackage.he5;
import com.repackage.hk8;
import com.repackage.jz6;
import com.repackage.lu6;
import com.repackage.mu6;
import com.repackage.ou6;
import com.repackage.ru6;
import com.repackage.sx4;
import com.repackage.te;
import com.repackage.yt4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes3.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context f;
    public ConcernFragment g;
    public PersonalizeFragment h;
    public PersonalizeWrapperFragment i;
    public HotTopicTabFragment j;
    public BaseFragment k;
    public GameVideoFragment l;
    public VideoTabFragment m;
    public ge6 n;
    public String o;
    public String p;
    public boolean q;
    public int r;
    public int s;
    public ru6 t;
    public boolean u;
    public List<b> v;
    public List<b> w;
    public HashMap<String, BaseFragment> x;

    /* loaded from: classes3.dex */
    public class a extends de5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ NewScrollFragmentAdapter b;

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
            this.b = newScrollFragmentAdapter;
            this.a = i;
        }

        @Override // com.repackage.de5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                cr4.f();
                te<String> h = cr4.h(this.b.o, TbadkCoreApplication.getCurrentAccount());
                if (h != null) {
                    h.e(this.b.p, Integer.toString(this.a), 43200000L);
                    return null;
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, boolean z, lu6 lu6Var, ConcernPageView.o oVar) {
        super(fragmentManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, fragmentManager, Boolean.valueOf(z), lu6Var, oVar};
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
        this.o = "recommendFrsLastReadTabPositionNamespace";
        this.p = "recommendFrsLastReadTabPositionKey";
        this.q = false;
        this.r = -1;
        this.s = -1;
        this.u = false;
        this.v = new ArrayList();
        this.w = new ArrayList();
        this.x = new HashMap<>();
        this.f = context;
        this.u = z;
        if (this.t == null) {
            this.t = new ru6();
        }
        List<sx4> f = this.u ? this.t.f() : this.t.h();
        this.w.clear();
        this.x.clear();
        j(context, lu6Var, oVar);
        k(context, f);
        f();
        P();
        notifyDataSetChanged();
    }

    public void A(String str) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            int hashCode = str.hashCode();
            if (hashCode != 674261) {
                if (hashCode == 824488 && str.equals("推荐")) {
                    c = 0;
                }
                c = 65535;
            } else {
                if (str.equals("关注")) {
                    c = 1;
                }
                c = 65535;
            }
            if (c == 0) {
                PersonalizeFragment personalizeFragment = this.h;
                if (personalizeFragment != null) {
                    personalizeFragment.notifyColourHeaderData();
                }
            } else if (c != 1) {
                if (this.x.containsKey(str)) {
                    this.x.get(str).notifyColourHeaderData();
                }
            } else {
                ConcernFragment concernFragment = this.g;
                if (concernFragment != null) {
                    concernFragment.notifyColourHeaderData();
                }
            }
        }
    }

    public void B(int i) {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && i == 1 && (personalizeFragment = this.h) != null) {
            personalizeFragment.y1();
        }
    }

    public void C(int i) {
        ge6 ge6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || (ge6Var = this.n) == null) {
            return;
        }
        ge6Var.b0();
    }

    public void D() {
        ge6 ge6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (ge6Var = this.n) == null) {
            return;
        }
        ge6Var.t();
    }

    public void E() {
        List<b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (list = this.w) == null) {
            return;
        }
        Iterator<b> it = list.iterator();
        while (it.hasNext()) {
            Fragment fragment = it.next().a;
            if (!(fragment instanceof ConcernFragment) && !(fragment instanceof PersonalizeFragment)) {
                it.remove();
            }
        }
        this.x.clear();
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        ru6 ru6Var = this.t;
        if (ru6Var == null) {
            this.t = new ru6();
        } else {
            ru6Var.k();
        }
        k(this.f, this.u ? this.t.f() : this.t.h());
        f();
        P();
    }

    public void F(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            he5.b(new a(this, i), null);
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048582, this, z) == null) && (this.n instanceof BaseFragment)) {
            if (!z) {
                int position = ListUtils.getPosition(b(), (BaseFragment) this.n);
                if (position < 0) {
                    position = n(1);
                }
                F(position);
                g();
            }
            ((BaseFragment) this.n).setPrimary(z);
        }
    }

    public void H(mu6 mu6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, mu6Var) == null) {
            PersonalizeFragment personalizeFragment = this.h;
            if (personalizeFragment != null) {
                personalizeFragment.B1(mu6Var);
            }
            if (mu6Var instanceof ScrollFragmentTabHost) {
                ScrollFragmentTabHost scrollFragmentTabHost = (ScrollFragmentTabHost) mu6Var;
                HotTopicTabFragment hotTopicTabFragment = this.j;
                if (hotTopicTabFragment != null) {
                    hotTopicTabFragment.B1(scrollFragmentTabHost);
                }
                ConcernFragment concernFragment = this.g;
                if (concernFragment != null) {
                    concernFragment.A1(scrollFragmentTabHost);
                }
            }
        }
    }

    public void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            if (this.s == i) {
                this.r = -1;
            } else {
                this.r = i;
            }
        }
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
        }
    }

    public void L() {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (personalizeFragment = this.h) == null) {
            return;
        }
        personalizeFragment.D1();
    }

    public void M() {
        ConcernFragment concernFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (concernFragment = this.g) == null) {
            return;
        }
        concernFragment.B1();
    }

    public void N(DataRes dataRes, boolean z) {
        ConcernFragment concernFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048588, this, dataRes, z) == null) || (concernFragment = this.g) == null) {
            return;
        }
        concernFragment.C1(dataRes, z);
    }

    public void O(String str, int i, int i2) {
        ConcernFragment concernFragment;
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048589, this, str, i, i2) == null) {
            if (i2 == 1 && (personalizeFragment = this.h) != null) {
                personalizeFragment.F1(str, i);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("updateError ");
                sb.append(i2);
                sb.append(" ");
                sb.append(this.h != null);
                sb.append(" ");
                sb.append(this.n == this.h);
                jz6.a(sb.toString());
                jz6.a("updateError : mCurrentFragmentName : " + this.n.getClass().getName() + "  mCurrentFragment instance : " + this.n + "  mPersonalizeFragment instance : " + this.h);
            }
            if (i2 != 0 || (concernFragment = this.g) == null) {
                return;
            }
            concernFragment.D1(str, i);
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.v.clear();
            for (b bVar : this.w) {
                this.v.add(bVar);
            }
        }
    }

    public void Q(tbclient.Personalized.DataRes dataRes, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.h == null) {
            return;
        }
        jz6.a("mPersonalizeFragmentSuccess");
        this.h.E1(dataRes, z, z2);
    }

    public void R() {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (personalizeFragment = this.h) == null) {
            return;
        }
        personalizeFragment.x1();
    }

    public final void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (list = this.w) == null) {
            return;
        }
        for (b bVar : list) {
            if (bVar != null) {
                Fragment fragment = bVar.a;
                if (fragment instanceof BaseFragment) {
                    ((BaseFragment) fragment).setTbPageExtraPageTabName(bVar.c);
                }
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            PersonalizeFragment personalizeFragment = this.h;
            if (personalizeFragment != null && this.n == personalizeFragment) {
                personalizeFragment.w1();
            }
            ConcernFragment concernFragment = this.g;
            if (concernFragment == null || this.n != concernFragment) {
                return;
            }
            concernFragment.v1();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            List<b> list = this.v;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            List<b> list = this.v;
            if (list == null || i < 0 || i >= list.size() || this.v.get(i) == null) {
                return null;
            }
            return this.v.get(i).a;
        }
        return (Fragment) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, obj)) == null) ? (b() == null || !b().contains(obj)) ? -2 : -1 : invokeL.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            List<b> list = this.v;
            if (list == null || i < 0 || i >= list.size() || this.v.get(i) == null) {
                return null;
            }
            return this.v.get(i).b;
        }
        return (CharSequence) invokeI.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            ru6 ru6Var = this.t;
            if (ru6Var == null) {
                return false;
            }
            return ru6Var.c();
        }
        return invokeV.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            Fragment item = getItem(this.s);
            if (item instanceof ge6) {
                ((ge6) item).t();
            }
        }
    }

    public final void j(Context context, lu6 lu6Var, ConcernPageView.o oVar) {
        String v;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048602, this, context, lu6Var, oVar) == null) {
            if (this.g == null) {
                this.g = new ConcernFragment(context);
                e(2);
            }
            this.g.y1(oVar);
            if (!this.u) {
                if (UbsABTestHelper.isConcernForumCardShow() && TbadkCoreApplication.isLogin() && yt4.k().l("key_home_concern_all_status", 0) == 1) {
                    this.w.add(x(this.g, 0, v(R.string.obfuscated_res_0x7f0f02b3)));
                } else {
                    this.w.add(x(this.g, 0, v(R.string.obfuscated_res_0x7f0f130c)));
                }
            }
            if (UbsABTestHelper.isHomeTabModifyABTestA() && !this.u) {
                if (this.i == null) {
                    this.i = new PersonalizeWrapperFragment(context, this.t.f());
                    e(1);
                }
                this.w.add(x(this.i, 1, v(R.string.obfuscated_res_0x7f0f1313)));
                return;
            }
            if (this.h == null) {
                this.h = new PersonalizeFragment(context);
                e(1);
            }
            this.h.A1(lu6Var);
            List<b> list = this.w;
            PersonalizeFragment personalizeFragment = this.h;
            if (this.u) {
                v = v(R.string.obfuscated_res_0x7f0f0265);
            } else {
                v = v(R.string.obfuscated_res_0x7f0f1313);
            }
            list.add(x(personalizeFragment, 1, v));
        }
    }

    public final void k(Context context, List<sx4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, context, list) == null) {
            for (sx4 sx4Var : list) {
                int i = sx4Var.a;
                String str = sx4Var.b;
                String str2 = sx4Var.c;
                boolean z = sx4Var.f;
                if (!sx4Var.e()) {
                    if (i == 101 || i == 201) {
                        HomePageTabFeedFragment homePageTabFeedFragment = new HomePageTabFeedFragment();
                        this.w.add(z(homePageTabFeedFragment, sx4Var));
                        homePageTabFeedFragment.L1(this.u);
                        this.x.put(sx4Var.b, homePageTabFeedFragment);
                    } else if (i == 5) {
                        if (this.j == null) {
                            e(3);
                            HotTopicTabFragment hotTopicTabFragment = new HotTopicTabFragment(context);
                            this.j = hotTopicTabFragment;
                            this.w.add(y(hotTopicTabFragment, i, str, str2, z));
                            this.x.put(sx4Var.b, this.j);
                        }
                    } else if (i == 8) {
                        if (this.m == null) {
                            this.m = new VideoTabFragment();
                            e(5);
                            this.w.add(z(this.m, sx4Var));
                            this.x.put(sx4Var.b, this.m);
                        }
                    } else if (i == 6) {
                        if (this.k == null) {
                            e(4);
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class);
                            if (runTask != null && runTask.getData() != null) {
                                BaseFragment baseFragment = (BaseFragment) runTask.getData();
                                this.k = baseFragment;
                                this.w.add(z(baseFragment, sx4Var));
                            }
                        }
                    } else if (i == 7) {
                        if (this.l == null) {
                            GameVideoFragment gameVideoFragment = new GameVideoFragment();
                            this.l = gameVideoFragment;
                            this.w.add(z(gameVideoFragment, sx4Var));
                            this.x.put(sx4Var.b, this.l);
                            TiebaStatic.log(new StatisticItem("c13483").param("obj_type", "2"));
                        }
                    } else if (i == 202 && !TextUtils.isEmpty(sx4Var.d)) {
                        Fragment tabWebFragment = new TabWebFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("tab_code", str2);
                        bundle.putString("tab_name", str);
                        bundle.putString("tab_url", sx4Var.d);
                        bundle.putInt("tab_type", i);
                        tabWebFragment.setArguments(bundle);
                        this.w.add(z(tabWebFragment, sx4Var));
                    }
                }
            }
        }
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            ge6 ge6Var = this.n;
            if (ge6Var instanceof BaseFragment) {
                return ((BaseFragment) ge6Var).getCurrentPageKey();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.t.e() : invokeV.intValue;
    }

    @Deprecated
    public int n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i)) == null) {
            for (int i2 = 0; i2 < this.v.size(); i2++) {
                if (this.v.get(i2).e == i) {
                    return i2;
                }
            }
            return u();
        }
        return invokeI.intValue;
    }

    public String o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i)) == null) {
            b bVar = (b) ListUtils.getItem(this.v, i);
            return bVar != null ? bVar.d : "";
        }
        return (String) invokeI.objValue;
    }

    public void onPageScrolled(int i, float f, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            int i3 = this.r;
            if (i3 == -1 || (i == i3 && f == 0.0f)) {
                Fragment fragment = (Fragment) ListUtils.getItem(b(), i - 1);
                Fragment fragment2 = (Fragment) ListUtils.getItem(b(), i);
                Fragment fragment3 = (Fragment) ListUtils.getItem(b(), i + 1);
                this.r = -1;
                if (f == 0.0f) {
                    if (fragment instanceof ge6) {
                        ((ge6) fragment).W();
                    }
                    if (fragment3 instanceof ge6) {
                        ((ge6) fragment3).W();
                    }
                    if (fragment2 != null) {
                        fragment2.setMenuVisibility(true);
                        fragment2.setUserVisibleHint(true);
                        return;
                    }
                    return;
                }
                if (fragment instanceof ge6) {
                    ((ge6) fragment).y();
                }
                if (fragment2 instanceof ge6) {
                    ((ge6) fragment2).y();
                }
                if (fragment3 instanceof ge6) {
                    ((ge6) fragment3).y();
                }
            }
        }
    }

    public String p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i)) == null) {
            b bVar = (b) ListUtils.getItem(this.v, i);
            return bVar != null ? bVar.c : v(R.string.obfuscated_res_0x7f0f1313);
        }
        return (String) invokeI.objValue;
    }

    public int q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i)) == null) {
            b bVar = (b) ListUtils.getItem(this.v, i);
            if (bVar != null) {
                return bVar.e;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public void r(ou6 ou6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, ou6Var) == null) || this.q) {
            return;
        }
        this.q = true;
        ou6Var.a(1);
    }

    public int s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
            for (int i = 0; i < this.v.size(); i++) {
                b bVar = this.v.get(i);
                if (!TextUtils.isEmpty(str) && str.equals(bVar.d)) {
                    return i;
                }
            }
            return u();
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048613, this, viewGroup, i, obj) == null) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (obj != null && this.s != i) {
                ge6 ge6Var = this.n;
                if (ge6Var instanceof BaseFragment) {
                    ((BaseFragment) ge6Var).setPrimary(false);
                }
                this.s = i;
                VoiceManager a2 = hk8.a(this.f);
                if (a2 != null) {
                    a2.stopPlay();
                }
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
                if ((obj instanceof PersonalizeFragment) && i == 0) {
                    ((PersonalizeFragment) obj).w();
                }
            }
            if (obj instanceof ge6) {
                this.n = (ge6) obj;
            }
        }
    }

    public int t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) {
            for (int i = 0; i < this.v.size(); i++) {
                b bVar = this.v.get(i);
                if (!TextUtils.isEmpty(str) && str.equals(bVar.c)) {
                    return i;
                }
            }
            return u();
        }
        return invokeL.intValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            for (int i = 0; i < this.v.size(); i++) {
                if (this.v.get(i).e == 1) {
                    return i;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final String v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i)) == null) ? TbadkCoreApplication.getInst().getString(i) : (String) invokeI.objValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.g != null : invokeV.booleanValue;
    }

    public b x(Fragment fragment, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048618, this, fragment, i, str)) == null) ? new b(fragment, i, str) : (b) invokeLIL.objValue;
    }

    public b y(Fragment fragment, int i, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048619, this, new Object[]{fragment, Integer.valueOf(i), str, str2, Boolean.valueOf(z)})) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("tab_code", str2);
            bundle.putString("tab_name", str);
            bundle.putInt("tab_type", i);
            fragment.setArguments(bundle);
            return new b(fragment, i, str, str2, z);
        }
        return (b) invokeCommon.objValue;
    }

    public b z(Fragment fragment, sx4 sx4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048620, this, fragment, sx4Var)) == null) {
            Bundle arguments = fragment.getArguments();
            if (arguments == null) {
                arguments = new Bundle();
            }
            arguments.putString("tab_code", sx4Var.c);
            arguments.putString("tab_name", sx4Var.b);
            arguments.putInt("tab_type", sx4Var.a);
            fragment.setArguments(arguments);
            return new b(fragment, sx4Var.a, sx4Var.d(), sx4Var.b, sx4Var.c);
        }
        return (b) invokeLL.objValue;
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Fragment a;
        public String b;
        public String c;
        public String d;
        public int e;

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
            this.e = i;
            this.b = str;
            this.c = str;
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
            this.e = i;
            this.b = str2;
            this.b = str;
            this.c = str2;
            this.d = str3;
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
            this.e = i;
            this.b = str;
            this.c = str;
            this.d = str2;
        }
    }
}
