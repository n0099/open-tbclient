package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.LatLng;
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
public class ab4 extends wa4<ws2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947609398, "Lcom/baidu/tieba/ab4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947609398, "Lcom/baidu/tieba/ab4;");
                return;
            }
        }
        boolean z = vm1.a;
    }

    public ab4() {
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

    public static ab4 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new ab4();
        }
        return (ab4) invokeV.objValue;
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
            k32.i("map", "GetCenterLcationAction start");
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
            MapStatus mapStatus = d.l.getMap().getMapStatus();
            dt2 dt2Var = new dt2();
            LatLng latLng = mapStatus.target;
            double d2 = latLng.latitude;
            dt2Var.a = d2;
            dt2Var.b = latLng.longitude;
            try {
                jSONObject.put("latitude", d2);
                jSONObject.put("longitude", dt2Var.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            k32.i("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
