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
/* loaded from: classes3.dex */
public class ce4 extends yd4<yv2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947671863, "Lcom/baidu/tieba/ce4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947671863, "Lcom/baidu/tieba/ce4;");
                return;
            }
        }
        boolean z = wp1.a;
    }

    public ce4() {
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

    public static ce4 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new ce4();
        }
        return (ce4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yd4
    public boolean b(Context context, yv2 yv2Var, vv2 vv2Var, m93 m93Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, yv2Var, vv2Var, m93Var, jSONObject)) == null) {
            return e(context, yv2Var, vv2Var, m93Var, jSONObject);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, yv2 yv2Var, vv2 vv2Var, m93 m93Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, yv2Var, vv2Var, m93Var, jSONObject)) == null) {
            m62.i("map", "GetCenterLcationAction start");
            uv1 A = zu2.U().A(yv2Var.c);
            if (!(A instanceof sv1)) {
                m62.c("map", "WebViewManager is null");
                return false;
            }
            we4 d = vd4.b().c((sv1) A).d(yv2Var.b);
            if (d == null) {
                m62.c("map", "can not find map by id " + yv2Var.b);
                return false;
            }
            MapStatus mapStatus = d.l.getMap().getMapStatus();
            fw2 fw2Var = new fw2();
            LatLng latLng = mapStatus.target;
            double d2 = latLng.latitude;
            fw2Var.a = d2;
            fw2Var.b = latLng.longitude;
            try {
                jSONObject.put("latitude", d2);
                jSONObject.put("longitude", fw2Var.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            m62.i("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
