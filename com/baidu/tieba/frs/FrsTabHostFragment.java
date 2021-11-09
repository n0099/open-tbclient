package com.baidu.tieba.frs;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import b.a.e.e.p.k;
import b.a.e.e.p.l;
import b.a.r0.d4.f;
import b.a.r0.l3.m;
import b.a.r0.t3.d;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.i0;
import b.a.r0.x0.q2.a.c;
import b.a.r0.x0.w2.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.frs.gametab.FrsTabController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ItemInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes9.dex */
public class FrsTabHostFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f48314e;

    /* renamed from: f  reason: collision with root package name */
    public FrsTabController f48315f;

    /* renamed from: g  reason: collision with root package name */
    public i0 f48316g;

    /* renamed from: h  reason: collision with root package name */
    public FrsFragment f48317h;

    /* renamed from: i  reason: collision with root package name */
    public FragmentTabHost f48318i;
    public FrameLayout j;
    public m k;
    public int l;
    public int m;
    public f n;
    public OvalActionButton o;
    public FRSRefreshButton p;
    public d q;
    public b.a.r0.x0.q2.a.c r;
    public final View.OnClickListener s;
    public c.d t;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabHostFragment f48319e;

        public a(FrsTabHostFragment frsTabHostFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabHostFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48319e = frsTabHostFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            this.f48319e.showWriteThreadView();
            if (this.f48319e.f48318i == null) {
                return;
            }
            String str = null;
            if (this.f48319e.k != null && this.f48319e.k.getForum() != null) {
                str = this.f48319e.k.getForum().getId();
            }
            this.f48319e.n(str);
        }
    }

    /* loaded from: classes9.dex */
    public class b implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabHostFragment f48320a;

        public b(FrsTabHostFragment frsTabHostFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabHostFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48320a = frsTabHostFragment;
        }

        @Override // b.a.r0.x0.q2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                if (z && i2 == 502) {
                    this.f48320a.z(1);
                } else if (z) {
                    this.f48320a.z(0);
                } else if (i2 != 502) {
                    this.f48320a.z(-1);
                } else {
                    this.f48320a.v();
                }
            }
        }

        @Override // b.a.r0.x0.q2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            }
        }

        @Override // b.a.r0.x0.q2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements FragmentTabHost.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabHostFragment f48321a;

        /* loaded from: classes9.dex */
        public class a implements b.a.q0.e.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ FragmentTabHost.b f48322a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f48323b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ boolean f48324c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ c f48325d;

            public a(c cVar, FragmentTabHost.b bVar, int i2, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, bVar, Integer.valueOf(i2), Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48325d = cVar;
                this.f48322a = bVar;
                this.f48323b = i2;
                this.f48324c = z;
            }

            @Override // b.a.q0.e.f
            public void onFail() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    onSwitchGet(false);
                }
            }

            @Override // b.a.q0.e.f
            public void onSwitchGet(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    if (z) {
                        if (TbadkApplication.getInst().getCurrentActivity() instanceof TbPageContextSupport) {
                            UrlManager.getInstance().dealOneLink(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), new String[]{UrlSchemaHelper.GO_TO_YY_PERSONAL_CENTER_PAGE});
                            return;
                        }
                        return;
                    }
                    this.f48325d.f48321a.y(this.f48322a, this.f48323b);
                    this.f48325d.f48321a.f48318i.tbSelectionChanged(this.f48323b, this.f48324c);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b implements b.a.q0.e.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ FrsTabInfo f48326a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ FragmentTabHost.b f48327b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ int f48328c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f48329d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f48330e;

            public b(c cVar, FrsTabInfo frsTabInfo, FragmentTabHost.b bVar, int i2, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, frsTabInfo, bVar, Integer.valueOf(i2), Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48330e = cVar;
                this.f48326a = frsTabInfo;
                this.f48327b = bVar;
                this.f48328c = i2;
                this.f48329d = z;
            }

            @Override // b.a.q0.e.f
            public void onFail() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    onSwitchGet(false);
                }
            }

            @Override // b.a.q0.e.f
            public void onSwitchGet(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    if (z) {
                        if (TbadkApplication.getInst().getCurrentActivity() instanceof TbPageContextSupport) {
                            UrlManager.getInstance().dealOneLink(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), new String[]{this.f48326a.tab_url});
                            return;
                        }
                        return;
                    }
                    this.f48330e.f48321a.y(this.f48327b, this.f48328c);
                    this.f48330e.f48321a.f48318i.tbSelectionChanged(this.f48328c, this.f48329d);
                }
            }
        }

        public c(FrsTabHostFragment frsTabHostFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabHostFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48321a = frsTabHostFragment;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                FrsTabInfo u = this.f48321a.u(i2);
                if (u == null || u.tab_type.intValue() != 11) {
                    FragmentTabHost.b tabSpec = this.f48321a.f48318i.getTabSpec(i2);
                    String str = null;
                    if (this.f48321a.k != null && this.f48321a.k.getForum() != null) {
                        str = this.f48321a.k.getForum().getId();
                    }
                    this.f48321a.m(tabSpec, str);
                    int i3 = tabSpec.f45183a;
                    if (i3 == 5) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(this.f48321a.f48314e.getPageContext().getPageActivity());
                            return false;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, new a(this, tabSpec, i2, z)));
                        return false;
                    } else if (i3 != 305) {
                        this.f48321a.y(tabSpec, i2);
                        return true;
                    } else if (!TbadkCoreApplication.isLogin()) {
                        ViewHelper.skipToLoginActivity(this.f48321a.f48314e.getPageContext().getPageActivity());
                        return false;
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, new b(this, u, tabSpec, i2, z)));
                        return false;
                    }
                }
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f48321a.f48314e.getPageContext(), new String[]{u.tab_url}, true);
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                this.f48321a.f48318i.getCurrentFragment();
                int s = this.f48321a.s(i2);
                if (s != 1) {
                    this.f48321a.f48317h.hideRefreshIcon();
                } else {
                    this.f48321a.f48317h.showRefreshIcon();
                }
                if (s != 1) {
                    if (s == 4 || s == 25) {
                        if (this.f48321a.o.getVisibility() == 8) {
                            this.f48321a.o.setVisibility(0);
                        }
                    } else {
                        if (this.f48321a.f48317h != null) {
                            this.f48321a.f48317h.setIsThreadTab(false);
                        }
                        this.f48321a.o.setVisibility(8);
                        this.f48321a.hideWriteTab();
                    }
                    if (this.f48321a.f48317h != null) {
                        this.f48321a.f48317h.setCanShowSpeedTipView(false);
                        return;
                    }
                    return;
                }
                if (this.f48321a.f48317h != null) {
                    this.f48321a.f48317h.setIsThreadTab(true);
                }
                this.f48321a.o.setVisibility(0);
            }
        }
    }

    public FrsTabHostFragment(FrsTabController frsTabController) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsTabController};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 0;
        this.s = new a(this);
        this.t = new b(this);
        this.f48315f = frsTabController;
    }

    public boolean checkIsForbid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FrsFragment frsFragment = this.f48317h;
            if (frsFragment != null && frsFragment.isAdded() && this.f48317h.getPageContext() != null) {
                b.a.r0.x0.h2.d.a(this.f48317h.getPageContext(), this.f48317h.getFrsViewData());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getBottomNavigationBarColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                return this.f48314e.getResources().getColor(b1.CAM_X0201_1);
            }
            return this.f48314e.getResources().getColor(b1.CAM_X0201);
        }
        return invokeV.intValue;
    }

    public Fragment getCurrentFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            FragmentTabHost fragmentTabHost = this.f48318i;
            if (fragmentTabHost == null) {
                return null;
            }
            return fragmentTabHost.getCurrentFragment();
        }
        return (Fragment) invokeV.objValue;
    }

    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            FragmentTabHost fragmentTabHost = this.f48318i;
            if (fragmentTabHost == null) {
                return -1;
            }
            return fragmentTabHost.getCurrentTabType();
        }
        return invokeV.intValue;
    }

    public FragmentTabHost getTabHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f48318i : (FragmentTabHost) invokeV.objValue;
    }

    public FragmentTabHost.b getTabSpec(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            FragmentTabHost fragmentTabHost = this.f48318i;
            if (fragmentTabHost == null) {
                return null;
            }
            return fragmentTabHost.getTabSpec(i2);
        }
        return (FragmentTabHost.b) invokeI.objValue;
    }

    public f getWriteTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.n : (f) invokeV.objValue;
    }

    public void hideWriteTab() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, Boolean.FALSE));
            f fVar = this.n;
            if (fVar == null || !fVar.l()) {
                return;
            }
            this.n.k(true);
        }
    }

    public boolean isWriteTabShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            f fVar = this.n;
            if (fVar == null) {
                return false;
            }
            return fVar.l();
        }
        return invokeV.booleanValue;
    }

    public final void m(FragmentTabHost.b bVar, String str) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bVar, str) == null) {
            TiebaStatic.log(new StatisticItem("c12334").param("obj_locate", r(bVar)).param("fid", str));
            if (bVar == null || (runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(b.a.e.e.m.b.g(str, 0L)))) == null || !((Boolean) runTask.getData()).booleanValue()) {
                return;
            }
            int i2 = bVar.f45183a;
            if (i2 == 1) {
                StatisticItem statisticItem = new StatisticItem("c12905");
                TiebaStaticHelper.addYYParam(statisticItem);
                TiebaStatic.log(statisticItem);
            } else if (i2 == 5) {
                StatisticItem statisticItem2 = new StatisticItem("c12907");
                TiebaStaticHelper.addYYParam(statisticItem2);
                TiebaStatic.log(statisticItem2);
            } else if (i2 == 305) {
                StatisticItem statisticItem3 = new StatisticItem("c12906");
                TiebaStaticHelper.addYYParam(statisticItem3);
                TiebaStatic.log(statisticItem3);
            }
        }
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            FragmentTabHost fragmentTabHost = this.f48318i;
            if (fragmentTabHost != null) {
                TiebaStatic.log(new StatisticItem("c12342").param("obj_locate", r(fragmentTabHost.getTabSpec(fragmentTabHost.getCurrentTabIndex()))).param("fid", str));
            }
            StatisticItem statisticItem = new StatisticItem("c13604");
            if (getPageContext() != null) {
                b.a.q0.n0.c.b(getPageContext().getPageActivity(), statisticItem);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void o(b.a.q0.h0.b bVar, b.a.q0.h0.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048587, this, bVar, cVar, tbFragmentTabIndicator, str) == null) || cVar == null || (mVar = this.k) == null || mVar.getForum() == null) {
            return;
        }
        ForumData forum = this.k.getForum();
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        bVar2.f45183a = cVar.f12616e;
        Fragment fragment = cVar.f12612a;
        bVar2.f45185c = fragment;
        boolean z = true;
        if (fragment.getArguments() == null) {
            Bundle bundle = new Bundle();
            bundle.putString("name", forum.getName());
            bundle.putString("from", forum.getSpecialForumType());
            bundle.putString("fid", forum.getId());
            bundle.putString("fname", forum.getName());
            bundle.putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
            bVar2.f45185c.setArguments(bundle);
        } else {
            bVar2.f45185c.getArguments().putString("fid", forum.getId());
            bVar2.f45185c.getArguments().putString("fname", forum.getName());
            bVar2.f45185c.getArguments().putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
        }
        tbFragmentTabIndicator.setContentTvTopMargin(l.g(this.f48314e, c1.tbds2));
        tbFragmentTabIndicator.setIconResourceId(cVar.f12615d);
        tbFragmentTabIndicator.setTextSize(0, l.g(this.f48314e.getActivity(), c1.tbds40));
        if (cVar.f12620i == b.a.q0.h0.c.j && cVar.f12616e == 99) {
            tbFragmentTabIndicator.setIconViewWithoutText(l.g(this.f48314e, c1.ds96), l.g(this.f48314e.getActivity(), c1.tbds12));
        }
        if (!TextUtils.isEmpty(str)) {
            if (StringHelper.getChineseAndEnglishLength(str) > 8) {
                str = StringHelper.subString(str, 8);
            }
            tbFragmentTabIndicator.setText(str);
        } else {
            tbFragmentTabIndicator.setText(cVar.f12613b);
        }
        tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        tbFragmentTabIndicator.setTipPosType(1);
        tbFragmentTabIndicator.setIsContentSelectBold(true);
        tbFragmentTabIndicator.setContentSelectTextSize(getResources().getDimension(c1.tbds46));
        tbFragmentTabIndicator.setContentDefaultTextSize(getResources().getDimension(c1.tbds46));
        tbFragmentTabIndicator.setThemeColorInfo(forum.getThemeColorInfo());
        tbFragmentTabIndicator.setContentSelectTextColor(b1.CAM_X0105);
        tbFragmentTabIndicator.setContentDefaultTextColor(b1.CAM_X0107);
        if (!((cVar.f12620i == b.a.q0.h0.c.j && cVar.f12616e == 99) ? false : false) && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
            tbFragmentTabIndicator.addTip(String.valueOf(bVar2.f45183a), p((FragmentTabIndicator) tbFragmentTabIndicator));
        }
        bVar2.f45184b = tbFragmentTabIndicator;
        bVar2.f45186d = bVar;
        this.f48318i.addTabSpec(bVar2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            this.q = new d(this.f48314e.getPageContext());
            b.a.r0.x0.q2.a.c cVar = new b.a.r0.x0.q2.a.c(this.f48314e.getPageContext());
            this.r = cVar;
            cVar.i(this.t);
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            FragmentTabHost fragmentTabHost = this.f48318i;
            if (fragmentTabHost != null) {
                fragmentTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            f fVar = this.n;
            if (fVar != null) {
                fVar.r(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f48314e = (BaseFragmentActivity) getActivity();
            if (this.f48318i == null) {
                FragmentTabHost fragmentTabHost = new FragmentTabHost(this.f48314e);
                this.f48318i = fragmentTabHost;
                fragmentTabHost.setClipChildren(false);
                this.f48318i.setClipToPadding(false);
                this.f48318i.setup(getChildFragmentManager());
                this.f48318i.getFragmentTabWidget().setAbsoluteWeight(true);
                this.f48318i.setTabContainerShadowShow(true);
                FrameLayout frameLayout = new FrameLayout(this.f48314e.getActivity());
                this.j = frameLayout;
                frameLayout.setClipChildren(false);
                this.j.setClipToPadding(false);
                this.j.addView(this.f48318i);
                this.f48318i.setOnTabSelectionListener(w());
            }
            return this.j;
        }
        return (View) invokeLLL.objValue;
    }

    public final TbFragmentTabIndicator.a p(FragmentTabIndicator fragmentTabIndicator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, fragmentTabIndicator)) == null) {
            int dimensionPixelSize = this.f48314e.getResources().getDimensionPixelSize(c1.ds12);
            ImageView imageView = new ImageView(this.f48314e);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
            imageView.setImageResource(d1.icon_frs_tab_new_notify_red_point);
            TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
            fragmentTabIndicator.setTipPosType(1);
            fragmentTabIndicator.setTipTopMargin(this.f48314e.getResources().getDimensionPixelSize(c1.ds12));
            aVar.f45978f = fragmentTabIndicator;
            aVar.f45975c = this.f48314e.getResources().getDimensionPixelSize(c1.ds12);
            aVar.f45973a = imageView;
            imageView.setVisibility(8);
            return aVar;
        }
        return (TbFragmentTabIndicator.a) invokeL.objValue;
    }

    public void processAddTabResponse(m mVar, i0 i0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, mVar, i0Var) == null) || mVar == null || i0Var == null || this.f48318i == null) {
            return;
        }
        this.k = mVar;
        this.f48316g = i0Var;
        i0Var.m();
        if (ListUtils.isEmpty(this.f48316g.g())) {
            return;
        }
        List<b.a.q0.h0.b> g2 = this.f48316g.g();
        List<FrsTabInfo> f2 = this.f48316g.f();
        this.f48318i.setShouldDrawDividerLine(false);
        this.f48318i.setShouldDrawIndicatorLine(false);
        this.f48318i.setShouldDrawTopLine(false);
        this.f48318i.needShowTopDiver(false);
        this.f48318i.getFragmentTabWidget().setBackGroundDrawableResId(b1.CAM_X0207);
        this.f48318i.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (f2.size() == g2.size()) {
            int size = f2.size();
            for (int i2 = 0; i2 < size; i2++) {
                b.a.q0.h0.b bVar = g2.get(i2);
                if (bVar != null) {
                    FrsTabInfo frsTabInfo = f2.get(i2);
                    o(bVar, bVar.getFragmentTabStructure(), bVar.getTabIndicator(this.f48314e.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                }
            }
        } else {
            for (b.a.q0.h0.b bVar2 : g2) {
                o(bVar2, bVar2.getFragmentTabStructure(), bVar2.getTabIndicator(this.f48314e.getActivity()), null);
            }
        }
        this.f48318i.initViewPager(2);
        this.f48318i.setViewPagerScrollable(false);
        int t = t(this.l);
        if (t < 0) {
            t = t(this.k.getGameDefaultTabId());
        }
        if (t < 0) {
            t = q();
        }
        if (t < 0) {
            t = 0;
        }
        this.l = t;
        this.m = t;
        this.f48315f.s0(t);
        this.f48315f.t0(this.m);
        this.f48318i.setCurrentTab(t);
        int s = s(t);
        if (s != 1) {
            FrsFragment frsFragment = this.f48317h;
            if (frsFragment != null) {
                frsFragment.setCanShowSpeedTipView(false);
                if (s != 4 && s != 25) {
                    this.f48317h.setIsThreadTab(false);
                    this.o.setVisibility(8);
                    this.f48317h.hideRefreshIcon();
                }
            }
            if (this.k.getForum() != null) {
                e c2 = b.a.r0.x0.w2.d.d().c(this.k.getForum().getName());
                if (s == 25) {
                    if (c2 == null) {
                        c2 = new e(null);
                    }
                    c2.f(true);
                    b.a.r0.x0.w2.d.d().e(this.k.getForum().getName(), c2);
                } else if (c2 != null && c2.c()) {
                    c2.f(false);
                    b.a.r0.x0.w2.d.d().e(this.k.getForum().getName(), c2);
                }
            }
        }
        this.f48318i.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            i0 i0Var = this.f48316g;
            if (i0Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(i0Var.f());
            for (int i2 = 0; i2 < count; i2++) {
                if (this.f48316g.f().get(i2).tab_id.intValue() == 1) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final int r(FragmentTabHost.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, bVar)) == null) {
            int i2 = bVar.f45183a;
            if (i2 != 101) {
                if (i2 == 1) {
                    return 2;
                }
                if (i2 == 2) {
                    return 3;
                }
                if (i2 == 3) {
                    return 4;
                }
                if (i2 == 99) {
                    return 5;
                }
                if (i2 == 4) {
                    return 6;
                }
                if (i2 == 305) {
                    return 7;
                }
                if (i2 == 5) {
                    return 8;
                }
                if (i2 == 11) {
                    return 11;
                }
                if (i2 == 9) {
                    return 9;
                }
                if (i2 == 8) {
                    return 10;
                }
                if (i2 == 25) {
                    return 12;
                }
                if (i2 == 105) {
                    return 13;
                }
                if (i2 == 106) {
                    return 14;
                }
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public final int s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            i0 i0Var = this.f48316g;
            if (i0Var != null && i2 < ListUtils.getCount(i0Var.f())) {
                return this.f48316g.f().get(i2).tab_id.intValue();
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public void setCurrentTab(int i2) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i2) == null) || (fragmentTabHost = this.f48318i) == null) {
            return;
        }
        fragmentTabHost.setCurrentTab(i2);
    }

    public void setDefaultTabId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.l = i2;
        }
    }

    public void setFrsMainFragment(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, frsFragment) == null) {
            this.f48317h = frsFragment;
        }
    }

    public void setRefreshIcon(FRSRefreshButton fRSRefreshButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, fRSRefreshButton) == null) {
            this.p = fRSRefreshButton;
        }
    }

    public void setWriteIcon(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, ovalActionButton) == null) {
            this.o = ovalActionButton;
            ovalActionButton.setOnClickListener(this.s);
        }
    }

    public void showWriteThreadView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || !ViewHelper.checkUpIsLogin(this.f48314e) || this.q.c() || checkIsForbid()) {
            return;
        }
        if (this.f48317h.getTabController().H(502) != null) {
            this.r.h(this.f48317h.getForumId(), this.f48317h.getTabController().z().f49025a);
        } else {
            z(-1);
        }
    }

    public final int t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
            i0 i0Var = this.f48316g;
            if (i0Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(i0Var.f());
            for (int i3 = 0; i3 < count; i3++) {
                if (this.f48316g.f().get(i3).tab_id.intValue() == i2) {
                    return i3;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final FrsTabInfo u(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) {
            i0 i0Var = this.f48316g;
            if (i0Var == null || i2 >= ListUtils.getCount(i0Var.f())) {
                return null;
            }
            return this.f48316g.f().get(i2);
        }
        return (FrsTabInfo) invokeI.objValue;
    }

    public final void v() {
        FrsFragment frsFragment;
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (frsFragment = this.f48317h) == null || frsFragment.getFrsViewData() == null || (forum = this.f48317h.getFrsViewData().getForum()) == null) {
            return;
        }
        ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
        if (themeColorInfo != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            ThemeElement themeElement = themeColorInfo.day;
            if (themeElement != null) {
                str9 = themeElement.light_color;
                str10 = themeElement.dark_color;
                str8 = skinType == 0 ? themeElement.pattern_image : null;
            } else {
                str8 = null;
                str9 = null;
                str10 = null;
            }
            ThemeElement themeElement2 = themeColorInfo.night;
            if (themeElement2 != null) {
                str11 = themeElement2.light_color;
                str12 = themeElement2.dark_color;
                if (skinType == 1) {
                    str8 = themeElement2.pattern_image;
                }
            } else {
                str11 = null;
                str12 = null;
            }
            ThemeElement themeElement3 = themeColorInfo.dark;
            if (themeElement3 != null) {
                String str13 = themeElement3.light_color;
                String str14 = themeElement3.dark_color;
                if (skinType == 4) {
                    str = themeElement3.pattern_image;
                    str6 = str13;
                } else {
                    str6 = str13;
                    str = str8;
                }
                str2 = str9;
                str3 = str10;
                str7 = str14;
            } else {
                str6 = null;
                str7 = null;
                str = str8;
                str2 = str9;
                str3 = str10;
            }
            str4 = str11;
            str5 = str12;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
        }
        FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.f48317h.getContext());
        frsProfessionIntroActivityConfig.putColor(str, str2, str3, str4, str5, str6, str7);
        frsProfessionIntroActivityConfig.start();
    }

    public final FragmentTabHost.a w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? new c(this) : (FragmentTabHost.a) invokeV.objValue;
    }

    public final void x(FragmentTabHost.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bVar) == null) {
            int i2 = bVar.f45183a;
            if (i2 == 2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_2"));
            } else if (i2 == 3) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGoodsTab_3"));
            } else if (i2 == 101) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsInfoTab_101"));
            } else if (i2 == 305) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsRankList_305"));
            } else if (i2 == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsLiveLive_4"));
            } else if (i2 == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_1"));
            } else if (i2 == 5) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsLivePersonal_5"));
            } else if (i2 == 8) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_8"));
            } else if (i2 == 9) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_9"));
            } else if (i2 == 11) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameRecommend_11"));
            } else if (i2 == 12) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsTalkBallTab_12"));
            } else if (i2 == 25) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsSportsRecommendTab_25"));
            }
        }
    }

    public final void y(FragmentTabHost.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048608, this, bVar, i2) == null) {
            TbFragmentTabIndicator tbFragmentTabIndicator = bVar.f45184b;
            if (tbFragmentTabIndicator != null) {
                tbFragmentTabIndicator.checkAndStartAnimation();
            }
            if (bVar.f45184b.getTip(String.valueOf(bVar.f45183a)) != null) {
                if (bVar.f45184b.getTip(String.valueOf(bVar.f45183a)).f45973a.getVisibility() == 0) {
                    bVar.f45184b.getTip(String.valueOf(bVar.f45183a)).f45973a.setVisibility(8);
                    x(bVar);
                } else if (this.m == i2) {
                    x(bVar);
                }
            }
            this.m = i2;
        }
    }

    public final void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, Boolean.TRUE));
            if (this.n == null) {
                f fVar = new f(this.f48314e.getPageContext(), this.j, "frs");
                this.n = fVar;
                fVar.E("2");
                ItemInfo itemInfo = this.f48317h.getFrsViewData().itemInfo;
                this.n.D((itemInfo == null || itemInfo.id.intValue() <= 0 || k.isEmpty(itemInfo.name)) ? false : true);
            }
            if (this.f48317h.getFrsViewData().getAnti() != null) {
                this.n.A(this.f48317h.getFrsViewData().getAnti().getCanGoods());
            }
            ForumWriteData forumWriteData = this.f48317h.getForumWriteData();
            forumWriteData.setDefaultZone(i2);
            this.n.F(i2 == 1 ? d1.btn_frs_professional_edit_n : 0);
            this.n.B(forumWriteData);
            this.n.C(this.f48317h.getFrsViewData().itemInfo);
            this.n.H(getBottomNavigationBarColor());
            FrsFragment frsFragment = this.f48317h;
            if (frsFragment != null && frsFragment.getFrsViewData() != null) {
                this.n.C(this.f48317h.getFrsViewData().itemInfo);
            }
            UtilHelper.setNavigationBarBackground(this.f48314e, getBottomNavigationBarColor());
            this.n.I(false, null, this.o);
            FrsFragment frsFragment2 = this.f48317h;
            if (frsFragment2 == null || frsFragment2.getFrsViewData() == null || this.f48317h.getFrsViewData().itemInfo == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13721").param("fid", this.f48317h.getForumId()).param("fname", this.f48317h.getForumName()).param("obj_param1", this.f48317h.getFrsViewData().itemInfo.name));
        }
    }
}
