package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.o32;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bx3 implements vs3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bx3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.vs3
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return ex3.b();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.vs3
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && b()) {
            SwanAppActivity activity = sp2.U().getActivity();
            if (activity != null) {
                activity.setRequestedOrientation(1);
            }
            sp2.U().W().g(true);
        }
    }

    @Override // com.baidu.tieba.vs3
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            o32 V = sp2.U().V();
            Context appContext = AppRuntime.getAppContext();
            if (V == null) {
                if (appContext != null) {
                    x33.f(appContext, R.string.obfuscated_res_0x7f0f01a6).G();
                    return;
                }
                return;
            }
            fu2 d = fu2.d(str, str);
            d.h(jSONObject.toString());
            o32.b i = V.i("adLanding");
            i.n(o32.g, o32.i);
            i.k("adLanding", d).b();
        }
    }

    @Override // com.baidu.tieba.vs3
    public boolean c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            return ex3.c(view2);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.vs3
    public boolean removeView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
            return ex3.d(view2);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.vs3
    public boolean d(View view2, pr3 pr3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, pr3Var)) == null) {
            return ex3.a(view2, new lu2(pr3Var.c(), pr3Var.d(), pr3Var.e(), pr3Var.b()));
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.vs3
    public boolean f(View view2, pr3 pr3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view2, pr3Var)) == null) {
            wl1 W = sp2.U().W();
            if (W != null && W.a(view2, new lu2(pr3Var.c(), pr3Var.d(), pr3Var.e(), pr3Var.b()))) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
