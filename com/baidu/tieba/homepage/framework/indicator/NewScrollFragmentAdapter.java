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
import com.baidu.tieba.ad;
import com.baidu.tieba.aha;
import com.baidu.tieba.ch6;
import com.baidu.tieba.ee7;
import com.baidu.tieba.fx7;
import com.baidu.tieba.gs5;
import com.baidu.tieba.gx7;
import com.baidu.tieba.gz4;
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
import com.baidu.tieba.ix7;
import com.baidu.tieba.kga;
import com.baidu.tieba.ks5;
import com.baidu.tieba.kx7;
import com.baidu.tieba.lx7;
import com.baidu.tieba.m9;
import com.baidu.tieba.nx7;
import com.baidu.tieba.qb5;
import com.baidu.tieba.w75;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
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
    public ee7 n;
    public String o;
    public String p;
    public boolean q;
    public int r;
    public int s;
    public nx7 t;
    public boolean u;
    public List<c> v;
    public List<c> w;
    public HashMap<String, BaseFragment> x;
    public b y;

    /* loaded from: classes6.dex */
    public interface b {
        void a(Pair<String, String>... pairArr);

        void onStop();
    }

    public void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends gs5<Object> {
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

        @Override // com.baidu.tieba.gs5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                gz4.k();
                m9<String> m = gz4.m(this.b.o, TbadkCoreApplication.getCurrentAccount());
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
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Fragment a;
        public String b;
        public String c;
        public String d;
        public int e;
        @Nullable
        public kx7 f;

        public c(Fragment fragment, int i, String str) {
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

        public c(Fragment fragment, int i, String str, String str2, String str3) {
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

        public c(Fragment fragment, int i, String str, String str2, boolean z) {
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
    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, boolean z, fx7 fx7Var, ConcernPageView.s sVar, b bVar) {
        super(fragmentManager);
        List<w75> h;
        b bVar2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, fragmentManager, Boolean.valueOf(z), fx7Var, sVar, bVar};
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
        aha.a("NewScrollFragmentAdapter init:" + z);
        this.f = context;
        this.y = bVar;
        this.u = z;
        if (this.t == null) {
            this.t = new nx7();
        }
        if (this.u) {
            h = this.t.f();
        } else {
            h = this.t.h();
        }
        this.w.clear();
        this.x.clear();
        m(context, fx7Var, sVar);
        n(context, h);
        h();
        Y();
        notifyDataSetChanged();
        if (this.u && (bVar2 = this.y) != null) {
            bVar2.onStop();
        }
    }

    public int C(int i) {
        InterceptResult invokeI;
        kx7 kx7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            c cVar = (c) ListUtils.getItem(this.v, i);
            if (cVar != null && (kx7Var = cVar.f) != null) {
                return kx7Var.a();
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
            personalizeFragment.i2();
        }
    }

    public void K(int i) {
        ee7 ee7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && (ee7Var = this.n) != null) {
            ee7Var.y0();
        }
    }

    public void N(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            ks5.b(new a(this, i), null);
        }
    }

    public void P(gx7 gx7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, gx7Var) == null) {
            PersonalizeFragment personalizeFragment = this.h;
            if (personalizeFragment != null) {
                personalizeFragment.k2(gx7Var);
            }
            if (gx7Var instanceof ScrollFragmentTabHost) {
                ScrollFragmentTabHost scrollFragmentTabHost = (ScrollFragmentTabHost) gx7Var;
                HotTopicTabFragment hotTopicTabFragment = this.j;
                if (hotTopicTabFragment != null) {
                    hotTopicTabFragment.g2(scrollFragmentTabHost);
                }
                ConcernFragment concernFragment = this.g;
                if (concernFragment != null) {
                    concernFragment.j2(scrollFragmentTabHost);
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
            personalizeFragment.m2(z);
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
            c cVar = (c) ListUtils.getItem(this.v, i);
            if (cVar != null) {
                return cVar.d;
            }
            return "";
        }
        return (String) invokeI.objValue;
    }

    public String u(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048625, this, i)) == null) {
            c cVar = (c) ListUtils.getItem(this.v, i);
            if (cVar != null) {
                return cVar.c;
            }
            return D(R.string.obfuscated_res_0x7f0f15f5);
        }
        return (String) invokeI.objValue;
    }

    public int x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048626, this, i)) == null) {
            c cVar = (c) ListUtils.getItem(this.v, i);
            if (cVar != null) {
                return cVar.e;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public void y(ix7 ix7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048627, this, ix7Var) != null) || this.q) {
            return;
        }
        this.q = true;
        ix7Var.a(1);
    }

    public int A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            for (int i = 0; i < this.v.size(); i++) {
                c cVar = this.v.get(i);
                if (!TextUtils.isEmpty(str) && str.equals(cVar.c)) {
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
            List<c> list = this.v;
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
            List<c> list = this.v;
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
            for (c cVar : this.v) {
                if (cVar.a == obj) {
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
                c cVar = this.v.get(i);
                if (!TextUtils.isEmpty(str) && str.equals(cVar.d)) {
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
        ee7 ee7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (ee7Var = this.n) != null) {
            ee7Var.N();
        }
    }

    public void U() {
        ConcernFragment concernFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (concernFragment = this.g) != null) {
            concernFragment.k2();
        }
    }

    public void a0() {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (personalizeFragment = this.h) != null) {
            personalizeFragment.h2();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            List<c> list = this.v;
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
                personalizeFragment.g2();
            }
            ConcernFragment concernFragment = this.g;
            if (concernFragment != null && this.n == concernFragment) {
                concernFragment.f2();
            }
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            nx7 nx7Var = this.t;
            if (nx7Var == null) {
                return false;
            }
            return nx7Var.c();
        }
        return invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            Fragment item = getItem(this.s);
            if (item instanceof ee7) {
                ((ee7) item).N();
            }
        }
    }

    public ee7 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.n;
        }
        return (ee7) invokeV.objValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            for (c cVar : this.v) {
                kx7 kx7Var = cVar.f;
                if (kx7Var != null) {
                    kx7Var.c();
                }
            }
        }
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            ee7 ee7Var = this.n;
            if (ee7Var instanceof BaseFragment) {
                return ((BaseFragment) ee7Var).getCurrentPageKey();
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

    public c F(Fragment fragment, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048581, this, fragment, i, str)) == null) {
            return new c(fragment, i, str);
        }
        return (c) invokeLIL.objValue;
    }

    public void W(String str, int i, int i2) {
        ConcernFragment concernFragment;
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048598, this, str, i, i2) == null) {
            if (i2 == 1 && (personalizeFragment = this.h) != null) {
                personalizeFragment.o2(str, i);
            }
            if (i2 == 0 && (concernFragment = this.g) != null) {
                concernFragment.m2(str, i);
            }
        }
    }

    public void Z(DataRes dataRes, boolean z, boolean z2) {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (personalizeFragment = this.h) != null) {
            personalizeFragment.n2(dataRes, z, z2);
        }
    }

    public c G(Fragment fragment, int i, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{fragment, Integer.valueOf(i), str, str2, Boolean.valueOf(z)})) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("tab_code", str2);
            bundle.putString("tab_name", str);
            bundle.putInt("tab_type", i);
            fragment.setArguments(bundle);
            return new c(fragment, i, str, str2, z);
        }
        return (c) invokeCommon.objValue;
    }

    public c H(Fragment fragment, w75 w75Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, fragment, w75Var)) == null) {
            Bundle arguments = fragment.getArguments();
            if (arguments == null) {
                arguments = new Bundle();
            }
            arguments.putString("tab_code", w75Var.c);
            arguments.putString("tab_name", w75Var.b);
            arguments.putInt("tab_type", w75Var.a);
            fragment.setArguments(arguments);
            return new c(fragment, w75Var.a, w75Var.e(), w75Var.b, w75Var.c);
        }
        return (c) invokeLL.objValue;
    }

    public void I(String str) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            int hashCode = str.hashCode();
            if (hashCode != 674261) {
                if (hashCode == 824488 && str.equals("推荐")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (str.equals("关注")) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 != 1) {
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
        List<c> list;
        List<w75> h;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || (list = this.w) == null) {
            return;
        }
        Iterator<c> it = list.iterator();
        while (it.hasNext()) {
            c next = it.next();
            Fragment fragment = next.a;
            if (!(fragment instanceof ConcernFragment) && !(fragment instanceof PersonalizeWrapperFragment) && !(fragment instanceof HotTopicTabFragment)) {
                it.remove();
                kx7 kx7Var = next.f;
                if (kx7Var != null) {
                    kx7Var.c();
                }
            }
        }
        this.k = null;
        this.l = null;
        this.m = null;
        nx7 nx7Var = this.t;
        if (nx7Var == null) {
            this.t = new nx7();
        } else {
            nx7Var.k();
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
        ee7 ee7Var = this.n;
        if (ee7Var instanceof TabWebFragment) {
            ee7Var.N();
        }
    }

    public void g() {
        HashMap<String, qb5> colourHeaderConfig;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048604, this) != null) || (colourHeaderConfig = TbSingleton.getInstance().getColourHeaderConfig()) == null) {
            return;
        }
        Iterator<Fragment> it = b().iterator();
        while (it.hasNext()) {
            Fragment next = it.next();
            if (next instanceof TabWebFragment) {
                TabWebFragment tabWebFragment = (TabWebFragment) next;
                qb5 qb5Var = colourHeaderConfig.get(tabWebFragment.F2());
                if (qb5Var != null && !TextUtils.isEmpty(qb5Var.j()) && !TextUtils.isEmpty(tabWebFragment.a) && !tabWebFragment.a.contains("bgImg=")) {
                    String str = tabWebFragment.a;
                    tabWebFragment.k2(UtilHelper.urlAddParam(str, "bgImg=" + ad.getUrlEncode(qb5Var.j())));
                }
            }
        }
    }

    public void Q(String str, int i) {
        kx7 kx7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, str, i) == null) {
            for (int i2 = 0; i2 < this.v.size(); i2++) {
                c cVar = this.v.get(i2);
                if (!TextUtils.isEmpty(str) && str.equals(cVar.d) && (kx7Var = cVar.f) != null) {
                    kx7Var.d(i);
                }
            }
        }
    }

    public void V(tbclient.Userlike.DataRes dataRes, boolean z) {
        ConcernFragment concernFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048597, this, dataRes, z) == null) && (concernFragment = this.g) != null) {
            concernFragment.l2(dataRes, z);
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.v.clear();
            aha.a("NewScrollFragmentAdapter updateFragmentTabItems start");
            for (c cVar : this.w) {
                this.v.add(cVar);
                aha.a("NewScrollFragmentAdapter updateFragmentTabItems:" + cVar.c + " " + cVar.a);
            }
            aha.a("NewScrollFragmentAdapter updateFragmentTabItems end");
        }
    }

    public final String f(@NonNull w75 w75Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, w75Var)) == null) {
            String str = w75Var.d;
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            HashMap<String, qb5> colourHeaderConfig = TbSingleton.getInstance().getColourHeaderConfig();
            if (colourHeaderConfig == null) {
                return str;
            }
            qb5 qb5Var = colourHeaderConfig.get(w75Var.b);
            if (qb5Var != null && !TextUtils.isEmpty(qb5Var.j()) && !str.contains("bgImg=")) {
                w75Var.j = true;
                return UtilHelper.urlAddParam(str, "bgImg=" + ad.getUrlEncode(qb5Var.j()));
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final void h() {
        List<c> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || (list = this.w) == null) {
            return;
        }
        for (c cVar : list) {
            if (cVar != null) {
                Fragment fragment = cVar.a;
                if (fragment instanceof BaseFragment) {
                    ((BaseFragment) fragment).setTbPageExtraPageTabName(cVar.c);
                }
            }
        }
    }

    public final void m(Context context, fx7 fx7Var, ConcernPageView.s sVar) {
        String D;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048614, this, context, fx7Var, sVar) == null) {
            if (this.g == null) {
                this.g = new ConcernFragment(context);
                e(2);
            }
            this.g.i2(sVar);
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
                this.w.add(G(this.i, 1, D(R.string.obfuscated_res_0x7f0f15f5), BdUniDispatchSchemeController.PARAM_RECOMMEND, false));
            } else if (!PermissionUtil.isBrowseMode()) {
                if (this.h == null) {
                    this.h = new PersonalizeFragment(context);
                    e(1);
                }
                this.h.j2(fx7Var);
                List<c> list = this.w;
                PersonalizeFragment personalizeFragment = this.h;
                if (this.u) {
                    D = D(R.string.obfuscated_res_0x7f0f02a0);
                } else {
                    D = D(R.string.obfuscated_res_0x7f0f15f5);
                }
                list.add(F(personalizeFragment, 1, D));
            }
            if (this.w.isEmpty() && this.u && (bVar = this.y) != null) {
                bVar.a(new Pair<>(PushMessageHelper.ERROR_TYPE, "home_recommend"), new Pair<>("error_info", "home recommend local data empty"));
            }
            for (int i = 0; i < this.w.size(); i++) {
                c cVar = this.w.get(i);
                aha.a("NewScrollFragmentAdapter generateLocalTabFragments" + i + " " + cVar.c + " " + cVar.a);
            }
        }
    }

    public final void n(Context context, List<w75> list) {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, context, list) == null) {
            for (w75 w75Var : list) {
                int i = w75Var.a;
                String str = w75Var.b;
                String str2 = w75Var.c;
                boolean z = w75Var.f;
                if (!w75Var.f()) {
                    if (i != 101 && i != 201) {
                        if (i == 5) {
                            if (this.j == null) {
                                e(3);
                                HotTopicTabFragment hotTopicTabFragment = new HotTopicTabFragment(context);
                                this.j = hotTopicTabFragment;
                                this.w.add(G(hotTopicTabFragment, i, str, str2, z));
                                this.x.put(w75Var.b, this.j);
                            }
                        } else if (i == 8) {
                            if (this.m == null) {
                                this.m = new VideoTabFragment();
                                e(5);
                                this.w.add(H(this.m, w75Var));
                                this.x.put(w75Var.b, this.m);
                            }
                        } else if (i == 6) {
                            if (!PermissionUtil.isBrowseMode() && this.k == null) {
                                e(4);
                                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class);
                                if (runTask != null && runTask.getData() != null) {
                                    BaseFragment baseFragment = (BaseFragment) runTask.getData();
                                    this.k = baseFragment;
                                    this.w.add(H(baseFragment, w75Var));
                                }
                            }
                        } else if (i == 7) {
                            if (this.l == null) {
                                GameVideoFragment gameVideoFragment = new GameVideoFragment();
                                this.l = gameVideoFragment;
                                this.w.add(H(gameVideoFragment, w75Var));
                                this.x.put(w75Var.b, this.l);
                                TiebaStatic.log(new StatisticItem("c13483").param("obj_type", "2"));
                            }
                        } else if (i == 202 && !TextUtils.isEmpty(w75Var.d)) {
                            if (ch6.e(w75Var.d)) {
                                NewTabWebFragment newTabWebFragment = new NewTabWebFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("tab_code", str2);
                                bundle.putString("tab_name", str);
                                String f = f(w75Var);
                                w75Var.d = f;
                                bundle.putString("tab_url", f);
                                bundle.putInt("tab_type", i);
                                bundle.putBoolean("tab_is_second_tab", this.u);
                                newTabWebFragment.setArguments(bundle);
                                c H = H(newTabWebFragment, w75Var);
                                lx7 lx7Var = new lx7();
                                H.f = lx7Var;
                                lx7Var.b();
                                newTabWebFragment.I2(H.f);
                                this.w.add(H);
                            } else {
                                Fragment tabWebFragment = new TabWebFragment();
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("tab_code", str2);
                                bundle2.putString("tab_name", str);
                                String f2 = f(w75Var);
                                w75Var.d = f2;
                                bundle2.putString("tab_url", f2);
                                bundle2.putInt("tab_type", i);
                                bundle2.putBoolean("tab_is_second_tab", this.u);
                                tabWebFragment.setArguments(bundle2);
                                c H2 = H(tabWebFragment, w75Var);
                                lx7 lx7Var2 = new lx7();
                                H2.f = lx7Var2;
                                lx7Var2.b();
                                this.w.add(H2);
                            }
                        }
                    } else {
                        HomePageTabFeedFragment homePageTabFeedFragment = new HomePageTabFeedFragment();
                        this.w.add(H(homePageTabFeedFragment, w75Var));
                        homePageTabFeedFragment.u2(this.u);
                        this.x.put(w75Var.b, homePageTabFeedFragment);
                    }
                }
            }
            if (this.w.isEmpty() && this.u && (bVar = this.y) != null) {
                bVar.a(new Pair<>(PushMessageHelper.ERROR_TYPE, "home_recommend"), new Pair<>("error_info", "home recommend sync data empty"));
            }
            aha.a("NewScrollFragmentAdapter generateSyncTabFragments:" + this.x);
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
                    if (fragment instanceof ee7) {
                        ((ee7) fragment).t0();
                    }
                    if (fragment3 instanceof ee7) {
                        ((ee7) fragment3).t0();
                    }
                    if (fragment2 != null) {
                        fragment2.setMenuVisibility(true);
                        fragment2.setUserVisibleHint(true);
                        return;
                    }
                    return;
                }
                if (fragment instanceof ee7) {
                    ((ee7) fragment).Y();
                }
                if (fragment2 instanceof ee7) {
                    ((ee7) fragment2).Y();
                }
                if (fragment3 instanceof ee7) {
                    ((ee7) fragment3).Y();
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
                ee7 ee7Var = this.n;
                if (ee7Var instanceof BaseFragment) {
                    ((BaseFragment) ee7Var).setPrimary(false);
                }
                this.s = i;
                VoiceManager b2 = kga.b(this.f);
                if (b2 != null) {
                    b2.stopPlay();
                }
                VoiceManager a2 = kga.a(this.f);
                if (a2 != null) {
                    a2.stopPlay();
                }
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
                if ((obj instanceof PersonalizeFragment) && i == 0) {
                    ((PersonalizeFragment) obj).i();
                }
            }
            if (obj instanceof ee7) {
                this.n = (ee7) obj;
            }
        }
    }
}
