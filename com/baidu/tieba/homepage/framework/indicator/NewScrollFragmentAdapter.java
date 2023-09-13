package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
import com.baidu.tieba.a38;
import com.baidu.tieba.by5;
import com.baidu.tieba.ei;
import com.baidu.tieba.eka;
import com.baidu.tieba.gh5;
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
import com.baidu.tieba.kd5;
import com.baidu.tieba.lj7;
import com.baidu.tieba.oe;
import com.baidu.tieba.oja;
import com.baidu.tieba.pm6;
import com.baidu.tieba.s28;
import com.baidu.tieba.t28;
import com.baidu.tieba.v28;
import com.baidu.tieba.x28;
import com.baidu.tieba.x45;
import com.baidu.tieba.xx5;
import com.baidu.tieba.y28;
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
    public lj7 n;
    public String o;
    public String p;
    public boolean q;
    public int r;
    public int s;
    public a38 t;
    public boolean u;
    public List<b> v;
    public List<b> w;
    public HashMap<String, BaseFragment> x;

    public void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends xx5<Object> {
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

        @Override // com.baidu.tieba.xx5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                x45.k();
                oe<String> m = x45.m(this.b.o, TbadkCoreApplication.getCurrentAccount());
                if (m != null) {
                    m.e(this.b.p, Integer.toString(this.a), com.heytap.mcssdk.constant.a.g);
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
        @Nullable
        public x28 f;

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
    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, boolean z, s28 s28Var, ConcernPageView.s sVar) {
        super(fragmentManager);
        List<kd5> h;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, fragmentManager, Boolean.valueOf(z), s28Var, sVar};
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
        eka.a("NewScrollFragmentAdapter init:" + z);
        this.f = context;
        this.u = z;
        if (this.t == null) {
            this.t = new a38();
        }
        if (this.u) {
            h = this.t.f();
        } else {
            h = this.t.h();
        }
        this.w.clear();
        this.x.clear();
        m(context, s28Var, sVar);
        n(context, h);
        h();
        Y();
        notifyDataSetChanged();
    }

    public int C(int i) {
        InterceptResult invokeI;
        x28 x28Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            b bVar = (b) ListUtils.getItem(this.v, i);
            if (bVar != null && (x28Var = bVar.f) != null) {
                return x28Var.a();
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public final String D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return TbadkCoreApplication.getInst().getString(i);
        }
        return (String) invokeI.objValue;
    }

    public void J(int i) {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && i == 1 && (personalizeFragment = this.h) != null) {
            personalizeFragment.c2();
        }
    }

    public void K(int i) {
        lj7 lj7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && (lj7Var = this.n) != null) {
            lj7Var.r0();
        }
    }

    public void N(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            by5.b(new a(this, i), null);
        }
    }

    public void P(t28 t28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, t28Var) == null) {
            PersonalizeFragment personalizeFragment = this.h;
            if (personalizeFragment != null) {
                personalizeFragment.e2(t28Var);
            }
            if (t28Var instanceof ScrollFragmentTabHost) {
                ScrollFragmentTabHost scrollFragmentTabHost = (ScrollFragmentTabHost) t28Var;
                HotTopicTabFragment hotTopicTabFragment = this.j;
                if (hotTopicTabFragment != null) {
                    hotTopicTabFragment.a2(scrollFragmentTabHost);
                }
                ConcernFragment concernFragment = this.g;
                if (concernFragment != null) {
                    concernFragment.d2(scrollFragmentTabHost);
                }
            }
        }
    }

    public void R(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            if (this.s == i) {
                this.r = -1;
            } else {
                this.r = i;
            }
        }
    }

    public void T(boolean z) {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048595, this, z) == null) && (personalizeFragment = this.h) != null) {
            personalizeFragment.g2(z);
        }
    }

    public final void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, obj)) == null) {
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048622, this, i)) == null) {
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048624, this, i)) == null) {
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048625, this, i)) == null) {
            b bVar = (b) ListUtils.getItem(this.v, i);
            if (bVar != null) {
                return bVar.c;
            }
            return D(R.string.obfuscated_res_0x7f0f15e1);
        }
        return (String) invokeI.objValue;
    }

    public int x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048626, this, i)) == null) {
            b bVar = (b) ListUtils.getItem(this.v, i);
            if (bVar != null) {
                return bVar.e;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public void y(v28 v28Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048627, this, v28Var) != null) || this.q) {
            return;
        }
        this.q = true;
        v28Var.a(1);
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
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (this.n instanceof BaseFragment)) {
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i)) == null) {
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, obj)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, str)) == null) {
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

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.g != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void L() {
        lj7 lj7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (lj7Var = this.n) != null) {
            lj7Var.F();
        }
    }

    public void U() {
        ConcernFragment concernFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (concernFragment = this.g) != null) {
            concernFragment.e2();
        }
    }

    public void a0() {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (personalizeFragment = this.h) != null) {
            personalizeFragment.b2();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            PersonalizeFragment personalizeFragment = this.h;
            if (personalizeFragment != null && this.n == personalizeFragment) {
                personalizeFragment.a2();
            }
            ConcernFragment concernFragment = this.g;
            if (concernFragment != null && this.n == concernFragment) {
                concernFragment.Z1();
            }
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            a38 a38Var = this.t;
            if (a38Var == null) {
                return false;
            }
            return a38Var.c();
        }
        return invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            Fragment item = getItem(this.s);
            if (item instanceof lj7) {
                ((lj7) item).F();
            }
        }
    }

    public lj7 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.n;
        }
        return (lj7) invokeV.objValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            for (b bVar : this.v) {
                x28 x28Var = bVar.f;
                if (x28Var != null) {
                    x28Var.c();
                }
            }
        }
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            lj7 lj7Var = this.n;
            if (lj7Var instanceof BaseFragment) {
                return ((BaseFragment) lj7Var).getCurrentPageKey();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.t.e();
        }
        return invokeV.intValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            for (int i = 0; i < this.v.size(); i++) {
                if (this.v.get(i).e == 5) {
                    return i;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public b F(Fragment fragment, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048581, this, fragment, i, str)) == null) {
            return new b(fragment, i, str);
        }
        return (b) invokeLIL.objValue;
    }

    public void X(String str, int i, int i2) {
        ConcernFragment concernFragment;
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048598, this, str, i, i2) == null) {
            if (i2 == 1 && (personalizeFragment = this.h) != null) {
                personalizeFragment.i2(str, i);
            }
            if (i2 == 0 && (concernFragment = this.g) != null) {
                concernFragment.g2(str, i);
            }
        }
    }

    public void Z(DataRes dataRes, boolean z, boolean z2) {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (personalizeFragment = this.h) != null) {
            personalizeFragment.h2(dataRes, z, z2);
        }
    }

    public b G(Fragment fragment, int i, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{fragment, Integer.valueOf(i), str, str2, Boolean.valueOf(z)})) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("tab_code", str2);
            bundle.putString("tab_name", str);
            bundle.putInt("tab_type", i);
            fragment.setArguments(bundle);
            return new b(fragment, i, str, str2, z);
        }
        return (b) invokeCommon.objValue;
    }

    public b H(Fragment fragment, kd5 kd5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, fragment, kd5Var)) == null) {
            Bundle arguments = fragment.getArguments();
            if (arguments == null) {
                arguments = new Bundle();
            }
            arguments.putString("tab_code", kd5Var.c);
            arguments.putString("tab_name", kd5Var.b);
            arguments.putInt("tab_type", kd5Var.a);
            fragment.setArguments(arguments);
            return new b(fragment, kd5Var.a, kd5Var.e(), kd5Var.b, kd5Var.c);
        }
        return (b) invokeLL.objValue;
    }

    public void I(String str) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
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
        List<kd5> h;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || (list = this.w) == null) {
            return;
        }
        Iterator<b> it = list.iterator();
        while (it.hasNext()) {
            b next = it.next();
            Fragment fragment = next.a;
            if (!(fragment instanceof ConcernFragment) && !(fragment instanceof PersonalizeWrapperFragment) && !(fragment instanceof HotTopicTabFragment)) {
                it.remove();
                x28 x28Var = next.f;
                if (x28Var != null) {
                    x28Var.c();
                }
            }
        }
        this.k = null;
        this.l = null;
        this.m = null;
        a38 a38Var = this.t;
        if (a38Var == null) {
            this.t = new a38();
        } else {
            a38Var.k();
        }
        if (this.u) {
            h = this.t.f();
        } else {
            h = this.t.h();
        }
        n(this.f, h);
        h();
        Y();
        notifyDataSetChanged();
        lj7 lj7Var = this.n;
        if (lj7Var instanceof TabWebFragment) {
            lj7Var.F();
        }
    }

    public void g() {
        HashMap<String, gh5> colourHeaderConfig;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048604, this) != null) || (colourHeaderConfig = TbSingleton.getInstance().getColourHeaderConfig()) == null) {
            return;
        }
        Iterator<Fragment> it = b().iterator();
        while (it.hasNext()) {
            Fragment next = it.next();
            if (next instanceof TabWebFragment) {
                TabWebFragment tabWebFragment = (TabWebFragment) next;
                gh5 gh5Var = colourHeaderConfig.get(tabWebFragment.z2());
                if (gh5Var != null && !TextUtils.isEmpty(gh5Var.j()) && !TextUtils.isEmpty(tabWebFragment.a) && !tabWebFragment.a.contains("bgImg=")) {
                    String str = tabWebFragment.a;
                    tabWebFragment.e2(UtilHelper.urlAddParam(str, "bgImg=" + ei.getUrlEncode(gh5Var.j())));
                }
            }
        }
    }

    public void Q(String str, int i) {
        x28 x28Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, str, i) == null) {
            for (int i2 = 0; i2 < this.v.size(); i2++) {
                b bVar = this.v.get(i2);
                if (!TextUtils.isEmpty(str) && str.equals(bVar.d) && (x28Var = bVar.f) != null) {
                    x28Var.d(i);
                }
            }
        }
    }

    public void W(tbclient.Userlike.DataRes dataRes, boolean z) {
        ConcernFragment concernFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048597, this, dataRes, z) == null) && (concernFragment = this.g) != null) {
            concernFragment.f2(dataRes, z);
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.v.clear();
            eka.a("NewScrollFragmentAdapter updateFragmentTabItems start");
            for (b bVar : this.w) {
                this.v.add(bVar);
                eka.a("NewScrollFragmentAdapter updateFragmentTabItems:" + bVar.c + " " + bVar.a);
            }
            eka.a("NewScrollFragmentAdapter updateFragmentTabItems end");
        }
    }

    public final String f(@NonNull kd5 kd5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, kd5Var)) == null) {
            String str = kd5Var.d;
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            HashMap<String, gh5> colourHeaderConfig = TbSingleton.getInstance().getColourHeaderConfig();
            if (colourHeaderConfig == null) {
                return str;
            }
            gh5 gh5Var = colourHeaderConfig.get(kd5Var.b);
            if (gh5Var != null && !TextUtils.isEmpty(gh5Var.j()) && !str.contains("bgImg=")) {
                kd5Var.j = true;
                return UtilHelper.urlAddParam(str, "bgImg=" + ei.getUrlEncode(gh5Var.j()));
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final void h() {
        List<b> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || (list = this.w) == null) {
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

    public final void m(Context context, s28 s28Var, ConcernPageView.s sVar) {
        String D;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048614, this, context, s28Var, sVar) == null) {
            if (this.g == null) {
                this.g = new ConcernFragment(context);
                e(2);
            }
            this.g.c2(sVar);
            if (!this.u) {
                if (UbsABTestHelper.isConcernForumCardShow() && TbadkCoreApplication.isLogin() && SharedPrefHelper.getInstance().getInt("key_home_concern_all_status", 0) == 1) {
                    this.w.add(G(this.g, 0, D(R.string.attention_person), BdUniDispatchSchemeController.PARAM_CONCERN, false));
                } else {
                    this.w.add(F(this.g, 0, D(R.string.tab_name_concern)));
                }
            }
            if (!this.u) {
                if (this.i == null) {
                    this.i = new PersonalizeWrapperFragment(context);
                    e(1);
                }
                this.w.add(G(this.i, 1, D(R.string.obfuscated_res_0x7f0f15e1), BdUniDispatchSchemeController.PARAM_RECOMMEND, false));
            } else if (!PermissionUtil.isBrowseMode()) {
                if (this.h == null) {
                    this.h = new PersonalizeFragment(context);
                    e(1);
                }
                this.h.d2(s28Var);
                List<b> list = this.w;
                PersonalizeFragment personalizeFragment = this.h;
                if (this.u) {
                    D = D(R.string.obfuscated_res_0x7f0f029d);
                } else {
                    D = D(R.string.obfuscated_res_0x7f0f15e1);
                }
                list.add(F(personalizeFragment, 1, D));
            }
            for (int i = 0; i < this.w.size(); i++) {
                b bVar = this.w.get(i);
                eka.a("NewScrollFragmentAdapter generateLocalTabFragments" + i + " " + bVar.c + " " + bVar.a);
            }
        }
    }

    public final void n(Context context, List<kd5> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, context, list) == null) {
            for (kd5 kd5Var : list) {
                int i = kd5Var.a;
                String str = kd5Var.b;
                String str2 = kd5Var.c;
                boolean z = kd5Var.f;
                if (!kd5Var.f()) {
                    if (i != 101 && i != 201) {
                        if (i == 5) {
                            if (this.j == null) {
                                e(3);
                                HotTopicTabFragment hotTopicTabFragment = new HotTopicTabFragment(context);
                                this.j = hotTopicTabFragment;
                                this.w.add(G(hotTopicTabFragment, i, str, str2, z));
                                this.x.put(kd5Var.b, this.j);
                            }
                        } else if (i == 8) {
                            if (this.m == null) {
                                this.m = new VideoTabFragment();
                                e(5);
                                this.w.add(H(this.m, kd5Var));
                                this.x.put(kd5Var.b, this.m);
                            }
                        } else if (i == 6) {
                            if (!PermissionUtil.isBrowseMode() && this.k == null) {
                                e(4);
                                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class);
                                if (runTask != null && runTask.getData() != null) {
                                    BaseFragment baseFragment = (BaseFragment) runTask.getData();
                                    this.k = baseFragment;
                                    this.w.add(H(baseFragment, kd5Var));
                                }
                            }
                        } else if (i == 7) {
                            if (this.l == null) {
                                GameVideoFragment gameVideoFragment = new GameVideoFragment();
                                this.l = gameVideoFragment;
                                this.w.add(H(gameVideoFragment, kd5Var));
                                this.x.put(kd5Var.b, this.l);
                                TiebaStatic.log(new StatisticItem("c13483").param("obj_type", "2"));
                            }
                        } else if (i == 202 && !TextUtils.isEmpty(kd5Var.d)) {
                            if (pm6.e(kd5Var.d)) {
                                NewTabWebFragment newTabWebFragment = new NewTabWebFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("tab_code", str2);
                                bundle.putString("tab_name", str);
                                String f = f(kd5Var);
                                kd5Var.d = f;
                                bundle.putString("tab_url", f);
                                bundle.putInt("tab_type", i);
                                bundle.putBoolean("tab_is_second_tab", this.u);
                                newTabWebFragment.setArguments(bundle);
                                b H = H(newTabWebFragment, kd5Var);
                                y28 y28Var = new y28();
                                H.f = y28Var;
                                y28Var.b();
                                newTabWebFragment.C2(H.f);
                                this.w.add(H);
                            } else {
                                Fragment tabWebFragment = new TabWebFragment();
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("tab_code", str2);
                                bundle2.putString("tab_name", str);
                                String f2 = f(kd5Var);
                                kd5Var.d = f2;
                                bundle2.putString("tab_url", f2);
                                bundle2.putInt("tab_type", i);
                                bundle2.putBoolean("tab_is_second_tab", this.u);
                                tabWebFragment.setArguments(bundle2);
                                b H2 = H(tabWebFragment, kd5Var);
                                y28 y28Var2 = new y28();
                                H2.f = y28Var2;
                                y28Var2.b();
                                this.w.add(H2);
                            }
                        }
                    } else {
                        HomePageTabFeedFragment homePageTabFeedFragment = new HomePageTabFeedFragment();
                        this.w.add(H(homePageTabFeedFragment, kd5Var));
                        homePageTabFeedFragment.o2(this.u);
                        this.x.put(kd5Var.b, homePageTabFeedFragment);
                    }
                }
            }
            eka.a("NewScrollFragmentAdapter generateSyncTabFragments:" + this.x);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            int i3 = this.r;
            if (i3 == -1 || (i == i3 && f == 0.0f)) {
                Fragment fragment = (Fragment) ListUtils.getItem(b(), i - 1);
                Fragment fragment2 = (Fragment) ListUtils.getItem(b(), i);
                Fragment fragment3 = (Fragment) ListUtils.getItem(b(), i + 1);
                this.r = -1;
                if (f == 0.0f) {
                    if (fragment instanceof lj7) {
                        ((lj7) fragment).n0();
                    }
                    if (fragment3 instanceof lj7) {
                        ((lj7) fragment3).n0();
                    }
                    if (fragment2 != null) {
                        fragment2.setMenuVisibility(true);
                        fragment2.setUserVisibleHint(true);
                        return;
                    }
                    return;
                }
                if (fragment instanceof lj7) {
                    ((lj7) fragment).Q();
                }
                if (fragment2 instanceof lj7) {
                    ((lj7) fragment2).Q();
                }
                if (fragment3 instanceof lj7) {
                    ((lj7) fragment3).Q();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048623, this, viewGroup, i, obj) == null) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (obj != null && this.s != i) {
                lj7 lj7Var = this.n;
                if (lj7Var instanceof BaseFragment) {
                    ((BaseFragment) lj7Var).setPrimary(false);
                }
                this.s = i;
                VoiceManager b2 = oja.b(this.f);
                if (b2 != null) {
                    b2.stopPlay();
                }
                VoiceManager a2 = oja.a(this.f);
                if (a2 != null) {
                    a2.stopPlay();
                }
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
                if ((obj instanceof PersonalizeFragment) && i == 0) {
                    ((PersonalizeFragment) obj).h();
                }
            }
            if (obj instanceof lj7) {
                this.n = (lj7) obj;
            }
        }
    }
}
