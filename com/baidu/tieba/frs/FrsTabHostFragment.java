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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gametab.FrsTabController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d55;
import com.repackage.e55;
import com.repackage.ey8;
import com.repackage.fn6;
import com.repackage.jk6;
import com.repackage.kg;
import com.repackage.l85;
import com.repackage.li;
import com.repackage.ll4;
import com.repackage.mi;
import com.repackage.od6;
import com.repackage.oi8;
import com.repackage.rm6;
import com.repackage.rq8;
import com.repackage.wo6;
import com.repackage.xo6;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ItemInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes3.dex */
public class FrsTabHostFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;
    public FrsTabController b;
    public od6 c;
    public FrsFragment d;
    public FragmentTabHost e;
    public FrameLayout f;
    public oi8 g;
    public int h;
    public int i;
    public ey8 j;
    public OvalActionButton k;
    public FRSRefreshButton l;
    public rq8 m;
    public rm6 n;
    public final View.OnClickListener o;
    public rm6.d p;

    /* loaded from: classes3.dex */
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
            this.a.r1();
            if (this.a.e == null) {
                return;
            }
            String str = null;
            if (this.a.g != null && this.a.g.getForum() != null) {
                str = this.a.g.getForum().getId();
            }
            this.a.P0(str);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements rm6.d {
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

        @Override // com.repackage.rm6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                if (z && i == 502) {
                    this.a.q1(1);
                } else if (z) {
                    this.a.q1(0);
                } else if (i != 502) {
                    this.a.q1(-1);
                } else {
                    this.a.e1();
                }
            }
        }

        @Override // com.repackage.rm6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            }
        }

        @Override // com.repackage.rm6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements FragmentTabHost.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabHostFragment a;

        /* loaded from: classes3.dex */
        public class a implements ll4 {
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

            @Override // com.repackage.ll4
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
                    this.d.a.j1(this.a, this.b);
                    this.d.a.e.w(this.b, this.c);
                }
            }

            @Override // com.repackage.ll4
            public void onFail() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    a(false);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements ll4 {
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

            @Override // com.repackage.ll4
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
                    this.e.a.j1(this.b, this.c);
                    this.e.a.e.w(this.c, this.d);
                }
            }

            @Override // com.repackage.ll4
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
                FrsTabInfo b1 = this.a.b1(i);
                if (b1 == null || b1.tab_type.intValue() != 11) {
                    FragmentTabHost.b i2 = this.a.e.i(i);
                    String str = null;
                    if (this.a.g != null && this.a.g.getForum() != null) {
                        str = this.a.g.getForum().getId();
                    }
                    this.a.O0(i2, str);
                    int i3 = i2.a;
                    if (i3 == 5) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(this.a.a.getPageContext().getPageActivity());
                            return false;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, new a(this, i2, i, z)));
                        return false;
                    } else if (i3 != 305) {
                        this.a.j1(i2, i);
                        return true;
                    } else if (!TbadkCoreApplication.isLogin()) {
                        ViewHelper.skipToLoginActivity(this.a.a.getPageContext().getPageActivity());
                        return false;
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, new b(this, b1, i2, i, z)));
                        return false;
                    }
                }
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.a.getPageContext(), new String[]{b1.tab_url}, true);
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                this.a.e.getCurrentFragment();
                int Z0 = this.a.Z0(i);
                if (Z0 != 1) {
                    this.a.d.T2();
                } else {
                    this.a.d.f4();
                }
                if (Z0 != 1) {
                    if (Z0 == 4 || Z0 == 25) {
                        if (this.a.k.getVisibility() == 8) {
                            this.a.k.setVisibility(0);
                        }
                    } else {
                        if (this.a.d != null) {
                            this.a.d.E3(false);
                        }
                        this.a.k.setVisibility(8);
                        this.a.f1();
                    }
                    if (this.a.d != null) {
                        this.a.d.x3(false);
                        return;
                    }
                    return;
                }
                if (this.a.d != null) {
                    this.a.d.E3(true);
                }
                this.a.k.setVisibility(0);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = 0;
        this.o = new a(this);
        this.p = new b(this);
        this.b = frsTabController;
    }

    public final void O0(FragmentTabHost.b bVar, String str) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, str) == null) {
            TiebaStatic.log(new StatisticItem("c12334").param("obj_locate", X0(bVar)).param("fid", str));
            if (bVar == null || (runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(kg.g(str, 0L)))) == null || !((Boolean) runTask.getData()).booleanValue()) {
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

    public final void P0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            FragmentTabHost fragmentTabHost = this.e;
            if (fragmentTabHost != null) {
                TiebaStatic.log(new StatisticItem("c12342").param("obj_locate", X0(fragmentTabHost.i(fragmentTabHost.getCurrentTabIndex()))).param("fid", str));
            }
            StatisticItem statisticItem = new StatisticItem("c13604");
            if (getPageContext() != null) {
                l85.b(getPageContext().getPageActivity(), statisticItem);
            }
            FrsFragment frsFragment = this.d;
            if (frsFragment != null) {
                fn6.b(statisticItem, frsFragment.b(), this.d.a());
            }
            fn6.a(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            FrsFragment frsFragment = this.d;
            if (frsFragment != null && frsFragment.isAdded() && this.d.getPageContext() != null) {
                jk6.a(this.d.getPageContext(), this.d.g0());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void R0(d55 d55Var, e55 e55Var, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        oi8 oi8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, d55Var, e55Var, tbFragmentTabIndicator, str) == null) || e55Var == null || (oi8Var = this.g) == null || oi8Var.getForum() == null) {
            return;
        }
        ForumData forum = this.g.getForum();
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        bVar.a = e55Var.e;
        Fragment fragment = e55Var.a;
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
        tbFragmentTabIndicator.setContentTvTopMargin(mi.f(this.a, R.dimen.tbds2));
        tbFragmentTabIndicator.setIconResourceId(e55Var.d);
        tbFragmentTabIndicator.setTextSize(0, mi.f(this.a.getActivity(), R.dimen.tbds40));
        if (e55Var.i == e55.j && e55Var.e == 99) {
            tbFragmentTabIndicator.setIconViewWithoutText(mi.f(this.a, R.dimen.obfuscated_res_0x7f070281), mi.f(this.a.getActivity(), R.dimen.tbds12));
        }
        if (!TextUtils.isEmpty(str)) {
            if (StringHelper.getChineseAndEnglishLength(str) > 8) {
                str = StringHelper.subString(str, 8);
            }
            tbFragmentTabIndicator.setText(str);
        } else {
            tbFragmentTabIndicator.setText(e55Var.b);
        }
        tbFragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
        tbFragmentTabIndicator.setTipPosType(1);
        tbFragmentTabIndicator.setIsContentSelectBold(true);
        tbFragmentTabIndicator.setContentSelectTextSize(getResources().getDimension(R.dimen.tbds46));
        tbFragmentTabIndicator.setContentDefaultTextSize(getResources().getDimension(R.dimen.tbds46));
        tbFragmentTabIndicator.setThemeColorInfo(forum.getThemeColorInfo());
        tbFragmentTabIndicator.setContentSelectTextColor(R.color.CAM_X0105);
        tbFragmentTabIndicator.setContentDefaultTextColor(R.color.CAM_X0107);
        if (!((e55Var.i == e55.j && e55Var.e == 99) ? false : false) && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
            tbFragmentTabIndicator.a(String.valueOf(bVar.a), S0((FragmentTabIndicator) tbFragmentTabIndicator));
        }
        bVar.b = tbFragmentTabIndicator;
        bVar.d = d55Var;
        this.e.c(bVar);
    }

    public final TbFragmentTabIndicator.a S0(FragmentTabIndicator fragmentTabIndicator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fragmentTabIndicator)) == null) {
            int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023e);
            ImageView imageView = new ImageView(this.a);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f080715);
            TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
            fragmentTabIndicator.setTipPosType(1);
            fragmentTabIndicator.setTipTopMargin(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023e));
            aVar.f = fragmentTabIndicator;
            aVar.c = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023e);
            aVar.a = imageView;
            imageView.setVisibility(8);
            return aVar;
        }
        return (TbFragmentTabIndicator.a) invokeL.objValue;
    }

    public int T0() {
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

    public Fragment U0() {
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

    public int V0() {
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

    public final int W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            od6 od6Var = this.c;
            if (od6Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(od6Var.f());
            for (int i = 0; i < count; i++) {
                if (this.c.f().get(i).tab_id.intValue() == 1) {
                    return i;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final int X0(FragmentTabHost.b bVar) {
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

    public FragmentTabHost Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.e : (FragmentTabHost) invokeV.objValue;
    }

    public final int Z0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            od6 od6Var = this.c;
            if (od6Var != null && i < ListUtils.getCount(od6Var.f())) {
                return this.c.f().get(i).tab_id.intValue();
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final int a1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            od6 od6Var = this.c;
            if (od6Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(od6Var.f());
            for (int i2 = 0; i2 < count; i2++) {
                if (this.c.f().get(i2).tab_id.intValue() == i) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final FrsTabInfo b1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            od6 od6Var = this.c;
            if (od6Var == null || i >= ListUtils.getCount(od6Var.f())) {
                return null;
            }
            return this.c.f().get(i);
        }
        return (FrsTabInfo) invokeI.objValue;
    }

    public FragmentTabHost.b c1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            FragmentTabHost fragmentTabHost = this.e;
            if (fragmentTabHost == null) {
                return null;
            }
            return fragmentTabHost.i(i);
        }
        return (FragmentTabHost.b) invokeI.objValue;
    }

    public ey8 d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.j : (ey8) invokeV.objValue;
    }

    public final void e1() {
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
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (frsFragment = this.d) == null || frsFragment.g0() == null || (forum = this.d.g0().getForum()) == null) {
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

    public void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, Boolean.FALSE));
            ey8 ey8Var = this.j;
            if (ey8Var == null || !ey8Var.n()) {
                return;
            }
            this.j.m(true);
        }
    }

    public boolean g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            ey8 ey8Var = this.j;
            if (ey8Var == null) {
                return false;
            }
            return ey8Var.n();
        }
        return invokeV.booleanValue;
    }

    public final FragmentTabHost.a h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? new c(this) : (FragmentTabHost.a) invokeV.objValue;
    }

    public final void i1(FragmentTabHost.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) {
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

    public final void j1(FragmentTabHost.b bVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, bVar, i) == null) {
            TbFragmentTabIndicator tbFragmentTabIndicator = bVar.b;
            if (tbFragmentTabIndicator != null) {
                tbFragmentTabIndicator.c();
            }
            if (bVar.b.d(String.valueOf(bVar.a)) != null) {
                if (bVar.b.d(String.valueOf(bVar.a)).a.getVisibility() == 0) {
                    bVar.b.d(String.valueOf(bVar.a)).a.setVisibility(8);
                    i1(bVar);
                } else if (this.i == i) {
                    i1(bVar);
                }
            }
            this.i = i;
        }
    }

    public void k1(oi8 oi8Var, od6 od6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, oi8Var, od6Var) == null) || oi8Var == null || od6Var == null || this.e == null) {
            return;
        }
        this.g = oi8Var;
        this.c = od6Var;
        od6Var.m();
        if (ListUtils.isEmpty(this.c.g())) {
            return;
        }
        List<d55> g = this.c.g();
        List<FrsTabInfo> f = this.c.f();
        this.e.setShouldDrawDividerLine(false);
        this.e.setShouldDrawIndicatorLine(false);
        this.e.setShouldDrawTopLine(false);
        this.e.r(false);
        this.e.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0207);
        this.e.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (f.size() == g.size()) {
            int size = f.size();
            for (int i = 0; i < size; i++) {
                d55 d55Var = g.get(i);
                if (d55Var != null) {
                    FrsTabInfo frsTabInfo = f.get(i);
                    R0(d55Var, d55Var.b(), d55Var.c(this.a.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                }
            }
        } else {
            for (d55 d55Var2 : g) {
                R0(d55Var2, d55Var2.b(), d55Var2.c(this.a.getActivity()), null);
            }
        }
        this.e.n(2);
        this.e.setViewPagerScrollable(false);
        int a1 = a1(this.h);
        if (a1 < 0) {
            a1 = a1(this.g.getGameDefaultTabId());
        }
        if (a1 < 0) {
            a1 = W0();
        }
        if (a1 < 0) {
            a1 = 0;
        }
        this.h = a1;
        this.i = a1;
        this.b.t0(a1);
        this.b.u0(this.i);
        this.e.setCurrentTab(a1);
        int Z0 = Z0(a1);
        if (Z0 != 1) {
            FrsFragment frsFragment = this.d;
            if (frsFragment != null) {
                frsFragment.x3(false);
                if (Z0 != 4 && Z0 != 25) {
                    this.d.E3(false);
                    this.k.setVisibility(8);
                    this.d.T2();
                }
            }
            if (this.g.getForum() != null) {
                xo6 c2 = wo6.d().c(this.g.getForum().getName());
                if (Z0 == 25) {
                    if (c2 == null) {
                        c2 = new xo6(null);
                    }
                    c2.f(true);
                    wo6.d().e(this.g.getForum().getName(), c2);
                } else if (c2 != null && c2.c()) {
                    c2.f(false);
                    wo6.d().e(this.g.getForum().getName(), c2);
                }
            }
        }
        this.e.s(TbadkCoreApplication.getInst().getSkinType());
    }

    public void l1(int i) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i) == null) || (fragmentTabHost = this.e) == null) {
            return;
        }
        fragmentTabHost.setCurrentTab(i);
    }

    public void m1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.h = i;
        }
    }

    public void n1(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, frsFragment) == null) {
            this.d = frsFragment;
        }
    }

    public void o1(FRSRefreshButton fRSRefreshButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, fRSRefreshButton) == null) {
            this.l = fRSRefreshButton;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
            this.m = new rq8(this.a.getPageContext());
            rm6 rm6Var = new rm6(this.a.getPageContext());
            this.n = rm6Var;
            rm6Var.i(this.p);
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            FragmentTabHost fragmentTabHost = this.e;
            if (fragmentTabHost != null) {
                fragmentTabHost.s(TbadkCoreApplication.getInst().getSkinType());
            }
            ey8 ey8Var = this.j;
            if (ey8Var != null) {
                ey8Var.t(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048606, this, layoutInflater, viewGroup, bundle)) == null) {
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
                this.e.setOnTabSelectionListener(h1());
            }
            return this.f;
        }
        return (View) invokeLLL.objValue;
    }

    public void p1(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, ovalActionButton) == null) {
            this.k = ovalActionButton;
            ovalActionButton.setOnClickListener(this.o);
        }
    }

    public final void q1(int i) {
        FrsViewData g0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, Boolean.TRUE));
            if (this.j == null) {
                FrsFragment frsFragment = this.d;
                ey8 ey8Var = new ey8(this.a.getPageContext(), this.f, "frs", (frsFragment == null || (g0 = frsFragment.g0()) == null) ? null : g0.getVoiceRoomConfig());
                this.j = ey8Var;
                ey8Var.H("2");
                ItemInfo itemInfo = this.d.g0().itemInfo;
                this.j.G((itemInfo == null || itemInfo.id.intValue() <= 0 || li.isEmpty(itemInfo.name)) ? false : true);
            }
            if (this.d.g0().getAnti() != null) {
                this.j.D(this.d.g0().getAnti().getCanGoods());
            }
            ForumWriteData w2 = this.d.w2();
            w2.setDefaultZone(i);
            this.j.I(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
            this.j.E(w2);
            this.j.F(this.d.g0().itemInfo);
            this.j.K(T0());
            FrsFragment frsFragment2 = this.d;
            if (frsFragment2 != null && frsFragment2.g0() != null) {
                this.j.F(this.d.g0().itemInfo);
            }
            UtilHelper.setNavigationBarBackground(this.a, T0());
            this.j.L(false, null, this.k);
            FrsFragment frsFragment3 = this.d;
            if (frsFragment3 == null || frsFragment3.g0() == null || this.d.g0().itemInfo == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13721").param("fid", this.d.b()).param("fname", this.d.a()).param("obj_param1", this.d.g0().itemInfo.name));
        }
    }

    public void r1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || !ViewHelper.checkUpIsLogin(this.a) || this.m.c() || Q0()) {
            return;
        }
        if (this.d.L2().I(502) != null) {
            this.n.h(this.d.b(), this.d.L2().A().a);
        } else {
            q1(-1);
        }
    }
}
