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
/* loaded from: classes5.dex */
public class cb4 extends wa4<ws2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947668980, "Lcom/baidu/tieba/cb4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947668980, "Lcom/baidu/tieba/cb4;");
                return;
            }
        }
        boolean z = vm1.a;
    }

    public cb4() {
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

    public static cb4 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new cb4();
        }
        return (cb4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wa4
    public boolean b(Context context, ws2 ws2Var, ts2 ts2Var, k63 k63Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, ws2Var, ts2Var, k63Var, jSONObject)) == null) {
            return e(context, ws2Var, ts2Var, k63Var, jSONObject);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, ws2 ws2Var, ts2 ts2Var, k63 k63Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ws2Var, ts2Var, k63Var, jSONObject)) == null) {
            k32.i("map", "GetScaleAction start");
            ts1 B = xr2.V().B(ws2Var.c);
            if (!(B instanceof rs1)) {
                k32.c("map", "WebViewManager is null");
                return false;
            }
            ub4 d = ta4.b().c((rs1) B).d(ws2Var.b);
            if (d == null) {
                k32.c("map", "can not find map by id " + ws2Var.b);
                return false;
            }
            try {
                jSONObject.put("scale", d.l.getMap().getMapStatus().zoom);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            k32.i("map", "GetScaleAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
