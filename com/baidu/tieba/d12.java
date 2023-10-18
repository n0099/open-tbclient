package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.tieba.e12;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class d12<V extends View, M extends e12> extends f12<V, M> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppComponentContainerView a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ e12 c;

        public a(d12 d12Var, SwanAppComponentContainerView swanAppComponentContainerView, boolean z, e12 e12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d12Var, swanAppComponentContainerView, Boolean.valueOf(z), e12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppComponentContainerView;
            this.b = z;
            this.c = e12Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (this.b) {
                        marginLayoutParams.leftMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    } else {
                        marginLayoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    }
                    this.c.h.l(marginLayoutParams.leftMargin);
                    this.c.h.m(marginLayoutParams.topMargin);
                    this.a.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d12(@Nullable Context context, @NonNull M m) {
        super(context, m);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, m};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (g12) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.f12
    @NonNull
    /* renamed from: K */
    public h22 k(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, m, m2)) == null) {
            h22 k = super.k(m, m2);
            if (m2.j != null && ((jSONObject = m.j) == null || !TextUtils.equals(jSONObject.toString(), m2.j.toString()))) {
                k.b(4);
            }
            return k;
        }
        return (h22) invokeLL.objValue;
    }

    public void S(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048588, this, v, m) != null) || m.j == null) {
            return;
        }
        if (f12.h) {
            Log.d("Component-View", "renderBackground");
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(m.k);
        gradientDrawable.setCornerRadius(m.n);
        gradientDrawable.setStroke(m.l, m.m);
        v.setBackground(gradientDrawable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.f12
    /* renamed from: Q */
    public void D(@NonNull V v, @NonNull M m, @NonNull h22 h22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, v, m, h22Var) == null) {
            super.D(v, m, h22Var);
            if (h22Var.a(4)) {
                T(v, m);
                S(v, m);
                R(v, m);
            }
        }
    }

    @Nullable
    public final ValueAnimator H(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull e12 e12Var, @NonNull e12 e12Var2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppComponentContainerView, e12Var, e12Var2)) == null) {
            if (e12Var2.j != null) {
                float b = pi3.b(e12Var.j, NativeConstants.OPACITY, 1.0f);
                float b2 = pi3.b(e12Var2.j, NativeConstants.OPACITY, b);
                if (b != b2) {
                    return ObjectAnimator.ofFloat(swanAppComponentContainerView, Key.ALPHA, b, b2);
                }
            }
            return null;
        }
        return (ValueAnimator) invokeLLL.objValue;
    }

    public final AnimatorSet I(long j, @NonNull Interpolator interpolator, List<Animator> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), interpolator, list})) == null) {
            if (j <= 0 || list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Animator animator : list) {
                if (animator != null) {
                    arrayList.add(animator);
                }
            }
            if (arrayList.size() == 0) {
                return null;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(interpolator);
            animatorSet.setDuration(j);
            animatorSet.playTogether(arrayList);
            return animatorSet;
        }
        return (AnimatorSet) invokeCommon.objValue;
    }

    @Nullable
    public final ValueAnimator J(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull e12 e12Var, @NonNull e12 e12Var2, boolean z) {
        InterceptResult invokeCommon;
        int e;
        int e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{swanAppComponentContainerView, e12Var, e12Var2, Boolean.valueOf(z)})) == null) {
            vv2 vv2Var = e12Var.h;
            if (vv2Var == null || e12Var2.h == null) {
                return null;
            }
            if (z) {
                e = vv2Var.d();
            } else {
                e = vv2Var.e();
            }
            vv2 vv2Var2 = e12Var2.h;
            if (z) {
                e2 = vv2Var2.d();
            } else {
                e2 = vv2Var2.e();
            }
            if (e == e2) {
                return null;
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(e, e2);
            ofInt.addUpdateListener(new a(this, swanAppComponentContainerView, z, e12Var2));
            return ofInt;
        }
        return (ValueAnimator) invokeCommon.objValue;
    }

    public final boolean L() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!s(4) || !t() || (jSONObject = ((e12) n()).q) == null || TextUtils.isEmpty(jSONObject.optString("duration"))) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final Interpolator M(@NonNull String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            switch (str.hashCode()) {
                case -1965120668:
                    if (str.equals("ease-in")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1102672091:
                    if (str.equals(Easing.LINEAR_NAME)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -789192465:
                    if (str.equals("ease-out")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -361990811:
                    if (str.equals("ease-in-out")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 3105774:
                    if (str.equals("ease")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c != 3) {
                            return PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f);
                        }
                        return PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f);
                    }
                    return PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
                }
                return PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
            }
            return PathInterpolatorCompat.create(0.0f, 0.0f, 1.0f, 1.0f);
        }
        return (Interpolator) invokeL.objValue;
    }

    public final boolean P(boolean z) {
        InterceptResult invokeZ;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            SwanAppComponentContainerView m = m();
            e12 e12Var = (e12) p();
            e12 e12Var2 = (e12) n();
            if (m == null || e12Var == null || (jSONObject = e12Var2.q) == null || TextUtils.isEmpty(jSONObject.optString("duration"))) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            if (z) {
                arrayList.add(J(m, e12Var, e12Var2, false));
                arrayList.add(J(m, e12Var, e12Var2, true));
            } else {
                arrayList.add(H(m, e12Var, e12Var2));
            }
            AnimatorSet I = I(e12Var2.r, M(e12Var2.s), arrayList);
            if (I != null) {
                I.start();
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return P(false);
        }
        return invokeV.booleanValue;
    }

    public final boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return P(true);
        }
        return invokeV.booleanValue;
    }

    public void R(@NonNull View view2, @NonNull M m) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, view2, m) != null) || m.j == null) {
            return;
        }
        if (f12.h) {
            Log.d("Component-View", "renderAlpha");
        }
        if (L()) {
            if (f12.h) {
                Log.d("Component-View", "renderAlpha with animation");
            }
            if (!N()) {
                p22.o("Component-View", "performAlphaUpdateAnimation fail");
                return;
            }
            return;
        }
        float f = m.p;
        if (f >= 0.0f && f <= 1.0f) {
            view2.setAlpha(f);
            return;
        }
        p22.o("Component-View", "alpha invalid: " + m.p);
    }

    public void T(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, v, m) != null) || m.j == null) {
            return;
        }
        if (f12.h) {
            Log.d("Component-View", "renderPadding");
        }
        JSONArray jSONArray = m.o;
        if (jSONArray == null) {
            return;
        }
        if (jSONArray.length() == 4) {
            v.setPadding(gj3.g((float) jSONArray.optDouble(3, 0.0d)), gj3.g((float) jSONArray.optDouble(0, 0.0d)), gj3.g((float) jSONArray.optDouble(1, 0.0d)), gj3.g((float) jSONArray.optDouble(2, 0.0d)));
            return;
        }
        p22.c("Component-View", "invalid padding array length: " + jSONArray.length());
    }
}
