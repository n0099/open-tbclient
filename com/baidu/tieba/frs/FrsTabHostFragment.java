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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.ala.IYYCloudSwitchCallback;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionStatic;
import com.baidu.tbadk.mainTab.FragmentDelegate;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.FragmentTabStructure;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import com.baidu.tieba.a08;
import com.baidu.tieba.a38;
import com.baidu.tieba.cp5;
import com.baidu.tieba.dva;
import com.baidu.tieba.gt7;
import com.baidu.tieba.qdb;
import com.baidu.tieba.rdb;
import com.baidu.tieba.t4b;
import com.baidu.tieba.t58;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.u58;
import com.baidu.tieba.vdb;
import com.baidu.tieba.zz7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.FrsPage.ActivityConfig;
import tbclient.FrsTabInfo;
import tbclient.ItemInfo;
/* loaded from: classes6.dex */
public class FrsTabHostFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;
    public zz7 b;
    public gt7 c;
    public FrsFragment d;
    public FragmentTabHost e;
    public FrameLayout f;
    public dva g;
    public int h;
    public int i;
    public rdb j;
    public OvalActionButton k;
    public FRSRefreshButton l;
    public t4b m;
    public qdb n;
    public boolean o;
    public final View.OnClickListener p;

    /* loaded from: classes6.dex */
    public class b implements FragmentTabHost.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabHostFragment a;

        /* loaded from: classes6.dex */
        public class a implements IYYCloudSwitchCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FragmentTabHost.c a;
            public final /* synthetic */ int b;
            public final /* synthetic */ boolean c;
            public final /* synthetic */ b d;

            public a(b bVar, FragmentTabHost.c cVar, int i, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, cVar, Integer.valueOf(i), Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = bVar;
                this.a = cVar;
                this.b = i;
                this.c = z;
            }

            @Override // com.baidu.tbadk.ala.IYYCloudSwitchCallback
            public void onFail() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    onSwitchGet(false);
                }
            }

            @Override // com.baidu.tbadk.ala.IYYCloudSwitchCallback
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
                    this.d.a.n3(this.a, this.b);
                    this.d.a.e.u(this.b, this.c);
                }
            }
        }

        /* renamed from: com.baidu.tieba.frs.FrsTabHostFragment$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0280b implements IYYCloudSwitchCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FrsTabInfo a;
            public final /* synthetic */ FragmentTabHost.c b;
            public final /* synthetic */ int c;
            public final /* synthetic */ boolean d;
            public final /* synthetic */ b e;

            public C0280b(b bVar, FrsTabInfo frsTabInfo, FragmentTabHost.c cVar, int i, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, frsTabInfo, cVar, Integer.valueOf(i), Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = bVar;
                this.a = frsTabInfo;
                this.b = cVar;
                this.c = i;
                this.d = z;
            }

            @Override // com.baidu.tbadk.ala.IYYCloudSwitchCallback
            public void onFail() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    onSwitchGet(false);
                }
            }

            @Override // com.baidu.tbadk.ala.IYYCloudSwitchCallback
            public void onSwitchGet(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    if (z) {
                        if (TbadkApplication.getInst().getCurrentActivity() instanceof TbPageContextSupport) {
                            UrlManager.getInstance().dealOneLink(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), new String[]{this.a.tab_url});
                            return;
                        }
                        return;
                    }
                    this.e.a.n3(this.b, this.c);
                    this.e.a.e.u(this.c, this.d);
                }
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

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public boolean onPreTabSelectionChange(int i, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) != null) {
                return invokeCommon.booleanValue;
            }
            FrsTabInfo d3 = this.a.d3(i);
            String str = null;
            Bundle bundle = null;
            str = null;
            if (d3 != null && d3.tab_type.intValue() == 11) {
                ThirdStatisticHelper.sendReq(d3.click_monitor_url);
                String str2 = d3.tab_url;
                if (!TextUtils.isEmpty(d3.demote_url)) {
                    str2 = SchemeActionStatic.wrapThirdDeeplink(d3.tab_url, d3.demote_url);
                    bundle = new Bundle();
                    bundle.putBoolean(BaseWebViewActivity.BUNDLE_NEED_EXTRA_PARAM, false);
                }
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.a.getPageContext(), new String[]{str2}, true, bundle);
                return false;
            }
            FragmentTabHost.c g = this.a.e.g(i);
            if (this.a.g != null && this.a.g.getForum() != null) {
                str = this.a.g.getForum().getId();
            }
            this.a.Q2(g, str);
            int i2 = g.a;
            if (i2 == 5) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.a.a.getPageContext().getPageActivity());
                    return false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, new a(this, g, i, z)));
                return false;
            } else if (i2 == 305) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.a.a.getPageContext().getPageActivity());
                    return false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, new C0280b(this, d3, g, i, z)));
                return false;
            } else {
                this.a.n3(g, i);
                return true;
            }
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public void onTabSelectionChanged(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                this.a.e.getCurrentFragment();
                int b3 = this.a.b3(i);
                if (b3 != 1) {
                    this.a.d.c5();
                } else {
                    this.a.d.p6();
                }
                if (b3 != 1) {
                    if (b3 != 4 && b3 != 25) {
                        if (this.a.d != null) {
                            this.a.d.T5(false);
                        }
                        this.a.k.setVisibility(8);
                        this.a.h3();
                    } else if (this.a.k.getVisibility() == 8) {
                        this.a.k.setVisibility(0);
                    }
                    if (this.a.d != null) {
                        this.a.d.K5(false);
                        return;
                    }
                    return;
                }
                if (this.a.d != null) {
                    this.a.d.T5(true);
                }
                this.a.k.setVisibility(0);
            }
        }
    }

    /* loaded from: classes6.dex */
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
            this.a.v3();
            if (this.a.e == null) {
                return;
            }
            String str = null;
            if (this.a.g != null && this.a.g.getForum() != null) {
                str = this.a.g.getForum().getId();
            }
            this.a.R2(str);
        }
    }

    public FrsTabHostFragment(zz7 zz7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zz7Var};
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
        this.p = new a(this);
        this.b = zz7Var;
    }

    public final int b3(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            gt7 gt7Var = this.c;
            if (gt7Var == null || i >= ListUtils.getCount(gt7Var.g())) {
                return -1;
            }
            return this.c.g().get(i).tab_id.intValue();
        }
        return invokeI.intValue;
    }

    public final int c3(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            gt7 gt7Var = this.c;
            if (gt7Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(gt7Var.g());
            for (int i2 = 0; i2 < count; i2++) {
                if (this.c.g().get(i2).tab_id.intValue() == i) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final FrsTabInfo d3(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            gt7 gt7Var = this.c;
            if (gt7Var != null && i < ListUtils.getCount(gt7Var.g())) {
                return this.c.g().get(i);
            }
            return null;
        }
        return (FrsTabInfo) invokeI.objValue;
    }

    public FragmentTabHost.c e3(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            FragmentTabHost fragmentTabHost = this.e;
            if (fragmentTabHost == null) {
                return null;
            }
            return fragmentTabHost.g(i);
        }
        return (FragmentTabHost.c) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bundle) == null) {
            this.m = new t4b(this.a.getPageContext());
            this.n = new qdb(this.a, "frs", 2, "2");
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            FragmentTabHost fragmentTabHost = this.e;
            if (fragmentTabHost != null) {
                fragmentTabHost.r(TbadkCoreApplication.getInst().getSkinType());
            }
            rdb rdbVar = this.j;
            if (rdbVar != null) {
                rdbVar.d(i);
            }
            qdb qdbVar = this.n;
            if (qdbVar != null) {
                qdbVar.i(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    public void p3(int i) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048605, this, i) != null) || (fragmentTabHost = this.e) == null) {
            return;
        }
        fragmentTabHost.setCurrentTab(i);
    }

    public void q3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.h = i;
        }
    }

    public void r3(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, frsFragment) == null) {
            this.d = frsFragment;
        }
    }

    public void s3(FRSRefreshButton fRSRefreshButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, fRSRefreshButton) == null) {
            this.l = fRSRefreshButton;
        }
    }

    public void t3(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, ovalActionButton) == null) {
            this.k = ovalActionButton;
            ovalActionButton.setOnClickListener(this.p);
        }
    }

    public final void Q2(FragmentTabHost.c cVar, String str) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, cVar, str) == null) {
            TiebaStatic.log(new StatisticItem("c12334").param("obj_locate", Z2(cVar)).param("fid", str));
            if (cVar != null && (runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(JavaTypesHelper.toLong(str, 0L)))) != null && ((Boolean) runTask.getData()).booleanValue()) {
                int i = cVar.a;
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

    public final void R2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            FragmentTabHost fragmentTabHost = this.e;
            if (fragmentTabHost != null) {
                TiebaStatic.log(new StatisticItem("c12342").param("obj_locate", Z2(fragmentTabHost.g(fragmentTabHost.getCurrentTabIndex()))).param("fid", str));
            }
            StatisticItem statisticItem = new StatisticItem("c13604");
            if (getPageContext() != null) {
                cp5.b(getPageContext().getPageActivity(), statisticItem);
            }
            FrsFragment frsFragment = this.d;
            if (frsFragment != null) {
                a38.b(statisticItem, frsFragment.w(), this.d.v());
            }
            a38.a(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public final int Z2(FragmentTabHost.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, cVar)) == null) {
            int i = cVar.a;
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

    public boolean S2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            FrsFragment frsFragment = this.d;
            if (frsFragment != null && frsFragment.isAdded() && this.d.getPageContext() != null) {
                a08.a(this.d.getPageContext(), this.d.Q1());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            gt7 gt7Var = this.c;
            if (gt7Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(gt7Var.g());
            for (int i = 0; i < count; i++) {
                if (this.c.g().get(i).tab_id.intValue() == 1) {
                    return i;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void T2(FragmentDelegate fragmentDelegate, FragmentTabStructure fragmentTabStructure, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        dva dvaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, fragmentDelegate, fragmentTabStructure, tbFragmentTabIndicator, str) == null) && fragmentTabStructure != null && (dvaVar = this.g) != null && dvaVar.getForum() != null) {
            ForumData forum = this.g.getForum();
            FragmentTabHost.c cVar = new FragmentTabHost.c();
            cVar.a = fragmentTabStructure.type;
            Fragment fragment = fragmentTabStructure.frag;
            cVar.c = fragment;
            boolean z = true;
            if (fragment.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", forum.getName());
                bundle.putString("from", forum.getSpecialForumType());
                bundle.putString("fid", forum.getId());
                bundle.putString("fname", forum.getName());
                bundle.putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
                cVar.c.setArguments(bundle);
            } else {
                cVar.c.getArguments().putString("fid", forum.getId());
                cVar.c.getArguments().putString("fname", forum.getName());
                cVar.c.getArguments().putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
            }
            tbFragmentTabIndicator.setContentTvTopMargin(BdUtilHelper.getDimens(this.a, R.dimen.tbds2));
            tbFragmentTabIndicator.setIconResourceId(fragmentTabStructure.drawableResId);
            tbFragmentTabIndicator.setTextSize(0, BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.tbds40));
            if (fragmentTabStructure.showIconType == FragmentTabStructure.SHOWICON && fragmentTabStructure.type == 99) {
                tbFragmentTabIndicator.setIconViewWithoutText(BdUtilHelper.getDimens(this.a, R.dimen.obfuscated_res_0x7f070281), BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.tbds12));
            }
            if (!TextUtils.isEmpty(str)) {
                if (StringHelper.getChineseAndEnglishLength(str) > 8) {
                    str = StringHelper.subString(str, 8);
                }
                tbFragmentTabIndicator.setText(str);
            } else {
                tbFragmentTabIndicator.setText(fragmentTabStructure.textResId);
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            tbFragmentTabIndicator.setIsContentSelectBold(true);
            tbFragmentTabIndicator.setContentSelectTextSize(getResources().getDimension(R.dimen.tbds46));
            tbFragmentTabIndicator.setContentDefaultTextSize(getResources().getDimension(R.dimen.tbds46));
            tbFragmentTabIndicator.setThemeColorInfo(forum.getThemeColorInfo());
            tbFragmentTabIndicator.setContentSelectTextColor(R.color.CAM_X0105);
            tbFragmentTabIndicator.setContentDefaultTextColor(R.color.CAM_X0107);
            if (!((fragmentTabStructure.showIconType == FragmentTabStructure.SHOWICON && fragmentTabStructure.type == 99) ? false : false) && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
                tbFragmentTabIndicator.addTip(String.valueOf(cVar.a), U2((FragmentTabIndicator) tbFragmentTabIndicator));
            }
            cVar.b = tbFragmentTabIndicator;
            cVar.d = fragmentDelegate;
            this.e.b(cVar);
        }
    }

    public final TbFragmentTabIndicator.FragmentTapTip U2(FragmentTabIndicator fragmentTabIndicator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fragmentTabIndicator)) == null) {
            int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070364);
            ImageView imageView = new ImageView(this.a);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f08091d);
            TbFragmentTabIndicator.FragmentTapTip fragmentTapTip = new TbFragmentTabIndicator.FragmentTapTip();
            fragmentTabIndicator.setTipPosType(1);
            fragmentTabIndicator.setTipTopMargin(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070364));
            fragmentTapTip.indicator = fragmentTabIndicator;
            fragmentTapTip.offsetX = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070364);
            fragmentTapTip.f1079view = imageView;
            imageView.setVisibility(8);
            return fragmentTapTip;
        }
        return (TbFragmentTabIndicator.FragmentTapTip) invokeL.objValue;
    }

    public final void m3(ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, forumWriteData) == null) && forumWriteData != null && !TextUtils.isEmpty(forumWriteData.forumId)) {
            WriteActivityConfig.newInstance(this.a).setType(9).setForumWriteData(forumWriteData).setFrom("frs").setTitle(g3()).setCallFrom("2").setStatisticFrom(2).setIsWriteTest(true).setFromArticle(vdb.n).send();
        }
    }

    public int V2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a.getResources().getColor(R.color.CAM_X0201);
        }
        return invokeV.intValue;
    }

    public Fragment W2() {
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

    public int X2() {
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

    public FragmentTabHost a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.e;
        }
        return (FragmentTabHost) invokeV.objValue;
    }

    public rdb f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.j;
        }
        return (rdb) invokeV.objValue;
    }

    public final String g3() {
        InterceptResult invokeV;
        FrsViewData Q1;
        ActivityConfig activityConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            FrsFragment frsFragment = this.d;
            if (frsFragment == null || (Q1 = frsFragment.Q1()) == null || (activityConfig = Q1.activityConfig) == null) {
                return "";
            }
            return activityConfig.addthread_text;
        }
        return (String) invokeV.objValue;
    }

    public void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, Boolean.FALSE));
            rdb rdbVar = this.j;
            if (rdbVar != null && rdbVar.b()) {
                this.j.a(true);
            }
        }
    }

    public boolean i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            rdb rdbVar = this.j;
            if (rdbVar == null) {
                return false;
            }
            return rdbVar.b();
        }
        return invokeV.booleanValue;
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.o) {
                o3(this.g, this.c);
            }
            this.o = false;
        }
    }

    public final FragmentTabHost.b k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return new b(this);
        }
        return (FragmentTabHost.b) invokeV.objValue;
    }

    public final void l3(FragmentTabHost.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, cVar) == null) {
            int i = cVar.a;
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

    public final void n3(FragmentTabHost.c cVar, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, cVar, i) == null) {
            TbFragmentTabIndicator tbFragmentTabIndicator = cVar.b;
            if (tbFragmentTabIndicator != null) {
                tbFragmentTabIndicator.checkAndStartAnimation();
            }
            if (cVar.b.getTip(String.valueOf(cVar.a)) != null) {
                if (cVar.b.getTip(String.valueOf(cVar.a)).f1079view.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    cVar.b.getTip(String.valueOf(cVar.a)).f1079view.setVisibility(8);
                    l3(cVar);
                } else if (this.i == i) {
                    l3(cVar);
                }
            }
            this.i = i;
        }
    }

    public void o3(dva dvaVar, gt7 gt7Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, dvaVar, gt7Var) == null) {
            this.o = false;
            if (dvaVar != null && gt7Var != null) {
                FragmentTabHost fragmentTabHost = this.e;
                if (fragmentTabHost == null) {
                    this.g = dvaVar;
                    this.c = gt7Var;
                    this.o = true;
                    return;
                }
                fragmentTabHost.setForumId(dvaVar.getForum().getId());
                this.g = dvaVar;
                this.c = gt7Var;
                gt7Var.n();
                if (ListUtils.isEmpty(this.c.h())) {
                    return;
                }
                List<FragmentDelegate> h = this.c.h();
                List<FrsTabInfo> g = this.c.g();
                this.e.setShouldDrawDividerLine(false);
                this.e.setShouldDrawIndicatorLine(false);
                this.e.setShouldDrawTopLine(false);
                this.e.q(false);
                this.e.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0207);
                this.e.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                if (g.size() == h.size()) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        FragmentDelegate fragmentDelegate = h.get(i);
                        if (fragmentDelegate != null) {
                            FrsTabInfo frsTabInfo = g.get(i);
                            if (frsTabInfo != null) {
                                str = frsTabInfo.tab_name;
                            } else {
                                str = "";
                            }
                            if (frsTabInfo != null) {
                                ThirdStatisticHelper.sendReq(frsTabInfo.exposure_monitor_url);
                            }
                            T2(fragmentDelegate, fragmentDelegate.getFragmentTabStructure(), fragmentDelegate.getTabIndicator(this.a.getActivity()), str);
                        }
                    }
                } else {
                    for (FragmentDelegate fragmentDelegate2 : h) {
                        T2(fragmentDelegate2, fragmentDelegate2.getFragmentTabStructure(), fragmentDelegate2.getTabIndicator(this.a.getActivity()), null);
                    }
                }
                this.e.setFrsBottomBarCount(h.size());
                this.e.j(2);
                this.e.setViewPagerScrollable(false);
                int c3 = c3(this.h);
                if (c3 < 0) {
                    c3 = c3(this.g.getGameDefaultTabId());
                }
                if (c3 < 0) {
                    c3 = Y2();
                }
                if (c3 < 0) {
                    c3 = 0;
                }
                this.h = c3;
                this.i = c3;
                this.b.J0(c3);
                this.b.K0(this.i);
                this.e.setCurrentTab(c3);
                int b3 = b3(c3);
                if (b3 != 1) {
                    FrsFragment frsFragment = this.d;
                    if (frsFragment != null) {
                        frsFragment.K5(false);
                        if (b3 != 4 && b3 != 25) {
                            this.d.T5(false);
                            this.k.setVisibility(8);
                            this.d.c5();
                        }
                    }
                    if (this.g.getForum() != null) {
                        u58 c = t58.d().c(this.g.getForum().getName());
                        if (b3 == 25) {
                            if (c == null) {
                                c = new u58(null);
                            }
                            c.f(true);
                            t58.d().e(this.g.getForum().getName(), c);
                        } else if (c != null && c.c()) {
                            c.f(false);
                            t58.d().e(this.g.getForum().getName(), c);
                        }
                    }
                }
                this.e.r(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048604, this, layoutInflater, viewGroup, bundle)) == null) {
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
                this.e.setOnTabSelectionListener(k3());
            }
            j3();
            return this.f;
        }
        return (View) invokeLLL.objValue;
    }

    public final void u3() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (frsFragment = this.d) != null) {
            ForumWriteData D4 = frsFragment.D4();
            ItemInfo itemInfo = null;
            if (this.d.Q1() != null) {
                itemInfo = this.d.Q1().itemInfo;
            }
            if (this.n == null) {
                this.n = new qdb(this.a, "frs", 2, "2");
            }
            this.n.j(D4);
            this.n.l(g3());
            this.n.k(itemInfo);
            this.n.m();
        }
    }

    public void v3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048611, this) != null) || !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a, LoginDialogData.FRS_PUBLISH_RESULT_PAGE))) {
            return;
        }
        t4b t4bVar = this.m;
        if ((t4bVar != null && t4bVar.c()) || S2()) {
            return;
        }
        if (UbsABTestHelper.isNewWrite()) {
            m3(this.d.D4());
        } else {
            u3();
        }
        int i = 2;
        StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_HOME_WRITE_TEST_ICON_CLICK).param("obj_type", 2);
        if (!UbsABTestHelper.isNewWrite()) {
            i = 1;
        }
        TiebaStatic.log(param.param("obj_source", i));
    }
}
