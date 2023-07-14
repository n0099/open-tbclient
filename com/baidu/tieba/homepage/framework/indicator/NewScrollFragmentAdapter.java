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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.a28;
import com.baidu.tieba.az5;
import com.baidu.tieba.b28;
import com.baidu.tieba.d28;
import com.baidu.tieba.da5;
import com.baidu.tieba.ej7;
import com.baidu.tieba.en6;
import com.baidu.tieba.fe5;
import com.baidu.tieba.g28;
import com.baidu.tieba.homepage.concern.ConcernFragment;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.gamevideo.GameVideoFragment;
import com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment;
import com.baidu.tieba.homepage.personalize.PersonalizeFragment;
import com.baidu.tieba.homepage.personalize.PersonalizeWrapperFragment;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.homepage.tabfeed.h5.NewTabWebFragment;
import com.baidu.tieba.homepage.tabfeed.h5.TabWebFragment;
import com.baidu.tieba.homepage.video.VideoTabFragment;
import com.baidu.tieba.jfa;
import com.baidu.tieba.o55;
import com.baidu.tieba.rea;
import com.baidu.tieba.uh5;
import com.baidu.tieba.wy5;
import com.baidu.tieba.xi;
import com.baidu.tieba.ye;
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
/* loaded from: classes6.dex */
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
    public ej7 n;
    public String o;
    public String p;
    public boolean q;
    public int r;
    public int s;
    public g28 t;
    public boolean u;
    public List<b> v;
    public List<b> w;
    public HashMap<String, BaseFragment> x;

    public void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends wy5<Object> {
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

        @Override // com.baidu.tieba.wy5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                o55.e();
                ye<String> g = o55.g(this.b.o, TbadkCoreApplication.getCurrentAccount());
                if (g != null) {
                    g.e(this.b.p, Integer.toString(this.a), com.heytap.mcssdk.constant.a.g);
                    return null;
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
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
    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, boolean z, a28 a28Var, ConcernPageView.s sVar) {
        super(fragmentManager);
        List<fe5> h;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, fragmentManager, Boolean.valueOf(z), a28Var, sVar};
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
        jfa.a("NewScrollFragmentAdapter init:" + z);
        this.f = context;
        this.u = z;
        if (this.t == null) {
            this.t = new g28();
        }
        if (this.u) {
            h = this.t.f();
        } else {
            h = this.t.h();
        }
        this.w.clear();
        this.x.clear();
        m(context, a28Var, sVar);
        n(context, h);
        h();
        W();
        notifyDataSetChanged();
    }

    public final String C(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return TbadkCoreApplication.getInst().getString(i);
        }
        return (String) invokeI.objValue;
    }

    public void I(int i) {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && i == 1 && (personalizeFragment = this.h) != null) {
            personalizeFragment.N1();
        }
    }

    public void J(int i) {
        ej7 ej7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && (ej7Var = this.n) != null) {
            ej7Var.j0();
        }
    }

    public void N(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            az5.b(new a(this, i), null);
        }
    }

    public void P(b28 b28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, b28Var) == null) {
            PersonalizeFragment personalizeFragment = this.h;
            if (personalizeFragment != null) {
                personalizeFragment.P1(b28Var);
            }
            if (b28Var instanceof ScrollFragmentTabHost) {
                ScrollFragmentTabHost scrollFragmentTabHost = (ScrollFragmentTabHost) b28Var;
                HotTopicTabFragment hotTopicTabFragment = this.j;
                if (hotTopicTabFragment != null) {
                    hotTopicTabFragment.L1(scrollFragmentTabHost);
                }
                ConcernFragment concernFragment = this.g;
                if (concernFragment != null) {
                    concernFragment.O1(scrollFragmentTabHost);
                }
            }
        }
    }

    public void Q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            if (this.s == i) {
                this.r = -1;
            } else {
                this.r = i;
            }
        }
    }

    public void S(boolean z) {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048593, this, z) == null) && (personalizeFragment = this.h) != null) {
            personalizeFragment.R1(z);
        }
    }

    public final void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, obj)) == null) {
            if (j(obj)) {
                return -1;
            }
            return -2;
        }
        return invokeL.intValue;
    }

    @Deprecated
    public int s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048619, this, i)) == null) {
            for (int i2 = 0; i2 < this.v.size(); i2++) {
                if (this.v.get(i2).e == i) {
                    return i2;
                }
            }
            return B();
        }
        return invokeI.intValue;
    }

    public String t(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048621, this, i)) == null) {
            b bVar = (b) ListUtils.getItem(this.v, i);
            if (bVar != null) {
                return bVar.d;
            }
            return "";
        }
        return (String) invokeI.objValue;
    }

    public String u(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048622, this, i)) == null) {
            b bVar = (b) ListUtils.getItem(this.v, i);
            if (bVar != null) {
                return bVar.c;
            }
            return C(R.string.obfuscated_res_0x7f0f15b6);
        }
        return (String) invokeI.objValue;
    }

    public int x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i)) == null) {
            b bVar = (b) ListUtils.getItem(this.v, i);
            if (bVar != null) {
                return bVar.e;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public void y(d28 d28Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048624, this, d28Var) != null) || this.q) {
            return;
        }
        this.q = true;
        d28Var.a(1);
    }

    public int A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            for (int i = 0; i < this.v.size(); i++) {
                b bVar = this.v.get(i);
                if (!TextUtils.isEmpty(str) && str.equals(bVar.c)) {
                    return i;
                }
            }
            return B();
        }
        return invokeL.intValue;
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (this.n instanceof BaseFragment)) {
            if (!z) {
                int position = ListUtils.getPosition(b(), (BaseFragment) this.n);
                if (position < 0) {
                    position = s(1);
                }
                N(position);
                i();
            }
            ((BaseFragment) this.n).setPrimary(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i)) == null) {
            List<b> list = this.v;
            if (list != null && i >= 0 && i < list.size() && this.v.get(i) != null) {
                return this.v.get(i).b;
            }
            return null;
        }
        return (CharSequence) invokeI.objValue;
    }

    public final boolean j(@NonNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, obj)) == null) {
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

    public int z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, str)) == null) {
            for (int i = 0; i < this.v.size(); i++) {
                b bVar = this.v.get(i);
                if (!TextUtils.isEmpty(str) && str.equals(bVar.d)) {
                    return i;
                }
            }
            return B();
        }
        return invokeL.intValue;
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            for (int i = 0; i < this.v.size(); i++) {
                if (this.v.get(i).e == 1) {
                    return i;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.g != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void L() {
        ej7 ej7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (ej7Var = this.n) != null) {
            ej7Var.B();
        }
    }

    public void T() {
        ConcernFragment concernFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (concernFragment = this.g) != null) {
            concernFragment.P1();
        }
    }

    public void Y() {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (personalizeFragment = this.h) != null) {
            personalizeFragment.M1();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            List<b> list = this.v;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            PersonalizeFragment personalizeFragment = this.h;
            if (personalizeFragment != null && this.n == personalizeFragment) {
                personalizeFragment.L1();
            }
            ConcernFragment concernFragment = this.g;
            if (concernFragment != null && this.n == concernFragment) {
                concernFragment.K1();
            }
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            g28 g28Var = this.t;
            if (g28Var == null) {
                return false;
            }
            return g28Var.c();
        }
        return invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            Fragment item = getItem(this.s);
            if (item instanceof ej7) {
                ((ej7) item).B();
            }
        }
    }

    public ej7 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.n;
        }
        return (ej7) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            ej7 ej7Var = this.n;
            if (ej7Var instanceof BaseFragment) {
                return ((BaseFragment) ej7Var).getCurrentPageKey();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.t.e();
        }
        return invokeV.intValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            for (int i = 0; i < this.v.size(); i++) {
                if (this.v.get(i).e == 5) {
                    return i;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public b E(Fragment fragment, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, fragment, i, str)) == null) {
            return new b(fragment, i, str);
        }
        return (b) invokeLIL.objValue;
    }

    public void V(String str, int i, int i2) {
        ConcernFragment concernFragment;
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048596, this, str, i, i2) == null) {
            if (i2 == 1 && (personalizeFragment = this.h) != null) {
                personalizeFragment.T1(str, i);
            }
            if (i2 == 0 && (concernFragment = this.g) != null) {
                concernFragment.R1(str, i);
            }
        }
    }

    public void X(DataRes dataRes, boolean z, boolean z2) {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (personalizeFragment = this.h) != null) {
            personalizeFragment.S1(dataRes, z, z2);
        }
    }

    public b F(Fragment fragment, int i, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{fragment, Integer.valueOf(i), str, str2, Boolean.valueOf(z)})) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("tab_code", str2);
            bundle.putString("tab_name", str);
            bundle.putInt("tab_type", i);
            fragment.setArguments(bundle);
            return new b(fragment, i, str, str2, z);
        }
        return (b) invokeCommon.objValue;
    }

    public b G(Fragment fragment, fe5 fe5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, fragment, fe5Var)) == null) {
            Bundle arguments = fragment.getArguments();
            if (arguments == null) {
                arguments = new Bundle();
            }
            arguments.putString("tab_code", fe5Var.c);
            arguments.putString("tab_name", fe5Var.b);
            arguments.putInt("tab_type", fe5Var.a);
            fragment.setArguments(arguments);
            return new b(fragment, fe5Var.a, fe5Var.e(), fe5Var.b, fe5Var.c);
        }
        return (b) invokeLL.objValue;
    }

    public void H(String str) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
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

    public void M() {
        List<b> list;
        List<fe5> h;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || (list = this.w) == null) {
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
        g28 g28Var = this.t;
        if (g28Var == null) {
            this.t = new g28();
        } else {
            g28Var.k();
        }
        if (this.u) {
            h = this.t.f();
        } else {
            h = this.t.h();
        }
        n(this.f, h);
        h();
        W();
        notifyDataSetChanged();
        ej7 ej7Var = this.n;
        if (ej7Var instanceof TabWebFragment) {
            ej7Var.B();
        }
    }

    public void g() {
        HashMap<String, uh5> colourHeaderConfig;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048602, this) != null) || (colourHeaderConfig = TbSingleton.getInstance().getColourHeaderConfig()) == null) {
            return;
        }
        Iterator<Fragment> it = b().iterator();
        while (it.hasNext()) {
            Fragment next = it.next();
            if (next instanceof TabWebFragment) {
                TabWebFragment tabWebFragment = (TabWebFragment) next;
                uh5 uh5Var = colourHeaderConfig.get(tabWebFragment.k2());
                if (uh5Var != null && !TextUtils.isEmpty(uh5Var.j()) && !TextUtils.isEmpty(tabWebFragment.a) && !tabWebFragment.a.contains("bgImg=")) {
                    String str = tabWebFragment.a;
                    tabWebFragment.P1(UtilHelper.urlAddParam(str, "bgImg=" + xi.getUrlEncode(uh5Var.j())));
                }
            }
        }
    }

    public void U(tbclient.Userlike.DataRes dataRes, boolean z) {
        ConcernFragment concernFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048595, this, dataRes, z) == null) && (concernFragment = this.g) != null) {
            concernFragment.Q1(dataRes, z);
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.v.clear();
            jfa.a("NewScrollFragmentAdapter updateFragmentTabItems start");
            for (b bVar : this.w) {
                this.v.add(bVar);
                jfa.a("NewScrollFragmentAdapter updateFragmentTabItems:" + bVar.c + " " + bVar.a);
            }
            jfa.a("NewScrollFragmentAdapter updateFragmentTabItems end");
        }
    }

    public final String f(@NonNull fe5 fe5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, fe5Var)) == null) {
            String str = fe5Var.d;
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            HashMap<String, uh5> colourHeaderConfig = TbSingleton.getInstance().getColourHeaderConfig();
            if (colourHeaderConfig == null) {
                return str;
            }
            uh5 uh5Var = colourHeaderConfig.get(fe5Var.b);
            if (uh5Var != null && !TextUtils.isEmpty(uh5Var.j()) && !str.contains("bgImg=")) {
                fe5Var.j = true;
                return UtilHelper.urlAddParam(str, "bgImg=" + xi.getUrlEncode(uh5Var.j()));
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final void h() {
        List<b> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048607, this) != null) || (list = this.w) == null) {
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

    public final void m(Context context, a28 a28Var, ConcernPageView.s sVar) {
        String C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048612, this, context, a28Var, sVar) == null) {
            if (this.g == null) {
                this.g = new ConcernFragment(context);
                e(2);
            }
            this.g.N1(sVar);
            if (!this.u) {
                if (UbsABTestHelper.isConcernForumCardShow() && TbadkCoreApplication.isLogin() && da5.p().q("key_home_concern_all_status", 0) == 1) {
                    this.w.add(F(this.g, 0, C(R.string.attention_person), BdUniDispatchSchemeController.PARAM_CONCERN, false));
                } else {
                    this.w.add(E(this.g, 0, C(R.string.tab_name_concern)));
                }
            }
            if (!this.u) {
                if (this.i == null) {
                    this.i = new PersonalizeWrapperFragment(context);
                    e(1);
                }
                this.w.add(F(this.i, 1, C(R.string.obfuscated_res_0x7f0f15b6), BdUniDispatchSchemeController.PARAM_RECOMMEND, false));
            } else if (!PermissionUtil.isBrowseMode()) {
                if (this.h == null) {
                    this.h = new PersonalizeFragment(context);
                    e(1);
                }
                this.h.O1(a28Var);
                List<b> list = this.w;
                PersonalizeFragment personalizeFragment = this.h;
                if (this.u) {
                    C = C(R.string.obfuscated_res_0x7f0f029c);
                } else {
                    C = C(R.string.obfuscated_res_0x7f0f15b6);
                }
                list.add(E(personalizeFragment, 1, C));
            }
            for (int i = 0; i < this.w.size(); i++) {
                b bVar = this.w.get(i);
                jfa.a("NewScrollFragmentAdapter generateLocalTabFragments" + i + " " + bVar.c + " " + bVar.a);
            }
        }
    }

    public final void n(Context context, List<fe5> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, context, list) == null) {
            for (fe5 fe5Var : list) {
                int i = fe5Var.a;
                String str = fe5Var.b;
                String str2 = fe5Var.c;
                boolean z = fe5Var.f;
                if (!fe5Var.f()) {
                    if (i != 101 && i != 201) {
                        if (i == 5) {
                            if (this.j == null) {
                                e(3);
                                HotTopicTabFragment hotTopicTabFragment = new HotTopicTabFragment(context);
                                this.j = hotTopicTabFragment;
                                this.w.add(F(hotTopicTabFragment, i, str, str2, z));
                                this.x.put(fe5Var.b, this.j);
                            }
                        } else if (i == 8) {
                            if (this.m == null) {
                                this.m = new VideoTabFragment();
                                e(5);
                                this.w.add(G(this.m, fe5Var));
                                this.x.put(fe5Var.b, this.m);
                            }
                        } else if (i == 6) {
                            if (!PermissionUtil.isBrowseMode() && this.k == null) {
                                e(4);
                                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class);
                                if (runTask != null && runTask.getData() != null) {
                                    BaseFragment baseFragment = (BaseFragment) runTask.getData();
                                    this.k = baseFragment;
                                    this.w.add(G(baseFragment, fe5Var));
                                }
                            }
                        } else if (i == 7) {
                            if (this.l == null) {
                                GameVideoFragment gameVideoFragment = new GameVideoFragment();
                                this.l = gameVideoFragment;
                                this.w.add(G(gameVideoFragment, fe5Var));
                                this.x.put(fe5Var.b, this.l);
                                TiebaStatic.log(new StatisticItem("c13483").param("obj_type", "2"));
                            }
                        } else if (i == 202 && !TextUtils.isEmpty(fe5Var.d)) {
                            if (en6.e(fe5Var.d)) {
                                Fragment newTabWebFragment = new NewTabWebFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("tab_code", str2);
                                bundle.putString("tab_name", str);
                                String f = f(fe5Var);
                                fe5Var.d = f;
                                bundle.putString("tab_url", f);
                                bundle.putInt("tab_type", i);
                                bundle.putBoolean("tab_is_second_tab", this.u);
                                newTabWebFragment.setArguments(bundle);
                                this.w.add(G(newTabWebFragment, fe5Var));
                            } else {
                                Fragment tabWebFragment = new TabWebFragment();
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("tab_code", str2);
                                bundle2.putString("tab_name", str);
                                String f2 = f(fe5Var);
                                fe5Var.d = f2;
                                bundle2.putString("tab_url", f2);
                                bundle2.putInt("tab_type", i);
                                bundle2.putBoolean("tab_is_second_tab", this.u);
                                tabWebFragment.setArguments(bundle2);
                                this.w.add(G(tabWebFragment, fe5Var));
                            }
                        }
                    } else {
                        HomePageTabFeedFragment homePageTabFeedFragment = new HomePageTabFeedFragment();
                        this.w.add(G(homePageTabFeedFragment, fe5Var));
                        homePageTabFeedFragment.Z1(this.u);
                        this.x.put(fe5Var.b, homePageTabFeedFragment);
                    }
                }
            }
            jfa.a("NewScrollFragmentAdapter generateSyncTabFragments:" + this.x);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            int i3 = this.r;
            if (i3 == -1 || (i == i3 && f == 0.0f)) {
                Fragment fragment = (Fragment) ListUtils.getItem(b(), i - 1);
                Fragment fragment2 = (Fragment) ListUtils.getItem(b(), i);
                Fragment fragment3 = (Fragment) ListUtils.getItem(b(), i + 1);
                this.r = -1;
                if (f == 0.0f) {
                    if (fragment instanceof ej7) {
                        ((ej7) fragment).f0();
                    }
                    if (fragment3 instanceof ej7) {
                        ((ej7) fragment3).f0();
                    }
                    if (fragment2 != null) {
                        fragment2.setMenuVisibility(true);
                        fragment2.setUserVisibleHint(true);
                        return;
                    }
                    return;
                }
                if (fragment instanceof ej7) {
                    ((ej7) fragment).L();
                }
                if (fragment2 instanceof ej7) {
                    ((ej7) fragment2).L();
                }
                if (fragment3 instanceof ej7) {
                    ((ej7) fragment3).L();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048620, this, viewGroup, i, obj) == null) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (obj != null && this.s != i) {
                ej7 ej7Var = this.n;
                if (ej7Var instanceof BaseFragment) {
                    ((BaseFragment) ej7Var).setPrimary(false);
                }
                this.s = i;
                VoiceManager a2 = rea.a(this.f);
                if (a2 != null) {
                    a2.stopPlay();
                }
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
                if ((obj instanceof PersonalizeFragment) && i == 0) {
                    ((PersonalizeFragment) obj).g();
                }
            }
            if (obj instanceof ej7) {
                this.n = (ej7) obj;
            }
        }
    }
}
