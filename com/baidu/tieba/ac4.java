package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.aw2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ac4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && cb3.K().k() == 1 && !d()) {
            i43.p("startup").F(new UbcFlowEvent(str));
        }
    }

    public static void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, jSONArray) == null) && jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow p = i43.p("startup");
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
            db3 M = db3.M();
            if (M == null || (w = M.w()) == null) {
                return 0L;
            }
            co2 Q = w.Q();
            if (!(Q instanceof e74)) {
                return 0L;
            }
            return ((e74) Q).f1();
        }
        return invokeV.longValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            db3 M = db3.M();
            if (M == null || (w = M.w()) == null) {
                return false;
            }
            co2 Q = w.Q();
            if (!(Q instanceof e74)) {
                return false;
            }
            return ((e74) Q).j1();
        }
        return invokeV.booleanValue;
    }

    public static void e(String str, aw2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, aVar) == null) && aVar != null && !d() && (P = aVar.P()) != null && P.getLong("page_display_flag_for_statistic") > 0) {
            long l = aVar.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            gi3 gi3Var = new gi3();
            gi3Var.a = wh3.n(aVar.G());
            gi3Var.f = aVar.H();
            gi3Var.c = aVar.T();
            gi3Var.b = "launch";
            gi3Var.e = "realcancel";
            gi3Var.q = String.valueOf(currentTimeMillis - l);
            gi3Var.a("reason", str);
            gi3Var.a("errorList", ub4.c().d());
            gi3Var.d(P.getString("ubc"));
            wh3.onEvent(gi3Var);
            P.remove("page_display_flag_for_statistic");
        }
    }

    public static void f(aw2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, aVar) == null) && aVar != null && d() && (P = aVar.P()) != null && P.getLong("page_display_flag_for_statistic") > 0) {
            long l = aVar.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            gi3 gi3Var = new gi3();
            gi3Var.a = wh3.n(aVar.G());
            gi3Var.f = aVar.H();
            gi3Var.c = aVar.T();
            gi3Var.b = "launch";
            gi3Var.e = "realsuccess";
            gi3Var.r = String.valueOf(currentTimeMillis - l);
            gi3Var.d(P.getString("ubc"));
            wh3.onEvent(gi3Var);
            P.remove("page_display_flag_for_statistic");
        }
    }
}
