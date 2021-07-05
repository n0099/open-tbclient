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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.d.l;
import d.a.r0.b.d;
import d.a.r0.c1.b.e;
import d.a.r0.s.c.y;
import d.a.r0.z0.b0;
import d.a.r0.z0.f0;
import d.a.r0.z0.i0;
import d.a.s0.u0.n0;
import java.util.ArrayList;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes5.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public Context f16536f;

    /* renamed from: g  reason: collision with root package name */
    public ConcernFragment f16537g;

    /* renamed from: h  reason: collision with root package name */
    public PersonalizeFragment f16538h;

    /* renamed from: i  reason: collision with root package name */
    public HotTopicTabFragment f16539i;
    public BaseFragment j;
    public GameVideoFragment k;
    public VideoTabFragment l;
    public n0 m;
    public String n;
    public String o;
    public boolean p;
    public int q;
    public b0 r;
    public int s;
    public d.a.s0.e1.d.f.a t;
    public List<b> u;
    public List<b> v;

    /* loaded from: classes5.dex */
    public class a extends f0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f16540a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NewScrollFragmentAdapter f16541b;

        public a(NewScrollFragmentAdapter newScrollFragmentAdapter, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newScrollFragmentAdapter, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16541b = newScrollFragmentAdapter;
            this.f16540a = i2;
        }

        @Override // d.a.r0.z0.f0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                l<String> h2 = d.a.r0.r.r.a.f().h(this.f16541b.n, TbadkCoreApplication.getCurrentAccount());
                if (h2 != null) {
                    h2.e(this.f16541b.o, Integer.toString(this.f16540a), 43200000L);
                    return null;
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, d.a.s0.e1.d.b bVar, ConcernPageView.l lVar) {
        super(fragmentManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, fragmentManager, bVar, lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.s = -1;
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.f16536f = context;
        if (this.t == null) {
            this.t = new d.a.s0.e1.d.f.a();
        }
        List<y> b2 = this.t.b();
        this.v.clear();
        if (this.f16537g == null) {
            this.f16537g = new ConcernFragment(context);
            i(2);
        }
        this.f16537g.M0(lVar);
        if (d.h() && TbadkCoreApplication.isLogin() && d.a.r0.r.d0.b.j().k("key_home_concern_all_status", 0) == 1) {
            this.v.add(w(this.f16537g, 0, t(R.string.attention_person)));
        } else {
            this.v.add(w(this.f16537g, 0, t(R.string.tab_name_concern)));
        }
        if (this.f16538h == null) {
            this.f16538h = new PersonalizeFragment(context);
            i(1);
        }
        this.f16538h.N0(bVar);
        this.v.add(w(this.f16538h, 1, t(R.string.tab_name_recommend)));
        for (y yVar : b2) {
            int i4 = yVar.f56468a;
            String str = yVar.f56469b;
            String str2 = yVar.f56470c;
            boolean z = yVar.f56473f;
            if (!yVar.a()) {
                if (i4 == 101 || i4 == 201) {
                    Fragment homePageTabFeedFragment = new HomePageTabFeedFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString(LowFlowsActivityConfig.TAB_CODE, str2);
                    bundle.putString("tab_name", str);
                    bundle.putInt("tab_type", i4);
                    homePageTabFeedFragment.setArguments(bundle);
                    this.v.add(y(homePageTabFeedFragment, yVar));
                } else if (i4 == 5) {
                    if (this.f16539i == null) {
                        i(3);
                        HotTopicTabFragment hotTopicTabFragment = new HotTopicTabFragment(context);
                        this.f16539i = hotTopicTabFragment;
                        this.v.add(x(hotTopicTabFragment, i4, str, z));
                    }
                } else if (i4 == 8) {
                    if (this.l == null) {
                        this.l = new VideoTabFragment();
                        i(5);
                        this.v.add(y(this.l, yVar));
                    }
                } else if (i4 == 6) {
                    if (this.j == null) {
                        i(4);
                        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class);
                        if (runTask != null && runTask.getData() != null) {
                            BaseFragment baseFragment = (BaseFragment) runTask.getData();
                            this.j = baseFragment;
                            this.v.add(y(baseFragment, yVar));
                        }
                    }
                } else if (i4 == 7) {
                    if (this.k == null) {
                        GameVideoFragment gameVideoFragment = new GameVideoFragment();
                        this.k = gameVideoFragment;
                        this.v.add(y(gameVideoFragment, yVar));
                        TiebaStatic.log(new StatisticItem("c13483").param("obj_type", "2"));
                    }
                } else if (i4 == 202 && !TextUtils.isEmpty(yVar.f56471d)) {
                    Fragment tabWebFragment = new TabWebFragment();
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(LowFlowsActivityConfig.TAB_CODE, str2);
                    bundle2.putString("tab_name", str);
                    bundle2.putString("tab_url", yVar.f56471d);
                    bundle2.putInt("tab_type", i4);
                    tabWebFragment.setArguments(bundle2);
                    this.v.add(y(tabWebFragment, yVar));
                }
            }
        }
        O();
        notifyDataSetChanged();
    }

    public void A(int i2) {
        n0 n0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (n0Var = this.m) == null) {
            return;
        }
        n0Var.G();
    }

    public void B() {
        n0 n0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (n0Var = this.m) == null) {
            return;
        }
        n0Var.p();
    }

    public void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            i0.b(new a(this, i2), null);
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (this.m instanceof BaseFragment)) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, scrollFragmentTabHost) == null) {
            PersonalizeFragment personalizeFragment = this.f16538h;
            if (personalizeFragment != null) {
                personalizeFragment.O0(scrollFragmentTabHost);
            }
            HotTopicTabFragment hotTopicTabFragment = this.f16539i;
            if (hotTopicTabFragment != null) {
                hotTopicTabFragment.N0(scrollFragmentTabHost);
            }
            ConcernFragment concernFragment = this.f16537g;
            if (concernFragment != null) {
                concernFragment.N0(scrollFragmentTabHost);
            }
        }
    }

    public void I(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (this.s == i2) {
                this.q = -1;
            } else {
                this.q = i2;
            }
        }
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    public void K() {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (personalizeFragment = this.f16538h) == null) {
            return;
        }
        personalizeFragment.R0();
    }

    public void L() {
        ConcernFragment concernFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (concernFragment = this.f16537g) == null) {
            return;
        }
        concernFragment.O0();
    }

    public void M(DataRes dataRes, boolean z) {
        ConcernFragment concernFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048585, this, dataRes, z) == null) || (concernFragment = this.f16537g) == null) {
            return;
        }
        concernFragment.P0(dataRes, z);
    }

    public void N(String str, int i2, int i3) {
        ConcernFragment concernFragment;
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048586, this, str, i2, i3) == null) {
            if (i3 == 1 && (personalizeFragment = this.f16538h) != null && this.m == personalizeFragment) {
                personalizeFragment.T0(str, i2);
            }
            if (i3 != 0 || (concernFragment = this.f16537g) == null) {
                return;
            }
            concernFragment.Q0(str, i2);
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.u.clear();
            boolean d2 = e.d();
            for (b bVar : this.v) {
                if (d2) {
                    Fragment fragment = bVar.f16542a;
                    if (fragment == this.f16537g || fragment == this.f16538h) {
                        this.u.add(bVar);
                    }
                } else {
                    this.u.add(bVar);
                }
            }
        }
    }

    public void P(tbclient.Personalized.DataRes dataRes, boolean z, boolean z2) {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (personalizeFragment = this.f16538h) == null) {
            return;
        }
        personalizeFragment.S0(dataRes, z, z2);
    }

    public void Q() {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (personalizeFragment = this.f16538h) == null) {
            return;
        }
        personalizeFragment.L0();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            List<b> list = this.u;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            List<b> list = this.u;
            if (list == null || i2 < 0 || i2 >= list.size() || this.u.get(i2) == null) {
                return null;
            }
            return this.u.get(i2).f16542a;
        }
        return (Fragment) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, obj)) == null) ? (e() == null || !e().contains(obj)) ? -2 : -1 : invokeL.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            List<b> list = this.u;
            if (list == null || i2 < 0 || i2 >= list.size() || this.u.get(i2) == null) {
                return null;
            }
            return this.u.get(i2).f16543b;
        }
        return (CharSequence) invokeI.objValue;
    }

    public final void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LIVE_TAB_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_type", i2);
            TiebaStaticHelper.addYYParam(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            PersonalizeFragment personalizeFragment = this.f16538h;
            if (personalizeFragment != null && this.m == personalizeFragment) {
                personalizeFragment.K0();
            }
            ConcernFragment concernFragment = this.f16537g;
            if (concernFragment == null || this.m != concernFragment) {
                return;
            }
            concernFragment.J0();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            Fragment item = getItem(this.s);
            if (item instanceof n0) {
                ((n0) item).p();
            }
        }
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            n0 n0Var = this.m;
            if (n0Var instanceof BaseFragment) {
                return ((BaseFragment) n0Var).getCurrentPageKey();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.t.a() : invokeV.intValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            for (int i2 = 0; i2 < this.u.size(); i2++) {
                if (this.u.get(i2).f16545d == 5) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Deprecated
    public int o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            for (int i3 = 0; i3 < this.u.size(); i3++) {
                if (this.u.get(i3).f16545d == i2) {
                    return i3;
                }
            }
            return s();
        }
        return invokeI.intValue;
    }

    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            int i4 = this.q;
            if (i4 == -1 || (i2 == i4 && f2 == 0.0f)) {
                Fragment fragment = (Fragment) ListUtils.getItem(e(), i2 - 1);
                Fragment fragment2 = (Fragment) ListUtils.getItem(e(), i2);
                Fragment fragment3 = (Fragment) ListUtils.getItem(e(), i2 + 1);
                this.q = -1;
                if (f2 == 0.0f) {
                    if (fragment instanceof n0) {
                        ((n0) fragment).B();
                    }
                    if (fragment3 instanceof n0) {
                        ((n0) fragment3).B();
                    }
                    if (fragment2 != null) {
                        fragment2.setMenuVisibility(true);
                        fragment2.setUserVisibleHint(true);
                        return;
                    }
                    return;
                }
                if (fragment instanceof n0) {
                    ((n0) fragment).t();
                }
                if (fragment2 instanceof n0) {
                    ((n0) fragment2).t();
                }
                if (fragment3 instanceof n0) {
                    ((n0) fragment3).t();
                }
            }
        }
    }

    public int p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
            b bVar = (b) ListUtils.getItem(this.u, i2);
            if (bVar != null) {
                return bVar.f16545d;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public void q(d.a.s0.e1.d.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, dVar) == null) || this.p) {
            return;
        }
        this.p = true;
        dVar.a(1);
    }

    public int r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            for (int i2 = 0; i2 < this.u.size(); i2++) {
                b bVar = this.u.get(i2);
                if (!TextUtils.isEmpty(str) && str.equals(bVar.f16544c)) {
                    return i2;
                }
            }
            return s();
        }
        return invokeL.intValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            for (int i2 = 0; i2 < this.u.size(); i2++) {
                if (this.u.get(i2).f16545d == 1) {
                    return i2;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048606, this, viewGroup, i2, obj) == null) {
            super.setPrimaryItem(viewGroup, i2, obj);
            if (obj != null && this.s != i2) {
                n0 n0Var = this.m;
                if (n0Var instanceof BaseFragment) {
                    ((BaseFragment) n0Var).setPrimary(false);
                }
                this.s = i2;
                VoiceManager a2 = d.a.s0.h3.p0.b.a(this.f16536f);
                if (a2 != null) {
                    a2.stopPlay();
                }
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
                if ((obj instanceof PersonalizeFragment) && i2 == 0) {
                    ((PersonalizeFragment) obj).s();
                }
                if (obj instanceof n0) {
                    ((n0) obj).r();
                }
            }
            if (obj instanceof n0) {
                n0 n0Var2 = (n0) obj;
                this.m = n0Var2;
                n0Var2.x(this.r);
            }
        }
    }

    public final String t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) ? TbadkCoreApplication.getInst().getString(i2) : (String) invokeI.objValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f16537g != null : invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f16539i != null : invokeV.booleanValue;
    }

    public b w(Fragment fragment, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048610, this, fragment, i2, str)) == null) ? new b(fragment, i2, str) : (b) invokeLIL.objValue;
    }

    public b x(Fragment fragment, int i2, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048611, this, new Object[]{fragment, Integer.valueOf(i2), str, Boolean.valueOf(z)})) == null) ? new b(fragment, i2, str, z) : (b) invokeCommon.objValue;
    }

    public b y(Fragment fragment, y yVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, fragment, yVar)) == null) ? new b(fragment, yVar.f56468a, yVar.f56469b) : (b) invokeLL.objValue;
    }

    public void z(int i2) {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048613, this, i2) == null) && i2 == 1 && (personalizeFragment = this.f16538h) != null) {
            personalizeFragment.M0();
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Fragment f16542a;

        /* renamed from: b  reason: collision with root package name */
        public String f16543b;

        /* renamed from: c  reason: collision with root package name */
        public String f16544c;

        /* renamed from: d  reason: collision with root package name */
        public int f16545d;

        public b(Fragment fragment, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragment, Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16542a = fragment;
            this.f16545d = i2;
            this.f16543b = str;
            this.f16544c = str;
        }

        public b(Fragment fragment, int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragment, Integer.valueOf(i2), str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f16542a = fragment;
            this.f16545d = i2;
            this.f16543b = str;
            this.f16544c = str;
        }
    }
}
