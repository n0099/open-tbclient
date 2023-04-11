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
import com.baidu.tieba.i32;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class h32<V extends View, M extends i32> extends j32<V, M> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppComponentContainerView a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ i32 c;

        public a(h32 h32Var, SwanAppComponentContainerView swanAppComponentContainerView, boolean z, i32 i32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var, swanAppComponentContainerView, Boolean.valueOf(z), i32Var};
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
            this.c = i32Var;
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
    public h32(@Nullable Context context, @NonNull M m) {
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
                super((Context) objArr2[0], (k32) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.j32
    @NonNull
    /* renamed from: I */
    public m42 k(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, m, m2)) == null) {
            m42 k = super.k(m, m2);
            if (m2.j != null && ((jSONObject = m.j) == null || !TextUtils.equals(jSONObject.toString(), m2.j.toString()))) {
                k.b(4);
            }
            return k;
        }
        return (m42) invokeLL.objValue;
    }

    public void Q(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048588, this, v, m) != null) || m.j == null) {
            return;
        }
        if (j32.h) {
            Log.d("Component-View", "renderBackground");
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(m.k);
        gradientDrawable.setCornerRadius(m.n);
        gradientDrawable.setStroke(m.l, m.m);
        v.setBackground(gradientDrawable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.j32
    /* renamed from: O */
    public void C(@NonNull V v, @NonNull M m, @NonNull m42 m42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, v, m, m42Var) == null) {
            super.C(v, m, m42Var);
            if (m42Var.a(4)) {
                R(v, m);
                Q(v, m);
                P(v, m);
            }
        }
    }

    @Nullable
    public final ValueAnimator F(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull i32 i32Var, @NonNull i32 i32Var2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppComponentContainerView, i32Var, i32Var2)) == null) {
            if (i32Var2.j != null) {
                float b = uk3.b(i32Var.j, NativeConstants.OPACITY, 1.0f);
                float b2 = uk3.b(i32Var2.j, NativeConstants.OPACITY, b);
                if (b != b2) {
                    return ObjectAnimator.ofFloat(swanAppComponentContainerView, Key.ALPHA, b, b2);
                }
            }
            return null;
        }
        return (ValueAnimator) invokeLLL.objValue;
    }

    public final AnimatorSet G(long j, @NonNull Interpolator interpolator, List<Animator> list) {
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
    public final ValueAnimator H(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull i32 i32Var, @NonNull i32 i32Var2, boolean z) {
        InterceptResult invokeCommon;
        int e;
        int e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{swanAppComponentContainerView, i32Var, i32Var2, Boolean.valueOf(z)})) == null) {
            ay2 ay2Var = i32Var.h;
            if (ay2Var == null || i32Var2.h == null) {
                return null;
            }
            if (z) {
                e = ay2Var.d();
            } else {
                e = ay2Var.e();
            }
            ay2 ay2Var2 = i32Var2.h;
            if (z) {
                e2 = ay2Var2.d();
            } else {
                e2 = ay2Var2.e();
            }
            if (e == e2) {
                return null;
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(e, e2);
            ofInt.addUpdateListener(new a(this, swanAppComponentContainerView, z, i32Var2));
            return ofInt;
        }
        return (ValueAnimator) invokeCommon.objValue;
    }

    public final boolean J() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!s(4) || !t() || (jSONObject = ((i32) n()).q) == null || TextUtils.isEmpty(jSONObject.optString("duration"))) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final Interpolator K(@NonNull String str) {
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

    public final boolean N(boolean z) {
        InterceptResult invokeZ;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            SwanAppComponentContainerView m = m();
            i32 i32Var = (i32) p();
            i32 i32Var2 = (i32) n();
            if (m == null || i32Var == null || (jSONObject = i32Var2.q) == null || TextUtils.isEmpty(jSONObject.optString("duration"))) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            if (z) {
                arrayList.add(H(m, i32Var, i32Var2, false));
                arrayList.add(H(m, i32Var, i32Var2, true));
            } else {
                arrayList.add(F(m, i32Var, i32Var2));
            }
            AnimatorSet G = G(i32Var2.r, K(i32Var2.s), arrayList);
            if (G != null) {
                G.start();
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public final boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return N(false);
        }
        return invokeV.booleanValue;
    }

    public final boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return N(true);
        }
        return invokeV.booleanValue;
    }

    public void P(@NonNull View view2, @NonNull M m) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, view2, m) != null) || m.j == null) {
            return;
        }
        if (j32.h) {
            Log.d("Component-View", "renderAlpha");
        }
        if (J()) {
            if (j32.h) {
                Log.d("Component-View", "renderAlpha with animation");
            }
            if (!L()) {
                u42.o("Component-View", "performAlphaUpdateAnimation fail");
                return;
            }
            return;
        }
        float f = m.p;
        if (f >= 0.0f && f <= 1.0f) {
            view2.setAlpha(f);
            return;
        }
        u42.o("Component-View", "alpha invalid: " + m.p);
    }

    public void R(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, v, m) != null) || m.j == null) {
            return;
        }
        if (j32.h) {
            Log.d("Component-View", "renderPadding");
        }
        JSONArray jSONArray = m.o;
        if (jSONArray == null) {
            return;
        }
        if (jSONArray.length() == 4) {
            v.setPadding(ll3.g((float) jSONArray.optDouble(3, 0.0d)), ll3.g((float) jSONArray.optDouble(0, 0.0d)), ll3.g((float) jSONArray.optDouble(1, 0.0d)), ll3.g((float) jSONArray.optDouble(2, 0.0d)));
            return;
        }
        u42.c("Component-View", "invalid padding array length: " + jSONArray.length());
    }
}
