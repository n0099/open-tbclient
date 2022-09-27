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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
import com.baidu.tieba.R;
import com.baidu.tieba.au8;
import com.baidu.tieba.dh;
import com.baidu.tieba.di6;
import com.baidu.tieba.dj;
import com.baidu.tieba.do6;
import com.baidu.tieba.ej;
import com.baidu.tieba.eo4;
import com.baidu.tieba.eo6;
import com.baidu.tieba.hr6;
import com.baidu.tieba.l95;
import com.baidu.tieba.m95;
import com.baidu.tieba.qs6;
import com.baidu.tieba.rs6;
import com.baidu.tieba.t19;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tc5;
import com.baidu.tieba.u19;
import com.baidu.tieba.yq6;
import com.baidu.tieba.zl8;
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
    public do6 b;
    public di6 c;
    public FrsFragment d;
    public FragmentTabHost e;
    public FrameLayout f;
    public zl8 g;
    public int h;
    public int i;
    public u19 j;
    public OvalActionButton k;
    public FRSRefreshButton l;
    public au8 m;
    public yq6 n;
    public t19 o;
    public boolean p;
    public final View.OnClickListener q;
    public yq6.d r;

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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null || WriteActivityConfig.isAsyncWriting()) {
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
    public class b implements yq6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabHostFragment a;

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

        @Override // com.baidu.tieba.yq6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                if (z && i == 502) {
                    this.a.h2(1);
                } else if (z) {
                    this.a.h2(0);
                } else if (i != 502) {
                    this.a.h2(-1);
                } else {
                    this.a.U1();
                }
            }
        }

        @Override // com.baidu.tieba.yq6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            }
        }

        @Override // com.baidu.tieba.yq6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements FragmentTabHost.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabHostFragment a;

        /* loaded from: classes4.dex */
        public class a implements eo4 {
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

            @Override // com.baidu.tieba.eo4
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
                    this.d.a.e.s(this.b, this.c);
                }
            }

            @Override // com.baidu.tieba.eo4
            public void onFail() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    a(false);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements eo4 {
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

            @Override // com.baidu.tieba.eo4
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
                    this.e.a.e.s(this.c, this.d);
                }
            }

            @Override // com.baidu.tieba.eo4
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
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
                FrsTabInfo Q1 = this.a.Q1(i);
                if (Q1 == null || Q1.tab_type.intValue() != 11) {
                    FragmentTabHost.b f = this.a.e.f(i);
                    String str = null;
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
                    } else if (i2 != 305) {
                        this.a.a2(f, i);
                        return true;
                    } else if (!TbadkCoreApplication.isLogin()) {
                        ViewHelper.skipToLoginActivity(this.a.a.getPageContext().getPageActivity());
                        return false;
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, new b(this, Q1, f, i, z)));
                        return false;
                    }
                }
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.a.getPageContext(), new String[]{Q1.tab_url}, true);
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                this.a.e.getCurrentFragment();
                int O1 = this.a.O1(i);
                if (O1 != 1) {
                    this.a.d.M3();
                } else {
                    this.a.d.a5();
                }
                if (O1 != 1) {
                    if (O1 == 4 || O1 == 25) {
                        if (this.a.k.getVisibility() == 8) {
                            this.a.k.setVisibility(0);
                        }
                    } else {
                        if (this.a.d != null) {
                            this.a.d.B4(false);
                        }
                        this.a.k.setVisibility(8);
                        this.a.V1();
                    }
                    if (this.a.d != null) {
                        this.a.d.q4(false);
                        return;
                    }
                    return;
                }
                if (this.a.d != null) {
                    this.a.d.B4(true);
                }
                this.a.k.setVisibility(0);
            }
        }
    }

    public FrsTabHostFragment(do6 do6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {do6Var};
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
        this.b = do6Var;
    }

    public final void D1(FragmentTabHost.b bVar, String str) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, str) == null) {
            TiebaStatic.log(new StatisticItem("c12334").param("obj_locate", M1(bVar)).param("fid", str));
            if (bVar == null || (runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(dh.g(str, 0L)))) == null || !((Boolean) runTask.getData()).booleanValue()) {
                return;
            }
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

    public final void E1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            FragmentTabHost fragmentTabHost = this.e;
            if (fragmentTabHost != null) {
                TiebaStatic.log(new StatisticItem("c12342").param("obj_locate", M1(fragmentTabHost.f(fragmentTabHost.getCurrentTabIndex()))).param("fid", str));
            }
            StatisticItem statisticItem = new StatisticItem("c13604");
            if (getPageContext() != null) {
                tc5.b(getPageContext().getPageActivity(), statisticItem);
            }
            FrsFragment frsFragment = this.d;
            if (frsFragment != null) {
                hr6.b(statisticItem, frsFragment.d(), this.d.c());
            }
            hr6.a(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            FrsFragment frsFragment = this.d;
            if (frsFragment != null && frsFragment.isAdded() && this.d.getPageContext() != null) {
                eo6.a(this.d.getPageContext(), this.d.O0());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void G1(l95 l95Var, m95 m95Var, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        zl8 zl8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, l95Var, m95Var, tbFragmentTabIndicator, str) == null) || m95Var == null || (zl8Var = this.g) == null || zl8Var.getForum() == null) {
            return;
        }
        ForumData forum = this.g.getForum();
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        bVar.a = m95Var.e;
        Fragment fragment = m95Var.a;
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
        tbFragmentTabIndicator.setContentTvTopMargin(ej.f(this.a, R.dimen.tbds2));
        tbFragmentTabIndicator.setIconResourceId(m95Var.d);
        tbFragmentTabIndicator.setTextSize(0, ej.f(this.a.getActivity(), R.dimen.tbds40));
        if (m95Var.i == m95.j && m95Var.e == 99) {
            tbFragmentTabIndicator.setIconViewWithoutText(ej.f(this.a, R.dimen.obfuscated_res_0x7f070281), ej.f(this.a.getActivity(), R.dimen.tbds12));
        }
        if (!TextUtils.isEmpty(str)) {
            if (StringHelper.getChineseAndEnglishLength(str) > 8) {
                str = StringHelper.subString(str, 8);
            }
            tbFragmentTabIndicator.setText(str);
        } else {
            tbFragmentTabIndicator.setText(m95Var.b);
        }
        tbFragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
        tbFragmentTabIndicator.setTipPosType(1);
        tbFragmentTabIndicator.setIsContentSelectBold(true);
        tbFragmentTabIndicator.setContentSelectTextSize(getResources().getDimension(R.dimen.tbds46));
        tbFragmentTabIndicator.setContentDefaultTextSize(getResources().getDimension(R.dimen.tbds46));
        tbFragmentTabIndicator.setThemeColorInfo(forum.getThemeColorInfo());
        tbFragmentTabIndicator.setContentSelectTextColor(R.color.CAM_X0105);
        tbFragmentTabIndicator.setContentDefaultTextColor(R.color.CAM_X0107);
        if (!((m95Var.i == m95.j && m95Var.e == 99) ? false : false) && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
            tbFragmentTabIndicator.a(String.valueOf(bVar.a), H1((FragmentTabIndicator) tbFragmentTabIndicator));
        }
        bVar.b = tbFragmentTabIndicator;
        bVar.d = l95Var;
        this.e.a(bVar);
    }

    public final TbFragmentTabIndicator.a H1(FragmentTabIndicator fragmentTabIndicator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fragmentTabIndicator)) == null) {
            int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023b);
            ImageView imageView = new ImageView(this.a);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f080736);
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

    public final int L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            di6 di6Var = this.c;
            if (di6Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(di6Var.f());
            for (int i = 0; i < count; i++) {
                if (this.c.f().get(i).tab_id.intValue() == 1) {
                    return i;
                }
            }
            return -1;
        }
        return invokeV.intValue;
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

    public FragmentTabHost N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.e : (FragmentTabHost) invokeV.objValue;
    }

    public final int O1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            di6 di6Var = this.c;
            if (di6Var != null && i < ListUtils.getCount(di6Var.f())) {
                return this.c.f().get(i).tab_id.intValue();
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final int P1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            di6 di6Var = this.c;
            if (di6Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(di6Var.f());
            for (int i2 = 0; i2 < count; i2++) {
                if (this.c.f().get(i2).tab_id.intValue() == i) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final FrsTabInfo Q1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            di6 di6Var = this.c;
            if (di6Var == null || i >= ListUtils.getCount(di6Var.f())) {
                return null;
            }
            return this.c.f().get(i);
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

    public u19 S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.j : (u19) invokeV.objValue;
    }

    public final String T1() {
        InterceptResult invokeV;
        FrsViewData O0;
        ActivityConfig activityConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            FrsFragment frsFragment = this.d;
            return (frsFragment == null || (O0 = frsFragment.O0()) == null || (activityConfig = O0.activityConfig) == null) ? "" : activityConfig.addthread_text;
        }
        return (String) invokeV.objValue;
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
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (frsFragment = this.d) == null || frsFragment.O0() == null || (forum = this.d.O0().getForum()) == null) {
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
        FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.d.getContext());
        frsProfessionIntroActivityConfig.putColor(str, str2, str3, str4, str5, str6, str7);
        frsProfessionIntroActivityConfig.start();
    }

    public void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, Boolean.FALSE));
            u19 u19Var = this.j;
            if (u19Var == null || !u19Var.n()) {
                return;
            }
            this.j.m(true);
        }
    }

    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            u19 u19Var = this.j;
            if (u19Var == null) {
                return false;
            }
            return u19Var.n();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? new c(this) : (FragmentTabHost.a) invokeV.objValue;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, bVar, i) == null) {
            TbFragmentTabIndicator tbFragmentTabIndicator = bVar.b;
            if (tbFragmentTabIndicator != null) {
                tbFragmentTabIndicator.c();
            }
            if (bVar.b.d(String.valueOf(bVar.a)) != null) {
                if (bVar.b.d(String.valueOf(bVar.a)).a.getVisibility() == 0) {
                    bVar.b.d(String.valueOf(bVar.a)).a.setVisibility(8);
                    Z1(bVar);
                } else if (this.i == i) {
                    Z1(bVar);
                }
            }
            this.i = i;
        }
    }

    public void b2(zl8 zl8Var, di6 di6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, zl8Var, di6Var) == null) {
            this.p = false;
            if (zl8Var == null || di6Var == null) {
                return;
            }
            if (this.e == null) {
                this.g = zl8Var;
                this.c = di6Var;
                this.p = true;
                return;
            }
            this.g = zl8Var;
            this.c = di6Var;
            di6Var.m();
            if (ListUtils.isEmpty(this.c.g())) {
                return;
            }
            List<l95> g = this.c.g();
            List<FrsTabInfo> f = this.c.f();
            this.e.setShouldDrawDividerLine(false);
            this.e.setShouldDrawIndicatorLine(false);
            this.e.setShouldDrawTopLine(false);
            this.e.o(false);
            this.e.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0207);
            this.e.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            if (f.size() == g.size()) {
                int size = f.size();
                for (int i = 0; i < size; i++) {
                    l95 l95Var = g.get(i);
                    if (l95Var != null) {
                        FrsTabInfo frsTabInfo = f.get(i);
                        G1(l95Var, l95Var.b(), l95Var.c(this.a.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                    }
                }
            } else {
                for (l95 l95Var2 : g) {
                    G1(l95Var2, l95Var2.b(), l95Var2.c(this.a.getActivity()), null);
                }
            }
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
            this.b.j0(P1);
            this.b.k0(this.i);
            this.e.setCurrentTab(P1);
            int O1 = O1(P1);
            if (O1 != 1) {
                FrsFragment frsFragment = this.d;
                if (frsFragment != null) {
                    frsFragment.q4(false);
                    if (O1 != 4 && O1 != 25) {
                        this.d.B4(false);
                        this.k.setVisibility(8);
                        this.d.M3();
                    }
                }
                if (this.g.getForum() != null) {
                    rs6 c2 = qs6.d().c(this.g.getForum().getName());
                    if (O1 == 25) {
                        if (c2 == null) {
                            c2 = new rs6(null);
                        }
                        c2.f(true);
                        qs6.d().e(this.g.getForum().getName(), c2);
                    } else if (c2 != null && c2.c()) {
                        c2.f(false);
                        qs6.d().e(this.g.getForum().getName(), c2);
                    }
                }
            }
            this.e.p(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c2(int i) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048601, this, i) == null) || (fragmentTabHost = this.e) == null) {
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

    public final void h2(int i) {
        FrsViewData O0;
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            if (UbsABTestHelper.isMainTabShowA() && (frsFragment = this.d) != null) {
                ForumWriteData n3 = frsFragment.n3();
                ItemInfo itemInfo = this.d.O0() != null ? this.d.O0().itemInfo : null;
                if (this.o == null) {
                    this.o = new t19(this.a, "frs", 2, "2");
                }
                this.o.j(n3);
                this.o.l(T1());
                this.o.k(itemInfo);
                this.o.m();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, Boolean.TRUE));
            if (this.j == null) {
                FrsFragment frsFragment2 = this.d;
                u19 u19Var = new u19(this.a.getPageContext(), this.f, "frs", (frsFragment2 == null || (O0 = frsFragment2.O0()) == null) ? null : O0.getVoiceRoomConfig());
                this.j = u19Var;
                u19Var.E("2");
                FrsFragment frsFragment3 = this.d;
                if (frsFragment3 != null) {
                    ItemInfo itemInfo2 = frsFragment3.O0().itemInfo;
                    this.j.D((itemInfo2 == null || itemInfo2.id.intValue() <= 0 || dj.isEmpty(itemInfo2.name)) ? false : true);
                }
            }
            FrsFragment frsFragment4 = this.d;
            if (frsFragment4 != null && frsFragment4.O0().getAnti() != null) {
                this.j.A(this.d.O0().getAnti().getCanGoods());
            }
            FrsFragment frsFragment5 = this.d;
            if (frsFragment5 != null) {
                ForumWriteData n32 = frsFragment5.n3();
                n32.setDefaultZone(i);
                this.j.B(n32);
            }
            this.j.F(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
            this.j.C(this.d.O0().itemInfo);
            this.j.H(I1());
            FrsFragment frsFragment6 = this.d;
            if (frsFragment6 != null && frsFragment6.O0() != null) {
                this.j.C(this.d.O0().itemInfo);
            }
            UtilHelper.setNavigationBarBackground(this.a, I1());
            this.j.I(false, null, this.k);
            FrsFragment frsFragment7 = this.d;
            if (frsFragment7 == null || frsFragment7.O0() == null || this.d.O0().itemInfo == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13721").param("fid", this.d.d()).param("fname", this.d.c()).param("obj_param1", this.d.O0().itemInfo.name));
        }
    }

    public void i2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a, LoginDialogData.FRS_PUBLISH_RESULT_PAGE))) {
            au8 au8Var = this.m;
            if ((au8Var == null || !au8Var.c()) && !F1()) {
                if (this.d.E3().K(502) != null) {
                    this.n.h(this.d.d(), this.d.E3().C().a);
                } else {
                    h2(-1);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bundle) == null) {
            this.m = new au8(this.a.getPageContext());
            yq6 yq6Var = new yq6(this.a.getPageContext());
            this.n = yq6Var;
            yq6Var.i(this.r);
            this.o = new t19(this.a, "frs", 2, "2");
            super.onActivityCreated(bundle);
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
            u19 u19Var = this.j;
            if (u19Var != null) {
                u19Var.s(i);
            }
            t19 t19Var = this.o;
            if (t19Var != null) {
                t19Var.i(i);
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
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
