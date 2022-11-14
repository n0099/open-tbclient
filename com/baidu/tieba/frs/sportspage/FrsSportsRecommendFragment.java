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
import com.baidu.adp.lib.util.BdNetTypeUtil;
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
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.cl6;
import com.baidu.tieba.fe5;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.im6;
import com.baidu.tieba.jm6;
import com.baidu.tieba.km6;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tl5;
import com.baidu.tieba.wu4;
import com.baidu.tieba.xg;
import com.baidu.tieba.xn;
import com.baidu.tieba.yi;
import com.baidu.tieba.yt6;
import com.baidu.tieba.zt6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.math.BigDecimal;
import java.util.Iterator;
/* loaded from: classes4.dex */
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
    public yt6 R;
    public zt6 S;
    public CollapsingToolbarLayout T;
    public AppBarLayout U;
    public FrameLayout V;
    public cl6 W;
    public TextView X;
    public long Y;
    public boolean Z;
    public int a0;
    public final View.OnClickListener b0;
    public CustomMessageListener c0;
    public AppBarLayout.OnOffsetChangedListener d0;

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0350 : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.ce5
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

    /* loaded from: classes4.dex */
    public class a implements tl5 {
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

        @Override // com.baidu.tieba.tl5
        public void a(View view2, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && i2 != i4) {
                this.a.T.setMinimumHeight(i2);
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
                if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == xg.e(split[1], 0)) {
                    this.a.U.setExpanded(true, false);
                    this.a.a.z(0);
                    this.a.x();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                int g = ((yi.g(this.a.getContext(), R.dimen.tbds318) - height) - i3) - i2;
                int i4 = i2 + height + i3 + g;
                int totalScrollRange = (appBarLayout.getTotalScrollRange() - i4) - g;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange <= 0) {
                    return;
                }
                float f = 1.0f;
                float abs = (Math.abs(i * 1.0f) - g) / totalScrollRange;
                if (Float.compare(abs, 1.0f) > 0) {
                    abs = 1.0f;
                }
                if (Float.compare(abs, 0.05f) <= 0 && this.a.a0 - i < 0) {
                    abs = 0.0f;
                }
                if (g + i > 0 && this.a.K != null && this.a.K.getBarBgView() != null && this.a.K.getBarBgView().getAlpha() == 0.0f) {
                    return;
                }
                if (Float.compare(abs, 1.0f) != 0) {
                    if (this.a.H != null && this.a.I != null) {
                        if (this.a.I.getHeight() != UtilHelper.getStatusBarHeight()) {
                            this.a.l2(0);
                        }
                        this.a.H.setVisibility(8);
                    }
                } else {
                    this.a.l2(Math.abs(i4 - totalScrollRange2));
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
                    this.a.m2();
                }
                this.a.n2(i, f);
                this.a.a0 = i;
                this.a.C1(i);
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
                    ((FrsActivity) getFragmentActivity()).j += currentTimeMillis;
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
                    ((FrsActivity) getFragmentActivity()).j += currentTimeMillis;
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
        im6 im6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (im6Var = this.a) != null) {
            im6Var.x(true);
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048595, this, view2, str, z) == null) {
            super.showNetRefreshView(this.V, str, z);
            C1(0);
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void N1(km6 km6Var) {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, km6Var) == null) {
            super.N1(km6Var);
            if (km6Var == null) {
                return;
            }
            yt6 yt6Var = this.R;
            if (yt6Var != null) {
                yt6Var.k(km6Var.e, km6Var.f, km6Var.g);
            }
            if (this.S != null && (frsViewData = this.d) != null && frsViewData.getForum() != null) {
                this.S.e(km6Var.h, this.d.getForum().getId());
            }
            jm6 jm6Var = this.b;
            if (jm6Var != null && jm6Var.j()) {
                k2(km6Var.d);
            }
            if (!ListUtils.isEmpty(km6Var.c)) {
                Iterator<xn> it = km6Var.c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    xn next = it.next();
                    ThreadData threadData = null;
                    if (next instanceof ThreadData) {
                        threadData = (ThreadData) next;
                    } else if (next instanceof wu4) {
                        threadData = ((wu4) next).t;
                    }
                    if (threadData != null && !threadData.isTop()) {
                        long g = xg.g(threadData.getId(), 0L);
                        if (g > 0) {
                            this.Y = g;
                            break;
                        }
                    }
                }
            }
            this.Z = false;
        }
    }

    public final void k2(int i) {
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
                        string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0772);
                    } else {
                        return;
                    }
                } else if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0773), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0774);
                }
                this.X.setText(string);
            }
            SkinManager.setBackgroundResource(this.X, R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.X, (int) R.color.CAM_X0112);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702dd));
            if (this.W == null) {
                this.W = new cl6();
            }
            this.W.h(this.X, this.V, layoutParams, 2000);
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            super.onChangeSkinType(i);
            yt6 yt6Var = this.R;
            if (yt6Var != null) {
                yt6Var.h();
            }
            zt6 zt6Var = this.S;
            if (zt6Var != null) {
                zt6Var.d();
            }
            NoNetworkView noNetworkView = this.Q;
            if (noNetworkView != null) {
                noNetworkView.d(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            SkinManager.setBackgroundResource(this.L, R.drawable.obfuscated_res_0x7f08125c);
            SkinManager.setBackgroundResource(this.M, R.drawable.obfuscated_res_0x7f08125c);
            SkinManager.setBackgroundColor(this.I, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.H, R.color.CAM_X0201);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.P, R.drawable.obfuscated_res_0x7f08062e, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.O, R.drawable.obfuscated_res_0x7f08062e, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            NavigationBar navigationBar = this.K;
            if (navigationBar != null) {
                SkinManager.setBackgroundColor(navigationBar.getBarBgView(), R.color.CAM_X0207);
                this.K.onChangeSkinType(getPageContext(), i);
                if (this.K.getBackground() != null && this.K.getBackground().mutate() != null) {
                    this.K.getBackground().mutate().setAlpha(0);
                }
            }
            m2();
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tieba.pk6
    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            h2();
            jm6 jm6Var = this.b;
            if (jm6Var != null) {
                jm6Var.q(this.Y);
            }
            super.U0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public fe5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            fe5 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.t(xg.g(this.e, 0L));
            }
            return pageStayDurationItem;
        }
        return (fe5) invokeV.objValue;
    }

    public final void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.U.setExpanded(true);
        }
    }

    public final void i2() {
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

    public final void m2() {
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

    public final void j2() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.K == null) {
                NavigationBar navigationBar = (NavigationBar) this.c.findViewById(R.id.obfuscated_res_0x7f092613);
                this.K = navigationBar;
                navigationBar.getBarBgView().setAlpha(0.0f);
            }
            if (this.J == null) {
                ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091699);
                this.J = observedChangeLinearLayout;
                observedChangeLinearLayout.setOnSizeChangeListener(new a(this));
            }
            if (this.L == null) {
                this.L = this.c.findViewById(R.id.obfuscated_res_0x7f091665);
            }
            if (this.M == null) {
                this.M = this.c.findViewById(R.id.obfuscated_res_0x7f0909ce);
            }
            if (this.N == null) {
                View addSystemImageButton = this.K.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                this.N = addSystemImageButton;
                addSystemImageButton.setOnClickListener(this.b0);
                this.O = (ImageView) this.N.findViewById(R.id.obfuscated_res_0x7f0926cf);
            }
            if (this.P == null) {
                this.P = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091667);
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
                    name = StringHelper.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
                }
                this.K.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0771), name));
            }
        }
    }

    public final void l2(int i) {
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

    public final void n2(int i, float f) {
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
            int g = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
            if (height2 > 0 && height2 < g) {
                this.L.setVisibility(0);
                this.M.setVisibility(0);
                layoutParams.bottomMargin = -height2;
                layoutParams2.topMargin = -(g - height2);
            } else if (height2 > g) {
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
            j2();
            this.T = (CollapsingToolbarLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090b2a);
            this.I = this.c.findViewById(R.id.obfuscated_res_0x7f091fd7);
            this.H = this.c.findViewById(R.id.obfuscated_res_0x7f091fd8);
            AppBarLayout appBarLayout = (AppBarLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090b0f);
            this.U = appBarLayout;
            appBarLayout.addOnOffsetChangedListener(this.d0);
            i2();
            yt6 yt6Var = new yt6(this, this.c);
            this.R = yt6Var;
            yt6Var.j(this.d);
            this.S = new zt6(this, this.c);
            jm6 jm6Var = this.b;
            if (jm6Var != null) {
                jm6Var.q(0L);
            }
            this.V = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090c11);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }
}
