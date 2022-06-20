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
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.homepage.tabfeed.h5.TabWebFragment;
import com.baidu.tieba.homepage.video.VideoTabFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ad5;
import com.repackage.bu6;
import com.repackage.ed5;
import com.repackage.ht4;
import com.repackage.jd6;
import com.repackage.lj8;
import com.repackage.mq4;
import com.repackage.te;
import com.repackage.tw4;
import com.repackage.ty6;
import com.repackage.wt6;
import com.repackage.yt6;
import java.util.ArrayList;
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
    public HotTopicTabFragment i;
    public BaseFragment j;
    public GameVideoFragment k;
    public VideoTabFragment l;
    public jd6 m;
    public String n;
    public String o;
    public boolean p;
    public int q;
    public int r;
    public bu6 s;
    public List<b> t;
    public List<b> u;

    /* loaded from: classes3.dex */
    public class a extends ad5<Object> {
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

        @Override // com.repackage.ad5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                mq4.f();
                te<String> h = mq4.h(this.b.n, TbadkCoreApplication.getCurrentAccount());
                if (h != null) {
                    h.e(this.b.o, Integer.toString(this.a), 43200000L);
                    return null;
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, wt6 wt6Var, ConcernPageView.l lVar) {
        super(fragmentManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, fragmentManager, wt6Var, lVar};
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
        this.f = context;
        if (this.s == null) {
            this.s = new bu6();
        }
        List<tw4> g = this.s.g();
        this.u.clear();
        j(context, wt6Var, lVar);
        k(context, g);
        f();
        O();
        notifyDataSetChanged();
    }

    public void A(int i) {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && i == 1 && (personalizeFragment = this.h) != null) {
            personalizeFragment.x1();
        }
    }

    public void B(int i) {
        jd6 jd6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (jd6Var = this.m) == null) {
            return;
        }
        jd6Var.b0();
    }

    public void C() {
        jd6 jd6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (jd6Var = this.m) == null) {
            return;
        }
        jd6Var.t();
    }

    public void D() {
        List<b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (list = this.u) == null) {
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
        bu6 bu6Var = this.s;
        if (bu6Var == null) {
            this.s = new bu6();
        } else {
            bu6Var.j();
        }
        k(this.f, this.s.g());
        f();
        O();
    }

    public void E(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            ed5.b(new a(this, i), null);
        }
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (this.m instanceof BaseFragment)) {
            if (!z) {
                int position = ListUtils.getPosition(b(), (BaseFragment) this.m);
                if (position < 0) {
                    position = n(1);
                }
                E(position);
                g();
            }
            ((BaseFragment) this.m).setPrimary(z);
        }
    }

    public void G(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, scrollFragmentTabHost) == null) {
            PersonalizeFragment personalizeFragment = this.h;
            if (personalizeFragment != null) {
                personalizeFragment.A1(scrollFragmentTabHost);
            }
            HotTopicTabFragment hotTopicTabFragment = this.i;
            if (hotTopicTabFragment != null) {
                hotTopicTabFragment.A1(scrollFragmentTabHost);
            }
            ConcernFragment concernFragment = this.g;
            if (concernFragment != null) {
                concernFragment.y1(scrollFragmentTabHost);
            }
        }
    }

    public void H(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            if (this.r == i) {
                this.q = -1;
            } else {
                this.q = i;
            }
        }
    }

    public void I(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
        }
    }

    public void J() {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (personalizeFragment = this.h) == null) {
            return;
        }
        personalizeFragment.C1();
    }

    public void L() {
        ConcernFragment concernFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (concernFragment = this.g) == null) {
            return;
        }
        concernFragment.A1();
    }

    public void M(DataRes dataRes, boolean z) {
        ConcernFragment concernFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, dataRes, z) == null) || (concernFragment = this.g) == null) {
            return;
        }
        concernFragment.B1(dataRes, z);
    }

    public void N(String str, int i, int i2) {
        ConcernFragment concernFragment;
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048588, this, str, i, i2) == null) {
            if (i2 == 1 && (personalizeFragment = this.h) != null) {
                personalizeFragment.E1(str, i);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("updateError ");
                sb.append(i2);
                sb.append(" ");
                sb.append(this.h != null);
                sb.append(" ");
                sb.append(this.m == this.h);
                ty6.a(sb.toString());
                ty6.a("updateError : mCurrentFragmentName : " + this.m.getClass().getName() + "  mCurrentFragment instance : " + this.m + "  mPersonalizeFragment instance : " + this.h);
            }
            if (i2 != 0 || (concernFragment = this.g) == null) {
                return;
            }
            concernFragment.C1(str, i);
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.t.clear();
            for (b bVar : this.u) {
                this.t.add(bVar);
            }
        }
    }

    public void P(tbclient.Personalized.DataRes dataRes, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.h == null) {
            return;
        }
        ty6.a("mPersonalizeFragmentSuccess");
        this.h.D1(dataRes, z, z2);
    }

    public void Q() {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (personalizeFragment = this.h) == null) {
            return;
        }
        personalizeFragment.w1();
    }

    public final void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (list = this.u) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            PersonalizeFragment personalizeFragment = this.h;
            if (personalizeFragment != null && this.m == personalizeFragment) {
                personalizeFragment.v1();
            }
            ConcernFragment concernFragment = this.g;
            if (concernFragment == null || this.m != concernFragment) {
                return;
            }
            concernFragment.u1();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, obj)) == null) ? (b() == null || !b().contains(obj)) ? -2 : -1 : invokeL.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            List<b> list = this.t;
            if (list == null || i < 0 || i >= list.size() || this.t.get(i) == null) {
                return null;
            }
            return this.t.get(i).b;
        }
        return (CharSequence) invokeI.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            bu6 bu6Var = this.s;
            if (bu6Var == null) {
                return false;
            }
            return bu6Var.c();
        }
        return invokeV.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            Fragment item = getItem(this.r);
            if (item instanceof jd6) {
                ((jd6) item).t();
            }
        }
    }

    public final void j(Context context, wt6 wt6Var, ConcernPageView.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, context, wt6Var, lVar) == null) {
            if (this.g == null) {
                this.g = new ConcernFragment(context);
                e(2);
            }
            this.g.x1(lVar);
            if (UbsABTestHelper.isConcernForumCardShow() && TbadkCoreApplication.isLogin() && ht4.k().l("key_home_concern_all_status", 0) == 1) {
                this.u.add(x(this.g, 0, v(R.string.obfuscated_res_0x7f0f02b0)));
            } else {
                this.u.add(x(this.g, 0, v(R.string.obfuscated_res_0x7f0f1364)));
            }
            if (this.h == null) {
                this.h = new PersonalizeFragment(context);
                e(1);
            }
            this.h.y1(wt6Var);
            this.u.add(x(this.h, 1, v(R.string.obfuscated_res_0x7f0f136b)));
        }
    }

    public final void k(Context context, List<tw4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, context, list) == null) {
            for (tw4 tw4Var : list) {
                int i = tw4Var.a;
                String str = tw4Var.b;
                String str2 = tw4Var.c;
                boolean z = tw4Var.f;
                if (!tw4Var.d()) {
                    if (i == 101 || i == 201) {
                        this.u.add(z(new HomePageTabFeedFragment(), tw4Var));
                    } else if (i == 5) {
                        if (this.i == null) {
                            e(3);
                            HotTopicTabFragment hotTopicTabFragment = new HotTopicTabFragment(context);
                            this.i = hotTopicTabFragment;
                            this.u.add(y(hotTopicTabFragment, i, str, str2, z));
                        }
                    } else if (i == 8) {
                        if (this.l == null) {
                            this.l = new VideoTabFragment();
                            e(5);
                            this.u.add(z(this.l, tw4Var));
                        }
                    } else if (i == 6) {
                        if (this.j == null) {
                            e(4);
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class);
                            if (runTask != null && runTask.getData() != null) {
                                BaseFragment baseFragment = (BaseFragment) runTask.getData();
                                this.j = baseFragment;
                                this.u.add(z(baseFragment, tw4Var));
                            }
                        }
                    } else if (i == 7) {
                        if (this.k == null) {
                            GameVideoFragment gameVideoFragment = new GameVideoFragment();
                            this.k = gameVideoFragment;
                            this.u.add(z(gameVideoFragment, tw4Var));
                            TiebaStatic.log(new StatisticItem("c13483").param("obj_type", "2"));
                        }
                    } else if (i == 202 && !TextUtils.isEmpty(tw4Var.d)) {
                        Fragment tabWebFragment = new TabWebFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("tab_code", str2);
                        bundle.putString("tab_name", str);
                        bundle.putString("tab_url", tw4Var.d);
                        bundle.putInt("tab_type", i);
                        tabWebFragment.setArguments(bundle);
                        this.u.add(z(tabWebFragment, tw4Var));
                    }
                }
            }
        }
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            jd6 jd6Var = this.m;
            if (jd6Var instanceof BaseFragment) {
                return ((BaseFragment) jd6Var).getCurrentPageKey();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.s.e() : invokeV.intValue;
    }

    @Deprecated
    public int n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
            for (int i2 = 0; i2 < this.t.size(); i2++) {
                if (this.t.get(i2).e == i) {
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i)) == null) {
            b bVar = (b) ListUtils.getItem(this.t, i);
            return bVar != null ? bVar.d : "";
        }
        return (String) invokeI.objValue;
    }

    public void onPageScrolled(int i, float f, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            int i3 = this.q;
            if (i3 == -1 || (i == i3 && f == 0.0f)) {
                Fragment fragment = (Fragment) ListUtils.getItem(b(), i - 1);
                Fragment fragment2 = (Fragment) ListUtils.getItem(b(), i);
                Fragment fragment3 = (Fragment) ListUtils.getItem(b(), i + 1);
                this.q = -1;
                if (f == 0.0f) {
                    if (fragment instanceof jd6) {
                        ((jd6) fragment).W();
                    }
                    if (fragment3 instanceof jd6) {
                        ((jd6) fragment3).W();
                    }
                    if (fragment2 != null) {
                        fragment2.setMenuVisibility(true);
                        fragment2.setUserVisibleHint(true);
                        return;
                    }
                    return;
                }
                if (fragment instanceof jd6) {
                    ((jd6) fragment).y();
                }
                if (fragment2 instanceof jd6) {
                    ((jd6) fragment2).y();
                }
                if (fragment3 instanceof jd6) {
                    ((jd6) fragment3).y();
                }
            }
        }
    }

    public String p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i)) == null) {
            b bVar = (b) ListUtils.getItem(this.t, i);
            return bVar != null ? bVar.c : v(R.string.obfuscated_res_0x7f0f136b);
        }
        return (String) invokeI.objValue;
    }

    public int q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i)) == null) {
            b bVar = (b) ListUtils.getItem(this.t, i);
            if (bVar != null) {
                return bVar.e;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public void r(yt6 yt6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, yt6Var) == null) || this.p) {
            return;
        }
        this.p = true;
        yt6Var.a(1);
    }

    public int s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            for (int i = 0; i < this.t.size(); i++) {
                b bVar = this.t.get(i);
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
        if (interceptable == null || interceptable.invokeLIL(1048612, this, viewGroup, i, obj) == null) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (obj != null && this.r != i) {
                jd6 jd6Var = this.m;
                if (jd6Var instanceof BaseFragment) {
                    ((BaseFragment) jd6Var).setPrimary(false);
                }
                this.r = i;
                VoiceManager a2 = lj8.a(this.f);
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
            if (obj instanceof jd6) {
                this.m = (jd6) obj;
            }
        }
    }

    public int t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) {
            for (int i = 0; i < this.t.size(); i++) {
                b bVar = this.t.get(i);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            for (int i = 0; i < this.t.size(); i++) {
                if (this.t.get(i).e == 1) {
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i)) == null) ? TbadkCoreApplication.getInst().getString(i) : (String) invokeI.objValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.g != null : invokeV.booleanValue;
    }

    public b x(Fragment fragment, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048617, this, fragment, i, str)) == null) ? new b(fragment, i, str) : (b) invokeLIL.objValue;
    }

    public b y(Fragment fragment, int i, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048618, this, new Object[]{fragment, Integer.valueOf(i), str, str2, Boolean.valueOf(z)})) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("tab_code", str2);
            bundle.putString("tab_name", str);
            bundle.putInt("tab_type", i);
            fragment.setArguments(bundle);
            return new b(fragment, i, str, str2, z);
        }
        return (b) invokeCommon.objValue;
    }

    public b z(Fragment fragment, tw4 tw4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048619, this, fragment, tw4Var)) == null) {
            Bundle arguments = fragment.getArguments();
            if (arguments == null) {
                arguments = new Bundle();
            }
            arguments.putString("tab_code", tw4Var.c);
            arguments.putString("tab_name", tw4Var.b);
            arguments.putInt("tab_type", tw4Var.a);
            fragment.setArguments(arguments);
            return new b(fragment, tw4Var.a, tw4Var.c(), tw4Var.b, tw4Var.c);
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
