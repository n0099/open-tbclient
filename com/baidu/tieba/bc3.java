package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.mq2;
import com.baidu.tieba.xb3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final int b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947640119, "Lcom/baidu/tieba/bc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947640119, "Lcom/baidu/tieba/bc3;");
                return;
            }
        }
        a = am1.a;
        b = wo2.g0().u() * 1024;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (b > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str) || str.getBytes().length <= b) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (!c()) {
                return false;
            }
            boolean a2 = a(str);
            if (a2) {
                d(str);
            }
            return a2;
        }
        return invokeL.booleanValue;
    }

    public static void d(@NonNull String str) {
        p53 c0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) != null) || (c0 = p53.c0()) == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            mq2.a X = c0.X();
            SwanCoreVersion coreVersion = cr2.V().getCoreVersion();
            int k = c0.k();
            jSONObject.putOpt("scheme", X.X());
            jSONObject.putOpt("swanjs", ue3.i(coreVersion, k));
            if (str != null && str.length() > 1024) {
                jSONObject.putOpt("params", str.substring(0, 1024));
            }
            xb3.b bVar = new xb3.b(10020);
            bVar.j(jj3.n().e());
            bVar.i(jSONObject.toString());
            bVar.h(c0.getAppId());
            bVar.m();
            p22.k("SwanAppParamChecker", "10020, params: " + str);
        } catch (JSONException e) {
            if (a) {
                e.printStackTrace();
            }
        }
    }
}
