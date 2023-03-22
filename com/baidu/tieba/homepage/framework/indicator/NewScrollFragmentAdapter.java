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
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.aq5;
import com.baidu.tieba.ce7;
import com.baidu.tieba.h75;
import com.baidu.tieba.homepage.concern.ConcernFragment;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.gamevideo.GameVideoFragment;
import com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment;
import com.baidu.tieba.homepage.personalize.PersonalizeFragment;
import com.baidu.tieba.homepage.personalize.PersonalizeWrapperFragment;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.homepage.tabfeed.h5.TabWebFragment;
import com.baidu.tieba.homepage.video.VideoTabFragment;
import com.baidu.tieba.kx6;
import com.baidu.tieba.m35;
import com.baidu.tieba.me;
import com.baidu.tieba.me9;
import com.baidu.tieba.ud9;
import com.baidu.tieba.wd7;
import com.baidu.tieba.wp5;
import com.baidu.tieba.xd7;
import com.baidu.tieba.yz4;
import com.baidu.tieba.zd7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.DataRes;
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
    public kx6 n;
    public String o;
    public String p;
    public boolean q;
    public int r;
    public int s;
    public ce7 t;
    public boolean u;
    public List<b> v;
    public List<b> w;
    public HashMap<String, BaseFragment> x;

    public void P(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a extends wp5<Object> {
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

        @Override // com.baidu.tieba.wp5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                yz4.d();
                me<String> f = yz4.f(this.b.o, TbadkCoreApplication.getCurrentAccount());
                if (f != null) {
                    f.e(this.b.p, Integer.toString(this.a), com.heytap.mcssdk.constant.a.g);
                    return null;
                }
                return null;
            }
            return invokeV.objValue;
        }
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, boolean z, wd7 wd7Var, ConcernPageView.o oVar) {
        super(fragmentManager);
        List<h75> h;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, fragmentManager, Boolean.valueOf(z), wd7Var, oVar};
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
        me9.a("NewScrollFragmentAdapter init:" + z);
        this.f = context;
        this.u = z;
        if (this.t == null) {
            this.t = new ce7();
        }
        if (this.u) {
            h = this.t.f();
        } else {
            h = this.t.h();
        }
        this.w.clear();
        this.x.clear();
        k(context, wd7Var, oVar);
        l(context, h);
        f();
        U();
        notifyDataSetChanged();
    }

    public final String A(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return TbadkCoreApplication.getInst().getString(i);
        }
        return (String) invokeI.objValue;
    }

    public void G(int i) {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && i == 1 && (personalizeFragment = this.h) != null) {
            personalizeFragment.K1();
        }
    }

    public void H(int i) {
        kx6 kx6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (kx6Var = this.n) != null) {
            kx6Var.Z();
        }
    }

    public void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            aq5.b(new a(this, i), null);
        }
    }

    public void N(xd7 xd7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, xd7Var) == null) {
            PersonalizeFragment personalizeFragment = this.h;
            if (personalizeFragment != null) {
                personalizeFragment.M1(xd7Var);
            }
            if (xd7Var instanceof ScrollFragmentTabHost) {
                ScrollFragmentTabHost scrollFragmentTabHost = (ScrollFragmentTabHost) xd7Var;
                HotTopicTabFragment hotTopicTabFragment = this.j;
                if (hotTopicTabFragment != null) {
                    hotTopicTabFragment.I1(scrollFragmentTabHost);
                }
                ConcernFragment concernFragment = this.g;
                if (concernFragment != null) {
                    concernFragment.L1(scrollFragmentTabHost);
                }
            }
        }
    }

    public void O(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            if (this.s == i) {
                this.r = -1;
            } else {
                this.r = i;
            }
        }
    }

    public void Q(boolean z) {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && (personalizeFragment = this.h) != null) {
            personalizeFragment.O1(z);
        }
    }

    public final void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LIVE_TAB_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_type", i);
            TiebaStaticHelper.addYYParam(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, obj)) == null) {
            if (h(obj)) {
                return -1;
            }
            return -2;
        }
        return invokeL.intValue;
    }

    @Deprecated
    public int q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i)) == null) {
            for (int i2 = 0; i2 < this.v.size(); i2++) {
                if (this.v.get(i2).e == i) {
                    return i2;
                }
            }
            return z();
        }
        return invokeI.intValue;
    }

    public String r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i)) == null) {
            b bVar = (b) ListUtils.getItem(this.v, i);
            if (bVar != null) {
                return bVar.d;
            }
            return "";
        }
        return (String) invokeI.objValue;
    }

    public String s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i)) == null) {
            b bVar = (b) ListUtils.getItem(this.v, i);
            if (bVar != null) {
                return bVar.c;
            }
            return A(R.string.obfuscated_res_0x7f0f144b);
        }
        return (String) invokeI.objValue;
    }

    public int t(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048619, this, i)) == null) {
            b bVar = (b) ListUtils.getItem(this.v, i);
            if (bVar != null) {
                return bVar.e;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public void u(zd7 zd7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, zd7Var) != null) || this.q) {
            return;
        }
        this.q = true;
        zd7Var.a(1);
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.g != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void I() {
        kx6 kx6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (kx6Var = this.n) != null) {
            kx6Var.q();
        }
    }

    public void R() {
        ConcernFragment concernFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (concernFragment = this.g) != null) {
            concernFragment.M1();
        }
    }

    public void W() {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (personalizeFragment = this.h) != null) {
            personalizeFragment.J1();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            PersonalizeFragment personalizeFragment = this.h;
            if (personalizeFragment != null && this.n == personalizeFragment) {
                personalizeFragment.I1();
            }
            ConcernFragment concernFragment = this.g;
            if (concernFragment != null && this.n == concernFragment) {
                concernFragment.H1();
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            List<b> list = this.v;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            ce7 ce7Var = this.t;
            if (ce7Var == null) {
                return false;
            }
            return ce7Var.c();
        }
        return invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            Fragment item = getItem(this.s);
            if (item instanceof kx6) {
                ((kx6) item).q();
            }
        }
    }

    public kx6 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.n;
        }
        return (kx6) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            kx6 kx6Var = this.n;
            if (kx6Var instanceof BaseFragment) {
                return ((BaseFragment) kx6Var).getCurrentPageKey();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.t.e();
        }
        return invokeV.intValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            for (int i = 0; i < this.v.size(); i++) {
                if (this.v.get(i).e == 5) {
                    return i;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            for (int i = 0; i < this.v.size(); i++) {
                if (this.v.get(i).e == 1) {
                    return i;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public b C(Fragment fragment, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, fragment, i, str)) == null) {
            return new b(fragment, i, str);
        }
        return (b) invokeLIL.objValue;
    }

    public void T(String str, int i, int i2) {
        ConcernFragment concernFragment;
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048594, this, str, i, i2) == null) {
            if (i2 == 1 && (personalizeFragment = this.h) != null) {
                personalizeFragment.Q1(str, i);
            }
            if (i2 == 0 && (concernFragment = this.g) != null) {
                concernFragment.O1(str, i);
            }
        }
    }

    public void V(DataRes dataRes, boolean z, boolean z2) {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (personalizeFragment = this.h) != null) {
            personalizeFragment.P1(dataRes, z, z2);
        }
    }

    public b D(Fragment fragment, int i, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{fragment, Integer.valueOf(i), str, str2, Boolean.valueOf(z)})) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("tab_code", str2);
            bundle.putString("tab_name", str);
            bundle.putInt("tab_type", i);
            fragment.setArguments(bundle);
            return new b(fragment, i, str, str2, z);
        }
        return (b) invokeCommon.objValue;
    }

    public b E(Fragment fragment, h75 h75Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, fragment, h75Var)) == null) {
            Bundle arguments = fragment.getArguments();
            if (arguments == null) {
                arguments = new Bundle();
            }
            arguments.putString("tab_code", h75Var.c);
            arguments.putString("tab_name", h75Var.b);
            arguments.putInt("tab_type", h75Var.a);
            fragment.setArguments(arguments);
            return new b(fragment, h75Var.a, h75Var.d(), h75Var.b, h75Var.c);
        }
        return (b) invokeLL.objValue;
    }

    public void F(String str) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
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
            if (c != 0) {
                if (c != 1) {
                    if (this.x.containsKey(str)) {
                        this.x.get(str).notifyColourHeaderData();
                        return;
                    }
                    return;
                }
                ConcernFragment concernFragment = this.g;
                if (concernFragment != null) {
                    concernFragment.notifyColourHeaderData();
                    return;
                }
                return;
            }
            PersonalizeFragment personalizeFragment = this.h;
            if (personalizeFragment != null) {
                personalizeFragment.notifyColourHeaderData();
            }
        }
    }

    public void J() {
        List<b> list;
        List<h75> h;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || (list = this.w) == null) {
            return;
        }
        Iterator<b> it = list.iterator();
        while (it.hasNext()) {
            Fragment fragment = it.next().a;
            if (!(fragment instanceof ConcernFragment) && !(fragment instanceof PersonalizeWrapperFragment) && !(fragment instanceof HotTopicTabFragment)) {
                it.remove();
            }
        }
        this.k = null;
        this.l = null;
        this.m = null;
        ce7 ce7Var = this.t;
        if (ce7Var == null) {
            this.t = new ce7();
        } else {
            ce7Var.k();
        }
        if (this.u) {
            h = this.t.f();
        } else {
            h = this.t.h();
        }
        l(this.f, h);
        f();
        U();
        notifyDataSetChanged();
        kx6 kx6Var = this.n;
        if (kx6Var instanceof TabWebFragment) {
            kx6Var.q();
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (this.n instanceof BaseFragment)) {
            if (!z) {
                int position = ListUtils.getPosition(b(), (BaseFragment) this.n);
                if (position < 0) {
                    position = q(1);
                }
                L(position);
                g();
            }
            ((BaseFragment) this.n).setPrimary(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i)) == null) {
            List<b> list = this.v;
            if (list != null && i >= 0 && i < list.size() && this.v.get(i) != null) {
                return this.v.get(i).a;
            }
            return null;
        }
        return (Fragment) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
            List<b> list = this.v;
            if (list != null && i >= 0 && i < list.size() && this.v.get(i) != null) {
                return this.v.get(i).b;
            }
            return null;
        }
        return (CharSequence) invokeI.objValue;
    }

    public final boolean h(@NonNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, obj)) == null) {
            if (ListUtils.isEmpty(this.v)) {
                return false;
            }
            for (b bVar : this.v) {
                if (bVar.a == obj) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, str)) == null) {
            for (int i = 0; i < this.v.size(); i++) {
                b bVar = this.v.get(i);
                if (!TextUtils.isEmpty(str) && str.equals(bVar.d)) {
                    return i;
                }
            }
            return z();
        }
        return invokeL.intValue;
    }

    public int y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, str)) == null) {
            for (int i = 0; i < this.v.size(); i++) {
                b bVar = this.v.get(i);
                if (!TextUtils.isEmpty(str) && str.equals(bVar.c)) {
                    return i;
                }
            }
            return z();
        }
        return invokeL.intValue;
    }

    public void S(tbclient.Userlike.DataRes dataRes, boolean z) {
        ConcernFragment concernFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048593, this, dataRes, z) == null) && (concernFragment = this.g) != null) {
            concernFragment.N1(dataRes, z);
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.v.clear();
            me9.a("NewScrollFragmentAdapter updateFragmentTabItems start");
            for (b bVar : this.w) {
                this.v.add(bVar);
                me9.a("NewScrollFragmentAdapter updateFragmentTabItems:" + bVar.c + " " + bVar.a);
            }
            me9.a("NewScrollFragmentAdapter updateFragmentTabItems end");
        }
    }

    public final void f() {
        List<b> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || (list = this.w) == null) {
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

    public final void k(Context context, wd7 wd7Var, ConcernPageView.o oVar) {
        String A;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048608, this, context, wd7Var, oVar) == null) {
            if (this.g == null) {
                this.g = new ConcernFragment(context);
                e(2);
            }
            this.g.K1(oVar);
            if (!this.u) {
                if (UbsABTestHelper.isConcernForumCardShow() && TbadkCoreApplication.isLogin() && m35.m().n("key_home_concern_all_status", 0) == 1) {
                    this.w.add(D(this.g, 0, A(R.string.attention_person), BdUniDispatchSchemeController.PARAM_CONCERN, false));
                } else {
                    this.w.add(C(this.g, 0, A(R.string.tab_name_concern)));
                }
            }
            if (!this.u) {
                if (this.i == null) {
                    this.i = new PersonalizeWrapperFragment(context);
                    e(1);
                }
                this.w.add(D(this.i, 1, A(R.string.obfuscated_res_0x7f0f144b), BdUniDispatchSchemeController.PARAM_RECOMMEND, false));
            } else if (!PermissionUtil.isBrowseMode()) {
                if (this.h == null) {
                    this.h = new PersonalizeFragment(context);
                    e(1);
                }
                this.h.L1(wd7Var);
                List<b> list = this.w;
                PersonalizeFragment personalizeFragment = this.h;
                if (this.u) {
                    A = A(R.string.obfuscated_res_0x7f0f0272);
                } else {
                    A = A(R.string.obfuscated_res_0x7f0f144b);
                }
                list.add(C(personalizeFragment, 1, A));
            }
            for (int i = 0; i < this.w.size(); i++) {
                b bVar = this.w.get(i);
                me9.a("NewScrollFragmentAdapter generateLocalTabFragments" + i + " " + bVar.c + " " + bVar.a);
            }
        }
    }

    public final void l(Context context, List<h75> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, context, list) == null) {
            for (h75 h75Var : list) {
                int i = h75Var.a;
                String str = h75Var.b;
                String str2 = h75Var.c;
                boolean z = h75Var.f;
                if (!h75Var.e()) {
                    if (i != 101 && i != 201) {
                        if (i == 5) {
                            if (this.j == null) {
                                e(3);
                                HotTopicTabFragment hotTopicTabFragment = new HotTopicTabFragment(context);
                                this.j = hotTopicTabFragment;
                                this.w.add(D(hotTopicTabFragment, i, str, str2, z));
                                this.x.put(h75Var.b, this.j);
                            }
                        } else if (i == 8) {
                            if (this.m == null) {
                                this.m = new VideoTabFragment();
                                e(5);
                                this.w.add(E(this.m, h75Var));
                                this.x.put(h75Var.b, this.m);
                            }
                        } else if (i == 6) {
                            if (!PermissionUtil.isBrowseMode() && this.k == null) {
                                e(4);
                                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class);
                                if (runTask != null && runTask.getData() != null) {
                                    BaseFragment baseFragment = (BaseFragment) runTask.getData();
                                    this.k = baseFragment;
                                    this.w.add(E(baseFragment, h75Var));
                                }
                            }
                        } else if (i == 7) {
                            if (this.l == null) {
                                GameVideoFragment gameVideoFragment = new GameVideoFragment();
                                this.l = gameVideoFragment;
                                this.w.add(E(gameVideoFragment, h75Var));
                                this.x.put(h75Var.b, this.l);
                                TiebaStatic.log(new StatisticItem("c13483").param("obj_type", "2"));
                            }
                        } else if (i == 202 && !TextUtils.isEmpty(h75Var.d)) {
                            Fragment tabWebFragment = new TabWebFragment();
                            Bundle bundle = new Bundle();
                            bundle.putString("tab_code", str2);
                            bundle.putString("tab_name", str);
                            bundle.putString("tab_url", h75Var.d);
                            bundle.putInt("tab_type", i);
                            tabWebFragment.setArguments(bundle);
                            this.w.add(E(tabWebFragment, h75Var));
                        }
                    } else {
                        HomePageTabFeedFragment homePageTabFeedFragment = new HomePageTabFeedFragment();
                        this.w.add(E(homePageTabFeedFragment, h75Var));
                        homePageTabFeedFragment.W1(this.u);
                        this.x.put(h75Var.b, homePageTabFeedFragment);
                    }
                }
            }
            me9.a("NewScrollFragmentAdapter generateSyncTabFragments:" + this.x);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            int i3 = this.r;
            if (i3 == -1 || (i == i3 && f == 0.0f)) {
                Fragment fragment = (Fragment) ListUtils.getItem(b(), i - 1);
                Fragment fragment2 = (Fragment) ListUtils.getItem(b(), i);
                Fragment fragment3 = (Fragment) ListUtils.getItem(b(), i + 1);
                this.r = -1;
                if (f == 0.0f) {
                    if (fragment instanceof kx6) {
                        ((kx6) fragment).P();
                    }
                    if (fragment3 instanceof kx6) {
                        ((kx6) fragment3).P();
                    }
                    if (fragment2 != null) {
                        fragment2.setMenuVisibility(true);
                        fragment2.setUserVisibleHint(true);
                        return;
                    }
                    return;
                }
                if (fragment instanceof kx6) {
                    ((kx6) fragment).B();
                }
                if (fragment2 instanceof kx6) {
                    ((kx6) fragment2).B();
                }
                if (fragment3 instanceof kx6) {
                    ((kx6) fragment3).B();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048618, this, viewGroup, i, obj) == null) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (obj != null && this.s != i) {
                kx6 kx6Var = this.n;
                if (kx6Var instanceof BaseFragment) {
                    ((BaseFragment) kx6Var).setPrimary(false);
                }
                this.s = i;
                VoiceManager a2 = ud9.a(this.f);
                if (a2 != null) {
                    a2.stopPlay();
                }
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
                if ((obj instanceof PersonalizeFragment) && i == 0) {
                    ((PersonalizeFragment) obj).y();
                }
            }
            if (obj instanceof kx6) {
                this.n = (kx6) obj;
            }
        }
    }
}
