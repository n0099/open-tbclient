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
import c.a.p0.l3.a0;
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
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f30717b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f30718c;

    /* renamed from: d  reason: collision with root package name */
    public AlphaAnimation f30719d;

    /* renamed from: e  reason: collision with root package name */
    public AlphaAnimation f30720e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f30721f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f30722g;

    /* renamed from: h  reason: collision with root package name */
    public ValueAnimator f30723h;
    public ValueAnimator i;
    public ValueAnimator j;
    public ValueAnimator k;
    public ValueAnimator l;
    public ValueAnimator m;
    public AnimatorSet n;
    public AnimatorSet o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public final Runnable t;

    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RightFloatLayerView a;

        public a(RightFloatLayerView rightFloatLayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rightFloatLayerView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.f30718c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RightFloatLayerView a;

        public b(RightFloatLayerView rightFloatLayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rightFloatLayerView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.a.a.setAlpha(floatValue);
                this.a.f30717b.setAlpha(floatValue);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RightFloatLayerView a;

        public c(RightFloatLayerView rightFloatLayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rightFloatLayerView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.f30718c.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RightFloatLayerView a;

        public d(RightFloatLayerView rightFloatLayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rightFloatLayerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.i();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (rightFloatLayerView.r) {
                    if (z) {
                        rightFloatLayerView.d();
                    } else {
                        rightFloatLayerView.c();
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
        public final /* synthetic */ RightFloatLayerView a;

        public f(RightFloatLayerView rightFloatLayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rightFloatLayerView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.f30718c.setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RightFloatLayerView a;

        public g(RightFloatLayerView rightFloatLayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rightFloatLayerView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.f30718c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RightFloatLayerView a;

        public h(RightFloatLayerView rightFloatLayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rightFloatLayerView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.a.a.setAlpha(floatValue);
                this.a.f30717b.setAlpha(floatValue);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RightFloatLayerView a;

        public i(RightFloatLayerView rightFloatLayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rightFloatLayerView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.f30718c.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RightFloatLayerView a;

        public j(RightFloatLayerView rightFloatLayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rightFloatLayerView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.a.p = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RightFloatLayerView a;

        public k(RightFloatLayerView rightFloatLayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rightFloatLayerView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.f30718c.setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RightFloatLayerView a;

        public l(RightFloatLayerView rightFloatLayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rightFloatLayerView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                RightFloatLayerView rightFloatLayerView = this.a;
                rightFloatLayerView.p = false;
                if (rightFloatLayerView.q) {
                    rightFloatLayerView.h();
                    this.a.q = false;
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

    public static void a(c.a.o0.s.c.f fVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65539, null, fVar, i2) == null) || fVar == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(fVar.n == 2 ? TbadkCoreStatisticKey.KEY_AD_FLOAT_LAYER_CLICK : TbadkCoreStatisticKey.KEY_FLOAT_LAYER_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", fVar.q).param("obj_param1", i2));
    }

    public static void b(c.a.o0.s.c.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fVar) == null) || fVar == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(fVar.n == 2 ? TbadkCoreStatisticKey.KEY_AD_FLOAT_LAYER_SHOW : TbadkCoreStatisticKey.KEY_FLOAT_LAYER_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", fVar.q));
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (m()) {
                return false;
            }
            return !StringHelper.isTaday(c.a.o0.r.j0.b.k().m("key_tab_right_float_layer_view", 0L));
        }
        return invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && getVisibility() == 0) {
            AlphaAnimation alphaAnimation = this.f30719d;
            if (alphaAnimation != null) {
                alphaAnimation.cancel();
            }
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.f30719d = alphaAnimation2;
            alphaAnimation2.setDuration(300L);
            this.f30719d.setFillAfter(true);
            startAnimation(this.f30719d);
            setClickable(false);
            setVisibility(8);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || getVisibility() == 0) {
            return;
        }
        AlphaAnimation alphaAnimation = this.f30720e;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
        }
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        this.f30720e = alphaAnimation2;
        alphaAnimation2.setDuration(300L);
        this.f30720e.setFillAfter(true);
        startAnimation(this.f30720e);
        setClickable(true);
        setVisibility(0);
    }

    public final int e(c.a.o0.s.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar)) == null) {
            String str = fVar.l;
            String str2 = fVar.o;
            String str3 = fVar.m;
            int d2 = a0.d(getContext(), str, str2, str3, null);
            t(str3, 2);
            v(str3, d2);
            x(fVar);
            return d2;
        }
        return invokeL.intValue;
    }

    public final void f(c.a.o0.s.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            String str = fVar.a;
            String str2 = fVar.j;
            String str3 = fVar.k;
            String str4 = fVar.i;
            if (!UtilHelper.isMatchScheme(getContext(), str2, str3) && !StringUtils.isNull(str)) {
                n(str);
            }
            ThirdStatisticHelper.sendReq(str4);
        }
    }

    public void g(c.a.o0.s.c.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) || fVar == null) {
            return;
        }
        if (fVar.n == 2) {
            e(fVar);
        } else {
            f(fVar);
        }
        a(fVar, 0);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && getVisibility() == 0 && !this.p) {
            if (this.f30721f == null) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, -45.0f);
                this.f30721f = ofFloat;
                ofFloat.setDuration(400L);
                this.f30721f.addUpdateListener(new f(this));
            }
            if (this.f30722g == null) {
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.5f);
                this.f30722g = ofFloat2;
                ofFloat2.setDuration(450L);
                this.f30722g.addUpdateListener(new g(this));
            }
            if (this.f30723h == null) {
                ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.f30723h = ofFloat3;
                ofFloat3.setDuration(450L);
                this.f30723h.addUpdateListener(new h(this));
            }
            if (this.i == null) {
                ValueAnimator ofFloat4 = ValueAnimator.ofFloat(0.0f, 101.0f);
                this.i = ofFloat4;
                ofFloat4.setDuration(400L);
                this.i.addUpdateListener(new i(this));
                this.i.addListener(new j(this));
            }
            if (this.n == null) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.n = animatorSet;
                animatorSet.play(this.f30721f).with(this.f30722g).with(this.f30723h).before(this.i);
            }
            this.n.start();
            setClickable(false);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && getVisibility() == 0 && this.p) {
            if (this.j == null) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(-45.0f, 6.0f, -4.0f, 0.0f);
                this.j = ofFloat;
                ofFloat.setDuration(700L);
                this.j.addUpdateListener(new k(this));
                this.j.addListener(new l(this));
            }
            if (this.k == null) {
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.5f, 1.0f);
                this.k = ofFloat2;
                ofFloat2.setDuration(450L);
                this.k.addUpdateListener(new a(this));
            }
            if (this.l == null) {
                ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.l = ofFloat3;
                ofFloat3.setDuration(450L);
                this.l.addUpdateListener(new b(this));
            }
            if (this.m == null) {
                ValueAnimator ofFloat4 = ValueAnimator.ofFloat(101.0f, 0.0f);
                this.m = ofFloat4;
                ofFloat4.setDuration(400L);
                this.m.addUpdateListener(new c(this));
            }
            if (this.o == null) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.o = animatorSet;
                animatorSet.play(this.j).after(this.m).with(this.l).with(this.k);
            }
            this.o.start();
            setClickable(false);
        }
    }

    public void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d05f3, (ViewGroup) this, true);
            this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f0909c9);
            this.f30717b = (TextView) findViewById(R.id.obfuscated_res_0x7f0911bb);
            SkinManager.setImageResource(this.a, R.drawable.obfuscated_res_0x7f0805f9);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f0909cf);
            this.f30718c = tbImageView;
            tbImageView.setAutoChangeStyle(true);
            this.f30718c.setEvent(new e(this));
        }
    }

    public boolean l(c.a.o0.s.c.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar)) == null) ? fVar.n == 2 || fVar.b() : invokeL.booleanValue;
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f30718c.invalidate();
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.a, R.drawable.obfuscated_res_0x7f0805f9, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f30717b, R.color.CAM_X0112, 1);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.q = true;
            h();
            removeCallbacks(this.t);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.q = false;
            postDelayed(this.t, 1600L);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.p = true;
            removeCallbacks(this.t);
        }
    }

    public void s(c.a.o0.s.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, fVar) == null) {
            c.a.p0.b2.o.h.c.g(fVar);
        }
    }

    public void setAutoCompleteShown(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.r = z;
        }
    }

    public void setData(c.a.o0.s.c.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, fVar) == null) || fVar == null || this.s || m.isEmpty(fVar.f11194b)) {
            return;
        }
        if (l(fVar)) {
            this.f30717b.setVisibility(0);
        } else {
            this.f30717b.setVisibility(4);
        }
        this.f30718c.setVisibility(0);
        this.f30718c.J(fVar.f11194b, 45, false);
        w(fVar);
        this.s = true;
    }

    public void setFeedBackListener(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) || (imageView = this.a) == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void setHomePbFloatLastCloseTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            c.a.o0.r.j0.b.k().x("key_tab_right_float_layer_view", System.currentTimeMillis());
        }
    }

    public void setLogoListener(View.OnClickListener onClickListener) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) || (tbImageView = this.f30718c) == null) {
            return;
        }
        tbImageView.setOnClickListener(onClickListener);
    }

    public final void t(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048596, this, str, i2) == null) {
            c.a.p0.l3.m0.d.e("TIEBA_LAYER", str, 0, i2, "layer", null, null, null, null, null);
        }
    }

    public void u(c.a.o0.s.c.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, fVar) == null) || fVar == null) {
            return;
        }
        int i2 = fVar.n;
        String str = fVar.m;
        if (i2 == 2) {
            t(str, 7);
        }
        a(fVar, 1);
    }

    public final void v(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048598, this, str, i2) == null) {
            boolean z = i2 == 1000;
            c.a.p0.l3.m0.d.e("TIEBA_LAYER_DEEPLINK", str, 0, 706, z ? "APP" : "URL", null, z ? null : String.valueOf(i2), null, null, null);
        }
    }

    public void w(c.a.o0.s.c.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, fVar) == null) || fVar == null) {
            return;
        }
        if (fVar.n == 2) {
            t(fVar.m, 3);
            s(fVar);
        } else {
            ThirdStatisticHelper.sendReq(fVar.i);
        }
        b(fVar);
    }

    public void x(c.a.o0.s.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, fVar) == null) {
            c.a.p0.b2.o.h.c.h(fVar);
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
        this.f30719d = null;
        this.f30720e = null;
        this.p = false;
        this.q = false;
        this.r = true;
        this.s = false;
        this.t = new d(this);
        j(context);
    }
}
