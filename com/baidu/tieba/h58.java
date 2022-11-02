package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.ViewModelProviders;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.pb.videopb.videoView.PbNextVideoLayout;
import com.baidu.tieba.pb.videopb.videoView.PbVideoFullscreenAttentionLayout;
import com.baidu.tieba.pb.videopb.videoView.PbVideoMediaController;
import com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class h58 extends cd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbVideoFullscreenAttentionLayout N0;
    public PbNextVideoLayout O0;
    public ImageView P0;
    public ImageView Q0;
    public int R0;
    public int S0;
    public boolean T0;
    public ObjectAnimator U0;
    public VideoPbViewModel V0;
    public int W0;
    public String X0;
    public String Y0;
    public BaijiahaoData Z0;
    public AbsVideoPbFragment a1;
    public View b1;
    public View c1;
    public boolean d1;
    public boolean e1;
    public ObjectAnimator f1;
    public ObjectAnimator g1;
    public Runnable h1;
    public Runnable i1;
    public Runnable j1;
    public Runnable k1;

    @Override // com.baidu.tieba.cd8
    public int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? R.layout.obfuscated_res_0x7f0d06f1 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.cd8
    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h58 a;

        /* loaded from: classes4.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.a.a.Q0();
                    zg.a().postDelayed(this.a.a.j1, 5000L);
                }
            }
        }

        public b(h58 h58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h58Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.N0.b()) {
                Context context = this.a.O;
                if (this.a.T) {
                    i = R.dimen.tbds210;
                } else {
                    i = R.dimen.tbds244;
                }
                this.a.T0 = true;
                this.a.U0.setFloatValues(-xi.g(context, i));
                this.a.U0.removeAllListeners();
                this.a.U0.addListener(new a(this));
                this.a.U0.start();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h58 a;

        /* loaded from: classes4.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.a.a.N0.setVisibility(8);
                }
            }
        }

        public c(h58 h58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h58Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Context context = this.a.O;
                if (this.a.T) {
                    i = R.dimen.tbds210;
                } else {
                    i = R.dimen.tbds244;
                }
                this.a.U0.setFloatValues(xi.g(context, i));
                this.a.U0.removeAllListeners();
                this.a.U0.addListener(new a(this));
                this.a.U0.start();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h58 a;

        public a(h58 h58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h58Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h58 a;

        public d(h58 h58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h58Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.e1 && (this.a.O instanceof Activity)) {
                this.a.L0();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h58(Context context, View view2) {
        super(context, view2);
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.R0 = -1;
        this.W0 = 0;
        this.h1 = new a(this);
        this.i1 = new b(this);
        this.j1 = new c(this);
        this.k1 = new d(this);
        P();
        if (context instanceof AbsPbActivity) {
            this.V0 = (VideoPbViewModel) ViewModelProviders.of((AbsPbActivity) context).get(VideoPbViewModel.class);
            Activity activity = (Activity) context;
            if (!TbSingleton.getInstance().isNotchScreen(activity) && !TbSingleton.getInstance().isCutoutScreen(activity)) {
                z = false;
            } else {
                z = true;
            }
            this.d1 = z;
        }
        X(true);
        Y(true);
        this.c0 = false;
    }

    public void R0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.O0.setIsCountDownValid(z);
        }
    }

    public void S0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.e1 = z;
        }
    }

    @Override // com.baidu.tieba.cd8
    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            Context context = this.O;
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).setSwipeBackEnabled(this.Y);
            }
            super.V(z);
            Q0();
            if (this.Y) {
                J0();
            } else {
                this.N0.setVisibility(8);
            }
        }
    }

    public void V0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view2) == null) {
            this.b1 = view2;
        }
    }

    public void W0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view2) == null) {
            this.c1 = view2;
        }
    }

    public void X0(AbsVideoPbFragment absVideoPbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, absVideoPbFragment) == null) {
            this.a1 = absVideoPbFragment;
        }
    }

    @Override // com.baidu.tieba.cd8
    public boolean f0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, motionEvent)) == null) {
            if (!this.Y && motionEvent.getX() <= this.S0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.cd8, com.baidu.tieba.zc8
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            this.N0.setUniqueId(bdUniqueId);
        }
    }

    public final void J0() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.T0 && !this.N0.b()) {
            this.N0.setTranslationX(0.0f);
            this.N0.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.N0.getLayoutParams();
            Context context = this.O;
            if (this.T) {
                i = R.dimen.tbds248;
            } else {
                i = R.dimen.tbds428;
            }
            layoutParams.bottomMargin = xi.g(context, i);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.N0, Key.TRANSLATION_X, 0.0f);
            this.U0 = ofFloat;
            ofFloat.setDuration(500);
            Q0();
            zg.a().postDelayed(this.i1, 5000L);
        }
    }

    @Override // com.baidu.tieba.cd8
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i = this.b & (-33);
            this.b = i;
            int i2 = this.o & (-33);
            this.o = i2;
            int i3 = this.d & (-33);
            this.d = i3;
            int i4 = this.e & (-33);
            this.e = i4;
            int i5 = this.n & (-33);
            this.n = i5;
            int i6 = this.f & (-33);
            this.f = i6;
            int i7 = this.g & (-33);
            this.g = i7;
            int i8 = this.h & (-33);
            this.h = i8;
            int i9 = this.i & (-33);
            this.i = i9;
            int i10 = this.j & (-33);
            this.j = i10;
            int i11 = this.k & (-33);
            this.k = i11;
            this.b = i | 1024;
            this.o = i2 | 1024;
            int i12 = i3 | 1024;
            this.d = i12;
            this.e = i4 & (-1025);
            this.n = i5 & (-1025);
            this.f = i6 | 1024;
            this.g = i7 | 1024;
            int i13 = i8 | 1024;
            this.h = i13;
            int i14 = i9 | 1024;
            this.i = i14;
            this.j = i10 | 1024;
            this.k = i11 & (-1025);
            this.d = i12 | 16384;
            this.h = i13 | 16384;
            this.i = i14 & (-2);
        }
    }

    @Override // com.baidu.tieba.cd8
    public void Q() {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.G.a(this.T, this.Y);
            this.H.e(this.T, this.Y);
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.F;
            if (operableVideoMediaControllerView instanceof PbVideoMediaController) {
                ((PbVideoMediaController) operableVideoMediaControllerView).q(this.T, this.Y);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
            int i3 = 0;
            if (this.Y && this.T) {
                i = xi.g(this.O, R.dimen.tbds42);
            } else {
                i = 0;
            }
            if (this.Y && !this.T) {
                i3 = xi.g(this.O, R.dimen.tbds34);
            }
            layoutParams.bottomMargin = i;
            layoutParams.rightMargin = i3;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.P0.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.Q0.getLayoutParams();
            Context context = this.O;
            if (this.Y && !this.T) {
                i2 = R.dimen.tbds208;
            } else {
                i2 = R.dimen.tbds104;
            }
            int g = xi.g(context, i2);
            layoutParams3.leftMargin = g;
            layoutParams2.rightMargin = g;
            this.O0.b(this.T, this.Y);
        }
    }

    @Override // com.baidu.tieba.cd8
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.d0();
            this.N0 = (PbVideoFullscreenAttentionLayout) this.Q.findViewById(R.id.obfuscated_res_0x7f092564);
            this.O0 = (PbNextVideoLayout) this.Q.findViewById(R.id.obfuscated_res_0x7f092588);
            this.P0 = (ImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f09259f);
            this.Q0 = (ImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f092587);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.P0, R.drawable.obfuscated_res_0x7f080641, R.color.CAM_X0101, null);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.Q0, R.drawable.obfuscated_res_0x7f080633, R.color.CAM_X0101, null);
            this.u.s();
            this.u.setDrawCorner(false);
            this.N0.setOnClickEvent(this);
            this.P0.setOnClickListener(this);
            this.Q0.setOnClickListener(this);
            this.O0.setOnClickListener(this);
            this.S0 = xi.l(this.O) / 10;
            this.H.setShareFrom(18);
        }
    }

    public final StatisticItem K0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            StatisticItem param = new StatisticItem(str).param("tid", this.V).param("fid", this.W).param("uid", TbadkCoreApplication.getCurrentAccount());
            BaijiahaoData baijiahaoData = this.Z0;
            if (baijiahaoData != null) {
                param.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
                param.param(TiebaStatic.Params.OBJ_PARAM6, this.Z0.oriUgcVid);
                int i = this.Z0.oriUgcType;
                if (i == 4) {
                    param.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                } else if (i == 2) {
                    param.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                }
            } else {
                param.param(TiebaStatic.Params.OBJ_PARAM5, 1);
            }
            Context context = this.O;
            if ((context instanceof AbsPbActivity) && ((AbsPbActivity) context).j1() != null) {
                param.param("ab_tag", ((AbsPbActivity) this.O).j1().X1()).param("obj_id", ((AbsPbActivity) this.O).j1().Y1()).param("obj_source", ((AbsPbActivity) this.O).j1().Z1());
            }
            return param;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Y0();
            UtilHelper.hideStatusBar((Activity) this.O, this.b1);
            this.e1 = false;
            AbsVideoPbFragment absVideoPbFragment = this.a1;
            if (absVideoPbFragment != null) {
                absVideoPbFragment.h5(false);
            }
        }
    }

    public boolean M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e1;
        }
        return invokeV.booleanValue;
    }

    public boolean N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.T;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.cd8
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.O();
            if (this.Y) {
                J0();
            }
        }
    }

    public void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Q0();
            X(false);
            Y(false);
            MessageManager.getInstance().unRegisterListener(this.H0);
            MessageManager.getInstance().unRegisterListener(this.M0);
        }
    }

    public final void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            zg.a().removeCallbacks(this.i1);
            zg.a().removeCallbacks(this.j1);
        }
    }

    @Override // com.baidu.tieba.cd8
    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.t.getControl().setVolume(1.0f, 1.0f);
        }
    }

    @Override // com.baidu.tieba.cd8
    public void u0() {
        uc8 uc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (uc8Var = this.Z) != null) {
            uc8 b2 = uc8Var.b();
            b2.a = "pb";
            jc8.e(b2.m, "", "2", b2, this.t.getControl().getPcdnState());
        }
    }

    public boolean P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.p == this.k) {
                return false;
            }
            this.K.setVisibility(0);
            this.K.d(this.O, false, 10);
            zg.a().removeCallbacks(this.h1);
            zg.a().postDelayed(this.h1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.g1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c1, Key.ALPHA, 1.0f, 0.0f);
                this.g1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.g1.start();
        }
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.f1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c1, Key.ALPHA, 0.0f, 1.0f);
                this.f1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.f1.start();
        }
    }

    @Override // com.baidu.tieba.cd8, com.baidu.tieba.zc8
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.p == this.k) {
                return false;
            }
            this.K.setVisibility(0);
            this.K.d(this.O, true, 10);
            zg.a().removeCallbacks(this.h1);
            zg.a().postDelayed(this.h1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void T0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, threadData) == null) {
            if (threadData != null && threadData.getThreadVideoInfo() != null && !wi.isEmpty(threadData.getThreadVideoInfo().video_url)) {
                int i = this.p;
                if (i == this.f || i == this.g) {
                    int i2 = this.p | 32768;
                    this.p = i2;
                    o0(i2);
                }
                int i3 = this.p;
                if (i3 == this.i) {
                    int i4 = i3 | 131072;
                    this.p = i4;
                    o0(i4);
                }
                this.f |= 32768;
                this.g |= 32768;
                this.i |= 131072;
                this.O0.setDate(threadData);
                return;
            }
            int i5 = this.p;
            if (i5 == this.f || i5 == this.g || i5 == this.i) {
                int i6 = this.p & (-32769);
                this.p = i6;
                int i7 = i6 & (-131073);
                this.p = i7;
                o0(i7);
            }
            this.f &= -32769;
            this.g &= -32769;
            this.i &= -131073;
        }
    }

    @Override // com.baidu.tieba.cd8, com.baidu.tieba.zc8
    public boolean onBackground(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048603, this, z)) == null) {
            Q0();
            this.N0.setVisibility(8);
            if (!this.d1) {
                L0();
            }
            if (z) {
                int i = this.p;
                this.R0 = i;
                if (i == this.g || ((i == this.h && !this.t.getControl().isPlaying()) || this.p == this.i)) {
                    this.R0 |= 1;
                }
                stopPlay();
            } else {
                int i2 = this.R0;
                if (i2 == -1) {
                    startPlay();
                } else if (i2 != this.d && i2 != this.f && i2 != this.e && i2 != this.n) {
                    this.F.setCurrentDuration(tc8.d().c(this.U), false);
                    o0(this.R0);
                } else {
                    startPlay();
                }
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.baidu.tieba.cd8, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, view2) != null) || view2 == null) {
            return;
        }
        int id = view2.getId();
        boolean z = true;
        if (id == R.id.obfuscated_res_0x7f091a2a) {
            TbSingleton.getInstance().setHasAgreeToPlay(true);
        }
        super.onClick(view2);
        if (id == R.id.obfuscated_res_0x7f0906db) {
            Q0();
            zg.a().post(this.j1);
        } else if (id != R.id.obfuscated_res_0x7f092587 && id != R.id.obfuscated_res_0x7f092588) {
            if (id == R.id.obfuscated_res_0x7f09259f) {
                VideoPbViewModel videoPbViewModel = this.V0;
                if (videoPbViewModel != null) {
                    videoPbViewModel.q();
                }
                TiebaStatic.log(new StatisticItem("c13594"));
            } else if (id == R.id.obfuscated_res_0x7f091894) {
                this.i &= -131073;
                this.p &= -131073;
                this.O0.setVisibility(8);
            }
        } else {
            VideoPbViewModel videoPbViewModel2 = this.V0;
            if (videoPbViewModel2 != null) {
                if (id != R.id.obfuscated_res_0x7f092588) {
                    z = false;
                }
                videoPbViewModel2.p(z);
            }
            if (id == R.id.obfuscated_res_0x7f092587) {
                TiebaStatic.log(new StatisticItem("c13595"));
            }
        }
    }

    @Override // com.baidu.tieba.cd8
    public void t0(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            if (i == R.id.obfuscated_res_0x7f092562) {
                if (!isFullScreen()) {
                    TiebaStatic.log(new StatisticItem("c13598"));
                } else {
                    TiebaStatic.log(new StatisticItem("c13599"));
                }
            } else if (i == R.id.obfuscated_res_0x7f0925a5) {
                TiebaStatic.log(K0("c13602"));
            } else if (i == R.id.obfuscated_res_0x7f092596) {
                TiebaStatic.log(new StatisticItem("c13597"));
            } else if (i == R.id.obfuscated_res_0x7f092589) {
                TiebaStatic.log(new StatisticItem("c13596"));
            } else if (i == R.id.obfuscated_res_0x7f092588) {
                StatisticItem K0 = K0("c13601");
                if (this.O0.h) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                TiebaStatic.log(K0.param("obj_type", i2));
            }
        }
    }

    public void U0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, threadData) == null) {
            if (threadData != null && threadData.getThreadVideoInfo() != null && !wi.isEmpty(threadData.getThreadVideoInfo().video_url)) {
                int i = this.p;
                if (i == this.f || i == this.g) {
                    int i2 = this.p | 65536;
                    this.p = i2;
                    o0(i2);
                }
                this.f |= 65536;
                this.g |= 65536;
                return;
            }
            int i3 = this.p;
            if (i3 == this.f || i3 == this.g) {
                int i4 = this.p & (-65537);
                this.p = i4;
                o0(i4);
            }
            this.f &= -65537;
            this.g &= -65537;
        }
    }

    @Override // com.baidu.tieba.cd8
    public void o0(int i) {
        AbsVideoPbFragment absVideoPbFragment;
        boolean z;
        int i2;
        int i3;
        int i4;
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            int i5 = 8;
            if (i != this.g && i != this.h && i != this.f && i != this.d) {
                Q0();
                PbVideoFullscreenAttentionLayout pbVideoFullscreenAttentionLayout = this.N0;
                if (pbVideoFullscreenAttentionLayout != null) {
                    pbVideoFullscreenAttentionLayout.setVisibility(8);
                }
            }
            int i6 = this.p;
            int i7 = this.k;
            if (i6 != i7 && i == i7) {
                zg.a().removeCallbacks(this.h1);
                int i8 = this.p;
                if ((i8 & 16384) > 0) {
                    i = (i | 16384) & (-129) & (-65);
                } else if ((i8 & 128) > 0) {
                    i = (i & (-16385)) | 128 | 64;
                }
                this.k = i;
            }
            super.o0(i);
            if (!this.Y) {
                this.I.setVisibility(8);
                this.J.setVisibility(8);
                VideoPbViewModel videoPbViewModel = this.V0;
                if (videoPbViewModel != null) {
                    if ((i & 1024) > 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    videoPbViewModel.w(z4);
                }
            }
            VideoPbViewModel videoPbViewModel2 = this.V0;
            if (videoPbViewModel2 != null) {
                if ((i & 128) > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                videoPbViewModel2.w(z3);
            }
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.F;
            if (operableVideoMediaControllerView instanceof PbVideoMediaController) {
                int i9 = i & 16384;
                if (i9 <= 0 && (i & 128) <= 0) {
                    i4 = 8;
                } else {
                    i4 = 0;
                }
                operableVideoMediaControllerView.setVisibility(i4);
                PbVideoMediaController pbVideoMediaController = (PbVideoMediaController) this.F;
                if (i9 > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                pbVideoMediaController.setBottomBarShow(z2);
            }
            ImageView imageView = this.P0;
            if (imageView != null) {
                if ((65536 & i) > 0) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                imageView.setVisibility(i3);
            }
            ImageView imageView2 = this.Q0;
            if (imageView2 != null) {
                if ((32768 & i) > 0) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                imageView2.setVisibility(i2);
            }
            if (this.O0 != null) {
                if ((131072 & i) > 0) {
                    z = true;
                } else {
                    z = false;
                }
                PbNextVideoLayout pbNextVideoLayout = this.O0;
                if (z) {
                    i5 = 0;
                }
                pbNextVideoLayout.setVisibility(i5);
                if (z) {
                    TiebaStatic.log(K0("c13600"));
                }
            }
            if (!this.Y && !this.d1 && (this.O instanceof Activity)) {
                if ((i & 128) > 0) {
                    if (!this.e1) {
                        AbsVideoPbFragment absVideoPbFragment2 = this.a1;
                        if (absVideoPbFragment2 == null || !absVideoPbFragment2.z4()) {
                            Z0();
                            UtilHelper.showStatusBar((Activity) this.O, this.b1);
                        }
                        this.e1 = true;
                        zg.a().removeCallbacks(this.k1);
                        zg.a().postDelayed(this.k1, 3000L);
                    }
                } else if (this.e1 || ((absVideoPbFragment = this.a1) != null && absVideoPbFragment.z4())) {
                    L0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.cd8, com.baidu.tieba.zc8
    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048606, this, threadData) != null) || threadData == null) {
            return;
        }
        this.Z0 = threadData.getBaijiahaoData();
        uc8 uc8Var = new uc8();
        uc8Var.a = "6";
        uc8Var.c = threadData.getTid();
        uc8Var.d = Long.toString(threadData.getFid());
        uc8Var.e = TbadkCoreApplication.getCurrentAccount();
        Context context = this.O;
        boolean z = false;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (threadData.isBjh()) {
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.W0 = intExtra;
                if (intExtra == 0) {
                    this.W0 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra("last_tid");
                this.X0 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    uc8Var.k = this.X0;
                }
                uc8Var.i = Integer.toString(this.W0);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.Y0 = stringExtra2;
                uc8Var.i = stringExtra2;
            }
        }
        if (threadData.getThreadVideoInfo() != null) {
            uc8Var.m = threadData.getThreadVideoInfo().video_md5;
            uc8Var.p = String.valueOf(threadData.getThreadVideoInfo().is_vertical);
        }
        setStatistic(uc8Var);
        this.T0 = false;
        if (this.V0.c().z0()) {
            this.O0.setIsCountDownValid(true);
        } else {
            this.O0.setIsCountDownValid(false);
        }
        if (this.Y && threadData.getThreadVideoInfo() != null) {
            boolean z2 = this.T;
            if (threadData.getThreadVideoInfo().is_vertical.intValue() == 1) {
                z = true;
            }
            if (z2 != z) {
                U();
            }
        }
        super.setData(threadData);
        X(!this.T);
        if (threadData.getAuthor() != null) {
            threadData.getAuthor().setIsLike(threadData.getAuthor().hadConcerned());
        }
        this.N0.setData(threadData);
    }
}
