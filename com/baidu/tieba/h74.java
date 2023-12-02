package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.hr2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && j63.K().k() == 1 && !d()) {
            pz2.p("startup").F(new UbcFlowEvent(str));
        }
    }

    public static void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, jSONArray) == null) && jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow p = pz2.p("startup");
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
            k63 M = k63.M();
            if (M == null || (w = M.w()) == null) {
                return 0L;
            }
            jj2 R = w.R();
            if (!(R instanceof l24)) {
                return 0L;
            }
            return ((l24) R).g1();
        }
        return invokeV.longValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            k63 M = k63.M();
            if (M == null || (w = M.w()) == null) {
                return false;
            }
            jj2 R = w.R();
            if (!(R instanceof l24)) {
                return false;
            }
            return ((l24) R).k1();
        }
        return invokeV.booleanValue;
    }

    public static void e(String str, hr2.a aVar) {
        Bundle Q;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, aVar) == null) && aVar != null && !d() && (Q = aVar.Q()) != null && Q.getLong("page_display_flag_for_statistic") > 0) {
            long k = aVar.k("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            nd3 nd3Var = new nd3();
            nd3Var.a = dd3.n(aVar.H());
            nd3Var.f = aVar.I();
            nd3Var.c = aVar.U();
            nd3Var.b = "launch";
            nd3Var.e = "realcancel";
            nd3Var.q = String.valueOf(currentTimeMillis - k);
            nd3Var.a("reason", str);
            nd3Var.a("errorList", b74.c().d());
            nd3Var.d(Q.getString("ubc"));
            dd3.onEvent(nd3Var);
            Q.remove("page_display_flag_for_statistic");
        }
    }

    public static void f(hr2.a aVar) {
        Bundle Q;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, aVar) == null) && aVar != null && d() && (Q = aVar.Q()) != null && Q.getLong("page_display_flag_for_statistic") > 0) {
            long k = aVar.k("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            nd3 nd3Var = new nd3();
            nd3Var.a = dd3.n(aVar.H());
            nd3Var.f = aVar.I();
            nd3Var.c = aVar.U();
            nd3Var.b = "launch";
            nd3Var.e = "realsuccess";
            nd3Var.r = String.valueOf(currentTimeMillis - k);
            nd3Var.d(Q.getString("ubc"));
            dd3.onEvent(nd3Var);
            Q.remove("page_display_flag_for_statistic");
        }
    }
}
