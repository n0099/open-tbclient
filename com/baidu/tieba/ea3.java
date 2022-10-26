package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.jo2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashSet;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class ea3 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947727570, "Lcom/baidu/tieba/ea3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947727570, "Lcom/baidu/tieba/ea3;");
                return;
            }
        }
        boolean z = wj1.a;
        a = 0;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a;
        }
        return invokeV.intValue;
    }

    public static void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, jSONObject) != null) || jSONObject == null) {
            return;
        }
        jo2.a W = l33.K().q().W();
        String i = rc3.i(W.j0(), W.G());
        if (!jSONObject.has("appid")) {
            mg3.f(jSONObject, "appid", W.H());
        }
        if (!jSONObject.has("swan")) {
            mg3.f(jSONObject, "swan", i);
        }
        if (!jSONObject.has("appversion")) {
            mg3.f(jSONObject, "appversion", W.v1());
        }
        if (!jSONObject.has("swanNativeVersion")) {
            mg3.f(jSONObject, "swanNativeVersion", xj1.a());
        }
        if (!jSONObject.has("thirdversion")) {
            mg3.f(jSONObject, "thirdversion", W.w1());
        }
        if (l33.K().q().y0() && !jSONObject.has("isWebDowngrade")) {
            mg3.f(jSONObject, "isWebDowngrade", "1");
        }
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String o = eh3.o(str);
            if (TextUtils.isEmpty(o)) {
                return str;
            }
            HashSet hashSet = new HashSet();
            hashSet.add("bduss");
            hashSet.add("bduss".toUpperCase());
            String i = eh3.i(o, hashSet);
            String f = eh3.f(str);
            return f + "?" + i;
        }
        return (String) invokeL.objValue;
    }

    public static void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i) == null) {
            a = i;
        }
    }

    public static oa3 f(oa3 oa3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, oa3Var)) == null) {
            e(oa3Var, "isDownloading", String.valueOf(l33.K().q().F0() ? 1 : 0));
            return oa3Var;
        }
        return (oa3) invokeL.objValue;
    }

    public static oa3 g(oa3 oa3Var) {
        InterceptResult invokeL;
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, oa3Var)) == null) {
            if (c() == 2) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                str = "2";
            } else {
                str = "1";
            }
            e(oa3Var, "launchType", str);
            return oa3Var;
        }
        return (oa3) invokeL.objValue;
    }

    public static oa3 h(oa3 oa3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, oa3Var)) == null) {
            e(oa3Var, "packageState", String.valueOf(l33.K().q().E0()));
            return oa3Var;
        }
        return (oa3) invokeL.objValue;
    }

    public static oa3 i(oa3 oa3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, oa3Var)) == null) {
            e(oa3Var, "coreState", String.valueOf(ga2.B0()));
            return oa3Var;
        }
        return (oa3) invokeL.objValue;
    }

    public static oa3 e(oa3 oa3Var, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, oa3Var, str, obj)) == null) {
            if (oa3Var != null && !TextUtils.isEmpty(str)) {
                oa3Var.a(str, obj);
            }
            return oa3Var;
        }
        return (oa3) invokeLLL.objValue;
    }
}
