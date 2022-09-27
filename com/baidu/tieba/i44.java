package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.io2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && k33.K().k() == 1 && !d()) {
            qw2.p("startup").F(new UbcFlowEvent(str));
        }
    }

    public static void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, jSONArray) == null) || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        HybridUbcFlow p = qw2.p("startup");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("id");
                long optLong = optJSONObject.optLong("timestamp");
                if (!TextUtils.isEmpty(optString) && optJSONObject.has("timestamp")) {
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent(optString);
                    ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                    ubcFlowEvent.h(optLong);
                    p.F(ubcFlowEvent);
                }
            }
        }
    }

    public static long c() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            l33 M = l33.M();
            if (M == null || (w = M.w()) == null) {
                return 0L;
            }
            kg2 Q = w.Q();
            if (Q instanceof mz3) {
                return ((mz3) Q).f1();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            l33 M = l33.M();
            if (M == null || (w = M.w()) == null) {
                return false;
            }
            kg2 Q = w.Q();
            if (Q instanceof mz3) {
                return ((mz3) Q).j1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void e(String str, io2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, aVar) == null) || aVar == null || d() || (P = aVar.P()) == null || P.getLong("page_display_flag_for_statistic") <= 0) {
            return;
        }
        long l = aVar.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        oa3 oa3Var = new oa3();
        oa3Var.a = ea3.n(aVar.G());
        oa3Var.f = aVar.H();
        oa3Var.c = aVar.T();
        oa3Var.b = "launch";
        oa3Var.e = "realcancel";
        oa3Var.q = String.valueOf(currentTimeMillis - l);
        oa3Var.a("reason", str);
        oa3Var.a("errorList", c44.c().d());
        oa3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        ea3.onEvent(oa3Var);
        P.remove("page_display_flag_for_statistic");
    }

    public static void f(io2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, aVar) == null) || aVar == null || !d() || (P = aVar.P()) == null || P.getLong("page_display_flag_for_statistic") <= 0) {
            return;
        }
        long l = aVar.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        oa3 oa3Var = new oa3();
        oa3Var.a = ea3.n(aVar.G());
        oa3Var.f = aVar.H();
        oa3Var.c = aVar.T();
        oa3Var.b = "launch";
        oa3Var.e = "realsuccess";
        oa3Var.r = String.valueOf(currentTimeMillis - l);
        oa3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        ea3.onEvent(oa3Var);
        P.remove("page_display_flag_for_statistic");
    }
}
