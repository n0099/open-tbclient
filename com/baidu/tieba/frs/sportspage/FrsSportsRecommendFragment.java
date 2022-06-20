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
import com.repackage.af5;
import com.repackage.bq4;
import com.repackage.mn6;
import com.repackage.ng;
import com.repackage.ni;
import com.repackage.nn;
import com.repackage.nn6;
import com.repackage.pi;
import com.repackage.sf6;
import com.repackage.tf6;
import com.repackage.uf6;
import com.repackage.w75;
import com.repackage.zd6;
import java.util.Iterator;
/* loaded from: classes3.dex */
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
    public mn6 Q;
    public nn6 R;
    public CollapsingToolbarLayout S;
    public AppBarLayout T;
    public FrameLayout U;
    public zd6 V;
    public TextView W;
    public long X;
    public boolean Y;
    public int Z;
    public final View.OnClickListener g0;
    public CustomMessageListener h0;
    public AppBarLayout.OnOffsetChangedListener i0;

    /* loaded from: classes3.dex */
    public class a implements af5 {
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

        @Override // com.repackage.af5
        public void a(View view2, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || i2 == i4) {
                return;
            }
            this.a.S.setMinimumHeight(i2);
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.M != null && view2 == this.a.M) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.a.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String[] split = ((String) customResponsedMessage.getData()).split("_");
            if (split.length == 2 && "FrsSportsRecommendTab".equals(split[0]) && 25 == ng.e(split[1], 0)) {
                this.a.T.setExpanded(true, false);
                this.a.a.z(0);
                this.a.w();
            }
        }
    }

    /* loaded from: classes3.dex */
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
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i) == null) || this.a.Z == i) {
                return;
            }
            int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            int height = this.a.J.getHeight();
            int height2 = (this.a.P == null || ni.z()) ? 0 : this.a.P.getHeight();
            int f = ((pi.f(this.a.getContext(), R.dimen.tbds318) - height) - height2) - statusBarHeight;
            int i2 = statusBarHeight + height + height2 + f;
            int totalScrollRange = (appBarLayout.getTotalScrollRange() - i2) - f;
            int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
            if (totalScrollRange <= 0) {
                return;
            }
            float f2 = 1.0f;
            float abs = (Math.abs(i * 1.0f) - f) / totalScrollRange;
            if (Float.compare(abs, 1.0f) > 0) {
                abs = 1.0f;
            }
            if (Float.compare(abs, 0.05f) <= 0 && this.a.Z - i < 0) {
                abs = 0.0f;
            }
            if (f + i <= 0 || this.a.J == null || this.a.J.getBarBgView() == null || this.a.J.getBarBgView().getAlpha() != 0.0f) {
                if (Float.compare(abs, 1.0f) == 0) {
                    this.a.k2(Math.abs(i2 - totalScrollRange2));
                    if (this.a.G != null) {
                        this.a.G.setVisibility(0);
                    }
                } else if (this.a.G != null && this.a.H != null) {
                    if (this.a.H.getHeight() != UtilHelper.getStatusBarHeight()) {
                        this.a.k2(0);
                    }
                    this.a.G.setVisibility(8);
                }
                if (abs > 0.5f) {
                    UtilHelper.changeStatusBarIconAndTextColor(false, this.a.getPageContext().getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, this.a.getPageContext().getPageActivity());
                    f2 = abs;
                }
                if (this.a.J != null) {
                    this.a.J.getBarBgView().setAlpha(f2);
                    this.a.l2();
                }
                this.a.m2(i, f2);
                this.a.Z = i;
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
        this.Y = true;
        this.g0 = new b(this);
        this.h0 = new c(this, 2001446);
        this.i0 = new d(this);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public int G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0344 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment
    public void M1(uf6 uf6Var) {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uf6Var) == null) {
            super.M1(uf6Var);
            if (uf6Var == null) {
                return;
            }
            mn6 mn6Var = this.Q;
            if (mn6Var != null) {
                mn6Var.k(uf6Var.e, uf6Var.f, uf6Var.g);
            }
            if (this.R != null && (frsViewData = this.d) != null && frsViewData.getForum() != null) {
                this.R.e(uf6Var.h, this.d.getForum().getId());
            }
            tf6 tf6Var = this.b;
            if (tf6Var != null && tf6Var.j()) {
                j2(uf6Var.d);
            }
            if (!ListUtils.isEmpty(uf6Var.c)) {
                Iterator<nn> it = uf6Var.c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    nn next = it.next();
                    ThreadData threadData = null;
                    if (next instanceof ThreadData) {
                        threadData = (ThreadData) next;
                    } else if (next instanceof bq4) {
                        threadData = ((bq4) next).s;
                    }
                    if (threadData != null && !threadData.isTop()) {
                        long g = ng.g(threadData.getId(), 0L);
                        if (g > 0) {
                            this.X = g;
                            break;
                        }
                    }
                }
            }
            this.Y = false;
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.repackage.nd6
    public void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            g2();
            tf6 tf6Var = this.b;
            if (tf6Var != null) {
                tf6Var.q(this.X);
            }
            super.V0();
        }
    }

    public final void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.T.setExpanded(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.t75
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "a063" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public w75 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            w75 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.t(ng.g(this.e, 0L));
            }
            return pageStayDurationItem;
        }
        return (w75) invokeV.objValue;
    }

    public final void h2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.H == null) {
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

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
        }
    }

    public final void i2() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.J == null) {
                NavigationBar navigationBar = (NavigationBar) this.c.findViewById(R.id.obfuscated_res_0x7f09238f);
                this.J = navigationBar;
                navigationBar.getBarBgView().setAlpha(0.0f);
            }
            if (this.I == null) {
                ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0914ed);
                this.I = observedChangeLinearLayout;
                observedChangeLinearLayout.setOnSizeChangeListener(new a(this));
            }
            if (this.K == null) {
                this.K = this.c.findViewById(R.id.obfuscated_res_0x7f0914c2);
            }
            if (this.L == null) {
                this.L = this.c.findViewById(R.id.obfuscated_res_0x7f090965);
            }
            if (this.M == null) {
                View addSystemImageButton = this.J.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                this.M = addSystemImageButton;
                addSystemImageButton.setOnClickListener(this.g0);
                this.N = (ImageView) this.M.findViewById(R.id.obfuscated_res_0x7f09242f);
            }
            if (this.O == null) {
                this.O = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0914c4);
            }
            if (this.P == null) {
                this.P = new NoNetworkView(getContext());
                this.P.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.I.addView(this.P);
            }
            if (ni.A()) {
                this.P.setVisibility(8);
            } else {
                this.P.setVisibility(0);
            }
            if (this.J == null || (frsViewData = this.d) == null || frsViewData.getForum() == null) {
                return;
            }
            String name = this.d.getForum().getName();
            if (StringHelper.getChineseAndEnglishLength(name) > 14) {
                name = StringHelper.cutForumNameWithSuffix(name, 14, StringHelper.STRING_MORE);
            }
            this.J.setCenterTextTitle(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0738), name));
        }
    }

    public final void j2(int i) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            if (this.W == null) {
                TextView textView = new TextView(getContext());
                this.W = textView;
                textView.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b5));
                this.W.setGravity(17);
            }
            if (this.W != null) {
                if (this.Y) {
                    if (i <= 0) {
                        return;
                    }
                    string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0739);
                } else if (i > 0) {
                    string = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f073a), Integer.valueOf(i));
                } else {
                    string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f073b);
                }
                this.W.setText(string);
            }
            SkinManager.setBackgroundResource(this.W, R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.W, (int) R.color.CAM_X0112);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702e0));
            if (this.V == null) {
                this.V = new zd6();
            }
            this.V.h(this.W, this.U, layoutParams, 2000);
        }
    }

    public final void k2(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i) == null) || !UtilHelper.canUseStyleImmersiveSticky() || (view2 = this.H) == null || this.G == null || view2.getLayoutParams() == null || this.G.getLayoutParams() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.H.getLayoutParams();
        int statusBarHeight = UtilHelper.getStatusBarHeight() - i;
        layoutParams.height = statusBarHeight;
        if (statusBarHeight < 0) {
            layoutParams.height = 0;
        }
        this.H.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.G.getLayoutParams();
        layoutParams2.height = i;
        if (i > UtilHelper.getStatusBarHeight()) {
            layoutParams2.height = UtilHelper.getStatusBarHeight();
        }
        this.G.setLayoutParams(layoutParams2);
    }

    public final void l2() {
        NavigationBar navigationBar;
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (navigationBar = this.J) == null) {
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
        View view2 = this.H;
        if (view2 != null) {
            view2.setAlpha(alpha);
        }
        View view3 = this.G;
        if (view3 != null) {
            view3.setAlpha(alpha);
        }
    }

    public final void m2(int i, float f) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) || this.K == null || this.L == null || (navigationBar = this.J) == null) {
            return;
        }
        int height = navigationBar.getHeight();
        if (!(f == 1.0f)) {
            this.K.setVisibility(8);
            this.L.setVisibility(8);
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.K.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.L.getLayoutParams();
        if (this.a.j().getFirstCompletelyVisiblePosition() != 0) {
            this.K.setVisibility(8);
            this.L.setVisibility(0);
            if (layoutParams2.topMargin != 0) {
                layoutParams2.topMargin = 0;
                return;
            }
            return;
        }
        int height2 = height - (this.T.getHeight() + i);
        int f2 = pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds16);
        if (height2 > 0 && height2 < f2) {
            this.K.setVisibility(0);
            this.L.setVisibility(0);
            layoutParams.bottomMargin = -height2;
            layoutParams2.topMargin = -(f2 - height2);
        } else if (height2 > f2) {
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

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            super.onChangeSkinType(i);
            mn6 mn6Var = this.Q;
            if (mn6Var != null) {
                mn6Var.h();
            }
            nn6 nn6Var = this.R;
            if (nn6Var != null) {
                nn6Var.d();
            }
            NoNetworkView noNetworkView = this.P;
            if (noNetworkView != null) {
                noNetworkView.d(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            SkinManager.setBackgroundResource(this.K, R.drawable.obfuscated_res_0x7f081202);
            SkinManager.setBackgroundResource(this.L, R.drawable.obfuscated_res_0x7f081202);
            SkinManager.setBackgroundColor(this.H, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.G, R.color.CAM_X0201);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.O, R.drawable.obfuscated_res_0x7f08060d, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.N, R.drawable.obfuscated_res_0x7f08060d, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            NavigationBar navigationBar = this.J;
            if (navigationBar != null) {
                SkinManager.setBackgroundColor(navigationBar.getBarBgView(), R.color.CAM_X0207);
                this.J.onChangeSkinType(getPageContext(), i);
                if (this.J.getBackground() != null && this.J.getBackground().mutate() != null) {
                    this.J.getBackground().mutate().setAlpha(0);
                }
            }
            l2();
        }
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.h0);
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
            i2();
            this.S = (CollapsingToolbarLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090ab7);
            this.H = this.c.findViewById(R.id.obfuscated_res_0x7f091d8e);
            this.G = this.c.findViewById(R.id.obfuscated_res_0x7f091d8f);
            AppBarLayout appBarLayout = (AppBarLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090a9b);
            this.T = appBarLayout;
            appBarLayout.addOnOffsetChangedListener(this.i0);
            h2();
            mn6 mn6Var = new mn6(this, this.c);
            this.Q = mn6Var;
            mn6Var.j(this.d);
            this.R = new nn6(this, this.c);
            tf6 tf6Var = this.b;
            if (tf6Var != null) {
                tf6Var.q(0L);
            }
            this.U = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090b9c);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.c;
        }
        return (View) invokeLLL.objValue;
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

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2, boolean z, int i) {
        sf6 sf6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || (sf6Var = this.a) == null) {
            return;
        }
        sf6Var.x(true);
    }

    @Override // com.baidu.tieba.frs.commontab.FrsCommonTabFragment, com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048595, this, view2, str, z) == null) {
            super.showNetRefreshView(this.U, str, z);
            C1(0);
        }
    }
}
