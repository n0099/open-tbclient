package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.e.f.d.l;
import b.a.q0.b.d;
import b.a.q0.c1.i0;
import b.a.q0.c1.l0;
import b.a.q0.f1.b.c;
import b.a.q0.t.c.a0;
import b.a.r0.x0.o0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
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
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes9.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public Context f50400f;

    /* renamed from: g  reason: collision with root package name */
    public ConcernFragment f50401g;

    /* renamed from: h  reason: collision with root package name */
    public PersonalizeFragment f50402h;

    /* renamed from: i  reason: collision with root package name */
    public HotTopicTabFragment f50403i;
    public BaseFragment j;
    public GameVideoFragment k;
    public VideoTabFragment l;
    public o0 m;
    public String n;
    public String o;
    public boolean p;
    public int q;
    public int r;
    public b.a.r0.h1.d.f.a s;
    public List<b> t;
    public List<b> u;

    /* loaded from: classes9.dex */
    public class a extends i0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f50404a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NewScrollFragmentAdapter f50405b;

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
            this.f50405b = newScrollFragmentAdapter;
            this.f50404a = i2;
        }

        @Override // b.a.q0.c1.i0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b.a.q0.s.r.a.f();
                l<String> h2 = b.a.q0.s.r.a.h(this.f50405b.n, TbadkCoreApplication.getCurrentAccount());
                if (h2 != null) {
                    h2.e(this.f50405b.o, Integer.toString(this.f50404a), 43200000L);
                    return null;
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, b.a.r0.h1.d.b bVar, ConcernPageView.l lVar) {
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
        this.r = -1;
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.f50400f = context;
        if (this.s == null) {
            this.s = new b.a.r0.h1.d.f.a();
        }
        List<a0> f2 = this.s.f();
        this.u.clear();
        if (this.f50401g == null) {
            this.f50401g = new ConcernFragment(context);
            c(2);
        }
        this.f50401g.setCallback(lVar);
        if (d.i() && TbadkCoreApplication.isLogin() && b.a.q0.s.e0.b.j().k("key_home_concern_all_status", 0) == 1) {
            this.u.add(newFragmentItem(this.f50401g, 0, e(R.string.attention_person)));
        } else {
            this.u.add(newFragmentItem(this.f50401g, 0, e(R.string.tab_name_concern)));
        }
        if (this.f50402h == null) {
            this.f50402h = new PersonalizeFragment(context);
            c(1);
        }
        this.f50402h.setCallback(bVar);
        this.u.add(newFragmentItem(this.f50402h, 1, e(R.string.tab_name_recommend)));
        for (a0 a0Var : f2) {
            int i4 = a0Var.f14500a;
            String str = a0Var.f14501b;
            String str2 = a0Var.f14502c;
            boolean z = a0Var.f14505f;
            if (!a0Var.c()) {
                if (i4 == 101 || i4 == 201) {
                    this.u.add(newFragmentItem(new HomePageTabFeedFragment(), a0Var));
                } else if (i4 == 5) {
                    if (this.f50403i == null) {
                        c(3);
                        HotTopicTabFragment hotTopicTabFragment = new HotTopicTabFragment(context);
                        this.f50403i = hotTopicTabFragment;
                        this.u.add(newFragmentItem(hotTopicTabFragment, i4, str, str2, z));
                    }
                } else if (i4 == 8) {
                    if (this.l == null) {
                        this.l = new VideoTabFragment();
                        c(5);
                        this.u.add(newFragmentItem(this.l, a0Var));
                    }
                } else if (i4 == 6) {
                    if (this.j == null) {
                        c(4);
                        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class);
                        if (runTask != null && runTask.getData() != null) {
                            BaseFragment baseFragment = (BaseFragment) runTask.getData();
                            this.j = baseFragment;
                            this.u.add(newFragmentItem(baseFragment, a0Var));
                        }
                    }
                } else if (i4 == 7) {
                    if (this.k == null) {
                        GameVideoFragment gameVideoFragment = new GameVideoFragment();
                        this.k = gameVideoFragment;
                        this.u.add(newFragmentItem(gameVideoFragment, a0Var));
                        TiebaStatic.log(new StatisticItem("c13483").param("obj_type", "2"));
                    }
                } else if (i4 == 202 && !TextUtils.isEmpty(a0Var.f14503d)) {
                    Fragment tabWebFragment = new TabWebFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("tab_code", str2);
                    bundle.putString("tab_name", str);
                    bundle.putString(TabWebFragment.TAB_URL, a0Var.f14503d);
                    bundle.putInt("tab_type", i4);
                    tabWebFragment.setArguments(bundle);
                    this.u.add(newFragmentItem(tabWebFragment, a0Var));
                }
            }
        }
        updateFragmentTabItems();
        notifyDataSetChanged();
    }

    public final void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LIVE_TAB_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_type", i2);
            TiebaStaticHelper.addYYParam(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            PersonalizeFragment personalizeFragment = this.f50402h;
            if (personalizeFragment != null && this.m == personalizeFragment) {
                personalizeFragment.completePullRefresh();
            }
            ConcernFragment concernFragment = this.f50401g;
            if (concernFragment == null || this.m != concernFragment) {
                return;
            }
            concernFragment.completePullRefresh();
        }
    }

    public final String e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? TbadkCoreApplication.getInst().getString(i2) : (String) invokeI.objValue;
    }

    public void forceRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Fragment item = getItem(this.r);
            if (item instanceof o0) {
                ((o0) item).refreshPage();
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<b> list = this.t;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public o0 getCurrentFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m : (o0) invokeV.objValue;
    }

    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            o0 o0Var = this.m;
            if (o0Var instanceof BaseFragment) {
                return ((BaseFragment) o0Var).getCurrentPageKey();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int getDefaultPageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.s.d() : invokeV.intValue;
    }

    public int getHotTopicIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            for (int i2 = 0; i2 < this.t.size(); i2++) {
                if (this.t.get(i2).f50411f == 5) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            List<b> list = this.t;
            if (list == null || i2 < 0 || i2 >= list.size() || this.t.get(i2) == null) {
                return null;
            }
            return this.t.get(i2).f50406a;
        }
        return (Fragment) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) ? (getAllFragments() == null || !getAllFragments().contains(obj)) ? -2 : -1 : invokeL.intValue;
    }

    public boolean getItemShowRedDot(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            b bVar = (b) ListUtils.getItem(this.t, i2);
            return bVar != null && bVar.f50408c;
        }
        return invokeI.booleanValue;
    }

    public String getItemTabName(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            b bVar = (b) ListUtils.getItem(this.t, i2);
            return bVar != null ? bVar.f50409d : e(R.string.tab_name_recommend);
        }
        return (String) invokeI.objValue;
    }

    public int getItemType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            b bVar = (b) ListUtils.getItem(this.t, i2);
            if (bVar != null) {
                return bVar.f50411f;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public void getLastBrowseTabByCache(b.a.r0.h1.d.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, dVar) == null) || this.p) {
            return;
        }
        this.p = true;
        dVar.a(1);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            List<b> list = this.t;
            if (list == null || i2 < 0 || i2 >= list.size() || this.t.get(i2) == null) {
                return null;
            }
            return this.t.get(i2).f50407b;
        }
        return (CharSequence) invokeI.objValue;
    }

    public int getPositionByTabCode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            for (int i2 = 0; i2 < this.t.size(); i2++) {
                b bVar = this.t.get(i2);
                if (!TextUtils.isEmpty(str) && str.equals(bVar.f50410e)) {
                    return i2;
                }
            }
            return getRecommendIndex();
        }
        return invokeL.intValue;
    }

    public int getPositionByTabName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            for (int i2 = 0; i2 < this.t.size(); i2++) {
                b bVar = this.t.get(i2);
                if (!TextUtils.isEmpty(str) && str.equals(bVar.f50409d)) {
                    return i2;
                }
            }
            return getRecommendIndex();
        }
        return invokeL.intValue;
    }

    public int getRecommendIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            for (int i2 = 0; i2 < this.t.size(); i2++) {
                if (this.t.get(i2).f50411f == 1) {
                    return i2;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean isConcernFragmentCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f50401g != null : invokeV.booleanValue;
    }

    public boolean isHotTopicFragmentCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f50403i != null : invokeV.booleanValue;
    }

    public b newFragmentItem(Fragment fragment, a0 a0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, fragment, a0Var)) == null) {
            Bundle arguments = fragment.getArguments();
            if (arguments == null) {
                arguments = new Bundle();
            }
            arguments.putString("tab_code", a0Var.f14502c);
            arguments.putString("tab_name", a0Var.f14501b);
            arguments.putInt("tab_type", a0Var.f14500a);
            fragment.setArguments(arguments);
            return new b(fragment, a0Var.f14500a, a0Var.b(), a0Var.f14501b, a0Var.f14502c);
        }
        return (b) invokeLL.objValue;
    }

    public void notifyJumpToLastReadPosition(int i2) {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048601, this, i2) == null) && i2 == 1 && (personalizeFragment = this.f50402h) != null) {
            personalizeFragment.notifyJumpToLastReadPosition();
        }
    }

    public void onChangeSkin(int i2) {
        o0 o0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i2) == null) || (o0Var = this.m) == null) {
            return;
        }
        o0Var.changeSkinType();
    }

    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            int i4 = this.q;
            if (i4 == -1 || (i2 == i4 && f2 == 0.0f)) {
                Fragment fragment = (Fragment) ListUtils.getItem(getAllFragments(), i2 - 1);
                Fragment fragment2 = (Fragment) ListUtils.getItem(getAllFragments(), i2);
                Fragment fragment3 = (Fragment) ListUtils.getItem(getAllFragments(), i2 + 1);
                this.q = -1;
                if (f2 == 0.0f) {
                    if (fragment instanceof o0) {
                        ((o0) fragment).onPageOutEnd();
                    }
                    if (fragment3 instanceof o0) {
                        ((o0) fragment3).onPageOutEnd();
                    }
                    if (fragment2 != null) {
                        fragment2.setMenuVisibility(true);
                        fragment2.setUserVisibleHint(true);
                        return;
                    }
                    return;
                }
                if (fragment instanceof o0) {
                    ((o0) fragment).onPageStartIn();
                }
                if (fragment2 instanceof o0) {
                    ((o0) fragment2).onPageStartIn();
                }
                if (fragment3 instanceof o0) {
                    ((o0) fragment3).onPageStartIn();
                }
            }
        }
    }

    public void reloadCurrentTab() {
        o0 o0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (o0Var = this.m) == null) {
            return;
        }
        o0Var.refreshPage();
    }

    public void reloadTab(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            Fragment fragment = (Fragment) ListUtils.getItem(getAllFragments(), getItemPosition(i2));
            if (fragment == null || !(fragment instanceof o0)) {
                return;
            }
            ((o0) fragment).refreshPage();
        }
    }

    public void saveLastBrowseTabCache(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            l0.b(new a(this, i2), null);
        }
    }

    public void setPrimary(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048607, this, z) == null) && (this.m instanceof BaseFragment)) {
            if (!z) {
                int position = ListUtils.getPosition(getAllFragments(), (BaseFragment) this.m);
                if (position < 0) {
                    position = getItemPosition(1);
                }
                saveLastBrowseTabCache(position);
                d();
            }
            ((BaseFragment) this.m).setPrimary(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048608, this, viewGroup, i2, obj) == null) {
            super.setPrimaryItem(viewGroup, i2, obj);
            if (obj != null && this.r != i2) {
                o0 o0Var = this.m;
                if (o0Var instanceof BaseFragment) {
                    ((BaseFragment) o0Var).setPrimary(false);
                }
                this.r = i2;
                VoiceManager a2 = b.a.r0.m3.r0.b.a(this.f50400f);
                if (a2 != null) {
                    a2.stopPlay();
                }
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
                if ((obj instanceof PersonalizeFragment) && i2 == 0) {
                    ((PersonalizeFragment) obj).forceRefresh();
                }
            }
            if (obj instanceof o0) {
                this.m = (o0) obj;
            }
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, scrollFragmentTabHost) == null) {
            PersonalizeFragment personalizeFragment = this.f50402h;
            if (personalizeFragment != null) {
                personalizeFragment.setScrollFragmentTabHost(scrollFragmentTabHost);
            }
            HotTopicTabFragment hotTopicTabFragment = this.f50403i;
            if (hotTopicTabFragment != null) {
                hotTopicTabFragment.setScrollFragmentTabHost(scrollFragmentTabHost);
            }
            ConcernFragment concernFragment = this.f50401g;
            if (concernFragment != null) {
                concernFragment.setScrollFragmentTabHost(scrollFragmentTabHost);
            }
        }
    }

    public void setTargetItemIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            if (this.r == i2) {
                this.q = -1;
            } else {
                this.q = i2;
            }
        }
    }

    public void setVideoThreadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
        }
    }

    public void showLoadingView() {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (personalizeFragment = this.f50402h) == null) {
            return;
        }
        personalizeFragment.showLoadingView();
    }

    public void startFirstLoad() {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (personalizeFragment = this.f50402h) == null) {
            return;
        }
        personalizeFragment.startFirstLoad();
    }

    public void startRedDotConcernLoad() {
        ConcernFragment concernFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (concernFragment = this.f50401g) == null) {
            return;
        }
        concernFragment.startRedDotLoad();
    }

    public void updateConcernData(DataRes dataRes, boolean z) {
        ConcernFragment concernFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048615, this, dataRes, z) == null) || (concernFragment = this.f50401g) == null) {
            return;
        }
        concernFragment.updateData(dataRes, z);
    }

    public void updateError(String str, int i2, int i3) {
        ConcernFragment concernFragment;
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048616, this, str, i2, i3) == null) {
            if (i3 == 1 && (personalizeFragment = this.f50402h) != null && this.m == personalizeFragment) {
                personalizeFragment.updateError(str, i2);
            }
            if (i3 != 0 || (concernFragment = this.f50401g) == null) {
                return;
            }
            concernFragment.updateError(str, i2);
        }
    }

    public void updateFragmentTabItems() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.t.clear();
            boolean d2 = c.d();
            for (b bVar : this.u) {
                if (d2) {
                    Fragment fragment = bVar.f50406a;
                    if (fragment == this.f50401g || fragment == this.f50402h) {
                        this.t.add(bVar);
                    }
                } else {
                    this.t.add(bVar);
                }
            }
        }
    }

    public void updatePersonalizeData(tbclient.Personalized.DataRes dataRes, boolean z, boolean z2) {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (personalizeFragment = this.f50402h) == null) {
            return;
        }
        personalizeFragment.updateData(dataRes, z, z2);
    }

    public void updatePersonalizePage() {
        PersonalizeFragment personalizeFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || (personalizeFragment = this.f50402h) == null) {
            return;
        }
        personalizeFragment.forceReloadData();
    }

    @Deprecated
    public int getItemPosition(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            for (int i3 = 0; i3 < this.t.size(); i3++) {
                if (this.t.get(i3).f50411f == i2) {
                    return i3;
                }
            }
            return getRecommendIndex();
        }
        return invokeI.intValue;
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Fragment f50406a;

        /* renamed from: b  reason: collision with root package name */
        public String f50407b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f50408c;

        /* renamed from: d  reason: collision with root package name */
        public String f50409d;

        /* renamed from: e  reason: collision with root package name */
        public String f50410e;

        /* renamed from: f  reason: collision with root package name */
        public int f50411f;

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
            this.f50406a = fragment;
            this.f50411f = i2;
            this.f50407b = str;
            this.f50409d = str;
        }

        public b(Fragment fragment, int i2, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragment, Integer.valueOf(i2), str, str2, str3};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f50406a = fragment;
            this.f50411f = i2;
            this.f50407b = str2;
            this.f50407b = str;
            this.f50409d = str2;
            this.f50410e = str3;
        }

        public b(Fragment fragment, int i2, String str, String str2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragment, Integer.valueOf(i2), str, str2, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f50406a = fragment;
            this.f50411f = i2;
            this.f50407b = str;
            this.f50409d = str;
            this.f50410e = str2;
            this.f50408c = z;
        }
    }

    public b newFragmentItem(Fragment fragment, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048598, this, fragment, i2, str)) == null) ? new b(fragment, i2, str) : (b) invokeLIL.objValue;
    }

    public b newFragmentItem(Fragment fragment, int i2, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{fragment, Integer.valueOf(i2), str, str2, Boolean.valueOf(z)})) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("tab_code", str2);
            bundle.putString("tab_name", str);
            bundle.putInt("tab_type", i2);
            fragment.setArguments(bundle);
            return new b(fragment, i2, str, str2, z);
        }
        return (b) invokeCommon.objValue;
    }
}
