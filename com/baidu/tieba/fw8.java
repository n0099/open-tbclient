package com.baidu.tieba;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fw8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Animation.AnimationListener a;
        public final /* synthetic */ View b;

        public a(Animation.AnimationListener animationListener, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {animationListener, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = animationListener;
            this.b = view2;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                Animation.AnimationListener animationListener = this.a;
                if (animationListener != null) {
                    animationListener.onAnimationEnd(animation);
                }
                View view2 = this.b;
                if (view2 != null) {
                    view2.clearAnimation();
                    this.b.setVisibility(0);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) && (animationListener = this.a) != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) && (animationListener = this.a) != null) {
                animationListener.onAnimationStart(animation);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Animation.AnimationListener a;
        public final /* synthetic */ View b;

        public b(Animation.AnimationListener animationListener, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {animationListener, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = animationListener;
            this.b = view2;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                Animation.AnimationListener animationListener = this.a;
                if (animationListener != null) {
                    animationListener.onAnimationEnd(animation);
                }
                View view2 = this.b;
                if (view2 != null) {
                    view2.clearAnimation();
                    this.b.setVisibility(8);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) && (animationListener = this.a) != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) && (animationListener = this.a) != null) {
                animationListener.onAnimationStart(animation);
            }
        }
    }

    public static void a(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65536, null, view2, i) == null) {
            b(view2, i, null);
        }
    }

    public static void c(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, view2, i) == null) {
            d(view2, i, null);
        }
    }

    public static void b(View view2, int i, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65537, null, view2, i, animationListener) == null) && view2 != null && i >= 0) {
            view2.clearAnimation();
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(i);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setAnimationListener(new b(animationListener, view2));
            view2.setVisibility(8);
            view2.startAnimation(alphaAnimation);
        }
    }

    public static void d(View view2, int i, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65539, null, view2, i, animationListener) == null) && view2 != null && i >= 0) {
            view2.clearAnimation();
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(i);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setAnimationListener(new a(animationListener, view2));
            view2.setVisibility(0);
            view2.startAnimation(alphaAnimation);
        }
    }
}
