package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ga4 extends ba4<bs2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947787183, "Lcom/baidu/tieba/ga4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947787183, "Lcom/baidu/tieba/ga4;");
                return;
            }
        }
        boolean z = am1.a;
    }

    public ga4() {
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

    public static ga4 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new ga4();
        }
        return (ga4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ba4
    public boolean b(Context context, bs2 bs2Var, yr2 yr2Var, p53 p53Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, bs2Var, yr2Var, p53Var, jSONObject)) == null) {
            return e(context, bs2Var, yr2Var, p53Var, jSONObject);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, bs2 bs2Var, yr2 yr2Var, p53 p53Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bs2Var, yr2Var, p53Var, jSONObject)) == null) {
            p22.i("map", "GetRegionAction start");
            yr1 B = cr2.V().B(bs2Var.c);
            if (!(B instanceof wr1)) {
                p22.c("map", "WebViewManager is null");
                return false;
            }
            za4 d = y94.b().c((wr1) B).d(bs2Var.b);
            if (d == null) {
                p22.c("map", "can not find map by id " + bs2Var.b);
                return false;
            }
            MapStatus mapStatus = d.l.getMap().getMapStatus();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("latitude", mapStatus.bound.southwest.latitude);
                jSONObject3.put("longitude", mapStatus.bound.southwest.longitude);
                jSONObject2.put("latitude", mapStatus.bound.northeast.latitude);
                jSONObject2.put("longitude", mapStatus.bound.northeast.longitude);
                jSONObject.put("southwest", jSONObject3);
                jSONObject.put("northeast", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            p22.i("map", "GetRegionAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
