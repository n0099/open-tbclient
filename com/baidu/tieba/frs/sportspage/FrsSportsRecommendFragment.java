package com.baidu.tieba.frs.sportspage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.o0.b1.j.e;
import d.a.o0.r.q.a2;
import d.a.o0.r.q.b2;
import d.a.p0.u0.c1;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class FrsSportsRecommendFragment extends FrsCommonTabFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View G;
    public View H;
    public ObservedChangeLinearLayout I;
    public NavigationBar J;
    public View K;
    public View L;
    public View M;
    public ImageView N;
    public ImageView O;
    public NoNetworkView P;
    public d.a.p0.u0.i2.a Q;
    public d.a.p0.u0.i2.b R;
    public CollapsingToolbarLayout S;
    public AppBarLayout T;
    public FrameLayout U;
    public c1 V;
    public TextView W;
    public long X;
    public boolean Y;
    public int Z;
    public final View.OnClickListener a0;
    public CustomMessageListener b0;
    public AppBarLayout.OnOffsetChangedListener c0;

    /* loaded from: classes4.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsSportsRecommendFragment f16019a;

        public a(FrsSportsRecommendFragment frsSportsRecommendFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSportsRecommendFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16019a = frsSportsRecommendFragment;
        }

        @Override // d.a.o0.b1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || i3 == i5) {
                return;
            }
            this.f16019a.S.setMinimumHeight(i3);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsSportsRecommendFragment f16020e;

        public b(FrsSportsRecommendFragment frsSportsRecommendFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSportsRecommendFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16020e = frsSportsRecommendFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f16020e.M != null && view == this.f16020e.M) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f16020e.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsSportsRecommendFragment f16021a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(FrsSportsRecommendFragment frsSportsRecommendFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSportsRecommendFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16021a = frsSportsRecommendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String[] split = ((String) customResponsedMessage.getData()).split("_");
            if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == d.a.c.e.m.b.d(split[1], 0)) {
                this.f16021a.T.setExpanded(true, false);
                this.f16021a.f15543e.y(0);
                this.f16021a.s();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsSportsRecommendFragment f16022a;

        public d(FrsSportsRecommendFragment frsSportsRecommendFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSportsRecommendFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16022a = frsSportsRecommendFragment;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i2) == null) || this.f16022a.Z == i2) {
                return;
            }
            int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            int height = this.f16022a.J.getHeight();
            int height2 = (this.f16022a.P == null || j.z()) ? 0 : this.f16022a.P.getHeight();
            int g2 = ((l.g(this.f16022a.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
            int i3 = statusBarHeight + height + height2 + g2;
            int totalScrollRange = (appBarLayout.getTotalScrollRange() - i3) - g2;
            int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i2);
            if (totalScrollRange <= 0) {
                return;
            }
            float f2 = 1.0f;
            float abs = (Math.abs(i2 * 1.0f) - g2) / totalScrollRange;
            if (Float.compare(abs, 1.0f) > 0) {
                abs = 1.0f;
            }
            if (Float.compare(abs, 0.05f) <= 0 && this.f16022a.Z - i2 < 0) {
                abs = 0.0f;
            }
            if (g2 + i2 <= 0 || this.f16022a.J == null || this.f16022a.J.getBarBgView() == null || this.f16022a.J.getBarBgView().getAlpha() != 0.0f) {
                if (Float.compare(abs, 1.0f) == 0) {
                    this.f16022a.w1(Math.abs(i3 - totalScrollRange2));
                    if (this.f16022a.G != null) {
                        this.f16022a.G.setVisibility(0);
                    }
                } else if (this.f16022a.G != null && this.f16022a.H != null) {
                    if (this.f16022a.H.getHeight() != UtilHelper.getStatusBarHeight()) {
                        this.f16022a.w1(0);
                    }
                    this.f16022a.G.setVisibility(8);
                }
                if (abs > 0.5f) {
                    UtilHelper.changeStatusBarIconAndTextColor(false, this.f16022a.getPageContext().getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, this.f16022a.getPageContext().getPageActivity());
                    f2 = abs;
                }
                if (this.f16022a.J != null) {
                    this.f16022a.J.getBarBgView().setAlpha(f2);
                    this.f16022a.x1();
                }
                this.f16022a.y1(i2, f2);
                this.f16022a.Z = i2;
                this.f16022a.O0(i2);
            }
        }
    }

    public FrsSportsRecommendFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.Y = true;
        this.a0 = new b(this);
        this.b0 = new c(this, 2001446);
        this.c0 = new d(this);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.frs_sports_recommend_fragment : invokeV.intValue;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void Y0(d.a.p0.u0.k1.d dVar) {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            super.Y0(dVar);
            if (dVar == null) {
                return;
            }
            d.a.p0.u0.i2.a aVar = this.Q;
            if (aVar != null) {
                aVar.k(dVar.f63008i, dVar.j, dVar.k);
            }
            if (this.R != null && (frsViewData = this.f15546h) != null && frsViewData.getForum() != null) {
                this.R.e(dVar.l, this.f15546h.getForum().getId());
            }
            d.a.p0.u0.k1.c cVar = this.f15544f;
            if (cVar != null && cVar.j()) {
                v1(dVar.f63007h);
            }
            if (!ListUtils.isEmpty(dVar.f63006g)) {
                Iterator<n> it = dVar.f63006g.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n next = it.next();
                    b2 b2Var = null;
                    if (next instanceof b2) {
                        b2Var = (b2) next;
                    } else if (next instanceof a2) {
                        b2Var = ((a2) next).w;
                    }
                    if (b2Var != null && !b2Var.m2()) {
                        long f2 = d.a.c.e.m.b.f(b2Var.c0(), 0L);
                        if (f2 > 0) {
                            this.X = f2;
                            break;
                        }
                    }
                }
            }
            this.Y = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.o0.k0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "a063" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d.a.o0.k0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d.a.o0.k0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.q(d.a.c.e.m.b.f(this.f15547i, 0L));
            }
            return pageStayDurationItem;
        }
        return (d.a.o0.k0.d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, d.a.p0.u0.r0
    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            s1();
            d.a.p0.u0.k1.c cVar = this.f15544f;
            if (cVar != null) {
                cVar.q(this.X);
            }
            super.l0();
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.p0.u0.i2.a aVar = this.Q;
            if (aVar != null) {
                aVar.h();
            }
            d.a.p0.u0.i2.b bVar = this.R;
            if (bVar != null) {
                bVar.d();
            }
            NoNetworkView noNetworkView = this.P;
            if (noNetworkView != null) {
                noNetworkView.c(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            SkinManager.setBackgroundResource(this.K, R.drawable.top_shadow);
            SkinManager.setBackgroundResource(this.L, R.drawable.top_shadow);
            SkinManager.setBackgroundColor(this.H, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.G, R.color.CAM_X0201);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.O, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.N, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            NavigationBar navigationBar = this.J;
            if (navigationBar != null) {
                SkinManager.setBackgroundColor(navigationBar.getBarBgView(), R.color.CAM_X0207);
                this.J.onChangeSkinType(getPageContext(), i2);
                if (this.J.getBackground() != null && this.J.getBackground().mutate() != null) {
                    this.J.getBackground().mutate().setAlpha(0);
                }
            }
            x1();
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.b0);
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            super.onCreateView(layoutInflater, viewGroup, bundle);
            this.f15543e.v(true);
            u1();
            this.S = (CollapsingToolbarLayout) this.f15545g.findViewById(R.id.frs_collapse_layout);
            this.H = this.f15545g.findViewById(R.id.statebar_view);
            this.G = this.f15545g.findViewById(R.id.statebar_view_holder);
            AppBarLayout appBarLayout = (AppBarLayout) this.f15545g.findViewById(R.id.frs_app_bar_layout);
            this.T = appBarLayout;
            appBarLayout.addOnOffsetChangedListener(this.c0);
            t1();
            d.a.p0.u0.i2.a aVar = new d.a.p0.u0.i2.a(this, this.f15545g);
            this.Q = aVar;
            aVar.j(this.f15546h);
            this.R = new d.a.p0.u0.i2.b(this, this.f15545g);
            d.a.p0.u0.k1.c cVar = this.f15544f;
            if (cVar != null) {
                cVar.q(0L);
            }
            this.U = (FrameLayout) this.f15545g.findViewById(R.id.frs_sports_recommend_list_container);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.f15545g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (isPrimary() && this.lastResumeTime != 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
                if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                    ((FrsActivity) getFragmentActivity()).mSpecialTabPageStayTime += currentTimeMillis;
                }
            }
            super.onPause();
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (!isPrimary() && this.lastResumeTime != 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
                if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                    ((FrsActivity) getFragmentActivity()).mSpecialTabPageStayTime += currentTimeMillis;
                }
            }
            super.onPrimary();
        }
    }

    public final void s1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.T.setExpanded(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i2) {
        d.a.p0.u0.k1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (bVar = this.f15543e) == null) {
            return;
        }
        bVar.w(true);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048589, this, view, str, z) == null) {
            super.showNetRefreshView(this.U, str, z);
            O0(0);
        }
    }

    public final void t1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.H == null) {
            return;
        }
        if (UtilHelper.canUseStyleImmersiveSticky() && this.H.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.H.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.H.setLayoutParams(layoutParams);
            this.H.setVisibility(0);
            ImageView imageView = this.O;
            if (imageView == null || !(imageView.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                return;
            }
            ((FrameLayout.LayoutParams) ((CollapsingToolbarLayout.LayoutParams) this.O.getLayoutParams())).topMargin = layoutParams.height;
            return;
        }
        this.H.setVisibility(8);
    }

    public final void u1() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.J == null) {
                NavigationBar navigationBar = (NavigationBar) this.f15545g.findViewById(R.id.view_navigation_bar);
                this.J = navigationBar;
                navigationBar.getBarBgView().setAlpha(0.0f);
            }
            if (this.I == null) {
                ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) this.f15545g.findViewById(R.id.navigation_bar_wrapperLayout);
                this.I = observedChangeLinearLayout;
                observedChangeLinearLayout.setOnSizeChangeListener(new a(this));
            }
            if (this.K == null) {
                this.K = this.f15545g.findViewById(R.id.navbar_bottom_divider_shadow);
            }
            if (this.L == null) {
                this.L = this.f15545g.findViewById(R.id.feed_top_divider_shadow);
            }
            if (this.M == null) {
                View addSystemImageButton = this.J.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                this.M = addSystemImageButton;
                addSystemImageButton.setOnClickListener(this.a0);
                this.N = (ImageView) this.M.findViewById(R.id.widget_navi_back_button);
            }
            if (this.O == null) {
                this.O = (ImageView) this.f15545g.findViewById(R.id.navbar_fake_back_icon);
            }
            if (this.P == null) {
                this.P = new NoNetworkView(getContext());
                this.P.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.I.addView(this.P);
            }
            if (j.A()) {
                this.P.setVisibility(8);
            } else {
                this.P.setVisibility(0);
            }
            if (this.J == null || (frsViewData = this.f15546h) == null || frsViewData.getForum() == null) {
                return;
            }
            String name = this.f15546h.getForum().getName();
            if (StringHelper.getChineseAndEnglishLength(name) > 14) {
                name = StringHelper.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
            }
            this.J.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    public final void v1(int i2) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            if (this.W == null) {
                TextView textView = new TextView(getContext());
                this.W = textView;
                textView.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.W.setGravity(17);
            }
            if (this.W != null) {
                if (this.Y) {
                    if (i2 <= 0) {
                        return;
                    }
                    string = TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_first_time_tip);
                } else if (i2 > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_get_new_thread), Integer.valueOf(i2));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_no_new_thread);
                }
                this.W.setText(string);
            }
            SkinManager.setBackgroundResource(this.W, R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.W, R.color.CAM_X0112);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.V == null) {
                this.V = new c1();
            }
            this.V.h(this.W, this.U, layoutParams, 2000);
        }
    }

    public final void w1(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || !UtilHelper.canUseStyleImmersiveSticky() || (view = this.H) == null || this.G == null || view.getLayoutParams() == null || this.G.getLayoutParams() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.H.getLayoutParams();
        int statusBarHeight = UtilHelper.getStatusBarHeight() - i2;
        layoutParams.height = statusBarHeight;
        if (statusBarHeight < 0) {
            layoutParams.height = 0;
        }
        this.H.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.G.getLayoutParams();
        layoutParams2.height = i2;
        if (i2 > UtilHelper.getStatusBarHeight()) {
            layoutParams2.height = UtilHelper.getStatusBarHeight();
        }
        this.G.setLayoutParams(layoutParams2);
    }

    public final void x1() {
        NavigationBar navigationBar;
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (navigationBar = this.J) == null) {
            return;
        }
        float alpha = navigationBar.getBarBgView() != null ? this.J.getBarBgView().getAlpha() : 0.0f;
        TextView textView = this.J.mCenterText;
        if (textView != null) {
            textView.setAlpha(alpha);
        }
        if (this.N != null && (imageView = this.O) != null) {
            imageView.setAlpha(1.0f - alpha);
            this.N.setAlpha(alpha);
        }
        View view = this.H;
        if (view != null) {
            view.setAlpha(alpha);
        }
        View view2 = this.G;
        if (view2 != null) {
            view2.setAlpha(alpha);
        }
    }

    public final void y1(int i2, float f2) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) || this.K == null || this.L == null || (navigationBar = this.J) == null) {
            return;
        }
        int height = navigationBar.getHeight();
        if (!(f2 == 1.0f)) {
            this.K.setVisibility(8);
            this.L.setVisibility(8);
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.K.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.L.getLayoutParams();
        if (this.f15543e.j().getFirstCompletelyVisiblePosition() != 0) {
            this.K.setVisibility(8);
            this.L.setVisibility(0);
            if (layoutParams2.topMargin != 0) {
                layoutParams2.topMargin = 0;
                return;
            }
            return;
        }
        int height2 = height - (this.T.getHeight() + i2);
        int g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
        if (height2 > 0 && height2 < g2) {
            this.K.setVisibility(0);
            this.L.setVisibility(0);
            layoutParams.bottomMargin = -height2;
            layoutParams2.topMargin = -(g2 - height2);
        } else if (height2 > g2) {
            this.K.setVisibility(8);
            this.L.setVisibility(0);
            if (layoutParams2.topMargin != 0) {
                layoutParams2.topMargin = 0;
            }
        } else {
            if (layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
            }
            this.K.setVisibility(0);
            this.L.setVisibility(8);
        }
    }
}
