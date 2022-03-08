package com.baidu.tbadk.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.r0.j3.a0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class RightFloatLayerView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AlphaAnimation f39868e;

    /* renamed from: f  reason: collision with root package name */
    public AlphaAnimation f39869f;
    public ImageView feedbackImageView;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f39870g;

    /* renamed from: h  reason: collision with root package name */
    public ValueAnimator f39871h;

    /* renamed from: i  reason: collision with root package name */
    public ValueAnimator f39872i;
    public boolean isAutoCompleteShown;
    public boolean isDrag;
    public boolean isFloatLayerShown;
    public boolean isHalfState;

    /* renamed from: j  reason: collision with root package name */
    public ValueAnimator f39873j;
    public ValueAnimator k;
    public ValueAnimator l;
    public TbImageView logoImageView;
    public ValueAnimator m;
    public TextView mAdLableIcon;
    public ValueAnimator n;
    public AnimatorSet o;
    public AnimatorSet p;
    public final Runnable q;

    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerView f39874e;

        public a(RightFloatLayerView rightFloatLayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39874e = rightFloatLayerView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f39874e.logoImageView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerView f39875e;

        public b(RightFloatLayerView rightFloatLayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39875e = rightFloatLayerView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f39875e.feedbackImageView.setAlpha(floatValue);
                this.f39875e.mAdLableIcon.setAlpha(floatValue);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerView f39876e;

        public c(RightFloatLayerView rightFloatLayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39876e = rightFloatLayerView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f39876e.logoImageView.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerView f39877e;

        public d(RightFloatLayerView rightFloatLayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39877e = rightFloatLayerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f39877e.halfShow();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RightFloatLayerView a;

        public e(RightFloatLayerView rightFloatLayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rightFloatLayerView;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
                RightFloatLayerView rightFloatLayerView = this.a;
                if (rightFloatLayerView.isAutoCompleteShown) {
                    if (z) {
                        rightFloatLayerView.completeShow();
                    } else {
                        rightFloatLayerView.completeHide();
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerView f39878e;

        public f(RightFloatLayerView rightFloatLayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39878e = rightFloatLayerView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f39878e.logoImageView.setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerView f39879e;

        public g(RightFloatLayerView rightFloatLayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39879e = rightFloatLayerView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f39879e.logoImageView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerView f39880e;

        public h(RightFloatLayerView rightFloatLayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39880e = rightFloatLayerView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f39880e.feedbackImageView.setAlpha(floatValue);
                this.f39880e.mAdLableIcon.setAlpha(floatValue);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerView f39881e;

        public i(RightFloatLayerView rightFloatLayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39881e = rightFloatLayerView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f39881e.logoImageView.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerView f39882e;

        public j(RightFloatLayerView rightFloatLayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39882e = rightFloatLayerView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.f39882e.isHalfState = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerView f39883e;

        public k(RightFloatLayerView rightFloatLayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39883e = rightFloatLayerView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f39883e.logoImageView.setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerView f39884e;

        public l(RightFloatLayerView rightFloatLayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39884e = rightFloatLayerView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                RightFloatLayerView rightFloatLayerView = this.f39884e;
                rightFloatLayerView.isHalfState = false;
                if (rightFloatLayerView.isDrag) {
                    rightFloatLayerView.halfHide();
                    this.f39884e.isDrag = false;
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RightFloatLayerView(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void addClickLogForFloatEyeAd(c.a.q0.s.c.f fVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65539, null, fVar, i2) == null) || fVar == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(fVar.r == 2 ? TbadkCoreStatisticKey.KEY_AD_FLOAT_LAYER_CLICK : TbadkCoreStatisticKey.KEY_FLOAT_LAYER_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", fVar.u).param("obj_param1", i2));
    }

    public static void addShowLogForFloatEyeAd(c.a.q0.s.c.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fVar) == null) || fVar == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(fVar.r == 2 ? TbadkCoreStatisticKey.KEY_AD_FLOAT_LAYER_SHOW : TbadkCoreStatisticKey.KEY_FLOAT_LAYER_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", fVar.u));
    }

    public static boolean isHomePbNeedShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (isVIPCloseAd()) {
                return false;
            }
            return !StringHelper.isTaday(c.a.q0.r.j0.b.k().m("key_tab_right_float_layer_view", 0L));
        }
        return invokeV.booleanValue;
    }

    public static boolean isVIPCloseAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1;
        }
        return invokeV.booleanValue;
    }

    public final int a(c.a.q0.s.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
            String str = fVar.p;
            String str2 = fVar.s;
            String str3 = fVar.q;
            int d2 = a0.d(getContext(), str, str2, str3, null);
            d(str3, 2);
            e(str3, d2);
            tryParallelCharge(fVar);
            return d2;
        }
        return invokeL.intValue;
    }

    public final void b(c.a.q0.s.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            String str = fVar.f13639e;
            String str2 = fVar.n;
            String str3 = fVar.o;
            String str4 = fVar.m;
            if (!UtilHelper.isMatchScheme(getContext(), str2, str3) && !StringUtils.isNull(str)) {
                c(str);
            }
            ThirdStatisticHelper.sendReq(str4);
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public void completeHide() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && getVisibility() == 0) {
            AlphaAnimation alphaAnimation = this.f39868e;
            if (alphaAnimation != null) {
                alphaAnimation.cancel();
            }
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.f39868e = alphaAnimation2;
            alphaAnimation2.setDuration(300L);
            this.f39868e.setFillAfter(true);
            startAnimation(this.f39868e);
            setClickable(false);
            setVisibility(8);
        }
    }

    public void completeShow() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || getVisibility() == 0) {
            return;
        }
        AlphaAnimation alphaAnimation = this.f39869f;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
        }
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        this.f39869f = alphaAnimation2;
        alphaAnimation2.setDuration(300L);
        this.f39869f.setFillAfter(true);
        startAnimation(this.f39869f);
        setClickable(true);
        setVisibility(0);
    }

    public final void d(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i2) == null) {
            c.a.r0.j3.m0.d.e("TIEBA_LAYER", str, 0, i2, "layer", null, null, null, null, null);
        }
    }

    public void doLink(c.a.q0.s.c.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) || fVar == null) {
            return;
        }
        if (fVar.r == 2) {
            a(fVar);
        } else {
            b(fVar);
        }
        addClickLogForFloatEyeAd(fVar, 0);
    }

    public final void e(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, str, i2) == null) {
            boolean z = i2 == 1000;
            c.a.r0.j3.m0.d.e("TIEBA_LAYER_DEEPLINK", str, 0, 706, z ? "APP" : "URL", null, z ? null : String.valueOf(i2), null, null, null);
        }
    }

    public void halfHide() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && getVisibility() == 0 && !this.isHalfState) {
            if (this.f39870g == null) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, -45.0f);
                this.f39870g = ofFloat;
                ofFloat.setDuration(400L);
                this.f39870g.addUpdateListener(new f(this));
            }
            if (this.f39871h == null) {
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.5f);
                this.f39871h = ofFloat2;
                ofFloat2.setDuration(450L);
                this.f39871h.addUpdateListener(new g(this));
            }
            if (this.f39872i == null) {
                ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.f39872i = ofFloat3;
                ofFloat3.setDuration(450L);
                this.f39872i.addUpdateListener(new h(this));
            }
            if (this.f39873j == null) {
                ValueAnimator ofFloat4 = ValueAnimator.ofFloat(0.0f, 101.0f);
                this.f39873j = ofFloat4;
                ofFloat4.setDuration(400L);
                this.f39873j.addUpdateListener(new i(this));
                this.f39873j.addListener(new j(this));
            }
            if (this.o == null) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.o = animatorSet;
                animatorSet.play(this.f39870g).with(this.f39871h).with(this.f39872i).before(this.f39873j);
            }
            this.o.start();
            setClickable(false);
        }
    }

    public void halfShow() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && getVisibility() == 0 && this.isHalfState) {
            if (this.k == null) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(-45.0f, 6.0f, -4.0f, 0.0f);
                this.k = ofFloat;
                ofFloat.setDuration(700L);
                this.k.addUpdateListener(new k(this));
                this.k.addListener(new l(this));
            }
            if (this.l == null) {
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.5f, 1.0f);
                this.l = ofFloat2;
                ofFloat2.setDuration(450L);
                this.l.addUpdateListener(new a(this));
            }
            if (this.m == null) {
                ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.m = ofFloat3;
                ofFloat3.setDuration(450L);
                this.m.addUpdateListener(new b(this));
            }
            if (this.n == null) {
                ValueAnimator ofFloat4 = ValueAnimator.ofFloat(101.0f, 0.0f);
                this.n = ofFloat4;
                ofFloat4.setDuration(400L);
                this.n.addUpdateListener(new c(this));
            }
            if (this.p == null) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.p = animatorSet;
                animatorSet.play(this.k).after(this.n).with(this.m).with(this.l);
            }
            this.p.start();
            setClickable(false);
        }
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.new_float_view, (ViewGroup) this, true);
            this.feedbackImageView = (ImageView) findViewById(R.id.float_layer_feedback_picture);
            this.mAdLableIcon = (TextView) findViewById(R.id.layer_ad_lable_icon_layout);
            SkinManager.setImageResource(this.feedbackImageView, R.drawable.ic_icon_popup_close_n);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.float_layer_logo_picture);
            this.logoImageView = tbImageView;
            tbImageView.setAutoChangeStyle(true);
            this.logoImageView.setEvent(new e(this));
        }
    }

    public boolean isFloatLayerShown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.isFloatLayerShown : invokeV.booleanValue;
    }

    public boolean isNeedShowAdIcon(c.a.q0.s.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, fVar)) == null) ? fVar.r == 2 || fVar.b() : invokeL.booleanValue;
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.logoImageView.invalidate();
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.feedbackImageView, R.drawable.ic_icon_popup_close_n, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.mAdLableIcon, R.color.CAM_X0112, 1);
        }
    }

    public void onScrollDragging() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.isDrag = true;
            halfHide();
            removeCallbacks(this.q);
        }
    }

    public void onScrollIdle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.isDrag = false;
            postDelayed(this.q, 1600L);
        }
    }

    public void onScrollSettling() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.isHalfState = true;
            removeCallbacks(this.q);
        }
    }

    public void parallelShow(c.a.q0.s.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, fVar) == null) {
            c.a.r0.z1.o.h.c.g(fVar);
        }
    }

    public void reportClickCloseAd(c.a.q0.s.c.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, fVar) == null) || fVar == null) {
            return;
        }
        int i2 = fVar.r;
        String str = fVar.q;
        if (i2 == 2) {
            d(str, 7);
        }
        addClickLogForFloatEyeAd(fVar, 1);
    }

    public void reportShowAd(c.a.q0.s.c.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, fVar) == null) || fVar == null) {
            return;
        }
        if (fVar.r == 2) {
            d(fVar.q, 3);
            parallelShow(fVar);
        } else {
            ThirdStatisticHelper.sendReq(fVar.m);
        }
        addShowLogForFloatEyeAd(fVar);
    }

    public void setAutoCompleteShown(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.isAutoCompleteShown = z;
        }
    }

    public void setData(c.a.q0.s.c.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, fVar) == null) || fVar == null || this.isFloatLayerShown || m.isEmpty(fVar.f13640f)) {
            return;
        }
        if (isNeedShowAdIcon(fVar)) {
            this.mAdLableIcon.setVisibility(0);
        } else {
            this.mAdLableIcon.setVisibility(4);
        }
        this.logoImageView.setVisibility(0);
        this.logoImageView.startLoad(fVar.f13640f, 45, false);
        reportShowAd(fVar);
        this.isFloatLayerShown = true;
    }

    public void setFeedBackListener(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, onClickListener) == null) || (imageView = this.feedbackImageView) == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void setHomePbFloatLastCloseTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            c.a.q0.r.j0.b.k().x("key_tab_right_float_layer_view", System.currentTimeMillis());
        }
    }

    public void setLogoListener(View.OnClickListener onClickListener) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, onClickListener) == null) || (tbImageView = this.logoImageView) == null) {
            return;
        }
        tbImageView.setOnClickListener(onClickListener);
    }

    public void tryParallelCharge(c.a.q0.s.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, fVar) == null) {
            c.a.r0.z1.o.h.c.h(fVar);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RightFloatLayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RightFloatLayerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f39868e = null;
        this.f39869f = null;
        this.isHalfState = false;
        this.isDrag = false;
        this.isAutoCompleteShown = true;
        this.isFloatLayerShown = false;
        this.q = new d(this);
        init(context);
    }
}
