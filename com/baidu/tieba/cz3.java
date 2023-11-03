package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.p52;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cz3 implements wu3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public cz3() {
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

    @Override // com.baidu.tieba.wu3
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return fz3.b();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.wu3
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && b()) {
            SwanAppActivity activity = tr2.V().getActivity();
            if (activity != null) {
                activity.setRequestedOrientation(1);
            }
            tr2.V().X().g(true);
        }
    }

    @Override // com.baidu.tieba.wu3
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            p52 W = tr2.V().W();
            Context appContext = AppRuntime.getAppContext();
            if (W == null) {
                if (appContext != null) {
                    y53.f(appContext, R.string.obfuscated_res_0x7f0f01d5).G();
                    return;
                }
                return;
            }
            gw2 d = gw2.d(str, str);
            d.h(jSONObject.toString());
            p52.b i = W.i("adLanding");
            i.n(p52.g, p52.i);
            i.k("adLanding", d).b();
        }
    }

    @Override // com.baidu.tieba.wu3
    public boolean c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            return fz3.c(view2);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.wu3
    public boolean removeView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
            return fz3.d(view2);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.wu3
    public boolean d(View view2, qt3 qt3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, qt3Var)) == null) {
            return fz3.a(view2, new mw2(qt3Var.c(), qt3Var.d(), qt3Var.e(), qt3Var.b()));
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.wu3
    public boolean f(View view2, qt3 qt3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view2, qt3Var)) == null) {
            yn1 X = tr2.V().X();
            if (X != null && X.a(view2, new mw2(qt3Var.c(), qt3Var.d(), qt3Var.e(), qt3Var.b()))) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
