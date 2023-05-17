package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.du2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class da4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && f93.K().k() == 1 && !d()) {
            l23.p("startup").F(new UbcFlowEvent(str));
        }
    }

    public static void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, jSONArray) == null) && jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow p = l23.p("startup");
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
            g93 M = g93.M();
            if (M == null || (w = M.w()) == null) {
                return 0L;
            }
            fm2 S = w.S();
            if (!(S instanceof h54)) {
                return 0L;
            }
            return ((h54) S).f1();
        }
        return invokeV.longValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            g93 M = g93.M();
            if (M == null || (w = M.w()) == null) {
                return false;
            }
            fm2 S = w.S();
            if (!(S instanceof h54)) {
                return false;
            }
            return ((h54) S).j1();
        }
        return invokeV.booleanValue;
    }

    public static void e(String str, du2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, aVar) == null) && aVar != null && !d() && (P = aVar.P()) != null && P.getLong("page_display_flag_for_statistic") > 0) {
            long l = aVar.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            jg3 jg3Var = new jg3();
            jg3Var.a = zf3.n(aVar.G());
            jg3Var.f = aVar.H();
            jg3Var.c = aVar.T();
            jg3Var.b = "launch";
            jg3Var.e = "realcancel";
            jg3Var.q = String.valueOf(currentTimeMillis - l);
            jg3Var.a("reason", str);
            jg3Var.a("errorList", x94.c().d());
            jg3Var.d(P.getString("ubc"));
            zf3.onEvent(jg3Var);
            P.remove("page_display_flag_for_statistic");
        }
    }

    public static void f(du2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, aVar) == null) && aVar != null && d() && (P = aVar.P()) != null && P.getLong("page_display_flag_for_statistic") > 0) {
            long l = aVar.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            jg3 jg3Var = new jg3();
            jg3Var.a = zf3.n(aVar.G());
            jg3Var.f = aVar.H();
            jg3Var.c = aVar.T();
            jg3Var.b = "launch";
            jg3Var.e = "realsuccess";
            jg3Var.r = String.valueOf(currentTimeMillis - l);
            jg3Var.d(P.getString("ubc"));
            zf3.onEvent(jg3Var);
            P.remove("page_display_flag_for_statistic");
        }
    }
}
