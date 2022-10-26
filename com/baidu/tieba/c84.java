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
public class c84 extends y74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947628618, "Lcom/baidu/tieba/c84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947628618, "Lcom/baidu/tieba/c84;");
                return;
            }
        }
        boolean z = wj1.a;
    }

    public c84() {
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

    public static c84 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new c84();
        }
        return (c84) invokeV.objValue;
    }

    @Override // com.baidu.tieba.y74
    public boolean b(Context context, yp2 yp2Var, vp2 vp2Var, m33 m33Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, yp2Var, vp2Var, m33Var, jSONObject)) == null) {
            return e(context, yp2Var, vp2Var, m33Var, jSONObject);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, yp2 yp2Var, vp2 vp2Var, m33 m33Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, yp2Var, vp2Var, m33Var, jSONObject)) == null) {
            m02.i("map", "GetCenterLcationAction start");
            up1 A = zo2.U().A(yp2Var.c);
            if (!(A instanceof sp1)) {
                m02.c("map", "WebViewManager is null");
                return false;
            }
            w84 d = v74.b().c((sp1) A).d(yp2Var.b);
            if (d == null) {
                m02.c("map", "can not find map by id " + yp2Var.b);
                return false;
            }
            MapStatus mapStatus = d.l.getMap().getMapStatus();
            fq2 fq2Var = new fq2();
            LatLng latLng = mapStatus.target;
            double d2 = latLng.latitude;
            fq2Var.a = d2;
            fq2Var.b = latLng.longitude;
            try {
                jSONObject.put("latitude", d2);
                jSONObject.put("longitude", fq2Var.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            m02.i("map", "GetCenterLocationAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
