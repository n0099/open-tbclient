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
import c.a.d.f.p.m;
import c.a.p0.a4.n;
import c.a.p0.f1.i2.a.c;
import c.a.p0.f1.j0;
import c.a.p0.f1.q2.e;
import c.a.p0.h4.d;
import c.a.p0.s4.f;
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
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ItemInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes5.dex */
public class FrsTabHostFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public FrsTabController f32318b;

    /* renamed from: c  reason: collision with root package name */
    public j0 f32319c;

    /* renamed from: d  reason: collision with root package name */
    public FrsFragment f32320d;

    /* renamed from: e  reason: collision with root package name */
    public FragmentTabHost f32321e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f32322f;

    /* renamed from: g  reason: collision with root package name */
    public n f32323g;

    /* renamed from: h  reason: collision with root package name */
    public int f32324h;
    public int i;
    public f j;
    public OvalActionButton k;
    public FRSRefreshButton l;
    public d m;
    public c.a.p0.f1.i2.a.c n;
    public final View.OnClickListener o;
    public c.d p;

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            this.a.r1();
            if (this.a.f32321e == null) {
                return;
            }
            String str = null;
            if (this.a.f32323g != null && this.a.f32323g.getForum() != null) {
                str = this.a.f32323g.getForum().getId();
            }
            this.a.P0(str);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements c.d {
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

        @Override // c.a.p0.f1.i2.a.c.d
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

        @Override // c.a.p0.f1.i2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            }
        }

        @Override // c.a.p0.f1.i2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements FragmentTabHost.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabHostFragment a;

        /* loaded from: classes5.dex */
        public class a implements c.a.o0.d.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FragmentTabHost.b a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f32325b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ boolean f32326c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ c f32327d;

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
                this.f32327d = cVar;
                this.a = bVar;
                this.f32325b = i;
                this.f32326c = z;
            }

            @Override // c.a.o0.d.f
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
                    this.f32327d.a.j1(this.a, this.f32325b);
                    this.f32327d.a.f32321e.w(this.f32325b, this.f32326c);
                }
            }

            @Override // c.a.o0.d.f
            public void onFail() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    a(false);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements c.a.o0.d.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FrsTabInfo a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ FragmentTabHost.b f32328b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ int f32329c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f32330d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f32331e;

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
                this.f32331e = cVar;
                this.a = frsTabInfo;
                this.f32328b = bVar;
                this.f32329c = i;
                this.f32330d = z;
            }

            @Override // c.a.o0.d.f
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
                    this.f32331e.a.j1(this.f32328b, this.f32329c);
                    this.f32331e.a.f32321e.w(this.f32329c, this.f32330d);
                }
            }

            @Override // c.a.o0.d.f
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
                    FragmentTabHost.b i2 = this.a.f32321e.i(i);
                    String str = null;
                    if (this.a.f32323g != null && this.a.f32323g.getForum() != null) {
                        str = this.a.f32323g.getForum().getId();
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
                this.a.f32321e.getCurrentFragment();
                int Z0 = this.a.Z0(i);
                if (Z0 != 1) {
                    this.a.f32320d.Q2();
                } else {
                    this.a.f32320d.Z3();
                }
                if (Z0 != 1) {
                    if (Z0 == 4 || Z0 == 25) {
                        if (this.a.k.getVisibility() == 8) {
                            this.a.k.setVisibility(0);
                        }
                    } else {
                        if (this.a.f32320d != null) {
                            this.a.f32320d.x3(false);
                        }
                        this.a.k.setVisibility(8);
                        this.a.f1();
                    }
                    if (this.a.f32320d != null) {
                        this.a.f32320d.s3(false);
                        return;
                    }
                    return;
                }
                if (this.a.f32320d != null) {
                    this.a.f32320d.x3(true);
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
        this.f32324h = 0;
        this.o = new a(this);
        this.p = new b(this);
        this.f32318b = frsTabController;
    }

    public final void O0(FragmentTabHost.b bVar, String str) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, str) == null) {
            TiebaStatic.log(new StatisticItem("c12334").param("obj_locate", X0(bVar)).param("fid", str));
            if (bVar == null || (runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(c.a.d.f.m.b.g(str, 0L)))) == null || !((Boolean) runTask.getData()).booleanValue()) {
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
            FragmentTabHost fragmentTabHost = this.f32321e;
            if (fragmentTabHost != null) {
                TiebaStatic.log(new StatisticItem("c12342").param("obj_locate", X0(fragmentTabHost.i(fragmentTabHost.getCurrentTabIndex()))).param("fid", str));
            }
            StatisticItem statisticItem = new StatisticItem("c13604");
            if (getPageContext() != null) {
                c.a.o0.o0.c.b(getPageContext().getPageActivity(), statisticItem);
            }
            FrsFragment frsFragment = this.f32320d;
            if (frsFragment != null) {
                c.a.p0.f1.l2.a.b(statisticItem, frsFragment.c(), this.f32320d.a());
            }
            c.a.p0.f1.l2.a.a(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            FrsFragment frsFragment = this.f32320d;
            if (frsFragment != null && frsFragment.isAdded() && this.f32320d.getPageContext() != null) {
                c.a.p0.f1.z1.d.a(this.f32320d.getPageContext(), this.f32320d.f0());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void R0(c.a.o0.h0.b bVar, c.a.o0.h0.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, bVar, cVar, tbFragmentTabIndicator, str) == null) || cVar == null || (nVar = this.f32323g) == null || nVar.getForum() == null) {
            return;
        }
        ForumData forum = this.f32323g.getForum();
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        bVar2.a = cVar.f10299e;
        Fragment fragment = cVar.a;
        bVar2.f29925c = fragment;
        boolean z = true;
        if (fragment.getArguments() == null) {
            Bundle bundle = new Bundle();
            bundle.putString("name", forum.getName());
            bundle.putString("from", forum.getSpecialForumType());
            bundle.putString("fid", forum.getId());
            bundle.putString("fname", forum.getName());
            bundle.putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
            bVar2.f29925c.setArguments(bundle);
        } else {
            bVar2.f29925c.getArguments().putString("fid", forum.getId());
            bVar2.f29925c.getArguments().putString("fname", forum.getName());
            bVar2.f29925c.getArguments().putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
        }
        tbFragmentTabIndicator.setContentTvTopMargin(c.a.d.f.p.n.f(this.a, R.dimen.tbds2));
        tbFragmentTabIndicator.setIconResourceId(cVar.f10298d);
        tbFragmentTabIndicator.setTextSize(0, c.a.d.f.p.n.f(this.a.getActivity(), R.dimen.tbds40));
        if (cVar.i == c.a.o0.h0.c.k && cVar.f10299e == 99) {
            tbFragmentTabIndicator.setIconViewWithoutText(c.a.d.f.p.n.f(this.a, R.dimen.obfuscated_res_0x7f070281), c.a.d.f.p.n.f(this.a.getActivity(), R.dimen.tbds12));
        }
        if (!TextUtils.isEmpty(str)) {
            if (StringHelper.getChineseAndEnglishLength(str) > 8) {
                str = StringHelper.subString(str, 8);
            }
            tbFragmentTabIndicator.setText(str);
        } else {
            tbFragmentTabIndicator.setText(cVar.f10296b);
        }
        tbFragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
        tbFragmentTabIndicator.setTipPosType(1);
        tbFragmentTabIndicator.setIsContentSelectBold(true);
        tbFragmentTabIndicator.setContentSelectTextSize(getResources().getDimension(R.dimen.tbds46));
        tbFragmentTabIndicator.setContentDefaultTextSize(getResources().getDimension(R.dimen.tbds46));
        tbFragmentTabIndicator.setThemeColorInfo(forum.getThemeColorInfo());
        tbFragmentTabIndicator.setContentSelectTextColor(R.color.CAM_X0105);
        tbFragmentTabIndicator.setContentDefaultTextColor(R.color.CAM_X0107);
        if (!((cVar.i == c.a.o0.h0.c.k && cVar.f10299e == 99) ? false : false) && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
            tbFragmentTabIndicator.a(String.valueOf(bVar2.a), S0((FragmentTabIndicator) tbFragmentTabIndicator));
        }
        bVar2.f29924b = tbFragmentTabIndicator;
        bVar2.f29926d = bVar;
        this.f32321e.c(bVar2);
    }

    public final TbFragmentTabIndicator.a S0(FragmentTabIndicator fragmentTabIndicator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fragmentTabIndicator)) == null) {
            int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070234);
            ImageView imageView = new ImageView(this.a);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f08072d);
            TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
            fragmentTabIndicator.setTipPosType(1);
            fragmentTabIndicator.setTipTopMargin(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070234));
            aVar.f30586f = fragmentTabIndicator;
            aVar.f30583c = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070234);
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
            FragmentTabHost fragmentTabHost = this.f32321e;
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
            FragmentTabHost fragmentTabHost = this.f32321e;
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
            j0 j0Var = this.f32319c;
            if (j0Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(j0Var.f());
            for (int i = 0; i < count; i++) {
                if (this.f32319c.f().get(i).tab_id.intValue() == 1) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f32321e : (FragmentTabHost) invokeV.objValue;
    }

    public final int Z0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            j0 j0Var = this.f32319c;
            if (j0Var != null && i < ListUtils.getCount(j0Var.f())) {
                return this.f32319c.f().get(i).tab_id.intValue();
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final int a1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            j0 j0Var = this.f32319c;
            if (j0Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(j0Var.f());
            for (int i2 = 0; i2 < count; i2++) {
                if (this.f32319c.f().get(i2).tab_id.intValue() == i) {
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
            j0 j0Var = this.f32319c;
            if (j0Var == null || i >= ListUtils.getCount(j0Var.f())) {
                return null;
            }
            return this.f32319c.f().get(i);
        }
        return (FrsTabInfo) invokeI.objValue;
    }

    public FragmentTabHost.b c1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            FragmentTabHost fragmentTabHost = this.f32321e;
            if (fragmentTabHost == null) {
                return null;
            }
            return fragmentTabHost.i(i);
        }
        return (FragmentTabHost.b) invokeI.objValue;
    }

    public f d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.j : (f) invokeV.objValue;
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
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (frsFragment = this.f32320d) == null || frsFragment.f0() == null || (forum = this.f32320d.f0().getForum()) == null) {
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
        FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.f32320d.getContext());
        frsProfessionIntroActivityConfig.putColor(str, str2, str3, str4, str5, str6, str7);
        frsProfessionIntroActivityConfig.start();
    }

    public void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, Boolean.FALSE));
            f fVar = this.j;
            if (fVar == null || !fVar.n()) {
                return;
            }
            this.j.m(true);
        }
    }

    public boolean g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            f fVar = this.j;
            if (fVar == null) {
                return false;
            }
            return fVar.n();
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
            TbFragmentTabIndicator tbFragmentTabIndicator = bVar.f29924b;
            if (tbFragmentTabIndicator != null) {
                tbFragmentTabIndicator.c();
            }
            if (bVar.f29924b.d(String.valueOf(bVar.a)) != null) {
                if (bVar.f29924b.d(String.valueOf(bVar.a)).a.getVisibility() == 0) {
                    bVar.f29924b.d(String.valueOf(bVar.a)).a.setVisibility(8);
                    i1(bVar);
                } else if (this.i == i) {
                    i1(bVar);
                }
            }
            this.i = i;
        }
    }

    public void k1(n nVar, j0 j0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, nVar, j0Var) == null) || nVar == null || j0Var == null || this.f32321e == null) {
            return;
        }
        this.f32323g = nVar;
        this.f32319c = j0Var;
        j0Var.m();
        if (ListUtils.isEmpty(this.f32319c.g())) {
            return;
        }
        List<c.a.o0.h0.b> g2 = this.f32319c.g();
        List<FrsTabInfo> f2 = this.f32319c.f();
        this.f32321e.setShouldDrawDividerLine(false);
        this.f32321e.setShouldDrawIndicatorLine(false);
        this.f32321e.setShouldDrawTopLine(false);
        this.f32321e.r(false);
        this.f32321e.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0207);
        this.f32321e.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (f2.size() == g2.size()) {
            int size = f2.size();
            for (int i = 0; i < size; i++) {
                c.a.o0.h0.b bVar = g2.get(i);
                if (bVar != null) {
                    FrsTabInfo frsTabInfo = f2.get(i);
                    R0(bVar, bVar.b(), bVar.c(this.a.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                }
            }
        } else {
            for (c.a.o0.h0.b bVar2 : g2) {
                R0(bVar2, bVar2.b(), bVar2.c(this.a.getActivity()), null);
            }
        }
        this.f32321e.n(2);
        this.f32321e.setViewPagerScrollable(false);
        int a1 = a1(this.f32324h);
        if (a1 < 0) {
            a1 = a1(this.f32323g.getGameDefaultTabId());
        }
        if (a1 < 0) {
            a1 = W0();
        }
        if (a1 < 0) {
            a1 = 0;
        }
        this.f32324h = a1;
        this.i = a1;
        this.f32318b.s0(a1);
        this.f32318b.t0(this.i);
        this.f32321e.setCurrentTab(a1);
        int Z0 = Z0(a1);
        if (Z0 != 1) {
            FrsFragment frsFragment = this.f32320d;
            if (frsFragment != null) {
                frsFragment.s3(false);
                if (Z0 != 4 && Z0 != 25) {
                    this.f32320d.x3(false);
                    this.k.setVisibility(8);
                    this.f32320d.Q2();
                }
            }
            if (this.f32323g.getForum() != null) {
                e c2 = c.a.p0.f1.q2.d.d().c(this.f32323g.getForum().getName());
                if (Z0 == 25) {
                    if (c2 == null) {
                        c2 = new e(null);
                    }
                    c2.f(true);
                    c.a.p0.f1.q2.d.d().e(this.f32323g.getForum().getName(), c2);
                } else if (c2 != null && c2.c()) {
                    c2.f(false);
                    c.a.p0.f1.q2.d.d().e(this.f32323g.getForum().getName(), c2);
                }
            }
        }
        this.f32321e.s(TbadkCoreApplication.getInst().getSkinType());
    }

    public void l1(int i) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i) == null) || (fragmentTabHost = this.f32321e) == null) {
            return;
        }
        fragmentTabHost.setCurrentTab(i);
    }

    public void m1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.f32324h = i;
        }
    }

    public void n1(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, frsFragment) == null) {
            this.f32320d = frsFragment;
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
            this.m = new d(this.a.getPageContext());
            c.a.p0.f1.i2.a.c cVar = new c.a.p0.f1.i2.a.c(this.a.getPageContext());
            this.n = cVar;
            cVar.i(this.p);
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            FragmentTabHost fragmentTabHost = this.f32321e;
            if (fragmentTabHost != null) {
                fragmentTabHost.s(TbadkCoreApplication.getInst().getSkinType());
            }
            f fVar = this.j;
            if (fVar != null) {
                fVar.t(i);
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
            if (this.f32321e == null) {
                FragmentTabHost fragmentTabHost = new FragmentTabHost(this.a);
                this.f32321e = fragmentTabHost;
                fragmentTabHost.setClipChildren(false);
                this.f32321e.setClipToPadding(false);
                this.f32321e.setup(getChildFragmentManager());
                this.f32321e.getFragmentTabWidget().setAbsoluteWeight(true);
                this.f32321e.setTabContainerShadowShow(true);
                FrameLayout frameLayout = new FrameLayout(this.a.getActivity());
                this.f32322f = frameLayout;
                frameLayout.setClipChildren(false);
                this.f32322f.setClipToPadding(false);
                this.f32322f.addView(this.f32321e);
                this.f32321e.setOnTabSelectionListener(h1());
            }
            return this.f32322f;
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
        FrsViewData f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, Boolean.TRUE));
            if (this.j == null) {
                FrsFragment frsFragment = this.f32320d;
                f fVar = new f(this.a.getPageContext(), this.f32322f, "frs", (frsFragment == null || (f0 = frsFragment.f0()) == null) ? null : f0.getVoiceRoomConfig());
                this.j = fVar;
                fVar.H("2");
                ItemInfo itemInfo = this.f32320d.f0().itemInfo;
                this.j.G((itemInfo == null || itemInfo.id.intValue() <= 0 || m.isEmpty(itemInfo.name)) ? false : true);
            }
            if (this.f32320d.f0().getAnti() != null) {
                this.j.D(this.f32320d.f0().getAnti().getCanGoods());
            }
            ForumWriteData x2 = this.f32320d.x2();
            x2.setDefaultZone(i);
            this.j.I(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
            this.j.E(x2);
            this.j.F(this.f32320d.f0().itemInfo);
            this.j.K(T0());
            FrsFragment frsFragment2 = this.f32320d;
            if (frsFragment2 != null && frsFragment2.f0() != null) {
                this.j.F(this.f32320d.f0().itemInfo);
            }
            UtilHelper.setNavigationBarBackground(this.a, T0());
            this.j.L(false, null, this.k);
            FrsFragment frsFragment3 = this.f32320d;
            if (frsFragment3 == null || frsFragment3.f0() == null || this.f32320d.f0().itemInfo == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13721").param("fid", this.f32320d.c()).param("fname", this.f32320d.a()).param("obj_param1", this.f32320d.f0().itemInfo.name));
        }
    }

    public void r1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || !ViewHelper.checkUpIsLogin(this.a) || this.m.c() || Q0()) {
            return;
        }
        if (this.f32320d.I2().I(502) != null) {
            this.n.h(this.f32320d.c(), this.f32320d.I2().A().a);
        } else {
            q1(-1);
        }
    }
}
