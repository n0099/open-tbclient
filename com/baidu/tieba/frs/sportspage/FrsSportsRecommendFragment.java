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
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.s0.g1.j.e;
import c.a.s0.s.q.c2;
import c.a.s0.s.q.d2;
import c.a.t0.d1.c1;
import c.a.t0.d1.d1;
import c.a.t0.d1.e1;
import c.a.t0.d1.f1;
import c.a.t0.d1.g1;
import c.a.t0.d1.i1;
import c.a.t0.d1.n1;
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
import java.util.Iterator;
/* loaded from: classes12.dex */
public class FrsSportsRecommendFragment extends FrsCommonTabFragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SPORTS_TAB_ID = 503;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar A;
    public View B;
    public View C;
    public View D;
    public ImageView E;
    public ImageView F;
    public NoNetworkView G;
    public c.a.t0.d1.u2.a H;
    public c.a.t0.d1.u2.b I;
    public CollapsingToolbarLayout J;
    public AppBarLayout K;
    public FrameLayout L;
    public n1 M;
    public TextView N;
    public long O;
    public boolean P;
    public int Q;
    public CustomMessageListener R;
    public AppBarLayout.OnOffsetChangedListener S;
    public final View.OnClickListener mCommonOnClickListener;
    public View x;
    public View y;
    public ObservedChangeLinearLayout z;

    /* loaded from: classes12.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsSportsRecommendFragment a;

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
            this.a = frsSportsRecommendFragment;
        }

        @Override // c.a.s0.g1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || i3 == i5) {
                return;
            }
            this.a.J.setMinimumHeight(i3);
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsSportsRecommendFragment f45347e;

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
            this.f45347e = frsSportsRecommendFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f45347e.D != null && view == this.f45347e.D) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f45347e.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsSportsRecommendFragment a;

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
            this.a = frsSportsRecommendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String[] split = ((String) customResponsedMessage.getData()).split("_");
            if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == c.a.d.f.m.b.e(split[1], 0)) {
                this.a.K.setExpanded(true, false);
                this.a.mMainView.z(0);
                this.a.forceRefresh();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsSportsRecommendFragment a;

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
            this.a = frsSportsRecommendFragment;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i2) == null) || this.a.Q == i2) {
                return;
            }
            int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            int height = this.a.A.getHeight();
            int height2 = (this.a.G == null || l.z()) ? 0 : this.a.G.getHeight();
            int f2 = ((n.f(this.a.getContext(), d1.tbds318) - height) - height2) - statusBarHeight;
            int i3 = statusBarHeight + height + height2 + f2;
            int totalScrollRange = (appBarLayout.getTotalScrollRange() - i3) - f2;
            int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i2);
            if (totalScrollRange <= 0) {
                return;
            }
            float f3 = 1.0f;
            float abs = (Math.abs(i2 * 1.0f) - f2) / totalScrollRange;
            if (Float.compare(abs, 1.0f) > 0) {
                abs = 1.0f;
            }
            if (Float.compare(abs, 0.05f) <= 0 && this.a.Q - i2 < 0) {
                abs = 0.0f;
            }
            if (f2 + i2 <= 0 || this.a.A == null || this.a.A.getBarBgView() == null || this.a.A.getBarBgView().getAlpha() != 0.0f) {
                if (Float.compare(abs, 1.0f) == 0) {
                    this.a.K(Math.abs(i3 - totalScrollRange2));
                    if (this.a.x != null) {
                        this.a.x.setVisibility(0);
                    }
                } else if (this.a.x != null && this.a.y != null) {
                    if (this.a.y.getHeight() != UtilHelper.getStatusBarHeight()) {
                        this.a.K(0);
                    }
                    this.a.x.setVisibility(8);
                }
                if (abs > 0.5f) {
                    UtilHelper.changeStatusBarIconAndTextColor(false, this.a.getPageContext().getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, this.a.getPageContext().getPageActivity());
                    f3 = abs;
                }
                if (this.a.A != null) {
                    this.a.A.getBarBgView().setAlpha(f3);
                    this.a.L();
                }
                this.a.M(i2, f3);
                this.a.Q = i2;
                this.a.adjustRefreshView(i2);
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
        this.P = true;
        this.mCommonOnClickListener = new b(this);
        this.R = new c(this, 2001446);
        this.S = new d(this);
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.K.setExpanded(true);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.y == null) {
            return;
        }
        if (UtilHelper.canUseStyleImmersiveSticky() && this.y.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.y.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.y.setLayoutParams(layoutParams);
            this.y.setVisibility(0);
            ImageView imageView = this.F;
            if (imageView == null || !(imageView.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                return;
            }
            ((FrameLayout.LayoutParams) ((CollapsingToolbarLayout.LayoutParams) this.F.getLayoutParams())).topMargin = layoutParams.height;
            return;
        }
        this.y.setVisibility(8);
    }

    public final void I() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.A == null) {
                NavigationBar navigationBar = (NavigationBar) this.mRootView.findViewById(f1.view_navigation_bar);
                this.A = navigationBar;
                navigationBar.getBarBgView().setAlpha(0.0f);
            }
            if (this.z == null) {
                ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) this.mRootView.findViewById(f1.navigation_bar_wrapperLayout);
                this.z = observedChangeLinearLayout;
                observedChangeLinearLayout.setOnSizeChangeListener(new a(this));
            }
            if (this.B == null) {
                this.B = this.mRootView.findViewById(f1.navbar_bottom_divider_shadow);
            }
            if (this.C == null) {
                this.C = this.mRootView.findViewById(f1.feed_top_divider_shadow);
            }
            if (this.D == null) {
                View addSystemImageButton = this.A.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                this.D = addSystemImageButton;
                addSystemImageButton.setOnClickListener(this.mCommonOnClickListener);
                this.E = (ImageView) this.D.findViewById(f1.widget_navi_back_button);
            }
            if (this.F == null) {
                this.F = (ImageView) this.mRootView.findViewById(f1.navbar_fake_back_icon);
            }
            if (this.G == null) {
                this.G = new NoNetworkView(getContext());
                this.G.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.z.addView(this.G);
            }
            if (l.A()) {
                this.G.setVisibility(8);
            } else {
                this.G.setVisibility(0);
            }
            if (this.A == null || (frsViewData = this.viewData) == null || frsViewData.getForum() == null) {
                return;
            }
            String name = this.viewData.getForum().getName();
            if (StringHelper.getChineseAndEnglishLength(name) > 14) {
                name = StringHelper.cutForumNameWithSuffix(name, 14, "...");
            }
            this.A.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(i1.frs_sports_recommend_bar_name), name));
        }
    }

    public final void J(int i2) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (this.N == null) {
                TextView textView = new TextView(getContext());
                this.N = textView;
                textView.setTextSize(0, getResources().getDimensionPixelSize(d1.fontsize28));
                this.N.setGravity(17);
            }
            if (this.N != null) {
                if (this.P) {
                    if (i2 <= 0) {
                        return;
                    }
                    string = TbadkCoreApplication.getInst().getString(i1.frs_sports_recommend_first_time_tip);
                } else if (i2 > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(i1.frs_sports_recommend_get_new_thread), Integer.valueOf(i2));
                } else {
                    string = TbadkCoreApplication.getInst().getString(i1.frs_sports_recommend_no_new_thread);
                }
                this.N.setText(string);
            }
            SkinManager.setBackgroundResource(this.N, c1.CAM_X0302);
            SkinManager.setViewTextColor(this.N, c1.CAM_X0112);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, n.f(TbadkCoreApplication.getInst(), d1.ds56));
            if (this.M == null) {
                this.M = new n1();
            }
            this.M.h(this.N, this.L, layoutParams, 2000);
        }
    }

    public final void K(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || !UtilHelper.canUseStyleImmersiveSticky() || (view = this.y) == null || this.x == null || view.getLayoutParams() == null || this.x.getLayoutParams() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.y.getLayoutParams();
        int statusBarHeight = UtilHelper.getStatusBarHeight() - i2;
        layoutParams.height = statusBarHeight;
        if (statusBarHeight < 0) {
            layoutParams.height = 0;
        }
        this.y.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.x.getLayoutParams();
        layoutParams2.height = i2;
        if (i2 > UtilHelper.getStatusBarHeight()) {
            layoutParams2.height = UtilHelper.getStatusBarHeight();
        }
        this.x.setLayoutParams(layoutParams2);
    }

    public final void L() {
        NavigationBar navigationBar;
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (navigationBar = this.A) == null) {
            return;
        }
        float alpha = navigationBar.getBarBgView() != null ? this.A.getBarBgView().getAlpha() : 0.0f;
        TextView textView = this.A.mCenterText;
        if (textView != null) {
            textView.setAlpha(alpha);
        }
        if (this.E != null && (imageView = this.F) != null) {
            imageView.setAlpha(1.0f - alpha);
            this.E.setAlpha(alpha);
        }
        View view = this.y;
        if (view != null) {
            view.setAlpha(alpha);
        }
        View view2 = this.x;
        if (view2 != null) {
            view2.setAlpha(alpha);
        }
    }

    public final void M(int i2, float f2) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) || this.B == null || this.C == null || (navigationBar = this.A) == null) {
            return;
        }
        int height = navigationBar.getHeight();
        if (!(f2 == 1.0f)) {
            this.B.setVisibility(8);
            this.C.setVisibility(8);
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.B.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.C.getLayoutParams();
        if (this.mMainView.j().getFirstCompletelyVisiblePosition() != 0) {
            this.B.setVisibility(8);
            this.C.setVisibility(0);
            if (layoutParams2.topMargin != 0) {
                layoutParams2.topMargin = 0;
                return;
            }
            return;
        }
        int height2 = height - (this.K.getHeight() + i2);
        int f3 = n.f(TbadkCoreApplication.getInst().getContext(), d1.tbds16);
        if (height2 > 0 && height2 < f3) {
            this.B.setVisibility(0);
            this.C.setVisibility(0);
            layoutParams.bottomMargin = -height2;
            layoutParams2.topMargin = -(f3 - height2);
        } else if (height2 > f3) {
            this.B.setVisibility(8);
            this.C.setVisibility(0);
            if (layoutParams2.topMargin != 0) {
                layoutParams2.topMargin = 0;
            }
        } else {
            if (layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
            }
            this.B.setVisibility(0);
            this.C.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.s0.q0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "a063" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int getLayoutR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? g1.frs_sports_recommend_fragment : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public c.a.s0.q0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            c.a.s0.q0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.t(c.a.d.f.m.b.g(this.forumId, 0L));
            }
            return pageStayDurationItem;
        }
        return (c.a.s0.q0.d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.t0.d1.u2.a aVar = this.H;
            if (aVar != null) {
                aVar.h();
            }
            c.a.t0.d1.u2.b bVar = this.I;
            if (bVar != null) {
                bVar.d();
            }
            NoNetworkView noNetworkView = this.G;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            SkinManager.setBackgroundResource(this.B, e1.top_shadow);
            SkinManager.setBackgroundResource(this.C, e1.top_shadow);
            SkinManager.setBackgroundColor(this.y, c1.CAM_X0201);
            SkinManager.setBackgroundColor(this.x, c1.CAM_X0201);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.F, e1.ic_icon_pure_topbar_return40_svg, c1.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.E, e1.ic_icon_pure_topbar_return40_svg, c1.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            NavigationBar navigationBar = this.A;
            if (navigationBar != null) {
                SkinManager.setBackgroundColor(navigationBar.getBarBgView(), c1.CAM_X0207);
                this.A.onChangeSkinType(getPageContext(), i2);
                if (this.A.getBackground() != null && this.A.getBackground().mutate() != null) {
                    this.A.getBackground().mutate().setAlpha(0);
                }
            }
            L();
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.R);
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, layoutInflater, viewGroup, bundle)) == null) {
            super.onCreateView(layoutInflater, viewGroup, bundle);
            this.mMainView.w(true);
            I();
            this.J = (CollapsingToolbarLayout) this.mRootView.findViewById(f1.frs_collapse_layout);
            this.y = this.mRootView.findViewById(f1.statebar_view);
            this.x = this.mRootView.findViewById(f1.statebar_view_holder);
            AppBarLayout appBarLayout = (AppBarLayout) this.mRootView.findViewById(f1.frs_app_bar_layout);
            this.K = appBarLayout;
            appBarLayout.addOnOffsetChangedListener(this.S);
            H();
            c.a.t0.d1.u2.a aVar = new c.a.t0.d1.u2.a(this, this.mRootView);
            this.H = aVar;
            aVar.j(this.viewData);
            this.I = new c.a.t0.d1.u2.b(this, this.mRootView);
            c.a.t0.d1.w1.c cVar = this.mModelController;
            if (cVar != null) {
                cVar.r(0L);
            }
            this.L = (FrameLayout) this.mRootView.findViewById(f1.frs_sports_recommend_list_container);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.mRootView;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (!isPrimary() && this.lastResumeTime != 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
                if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                    ((FrsActivity) getFragmentActivity()).mSpecialTabPageStayTime += currentTimeMillis;
                }
            }
            super.onPrimary();
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, c.a.t0.d1.s0
    public void onPullRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            G();
            c.a.t0.d1.w1.c cVar = this.mModelController;
            if (cVar != null) {
                cVar.r(this.O);
            }
            super.onPullRefresh();
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void onViewDataChange(c.a.t0.d1.w1.d dVar) {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, dVar) == null) {
            super.onViewDataChange(dVar);
            if (dVar == null) {
                return;
            }
            c.a.t0.d1.u2.a aVar = this.H;
            if (aVar != null) {
                aVar.k(dVar.f17041i, dVar.f17042j, dVar.f17043k);
            }
            if (this.I != null && (frsViewData = this.viewData) != null && frsViewData.getForum() != null) {
                this.I.e(dVar.l, this.viewData.getForum().getId());
            }
            c.a.t0.d1.w1.c cVar = this.mModelController;
            if (cVar != null && cVar.j()) {
                J(dVar.f17040h);
            }
            if (!ListUtils.isEmpty(dVar.f17039g)) {
                Iterator<c.a.d.n.e.n> it = dVar.f17039g.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c.a.d.n.e.n next = it.next();
                    d2 d2Var = null;
                    if (next instanceof d2) {
                        d2Var = (d2) next;
                    } else if (next instanceof c2) {
                        d2Var = ((c2) next).w;
                    }
                    if (d2Var != null && !d2Var.D2()) {
                        long g2 = c.a.d.f.m.b.g(d2Var.g0(), 0L);
                        if (g2 > 0) {
                            this.O = g2;
                            break;
                        }
                    }
                }
            }
            this.P = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i2) {
        c.a.t0.d1.w1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (bVar = this.mMainView) == null) {
            return;
        }
        bVar.x(true);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048595, this, view, str, z) == null) {
            super.showNetRefreshView(this.L, str, z);
            adjustRefreshView(0);
        }
    }
}
