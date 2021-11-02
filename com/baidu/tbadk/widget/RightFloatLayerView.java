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
import b.a.r0.z2.z;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
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
/* loaded from: classes8.dex */
public class RightFloatLayerView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f46124e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f46125f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f46126g;

    /* renamed from: h  reason: collision with root package name */
    public AlphaAnimation f46127h;

    /* renamed from: i  reason: collision with root package name */
    public AlphaAnimation f46128i;
    public ValueAnimator j;
    public ValueAnimator k;
    public ValueAnimator l;
    public ValueAnimator m;
    public ValueAnimator n;
    public ValueAnimator o;
    public ValueAnimator p;
    public ValueAnimator q;
    public AnimatorSet r;
    public AnimatorSet s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public final Runnable x;

    /* loaded from: classes8.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerView f46129e;

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
            this.f46129e = rightFloatLayerView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f46129e.f46126g.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerView f46130e;

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
            this.f46130e = rightFloatLayerView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f46130e.f46124e.setAlpha(floatValue);
                this.f46130e.f46125f.setAlpha(floatValue);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerView f46131e;

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
            this.f46131e = rightFloatLayerView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f46131e.f46126g.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerView f46132e;

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
            this.f46132e = rightFloatLayerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46132e.halfShow();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerView f46133a;

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
            this.f46133a = rightFloatLayerView;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && this.f46133a.v) {
                if (z) {
                    this.f46133a.completeShow();
                } else {
                    this.f46133a.completeHide();
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

    /* loaded from: classes8.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerView f46134e;

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
            this.f46134e = rightFloatLayerView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f46134e.f46126g.setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerView f46135e;

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
            this.f46135e = rightFloatLayerView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f46135e.f46126g.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerView f46136e;

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
            this.f46136e = rightFloatLayerView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f46136e.f46124e.setAlpha(floatValue);
                this.f46136e.f46125f.setAlpha(floatValue);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerView f46137e;

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
            this.f46137e = rightFloatLayerView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f46137e.f46126g.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerView f46138e;

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
            this.f46138e = rightFloatLayerView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.f46138e.t = true;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerView f46139e;

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
            this.f46139e = rightFloatLayerView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f46139e.f46126g.setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerView f46140e;

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
            this.f46140e = rightFloatLayerView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.f46140e.t = false;
                if (this.f46140e.u) {
                    this.f46140e.halfHide();
                    this.f46140e.u = false;
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

    public static void addClickLogForFloatEyeAd(b.a.q0.t.c.g gVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, gVar, i2) == null) || gVar == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(gVar.m == 2 ? TbadkCoreStatisticKey.KEY_AD_FLOAT_LAYER_CLICK : TbadkCoreStatisticKey.KEY_FLOAT_LAYER_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", gVar.p).param("obj_param1", i2));
    }

    public static void addShowLogForFloatEyeAd(b.a.q0.t.c.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, gVar) == null) || gVar == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(gVar.m == 2 ? TbadkCoreStatisticKey.KEY_AD_FLOAT_LAYER_SHOW : TbadkCoreStatisticKey.KEY_FLOAT_LAYER_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", gVar.p));
    }

    public static boolean isHomeNeedShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (isVIPCloseAd()) {
                return false;
            }
            return !StringHelper.isTaday(b.a.q0.s.e0.b.j().l("key_tab_right_float_layer_view", 0L));
        }
        return invokeV.booleanValue;
    }

    public static boolean isVIPCloseAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1;
        }
        return invokeV.booleanValue;
    }

    public void completeHide() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && getVisibility() == 0) {
            AlphaAnimation alphaAnimation = this.f46127h;
            if (alphaAnimation != null) {
                alphaAnimation.cancel();
            }
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.f46127h = alphaAnimation2;
            alphaAnimation2.setDuration(300L);
            this.f46127h.setFillAfter(true);
            startAnimation(this.f46127h);
            setClickable(false);
            setVisibility(8);
        }
    }

    public void completeShow() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || getVisibility() == 0) {
            return;
        }
        AlphaAnimation alphaAnimation = this.f46128i;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
        }
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        this.f46128i = alphaAnimation2;
        alphaAnimation2.setDuration(300L);
        this.f46128i.setFillAfter(true);
        startAnimation(this.f46128i);
        setClickable(true);
        setVisibility(0);
    }

    public void doLink(b.a.q0.t.c.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) || gVar == null) {
            return;
        }
        if (gVar.m == 2) {
            h(gVar);
        } else {
            i(gVar);
        }
        addClickLogForFloatEyeAd(gVar, 0);
    }

    public final int h(b.a.q0.t.c.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, gVar)) == null) {
            String str = gVar.k;
            String str2 = gVar.n;
            String str3 = gVar.l;
            int d2 = z.d(getContext(), str, str2, str3);
            l(str3, 2);
            m(str3, d2);
            tryParallelCharge(gVar);
            return d2;
        }
        return invokeL.intValue;
    }

    public void halfHide() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && getVisibility() == 0 && !this.t) {
            if (this.j == null) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, -45.0f);
                this.j = ofFloat;
                ofFloat.setDuration(400L);
                this.j.addUpdateListener(new f(this));
            }
            if (this.k == null) {
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.5f);
                this.k = ofFloat2;
                ofFloat2.setDuration(450L);
                this.k.addUpdateListener(new g(this));
            }
            if (this.l == null) {
                ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.l = ofFloat3;
                ofFloat3.setDuration(450L);
                this.l.addUpdateListener(new h(this));
            }
            if (this.m == null) {
                ValueAnimator ofFloat4 = ValueAnimator.ofFloat(0.0f, 101.0f);
                this.m = ofFloat4;
                ofFloat4.setDuration(400L);
                this.m.addUpdateListener(new i(this));
                this.m.addListener(new j(this));
            }
            if (this.r == null) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.r = animatorSet;
                animatorSet.play(this.j).with(this.k).with(this.l).before(this.m);
            }
            this.r.start();
            setClickable(false);
        }
    }

    public void halfShow() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && getVisibility() == 0 && this.t) {
            if (this.n == null) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(-45.0f, 6.0f, -4.0f, 0.0f);
                this.n = ofFloat;
                ofFloat.setDuration(700L);
                this.n.addUpdateListener(new k(this));
                this.n.addListener(new l(this));
            }
            if (this.o == null) {
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.5f, 1.0f);
                this.o = ofFloat2;
                ofFloat2.setDuration(450L);
                this.o.addUpdateListener(new a(this));
            }
            if (this.p == null) {
                ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.p = ofFloat3;
                ofFloat3.setDuration(450L);
                this.p.addUpdateListener(new b(this));
            }
            if (this.q == null) {
                ValueAnimator ofFloat4 = ValueAnimator.ofFloat(101.0f, 0.0f);
                this.q = ofFloat4;
                ofFloat4.setDuration(400L);
                this.q.addUpdateListener(new c(this));
            }
            if (this.s == null) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.s = animatorSet;
                animatorSet.play(this.n).after(this.q).with(this.p).with(this.o);
            }
            this.s.start();
            setClickable(false);
        }
    }

    public final void i(b.a.q0.t.c.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, gVar) == null) {
            String str = gVar.f13781e;
            String str2 = gVar.f13785i;
            String str3 = gVar.j;
            String str4 = gVar.f13784h;
            if (!UtilHelper.isMatchScheme(getContext(), str2, str3) && !StringUtils.isNull(str)) {
                k(str);
            }
            ThirdStatisticHelper.sendReq(str4);
        }
    }

    public void inHomeLastCloseTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b.a.q0.s.e0.b.j().w("key_tab_right_float_layer_view", System.currentTimeMillis());
        }
    }

    public void inPbLastCloseTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b.a.q0.s.e0.b.j().w("key_pb_right_float_layer_view", System.currentTimeMillis());
        }
    }

    public boolean isPbNeedShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (isVIPCloseAd()) {
                return false;
            }
            return !StringHelper.isTaday(b.a.q0.s.e0.b.j().l("key_pb_right_float_layer_view", 0L));
        }
        return invokeV.booleanValue;
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.new_float_view, (ViewGroup) this, true);
            this.f46124e = (ImageView) findViewById(R.id.float_layer_feedback_picture);
            this.f46125f = (TextView) findViewById(R.id.layer_ad_lable_icon_layout);
            SkinManager.setImageResource(this.f46124e, R.drawable.ic_icon_popup_close_n);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.float_layer_logo_picture);
            this.f46126g = tbImageView;
            tbImageView.setAutoChangeStyle(true);
            this.f46126g.setEvent(new e(this));
        }
    }

    public final void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void l(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, str, i2) == null) {
            b.a.r0.z2.l0.d.e("TIEBA_LAYER", str, 0, i2, "layer", null, null, null, null, null);
        }
    }

    public final void m(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, str, i2) == null) {
            boolean z = i2 == 1000;
            b.a.r0.z2.l0.d.e("TIEBA_LAYER_DEEPLINK", str, 0, SDKLogTypeConstants.CLOSE_GAME_TYPE, z ? "APP" : "URL", null, z ? null : String.valueOf(i2), null, null, null);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f46126g.invalidate();
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f46124e, R.drawable.ic_icon_popup_close_n, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f46125f, R.color.CAM_X0112, 1);
        }
    }

    public void onScrollDragging() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.u = true;
            halfHide();
            removeCallbacks(this.x);
        }
    }

    public void onScrollIdle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.u = false;
            postDelayed(this.x, 1600L);
        }
    }

    public void onScrollSettling() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.t = true;
            removeCallbacks(this.x);
        }
    }

    public void parallelShow(b.a.q0.t.c.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, gVar) == null) {
            b.a.r0.q1.o.h.c.g(gVar);
        }
    }

    public void reportClickCloseAd(b.a.q0.t.c.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, gVar) == null) || gVar == null) {
            return;
        }
        int i2 = gVar.m;
        String str = gVar.l;
        if (i2 == 2) {
            l(str, 7);
        }
        addClickLogForFloatEyeAd(gVar, 1);
    }

    public void reportShowAd(b.a.q0.t.c.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, gVar) == null) || gVar == null) {
            return;
        }
        if (gVar.m == 2) {
            l(gVar.l, 3);
            parallelShow(gVar);
        } else {
            ThirdStatisticHelper.sendReq(gVar.f13784h);
        }
        addShowLogForFloatEyeAd(gVar);
    }

    public void setAutoCompleteShown(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.v = z;
        }
    }

    public void setData(b.a.q0.t.c.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, gVar) == null) || gVar == null || this.w || b.a.e.e.p.k.isEmpty(gVar.f13782f)) {
            return;
        }
        this.f46126g.startLoad(gVar.f13782f, 45, false);
        reportShowAd(gVar);
        this.w = true;
    }

    public void setFeedBackListener(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, onClickListener) == null) || (imageView = this.f46124e) == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void setLogoListener(View.OnClickListener onClickListener) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, onClickListener) == null) || (tbImageView = this.f46126g) == null) {
            return;
        }
        tbImageView.setOnClickListener(onClickListener);
    }

    public void tryParallelCharge(b.a.q0.t.c.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, gVar) == null) {
            b.a.r0.q1.o.h.c.h(gVar);
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
        this.f46127h = null;
        this.f46128i = null;
        this.t = false;
        this.u = false;
        this.v = true;
        this.w = false;
        this.x = new d(this);
        j(context);
    }
}
