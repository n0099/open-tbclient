package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d84 extends x74<xp2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947658409, "Lcom/baidu/tieba/d84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947658409, "Lcom/baidu/tieba/d84;");
                return;
            }
        }
        boolean z = vj1.a;
    }

    public d84() {
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

    public static d84 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new d84() : (d84) invokeV.objValue;
    }

    @Override // com.baidu.tieba.x74
    public boolean b(Context context, xp2 xp2Var, up2 up2Var, l33 l33Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, xp2Var, up2Var, l33Var, jSONObject)) == null) ? e(context, xp2Var, up2Var, l33Var, jSONObject) : invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, xp2 xp2Var, up2 up2Var, l33 l33Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, xp2Var, up2Var, l33Var, jSONObject)) == null) {
            l02.i("map", "GetScaleAction start");
            tp1 A = yo2.U().A(xp2Var.c);
            if (!(A instanceof rp1)) {
                l02.c("map", "WebViewManager is null");
                return false;
            }
            v84 d = u74.b().c((rp1) A).d(xp2Var.b);
            if (d == null) {
                l02.c("map", "can not find map by id " + xp2Var.b);
                return false;
            }
            try {
                jSONObject.put("scale", d.l.getMap().getMapStatus().zoom);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            l02.i("map", "GetScaleAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
