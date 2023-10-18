package com.baidu.tieba;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tieba.da;
import com.baidu.tieba.pb.databinding.BotGuideViewBinding;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
/* loaded from: classes6.dex */
public final class he9 {
    public static /* synthetic */ Interceptable $ic;
    public static final he9 a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947820973, "Lcom/baidu/tieba/he9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947820973, "Lcom/baidu/tieba/he9;");
                return;
            }
        }
        a = new he9();
    }

    /* loaded from: classes6.dex */
    public static final class b implements da.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Ref.ObjectRef<View> a;
        public final /* synthetic */ Ref.ObjectRef<ObjectAnimator> b;
        public final /* synthetic */ float c;

        /* loaded from: classes6.dex */
        public static final class a implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Ref.ObjectRef a;

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                }
            }

            public a(Ref.ObjectRef objectRef) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {objectRef};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = objectRef;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    ((ObjectAnimator) this.a.element).start();
                }
            }
        }

        public b(Ref.ObjectRef<View> objectRef, Ref.ObjectRef<ObjectAnimator> objectRef2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {objectRef, objectRef2, Float.valueOf(f)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = objectRef;
            this.b = objectRef2;
            this.c = f;
        }

        @Override // com.baidu.tieba.da.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                he9 he9Var = he9.a;
                he9.b = false;
            }
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [T, android.animation.ObjectAnimator, java.lang.Object] */
        @Override // com.baidu.tieba.da.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                he9 he9Var = he9.a;
                he9.b = true;
                View view2 = this.a.element;
                View view3 = view2;
                if (view3 != null) {
                    Ref.ObjectRef<ObjectAnimator> objectRef = this.b;
                    float f = this.c;
                    ?? ofFloat = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, 0.0f, 5.0f, 0.0f);
                    Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(contentView, \"translationY\", 0F, 5F, 0F)");
                    objectRef.element = ofFloat;
                    ((ObjectAnimator) ofFloat).setRepeatMode(2);
                    objectRef.element.setDuration(1000L);
                    objectRef.element.setStartDelay(100L);
                    objectRef.element.setInterpolator(new LinearInterpolator());
                    objectRef.element.setRepeatCount(-1);
                    ValueAnimator b = he9.a.b(view3, 0.0f, 1.0f, f, 0.0f, 250L);
                    b.addListener(new a(objectRef));
                    b.start();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;
        public final /* synthetic */ float c;

        public a(View view2, float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, Float.valueOf(f), Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = f;
            this.c = f2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                if (animatedValue != null) {
                    float floatValue = ((Float) animatedValue).floatValue();
                    View view2 = this.a;
                    view2.setPivotX(view2.getWidth() - this.b);
                    View view3 = this.a;
                    view3.setPivotY(view3.getHeight() - this.c);
                    this.a.setScaleX(floatValue);
                    this.a.setScaleY(floatValue);
                    this.a.setAlpha(floatValue);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements ba {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Ref.ObjectRef<View> b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        @Override // com.baidu.tieba.ba
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 2;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.ba
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 48;
            }
            return invokeV.intValue;
        }

        public c(String str, Ref.ObjectRef<View> objectRef, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, objectRef, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = objectRef;
            this.c = i;
            this.d = i2;
        }

        /* JADX WARN: Type inference failed for: r5v2, types: [T, android.widget.RelativeLayout, android.view.View, java.lang.Object] */
        @Override // com.baidu.tieba.ba
        public View c(LayoutInflater inflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, inflater)) == null) {
                Intrinsics.checkNotNullParameter(inflater, "inflater");
                BotGuideViewBinding c = BotGuideViewBinding.c(inflater, null, false);
                Intrinsics.checkNotNullExpressionValue(c, "inflate(inflater, null, false)");
                c.b.setBackgroundResource(R.drawable.obfuscated_res_0x7f080e18);
                EMManager.from(c.c).setTextSize(R.dimen.T_X07).setTextColor(R.color.CAM_X0119);
                c.c.setText(this.a);
                Ref.ObjectRef<View> objectRef = this.b;
                ?? r5 = c.b;
                objectRef.element = r5;
                Intrinsics.checkNotNullExpressionValue(r5, "binding.botGuideRoot");
                return r5;
            }
            return (View) invokeL.objValue;
        }

        @Override // com.baidu.tieba.ba
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return -this.c;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.ba
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.d;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ca a;
        public final /* synthetic */ ee9 b;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public d(ca caVar, ee9 ee9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {caVar, ee9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = caVar;
            this.b = ee9Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                ca caVar = this.a;
                if (caVar != null) {
                    caVar.d();
                }
                ee9 ee9Var = this.b;
                if (ee9Var != null) {
                    ee9Var.onDismiss();
                }
            }
        }
    }

    public he9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @JvmStatic
    public static final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b;
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            b = false;
        }
    }

    /* JADX WARN: Type inference failed for: r13v4, types: [T, android.animation.ObjectAnimator] */
    @JvmStatic
    public static final void e(String str, View view2, final BaseFragmentActivity baseFragmentActivity, final ee9 ee9Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, str, view2, baseFragmentActivity, ee9Var) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z && view2 != null && view2.getVisibility() == 0 && baseFragmentActivity != null) {
                da daVar = new da();
                daVar.k(view2);
                daVar.c(0);
                daVar.j(true);
                daVar.i(true);
                daVar.d(false);
                daVar.g(false);
                int dimens = BdUtilHelper.getDimens(baseFragmentActivity, R.dimen.tbds3);
                int dimens2 = BdUtilHelper.getDimens(baseFragmentActivity, R.dimen.tbds3);
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                final float abs = Math.abs(view2.getRight() - view2.getLeft()) / 2;
                final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = new ObjectAnimator();
                daVar.a(new c(str, objectRef, dimens, dimens2));
                daVar.h(new b(objectRef, objectRef2, abs));
                final ca b2 = daVar.b();
                b2.k(false);
                b2.l(true);
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ge9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            he9.f(ca.this, baseFragmentActivity, ee9Var, objectRef2, objectRef, abs);
                        }
                    }
                }, 1000L);
            }
        }
    }

    public static final void f(final ca caVar, BaseFragmentActivity baseFragmentActivity, final ee9 ee9Var, final Ref.ObjectRef shakeAnim, final Ref.ObjectRef contentView, final float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{caVar, baseFragmentActivity, ee9Var, shakeAnim, contentView, Float.valueOf(f)}) == null) {
            Intrinsics.checkNotNullParameter(shakeAnim, "$shakeAnim");
            Intrinsics.checkNotNullParameter(contentView, "$contentView");
            caVar.n(baseFragmentActivity, true);
            if (ee9Var != null) {
                ee9Var.onShow();
            }
            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.fe9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        he9.g(Ref.ObjectRef.this, contentView, caVar, ee9Var, f);
                    }
                }
            }, 4000L);
        }
    }

    public static final void g(Ref.ObjectRef shakeAnim, Ref.ObjectRef contentView, ca caVar, ee9 ee9Var, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{shakeAnim, contentView, caVar, ee9Var, Float.valueOf(f)}) == null) {
            Intrinsics.checkNotNullParameter(shakeAnim, "$shakeAnim");
            Intrinsics.checkNotNullParameter(contentView, "$contentView");
            ((ObjectAnimator) shakeAnim.element).cancel();
            View view2 = (View) contentView.element;
            if (view2 != null) {
                ValueAnimator b2 = a.b(view2, 1.0f, 0.0f, f, 0.0f, 250L);
                b2.addListener(new d(caVar, ee9Var));
                b2.start();
                return;
            }
            if (caVar != null) {
                caVar.d();
            }
            if (ee9Var != null) {
                ee9Var.onDismiss();
            }
        }
    }

    public final ValueAnimator b(View curView, float f, float f2, float f3, float f4, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{curView, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Long.valueOf(j)})) == null) {
            Intrinsics.checkNotNullParameter(curView, "curView");
            ValueAnimator sclevalue = ValueAnimator.ofFloat(f, f2);
            sclevalue.setDuration(j);
            sclevalue.addUpdateListener(new a(curView, f3, f4));
            Intrinsics.checkNotNullExpressionValue(sclevalue, "sclevalue");
            return sclevalue;
        }
        return (ValueAnimator) invokeCommon.objValue;
    }
}
