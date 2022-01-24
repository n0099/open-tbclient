package com.baidu.tbadk.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class RightFloatLayerLottieView extends RightFloatLayerView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView r;
    public TextView s;
    public View t;
    public TBLottieAnimationView u;
    public View v;
    public TBLottieAnimationView w;
    public boolean x;
    public final Runnable y;

    /* loaded from: classes11.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerLottieView f41219e;

        /* renamed from: com.baidu.tbadk.widget.RightFloatLayerLottieView$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class C1903a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f41220e;

            public C1903a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f41220e = aVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    this.f41220e.f41219e.t.setVisibility(0);
                    this.f41220e.f41219e.v.setVisibility(8);
                    RightFloatLayerLottieView rightFloatLayerLottieView = this.f41220e.f41219e;
                    rightFloatLayerLottieView.l(rightFloatLayerLottieView.t, null, 0L);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41219e = rightFloatLayerLottieView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f41219e.v.getVisibility() == 0) {
                RightFloatLayerLottieView rightFloatLayerLottieView = this.f41219e;
                rightFloatLayerLottieView.k(rightFloatLayerLottieView.v, new C1903a(this), 0L);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements LottieListener<LottieComposition> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBLottieAnimationView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerLottieView f41221b;

        public b(RightFloatLayerLottieView rightFloatLayerLottieView, TBLottieAnimationView tBLottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerLottieView, tBLottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41221b = rightFloatLayerLottieView;
            this.a = tBLottieAnimationView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lottieComposition) == null) {
                this.a.setRenderMode(RenderMode.HARDWARE);
                this.a.setRepeatCount(-1);
                this.a.enableMergePathsForKitKatAndAbove(true);
                this.a.setComposition(lottieComposition);
                RightFloatLayerLottieView rightFloatLayerLottieView = this.f41221b;
                if (rightFloatLayerLottieView.isAutoCompleteShown) {
                    rightFloatLayerLottieView.completeShow();
                    this.a.playAnimation();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.completeHide();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerLottieView f41222e;

        public d(RightFloatLayerLottieView rightFloatLayerLottieView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerLottieView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41222e = rightFloatLayerLottieView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f41222e.t.setVisibility(8);
                this.f41222e.v.setVisibility(0);
                RightFloatLayerLottieView rightFloatLayerLottieView = this.f41222e;
                rightFloatLayerLottieView.l(rightFloatLayerLottieView.v, null, 300L);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerLottieView f41223e;

        /* loaded from: classes11.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f41224e;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f41224e = eVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    this.f41224e.f41223e.x = false;
                }
            }
        }

        public e(RightFloatLayerLottieView rightFloatLayerLottieView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerLottieView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41223e = rightFloatLayerLottieView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f41223e.t.setVisibility(8);
                this.f41223e.v.setVisibility(0);
                RightFloatLayerLottieView rightFloatLayerLottieView = this.f41223e;
                rightFloatLayerLottieView.l(rightFloatLayerLottieView.v, new a(this), 300L);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f41225e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerLottieView f41226f;

        public f(RightFloatLayerLottieView rightFloatLayerLottieView, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerLottieView, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41226f = rightFloatLayerLottieView;
            this.f41225e = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f41225e.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes11.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f41227e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerLottieView f41228f;

        public g(RightFloatLayerLottieView rightFloatLayerLottieView, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerLottieView, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41228f = rightFloatLayerLottieView;
            this.f41227e = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f41227e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes11.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f41229e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerLottieView f41230f;

        public h(RightFloatLayerLottieView rightFloatLayerLottieView, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerLottieView, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41230f = rightFloatLayerLottieView;
            this.f41229e = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f41229e.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes11.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f41231e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RightFloatLayerLottieView f41232f;

        public i(RightFloatLayerLottieView rightFloatLayerLottieView, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightFloatLayerLottieView, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41232f = rightFloatLayerLottieView;
            this.f41231e = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f41231e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
        this.x = false;
        this.y = new a(this);
    }

    @NonNull
    public static RightFloatLayerView getRightFloatView(c.a.s0.t.c.g gVar, @NonNull Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, gVar, context)) == null) {
            if (gVar == null) {
                return new RightFloatLayerView(context);
            }
            if (gVar.c()) {
                return new RightFloatLayerLottieView(context);
            }
            return new RightFloatLayerView(context);
        }
        return (RightFloatLayerView) invokeLL.objValue;
    }

    @Override // com.baidu.tbadk.widget.RightFloatLayerView
    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            super.init(context);
            this.t = findViewById(R.id.float_picture_and_unfold_container);
            this.v = findViewById(R.id.float_fold_container);
            this.r = (ImageView) findViewById(R.id.float_layer_feedback_picture_fold);
            this.s = (TextView) findViewById(R.id.layer_ad_lable_icon_layout_fold);
            this.w = (TBLottieAnimationView) findViewById(R.id.float_layer_logo_lottie_fold);
            this.u = (TBLottieAnimationView) findViewById(R.id.float_layer_logo_lottie_unfold);
            SkinManager.setImageResource(this.r, R.drawable.ic_icon_popup_close_n);
            this.u.setVisibility(0);
        }
    }

    public final void k(View view, AnimatorListenerAdapter animatorListenerAdapter, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, animatorListenerAdapter, Long.valueOf(j2)}) == null) || getVisibility() == 8 || view.getVisibility() == 8) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, view.getTranslationX());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(j2);
        ofFloat.addUpdateListener(new f(this, view));
        ofFloat2.setDuration(j2);
        ofFloat2.addUpdateListener(new g(this, view));
        AnimatorSet animatorSet = new AnimatorSet();
        if (animatorListenerAdapter != null) {
            animatorSet.addListener(animatorListenerAdapter);
        }
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
    }

    public final void l(View view, AnimatorListenerAdapter animatorListenerAdapter, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view, animatorListenerAdapter, Long.valueOf(j2)}) == null) || getVisibility() == 8 || view.getVisibility() == 8) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(view.getTranslationX(), 0.0f);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(j2);
        ofFloat.addUpdateListener(new h(this, view));
        ofFloat2.setDuration(j2);
        ofFloat2.addUpdateListener(new i(this, view));
        AnimatorSet animatorSet = new AnimatorSet();
        if (animatorListenerAdapter != null) {
            animatorSet.addListener(animatorListenerAdapter);
        }
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
    }

    public final void m(String str, TBLottieAnimationView tBLottieAnimationView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, tBLottieAnimationView) == null) {
            LottieCompositionFactory.fromUrl(getContext(), str).addFailureListener(new c(this)).addListener(new b(this, tBLottieAnimationView));
        }
    }

    @Override // com.baidu.tbadk.widget.RightFloatLayerView
    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TBLottieAnimationView tBLottieAnimationView = this.w;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.invalidate();
            }
            TBLottieAnimationView tBLottieAnimationView2 = this.u;
            if (tBLottieAnimationView2 != null) {
                tBLottieAnimationView2.invalidate();
            }
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.feedbackImageView, R.drawable.ic_icon_popup_close_n, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.mAdLableIcon, R.color.CAM_X0112, 1);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.r, R.drawable.ic_icon_popup_close_n, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0112, 1);
        }
    }

    public void onChangeStyleToUnFold(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            postDelayed(this.y, i2);
        }
    }

    @Override // com.baidu.tbadk.widget.RightFloatLayerView
    public void onScrollDragging() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.isDrag = true;
            removeCallbacks(this.y);
            if (this.v.getVisibility() == 0) {
                return;
            }
            this.x = true;
            k(this.t, new e(this), 400L);
        }
    }

    @Override // com.baidu.tbadk.widget.RightFloatLayerView
    public void onScrollIdle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.isDrag = false;
            if (this.x || this.v.getVisibility() == 8) {
                return;
            }
            k(this.t, new d(this), 400L);
        }
    }

    @Override // com.baidu.tbadk.widget.RightFloatLayerView
    public void onScrollSettling() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            removeCallbacks(this.y);
        }
    }

    @Override // com.baidu.tbadk.widget.RightFloatLayerView
    public void setData(c.a.s0.t.c.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, gVar) == null) || gVar == null || this.isFloatLayerShown || gVar.a()) {
            return;
        }
        if (isNeedShowAdIcon(gVar)) {
            this.s.setVisibility(0);
        } else {
            this.mAdLableIcon.setVisibility(4);
            this.s.setVisibility(4);
        }
        this.t.setVisibility(0);
        this.v.setVisibility(8);
        m(gVar.f13975h, this.u);
        m(gVar.f13974g, this.w);
        reportShowAd(gVar);
        this.isFloatLayerShown = true;
    }

    @Override // com.baidu.tbadk.widget.RightFloatLayerView
    public void setFeedBackListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            super.setFeedBackListener(onClickListener);
            ImageView imageView = this.r;
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
            TBLottieAnimationView tBLottieAnimationView = this.u;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.setOnClickListener(onClickListener);
            }
            TBLottieAnimationView tBLottieAnimationView2 = this.w;
            if (tBLottieAnimationView2 != null) {
                tBLottieAnimationView2.setOnClickListener(onClickListener);
            }
        }
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
        this.x = false;
        this.y = new a(this);
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
        this.x = false;
        this.y = new a(this);
    }
}
