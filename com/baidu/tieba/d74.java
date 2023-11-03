package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.dr2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && f63.K().k() == 1 && !d()) {
            lz2.p("startup").F(new UbcFlowEvent(str));
        }
    }

    public static void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, jSONArray) == null) && jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow p = lz2.p("startup");
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
            g63 M = g63.M();
            if (M == null || (w = M.w()) == null) {
                return 0L;
            }
            fj2 R = w.R();
            if (!(R instanceof h24)) {
                return 0L;
            }
            return ((h24) R).g1();
        }
        return invokeV.longValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            g63 M = g63.M();
            if (M == null || (w = M.w()) == null) {
                return false;
            }
            fj2 R = w.R();
            if (!(R instanceof h24)) {
                return false;
            }
            return ((h24) R).k1();
        }
        return invokeV.booleanValue;
    }

    public static void e(String str, dr2.a aVar) {
        Bundle Q;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, aVar) == null) && aVar != null && !d() && (Q = aVar.Q()) != null && Q.getLong("page_display_flag_for_statistic") > 0) {
            long l = aVar.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            jd3 jd3Var = new jd3();
            jd3Var.a = zc3.n(aVar.H());
            jd3Var.f = aVar.I();
            jd3Var.c = aVar.U();
            jd3Var.b = "launch";
            jd3Var.e = "realcancel";
            jd3Var.q = String.valueOf(currentTimeMillis - l);
            jd3Var.a("reason", str);
            jd3Var.a("errorList", x64.c().d());
            jd3Var.d(Q.getString("ubc"));
            zc3.onEvent(jd3Var);
            Q.remove("page_display_flag_for_statistic");
        }
    }

    public static void f(dr2.a aVar) {
        Bundle Q;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, aVar) == null) && aVar != null && d() && (Q = aVar.Q()) != null && Q.getLong("page_display_flag_for_statistic") > 0) {
            long l = aVar.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            jd3 jd3Var = new jd3();
            jd3Var.a = zc3.n(aVar.H());
            jd3Var.f = aVar.I();
            jd3Var.c = aVar.U();
            jd3Var.b = "launch";
            jd3Var.e = "realsuccess";
            jd3Var.r = String.valueOf(currentTimeMillis - l);
            jd3Var.d(Q.getString("ubc"));
            zc3.onEvent(jd3Var);
            Q.remove("page_display_flag_for_statistic");
        }
    }
}
