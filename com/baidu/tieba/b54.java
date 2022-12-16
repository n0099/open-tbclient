package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.bp2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b54 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && d43.K().k() == 1 && !d()) {
            jx2.p("startup").F(new UbcFlowEvent(str));
        }
    }

    public static void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, jSONArray) == null) && jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow p = jx2.p("startup");
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
    }

    public static long c() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            e43 M = e43.M();
            if (M == null || (w = M.w()) == null) {
                return 0L;
            }
            dh2 Q = w.Q();
            if (!(Q instanceof f04)) {
                return 0L;
            }
            return ((f04) Q).f1();
        }
        return invokeV.longValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            e43 M = e43.M();
            if (M == null || (w = M.w()) == null) {
                return false;
            }
            dh2 Q = w.Q();
            if (!(Q instanceof f04)) {
                return false;
            }
            return ((f04) Q).j1();
        }
        return invokeV.booleanValue;
    }

    public static void e(String str, bp2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, aVar) == null) && aVar != null && !d() && (P = aVar.P()) != null && P.getLong("page_display_flag_for_statistic") > 0) {
            long l = aVar.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            hb3 hb3Var = new hb3();
            hb3Var.a = xa3.n(aVar.G());
            hb3Var.f = aVar.H();
            hb3Var.c = aVar.T();
            hb3Var.b = "launch";
            hb3Var.e = "realcancel";
            hb3Var.q = String.valueOf(currentTimeMillis - l);
            hb3Var.a("reason", str);
            hb3Var.a("errorList", v44.c().d());
            hb3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            xa3.onEvent(hb3Var);
            P.remove("page_display_flag_for_statistic");
        }
    }

    public static void f(bp2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, aVar) == null) && aVar != null && d() && (P = aVar.P()) != null && P.getLong("page_display_flag_for_statistic") > 0) {
            long l = aVar.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            hb3 hb3Var = new hb3();
            hb3Var.a = xa3.n(aVar.G());
            hb3Var.f = aVar.H();
            hb3Var.c = aVar.T();
            hb3Var.b = "launch";
            hb3Var.e = "realsuccess";
            hb3Var.r = String.valueOf(currentTimeMillis - l);
            hb3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            xa3.onEvent(hb3Var);
            P.remove("page_display_flag_for_statistic");
        }
    }
}
