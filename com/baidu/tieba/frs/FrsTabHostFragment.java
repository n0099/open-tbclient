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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.q0.a4.f;
import d.a.q0.h3.m;
import d.a.q0.p3.d;
import d.a.q0.u0.f2.a.c;
import d.a.q0.u0.i0;
import d.a.q0.u0.m2.e;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ItemInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class FrsTabHostFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f15472e;

    /* renamed from: f  reason: collision with root package name */
    public FrsTabController f15473f;

    /* renamed from: g  reason: collision with root package name */
    public i0 f15474g;

    /* renamed from: h  reason: collision with root package name */
    public FrsFragment f15475h;

    /* renamed from: i  reason: collision with root package name */
    public FragmentTabHost f15476i;
    public FrameLayout j;
    public m k;
    public int l;
    public int m;
    public f n;
    public OvalActionButton o;
    public FRSRefreshButton p;
    public d q;
    public d.a.q0.u0.f2.a.c r;
    public final View.OnClickListener s;
    public c.d t;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabHostFragment f15477e;

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
            this.f15477e = frsTabHostFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            this.f15477e.A1();
            if (this.f15477e.f15476i == null) {
                return;
            }
            String str = null;
            if (this.f15477e.k != null && this.f15477e.k.getForum() != null) {
                str = this.f15477e.k.getForum().getId();
            }
            this.f15477e.Z0(str);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabHostFragment f15478a;

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
            this.f15478a = frsTabHostFragment;
        }

        @Override // d.a.q0.u0.f2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                if (z && i2 == 502) {
                    this.f15478a.z1(1);
                } else if (z) {
                    this.f15478a.z1(0);
                } else if (i2 != 502) {
                    this.f15478a.z1(-1);
                } else {
                    this.f15478a.n1();
                }
            }
        }

        @Override // d.a.q0.u0.f2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            }
        }

        @Override // d.a.q0.u0.f2.a.c.d
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

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabHostFragment f15479a;

        /* loaded from: classes4.dex */
        public class a implements d.a.p0.e.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ FragmentTabHost.b f15480a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f15481b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ boolean f15482c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ c f15483d;

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
                this.f15483d = cVar;
                this.f15480a = bVar;
                this.f15481b = i2;
                this.f15482c = z;
            }

            @Override // d.a.p0.e.f
            public void onFail() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    onSwitchGet(false);
                }
            }

            @Override // d.a.p0.e.f
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
                    this.f15483d.f15479a.s1(this.f15480a, this.f15481b);
                    this.f15483d.f15479a.f15476i.s(this.f15481b, this.f15482c);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements d.a.p0.e.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ FrsTabInfo f15484a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ FragmentTabHost.b f15485b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ int f15486c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f15487d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f15488e;

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
                this.f15488e = cVar;
                this.f15484a = frsTabInfo;
                this.f15485b = bVar;
                this.f15486c = i2;
                this.f15487d = z;
            }

            @Override // d.a.p0.e.f
            public void onFail() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    onSwitchGet(false);
                }
            }

            @Override // d.a.p0.e.f
            public void onSwitchGet(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    if (z) {
                        if (TbadkApplication.getInst().getCurrentActivity() instanceof TbPageContextSupport) {
                            UrlManager.getInstance().dealOneLink(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), new String[]{this.f15484a.tab_url});
                            return;
                        }
                        return;
                    }
                    this.f15488e.f15479a.s1(this.f15485b, this.f15486c);
                    this.f15488e.f15479a.f15476i.s(this.f15486c, this.f15487d);
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
            this.f15479a = frsTabHostFragment;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                FrsTabInfo l1 = this.f15479a.l1(i2);
                if (l1 == null || l1.tab_type.intValue() != 11) {
                    FragmentTabHost.b f2 = this.f15479a.f15476i.f(i2);
                    String str = null;
                    if (this.f15479a.k != null && this.f15479a.k.getForum() != null) {
                        str = this.f15479a.k.getForum().getId();
                    }
                    this.f15479a.Y0(f2, str);
                    int i3 = f2.f12393a;
                    if (i3 == 5) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(this.f15479a.f15472e.getPageContext().getPageActivity());
                            return false;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, new a(this, f2, i2, z)));
                        return false;
                    } else if (i3 != 305) {
                        this.f15479a.s1(f2, i2);
                        return true;
                    } else if (!TbadkCoreApplication.isLogin()) {
                        ViewHelper.skipToLoginActivity(this.f15479a.f15472e.getPageContext().getPageActivity());
                        return false;
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, new b(this, l1, f2, i2, z)));
                        return false;
                    }
                }
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f15479a.f15472e.getPageContext(), new String[]{l1.tab_url}, true);
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                this.f15479a.f15476i.getCurrentFragment();
                int j1 = this.f15479a.j1(i2);
                if (j1 != 1) {
                    this.f15479a.f15475h.R2();
                } else {
                    this.f15479a.f15475h.W3();
                }
                if (j1 != 1) {
                    if (j1 == 4 || j1 == 25) {
                        if (this.f15479a.o.getVisibility() == 8) {
                            this.f15479a.o.setVisibility(0);
                        }
                    } else {
                        if (this.f15479a.f15475h != null) {
                            this.f15479a.f15475h.u3(false);
                        }
                        this.f15479a.o.setVisibility(8);
                        this.f15479a.o1();
                    }
                    if (this.f15479a.f15475h != null) {
                        this.f15479a.f15475h.p3(false);
                        return;
                    }
                    return;
                }
                if (this.f15479a.f15475h != null) {
                    this.f15479a.f15475h.u3(true);
                }
                this.f15479a.o.setVisibility(0);
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
        this.f15473f = frsTabController;
    }

    public void A1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || !ViewHelper.checkUpIsLogin(this.f15472e) || this.q.c() || a1()) {
            return;
        }
        if (this.f15475h.K2().H(502) != null) {
            this.r.i(this.f15475h.h(), this.f15475h.K2().z().f16137a);
        } else {
            z1(-1);
        }
    }

    public final void Y0(FragmentTabHost.b bVar, String str) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, str) == null) {
            TiebaStatic.log(new StatisticItem("c12334").param("obj_locate", h1(bVar)).param("fid", str));
            if (bVar == null || (runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(d.a.d.e.m.b.f(str, 0L)))) == null || !((Boolean) runTask.getData()).booleanValue()) {
                return;
            }
            int i2 = bVar.f12393a;
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

    public final void Z0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            FragmentTabHost fragmentTabHost = this.f15476i;
            if (fragmentTabHost != null) {
                TiebaStatic.log(new StatisticItem("c12342").param("obj_locate", h1(fragmentTabHost.f(fragmentTabHost.getCurrentTabIndex()))).param("fid", str));
            }
            StatisticItem statisticItem = new StatisticItem("c13604");
            if (getPageContext() != null) {
                d.a.p0.l0.c.b(getPageContext().getPageActivity(), statisticItem);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            FrsFragment frsFragment = this.f15475h;
            if (frsFragment != null && frsFragment.isAdded() && this.f15475h.getPageContext() != null) {
                d.a.q0.u0.w1.d.a(this.f15475h.getPageContext(), this.f15475h.l0());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void b1(d.a.p0.g0.b bVar, d.a.p0.g0.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, bVar, cVar, tbFragmentTabIndicator, str) == null) || cVar == null || (mVar = this.k) == null || mVar.getForum() == null) {
            return;
        }
        ForumData forum = this.k.getForum();
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        bVar2.f12393a = cVar.f52622e;
        Fragment fragment = cVar.f52618a;
        bVar2.f12395c = fragment;
        boolean z = true;
        if (fragment.getArguments() == null) {
            Bundle bundle = new Bundle();
            bundle.putString("name", forum.getName());
            bundle.putString("from", forum.getSpecialForumType());
            bundle.putString("fid", forum.getId());
            bundle.putString("fname", forum.getName());
            bundle.putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
            bVar2.f12395c.setArguments(bundle);
        } else {
            bVar2.f12395c.getArguments().putString("fid", forum.getId());
            bVar2.f12395c.getArguments().putString("fname", forum.getName());
            bVar2.f12395c.getArguments().putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
        }
        tbFragmentTabIndicator.setContentTvTopMargin(l.g(this.f15472e, R.dimen.tbds2));
        tbFragmentTabIndicator.setIconResourceId(cVar.f52621d);
        tbFragmentTabIndicator.setTextSize(0, l.g(this.f15472e.getActivity(), R.dimen.tbds40));
        if (cVar.f52626i == d.a.p0.g0.c.j && cVar.f52622e == 99) {
            tbFragmentTabIndicator.setIconViewWithoutText(l.g(this.f15472e, R.dimen.ds96), l.g(this.f15472e.getActivity(), R.dimen.tbds12));
        }
        if (!TextUtils.isEmpty(str)) {
            if (StringHelper.getChineseAndEnglishLength(str) > 8) {
                str = StringHelper.subString(str, 8);
            }
            tbFragmentTabIndicator.setText(str);
        } else {
            tbFragmentTabIndicator.setText(cVar.f52619b);
        }
        tbFragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
        tbFragmentTabIndicator.setTipPosType(1);
        tbFragmentTabIndicator.setIsContentSelectBold(true);
        tbFragmentTabIndicator.setContentSelectTextSize(getResources().getDimension(R.dimen.tbds46));
        tbFragmentTabIndicator.setContentDefaultTextSize(getResources().getDimension(R.dimen.tbds46));
        tbFragmentTabIndicator.setThemeColorInfo(forum.getThemeColorInfo());
        tbFragmentTabIndicator.setContentSelectTextColor(R.color.CAM_X0105);
        tbFragmentTabIndicator.setContentDefaultTextColor(R.color.CAM_X0107);
        if (!((cVar.f52626i == d.a.p0.g0.c.j && cVar.f52622e == 99) ? false : false) && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
            tbFragmentTabIndicator.a(String.valueOf(bVar2.f12393a), c1((FragmentTabIndicator) tbFragmentTabIndicator));
        }
        bVar2.f12394b = tbFragmentTabIndicator;
        bVar2.f12396d = bVar;
        this.f15476i.a(bVar2);
    }

    public final TbFragmentTabIndicator.a c1(FragmentTabIndicator fragmentTabIndicator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, fragmentTabIndicator)) == null) {
            int dimensionPixelSize = this.f15472e.getResources().getDimensionPixelSize(R.dimen.ds12);
            ImageView imageView = new ImageView(this.f15472e);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
            imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
            TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
            fragmentTabIndicator.setTipPosType(1);
            fragmentTabIndicator.setTipTopMargin(this.f15472e.getResources().getDimensionPixelSize(R.dimen.ds12));
            aVar.f13169f = fragmentTabIndicator;
            aVar.f13166c = this.f15472e.getResources().getDimensionPixelSize(R.dimen.ds12);
            aVar.f13164a = imageView;
            imageView.setVisibility(8);
            return aVar;
        }
        return (TbFragmentTabIndicator.a) invokeL.objValue;
    }

    public int d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                return this.f15472e.getResources().getColor(R.color.CAM_X0201_1);
            }
            return this.f15472e.getResources().getColor(R.color.CAM_X0201);
        }
        return invokeV.intValue;
    }

    public Fragment e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            FragmentTabHost fragmentTabHost = this.f15476i;
            if (fragmentTabHost == null) {
                return null;
            }
            return fragmentTabHost.getCurrentFragment();
        }
        return (Fragment) invokeV.objValue;
    }

    public int f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            FragmentTabHost fragmentTabHost = this.f15476i;
            if (fragmentTabHost == null) {
                return -1;
            }
            return fragmentTabHost.getCurrentTabType();
        }
        return invokeV.intValue;
    }

    public final int g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            i0 i0Var = this.f15474g;
            if (i0Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(i0Var.g());
            for (int i2 = 0; i2 < count; i2++) {
                if (this.f15474g.g().get(i2).tab_id.intValue() == 1) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final int h1(FragmentTabHost.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bVar)) == null) {
            int i2 = bVar.f12393a;
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

    public FragmentTabHost i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f15476i : (FragmentTabHost) invokeV.objValue;
    }

    public final int j1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            i0 i0Var = this.f15474g;
            if (i0Var != null && i2 < ListUtils.getCount(i0Var.g())) {
                return this.f15474g.g().get(i2).tab_id.intValue();
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final int k1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            i0 i0Var = this.f15474g;
            if (i0Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(i0Var.g());
            for (int i3 = 0; i3 < count; i3++) {
                if (this.f15474g.g().get(i3).tab_id.intValue() == i2) {
                    return i3;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final FrsTabInfo l1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            i0 i0Var = this.f15474g;
            if (i0Var == null || i2 >= ListUtils.getCount(i0Var.g())) {
                return null;
            }
            return this.f15474g.g().get(i2);
        }
        return (FrsTabInfo) invokeI.objValue;
    }

    public FragmentTabHost.b m1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            FragmentTabHost fragmentTabHost = this.f15476i;
            if (fragmentTabHost == null) {
                return null;
            }
            return fragmentTabHost.f(i2);
        }
        return (FragmentTabHost.b) invokeI.objValue;
    }

    public final void n1() {
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
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (frsFragment = this.f15475h) == null || frsFragment.l0() == null || (forum = this.f15475h.l0().getForum()) == null) {
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
        FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.f15475h.getContext());
        frsProfessionIntroActivityConfig.putColor(str, str2, str3, str4, str5, str6, str7);
        frsProfessionIntroActivityConfig.start();
    }

    public void o1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, Boolean.FALSE));
            f fVar = this.n;
            if (fVar == null || !fVar.l()) {
                return;
            }
            this.n.k(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            this.q = new d(this.f15472e.getPageContext());
            d.a.q0.u0.f2.a.c cVar = new d.a.q0.u0.f2.a.c(this.f15472e.getPageContext());
            this.r = cVar;
            cVar.j(this.t);
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            FragmentTabHost fragmentTabHost = this.f15476i;
            if (fragmentTabHost != null) {
                fragmentTabHost.p(TbadkCoreApplication.getInst().getSkinType());
            }
            f fVar = this.n;
            if (fVar != null) {
                fVar.p(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048597, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f15472e = (BaseFragmentActivity) getActivity();
            if (this.f15476i == null) {
                FragmentTabHost fragmentTabHost = new FragmentTabHost(this.f15472e);
                this.f15476i = fragmentTabHost;
                fragmentTabHost.setClipChildren(false);
                this.f15476i.setClipToPadding(false);
                this.f15476i.setup(getChildFragmentManager());
                this.f15476i.getFragmentTabWidget().setAbsoluteWeight(true);
                this.f15476i.setTabContainerShadowShow(true);
                FrameLayout frameLayout = new FrameLayout(this.f15472e.getActivity());
                this.j = frameLayout;
                frameLayout.setClipChildren(false);
                this.j.setClipToPadding(false);
                this.j.addView(this.f15476i);
                this.f15476i.setOnTabSelectionListener(q1());
            }
            return this.j;
        }
        return (View) invokeLLL.objValue;
    }

    public boolean p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            f fVar = this.n;
            if (fVar == null) {
                return false;
            }
            return fVar.l();
        }
        return invokeV.booleanValue;
    }

    public final FragmentTabHost.a q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? new c(this) : (FragmentTabHost.a) invokeV.objValue;
    }

    public final void r1(FragmentTabHost.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bVar) == null) {
            int i2 = bVar.f12393a;
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

    public final void s1(FragmentTabHost.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048601, this, bVar, i2) == null) {
            TbFragmentTabIndicator tbFragmentTabIndicator = bVar.f12394b;
            if (tbFragmentTabIndicator != null) {
                tbFragmentTabIndicator.c();
            }
            if (bVar.f12394b.d(String.valueOf(bVar.f12393a)) != null) {
                if (bVar.f12394b.d(String.valueOf(bVar.f12393a)).f13164a.getVisibility() == 0) {
                    bVar.f12394b.d(String.valueOf(bVar.f12393a)).f13164a.setVisibility(8);
                    r1(bVar);
                } else if (this.m == i2) {
                    r1(bVar);
                }
            }
            this.m = i2;
        }
    }

    public void t1(m mVar, i0 i0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048602, this, mVar, i0Var) == null) || mVar == null || i0Var == null || this.f15476i == null) {
            return;
        }
        this.k = mVar;
        this.f15474g = i0Var;
        i0Var.n();
        if (ListUtils.isEmpty(this.f15474g.h())) {
            return;
        }
        List<d.a.p0.g0.b> h2 = this.f15474g.h();
        List<FrsTabInfo> g2 = this.f15474g.g();
        this.f15476i.setShouldDrawDividerLine(false);
        this.f15476i.setShouldDrawIndicatorLine(false);
        this.f15476i.setShouldDrawTopLine(false);
        this.f15476i.o(false);
        this.f15476i.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0207);
        this.f15476i.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (g2.size() == h2.size()) {
            int size = g2.size();
            for (int i2 = 0; i2 < size; i2++) {
                d.a.p0.g0.b bVar = h2.get(i2);
                if (bVar != null) {
                    FrsTabInfo frsTabInfo = g2.get(i2);
                    b1(bVar, bVar.getFragmentTabStructure(), bVar.getTabIndicator(this.f15472e.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                }
            }
        } else {
            for (d.a.p0.g0.b bVar2 : h2) {
                b1(bVar2, bVar2.getFragmentTabStructure(), bVar2.getTabIndicator(this.f15472e.getActivity()), null);
            }
        }
        this.f15476i.k(2);
        this.f15476i.setViewPagerScrollable(false);
        int k1 = k1(this.l);
        if (k1 < 0) {
            k1 = k1(this.k.getGameDefaultTabId());
        }
        if (k1 < 0) {
            k1 = g1();
        }
        if (k1 < 0) {
            k1 = 0;
        }
        this.l = k1;
        this.m = k1;
        this.f15473f.r0(k1);
        this.f15473f.s0(this.m);
        this.f15476i.setCurrentTab(k1);
        int j1 = j1(k1);
        if (j1 != 1) {
            FrsFragment frsFragment = this.f15475h;
            if (frsFragment != null) {
                frsFragment.p3(false);
                if (j1 != 4 && j1 != 25) {
                    this.f15475h.u3(false);
                    this.o.setVisibility(8);
                    this.f15475h.R2();
                }
            }
            if (this.k.getForum() != null) {
                e c2 = d.a.q0.u0.m2.d.d().c(this.k.getForum().getName());
                if (j1 == 25) {
                    if (c2 == null) {
                        c2 = new e(null);
                    }
                    c2.f(true);
                    d.a.q0.u0.m2.d.d().e(this.k.getForum().getName(), c2);
                } else if (c2 != null && c2.c()) {
                    c2.f(false);
                    d.a.q0.u0.m2.d.d().e(this.k.getForum().getName(), c2);
                }
            }
        }
        this.f15476i.p(TbadkCoreApplication.getInst().getSkinType());
    }

    public void u1(int i2) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i2) == null) || (fragmentTabHost = this.f15476i) == null) {
            return;
        }
        fragmentTabHost.setCurrentTab(i2);
    }

    public void v1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.l = i2;
        }
    }

    public void w1(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, frsFragment) == null) {
            this.f15475h = frsFragment;
        }
    }

    public void x1(FRSRefreshButton fRSRefreshButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, fRSRefreshButton) == null) {
            this.p = fRSRefreshButton;
        }
    }

    public void y1(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, ovalActionButton) == null) {
            this.o = ovalActionButton;
            ovalActionButton.setOnClickListener(this.s);
        }
    }

    public final void z1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, Boolean.TRUE));
            if (this.n == null) {
                f fVar = new f(this.f15472e.getPageContext(), this.j, "frs");
                this.n = fVar;
                fVar.C("2");
                ItemInfo itemInfo = this.f15475h.l0().itemInfo;
                this.n.B((itemInfo == null || itemInfo.id.intValue() <= 0 || k.isEmpty(itemInfo.name)) ? false : true);
            }
            if (this.f15475h.l0().getAnti() != null) {
                this.n.y(this.f15475h.l0().getAnti().getCanGoods());
            }
            ForumWriteData z2 = this.f15475h.z2();
            z2.setDefaultZone(i2);
            this.n.D(i2 == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
            this.n.z(z2);
            this.n.A(this.f15475h.l0().itemInfo);
            this.n.F(d1());
            FrsFragment frsFragment = this.f15475h;
            if (frsFragment != null && frsFragment.l0() != null) {
                this.n.A(this.f15475h.l0().itemInfo);
            }
            UtilHelper.setNavigationBarBackground(this.f15472e, d1());
            this.n.G(false, null, this.o);
            FrsFragment frsFragment2 = this.f15475h;
            if (frsFragment2 == null || frsFragment2.l0() == null || this.f15475h.l0().itemInfo == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13721").param("fid", this.f15475h.h()).param("fname", this.f15475h.g()).param("obj_param1", this.f15475h.l0().itemInfo.name));
        }
    }
}
