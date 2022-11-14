package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.cp2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c54 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && e43.K().k() == 1 && !d()) {
            kx2.p("startup").F(new UbcFlowEvent(str));
        }
    }

    public static void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, jSONArray) == null) && jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow p = kx2.p("startup");
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
            f43 M = f43.M();
            if (M == null || (w = M.w()) == null) {
                return 0L;
            }
            eh2 Q = w.Q();
            if (!(Q instanceof g04)) {
                return 0L;
            }
            return ((g04) Q).f1();
        }
        return invokeV.longValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            f43 M = f43.M();
            if (M == null || (w = M.w()) == null) {
                return false;
            }
            eh2 Q = w.Q();
            if (!(Q instanceof g04)) {
                return false;
            }
            return ((g04) Q).j1();
        }
        return invokeV.booleanValue;
    }

    public static void e(String str, cp2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, aVar) == null) && aVar != null && !d() && (P = aVar.P()) != null && P.getLong("page_display_flag_for_statistic") > 0) {
            long l = aVar.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            ib3 ib3Var = new ib3();
            ib3Var.a = ya3.n(aVar.G());
            ib3Var.f = aVar.H();
            ib3Var.c = aVar.T();
            ib3Var.b = "launch";
            ib3Var.e = "realcancel";
            ib3Var.q = String.valueOf(currentTimeMillis - l);
            ib3Var.a("reason", str);
            ib3Var.a("errorList", w44.c().d());
            ib3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            ya3.onEvent(ib3Var);
            P.remove("page_display_flag_for_statistic");
        }
    }

    public static void f(cp2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, aVar) == null) && aVar != null && d() && (P = aVar.P()) != null && P.getLong("page_display_flag_for_statistic") > 0) {
            long l = aVar.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            ib3 ib3Var = new ib3();
            ib3Var.a = ya3.n(aVar.G());
            ib3Var.f = aVar.H();
            ib3Var.c = aVar.T();
            ib3Var.b = "launch";
            ib3Var.e = "realsuccess";
            ib3Var.r = String.valueOf(currentTimeMillis - l);
            ib3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            ya3.onEvent(ib3Var);
            P.remove("page_display_flag_for_statistic");
        }
    }
}
