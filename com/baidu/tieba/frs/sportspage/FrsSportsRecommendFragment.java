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
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.q0.f1.j.e;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
import c.a.r0.w0.c1;
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
import java.util.Iterator;
/* loaded from: classes7.dex */
public class FrsSportsRecommendFragment extends FrsCommonTabFragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SPORTS_TAB_ID = 503;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public ImageView B;
    public NoNetworkView C;
    public c.a.r0.w0.j2.a D;
    public c.a.r0.w0.j2.b E;
    public CollapsingToolbarLayout F;
    public AppBarLayout G;
    public FrameLayout H;
    public c1 I;
    public TextView J;
    public long K;
    public boolean L;
    public int M;
    public CustomMessageListener N;
    public AppBarLayout.OnOffsetChangedListener O;
    public final View.OnClickListener mCommonOnClickListener;
    public View t;
    public View u;
    public ObservedChangeLinearLayout v;
    public NavigationBar w;
    public View x;
    public View y;
    public View z;

    /* loaded from: classes7.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsSportsRecommendFragment f51575a;

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
            this.f51575a = frsSportsRecommendFragment;
        }

        @Override // c.a.q0.f1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || i3 == i5) {
                return;
            }
            this.f51575a.F.setMinimumHeight(i3);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsSportsRecommendFragment f51576e;

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
            this.f51576e = frsSportsRecommendFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f51576e.z != null && view == this.f51576e.z) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f51576e.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsSportsRecommendFragment f51577a;

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
            this.f51577a = frsSportsRecommendFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String[] split = ((String) customResponsedMessage.getData()).split("_");
            if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == c.a.e.e.m.b.e(split[1], 0)) {
                this.f51577a.G.setExpanded(true, false);
                this.f51577a.mMainView.y(0);
                this.f51577a.forceRefresh();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsSportsRecommendFragment f51578a;

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
            this.f51578a = frsSportsRecommendFragment;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i2) == null) || this.f51578a.M == i2) {
                return;
            }
            int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            int height = this.f51578a.w.getHeight();
            int height2 = (this.f51578a.C == null || j.z()) ? 0 : this.f51578a.C.getHeight();
            int g2 = ((l.g(this.f51578a.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
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
            if (Float.compare(abs, 0.05f) <= 0 && this.f51578a.M - i2 < 0) {
                abs = 0.0f;
            }
            if (g2 + i2 <= 0 || this.f51578a.w == null || this.f51578a.w.getBarBgView() == null || this.f51578a.w.getBarBgView().getAlpha() != 0.0f) {
                if (Float.compare(abs, 1.0f) == 0) {
                    this.f51578a.D(Math.abs(i3 - totalScrollRange2));
                    if (this.f51578a.t != null) {
                        this.f51578a.t.setVisibility(0);
                    }
                } else if (this.f51578a.t != null && this.f51578a.u != null) {
                    if (this.f51578a.u.getHeight() != UtilHelper.getStatusBarHeight()) {
                        this.f51578a.D(0);
                    }
                    this.f51578a.t.setVisibility(8);
                }
                if (abs > 0.5f) {
                    UtilHelper.changeStatusBarIconAndTextColor(false, this.f51578a.getPageContext().getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, this.f51578a.getPageContext().getPageActivity());
                    f2 = abs;
                }
                if (this.f51578a.w != null) {
                    this.f51578a.w.getBarBgView().setAlpha(f2);
                    this.f51578a.J();
                }
                this.f51578a.K(i2, f2);
                this.f51578a.M = i2;
                this.f51578a.adjustRefreshView(i2);
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
        this.L = true;
        this.mCommonOnClickListener = new b(this);
        this.N = new c(this, 2001446);
        this.O = new d(this);
    }

    public final void A() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.w == null) {
                NavigationBar navigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
                this.w = navigationBar;
                navigationBar.getBarBgView().setAlpha(0.0f);
            }
            if (this.v == null) {
                ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) this.mRootView.findViewById(R.id.navigation_bar_wrapperLayout);
                this.v = observedChangeLinearLayout;
                observedChangeLinearLayout.setOnSizeChangeListener(new a(this));
            }
            if (this.x == null) {
                this.x = this.mRootView.findViewById(R.id.navbar_bottom_divider_shadow);
            }
            if (this.y == null) {
                this.y = this.mRootView.findViewById(R.id.feed_top_divider_shadow);
            }
            if (this.z == null) {
                View addSystemImageButton = this.w.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                this.z = addSystemImageButton;
                addSystemImageButton.setOnClickListener(this.mCommonOnClickListener);
                this.A = (ImageView) this.z.findViewById(R.id.widget_navi_back_button);
            }
            if (this.B == null) {
                this.B = (ImageView) this.mRootView.findViewById(R.id.navbar_fake_back_icon);
            }
            if (this.C == null) {
                this.C = new NoNetworkView(getContext());
                this.C.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.v.addView(this.C);
            }
            if (j.A()) {
                this.C.setVisibility(8);
            } else {
                this.C.setVisibility(0);
            }
            if (this.w == null || (frsViewData = this.viewData) == null || frsViewData.getForum() == null) {
                return;
            }
            String name = this.viewData.getForum().getName();
            if (StringHelper.getChineseAndEnglishLength(name) > 14) {
                name = StringHelper.cutForumNameWithSuffix(name, 14, "...");
            }
            this.w.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        }
    }

    public final void B(int i2) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (this.J == null) {
                TextView textView = new TextView(getContext());
                this.J = textView;
                textView.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
                this.J.setGravity(17);
            }
            if (this.J != null) {
                if (this.L) {
                    if (i2 <= 0) {
                        return;
                    }
                    string = TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_first_time_tip);
                } else if (i2 > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_get_new_thread), Integer.valueOf(i2));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_no_new_thread);
                }
                this.J.setText(string);
            }
            SkinManager.setBackgroundResource(this.J, R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.J, R.color.CAM_X0112);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.I == null) {
                this.I = new c1();
            }
            this.I.h(this.J, this.H, layoutParams, 2000);
        }
    }

    public final void D(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || !UtilHelper.canUseStyleImmersiveSticky() || (view = this.u) == null || this.t == null || view.getLayoutParams() == null || this.t.getLayoutParams() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
        int statusBarHeight = UtilHelper.getStatusBarHeight() - i2;
        layoutParams.height = statusBarHeight;
        if (statusBarHeight < 0) {
            layoutParams.height = 0;
        }
        this.u.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.t.getLayoutParams();
        layoutParams2.height = i2;
        if (i2 > UtilHelper.getStatusBarHeight()) {
            layoutParams2.height = UtilHelper.getStatusBarHeight();
        }
        this.t.setLayoutParams(layoutParams2);
    }

    public final void J() {
        NavigationBar navigationBar;
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (navigationBar = this.w) == null) {
            return;
        }
        float alpha = navigationBar.getBarBgView() != null ? this.w.getBarBgView().getAlpha() : 0.0f;
        TextView textView = this.w.mCenterText;
        if (textView != null) {
            textView.setAlpha(alpha);
        }
        if (this.A != null && (imageView = this.B) != null) {
            imageView.setAlpha(1.0f - alpha);
            this.A.setAlpha(alpha);
        }
        View view = this.u;
        if (view != null) {
            view.setAlpha(alpha);
        }
        View view2 = this.t;
        if (view2 != null) {
            view2.setAlpha(alpha);
        }
    }

    public final void K(int i2, float f2) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) || this.x == null || this.y == null || (navigationBar = this.w) == null) {
            return;
        }
        int height = navigationBar.getHeight();
        if (!(f2 == 1.0f)) {
            this.x.setVisibility(8);
            this.y.setVisibility(8);
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.x.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.y.getLayoutParams();
        if (this.mMainView.j().getFirstCompletelyVisiblePosition() != 0) {
            this.x.setVisibility(8);
            this.y.setVisibility(0);
            if (layoutParams2.topMargin != 0) {
                layoutParams2.topMargin = 0;
                return;
            }
            return;
        }
        int height2 = height - (this.G.getHeight() + i2);
        int g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
        if (height2 > 0 && height2 < g2) {
            this.x.setVisibility(0);
            this.y.setVisibility(0);
            layoutParams.bottomMargin = -height2;
            layoutParams2.topMargin = -(g2 - height2);
        } else if (height2 > g2) {
            this.x.setVisibility(8);
            this.y.setVisibility(0);
            if (layoutParams2.topMargin != 0) {
                layoutParams2.topMargin = 0;
            }
        } else {
            if (layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
            }
            this.x.setVisibility(0);
            this.y.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.q0.o0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "a063" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int getLayoutR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? R.layout.frs_sports_recommend_fragment : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public c.a.q0.o0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.q0.o0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.r(c.a.e.e.m.b.g(this.forumId, 0L));
            }
            return pageStayDurationItem;
        }
        return (c.a.q0.o0.d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.r0.w0.j2.a aVar = this.D;
            if (aVar != null) {
                aVar.h();
            }
            c.a.r0.w0.j2.b bVar = this.E;
            if (bVar != null) {
                bVar.d();
            }
            NoNetworkView noNetworkView = this.C;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            SkinManager.setBackgroundResource(this.x, R.drawable.top_shadow);
            SkinManager.setBackgroundResource(this.y, R.drawable.top_shadow);
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.t, R.color.CAM_X0201);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.B, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.A, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            NavigationBar navigationBar = this.w;
            if (navigationBar != null) {
                SkinManager.setBackgroundColor(navigationBar.getBarBgView(), R.color.CAM_X0207);
                this.w.onChangeSkinType(getPageContext(), i2);
                if (this.w.getBackground() != null && this.w.getBackground().mutate() != null) {
                    this.w.getBackground().mutate().setAlpha(0);
                }
            }
            J();
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.N);
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, layoutInflater, viewGroup, bundle)) == null) {
            super.onCreateView(layoutInflater, viewGroup, bundle);
            this.mMainView.v(true);
            A();
            this.F = (CollapsingToolbarLayout) this.mRootView.findViewById(R.id.frs_collapse_layout);
            this.u = this.mRootView.findViewById(R.id.statebar_view);
            this.t = this.mRootView.findViewById(R.id.statebar_view_holder);
            AppBarLayout appBarLayout = (AppBarLayout) this.mRootView.findViewById(R.id.frs_app_bar_layout);
            this.G = appBarLayout;
            appBarLayout.addOnOffsetChangedListener(this.O);
            z();
            c.a.r0.w0.j2.a aVar = new c.a.r0.w0.j2.a(this, this.mRootView);
            this.D = aVar;
            aVar.j(this.viewData);
            this.E = new c.a.r0.w0.j2.b(this, this.mRootView);
            c.a.r0.w0.l1.c cVar = this.mModelController;
            if (cVar != null) {
                cVar.q(0L);
            }
            this.H = (FrameLayout) this.mRootView.findViewById(R.id.frs_sports_recommend_list_container);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.mRootView;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (!isPrimary() && this.lastResumeTime != 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
                if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                    ((FrsActivity) getFragmentActivity()).mSpecialTabPageStayTime += currentTimeMillis;
                }
            }
            super.onPrimary();
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, c.a.r0.w0.r0
    public void onPullRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            y();
            c.a.r0.w0.l1.c cVar = this.mModelController;
            if (cVar != null) {
                cVar.q(this.K);
            }
            super.onPullRefresh();
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void onViewDataChange(c.a.r0.w0.l1.d dVar) {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, dVar) == null) {
            super.onViewDataChange(dVar);
            if (dVar == null) {
                return;
            }
            c.a.r0.w0.j2.a aVar = this.D;
            if (aVar != null) {
                aVar.k(dVar.f26995i, dVar.f26996j, dVar.k);
            }
            if (this.E != null && (frsViewData = this.viewData) != null && frsViewData.getForum() != null) {
                this.E.e(dVar.l, this.viewData.getForum().getId());
            }
            c.a.r0.w0.l1.c cVar = this.mModelController;
            if (cVar != null && cVar.i()) {
                B(dVar.f26994h);
            }
            if (!ListUtils.isEmpty(dVar.f26993g)) {
                Iterator<n> it = dVar.f26993g.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n next = it.next();
                    d2 d2Var = null;
                    if (next instanceof d2) {
                        d2Var = (d2) next;
                    } else if (next instanceof c2) {
                        d2Var = ((c2) next).w;
                    }
                    if (d2Var != null && !d2Var.A2()) {
                        long g2 = c.a.e.e.m.b.g(d2Var.f0(), 0L);
                        if (g2 > 0) {
                            this.K = g2;
                            break;
                        }
                    }
                }
            }
            this.L = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view, boolean z, int i2) {
        c.a.r0.w0.l1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (bVar = this.mMainView) == null) {
            return;
        }
        bVar.w(true);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048593, this, view, str, z) == null) {
            super.showNetRefreshView(this.H, str, z);
            adjustRefreshView(0);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.G.setExpanded(true);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || this.u == null) {
            return;
        }
        if (UtilHelper.canUseStyleImmersiveSticky() && this.u.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.u.setLayoutParams(layoutParams);
            this.u.setVisibility(0);
            ImageView imageView = this.B;
            if (imageView == null || !(imageView.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                return;
            }
            ((FrameLayout.LayoutParams) ((CollapsingToolbarLayout.LayoutParams) this.B.getLayoutParams())).topMargin = layoutParams.height;
            return;
        }
        this.u.setVisibility(8);
    }
}
