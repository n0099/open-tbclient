package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.ew2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ec4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && gb3.K().k() == 1 && !d()) {
            m43.p("startup").F(new UbcFlowEvent(str));
        }
    }

    public static void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, jSONArray) == null) && jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow p = m43.p("startup");
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
            hb3 M = hb3.M();
            if (M == null || (w = M.w()) == null) {
                return 0L;
            }
            go2 Q = w.Q();
            if (!(Q instanceof i74)) {
                return 0L;
            }
            return ((i74) Q).f1();
        }
        return invokeV.longValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            hb3 M = hb3.M();
            if (M == null || (w = M.w()) == null) {
                return false;
            }
            go2 Q = w.Q();
            if (!(Q instanceof i74)) {
                return false;
            }
            return ((i74) Q).j1();
        }
        return invokeV.booleanValue;
    }

    public static void e(String str, ew2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, aVar) == null) && aVar != null && !d() && (P = aVar.P()) != null && P.getLong("page_display_flag_for_statistic") > 0) {
            long l = aVar.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            ki3 ki3Var = new ki3();
            ki3Var.a = ai3.n(aVar.G());
            ki3Var.f = aVar.H();
            ki3Var.c = aVar.T();
            ki3Var.b = "launch";
            ki3Var.e = "realcancel";
            ki3Var.q = String.valueOf(currentTimeMillis - l);
            ki3Var.a("reason", str);
            ki3Var.a("errorList", yb4.c().d());
            ki3Var.d(P.getString("ubc"));
            ai3.onEvent(ki3Var);
            P.remove("page_display_flag_for_statistic");
        }
    }

    public static void f(ew2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, aVar) == null) && aVar != null && d() && (P = aVar.P()) != null && P.getLong("page_display_flag_for_statistic") > 0) {
            long l = aVar.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            ki3 ki3Var = new ki3();
            ki3Var.a = ai3.n(aVar.G());
            ki3Var.f = aVar.H();
            ki3Var.c = aVar.T();
            ki3Var.b = "launch";
            ki3Var.e = "realsuccess";
            ki3Var.r = String.valueOf(currentTimeMillis - l);
            ki3Var.d(P.getString("ubc"));
            ai3.onEvent(ki3Var);
            P.remove("page_display_flag_for_statistic");
        }
    }
}
