package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.q52;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dz3 implements xu3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public dz3() {
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

    @Override // com.baidu.tieba.xu3
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return gz3.b();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.xu3
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && b()) {
            SwanAppActivity activity = ur2.V().getActivity();
            if (activity != null) {
                activity.setRequestedOrientation(1);
            }
            ur2.V().X().g(true);
        }
    }

    @Override // com.baidu.tieba.xu3
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            q52 W = ur2.V().W();
            Context appContext = AppRuntime.getAppContext();
            if (W == null) {
                if (appContext != null) {
                    z53.f(appContext, R.string.obfuscated_res_0x7f0f01dd).G();
                    return;
                }
                return;
            }
            hw2 d = hw2.d(str, str);
            d.h(jSONObject.toString());
            q52.b i = W.i("adLanding");
            i.n(q52.g, q52.i);
            i.k("adLanding", d).b();
        }
    }

    @Override // com.baidu.tieba.xu3
    public boolean c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            return gz3.c(view2);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.xu3
    public boolean removeView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
            return gz3.d(view2);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.xu3
    public boolean d(View view2, rt3 rt3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, rt3Var)) == null) {
            return gz3.a(view2, new nw2(rt3Var.c(), rt3Var.d(), rt3Var.e(), rt3Var.b()));
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.xu3
    public boolean f(View view2, rt3 rt3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view2, rt3Var)) == null) {
            zn1 X = ur2.V().X();
            if (X != null && X.a(view2, new nw2(rt3Var.c(), rt3Var.d(), rt3Var.e(), rt3Var.b()))) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
