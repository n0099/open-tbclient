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
public class c74 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static long b;
    public static String c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947627657, "Lcom/baidu/tieba/c74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947627657, "Lcom/baidu/tieba/c74;");
                return;
            }
        }
        a = fs1.a;
        b = 86400000L;
        c = "duration_permission_list";
    }

    public static void a(JsObject jsObject) {
        d74 d74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, jsObject) == null) {
            vb3 M = vb3.M();
            c42 c42Var = null;
            if (jsObject != null && M != null && b(M)) {
                if (a) {
                    Log.e("SwanGameDurationApi", "params is " + jsObject.toString());
                }
                c42 F = c42.F(jsObject);
                String B = F.B("swanGameId");
                if (!TextUtils.isEmpty(B)) {
                    dk3 a2 = jk3.a();
                    if (!c(Long.valueOf(a2.getLong(B + "_LastPause", 0L)), Long.valueOf(System.currentTimeMillis()))) {
                        a2.putLong(B + "_Duration", 0L);
                    }
                    d74Var = new d74();
                    d74Var.duration = a2.getLong(B + "_Duration", 0L);
                } else {
                    d74Var = null;
                }
                c42Var = F;
            } else {
                d74Var = null;
            }
            he4.call(c42Var, true, d74Var);
        }
    }

    public static boolean b(vb3 vb3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, vb3Var)) == null) {
            String string = jk3.a().getString(c, "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (vb3.g0().contains(jSONArray.optString(i))) {
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
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && j2 > j && vb3.M() != null && !TextUtils.isEmpty(vb3.g0())) {
            String g0 = vb3.g0();
            dk3 a2 = jk3.a();
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
