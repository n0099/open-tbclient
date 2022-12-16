package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.design.behavior.AppBarLayoutStickyBehavior;
import com.baidu.adp.widget.design.behavior.ExposeTagViewCoordinatorLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.frs.FrsAllThreadFragment;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.frs.view.FrsMoveAreaBottomMenuView;
import com.baidu.tieba.frs.view.FrsMultiDelBottomMenuView;
import com.baidu.tieba.nq5;
import com.baidu.tieba.nv4;
import com.baidu.tieba.qf;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.CommonTipView;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes4.dex */
public class ik6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar A;
    @NonNull
    public final lu6 B;
    public View C;
    public View D;
    public FrameLayout E;
    public boolean F;
    public boolean G;
    public int H;
    public boolean I;
    public CommonTipView J;
    public sw6 K;
    public uo6 L;
    public bx6 M;
    public GifView N;
    public TbImageView O;
    public HashSet<String> P;
    public of8 Q;
    public int R;
    public int S;
    public View T;
    public View U;
    public ObservedChangeLinearLayout V;
    public boolean W;
    public so6 X;
    public boolean Y;
    public s09 Z;
    public FrsFragment a;
    public AppBarLayout a0;
    public NoPressedRelativeLayout b;
    public AppBarLayoutStickyBehavior b0;
    public CoordinatorLayout c;
    public FrsHeaderViewContainer c0;
    public View d;
    public CollapsingToolbarLayout d0;
    public View e;
    public boolean e0;
    public ImageView f;
    public int f0;
    public ImageView g;
    public int g0;
    public MessageRedDotView h;
    public int h0;
    public w66 i;
    public ww6 i0;
    public ImageView j;
    public FrsMultiDelBottomMenuView j0;
    public ImageView k;
    public FrsMoveAreaBottomMenuView k0;
    public TextView l;
    public NavigationBarCoverTip l0;
    public ViewStub m;
    public TextView m0;
    public FrameLayout n;
    public TextView n0;
    public TbImageView o;
    public int o0;
    public TbImageView p;
    public int p0;
    public ExposeTagViewCoordinatorLayout q;
    public boolean q0;
    public FrsTabViewPager r;
    public vn r0;
    public PbListView s;
    public y69 s0;
    public BdTypeRecyclerView t;
    public CustomMessageListener t0;
    public ro6 u;
    public AppBarLayout.OnOffsetChangedListener u0;
    public zw6 v;
    public Runnable v0;
    public nv4 w;
    public boolean w0;
    public View.OnClickListener x;
    public NoNetworkView.b y;
    public NoNetworkView z;

    /* loaded from: classes4.dex */
    public class a implements nv4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik6 a;

        public a(ik6 ik6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ik6Var;
        }

        @Override // com.baidu.tieba.nv4.c
        public void a(nv4 nv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nv4Var, i, view2) == null) {
                nv4Var.e();
                if (i == 0) {
                    this.a.a.d5();
                } else if (i == 1 && this.a.a.getPageContext() != null) {
                    SelectImageHelper.getAlbumImage(this.a.a.getPageContext().getPageActivity());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik6 a;

        public b(ik6 ik6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ik6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.m == null) {
                return;
            }
            this.a.n.setVisibility(0);
            this.a.p.setVisibility(0);
            this.a.o.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements of {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik6 a;

        @Override // com.baidu.tieba.of
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 4;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.of
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 16;
            }
            return invokeV.intValue;
        }

        public c(ik6 ik6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ik6Var;
        }

        @Override // com.baidu.tieba.of
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0922d1)).setText(R.string.obfuscated_res_0x7f0f078f);
                this.a.a.getPageContext().getLayoutMode().k(inflate);
                return inflate;
            }
            return (View) invokeL.objValue;
        }

        @Override // com.baidu.tieba.of
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return yi.g(this.a.a.getActivity(), R.dimen.obfuscated_res_0x7f070230);
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.of
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return -yi.g(this.a.a.getActivity(), R.dimen.obfuscated_res_0x7f0702e6);
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements qf.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.qf.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public d(ik6 ik6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.qf.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ry4.l().y("frs_video_activity_guide", 1L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pf a;

        public e(ik6 ik6Var, pf pfVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik6Var, pfVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pfVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            pf pfVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (pfVar = this.a) != null) {
                pfVar.d();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik6 a;

        public f(ik6 ik6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ik6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.Y().notifyDataSetChanged();
                if (!this.a.q0) {
                    this.a.Q.n(this.a.R, this.a.S, this.a.I, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ik6 ik6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik6Var, Integer.valueOf(i)};
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
            this.a = ik6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.a.r0 == null) {
                        this.a.r0 = new vn(new tn());
                    }
                    this.a.r0.q(this.a.t, 2);
                } else if (this.a.r0 != null) {
                    this.a.r0.w();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik6 a;

        public h(ik6 ik6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ik6Var;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLI(1048576, this, appBarLayout, i) != null) {
                return;
            }
            this.a.O(appBarLayout, i);
            if (this.a.v != null && this.a.q.hasTargetView()) {
                zw6 zw6Var = this.a.v;
                if (i == 0 && !this.a.q.canDrag()) {
                    z = true;
                } else {
                    z = false;
                }
                zw6Var.s(z);
            }
            if (!this.a.G0() && this.a.s0 != null) {
                this.a.s0.g();
            }
            if (this.a.g0 != i && Math.abs(i) >= 0 && this.a.V() != -1) {
                if (Math.abs(i) >= this.a.V()) {
                    if (this.a.e0) {
                        this.a.e0 = false;
                        ik6 ik6Var = this.a;
                        ik6Var.Q0(ik6Var.e0);
                    }
                } else if (!this.a.e0) {
                    this.a.e0 = true;
                    ik6 ik6Var2 = this.a;
                    ik6Var2.Q0(ik6Var2.e0);
                }
                int b0 = this.a.b0() + this.a.j0() + this.a.l0();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
                int totalScrollRange2 = (appBarLayout.getTotalScrollRange() - b0) + this.a.B.g();
                int g = totalScrollRange + this.a.B.g();
                if (totalScrollRange2 <= 0) {
                    return;
                }
                float abs = Math.abs(i * 1.0f) / totalScrollRange2;
                if (Float.compare(abs, 1.0f) > 0) {
                    abs = 1.0f;
                }
                if (Float.compare(abs, 0.05f) <= 0 && this.a.g0 - i < 0) {
                    abs = 0.0f;
                }
                if (Float.compare(abs, 1.0f) != 0) {
                    if (this.a.U != null) {
                        if (this.a.r0() != UtilHelper.getStatusBarHeight()) {
                            this.a.Y1(0);
                        }
                        this.a.U.setVisibility(8);
                    }
                } else {
                    this.a.Y1(Math.abs(b0 - g));
                    if (this.a.U != null) {
                        this.a.U.setVisibility(0);
                    }
                }
                if (this.a.A != null) {
                    if (this.a.W) {
                        this.a.A.getBarBgView().setAlpha(abs);
                        this.a.b2(false);
                        this.a.B.c(abs);
                    } else if (this.a.n0 != null) {
                        this.a.n0.setAlpha(abs);
                    }
                }
                this.a.g0 = i;
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921397, Integer.valueOf(i));
                CustomMessage customMessage = new CustomMessage(2921397);
                if (this.a.a != null && this.a.a.G3() != null && this.a.a.G3().B() != null && (this.a.a.G3().B().b instanceof BaseFragment)) {
                    customMessage.setTag(((BaseFragment) this.a.a.G3().B().b).getUniqueId());
                    customResponsedMessage.setOrginalMessage(customMessage);
                }
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
            if (this.a.v != null && this.a.v.k() > 0 && Math.abs(i) >= this.a.v.k()) {
                this.a.v.x();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements pm5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik6 a;

        public i(ik6 ik6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ik6Var;
        }

        @Override // com.baidu.tieba.pm5
        public void a(View view2, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && i2 != i4 && i4 > 0) {
                this.a.d0.setMinimumHeight(i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends DefaultItemAnimator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ ik6 b;

        public j(ik6 ik6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ik6Var;
            this.a = 0;
        }

        @Override // androidx.recyclerview.widget.SimpleItemAnimator
        public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                super.onRemoveFinished(viewHolder);
                int i = this.a - 1;
                this.a = i;
                if (i == 0) {
                    this.b.t.getAdapter().notifyDataSetChanged();
                }
            }
        }

        @Override // androidx.recyclerview.widget.SimpleItemAnimator
        public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewHolder) == null) {
                this.a++;
                super.onRemoveStarting(viewHolder);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(ik6 ik6Var, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik6Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, recycler, state) == null) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik6 a;

        public l(ik6 ik6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ik6Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view2 = viewHolder.itemView;
                if (this.a.Q != null) {
                    this.a.Q.k(view2);
                }
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(R.id.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.k();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(R.id.abstract_img_layout);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.p();
                }
                if (view2 instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view2).reset();
                }
                if (this.a.s0 != null) {
                    this.a.s0.e(view2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik6 a;

        public m(ik6 ik6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ik6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.L3();
                if (this.a.a != null && this.a.a0 != null) {
                    this.a.a.r4();
                    this.a.a0.setExpanded(true);
                    if (this.a.Q != null) {
                        this.a.Q.n(this.a.R, this.a.S, false, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements ExposeTagViewCoordinatorLayout.NestedScrollAcceptedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik6 a;

        public n(ik6 ik6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ik6Var;
        }

        @Override // com.baidu.adp.widget.design.behavior.ExposeTagViewCoordinatorLayout.NestedScrollAcceptedListener
        public void onNestedScrollAccepted(boolean z) {
            boolean z2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.v != null && this.a.q.hasTargetView()) {
                zw6 zw6Var = this.a.v;
                if (this.a.g0 == 0 && !this.a.q.canDrag()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zw6Var.s(z2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik6 a;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        public o(ik6 ik6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ik6Var;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && this.a.v != null && this.a.q.hasTargetView()) {
                this.a.v.s(false);
                this.a.q.clearTargetView();
            }
        }
    }

    public ik6(FrsFragment frsFragment, View.OnClickListener onClickListener, so6 so6Var, boolean z, ww6 ww6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, onClickListener, so6Var, Boolean.valueOf(z), ww6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.B = ku6.a();
        this.F = true;
        this.G = true;
        this.H = 0;
        this.I = false;
        this.R = 0;
        this.S = 0;
        this.T = null;
        this.U = null;
        this.W = false;
        this.Y = true;
        this.e0 = true;
        this.f0 = -1;
        this.g0 = -1;
        this.o0 = 0;
        this.p0 = 0;
        this.q0 = false;
        this.t0 = new g(this, 2156674);
        this.u0 = new h(this);
        this.v0 = new b(this);
        this.a = frsFragment;
        this.x = onClickListener;
        MessageManager.getInstance().registerListener(this.t0);
        E0(so6Var, z);
        this.P = new HashSet<>();
        this.H = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.h0 = TbadkCoreApplication.getInst().getSkinType();
        this.i0 = ww6Var;
    }

    public void A0(yr4 yr4Var) {
        zw6 zw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, yr4Var) == null) && (zw6Var = this.v) != null) {
            zw6Var.f(yr4Var);
        }
    }

    public void A1(boolean z) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && (frsMultiDelBottomMenuView = this.j0) != null) {
            frsMultiDelBottomMenuView.setIsBlockMode(z);
        }
    }

    public void B1(int i2) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && (frsMultiDelBottomMenuView = this.j0) != null) {
            frsMultiDelBottomMenuView.setVisibility(i2);
        }
    }

    public void C1(nq5.c cVar) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) && (frsMultiDelBottomMenuView = this.j0) != null) {
            frsMultiDelBottomMenuView.setDeleteCallback(cVar);
        }
    }

    public void D1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.H = i2;
        }
    }

    public void E1(ho hoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, hoVar) == null) {
            this.u.d(hoVar);
        }
    }

    public void F1(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.y = bVar;
            NoNetworkView noNetworkView = this.z;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
        }
    }

    public void G1(boolean z) {
        zw6 zw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (zw6Var = this.v) != null) {
            zw6Var.u(z);
        }
    }

    public void L(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onScrollListener) == null) {
            this.t.addOnScrollListener(onScrollListener);
        }
    }

    public final void M(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048601, this, i2) != null) || this.a == null) {
            return;
        }
        N(i2);
    }

    public void P(String str) {
        bx6 bx6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, str) == null) && (bx6Var = this.M) != null) {
            bx6Var.a(str);
        }
    }

    public final void Q0(boolean z) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048614, this, z) == null) && z && (frsFragment = this.a) != null && frsFragment.q0() != null) {
            this.a.q0().Z();
        }
    }

    public final void Q1(int i2) {
        w66 w66Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048615, this, i2) == null) && (w66Var = this.i) != null) {
            w66Var.g(i2);
        }
    }

    public void V0(boolean z) {
        y69 y69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048629, this, z) == null) && z && (y69Var = this.s0) != null) {
            y69Var.i(2000);
        }
    }

    public void W1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048633, this, z) == null) && this.K != null) {
            if (d95.h().k()) {
                this.K.A(false);
            } else {
                this.K.A(z);
            }
        }
    }

    public void j1(int i2) {
        zw6 zw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048664, this, i2) == null) && (zw6Var = this.v) != null) {
            zw6Var.q(i2);
        }
    }

    public void k1(boolean z) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048666, this, z) == null) && (appBarLayout = this.a0) != null) {
            appBarLayout.setExpanded(z);
        }
    }

    public void m1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, str) == null) {
            ro6 ro6Var = this.u;
            if (ro6Var instanceof do6) {
                ((do6) ro6Var).t(str);
            }
        }
    }

    public void n1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, str) == null) {
            this.u.a(str);
        }
    }

    public void o1(int i2) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048674, this, i2) == null) && (view2 = this.d) != null) {
            view2.setVisibility(i2);
        }
    }

    public void p1(boolean z) {
        uo6 uo6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048676, this, z) == null) && (uo6Var = this.L) != null) {
            uo6Var.a(z);
        }
    }

    public void r1(ll6 ll6Var) {
        zw6 zw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048680, this, ll6Var) == null) && (zw6Var = this.v) != null) {
            zw6Var.r(ll6Var);
        }
    }

    public void t1(boolean z) {
        uo6 uo6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048684, this, z) == null) {
            this.Y = z;
            if (!z && (uo6Var = this.L) != null) {
                uo6Var.b(false, false);
            }
        }
    }

    public void u1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048686, this, z) == null) {
            this.I = z;
        }
    }

    public void x1(int i2) {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048692, this, i2) == null) && (frsMoveAreaBottomMenuView = this.k0) != null) {
            frsMoveAreaBottomMenuView.setVisibility(i2);
        }
    }

    public void y0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048693, this, z) == null) && this.L != null) {
            if (z) {
                q1(false, true);
            } else {
                q1(false, false);
            }
        }
    }

    public void y1(int i2) {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048694, this, i2) == null) && (frsMoveAreaBottomMenuView = this.k0) != null) {
            frsMoveAreaBottomMenuView.setMoveNumber(i2);
        }
    }

    public void z1(int i2) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048696, this, i2) == null) && (frsMultiDelBottomMenuView = this.j0) != null) {
            frsMultiDelBottomMenuView.setSelectNumber(i2);
        }
    }

    public void d1(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048651, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            w66 w66Var = this.i;
            if (w66Var != null) {
                w66Var.e(z, i2);
            }
            this.B.d(i2, z);
        }
    }

    public void l1(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048668, this, i2, i3) == null) {
            this.R = i2;
            this.S = i3;
        }
    }

    public void q1(boolean z, boolean z2) {
        uo6 uo6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048678, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.Y && (uo6Var = this.L) != null) {
            uo6Var.b(z, z2);
        }
    }

    public void v1(int i2, boolean z) {
        zw6 zw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048688, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && (zw6Var = this.v) != null) {
            zw6Var.t(i2, z);
        }
    }

    @NonNull
    public static String d0(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                return fixedBarText + "吧";
            }
            return UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
        }
        return (String) invokeL.objValue;
    }

    public void N0(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.q0 = z;
            if (this.Q == null) {
                return;
            }
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && frsFragment.G3() != null && this.a.G3().B() != null) {
                z2 = this.a.G3().B().b instanceof FrsAllThreadFragment;
            } else {
                z2 = true;
            }
            if (!z && z2) {
                this.Q.r(true);
                this.Q.n(this.R, this.S, this.I, true);
                return;
            }
            this.Q.r(false);
            this.Q.z();
        }
    }

    public void Y0(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048638, this, i2) == null) && TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i2 == 3 || i2 == 6) && ry4.l().i("frs_login_tip", true)) {
                if (this.J == null) {
                    this.J = new CommonTipView(this.a.getActivity());
                }
                this.J.setText(R.string.obfuscated_res_0x7f0f074c);
                FrameLayout t0 = t0();
                if (t0 != null) {
                    this.J.j(t0, TbadkCoreApplication.getInst().getSkinType());
                    ry4.l().v("frs_login_tip", false);
                }
            }
        }
    }

    public final void Y1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i2) == null) {
            View q0 = q0();
            View s0 = s0();
            if (UtilHelper.canUseStyleImmersiveSticky() && q0 != null && s0 != null && q0.getLayoutParams() != null && s0.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = q0.getLayoutParams();
                int statusBarHeight = UtilHelper.getStatusBarHeight() - i2;
                layoutParams.height = statusBarHeight;
                if (statusBarHeight < 0) {
                    layoutParams.height = 0;
                }
                q0.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = s0.getLayoutParams();
                layoutParams2.height = i2;
                if (i2 > UtilHelper.getStatusBarHeight()) {
                    layoutParams2.height = UtilHelper.getStatusBarHeight();
                }
                s0.setLayoutParams(layoutParams2);
            }
        }
    }

    public void c1(ct4 ct4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, ct4Var) == null) {
            dq5 dq5Var = new dq5(this.a.getPageContext(), 1);
            dq5Var.j(this.t);
            HashMap hashMap = new HashMap();
            hashMap.put("forum_name", this.a.g());
            hashMap.put("forum_id", this.a.l());
            dq5Var.k(hashMap);
            dq5Var.i(ct4Var);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, dq5Var));
        }
    }

    public void w1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048690, this, z) == null) {
            this.F = z;
            if (z) {
                this.s.F(this.a.getResources().getString(R.string.load_more));
                BdTypeRecyclerView bdTypeRecyclerView = this.t;
                if (bdTypeRecyclerView.getChildAt(bdTypeRecyclerView.getChildCount() - 1) == this.s.c()) {
                    this.s.T();
                    this.a.b();
                    return;
                }
                this.s.g();
                return;
            }
            this.s.F(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0aa5));
            this.s.g();
        }
    }

    public void B0() {
        zw6 zw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (zw6Var = this.v) != null) {
            zw6Var.n();
        }
    }

    public void C0() {
        zw6 zw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (zw6Var = this.v) != null) {
            zw6Var.o();
        }
    }

    public boolean F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.m == null || this.p.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return ry4.l().i("key_reaction_guide_show_number", false);
        }
        return invokeV.booleanValue;
    }

    public boolean H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.s.c().getParent() != null && this.G) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.k0;
            if (frsMoveAreaBottomMenuView != null && frsMoveAreaBottomMenuView.b()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            zw6 zw6Var = this.v;
            if (zw6Var != null) {
                return zw6Var.j() instanceof FrsNewAreaFragment;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            sw6 sw6Var = this.K;
            if (sw6Var == null) {
                return false;
            }
            return sw6Var.p();
        }
        return invokeV.booleanValue;
    }

    public void K1() {
        zw6 zw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (zw6Var = this.v) != null) {
            zw6Var.v();
        }
    }

    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            ro6 ro6Var = this.u;
            if (ro6Var instanceof do6) {
                ((do6) ro6Var).q();
            }
        }
    }

    public void M0() {
        ro6 ro6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (ro6Var = this.u) != null) {
            ro6Var.notifyDataSetChanged();
        }
    }

    public void O0() {
        y69 y69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (y69Var = this.s0) != null) {
            y69Var.d();
        }
    }

    public void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.t.setVisibility(0);
        }
    }

    public void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.G = true;
            this.t.setNextPage(this.s);
            int i2 = this.H;
            if (i2 > 0) {
                this.s.O(i2);
            }
            this.s.E(null);
            this.s.T();
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.v.h();
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            ImageView imageView = this.k;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.j;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
        }
    }

    public void T() {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && (frsMultiDelBottomMenuView = this.j0) != null) {
            frsMultiDelBottomMenuView.a();
        }
    }

    public void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            S();
            nv4 nv4Var = this.w;
            if (nv4Var != null) {
                nv4Var.m();
            }
        }
    }

    public void U() {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048625, this) == null) && (frsMultiDelBottomMenuView = this.j0) != null) {
            frsMultiDelBottomMenuView.b();
        }
    }

    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            sw6 sw6Var = this.K;
            if (sw6Var != null) {
                sw6Var.s();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public View W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    public void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            M(TbadkCoreApplication.getInst().getSkinType());
            sw6 sw6Var = this.K;
            if (sw6Var != null) {
                sw6Var.t();
            }
        }
    }

    public View X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.D;
        }
        return (View) invokeV.objValue;
    }

    public void X1() {
        zw6 zw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048636, this) == null) && (zw6Var = this.v) != null) {
            zw6Var.w();
        }
    }

    public ro6 Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.u;
        }
        return (ro6) invokeV.objValue;
    }

    public zw6 Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.v;
        }
        return (zw6) invokeV.objValue;
    }

    public void Z1() {
        zw6 zw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && (zw6Var = this.v) != null) {
            zw6Var.x();
        }
    }

    public sw6 a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.K;
        }
        return (sw6) invokeV.objValue;
    }

    public void a1() {
        zw6 zw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048644, this) == null) && (zw6Var = this.v) != null) {
            zw6Var.w();
        }
    }

    public final int b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            if (!UtilHelper.canUseStyleImmersiveSticky()) {
                return 0;
            }
            return UtilHelper.getStatusBarHeight();
        }
        return invokeV.intValue;
    }

    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            E0(this.X, this.a.T3());
            ro6 ro6Var = this.u;
            if (ro6Var != null) {
                ro6Var.e();
            }
        }
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            zw6 zw6Var = this.v;
            if (zw6Var == null) {
                return false;
            }
            return zw6Var.l();
        }
        return invokeV.booleanValue;
    }

    public BdTypeRecyclerView e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.t;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public void e1() {
        NoNetworkView noNetworkView;
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048653, this) == null) && (noNetworkView = this.z) != null && (bVar = this.y) != null) {
            noNetworkView.e(bVar);
        }
    }

    public View f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            PbListView pbListView = this.s;
            if (pbListView == null) {
                return null;
            }
            return pbListView.c();
        }
        return (View) invokeV.objValue;
    }

    public void f1() {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048655, this) == null) && (frsMoveAreaBottomMenuView = this.k0) != null) {
            frsMoveAreaBottomMenuView.d();
        }
    }

    public View g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            w66 w66Var = this.i;
            if (w66Var != null) {
                return w66Var.c();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public boolean g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            if (this.F) {
                return false;
            }
            this.s.F(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0aa5));
            this.s.g();
            return true;
        }
        return invokeV.booleanValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment == null) {
                return null;
            }
            return frsFragment.p().getPageActivity();
        }
        return (Context) invokeV.objValue;
    }

    @NonNull
    public lu6 h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return this.B;
        }
        return (lu6) invokeV.objValue;
    }

    public NavigationBar i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            return this.A;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            this.u.notifyDataSetChanged();
        }
    }

    public final int j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            NavigationBar navigationBar = this.A;
            if (navigationBar == null) {
                return 0;
            }
            return navigationBar.getHeight();
        }
        return invokeV.intValue;
    }

    public ObservedChangeLinearLayout k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            return this.V;
        }
        return (ObservedChangeLinearLayout) invokeV.objValue;
    }

    public final int l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            if (this.z != null && !BdNetTypeUtil.isNetWorkAvailable()) {
                return this.z.getHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public of8 m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            return this.Q;
        }
        return (of8) invokeV.objValue;
    }

    public TextView n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return this.l;
        }
        return (TextView) invokeV.objValue;
    }

    public uo6 o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            return this.L;
        }
        return (uo6) invokeV.objValue;
    }

    public RelativeLayout p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            return this.b;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public View q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            return this.T;
        }
        return (View) invokeV.objValue;
    }

    public final int r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            View view2 = this.T;
            if (view2 == null) {
                return 0;
            }
            return view2.getHeight();
        }
        return invokeV.intValue;
    }

    public View s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            return this.U;
        }
        return (View) invokeV.objValue;
    }

    public FrameLayout t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            return this.E;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public ImageView u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            return this.k;
        }
        return (ImageView) invokeV.objValue;
    }

    public ImageView v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            return this.j;
        }
        return (ImageView) invokeV.objValue;
    }

    public void w0() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048689, this) == null) && this.m != null && (frameLayout = this.n) != null) {
            frameLayout.setVisibility(8);
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048691, this) == null) {
            this.G = false;
            this.t.setNextPage(null);
        }
    }

    public final boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            ww6 ww6Var = this.i0;
            if (ww6Var != null && ww6Var.G()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || this.N != null) {
            return;
        }
        View E3 = this.a.E3();
        this.N = (GifView) E3.findViewById(R.id.obfuscated_res_0x7f090ce6);
        TbImageView tbImageView = (TbImageView) E3.findViewById(R.id.obfuscated_res_0x7f0921ba);
        this.O = tbImageView;
        tbImageView.setPageId(this.a.getUniqueId());
        this.N.setLayerType(1, null);
        this.O.setLayerType(1, null);
    }

    public void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.G = true;
            this.t.setNextPage(this.s);
            this.s.E(this.x);
            int i2 = this.H;
            if (i2 > 0) {
                this.s.O(i2);
            }
            this.s.g();
            this.s.F(this.a.getResources().getString(R.string.list_click_load_more));
        }
    }

    public void M1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048603, this) != null) || this.m == null) {
            return;
        }
        this.n.setVisibility(0);
        this.p.setVisibility(8);
        this.o.setVisibility(0);
        TbadkCoreApplication.getInst().handler.postDelayed(this.v0, 5000L);
    }

    public void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.G = false;
            this.t.setNextPage(this.s);
            int i2 = this.H;
            if (i2 > 0) {
                this.s.O(i2);
            }
            this.s.E(null);
            this.s.g();
            this.s.F(this.a.getResources().getString(R.string.list_has_no_more));
        }
    }

    public boolean T0() {
        InterceptResult invokeV;
        AppBarLayoutStickyBehavior appBarLayoutStickyBehavior;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (this.a0 != null && (appBarLayoutStickyBehavior = this.b0) != null && appBarLayoutStickyBehavior.isSticky()) {
                BdTypeRecyclerView bdTypeRecyclerView = this.t;
                if (bdTypeRecyclerView != null) {
                    bdTypeRecyclerView.setSelection(0);
                }
                this.b0.expandedAppBarLayout(this.a0);
                return true;
            }
            sw6 sw6Var = this.K;
            if (sw6Var != null && sw6Var.v()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void Z0() {
        uo6 uo6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            if (this.Y && (uo6Var = this.L) != null) {
                uo6Var.b(false, false);
            }
            Q1(8);
            ImageView imageView = this.k;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = this.j;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            W1(false);
            this.t.setVisibility(8);
            this.c0.setVisibility(8);
        }
    }

    public void h1() {
        uo6 uo6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048660, this) == null) {
            if (this.Y && (uo6Var = this.L) != null) {
                uo6Var.b(true, false);
            }
            Q1(0);
            R();
            W1(this.a.b3());
            this.t.setVisibility(0);
            this.c0.setVisibility(0);
        }
    }

    public final void E0(so6 so6Var, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, so6Var, z) == null) {
            this.X = so6Var;
            View E3 = this.a.E3();
            if (this.b == null) {
                this.b = (NoPressedRelativeLayout) E3.findViewById(R.id.obfuscated_res_0x7f090b17);
            }
            if (this.d == null) {
                this.d = E3.findViewById(R.id.obfuscated_res_0x7f090b47);
            }
            if (this.c == null) {
                this.c = (CoordinatorLayout) E3.findViewById(R.id.obfuscated_res_0x7f090bfd);
            }
            if (this.D == null) {
                this.D = E3.findViewById(R.id.obfuscated_res_0x7f090bd7);
            }
            if (this.E == null) {
                this.E = (FrameLayout) E3.findViewById(R.id.obfuscated_res_0x7f090c44);
            }
            if (this.d0 == null) {
                this.d0 = (CollapsingToolbarLayout) E3.findViewById(R.id.obfuscated_res_0x7f090b45);
            }
            if (this.c0 == null) {
                this.c0 = (FrsHeaderViewContainer) E3.findViewById(R.id.obfuscated_res_0x7f090dd6);
            }
            if (this.v == null) {
                this.v = new zw6(this.a);
            }
            if (this.V == null) {
                ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) E3.findViewById(R.id.obfuscated_res_0x7f0916fd);
                this.V = observedChangeLinearLayout;
                observedChangeLinearLayout.setOnSizeChangeListener(new i(this));
            }
            this.B.h(this.a, E3, this.x);
            if (this.A == null) {
                this.A = this.B.e();
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.a.T3()) {
                this.A.setVisibility(8);
            }
            if (this.C == null) {
                this.C = E3.findViewById(R.id.obfuscated_res_0x7f090bfc);
                to6 c2 = so6Var.c();
                if (c2 != null) {
                    c2.b(this.C);
                }
            }
            if (this.e == null) {
                this.e = (View) this.B.a(LogicField.BACK_BTN);
                this.f = (ImageView) this.B.a(LogicField.BACK_IV);
            }
            if (this.k == null) {
                this.k = (ImageView) this.B.a(LogicField.SEARCH_BTN);
            }
            if (this.i == null) {
                this.i = (w66) this.B.a(LogicField.MESSAGE_ICON_CONTROLLER);
                this.g = (ImageView) this.B.a(LogicField.MESSAGE_BTN);
                this.h = (MessageRedDotView) this.B.a(LogicField.MESSAGE_RED_DOT);
            }
            if (this.j == null) {
                this.j = (ImageView) this.B.a(LogicField.SHARE_BTN);
            }
            if (this.l == null) {
                TextView textView = (TextView) this.A.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.obfuscated_res_0x7f0d034c, (View.OnClickListener) null);
                this.l = textView;
                textView.setVisibility(8);
                Drawable drawable = SkinManager.getDrawable(R.drawable.icon_arrow12_white);
                int g2 = yi.g(this.a.getActivity(), R.dimen.tbds31);
                drawable.setBounds(0, 0, g2, g2);
                this.l.setCompoundDrawables(null, null, drawable, null);
                SkinManager.setBackgroundResourceSelector(this.l, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
                SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0101);
            }
            if (z2) {
                this.A.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setBackgroundColor(this.A.getBottomLine(), R.color.CAM_X0204);
            }
            if (this.t == null) {
                this.t = (BdTypeRecyclerView) E3.findViewById(R.id.obfuscated_res_0x7f090be1);
            }
            j jVar = new j(this);
            jVar.setSupportsChangeAnimations(false);
            this.t.setItemAnimator(jVar);
            BdTypeRecyclerView bdTypeRecyclerView = this.t;
            bdTypeRecyclerView.setLayoutManager(new k(this, bdTypeRecyclerView.getContext()));
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                vn vnVar = new vn(new tn());
                this.r0 = vnVar;
                vnVar.q(this.t, 2);
            }
            this.t.setScrollable(this.a);
            this.t.setFadingEdgeLength(0);
            this.t.setOverScrollMode(2);
            this.b.setBottomOrderView(this.t);
            this.t.setOnTouchListener(this.a.P1);
            this.t.setRecyclerListener(new l(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            BdTypeRecyclerView bdTypeRecyclerView2 = this.t;
            bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.t.getPaddingBottom());
            if (this.s == null) {
                PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
                this.s = pbListView;
                pbListView.c();
            }
            this.s.r(R.color.transparent);
            this.s.v(yi.g(this.a.getActivity(), R.dimen.tbds182));
            this.s.A();
            this.s.J(R.dimen.tbfontsize33);
            this.s.H(SkinManager.getColor(R.color.CAM_X0109));
            this.s.D(R.color.CAM_X0110);
            this.t.setOnSrollToBottomListener(this.a);
            this.A.setOnClickListener(new m(this));
            boolean isShowBigImage = TbImageHelper.getInstance().isShowBigImage();
            if (this.u == null) {
                this.u = so6Var.b(this.a, this.t, isShowBigImage);
            }
            zw6 zw6Var = this.v;
            if (zw6Var != null) {
                zw6Var.t(1, false);
            }
            if (!z) {
                if (this.z == null) {
                    this.z = new NoNetworkView(this.a.getActivity());
                    this.z.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    this.V.addView(this.z);
                }
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    this.z.setVisibility(8);
                } else {
                    this.z.setVisibility(0);
                }
                this.z.d(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            D0();
            if (this.K == null) {
                sw6 a2 = so6Var.a(this.a, this.b);
                this.K = a2;
                a2.x(this.a.J3());
            }
            if (this.L == null) {
                this.L = so6Var.d(this.a, this.b);
                p1(true);
            }
            if (this.T == null) {
                this.T = E3.findViewById(R.id.obfuscated_res_0x7f092046);
            }
            if (this.U == null) {
                this.U = E3.findViewById(R.id.obfuscated_res_0x7f092047);
            }
            if (this.Q == null) {
                this.Q = new of8(this.a.getPageContext(), this.t);
            }
            this.Q.p(2);
            this.Q.u(this.a.getUniqueId());
            if (this.s0 == null) {
                this.s0 = new y69(this.a.getPageContext(), this.t);
            }
            NavigationBarCoverTip navigationBarCoverTip = (NavigationBarCoverTip) E3.findViewById(R.id.obfuscated_res_0x7f0916ff);
            this.l0 = navigationBarCoverTip;
            if (this.M == null) {
                this.M = new bx6(this.a, navigationBarCoverTip);
            }
            if (this.a0 == null) {
                AppBarLayout appBarLayout = (AppBarLayout) E3.findViewById(R.id.obfuscated_res_0x7f090b2a);
                this.a0 = appBarLayout;
                appBarLayout.addOnOffsetChangedListener(this.u0);
                this.e0 = true;
                this.f0 = -1;
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.a0.getLayoutParams();
                if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                    this.b0 = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
                }
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = (FrsMultiDelBottomMenuView) E3.findViewById(R.id.obfuscated_res_0x7f090bf5);
            this.j0 = frsMultiDelBottomMenuView;
            frsMultiDelBottomMenuView.setPageContext(this.a.getPageContext());
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = (FrsMoveAreaBottomMenuView) E3.findViewById(R.id.obfuscated_res_0x7f090bf2);
            this.k0 = frsMoveAreaBottomMenuView;
            frsMoveAreaBottomMenuView.setPageContext(this.a.getPageContext());
            if (this.n0 == null) {
                this.n0 = (TextView) this.B.a(LogicField.FOLD_TITLE);
            }
            ExposeTagViewCoordinatorLayout exposeTagViewCoordinatorLayout = (ExposeTagViewCoordinatorLayout) E3.findViewById(R.id.obfuscated_res_0x7f090bfd);
            this.q = exposeTagViewCoordinatorLayout;
            exposeTagViewCoordinatorLayout.setListener(new n(this));
            FrsTabViewPager frsTabViewPager = (FrsTabViewPager) E3.findViewById(R.id.obfuscated_res_0x7f090c59);
            this.r = frsTabViewPager;
            frsTabViewPager.addOnPageChangeListener(new o(this));
        }
    }

    public void H1(ArrayList<xn> arrayList, FrsViewData frsViewData) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048591, this, arrayList, frsViewData) != null) || frsViewData == null) {
            return;
        }
        ArrayList<xn> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (ListUtils.isEmpty(switchThreadDataToThreadCardInfo) || !frsViewData.mHasThreadExceptTop) {
            kk6 kk6Var = new kk6();
            ArrayList<xn> arrayList2 = new ArrayList<>();
            arrayList2.add(kk6Var);
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && frsFragment.N0() != null && this.a.N0().g0() == 0) {
                kk6Var.b(this.a.N0().b0());
            }
            switchThreadDataToThreadCardInfo = arrayList2;
        }
        if (ListUtils.getCount(switchThreadDataToThreadCardInfo) > 0) {
            for (int i3 = 0; i3 < switchThreadDataToThreadCardInfo.size(); i3++) {
                xn xnVar = switchThreadDataToThreadCardInfo.get(i3);
                if (xnVar instanceof yu4) {
                    ((yu4) xnVar).t.setSmartFrsPosition(i3);
                }
            }
        }
        this.u.g(switchThreadDataToThreadCardInfo, frsViewData);
        of8 of8Var = this.Q;
        if (of8Var != null && (i2 = this.R) != 0) {
            of8Var.n(i2, this.S, this.I, true);
        }
        FrsFragment frsFragment2 = this.a;
        if (frsFragment2 != null) {
            frsFragment2.G4();
        }
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.j0;
        if (frsMultiDelBottomMenuView != null) {
            frsMultiDelBottomMenuView.setFrsViewData(frsViewData);
        }
        y69 y69Var = this.s0;
        if (y69Var != null) {
            y69Var.i(2000);
        }
    }

    public final void O(AppBarLayout appBarLayout, int i2) {
        FrsFragment frsFragment;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048607, this, appBarLayout, i2) == null) && (frsFragment = this.a) != null && appBarLayout != null && frsFragment.G3() != null && this.a.getPageContext() != null) {
            int b0 = b0() + j0() + l0();
            int totalScrollRange = (appBarLayout.getTotalScrollRange() - Math.abs(i2)) + this.B.g();
            FrsTabViewController G3 = this.a.G3();
            ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            FrsFragment frsFragment2 = this.a;
            if (frsFragment2 != null && frsFragment2.c4()) {
                z = true;
            } else {
                z = false;
            }
            if (totalScrollRange <= 0) {
                if (this.p0 != 2) {
                    G3.f(2);
                }
                this.p0 = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange < b0) {
                if (this.p0 != 1) {
                    G3.f(1);
                }
                this.p0 = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.p0 != 0) {
                    G3.f(0);
                }
                this.p0 = 0;
                if (z) {
                    marginLayoutParams.topMargin = yi.g(this.a.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.d.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void R1(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048618, this, str, i2) == null) {
            if (this.m0 == null) {
                TextView textView = new TextView(this.a.getActivity());
                this.m0 = textView;
                textView.setGravity(19);
                this.m0.setPadding(yi.g(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07020f), 0, yi.g(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07020f), 0);
                this.m0.setLayoutParams(new ViewGroup.LayoutParams(-1, yi.g(this.a.getActivity(), R.dimen.tbds112)));
                this.m0.setTextSize(0, yi.g(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07032e));
                this.m0.setMaxLines(2);
                this.m0.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
                this.m0.setTextColor(ContextCompat.getColor(this.a.getActivity(), R.color.CAM_X0101));
            }
            this.l0.setBackgroundColor(i2);
            this.m0.setText(str);
            this.l0.n(this.a.getActivity(), this.m0, 5000);
        }
    }

    public void I1(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, str) != null) || (textView = this.n0) == null || !TextUtils.isEmpty(textView.getText())) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.n0.setText("");
            return;
        }
        this.n0.setText(d0(str));
        dr4.c().h(str);
    }

    public void U1(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048627, this, postWriteCallBackData) == null) && postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (postWriteCallBackData.getIconStampData() != null) {
                r45.c(this.a.p(), postWriteCallBackData, 1);
                return;
            }
            if (this.Z == null) {
                this.Z = new s09(this.a.getActivity(), this.b);
            }
            this.Z.g(postWriteCallBackData);
        }
    }

    public void J1() {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (navigationBar = this.A) != null && navigationBar.getBarBgView() != null && this.V != null) {
            s1();
            if (this.W) {
                this.A.getBarBgView().setAlpha(0.0f);
                this.A.hideBottomLine();
            } else {
                View view2 = this.T;
                if (view2 != null) {
                    view2.setAlpha(1.0f);
                }
                View view3 = this.U;
                if (view3 != null) {
                    view3.setAlpha(1.0f);
                }
                TextView textView = this.n0;
                if (textView != null) {
                    textView.setAlpha(0.0f);
                }
                this.A.getBarBgView().setAlpha(1.0f);
                this.A.showBottomLine();
            }
            R0(this.h0);
        }
    }

    public final int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            AppBarLayout appBarLayout = this.a0;
            if (appBarLayout == null) {
                return this.f0;
            }
            int i2 = this.f0;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            for (int childCount = appBarLayout.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = this.a0.getChildAt(childCount);
                if (childAt != null) {
                    int scrollFlags = ((AppBarLayout.LayoutParams) childAt.getLayoutParams()).getScrollFlags();
                    if ((scrollFlags & 5) == 5) {
                        if ((scrollFlags & 8) != 0) {
                            i3 += ViewCompat.getMinimumHeight(childAt);
                        }
                    } else if (i3 > 0) {
                        break;
                    }
                }
            }
            int max = Math.max(0, this.a0.getTotalScrollRange() - Math.abs(i3));
            this.f0 = max;
            return max;
        }
        return invokeV.intValue;
    }

    public final void s1() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048682, this) == null) {
            this.W = z0();
            FrsHeaderViewContainer frsHeaderViewContainer = this.c0;
            if (frsHeaderViewContainer != null && (layoutParams = frsHeaderViewContainer.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                if (this.W) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
                } else {
                    ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070306) + b0(), 0, 0);
                }
                this.c0.requestLayout();
            }
        }
    }

    public final void N(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            NavigationBar navigationBar = this.A;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), i2);
                if (this.A.getBackground() != null && this.A.getBackground().mutate() != null) {
                    this.A.getBackground().mutate().setAlpha(0);
                }
                SkinManager.setBackgroundColor(this.A.getBarBgView(), R.color.CAM_X0207);
                SkinManager.setBackgroundColor(this.A.getBottomLine(), R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.C, R.color.CAM_X0204, i2);
                w66 w66Var = this.i;
                if (w66Var != null) {
                    w66Var.d(i2);
                }
                if (this.k != null) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                if (this.j != null) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            SkinManager.setBackgroundColor(this.T, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.U, R.color.CAM_X0207);
            b2(true);
        }
    }

    public void N1(hv4 hv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, hv4Var) == null) {
            if (this.m == null) {
                View E3 = this.a.E3();
                ViewStub viewStub = (ViewStub) E3.findViewById(R.id.obfuscated_res_0x7f0927ab);
                this.m = viewStub;
                viewStub.setVisibility(0);
                this.n = (FrameLayout) E3.findViewById(R.id.obfuscated_res_0x7f090c97);
                this.o = (TbImageView) E3.findViewById(R.id.obfuscated_res_0x7f090c96);
                this.p = (TbImageView) E3.findViewById(R.id.obfuscated_res_0x7f090c98);
                this.o.setPageId(this.a.getUniqueId());
                this.p.setPageId(this.a.getUniqueId());
                this.o.setDefaultBgResource(R.color.common_color_10022);
                this.o.setDefaultResource(0);
                this.p.setDefaultBgResource(R.color.common_color_10022);
                this.p.setDefaultResource(0);
                this.n.setOnClickListener(this.x);
            }
            this.n.setVisibility(0);
            String a2 = hv4Var.a();
            String b2 = hv4Var.b();
            this.o.K(a2, 10, false);
            this.p.K(b2, 10, false);
            TbadkCoreApplication.getInst().handler.postDelayed(this.v0, 5000L);
        }
    }

    public void R0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.h0 = i2;
            this.B.onChangeSkinType(i2);
            eq5 eq5Var = new eq5(this.a, 4);
            eq5Var.F(i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, eq5Var));
            dq5 dq5Var = new dq5(this.a.getPageContext(), 4);
            dq5Var.l(i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, dq5Var));
            TbImageView tbImageView = this.O;
            if (tbImageView != null) {
                tbImageView.invalidate();
            }
            ro6 ro6Var = this.u;
            if (ro6Var != null) {
                ro6Var.b();
                this.u.notifyDataSetChanged();
            }
            ig5.a(this.a.getPageContext(), this.b);
            NoNetworkView noNetworkView = this.z;
            if (noNetworkView != null) {
                noNetworkView.d(this.a.getPageContext(), i2);
            }
            PbListView pbListView = this.s;
            if (pbListView != null) {
                pbListView.H(SkinManager.getColor(R.color.CAM_X0109));
                this.s.e(i2);
            }
            TextView textView = this.n0;
            if (textView != null) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            }
            M(i2);
            uo6 uo6Var = this.L;
            if (uo6Var != null) {
                uo6Var.onChangeSkinType(i2);
            }
            sw6 sw6Var = this.K;
            if (sw6Var != null) {
                sw6Var.u(i2);
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.j0;
            if (frsMultiDelBottomMenuView != null) {
                frsMultiDelBottomMenuView.d();
            }
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.k0;
            if (frsMoveAreaBottomMenuView != null) {
                frsMoveAreaBottomMenuView.c();
            }
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0202);
        }
    }

    public final void b2(boolean z) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048648, this, z) == null) && (navigationBar = this.A) != null && navigationBar.getBarBgView() != null && this.W) {
            if (this.A.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.o0 != 0) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    ImageView imageView = this.g;
                    if (imageView != null) {
                        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0101), null));
                    }
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.o0 = 0;
                }
            } else if (z || this.o0 != 1) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                ImageView imageView2 = this.g;
                if (imageView2 != null) {
                    imageView2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0106), null));
                }
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.o0 = 1;
            }
            a2();
        }
    }

    public void P0(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048611, this, i2, i3) == null) {
            y69 y69Var = this.s0;
            if (y69Var != null) {
                y69Var.i(100);
            }
            if (this.s0 != null && !G0()) {
                this.s0.g();
            }
            of8 of8Var = this.Q;
            if (of8Var == null) {
                return;
            }
            of8Var.m(i2, i3, this.I, 1);
            this.Q.p(2);
            this.Q.q(false);
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && this.w == null && this.a.getPageContext() != null) {
            String[] strArr = {this.a.getPageContext().getPageActivity().getString(R.string.take_photo), this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0257)};
            nv4 nv4Var = new nv4(this.a.getPageContext().getPageActivity());
            this.w = nv4Var;
            nv4Var.l(this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0d82));
            this.w.j(strArr, new a(this));
            this.w.c(this.a.getPageContext());
        }
    }

    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.t0);
            of8 of8Var = this.Q;
            if (of8Var != null) {
                of8Var.h();
            }
            bx6 bx6Var = this.M;
            if (bx6Var != null) {
                bx6Var.c();
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.j0;
            if (frsMultiDelBottomMenuView != null) {
                frsMultiDelBottomMenuView.setPageContext(null);
            }
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.k0;
            if (frsMoveAreaBottomMenuView != null) {
                frsMoveAreaBottomMenuView.setPageContext(null);
            }
            this.u.onDestory();
            this.t.setOnSrollToBottomListener(null);
            this.t.setScrollable(null);
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.v0);
            CommonTipView commonTipView = this.J;
            if (commonTipView != null) {
                commonTipView.i();
            }
            this.P.clear();
            sw6 sw6Var = this.K;
            if (sw6Var != null) {
                sw6Var.r();
            }
            s09 s09Var = this.Z;
            if (s09Var != null) {
                s09Var.e();
            }
            NavigationBarCoverTip navigationBarCoverTip = this.l0;
            if (navigationBarCoverTip != null) {
                navigationBarCoverTip.i();
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView2 = this.j0;
            if (frsMultiDelBottomMenuView2 != null) {
                frsMultiDelBottomMenuView2.e();
            }
            zw6 zw6Var = this.v;
            if (zw6Var != null) {
                zw6Var.p();
            }
            zw6 zw6Var2 = this.v;
            if (zw6Var2 != null) {
                zw6Var2.r(null);
            }
        }
    }

    public void V1() {
        int headerViewsCount;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048630, this) == null) && ry4.l().n("frs_video_activity_guide", 0L) == 0 && !this.w0 && this.a.getActivity() != null && this.a.getPageContext() != null) {
            View view2 = null;
            BdTypeRecyclerView bdTypeRecyclerView = this.t;
            if (bdTypeRecyclerView != null && (headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount()) < this.t.getChildCount()) {
                view2 = this.t.getChildAt(headerViewsCount);
            }
            if (view2 != null) {
                qf qfVar = new qf();
                qfVar.k(view2);
                qfVar.c(0);
                qfVar.j(true);
                qfVar.i(false);
                qfVar.d(true);
                qfVar.a(new c(this));
                qfVar.h(new d(this));
                pf b2 = qfVar.b();
                b2.k(false);
                b2.m(this.a.getActivity());
                ah.a().postDelayed(new e(this, b2), 4000L);
                this.w0 = true;
            }
        }
    }

    public void X0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048635, this) != null) || Y() == null) {
            return;
        }
        List<xn> f2 = Y().f();
        if (ListUtils.isEmpty(f2)) {
            return;
        }
        for (xn xnVar : f2) {
            if (xnVar instanceof yu4) {
                yu4 yu4Var = (yu4) xnVar;
                if (yu4Var.u != 0 && yu4Var.t != null && this.a.N0() != null && this.a.N0().o0() != null) {
                    int[] imageWidthAndHeight = yu4Var.t.getImageWidthAndHeight();
                    yu4Var.u = imageWidthAndHeight[0];
                    yu4Var.v = imageWidthAndHeight[1];
                }
            }
        }
        ah.a().postDelayed(new f(this), 500L);
    }

    public final void a2() {
        NavigationBar navigationBar;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048645, this) != null) || (navigationBar = this.A) == null) {
            return;
        }
        if (navigationBar.getBarBgView() != null) {
            f2 = this.A.getBarBgView().getAlpha();
        } else {
            f2 = 0.0f;
        }
        if (f2 < 0.5f) {
            f3 = 1.0f - (f2 * 2.0f);
        } else {
            f3 = (f2 * 2.0f) - 1.0f;
        }
        if (Float.compare(f3, 0.0f) < 0) {
            f3 = 0.0f;
        }
        if (Float.compare(f3, 1.0f) > 0) {
            f3 = 1.0f;
        }
        TextView textView = this.n0;
        if (textView != null) {
            textView.setAlpha(f2);
        }
        boolean z = true;
        if (f3 >= 0.0f && f3 <= 1.0f) {
            ImageView imageView = this.f;
            if (imageView != null) {
                imageView.setAlpha(f3);
            }
            ImageView imageView2 = this.g;
            if (imageView2 != null) {
                imageView2.setAlpha(f3);
            }
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && frsFragment.G3() != null && this.o0 == 1) {
                this.a.G3().f0(f3);
            }
            MessageRedDotView messageRedDotView = this.h;
            if (messageRedDotView != null) {
                messageRedDotView.setAlpha(f3);
            }
            ImageView imageView3 = this.k;
            if (imageView3 != null) {
                imageView3.setAlpha(f3);
            }
            ImageView imageView4 = this.j;
            if (imageView4 != null) {
                imageView4.setAlpha(f3);
            }
        }
        TextView textView2 = this.l;
        if (textView2 != null) {
            float f4 = 1.0f - (2.0f * f2);
            textView2.setAlpha(f4);
            TextView textView3 = this.l;
            if (f4 <= 0.0f) {
                z = false;
            }
            textView3.setClickable(z);
        }
        View view2 = this.T;
        if (view2 != null) {
            view2.setAlpha(f2);
        }
        View view3 = this.U;
        if (view3 != null) {
            view3.setAlpha(f2);
        }
        View view4 = this.C;
        if (view4 != null) {
            view4.setAlpha(f2);
        }
    }
}
