package com.baidu.tieba.frs;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionStatic;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import com.baidu.tieba.a29;
import com.baidu.tieba.b29;
import com.baidu.tieba.eh;
import com.baidu.tieba.er6;
import com.baidu.tieba.fj;
import com.baidu.tieba.fo4;
import com.baidu.tieba.gm8;
import com.baidu.tieba.ki6;
import com.baidu.tieba.ko6;
import com.baidu.tieba.ku8;
import com.baidu.tieba.lo6;
import com.baidu.tieba.nr6;
import com.baidu.tieba.p95;
import com.baidu.tieba.q95;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.ws6;
import com.baidu.tieba.xs6;
import com.baidu.tieba.yc5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.FrsPage.ActivityConfig;
import tbclient.FrsTabInfo;
import tbclient.ItemInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class FrsTabHostFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;
    public ko6 b;
    public ki6 c;
    public FrsFragment d;
    public FragmentTabHost e;
    public FrameLayout f;
    public gm8 g;
    public int h;
    public int i;
    public b29 j;
    public OvalActionButton k;
    public FRSRefreshButton l;
    public ku8 m;
    public er6 n;
    public a29 o;
    public boolean p;
    public final View.OnClickListener q;
    public er6.d r;

    /* loaded from: classes4.dex */
    public class c implements FragmentTabHost.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabHostFragment a;

        /* loaded from: classes4.dex */
        public class a implements fo4 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FragmentTabHost.b a;
            public final /* synthetic */ int b;
            public final /* synthetic */ boolean c;
            public final /* synthetic */ c d;

            public a(c cVar, FragmentTabHost.b bVar, int i, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, bVar, Integer.valueOf(i), Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = cVar;
                this.a = bVar;
                this.b = i;
                this.c = z;
            }

            @Override // com.baidu.tieba.fo4
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    if (z) {
                        if (TbadkApplication.getInst().getCurrentActivity() instanceof TbPageContextSupport) {
                            UrlManager.getInstance().dealOneLink(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), new String[]{UrlSchemaHelper.GO_TO_YY_PERSONAL_CENTER_PAGE});
                            return;
                        }
                        return;
                    }
                    this.d.a.a2(this.a, this.b);
                    this.d.a.e.t(this.b, this.c);
                }
            }

            @Override // com.baidu.tieba.fo4
            public void onFail() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    a(false);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements fo4 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FrsTabInfo a;
            public final /* synthetic */ FragmentTabHost.b b;
            public final /* synthetic */ int c;
            public final /* synthetic */ boolean d;
            public final /* synthetic */ c e;

            public b(c cVar, FrsTabInfo frsTabInfo, FragmentTabHost.b bVar, int i, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, frsTabInfo, bVar, Integer.valueOf(i), Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = cVar;
                this.a = frsTabInfo;
                this.b = bVar;
                this.c = i;
                this.d = z;
            }

            @Override // com.baidu.tieba.fo4
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    if (z) {
                        if (TbadkApplication.getInst().getCurrentActivity() instanceof TbPageContextSupport) {
                            UrlManager.getInstance().dealOneLink(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), new String[]{this.a.tab_url});
                            return;
                        }
                        return;
                    }
                    this.e.a.a2(this.b, this.c);
                    this.e.a.e.t(this.c, this.d);
                }
            }

            @Override // com.baidu.tieba.fo4
            public void onFail() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    a(false);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabHostFragment;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) != null) {
                return invokeCommon.booleanValue;
            }
            FrsTabInfo Q1 = this.a.Q1(i);
            String str = null;
            Bundle bundle = null;
            str = null;
            if (Q1 != null && Q1.tab_type.intValue() == 11) {
                ThirdStatisticHelper.sendReq(Q1.click_monitor_url);
                String str2 = Q1.tab_url;
                if (!TextUtils.isEmpty(Q1.demote_url)) {
                    str2 = SchemeActionStatic.wrapThirdDeeplink(Q1.tab_url, Q1.demote_url);
                    bundle = new Bundle();
                    bundle.putBoolean(BaseWebViewActivity.BUNDLE_NEED_EXTRA_PARAM, false);
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) this.a.a.getPageContext(), new String[]{str2}, true, bundle);
                return false;
            }
            FragmentTabHost.b f = this.a.e.f(i);
            if (this.a.g != null && this.a.g.getForum() != null) {
                str = this.a.g.getForum().getId();
            }
            this.a.D1(f, str);
            int i2 = f.a;
            if (i2 == 5) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.a.a.getPageContext().getPageActivity());
                    return false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, new a(this, f, i, z)));
                return false;
            } else if (i2 == 305) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.a.a.getPageContext().getPageActivity());
                    return false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, new b(this, Q1, f, i, z)));
                return false;
            } else {
                this.a.a2(f, i);
                return true;
            }
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                this.a.e.getCurrentFragment();
                int O1 = this.a.O1(i);
                if (O1 != 1) {
                    this.a.d.L3();
                } else {
                    this.a.d.Z4();
                }
                if (O1 != 1) {
                    if (O1 != 4 && O1 != 25) {
                        if (this.a.d != null) {
                            this.a.d.A4(false);
                        }
                        this.a.k.setVisibility(8);
                        this.a.V1();
                    } else if (this.a.k.getVisibility() == 8) {
                        this.a.k.setVisibility(0);
                    }
                    if (this.a.d != null) {
                        this.a.d.p4(false);
                        return;
                    }
                    return;
                }
                if (this.a.d != null) {
                    this.a.d.A4(true);
                }
                this.a.k.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabHostFragment a;

        public a(FrsTabHostFragment frsTabHostFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabHostFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabHostFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null || WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            this.a.i2();
            if (this.a.e == null) {
                return;
            }
            String str = null;
            if (this.a.g != null && this.a.g.getForum() != null) {
                str = this.a.g.getForum().getId();
            }
            this.a.E1(str);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements er6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabHostFragment a;

        @Override // com.baidu.tieba.er6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            }
        }

        @Override // com.baidu.tieba.er6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }

        public b(FrsTabHostFragment frsTabHostFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabHostFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabHostFragment;
        }

        @Override // com.baidu.tieba.er6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                if (!z || i != 502) {
                    if (!z) {
                        if (i == 502) {
                            this.a.U1();
                            return;
                        } else {
                            this.a.h2(-1);
                            return;
                        }
                    }
                    this.a.h2(0);
                    return;
                }
                this.a.h2(1);
            }
        }
    }

    public FrsTabHostFragment(ko6 ko6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ko6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = 0;
        this.q = new a(this);
        this.r = new b(this);
        this.b = ko6Var;
    }

    public final int O1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            ki6 ki6Var = this.c;
            if (ki6Var == null || i >= ListUtils.getCount(ki6Var.f())) {
                return -1;
            }
            return ((FrsTabInfo) this.c.f().get(i)).tab_id.intValue();
        }
        return invokeI.intValue;
    }

    public final int P1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            ki6 ki6Var = this.c;
            if (ki6Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(ki6Var.f());
            for (int i2 = 0; i2 < count; i2++) {
                if (((FrsTabInfo) this.c.f().get(i2)).tab_id.intValue() == i) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bundle) == null) {
            this.m = new ku8(this.a.getPageContext());
            er6 er6Var = new er6(this.a.getPageContext());
            this.n = er6Var;
            er6Var.i(this.r);
            this.o = new a29(this.a, "frs", 2, "2");
            super.onActivityCreated(bundle);
        }
    }

    public final FrsTabInfo Q1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            ki6 ki6Var = this.c;
            if (ki6Var != null && i < ListUtils.getCount(ki6Var.f())) {
                return (FrsTabInfo) this.c.f().get(i);
            }
            return null;
        }
        return (FrsTabInfo) invokeI.objValue;
    }

    public FragmentTabHost.b R1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            FragmentTabHost fragmentTabHost = this.e;
            if (fragmentTabHost == null) {
                return null;
            }
            return fragmentTabHost.f(i);
        }
        return (FragmentTabHost.b) invokeI.objValue;
    }

    public void c2(int i) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048601, this, i) != null) || (fragmentTabHost = this.e) == null) {
            return;
        }
        fragmentTabHost.setCurrentTab(i);
    }

    public void d2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.h = i;
        }
    }

    public void e2(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, frsFragment) == null) {
            this.d = frsFragment;
        }
    }

    public void f2(FRSRefreshButton fRSRefreshButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, fRSRefreshButton) == null) {
            this.l = fRSRefreshButton;
        }
    }

    public void g2(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, ovalActionButton) == null) {
            this.k = ovalActionButton;
            ovalActionButton.setOnClickListener(this.q);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            FragmentTabHost fragmentTabHost = this.e;
            if (fragmentTabHost != null) {
                fragmentTabHost.p(TbadkCoreApplication.getInst().getSkinType());
            }
            b29 b29Var = this.j;
            if (b29Var != null) {
                b29Var.d(i);
            }
            a29 a29Var = this.o;
            if (a29Var != null) {
                a29Var.i(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    public final void D1(FragmentTabHost.b bVar, String str) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, str) == null) {
            TiebaStatic.log(new StatisticItem("c12334").param("obj_locate", M1(bVar)).param("fid", str));
            if (bVar != null && (runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(eh.g(str, 0L)))) != null && ((Boolean) runTask.getData()).booleanValue()) {
                int i = bVar.a;
                if (i == 1) {
                    StatisticItem statisticItem = new StatisticItem("c12905");
                    TiebaStaticHelper.addYYParam(statisticItem);
                    TiebaStatic.log(statisticItem);
                } else if (i == 5) {
                    StatisticItem statisticItem2 = new StatisticItem("c12907");
                    TiebaStaticHelper.addYYParam(statisticItem2);
                    TiebaStatic.log(statisticItem2);
                } else if (i == 305) {
                    StatisticItem statisticItem3 = new StatisticItem("c12906");
                    TiebaStaticHelper.addYYParam(statisticItem3);
                    TiebaStatic.log(statisticItem3);
                }
            }
        }
    }

    public final void E1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            FragmentTabHost fragmentTabHost = this.e;
            if (fragmentTabHost != null) {
                TiebaStatic.log(new StatisticItem("c12342").param("obj_locate", M1(fragmentTabHost.f(fragmentTabHost.getCurrentTabIndex()))).param("fid", str));
            }
            StatisticItem statisticItem = new StatisticItem("c13604");
            if (getPageContext() != null) {
                yc5.b(getPageContext().getPageActivity(), statisticItem);
            }
            FrsFragment frsFragment = this.d;
            if (frsFragment != null) {
                nr6.b(statisticItem, frsFragment.k(), this.d.c());
            }
            nr6.a(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public final int M1(FragmentTabHost.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bVar)) == null) {
            int i = bVar.a;
            if (i != 101) {
                if (i == 1) {
                    return 2;
                }
                if (i == 2) {
                    return 3;
                }
                if (i == 3) {
                    return 4;
                }
                if (i == 99) {
                    return 5;
                }
                if (i == 4) {
                    return 6;
                }
                if (i == 305) {
                    return 7;
                }
                if (i == 5) {
                    return 8;
                }
                if (i == 11) {
                    return 11;
                }
                if (i == 9) {
                    return 9;
                }
                if (i == 8) {
                    return 10;
                }
                if (i == 25) {
                    return 12;
                }
                if (i == 105) {
                    return 13;
                }
                if (i == 106) {
                    return 14;
                }
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public boolean F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            FrsFragment frsFragment = this.d;
            if (frsFragment != null && frsFragment.isAdded() && this.d.getPageContext() != null) {
                lo6.a(this.d.getPageContext(), this.d.O0());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                return this.a.getResources().getColor(R.color.CAM_X0201_1);
            }
            return this.a.getResources().getColor(R.color.CAM_X0201);
        }
        return invokeV.intValue;
    }

    public final int L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ki6 ki6Var = this.c;
            if (ki6Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(ki6Var.f());
            for (int i = 0; i < count; i++) {
                if (((FrsTabInfo) this.c.f().get(i)).tab_id.intValue() == 1) {
                    return i;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void G1(p95 p95Var, q95 q95Var, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        gm8 gm8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, p95Var, q95Var, tbFragmentTabIndicator, str) == null) && q95Var != null && (gm8Var = this.g) != null && gm8Var.getForum() != null) {
            ForumData forum = this.g.getForum();
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            bVar.a = q95Var.e;
            Fragment fragment = q95Var.a;
            bVar.c = fragment;
            boolean z = true;
            if (fragment.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", forum.getName());
                bundle.putString("from", forum.getSpecialForumType());
                bundle.putString("fid", forum.getId());
                bundle.putString("fname", forum.getName());
                bundle.putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
                bVar.c.setArguments(bundle);
            } else {
                bVar.c.getArguments().putString("fid", forum.getId());
                bVar.c.getArguments().putString("fname", forum.getName());
                bVar.c.getArguments().putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
            }
            tbFragmentTabIndicator.setContentTvTopMargin(fj.f(this.a, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(q95Var.d);
            tbFragmentTabIndicator.setTextSize(0, fj.f(this.a.getActivity(), R.dimen.tbds40));
            if (q95Var.i == q95.j && q95Var.e == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(fj.f(this.a, R.dimen.obfuscated_res_0x7f070281), fj.f(this.a.getActivity(), R.dimen.tbds12));
            }
            if (!TextUtils.isEmpty(str)) {
                if (StringHelper.getChineseAndEnglishLength(str) > 8) {
                    str = StringHelper.subString(str, 8);
                }
                tbFragmentTabIndicator.setText(str);
            } else {
                tbFragmentTabIndicator.setText(q95Var.b);
            }
            tbFragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            tbFragmentTabIndicator.setIsContentSelectBold(true);
            tbFragmentTabIndicator.setContentSelectTextSize(getResources().getDimension(R.dimen.tbds46));
            tbFragmentTabIndicator.setContentDefaultTextSize(getResources().getDimension(R.dimen.tbds46));
            tbFragmentTabIndicator.setThemeColorInfo(forum.getThemeColorInfo());
            tbFragmentTabIndicator.setContentSelectTextColor(R.color.CAM_X0105);
            tbFragmentTabIndicator.setContentDefaultTextColor(R.color.CAM_X0107);
            if (!((q95Var.i == q95.j && q95Var.e == 99) ? false : false) && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
                tbFragmentTabIndicator.a(String.valueOf(bVar.a), H1((FragmentTabIndicator) tbFragmentTabIndicator));
            }
            bVar.b = tbFragmentTabIndicator;
            bVar.d = p95Var;
            this.e.a(bVar);
        }
    }

    public final TbFragmentTabIndicator.a H1(FragmentTabIndicator fragmentTabIndicator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fragmentTabIndicator)) == null) {
            int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023b);
            ImageView imageView = new ImageView(this.a);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f080737);
            TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
            fragmentTabIndicator.setTipPosType(1);
            fragmentTabIndicator.setTipTopMargin(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023b));
            aVar.f = fragmentTabIndicator;
            aVar.c = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023b);
            aVar.a = imageView;
            imageView.setVisibility(8);
            return aVar;
        }
        return (TbFragmentTabIndicator.a) invokeL.objValue;
    }

    public final void h2(int i) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048606, this, i) == null) && (frsFragment = this.d) != null) {
            ForumWriteData n3 = frsFragment.n3();
            ItemInfo itemInfo = null;
            if (this.d.O0() != null) {
                itemInfo = this.d.O0().itemInfo;
            }
            if (this.o == null) {
                this.o = new a29(this.a, "frs", 2, "2");
            }
            this.o.j(n3);
            this.o.l(T1());
            this.o.k(itemInfo);
            this.o.m();
        }
    }

    public Fragment J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FragmentTabHost fragmentTabHost = this.e;
            if (fragmentTabHost == null) {
                return null;
            }
            return fragmentTabHost.getCurrentFragment();
        }
        return (Fragment) invokeV.objValue;
    }

    public int K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            FragmentTabHost fragmentTabHost = this.e;
            if (fragmentTabHost == null) {
                return -1;
            }
            return fragmentTabHost.getCurrentTabType();
        }
        return invokeV.intValue;
    }

    public FragmentTabHost N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.e;
        }
        return (FragmentTabHost) invokeV.objValue;
    }

    public b29 S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.j;
        }
        return (b29) invokeV.objValue;
    }

    public final String T1() {
        InterceptResult invokeV;
        FrsViewData O0;
        ActivityConfig activityConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            FrsFragment frsFragment = this.d;
            if (frsFragment == null || (O0 = frsFragment.O0()) == null || (activityConfig = O0.activityConfig) == null) {
                return "";
            }
            return activityConfig.addthread_text;
        }
        return (String) invokeV.objValue;
    }

    public void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, Boolean.FALSE));
            b29 b29Var = this.j;
            if (b29Var != null && b29Var.b()) {
                this.j.a(true);
            }
        }
    }

    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            b29 b29Var = this.j;
            if (b29Var == null) {
                return false;
            }
            return b29Var.b();
        }
        return invokeV.booleanValue;
    }

    public final void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.p) {
                b2(this.g, this.c);
            }
            this.p = false;
        }
    }

    public final FragmentTabHost.a Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return new c(this);
        }
        return (FragmentTabHost.a) invokeV.objValue;
    }

    public final void U1() {
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
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || (frsFragment = this.d) == null || frsFragment.O0() == null || (forum = this.d.O0().getForum()) == null) {
            return;
        }
        ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
        if (themeColorInfo != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            ThemeElement themeElement = themeColorInfo.day;
            if (themeElement != null) {
                str9 = themeElement.light_color;
                str10 = themeElement.dark_color;
                if (skinType == 0) {
                    str8 = themeElement.pattern_image;
                } else {
                    str8 = null;
                }
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
        FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.d.getContext());
        frsProfessionIntroActivityConfig.putColor(str, str2, str3, str4, str5, str6, str7);
        frsProfessionIntroActivityConfig.start();
    }

    public final void Z1(FragmentTabHost.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            int i = bVar.a;
            if (i == 2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_2"));
            } else if (i == 3) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGoodsTab_3"));
            } else if (i == 101) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsInfoTab_101"));
            } else if (i == 305) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsRankList_305"));
            } else if (i == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsLiveLive_4"));
            } else if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_1"));
            } else if (i == 5) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsLivePersonal_5"));
            } else if (i == 8) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_8"));
            } else if (i == 9) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_9"));
            } else if (i == 11) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameRecommend_11"));
            } else if (i == 12) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsTalkBallTab_12"));
            } else if (i == 25) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsSportsRecommendTab_25"));
            }
        }
    }

    public final void a2(FragmentTabHost.b bVar, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, bVar, i) == null) {
            TbFragmentTabIndicator tbFragmentTabIndicator = bVar.b;
            if (tbFragmentTabIndicator != null) {
                tbFragmentTabIndicator.c();
            }
            if (bVar.b.d(String.valueOf(bVar.a)) != null) {
                if (bVar.b.d(String.valueOf(bVar.a)).a.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    bVar.b.d(String.valueOf(bVar.a)).a.setVisibility(8);
                    Z1(bVar);
                } else if (this.i == i) {
                    Z1(bVar);
                }
            }
            this.i = i;
        }
    }

    public void b2(gm8 gm8Var, ki6 ki6Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, gm8Var, ki6Var) == null) {
            this.p = false;
            if (gm8Var != null && ki6Var != null) {
                FragmentTabHost fragmentTabHost = this.e;
                if (fragmentTabHost == null) {
                    this.g = gm8Var;
                    this.c = ki6Var;
                    this.p = true;
                    return;
                }
                fragmentTabHost.setForumId(gm8Var.getForum().getId());
                this.g = gm8Var;
                this.c = ki6Var;
                ki6Var.m();
                if (ListUtils.isEmpty(this.c.g())) {
                    return;
                }
                List<p95> g = this.c.g();
                List f = this.c.f();
                this.e.setShouldDrawDividerLine(false);
                this.e.setShouldDrawIndicatorLine(false);
                this.e.setShouldDrawTopLine(false);
                this.e.o(false);
                this.e.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0207);
                this.e.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (f.size() == g.size()) {
                    int size = f.size();
                    for (int i = 0; i < size; i++) {
                        p95 p95Var = (p95) g.get(i);
                        if (p95Var != null) {
                            FrsTabInfo frsTabInfo = (FrsTabInfo) f.get(i);
                            if (frsTabInfo != null) {
                                str = frsTabInfo.tab_name;
                            } else {
                                str = "";
                            }
                            if (frsTabInfo != null) {
                                ThirdStatisticHelper.sendReq(frsTabInfo.exposure_monitor_url);
                            }
                            G1(p95Var, p95Var.b(), p95Var.c(this.a.getActivity()), str);
                        }
                    }
                } else {
                    for (p95 p95Var2 : g) {
                        G1(p95Var2, p95Var2.b(), p95Var2.c(this.a.getActivity()), null);
                    }
                }
                this.e.s(g.size());
                this.e.k(2);
                this.e.setViewPagerScrollable(false);
                int P1 = P1(this.h);
                if (P1 < 0) {
                    P1 = P1(this.g.getGameDefaultTabId());
                }
                if (P1 < 0) {
                    P1 = L1();
                }
                if (P1 < 0) {
                    P1 = 0;
                }
                this.h = P1;
                this.i = P1;
                this.b.i0(P1);
                this.b.j0(this.i);
                this.e.setCurrentTab(P1);
                int O1 = O1(P1);
                if (O1 != 1) {
                    FrsFragment frsFragment = this.d;
                    if (frsFragment != null) {
                        frsFragment.p4(false);
                        if (O1 != 4 && O1 != 25) {
                            this.d.A4(false);
                            this.k.setVisibility(8);
                            this.d.L3();
                        }
                    }
                    if (this.g.getForum() != null) {
                        xs6 c2 = ws6.d().c(this.g.getForum().getName());
                        if (O1 == 25) {
                            if (c2 == null) {
                                c2 = new xs6(null);
                            }
                            c2.f(true);
                            ws6.d().e(this.g.getForum().getName(), c2);
                        } else if (c2 != null && c2.c()) {
                            c2.f(false);
                            ws6.d().e(this.g.getForum().getName(), c2);
                        }
                    }
                }
                this.e.p(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void i2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048607, this) != null) || !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a, LoginDialogData.FRS_PUBLISH_RESULT_PAGE))) {
            return;
        }
        ku8 ku8Var = this.m;
        if ((ku8Var != null && ku8Var.c()) || F1()) {
            return;
        }
        if (this.d.E3().K(502) != null) {
            this.n.h(this.d.k(), this.d.E3().C().a);
        } else {
            h2(-1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048611, this, layoutInflater, viewGroup, bundle)) == null) {
            this.a = (BaseFragmentActivity) getActivity();
            if (this.e == null) {
                FragmentTabHost fragmentTabHost = new FragmentTabHost(this.a);
                this.e = fragmentTabHost;
                fragmentTabHost.setClipChildren(false);
                this.e.setClipToPadding(false);
                this.e.setup(getChildFragmentManager());
                this.e.getFragmentTabWidget().setAbsoluteWeight(true);
                this.e.setTabContainerShadowShow(true);
                FrameLayout frameLayout = new FrameLayout(this.a.getActivity());
                this.f = frameLayout;
                frameLayout.setClipChildren(false);
                this.f.setClipToPadding(false);
                this.f.addView(this.e);
                this.e.setOnTabSelectionListener(Y1());
            }
            X1();
            return this.f;
        }
        return (View) invokeLLL.objValue;
    }
}
