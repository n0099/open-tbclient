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
import com.baidu.tieba.ay6;
import com.baidu.tieba.bx4;
import com.baidu.tieba.homepage.concern.ConcernFragment;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.gamevideo.GameVideoFragment;
import com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment;
import com.baidu.tieba.homepage.personalize.PersonalizeFragment;
import com.baidu.tieba.homepage.personalize.PersonalizeWrapperFragment;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.homepage.tabfeed.h5.TabWebFragment;
import com.baidu.tieba.homepage.video.VideoTabFragment;
import com.baidu.tieba.jf;
import com.baidu.tieba.mo8;
import com.baidu.tieba.qh5;
import com.baidu.tieba.uh5;
import com.baidu.tieba.ux6;
import com.baidu.tieba.vh6;
import com.baidu.tieba.vx6;
import com.baidu.tieba.x05;
import com.baidu.tieba.xx6;
import com.baidu.tieba.zt4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
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
    public vh6 n;
    public String o;
    public String p;
    public boolean q;
    public int r;
    public int s;
    public ay6 t;
    public boolean u;
    public List<b> v;
    public List<b> w;
    public HashMap<String, BaseFragment> x;

    /* loaded from: classes4.dex */
    public class a extends qh5<Object> {
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

        @Override // com.baidu.tieba.qh5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                zt4.f();
                jf<String> h = zt4.h(this.b.o, TbadkCoreApplication.getCurrentAccount());
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
    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, boolean z, ux6 ux6Var, ConcernPageView.o oVar) {
        super(fragmentManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, fragmentManager, Boolean.valueOf(z), ux6Var, oVar};
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
            this.t = new ay6();
        }
        List<x05> f = this.u ? this.t.f() : this.t.h();
        this.w.clear();
        this.x.clear();
        j(context, ux6Var, oVar);
        k(context, f);
        f();
        Q();
        notifyDataSetChanged();
    }

    public b A(Fragment fragment, x05 x05Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fragment, x05Var)) == null) {
            Bundle arguments = fragment.getArguments();
            if (arguments == null) {
                arguments = new Bundle();
            }
            arguments.putString("tab_code", x05Var.c);
            arguments.putString("tab_name", x05Var.b);
            arguments.putInt("tab_type", x05Var.a);
            fragment.setArguments(arguments);
            return new b(fragment, x05Var.a, x05Var.d(), x05Var.b, x05Var.c);
        }
        return (b) invokeLL.objValue;
    }

    public void B(String str) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
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

    public void C(int i) {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && i == 1 && (personalizeFragment = this.h) != null) {
            personalizeFragment.w1();
        }
    }

    public void D(int i) {
        vh6 vh6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || (vh6Var = this.n) == null) {
            return;
        }
        vh6Var.b0();
    }

    public void E() {
        vh6 vh6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (vh6Var = this.n) == null) {
            return;
        }
        vh6Var.t();
    }

    public void F() {
        List<b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (list = this.w) == null) {
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
        ay6 ay6Var = this.t;
        if (ay6Var == null) {
            this.t = new ay6();
        } else {
            ay6Var.k();
        }
        k(this.f, this.u ? this.t.f() : this.t.h());
        f();
        Q();
    }

    public void G(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            uh5.b(new a(this, i), null);
        }
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (this.n instanceof BaseFragment)) {
            if (!z) {
                int position = ListUtils.getPosition(b(), (BaseFragment) this.n);
                if (position < 0) {
                    position = o(1);
                }
                G(position);
                g();
            }
            ((BaseFragment) this.n).setPrimary(z);
        }
    }

    public void I(vx6 vx6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vx6Var) == null) {
            PersonalizeFragment personalizeFragment = this.h;
            if (personalizeFragment != null) {
                personalizeFragment.z1(vx6Var);
            }
            if (vx6Var instanceof ScrollFragmentTabHost) {
                ScrollFragmentTabHost scrollFragmentTabHost = (ScrollFragmentTabHost) vx6Var;
                HotTopicTabFragment hotTopicTabFragment = this.j;
                if (hotTopicTabFragment != null) {
                    hotTopicTabFragment.z1(scrollFragmentTabHost);
                }
                ConcernFragment concernFragment = this.g;
                if (concernFragment != null) {
                    concernFragment.x1(scrollFragmentTabHost);
                }
            }
        }
    }

    public void K(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            if (this.s == i) {
                this.r = -1;
            } else {
                this.r = i;
            }
        }
    }

    public void L(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
        }
    }

    public void M(boolean z) {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (personalizeFragment = this.h) == null) {
            return;
        }
        personalizeFragment.B1(z);
    }

    public void N() {
        ConcernFragment concernFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (concernFragment = this.g) == null) {
            return;
        }
        concernFragment.z1();
    }

    public void O(DataRes dataRes, boolean z) {
        ConcernFragment concernFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048589, this, dataRes, z) == null) || (concernFragment = this.g) == null) {
            return;
        }
        concernFragment.A1(dataRes, z);
    }

    public void P(String str, int i, int i2) {
        ConcernFragment concernFragment;
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048590, this, str, i, i2) == null) {
            if (i2 == 1 && (personalizeFragment = this.h) != null) {
                personalizeFragment.D1(str, i);
            }
            if (i2 != 0 || (concernFragment = this.g) == null) {
                return;
            }
            concernFragment.B1(str, i);
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.v.clear();
            for (b bVar : this.w) {
                this.v.add(bVar);
            }
        }
    }

    public void R(tbclient.Personalized.DataRes dataRes, boolean z, boolean z2) {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (personalizeFragment = this.h) == null) {
            return;
        }
        personalizeFragment.C1(dataRes, z, z2);
    }

    public void S() {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (personalizeFragment = this.h) == null) {
            return;
        }
        personalizeFragment.v1();
    }

    public final void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (list = this.w) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            PersonalizeFragment personalizeFragment = this.h;
            if (personalizeFragment != null && this.n == personalizeFragment) {
                personalizeFragment.u1();
            }
            ConcernFragment concernFragment = this.g;
            if (concernFragment == null || this.n != concernFragment) {
                return;
            }
            concernFragment.t1();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, obj)) == null) ? (b() == null || !b().contains(obj)) ? -2 : -1 : invokeL.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            ay6 ay6Var = this.t;
            if (ay6Var == null) {
                return false;
            }
            return ay6Var.c();
        }
        return invokeV.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            Fragment item = getItem(this.s);
            if (item instanceof vh6) {
                ((vh6) item).t();
            }
        }
    }

    public final void j(Context context, ux6 ux6Var, ConcernPageView.o oVar) {
        String w;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048603, this, context, ux6Var, oVar) == null) {
            if (this.g == null) {
                this.g = new ConcernFragment(context);
                e(2);
            }
            this.g.w1(oVar);
            if (!this.u) {
                if (UbsABTestHelper.isConcernForumCardShow() && TbadkCoreApplication.isLogin() && bx4.k().l("key_home_concern_all_status", 0) == 1) {
                    this.w.add(y(this.g, 0, w(R.string.obfuscated_res_0x7f0f02bc)));
                } else {
                    this.w.add(y(this.g, 0, w(R.string.obfuscated_res_0x7f0f136b)));
                }
            }
            if (UbsABTestHelper.isHomeTabModifyABTestA() && !this.u) {
                if (this.i == null) {
                    this.i = new PersonalizeWrapperFragment(context, this.t.f());
                    e(1);
                }
                this.w.add(y(this.i, 1, w(R.string.obfuscated_res_0x7f0f1372)));
                return;
            }
            if (this.h == null) {
                this.h = new PersonalizeFragment(context);
                e(1);
            }
            this.h.x1(ux6Var);
            List<b> list = this.w;
            PersonalizeFragment personalizeFragment = this.h;
            if (this.u) {
                w = w(R.string.obfuscated_res_0x7f0f026d);
            } else {
                w = w(R.string.obfuscated_res_0x7f0f1372);
            }
            list.add(y(personalizeFragment, 1, w));
        }
    }

    public final void k(Context context, List<x05> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, context, list) == null) {
            for (x05 x05Var : list) {
                int i = x05Var.a;
                String str = x05Var.b;
                String str2 = x05Var.c;
                boolean z = x05Var.f;
                if (!x05Var.e()) {
                    if (i == 101 || i == 201) {
                        HomePageTabFeedFragment homePageTabFeedFragment = new HomePageTabFeedFragment();
                        this.w.add(A(homePageTabFeedFragment, x05Var));
                        homePageTabFeedFragment.J1(this.u);
                        this.x.put(x05Var.b, homePageTabFeedFragment);
                    } else if (i == 5) {
                        if (this.j == null) {
                            e(3);
                            HotTopicTabFragment hotTopicTabFragment = new HotTopicTabFragment(context);
                            this.j = hotTopicTabFragment;
                            this.w.add(z(hotTopicTabFragment, i, str, str2, z));
                            this.x.put(x05Var.b, this.j);
                        }
                    } else if (i == 8) {
                        if (this.m == null) {
                            this.m = new VideoTabFragment();
                            e(5);
                            this.w.add(A(this.m, x05Var));
                            this.x.put(x05Var.b, this.m);
                        }
                    } else if (i == 6) {
                        if (this.k == null) {
                            e(4);
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class);
                            if (runTask != null && runTask.getData() != null) {
                                BaseFragment baseFragment = (BaseFragment) runTask.getData();
                                this.k = baseFragment;
                                this.w.add(A(baseFragment, x05Var));
                            }
                        }
                    } else if (i == 7) {
                        if (this.l == null) {
                            GameVideoFragment gameVideoFragment = new GameVideoFragment();
                            this.l = gameVideoFragment;
                            this.w.add(A(gameVideoFragment, x05Var));
                            this.x.put(x05Var.b, this.l);
                            TiebaStatic.log(new StatisticItem("c13483").param("obj_type", "2"));
                        }
                    } else if (i == 202 && !TextUtils.isEmpty(x05Var.d)) {
                        Fragment tabWebFragment = new TabWebFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("tab_code", str2);
                        bundle.putString("tab_name", str);
                        bundle.putString("tab_url", x05Var.d);
                        bundle.putInt("tab_type", i);
                        tabWebFragment.setArguments(bundle);
                        this.w.add(A(tabWebFragment, x05Var));
                    }
                }
            }
        }
    }

    public vh6 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.n : (vh6) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            vh6 vh6Var = this.n;
            if (vh6Var instanceof BaseFragment) {
                return ((BaseFragment) vh6Var).getCurrentPageKey();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.t.e() : invokeV.intValue;
    }

    @Deprecated
    public int o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i)) == null) {
            for (int i2 = 0; i2 < this.v.size(); i2++) {
                if (this.v.get(i2).e == i) {
                    return i2;
                }
            }
            return v();
        }
        return invokeI.intValue;
    }

    public void onPageScrolled(int i, float f, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            int i3 = this.r;
            if (i3 == -1 || (i == i3 && f == 0.0f)) {
                Fragment fragment = (Fragment) ListUtils.getItem(b(), i - 1);
                Fragment fragment2 = (Fragment) ListUtils.getItem(b(), i);
                Fragment fragment3 = (Fragment) ListUtils.getItem(b(), i + 1);
                this.r = -1;
                if (f == 0.0f) {
                    if (fragment instanceof vh6) {
                        ((vh6) fragment).W();
                    }
                    if (fragment3 instanceof vh6) {
                        ((vh6) fragment3).W();
                    }
                    if (fragment2 != null) {
                        fragment2.setMenuVisibility(true);
                        fragment2.setUserVisibleHint(true);
                        return;
                    }
                    return;
                }
                if (fragment instanceof vh6) {
                    ((vh6) fragment).y();
                }
                if (fragment2 instanceof vh6) {
                    ((vh6) fragment2).y();
                }
                if (fragment3 instanceof vh6) {
                    ((vh6) fragment3).y();
                }
            }
        }
    }

    public String p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i)) == null) {
            b bVar = (b) ListUtils.getItem(this.v, i);
            return bVar != null ? bVar.d : "";
        }
        return (String) invokeI.objValue;
    }

    public String q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) {
            b bVar = (b) ListUtils.getItem(this.v, i);
            return bVar != null ? bVar.c : w(R.string.obfuscated_res_0x7f0f1372);
        }
        return (String) invokeI.objValue;
    }

    public int r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i)) == null) {
            b bVar = (b) ListUtils.getItem(this.v, i);
            if (bVar != null) {
                return bVar.e;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public void s(xx6 xx6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, xx6Var) == null) || this.q) {
            return;
        }
        this.q = true;
        xx6Var.a(1);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048614, this, viewGroup, i, obj) == null) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (obj != null && this.s != i) {
                vh6 vh6Var = this.n;
                if (vh6Var instanceof BaseFragment) {
                    ((BaseFragment) vh6Var).setPrimary(false);
                }
                this.s = i;
                VoiceManager a2 = mo8.a(this.f);
                if (a2 != null) {
                    a2.stopPlay();
                }
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
                if ((obj instanceof PersonalizeFragment) && i == 0) {
                    ((PersonalizeFragment) obj).x();
                }
            }
            if (obj instanceof vh6) {
                this.n = (vh6) obj;
            }
        }
    }

    public int t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, str)) == null) {
            for (int i = 0; i < this.v.size(); i++) {
                b bVar = this.v.get(i);
                if (!TextUtils.isEmpty(str) && str.equals(bVar.d)) {
                    return i;
                }
            }
            return v();
        }
        return invokeL.intValue;
    }

    public int u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, str)) == null) {
            for (int i = 0; i < this.v.size(); i++) {
                b bVar = this.v.get(i);
                if (!TextUtils.isEmpty(str) && str.equals(bVar.c)) {
                    return i;
                }
            }
            return v();
        }
        return invokeL.intValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            for (int i = 0; i < this.v.size(); i++) {
                if (this.v.get(i).e == 1) {
                    return i;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final String w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048618, this, i)) == null) ? TbadkCoreApplication.getInst().getString(i) : (String) invokeI.objValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.g != null : invokeV.booleanValue;
    }

    public b y(Fragment fragment, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048620, this, fragment, i, str)) == null) ? new b(fragment, i, str) : (b) invokeLIL.objValue;
    }

    public b z(Fragment fragment, int i, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048621, this, new Object[]{fragment, Integer.valueOf(i), str, str2, Boolean.valueOf(z)})) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("tab_code", str2);
            bundle.putString("tab_name", str);
            bundle.putInt("tab_type", i);
            fragment.setArguments(bundle);
            return new b(fragment, i, str, str2, z);
        }
        return (b) invokeCommon.objValue;
    }

    /* loaded from: classes4.dex */
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
