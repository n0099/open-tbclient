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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.p0.a4.f;
import d.a.p0.h3.m;
import d.a.p0.p3.d;
import d.a.p0.u0.f2.a.c;
import d.a.p0.u0.i0;
import d.a.p0.u0.m2.e;
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
    public BaseFragmentActivity f15424e;

    /* renamed from: f  reason: collision with root package name */
    public FrsTabController f15425f;

    /* renamed from: g  reason: collision with root package name */
    public i0 f15426g;

    /* renamed from: h  reason: collision with root package name */
    public FrsFragment f15427h;

    /* renamed from: i  reason: collision with root package name */
    public FragmentTabHost f15428i;
    public FrameLayout j;
    public m k;
    public int l;
    public int m;
    public f n;
    public OvalActionButton o;
    public FRSRefreshButton p;
    public d q;
    public d.a.p0.u0.f2.a.c r;
    public final View.OnClickListener s;
    public c.d t;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabHostFragment f15429e;

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
            this.f15429e = frsTabHostFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            this.f15429e.v1();
            if (this.f15429e.f15428i == null) {
                return;
            }
            String str = null;
            if (this.f15429e.k != null && this.f15429e.k.getForum() != null) {
                str = this.f15429e.k.getForum().getId();
            }
            this.f15429e.U0(str);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabHostFragment f15430a;

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
            this.f15430a = frsTabHostFragment;
        }

        @Override // d.a.p0.u0.f2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                if (z && i2 == 502) {
                    this.f15430a.u1(1);
                } else if (z) {
                    this.f15430a.u1(0);
                } else if (i2 != 502) {
                    this.f15430a.u1(-1);
                } else {
                    this.f15430a.i1();
                }
            }
        }

        @Override // d.a.p0.u0.f2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            }
        }

        @Override // d.a.p0.u0.f2.a.c.d
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
        public final /* synthetic */ FrsTabHostFragment f15431a;

        /* loaded from: classes4.dex */
        public class a implements d.a.o0.d.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ FragmentTabHost.b f15432a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f15433b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ boolean f15434c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ c f15435d;

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
                this.f15435d = cVar;
                this.f15432a = bVar;
                this.f15433b = i2;
                this.f15434c = z;
            }

            @Override // d.a.o0.d.f
            public void onFail() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    onSwitchGet(false);
                }
            }

            @Override // d.a.o0.d.f
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
                    this.f15435d.f15431a.n1(this.f15432a, this.f15433b);
                    this.f15435d.f15431a.f15428i.s(this.f15433b, this.f15434c);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements d.a.o0.d.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ FrsTabInfo f15436a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ FragmentTabHost.b f15437b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ int f15438c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f15439d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f15440e;

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
                this.f15440e = cVar;
                this.f15436a = frsTabInfo;
                this.f15437b = bVar;
                this.f15438c = i2;
                this.f15439d = z;
            }

            @Override // d.a.o0.d.f
            public void onFail() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    onSwitchGet(false);
                }
            }

            @Override // d.a.o0.d.f
            public void onSwitchGet(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    if (z) {
                        if (TbadkApplication.getInst().getCurrentActivity() instanceof TbPageContextSupport) {
                            UrlManager.getInstance().dealOneLink(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), new String[]{this.f15436a.tab_url});
                            return;
                        }
                        return;
                    }
                    this.f15440e.f15431a.n1(this.f15437b, this.f15438c);
                    this.f15440e.f15431a.f15428i.s(this.f15438c, this.f15439d);
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
            this.f15431a = frsTabHostFragment;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                FrsTabInfo g1 = this.f15431a.g1(i2);
                if (g1 == null || g1.tab_type.intValue() != 11) {
                    FragmentTabHost.b f2 = this.f15431a.f15428i.f(i2);
                    String str = null;
                    if (this.f15431a.k != null && this.f15431a.k.getForum() != null) {
                        str = this.f15431a.k.getForum().getId();
                    }
                    this.f15431a.T0(f2, str);
                    int i3 = f2.f12363a;
                    if (i3 == 5) {
                        if (!TbadkCoreApplication.isLogin()) {
                            ViewHelper.skipToLoginActivity(this.f15431a.f15424e.getPageContext().getPageActivity());
                            return false;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, new a(this, f2, i2, z)));
                        return false;
                    } else if (i3 != 305) {
                        this.f15431a.n1(f2, i2);
                        return true;
                    } else if (!TbadkCoreApplication.isLogin()) {
                        ViewHelper.skipToLoginActivity(this.f15431a.f15424e.getPageContext().getPageActivity());
                        return false;
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, new b(this, g1, f2, i2, z)));
                        return false;
                    }
                }
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f15431a.f15424e.getPageContext(), new String[]{g1.tab_url}, true);
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                this.f15431a.f15428i.getCurrentFragment();
                int e1 = this.f15431a.e1(i2);
                if (e1 != 1) {
                    this.f15431a.f15427h.M2();
                } else {
                    this.f15431a.f15427h.R3();
                }
                if (e1 != 1) {
                    if (e1 == 4 || e1 == 25) {
                        if (this.f15431a.o.getVisibility() == 8) {
                            this.f15431a.o.setVisibility(0);
                        }
                    } else {
                        if (this.f15431a.f15427h != null) {
                            this.f15431a.f15427h.p3(false);
                        }
                        this.f15431a.o.setVisibility(8);
                        this.f15431a.j1();
                    }
                    if (this.f15431a.f15427h != null) {
                        this.f15431a.f15427h.k3(false);
                        return;
                    }
                    return;
                }
                if (this.f15431a.f15427h != null) {
                    this.f15431a.f15427h.p3(true);
                }
                this.f15431a.o.setVisibility(0);
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
        this.f15425f = frsTabController;
    }

    public final void T0(FragmentTabHost.b bVar, String str) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, str) == null) {
            TiebaStatic.log(new StatisticItem("c12334").param("obj_locate", c1(bVar)).param("fid", str));
            if (bVar == null || (runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(d.a.c.e.m.b.f(str, 0L)))) == null || !((Boolean) runTask.getData()).booleanValue()) {
                return;
            }
            int i2 = bVar.f12363a;
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

    public final void U0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            FragmentTabHost fragmentTabHost = this.f15428i;
            if (fragmentTabHost != null) {
                TiebaStatic.log(new StatisticItem("c12342").param("obj_locate", c1(fragmentTabHost.f(fragmentTabHost.getCurrentTabIndex()))).param("fid", str));
            }
            StatisticItem statisticItem = new StatisticItem("c13604");
            if (getPageContext() != null) {
                d.a.o0.j0.c.b(getPageContext().getPageActivity(), statisticItem);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            FrsFragment frsFragment = this.f15427h;
            if (frsFragment != null && frsFragment.isAdded() && this.f15427h.getPageContext() != null) {
                d.a.p0.u0.w1.d.a(this.f15427h.getPageContext(), this.f15427h.i0());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void W0(d.a.o0.e0.b bVar, d.a.o0.e0.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, bVar, cVar, tbFragmentTabIndicator, str) == null) || cVar == null || (mVar = this.k) == null || mVar.getForum() == null) {
            return;
        }
        ForumData forum = this.k.getForum();
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        bVar2.f12363a = cVar.f51960e;
        Fragment fragment = cVar.f51956a;
        bVar2.f12365c = fragment;
        boolean z = true;
        if (fragment.getArguments() == null) {
            Bundle bundle = new Bundle();
            bundle.putString("name", forum.getName());
            bundle.putString("from", forum.getSpecialForumType());
            bundle.putString("fid", forum.getId());
            bundle.putString("fname", forum.getName());
            bundle.putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
            bVar2.f12365c.setArguments(bundle);
        } else {
            bVar2.f12365c.getArguments().putString("fid", forum.getId());
            bVar2.f12365c.getArguments().putString("fname", forum.getName());
            bVar2.f12365c.getArguments().putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
        }
        tbFragmentTabIndicator.setContentTvTopMargin(l.g(this.f15424e, R.dimen.tbds2));
        tbFragmentTabIndicator.setIconResourceId(cVar.f51959d);
        tbFragmentTabIndicator.setTextSize(0, l.g(this.f15424e.getActivity(), R.dimen.tbds40));
        if (cVar.f51964i == d.a.o0.e0.c.j && cVar.f51960e == 99) {
            tbFragmentTabIndicator.setIconViewWithoutText(l.g(this.f15424e, R.dimen.ds96), l.g(this.f15424e.getActivity(), R.dimen.tbds12));
        }
        if (!TextUtils.isEmpty(str)) {
            if (StringHelper.getChineseAndEnglishLength(str) > 8) {
                str = StringHelper.subString(str, 8);
            }
            tbFragmentTabIndicator.setText(str);
        } else {
            tbFragmentTabIndicator.setText(cVar.f51957b);
        }
        tbFragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
        tbFragmentTabIndicator.setTipPosType(1);
        tbFragmentTabIndicator.setIsContentSelectBold(true);
        tbFragmentTabIndicator.setContentSelectTextSize(getResources().getDimension(R.dimen.tbds46));
        tbFragmentTabIndicator.setContentDefaultTextSize(getResources().getDimension(R.dimen.tbds46));
        tbFragmentTabIndicator.setThemeColorInfo(forum.getThemeColorInfo());
        tbFragmentTabIndicator.setContentSelectTextColor(R.color.CAM_X0105);
        tbFragmentTabIndicator.setContentDefaultTextColor(R.color.CAM_X0107);
        if (!((cVar.f51964i == d.a.o0.e0.c.j && cVar.f51960e == 99) ? false : false) && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
            tbFragmentTabIndicator.a(String.valueOf(bVar2.f12363a), X0((FragmentTabIndicator) tbFragmentTabIndicator));
        }
        bVar2.f12364b = tbFragmentTabIndicator;
        bVar2.f12366d = bVar;
        this.f15428i.a(bVar2);
    }

    public final TbFragmentTabIndicator.a X0(FragmentTabIndicator fragmentTabIndicator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fragmentTabIndicator)) == null) {
            int dimensionPixelSize = this.f15424e.getResources().getDimensionPixelSize(R.dimen.ds12);
            ImageView imageView = new ImageView(this.f15424e);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
            imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
            TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
            fragmentTabIndicator.setTipPosType(1);
            fragmentTabIndicator.setTipTopMargin(this.f15424e.getResources().getDimensionPixelSize(R.dimen.ds12));
            aVar.f13120f = fragmentTabIndicator;
            aVar.f13117c = this.f15424e.getResources().getDimensionPixelSize(R.dimen.ds12);
            aVar.f13115a = imageView;
            imageView.setVisibility(8);
            return aVar;
        }
        return (TbFragmentTabIndicator.a) invokeL.objValue;
    }

    public int Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                return this.f15424e.getResources().getColor(R.color.CAM_X0201_1);
            }
            return this.f15424e.getResources().getColor(R.color.CAM_X0201);
        }
        return invokeV.intValue;
    }

    public Fragment Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FragmentTabHost fragmentTabHost = this.f15428i;
            if (fragmentTabHost == null) {
                return null;
            }
            return fragmentTabHost.getCurrentFragment();
        }
        return (Fragment) invokeV.objValue;
    }

    public int a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            FragmentTabHost fragmentTabHost = this.f15428i;
            if (fragmentTabHost == null) {
                return -1;
            }
            return fragmentTabHost.getCurrentTabType();
        }
        return invokeV.intValue;
    }

    public final int b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            i0 i0Var = this.f15426g;
            if (i0Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(i0Var.g());
            for (int i2 = 0; i2 < count; i2++) {
                if (this.f15426g.g().get(i2).tab_id.intValue() == 1) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final int c1(FragmentTabHost.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bVar)) == null) {
            int i2 = bVar.f12363a;
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

    public FragmentTabHost d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f15428i : (FragmentTabHost) invokeV.objValue;
    }

    public final int e1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            i0 i0Var = this.f15426g;
            if (i0Var != null && i2 < ListUtils.getCount(i0Var.g())) {
                return this.f15426g.g().get(i2).tab_id.intValue();
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final int f1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            i0 i0Var = this.f15426g;
            if (i0Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(i0Var.g());
            for (int i3 = 0; i3 < count; i3++) {
                if (this.f15426g.g().get(i3).tab_id.intValue() == i2) {
                    return i3;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final FrsTabInfo g1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            i0 i0Var = this.f15426g;
            if (i0Var == null || i2 >= ListUtils.getCount(i0Var.g())) {
                return null;
            }
            return this.f15426g.g().get(i2);
        }
        return (FrsTabInfo) invokeI.objValue;
    }

    public FragmentTabHost.b h1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            FragmentTabHost fragmentTabHost = this.f15428i;
            if (fragmentTabHost == null) {
                return null;
            }
            return fragmentTabHost.f(i2);
        }
        return (FragmentTabHost.b) invokeI.objValue;
    }

    public final void i1() {
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
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (frsFragment = this.f15427h) == null || frsFragment.i0() == null || (forum = this.f15427h.i0().getForum()) == null) {
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
        FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.f15427h.getContext());
        frsProfessionIntroActivityConfig.putColor(str, str2, str3, str4, str5, str6, str7);
        frsProfessionIntroActivityConfig.start();
    }

    public void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, Boolean.FALSE));
            f fVar = this.n;
            if (fVar == null || !fVar.l()) {
                return;
            }
            this.n.k(true);
        }
    }

    public boolean k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            f fVar = this.n;
            if (fVar == null) {
                return false;
            }
            return fVar.l();
        }
        return invokeV.booleanValue;
    }

    public final FragmentTabHost.a l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? new c(this) : (FragmentTabHost.a) invokeV.objValue;
    }

    public final void m1(FragmentTabHost.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bVar) == null) {
            int i2 = bVar.f12363a;
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

    public final void n1(FragmentTabHost.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048596, this, bVar, i2) == null) {
            TbFragmentTabIndicator tbFragmentTabIndicator = bVar.f12364b;
            if (tbFragmentTabIndicator != null) {
                tbFragmentTabIndicator.c();
            }
            if (bVar.f12364b.d(String.valueOf(bVar.f12363a)) != null) {
                if (bVar.f12364b.d(String.valueOf(bVar.f12363a)).f13115a.getVisibility() == 0) {
                    bVar.f12364b.d(String.valueOf(bVar.f12363a)).f13115a.setVisibility(8);
                    m1(bVar);
                } else if (this.m == i2) {
                    m1(bVar);
                }
            }
            this.m = i2;
        }
    }

    public void o1(m mVar, i0 i0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, mVar, i0Var) == null) || mVar == null || i0Var == null || this.f15428i == null) {
            return;
        }
        this.k = mVar;
        this.f15426g = i0Var;
        i0Var.n();
        if (ListUtils.isEmpty(this.f15426g.h())) {
            return;
        }
        List<d.a.o0.e0.b> h2 = this.f15426g.h();
        List<FrsTabInfo> g2 = this.f15426g.g();
        this.f15428i.setShouldDrawDividerLine(false);
        this.f15428i.setShouldDrawIndicatorLine(false);
        this.f15428i.setShouldDrawTopLine(false);
        this.f15428i.o(false);
        this.f15428i.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0207);
        this.f15428i.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (g2.size() == h2.size()) {
            int size = g2.size();
            for (int i2 = 0; i2 < size; i2++) {
                d.a.o0.e0.b bVar = h2.get(i2);
                if (bVar != null) {
                    FrsTabInfo frsTabInfo = g2.get(i2);
                    W0(bVar, bVar.getFragmentTabStructure(), bVar.getTabIndicator(this.f15424e.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                }
            }
        } else {
            for (d.a.o0.e0.b bVar2 : h2) {
                W0(bVar2, bVar2.getFragmentTabStructure(), bVar2.getTabIndicator(this.f15424e.getActivity()), null);
            }
        }
        this.f15428i.k(2);
        this.f15428i.setViewPagerScrollable(false);
        int f1 = f1(this.l);
        if (f1 < 0) {
            f1 = f1(this.k.getGameDefaultTabId());
        }
        if (f1 < 0) {
            f1 = b1();
        }
        if (f1 < 0) {
            f1 = 0;
        }
        this.l = f1;
        this.m = f1;
        this.f15425f.r0(f1);
        this.f15425f.s0(this.m);
        this.f15428i.setCurrentTab(f1);
        int e1 = e1(f1);
        if (e1 != 1) {
            FrsFragment frsFragment = this.f15427h;
            if (frsFragment != null) {
                frsFragment.k3(false);
                if (e1 != 4 && e1 != 25) {
                    this.f15427h.p3(false);
                    this.o.setVisibility(8);
                    this.f15427h.M2();
                }
            }
            if (this.k.getForum() != null) {
                e c2 = d.a.p0.u0.m2.d.d().c(this.k.getForum().getName());
                if (e1 == 25) {
                    if (c2 == null) {
                        c2 = new e(null);
                    }
                    c2.f(true);
                    d.a.p0.u0.m2.d.d().e(this.k.getForum().getName(), c2);
                } else if (c2 != null && c2.c()) {
                    c2.f(false);
                    d.a.p0.u0.m2.d.d().e(this.k.getForum().getName(), c2);
                }
            }
        }
        this.f15428i.p(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
            this.q = new d(this.f15424e.getPageContext());
            d.a.p0.u0.f2.a.c cVar = new d.a.p0.u0.f2.a.c(this.f15424e.getPageContext());
            this.r = cVar;
            cVar.j(this.t);
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            FragmentTabHost fragmentTabHost = this.f15428i;
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
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048601, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f15424e = (BaseFragmentActivity) getActivity();
            if (this.f15428i == null) {
                FragmentTabHost fragmentTabHost = new FragmentTabHost(this.f15424e);
                this.f15428i = fragmentTabHost;
                fragmentTabHost.setClipChildren(false);
                this.f15428i.setClipToPadding(false);
                this.f15428i.setup(getChildFragmentManager());
                this.f15428i.getFragmentTabWidget().setAbsoluteWeight(true);
                this.f15428i.setTabContainerShadowShow(true);
                FrameLayout frameLayout = new FrameLayout(this.f15424e.getActivity());
                this.j = frameLayout;
                frameLayout.setClipChildren(false);
                this.j.setClipToPadding(false);
                this.j.addView(this.f15428i);
                this.f15428i.setOnTabSelectionListener(l1());
            }
            return this.j;
        }
        return (View) invokeLLL.objValue;
    }

    public void p1(int i2) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i2) == null) || (fragmentTabHost = this.f15428i) == null) {
            return;
        }
        fragmentTabHost.setCurrentTab(i2);
    }

    public void q1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.l = i2;
        }
    }

    public void r1(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, frsFragment) == null) {
            this.f15427h = frsFragment;
        }
    }

    public void s1(FRSRefreshButton fRSRefreshButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, fRSRefreshButton) == null) {
            this.p = fRSRefreshButton;
        }
    }

    public void t1(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, ovalActionButton) == null) {
            this.o = ovalActionButton;
            ovalActionButton.setOnClickListener(this.s);
        }
    }

    public final void u1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, Boolean.TRUE));
            if (this.n == null) {
                f fVar = new f(this.f15424e.getPageContext(), this.j, "frs");
                this.n = fVar;
                fVar.C("2");
                ItemInfo itemInfo = this.f15427h.i0().itemInfo;
                this.n.B((itemInfo == null || itemInfo.id.intValue() <= 0 || k.isEmpty(itemInfo.name)) ? false : true);
            }
            if (this.f15427h.i0().getAnti() != null) {
                this.n.y(this.f15427h.i0().getAnti().getCanGoods());
            }
            ForumWriteData u2 = this.f15427h.u2();
            u2.setDefaultZone(i2);
            this.n.D(i2 == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
            this.n.z(u2);
            this.n.A(this.f15427h.i0().itemInfo);
            this.n.F(Y0());
            FrsFragment frsFragment = this.f15427h;
            if (frsFragment != null && frsFragment.i0() != null) {
                this.n.A(this.f15427h.i0().itemInfo);
            }
            UtilHelper.setNavigationBarBackground(this.f15424e, Y0());
            this.n.G(false, null, this.o);
            FrsFragment frsFragment2 = this.f15427h;
            if (frsFragment2 == null || frsFragment2.i0() == null || this.f15427h.i0().itemInfo == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13721").param("fid", this.f15427h.h()).param("fname", this.f15427h.g()).param("obj_param1", this.f15427h.i0().itemInfo.name));
        }
    }

    public void v1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || !ViewHelper.checkUpIsLogin(this.f15424e) || this.q.c() || V0()) {
            return;
        }
        if (this.f15427h.F2().H(502) != null) {
            this.r.i(this.f15427h.h(), this.f15427h.F2().z().f16082a);
        } else {
            u1(-1);
        }
    }
}
