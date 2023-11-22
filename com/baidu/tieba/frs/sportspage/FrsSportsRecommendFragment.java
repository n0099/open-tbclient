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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.pageStayDuration.PageStayDurationItem;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.at7;
import com.baidu.tieba.bt7;
import com.baidu.tieba.ct7;
import com.baidu.tieba.cx5;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.hz4;
import com.baidu.tieba.oi;
import com.baidu.tieba.pr7;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.x08;
import com.baidu.tieba.y08;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.math.BigDecimal;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class FrsSportsRecommendFragment extends FrsCommonTabFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View H;
    public View I;
    public ObservedChangeLinearLayout J;
    public NavigationBar K;
    public View L;
    public View M;
    public View N;
    public ImageView O;
    public ImageView P;
    public NoNetworkView Q;
    public x08 R;
    public y08 S;

    /* renamed from: T  reason: collision with root package name */
    public CollapsingToolbarLayout f1099T;
    public AppBarLayout U;
    public FrameLayout V;
    public pr7 W;
    public TextView X;
    public long Y;
    public boolean Z;
    public int a0;
    public final View.OnClickListener b0;
    public CustomMessageListener c0;
    public AppBarLayout.OnOffsetChangedListener d0;

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int K2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d03bb : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "a063" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements cx5 {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsSportsRecommendFragment;
        }

        @Override // com.baidu.tieba.cx5
        public void a(View view2, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && i2 != i4) {
                this.a.f1099T.setMinimumHeight(i2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsSportsRecommendFragment a;

        public b(FrsSportsRecommendFragment frsSportsRecommendFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSportsRecommendFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsSportsRecommendFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.N != null && view2 == this.a.N) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.a.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsSportsRecommendFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(FrsSportsRecommendFragment frsSportsRecommendFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSportsRecommendFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == JavaTypesHelper.toInt(split[1], 0)) {
                    this.a.U.setExpanded(true, false);
                    this.a.a.z(0);
                    this.a.i();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsSportsRecommendFragment;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i) == null) && this.a.a0 != i) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    i2 = UtilHelper.getStatusBarHeight();
                } else {
                    i2 = 0;
                }
                int height = this.a.K.getHeight();
                if (this.a.Q != null && !BdNetTypeUtil.isNetWorkAvailable()) {
                    i3 = this.a.Q.getHeight();
                } else {
                    i3 = 0;
                }
                int dimens = ((BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds318) - height) - i3) - i2;
                int i4 = i2 + height + i3 + dimens;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i4) - dimens;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange <= 0) {
                    return;
                }
                float f = 1.0f;
                float abs = (Math.abs(i * 1.0f) - dimens) / totalScrollRange;
                if (Float.compare(abs, 1.0f) > 0) {
                    abs = 1.0f;
                }
                if (Float.compare(abs, 0.05f) <= 0 && this.a.a0 - i < 0) {
                    abs = 0.0f;
                }
                if (dimens + i > 0 && this.a.K != null && this.a.K.getBarBgView() != null && this.a.K.getBarBgView().getAlpha() == 0.0f) {
                    return;
                }
                if (Float.compare(abs, 1.0f) != 0) {
                    if (this.a.H != null && this.a.I != null) {
                        if (this.a.I.getHeight() != UtilHelper.getStatusBarHeight()) {
                            this.a.l3(0);
                        }
                        this.a.H.setVisibility(8);
                    }
                } else {
                    this.a.l3(Math.abs(i4 - totalScrollRange2));
                    if (this.a.H != null) {
                        this.a.H.setVisibility(0);
                    }
                }
                if (abs > 0.5f) {
                    UtilHelper.changeStatusBarIconAndTextColor(false, this.a.getPageContext().getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, this.a.getPageContext().getPageActivity());
                    f = abs;
                }
                if (this.a.K != null) {
                    this.a.K.getBarBgView().setAlpha(f);
                    this.a.m3();
                }
                this.a.n3(i, f);
                this.a.a0 = i;
                this.a.F2(i);
            }
        }
    }

    public FrsSportsRecommendFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.Z = true;
        this.b0 = new b(this);
        this.c0 = new c(this, 2001446);
        this.d0 = new d(this);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (isPrimary() && this.lastResumeTime != 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
                if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                    ((FrsActivity) getFragmentActivity()).i += currentTimeMillis;
                }
            }
            super.onPause();
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (!isPrimary() && this.lastResumeTime != 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
                if (currentTimeMillis >= 0 && (getFragmentActivity() instanceof FrsActivity)) {
                    ((FrsActivity) getFragmentActivity()).i += currentTimeMillis;
                }
            }
            super.onPrimary();
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.c0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2, boolean z, int i) {
        at7 at7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (at7Var = this.a) != null) {
            at7Var.x(true);
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048595, this, view2, str, z) == null) {
            super.showNetRefreshView(this.V, str, z);
            F2(0);
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tieba.ar7
    public void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h3();
            bt7 bt7Var = this.b;
            if (bt7Var != null) {
                bt7Var.q(this.Y);
            }
            super.O1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public PageStayDurationItem getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PageStayDurationItem pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.setFid(JavaTypesHelper.toLong(this.e, 0L));
            }
            return pageStayDurationItem;
        }
        return (PageStayDurationItem) invokeV.objValue;
    }

    public final void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.U.setExpanded(true);
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void P2(ct7 ct7Var) {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ct7Var) == null) {
            super.P2(ct7Var);
            if (ct7Var == null) {
                return;
            }
            x08 x08Var = this.R;
            if (x08Var != null) {
                x08Var.k(ct7Var.e, ct7Var.f, ct7Var.g);
            }
            if (this.S != null && (frsViewData = this.d) != null && frsViewData.getForum() != null) {
                this.S.e(ct7Var.h, this.d.getForum().getId());
            }
            bt7 bt7Var = this.b;
            if (bt7Var != null && bt7Var.k()) {
                k3(ct7Var.d);
            }
            if (!ListUtils.isEmpty(ct7Var.c)) {
                Iterator<oi> it = ct7Var.c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    oi next = it.next();
                    ThreadData threadData = null;
                    if (next instanceof ThreadData) {
                        threadData = (ThreadData) next;
                    } else if (next instanceof hz4) {
                        threadData = ((hz4) next).t;
                    }
                    if (threadData != null && !threadData.isTop()) {
                        long j = JavaTypesHelper.toLong(threadData.getId(), 0L);
                        if (j > 0) {
                            this.Y = j;
                            break;
                        }
                    }
                }
            }
            this.Z = false;
        }
    }

    public final void k3(int i) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            if (this.X == null) {
                TextView textView = new TextView(getContext());
                this.X = textView;
                textView.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b5));
                this.X.setGravity(17);
            }
            if (this.X != null) {
                if (this.Z) {
                    if (i > 0) {
                        string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f088a);
                    } else {
                        return;
                    }
                } else if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f088b), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f088c);
                }
                this.X.setText(string);
            }
            SkinManager.setBackgroundResource(this.X, R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.X, (int) R.color.CAM_X0112);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703f7));
            if (this.W == null) {
                this.W = new pr7();
            }
            this.W.h(this.X, this.V, layoutParams, 2000);
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            super.onChangeSkinType(i);
            x08 x08Var = this.R;
            if (x08Var != null) {
                x08Var.h();
            }
            y08 y08Var = this.S;
            if (y08Var != null) {
                y08Var.d();
            }
            NoNetworkView noNetworkView = this.Q;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            SkinManager.setBackgroundResource(this.L, R.drawable.top_shadow);
            SkinManager.setBackgroundResource(this.M, R.drawable.top_shadow);
            SkinManager.setBackgroundColor(this.I, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.H, R.color.CAM_X0201);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.P, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.O, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            NavigationBar navigationBar = this.K;
            if (navigationBar != null) {
                SkinManager.setBackgroundColor(navigationBar.getBarBgView(), R.color.CAM_X0207);
                this.K.onChangeSkinType(getPageContext(), i);
                if (this.K.getBackground() != null && this.K.getBackground().mutate() != null) {
                    this.K.getBackground().mutate().setAlpha(0);
                }
            }
            m3();
        }
    }

    public final void i3() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || this.I == null) {
            return;
        }
        if (UtilHelper.canUseStyleImmersiveSticky() && this.I.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.I.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.I.setLayoutParams(layoutParams);
            this.I.setVisibility(0);
            ImageView imageView = this.P;
            if (imageView != null && (imageView.getLayoutParams() instanceof CollapsingToolbarLayout.LayoutParams)) {
                ((FrameLayout.LayoutParams) ((CollapsingToolbarLayout.LayoutParams) this.P.getLayoutParams())).topMargin = layoutParams.height;
                return;
            }
            return;
        }
        this.I.setVisibility(8);
    }

    public final void m3() {
        NavigationBar navigationBar;
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || (navigationBar = this.K) == null) {
            return;
        }
        float f = 0.0f;
        if (navigationBar.getBarBgView() != null) {
            f = this.K.getBarBgView().getAlpha();
        }
        TextView textView = this.K.mCenterText;
        if (textView != null) {
            textView.setAlpha(f);
        }
        if (this.O != null && (imageView = this.P) != null) {
            imageView.setAlpha(1.0f - f);
            this.O.setAlpha(f);
        }
        View view2 = this.I;
        if (view2 != null) {
            view2.setAlpha(f);
        }
        View view3 = this.H;
        if (view3 != null) {
            view3.setAlpha(f);
        }
    }

    public final void j3() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.K == null) {
                NavigationBar navigationBar = (NavigationBar) this.c.findViewById(R.id.view_navigation_bar);
                this.K = navigationBar;
                navigationBar.getBarBgView().setAlpha(0.0f);
            }
            if (this.J == null) {
                ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091974);
                this.J = observedChangeLinearLayout;
                observedChangeLinearLayout.setOnSizeChangeListener(new a(this));
            }
            if (this.L == null) {
                this.L = this.c.findViewById(R.id.obfuscated_res_0x7f09193d);
            }
            if (this.M == null) {
                this.M = this.c.findViewById(R.id.obfuscated_res_0x7f090b39);
            }
            if (this.N == null) {
                View addSystemImageButton = this.K.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                this.N = addSystemImageButton;
                addSystemImageButton.setOnClickListener(this.b0);
                this.O = (ImageView) this.N.findViewById(R.id.widget_navi_back_button);
            }
            if (this.P == null) {
                this.P = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09193f);
            }
            if (this.Q == null) {
                this.Q = new NoNetworkView(getContext());
                this.Q.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.J.addView(this.Q);
            }
            if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                this.Q.setVisibility(8);
            } else {
                this.Q.setVisibility(0);
            }
            if (this.K != null && (frsViewData = this.d) != null && frsViewData.getForum() != null) {
                String name = this.d.getForum().getName();
                if (StringHelper.getChineseAndEnglishLength(name) > 14) {
                    name = StringHelper.cutForumNameWithSuffix(name, 14, "...");
                }
                this.K.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0889), name));
            }
        }
    }

    public final void l3(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && UtilHelper.canUseStyleImmersiveSticky() && (view2 = this.I) != null && this.H != null && view2.getLayoutParams() != null && this.H.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.I.getLayoutParams();
            int statusBarHeight = UtilHelper.getStatusBarHeight() - i;
            layoutParams.height = statusBarHeight;
            if (statusBarHeight < 0) {
                layoutParams.height = 0;
            }
            this.I.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.H.getLayoutParams();
            layoutParams2.height = i;
            if (i > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            this.H.setLayoutParams(layoutParams2);
        }
    }

    public final void n3(int i, float f) {
        NavigationBar navigationBar;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) && this.L != null && this.M != null && (navigationBar = this.K) != null) {
            int height = navigationBar.getHeight();
            if (new BigDecimal(f).compareTo(BigDecimal.ONE) == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                this.L.setVisibility(8);
                this.M.setVisibility(8);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.L.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.M.getLayoutParams();
            if (this.a.j().getFirstCompletelyVisiblePosition() != 0) {
                this.L.setVisibility(8);
                this.M.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                    return;
                }
                return;
            }
            int height2 = height - (this.U.getHeight() + i);
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < dimens) {
                this.L.setVisibility(0);
                this.M.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(dimens - height2);
            } else if (height2 > dimens) {
                this.L.setVisibility(8);
                this.M.setVisibility(0);
                if (layoutParams2.topMargin != 0) {
                    layoutParams2.topMargin = 0;
                }
            } else {
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                }
                this.L.setVisibility(0);
                this.M.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, layoutInflater, viewGroup, bundle)) == null) {
            super.onCreateView(layoutInflater, viewGroup, bundle);
            this.a.w(true);
            j3();
            this.f1099T = (CollapsingToolbarLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090cc5);
            this.I = this.c.findViewById(R.id.obfuscated_res_0x7f092344);
            this.H = this.c.findViewById(R.id.obfuscated_res_0x7f092345);
            AppBarLayout appBarLayout = (AppBarLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090ca1);
            this.U = appBarLayout;
            appBarLayout.addOnOffsetChangedListener(this.d0);
            i3();
            x08 x08Var = new x08(this, this.c);
            this.R = x08Var;
            x08Var.j(this.d);
            this.S = new y08(this, this.c);
            bt7 bt7Var = this.b;
            if (bt7Var != null) {
                bt7Var.q(0L);
            }
            this.V = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090db4);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }
}
