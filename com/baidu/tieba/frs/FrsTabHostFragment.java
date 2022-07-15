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
import com.baidu.tieba.frs.gametab.FrsTabController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.be6;
import com.repackage.dh8;
import com.repackage.kn6;
import com.repackage.mk6;
import com.repackage.ng;
import com.repackage.oi;
import com.repackage.ow8;
import com.repackage.p55;
import com.repackage.pi;
import com.repackage.pw8;
import com.repackage.q55;
import com.repackage.to6;
import com.repackage.u85;
import com.repackage.uo6;
import com.repackage.xk4;
import com.repackage.xm6;
import com.repackage.xo8;
import java.util.List;
import tbclient.FrsPage.ActivityConfig;
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
    public be6 c;
    public FrsFragment d;
    public FragmentTabHost e;
    public FrameLayout f;
    public dh8 g;
    public int h;
    public int i;
    public pw8 j;
    public OvalActionButton k;
    public FRSRefreshButton l;
    public xo8 m;
    public xm6 n;
    public ow8 o;
    public final View.OnClickListener p;
    public xm6.d q;

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
            this.a.j2();
            if (this.a.e == null) {
                return;
            }
            String str = null;
            if (this.a.g != null && this.a.g.getForum() != null) {
                str = this.a.g.getForum().getId();
            }
            this.a.G1(str);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements xm6.d {
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

        @Override // com.repackage.xm6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                if (z && i == 502) {
                    this.a.i2(1);
                } else if (z) {
                    this.a.i2(0);
                } else if (i != 502) {
                    this.a.i2(-1);
                } else {
                    this.a.W1();
                }
            }
        }

        @Override // com.repackage.xm6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            }
        }

        @Override // com.repackage.xm6.d
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
        public class a implements xk4 {
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

            @Override // com.repackage.xk4
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
                    this.d.a.b2(this.a, this.b);
                    this.d.a.e.w(this.b, this.c);
                }
            }

            @Override // com.repackage.xk4
            public void onFail() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    a(false);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements xk4 {
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

            @Override // com.repackage.xk4
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
                    this.e.a.b2(this.b, this.c);
                    this.e.a.e.w(this.c, this.d);
                }
            }

            @Override // com.repackage.xk4
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
                FrsTabInfo S1 = this.a.S1(i);
                if (S1 == null || S1.tab_type.intValue() != 11) {
                    FragmentTabHost.b i2 = this.a.e.i(i);
                    String str = null;
                    if (this.a.g != null && this.a.g.getForum() != null) {
                        str = this.a.g.getForum().getId();
                    }
                    this.a.F1(i2, str);
                    int i3 = i2.a;
                    if (i3 == 5) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(this.a.a.getPageContext().getPageActivity());
                            return false;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, new a(this, i2, i, z)));
                        return false;
                    } else if (i3 != 305) {
                        this.a.b2(i2, i);
                        return true;
                    } else if (!TbadkCoreApplication.isLogin()) {
                        ViewHelper.skipToLoginActivity(this.a.a.getPageContext().getPageActivity());
                        return false;
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, new b(this, S1, i2, i, z)));
                        return false;
                    }
                }
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.a.getPageContext(), new String[]{S1.tab_url}, true);
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                this.a.e.getCurrentFragment();
                int Q1 = this.a.Q1(i);
                if (Q1 != 1) {
                    this.a.d.L3();
                } else {
                    this.a.d.Y4();
                }
                if (Q1 != 1) {
                    if (Q1 == 4 || Q1 == 25) {
                        if (this.a.k.getVisibility() == 8) {
                            this.a.k.setVisibility(0);
                        }
                    } else {
                        if (this.a.d != null) {
                            this.a.d.x4(false);
                        }
                        this.a.k.setVisibility(8);
                        this.a.X1();
                    }
                    if (this.a.d != null) {
                        this.a.d.q4(false);
                        return;
                    }
                    return;
                }
                if (this.a.d != null) {
                    this.a.d.x4(true);
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
        this.p = new a(this);
        this.q = new b(this);
        this.b = frsTabController;
    }

    public final void F1(FragmentTabHost.b bVar, String str) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, str) == null) {
            TiebaStatic.log(new StatisticItem("c12334").param("obj_locate", O1(bVar)).param("fid", str));
            if (bVar == null || (runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(ng.g(str, 0L)))) == null || !((Boolean) runTask.getData()).booleanValue()) {
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

    public final void G1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            FragmentTabHost fragmentTabHost = this.e;
            if (fragmentTabHost != null) {
                TiebaStatic.log(new StatisticItem("c12342").param("obj_locate", O1(fragmentTabHost.i(fragmentTabHost.getCurrentTabIndex()))).param("fid", str));
            }
            StatisticItem statisticItem = new StatisticItem("c13604");
            if (getPageContext() != null) {
                u85.b(getPageContext().getPageActivity(), statisticItem);
            }
            FrsFragment frsFragment = this.d;
            if (frsFragment != null) {
                kn6.b(statisticItem, frsFragment.d(), this.d.c());
            }
            kn6.a(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            FrsFragment frsFragment = this.d;
            if (frsFragment != null && frsFragment.isAdded() && this.d.getPageContext() != null) {
                mk6.a(this.d.getPageContext(), this.d.Q0());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void I1(p55 p55Var, q55 q55Var, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        dh8 dh8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, p55Var, q55Var, tbFragmentTabIndicator, str) == null) || q55Var == null || (dh8Var = this.g) == null || dh8Var.getForum() == null) {
            return;
        }
        ForumData forum = this.g.getForum();
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        bVar.a = q55Var.e;
        Fragment fragment = q55Var.a;
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
        tbFragmentTabIndicator.setContentTvTopMargin(pi.f(this.a, R.dimen.tbds2));
        tbFragmentTabIndicator.setIconResourceId(q55Var.d);
        tbFragmentTabIndicator.setTextSize(0, pi.f(this.a.getActivity(), R.dimen.tbds40));
        if (q55Var.i == q55.j && q55Var.e == 99) {
            tbFragmentTabIndicator.setIconViewWithoutText(pi.f(this.a, R.dimen.obfuscated_res_0x7f070281), pi.f(this.a.getActivity(), R.dimen.tbds12));
        }
        if (!TextUtils.isEmpty(str)) {
            if (StringHelper.getChineseAndEnglishLength(str) > 8) {
                str = StringHelper.subString(str, 8);
            }
            tbFragmentTabIndicator.setText(str);
        } else {
            tbFragmentTabIndicator.setText(q55Var.b);
        }
        tbFragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
        tbFragmentTabIndicator.setTipPosType(1);
        tbFragmentTabIndicator.setIsContentSelectBold(true);
        tbFragmentTabIndicator.setContentSelectTextSize(getResources().getDimension(R.dimen.tbds46));
        tbFragmentTabIndicator.setContentDefaultTextSize(getResources().getDimension(R.dimen.tbds46));
        tbFragmentTabIndicator.setThemeColorInfo(forum.getThemeColorInfo());
        tbFragmentTabIndicator.setContentSelectTextColor(R.color.CAM_X0105);
        tbFragmentTabIndicator.setContentDefaultTextColor(R.color.CAM_X0107);
        if (!((q55Var.i == q55.j && q55Var.e == 99) ? false : false) && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
            tbFragmentTabIndicator.a(String.valueOf(bVar.a), J1((FragmentTabIndicator) tbFragmentTabIndicator));
        }
        bVar.b = tbFragmentTabIndicator;
        bVar.d = p55Var;
        this.e.c(bVar);
    }

    public final TbFragmentTabIndicator.a J1(FragmentTabIndicator fragmentTabIndicator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fragmentTabIndicator)) == null) {
            int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023d);
            ImageView imageView = new ImageView(this.a);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f080715);
            TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
            fragmentTabIndicator.setTipPosType(1);
            fragmentTabIndicator.setTipTopMargin(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023d));
            aVar.f = fragmentTabIndicator;
            aVar.c = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023d);
            aVar.a = imageView;
            imageView.setVisibility(8);
            return aVar;
        }
        return (TbFragmentTabIndicator.a) invokeL.objValue;
    }

    public int K1() {
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

    public Fragment L1() {
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

    public int M1() {
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

    public final int N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            be6 be6Var = this.c;
            if (be6Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(be6Var.f());
            for (int i = 0; i < count; i++) {
                if (this.c.f().get(i).tab_id.intValue() == 1) {
                    return i;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final int O1(FragmentTabHost.b bVar) {
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

    public FragmentTabHost P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.e : (FragmentTabHost) invokeV.objValue;
    }

    public final int Q1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            be6 be6Var = this.c;
            if (be6Var != null && i < ListUtils.getCount(be6Var.f())) {
                return this.c.f().get(i).tab_id.intValue();
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final int R1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            be6 be6Var = this.c;
            if (be6Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(be6Var.f());
            for (int i2 = 0; i2 < count; i2++) {
                if (this.c.f().get(i2).tab_id.intValue() == i) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final FrsTabInfo S1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            be6 be6Var = this.c;
            if (be6Var == null || i >= ListUtils.getCount(be6Var.f())) {
                return null;
            }
            return this.c.f().get(i);
        }
        return (FrsTabInfo) invokeI.objValue;
    }

    public FragmentTabHost.b T1(int i) {
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

    public pw8 U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.j : (pw8) invokeV.objValue;
    }

    public final String V1() {
        InterceptResult invokeV;
        FrsViewData Q0;
        ActivityConfig activityConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            FrsFragment frsFragment = this.d;
            return (frsFragment == null || (Q0 = frsFragment.Q0()) == null || (activityConfig = Q0.activityConfig) == null) ? "" : activityConfig.addthread_text;
        }
        return (String) invokeV.objValue;
    }

    public final void W1() {
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
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (frsFragment = this.d) == null || frsFragment.Q0() == null || (forum = this.d.Q0().getForum()) == null) {
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

    public void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, Boolean.FALSE));
            pw8 pw8Var = this.j;
            if (pw8Var == null || !pw8Var.n()) {
                return;
            }
            this.j.m(true);
        }
    }

    public boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            pw8 pw8Var = this.j;
            if (pw8Var == null) {
                return false;
            }
            return pw8Var.n();
        }
        return invokeV.booleanValue;
    }

    public final FragmentTabHost.a Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? new c(this) : (FragmentTabHost.a) invokeV.objValue;
    }

    public final void a2(FragmentTabHost.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) {
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

    public final void b2(FragmentTabHost.b bVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048598, this, bVar, i) == null) {
            TbFragmentTabIndicator tbFragmentTabIndicator = bVar.b;
            if (tbFragmentTabIndicator != null) {
                tbFragmentTabIndicator.c();
            }
            if (bVar.b.d(String.valueOf(bVar.a)) != null) {
                if (bVar.b.d(String.valueOf(bVar.a)).a.getVisibility() == 0) {
                    bVar.b.d(String.valueOf(bVar.a)).a.setVisibility(8);
                    a2(bVar);
                } else if (this.i == i) {
                    a2(bVar);
                }
            }
            this.i = i;
        }
    }

    public void c2(dh8 dh8Var, be6 be6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048599, this, dh8Var, be6Var) == null) || dh8Var == null || be6Var == null || this.e == null) {
            return;
        }
        this.g = dh8Var;
        this.c = be6Var;
        be6Var.m();
        if (ListUtils.isEmpty(this.c.g())) {
            return;
        }
        List<p55> g = this.c.g();
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
                p55 p55Var = g.get(i);
                if (p55Var != null) {
                    FrsTabInfo frsTabInfo = f.get(i);
                    I1(p55Var, p55Var.b(), p55Var.c(this.a.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                }
            }
        } else {
            for (p55 p55Var2 : g) {
                I1(p55Var2, p55Var2.b(), p55Var2.c(this.a.getActivity()), null);
            }
        }
        this.e.n(2);
        this.e.setViewPagerScrollable(false);
        int R1 = R1(this.h);
        if (R1 < 0) {
            R1 = R1(this.g.getGameDefaultTabId());
        }
        if (R1 < 0) {
            R1 = N1();
        }
        if (R1 < 0) {
            R1 = 0;
        }
        this.h = R1;
        this.i = R1;
        this.b.x0(R1);
        this.b.y0(this.i);
        this.e.setCurrentTab(R1);
        int Q1 = Q1(R1);
        if (Q1 != 1) {
            FrsFragment frsFragment = this.d;
            if (frsFragment != null) {
                frsFragment.q4(false);
                if (Q1 != 4 && Q1 != 25) {
                    this.d.x4(false);
                    this.k.setVisibility(8);
                    this.d.L3();
                }
            }
            if (this.g.getForum() != null) {
                uo6 c2 = to6.d().c(this.g.getForum().getName());
                if (Q1 == 25) {
                    if (c2 == null) {
                        c2 = new uo6(null);
                    }
                    c2.f(true);
                    to6.d().e(this.g.getForum().getName(), c2);
                } else if (c2 != null && c2.c()) {
                    c2.f(false);
                    to6.d().e(this.g.getForum().getName(), c2);
                }
            }
        }
        this.e.s(TbadkCoreApplication.getInst().getSkinType());
    }

    public void d2(int i) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048600, this, i) == null) || (fragmentTabHost = this.e) == null) {
            return;
        }
        fragmentTabHost.setCurrentTab(i);
    }

    public void e2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.h = i;
        }
    }

    public void f2(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, frsFragment) == null) {
            this.d = frsFragment;
        }
    }

    public void g2(FRSRefreshButton fRSRefreshButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, fRSRefreshButton) == null) {
            this.l = fRSRefreshButton;
        }
    }

    public void h2(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, ovalActionButton) == null) {
            this.k = ovalActionButton;
            ovalActionButton.setOnClickListener(this.p);
        }
    }

    public final void i2(int i) {
        FrsViewData Q0;
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            if (UbsABTestHelper.isMainTabShowA() && (frsFragment = this.d) != null) {
                ForumWriteData o3 = frsFragment.o3();
                ItemInfo itemInfo = this.d.Q0() != null ? this.d.Q0().itemInfo : null;
                if (this.o == null) {
                    this.o = new ow8(this.a, "frs", 2, "2");
                }
                this.o.j(o3);
                this.o.l(V1());
                this.o.k(itemInfo);
                this.o.m();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, Boolean.TRUE));
            if (this.j == null) {
                FrsFragment frsFragment2 = this.d;
                pw8 pw8Var = new pw8(this.a.getPageContext(), this.f, "frs", (frsFragment2 == null || (Q0 = frsFragment2.Q0()) == null) ? null : Q0.getVoiceRoomConfig());
                this.j = pw8Var;
                pw8Var.E("2");
                ItemInfo itemInfo2 = this.d.Q0().itemInfo;
                this.j.D((itemInfo2 == null || itemInfo2.id.intValue() <= 0 || oi.isEmpty(itemInfo2.name)) ? false : true);
            }
            if (this.d.Q0().getAnti() != null) {
                this.j.A(this.d.Q0().getAnti().getCanGoods());
            }
            ForumWriteData o32 = this.d.o3();
            o32.setDefaultZone(i);
            this.j.F(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
            this.j.B(o32);
            this.j.C(this.d.Q0().itemInfo);
            this.j.H(K1());
            FrsFragment frsFragment3 = this.d;
            if (frsFragment3 != null && frsFragment3.Q0() != null) {
                this.j.C(this.d.Q0().itemInfo);
            }
            UtilHelper.setNavigationBarBackground(this.a, K1());
            this.j.I(false, null, this.k);
            FrsFragment frsFragment4 = this.d;
            if (frsFragment4 == null || frsFragment4.Q0() == null || this.d.Q0().itemInfo == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13721").param("fid", this.d.d()).param("fname", this.d.c()).param("obj_param1", this.d.Q0().itemInfo.name));
        }
    }

    public void j2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a, LoginDialogData.FRS_PUBLISH_RESULT_PAGE)) || this.m.c() || H1()) {
            return;
        }
        if (this.d.D3().K(502) != null) {
            this.n.h(this.d.d(), this.d.D3().C().a);
        } else {
            i2(-1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bundle) == null) {
            this.m = new xo8(this.a.getPageContext());
            xm6 xm6Var = new xm6(this.a.getPageContext());
            this.n = xm6Var;
            xm6Var.i(this.q);
            this.o = new ow8(this.a, "frs", 2, "2");
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            FragmentTabHost fragmentTabHost = this.e;
            if (fragmentTabHost != null) {
                fragmentTabHost.s(TbadkCoreApplication.getInst().getSkinType());
            }
            pw8 pw8Var = this.j;
            if (pw8Var != null) {
                pw8Var.s(i);
            }
            ow8 ow8Var = this.o;
            if (ow8Var != null) {
                ow8Var.i(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048610, this, layoutInflater, viewGroup, bundle)) == null) {
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
                this.e.setOnTabSelectionListener(Z1());
            }
            return this.f;
        }
        return (View) invokeLLL.objValue;
    }
}
