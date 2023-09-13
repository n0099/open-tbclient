package com.baidu.tbadk.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.RenderMode;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.mc5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class RightFloatLayerLottieView extends RightFloatLayerView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBLottieAnimationView A;
    public boolean B;
    public final Runnable C;
    public ImageView v;
    public TextView w;
    public View x;
    public TBLottieAnimationView y;
    public View z;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RightFloatLayerLottieView a;

        /* renamed from: com.baidu.tbadk.widget.RightFloatLayerLottieView$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0216a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0216a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    this.a.a.x.setVisibility(0);
                    this.a.a.z.setVisibility(8);
                    RightFloatLayerLottieView rightFloatLayerLottieView = this.a.a;
                    rightFloatLayerLottieView.D(rightFloatLayerLottieView.x, null, 0L);
                }
            }
        }

        public a(RightFloatLayerLottieView rightFloatLayerLottieView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerLottieView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rightFloatLayerLottieView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.z.getVisibility() == 0) {
                RightFloatLayerLottieView rightFloatLayerLottieView = this.a;
                rightFloatLayerLottieView.C(rightFloatLayerLottieView.z, new C0216a(this), 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RightFloatLayerLottieView a;

        /* loaded from: classes5.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, animator) != null) {
                    return;
                }
                this.a.a.B = false;
            }
        }

        public e(RightFloatLayerLottieView rightFloatLayerLottieView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerLottieView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rightFloatLayerLottieView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.x.setVisibility(8);
                this.a.z.setVisibility(0);
                RightFloatLayerLottieView rightFloatLayerLottieView = this.a;
                rightFloatLayerLottieView.D(rightFloatLayerLottieView.z, new a(this), 300L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements LottieListener<LottieComposition> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBLottieAnimationView a;
        public final /* synthetic */ RightFloatLayerLottieView b;

        public b(RightFloatLayerLottieView rightFloatLayerLottieView, TBLottieAnimationView tBLottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerLottieView, tBLottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rightFloatLayerLottieView;
            this.a = tBLottieAnimationView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lottieComposition) == null) {
                if (Build.VERSION.SDK_INT == 24) {
                    this.a.setRenderMode(RenderMode.SOFTWARE);
                } else {
                    this.a.setRenderMode(RenderMode.HARDWARE);
                }
                this.a.setRepeatCount(-1);
                this.a.enableMergePathsForKitKatAndAbove(true);
                this.a.setComposition(lottieComposition);
                RightFloatLayerLottieView rightFloatLayerLottieView = this.b;
                if (!rightFloatLayerLottieView.r) {
                    return;
                }
                rightFloatLayerLottieView.d();
                this.a.playAnimation();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements LottieListener<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RightFloatLayerLottieView a;

        public c(RightFloatLayerLottieView rightFloatLayerLottieView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerLottieView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rightFloatLayerLottieView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.a.c();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RightFloatLayerLottieView a;

        public d(RightFloatLayerLottieView rightFloatLayerLottieView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerLottieView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rightFloatLayerLottieView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.x.setVisibility(8);
                this.a.z.setVisibility(0);
                RightFloatLayerLottieView rightFloatLayerLottieView = this.a;
                rightFloatLayerLottieView.D(rightFloatLayerLottieView.z, null, 300L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ RightFloatLayerLottieView b;

        public f(RightFloatLayerLottieView rightFloatLayerLottieView, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerLottieView, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rightFloatLayerLottieView;
            this.a = view2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ RightFloatLayerLottieView b;

        public g(RightFloatLayerLottieView rightFloatLayerLottieView, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerLottieView, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rightFloatLayerLottieView;
            this.a = view2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ RightFloatLayerLottieView b;

        public h(RightFloatLayerLottieView rightFloatLayerLottieView, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerLottieView, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rightFloatLayerLottieView;
            this.a = view2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ RightFloatLayerLottieView b;

        public i(RightFloatLayerLottieView rightFloatLayerLottieView, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerLottieView, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rightFloatLayerLottieView;
            this.a = view2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RightFloatLayerLottieView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.B = false;
        this.C = new a(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RightFloatLayerLottieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.B = false;
        this.C = new a(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RightFloatLayerLottieView(Context context, AttributeSet attributeSet, int i2) {
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
        this.B = false;
        this.C = new a(this);
    }

    @NonNull
    public static RightFloatLayerView E(mc5 mc5Var, @NonNull Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, mc5Var, context)) == null) {
            if (mc5Var == null) {
                return new RightFloatLayerView(context);
            }
            if (mc5Var.c()) {
                return new RightFloatLayerLottieView(context);
            }
            return new RightFloatLayerView(context);
        }
        return (RightFloatLayerView) invokeLL.objValue;
    }

    public final void F(String str, TBLottieAnimationView tBLottieAnimationView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, tBLottieAnimationView) == null) {
            LottieCompositionFactory.fromUrl(getContext(), str).addFailureListener(new c(this)).addListener(new b(this, tBLottieAnimationView));
        }
    }

    public void G(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            postDelayed(this.C, i2);
        }
    }

    @Override // com.baidu.tbadk.widget.RightFloatLayerView
    public void setFeedBackListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            super.setFeedBackListener(onClickListener);
            ImageView imageView = this.v;
            if (imageView != null) {
                imageView.setOnClickListener(onClickListener);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.RightFloatLayerView
    public void setLogoListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            super.setLogoListener(onClickListener);
            TBLottieAnimationView tBLottieAnimationView = this.y;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.setOnClickListener(onClickListener);
            }
            TBLottieAnimationView tBLottieAnimationView2 = this.A;
            if (tBLottieAnimationView2 != null) {
                tBLottieAnimationView2.setOnClickListener(onClickListener);
            }
        }
    }

    public final void C(View view2, AnimatorListenerAdapter animatorListenerAdapter, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, animatorListenerAdapter, Long.valueOf(j)}) == null) && getVisibility() != 8 && view2.getVisibility() != 8) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, view2.getTranslationX());
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.setDuration(j);
            ofFloat.addUpdateListener(new f(this, view2));
            ofFloat2.setDuration(j);
            ofFloat2.addUpdateListener(new g(this, view2));
            AnimatorSet animatorSet = new AnimatorSet();
            if (animatorListenerAdapter != null) {
                animatorSet.addListener(animatorListenerAdapter);
            }
            animatorSet.play(ofFloat).with(ofFloat2);
            animatorSet.start();
        }
    }

    public final void D(View view2, AnimatorListenerAdapter animatorListenerAdapter, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, animatorListenerAdapter, Long.valueOf(j)}) == null) && getVisibility() != 8 && view2.getVisibility() != 8) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(view2.getTranslationX(), 0.0f);
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(j);
            ofFloat.addUpdateListener(new h(this, view2));
            ofFloat2.setDuration(j);
            ofFloat2.addUpdateListener(new i(this, view2));
            AnimatorSet animatorSet = new AnimatorSet();
            if (animatorListenerAdapter != null) {
                animatorSet.addListener(animatorListenerAdapter);
            }
            animatorSet.play(ofFloat).with(ofFloat2);
            animatorSet.start();
        }
    }

    @Override // com.baidu.tbadk.widget.RightFloatLayerView
    public void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            super.j(context);
            this.x = findViewById(R.id.float_picture_and_unfold_container);
            this.z = findViewById(R.id.float_fold_container);
            this.v = (ImageView) findViewById(R.id.float_layer_feedback_picture_fold);
            this.w = (TextView) findViewById(R.id.layer_ad_lable_icon_layout_fold);
            this.A = (TBLottieAnimationView) findViewById(R.id.float_layer_logo_lottie_fold);
            this.y = (TBLottieAnimationView) findViewById(R.id.float_layer_logo_lottie_unfold);
            SkinManager.setImageResource(this.v, R.drawable.ic_icon_popup_close_n);
            this.y.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.widget.RightFloatLayerView
    public void setData(mc5 mc5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, mc5Var) == null) && mc5Var != null && !this.s && !mc5Var.a()) {
            if (l(mc5Var)) {
                this.w.setVisibility(0);
            } else {
                this.b.setVisibility(4);
                this.w.setVisibility(4);
            }
            this.x.setVisibility(0);
            this.z.setVisibility(8);
            F(mc5Var.d, this.y);
            F(mc5Var.c, this.A);
            v(mc5Var);
            this.s = true;
        }
    }

    @Override // com.baidu.tbadk.widget.RightFloatLayerView
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            TBLottieAnimationView tBLottieAnimationView = this.A;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.invalidate();
            }
            TBLottieAnimationView tBLottieAnimationView2 = this.y;
            if (tBLottieAnimationView2 != null) {
                tBLottieAnimationView2.invalidate();
            }
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.a, R.drawable.ic_icon_popup_close_n, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.b, R.color.CAM_X0112, 1);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.v, R.drawable.ic_icon_popup_close_n, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0112, 1);
        }
    }

    @Override // com.baidu.tbadk.widget.RightFloatLayerView
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.q = true;
            removeCallbacks(this.C);
            if (this.z.getVisibility() == 0) {
                return;
            }
            this.B = true;
            C(this.x, new e(this), 400L);
        }
    }

    @Override // com.baidu.tbadk.widget.RightFloatLayerView
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.q = false;
            if (!this.B && this.z.getVisibility() != 8) {
                C(this.x, new d(this), 400L);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.RightFloatLayerView
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            removeCallbacks(this.C);
        }
    }
}
