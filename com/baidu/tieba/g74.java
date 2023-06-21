package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class g74 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static long b;
    public static String c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947746821, "Lcom/baidu/tieba/g74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947746821, "Lcom/baidu/tieba/g74;");
                return;
            }
        }
        a = js1.a;
        b = 86400000L;
        c = "duration_permission_list";
    }

    public static void a(JsObject jsObject) {
        h74 h74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, jsObject) == null) {
            zb3 M = zb3.M();
            g42 g42Var = null;
            if (jsObject != null && M != null && b(M)) {
                if (a) {
                    Log.e("SwanGameDurationApi", "params is " + jsObject.toString());
                }
                g42 F = g42.F(jsObject);
                String B = F.B("swanGameId");
                if (!TextUtils.isEmpty(B)) {
                    hk3 a2 = nk3.a();
                    if (!c(Long.valueOf(a2.getLong(B + "_LastPause", 0L)), Long.valueOf(System.currentTimeMillis()))) {
                        a2.putLong(B + "_Duration", 0L);
                    }
                    h74Var = new h74();
                    h74Var.duration = a2.getLong(B + "_Duration", 0L);
                } else {
                    h74Var = null;
                }
                g42Var = F;
            } else {
                h74Var = null;
            }
            le4.call(g42Var, true, h74Var);
        }
    }

    public static boolean b(zb3 zb3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, zb3Var)) == null) {
            String string = nk3.a().getString(c, "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (zb3.g0().contains(jSONArray.optString(i))) {
                            return true;
                        }
                    }
                } catch (Exception e) {
                    if (a) {
                        e.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(Long l, Long l2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, l, l2)) == null) {
            if (l.longValue() / 86400000 == l2.longValue() / 86400000) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && j2 > j && zb3.M() != null && !TextUtils.isEmpty(zb3.g0())) {
            String g0 = zb3.g0();
            hk3 a2 = nk3.a();
            long j3 = a2.getLong(g0 + "_LastPause", 0L);
            long j4 = a2.getLong(g0 + "_Duration", 0L);
            if (c(Long.valueOf(j), Long.valueOf(j2))) {
                if (c(Long.valueOf(j3), Long.valueOf(j))) {
                    a2.putLong(g0 + "_Duration", (j4 + j2) - j);
                } else {
                    a2.putLong(g0 + "_Duration", j2 - j);
                }
            } else {
                a2.putLong(g0 + "_Duration", j2 % b);
            }
            a2.putLong(g0 + "_LastPause", System.currentTimeMillis());
        }
    }
}
