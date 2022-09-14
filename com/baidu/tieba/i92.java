package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.ul2;
import com.baidu.tieba.vn2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes4.dex */
public class i92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static Boolean b;
    public static int c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947808263, "Lcom/baidu/tieba/i92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947808263, "Lcom/baidu/tieba/i92;");
                return;
            }
        }
        a = ij1.a;
        fm2.g0().getSwitch("swan_naview_slave_preload_type", 0);
        c = 0;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!s92.U().r0()) {
                Log.w("NASlaveConfig", "v8 is not enabled");
                return false;
            } else if (fm2.F0().j(1)) {
                String c0 = s92.U().c0();
                if (TextUtils.isEmpty(c0)) {
                    Log.w("NASlaveConfig", "base path is not exists");
                    return false;
                } else if (!new File(c0, "slave-talos/index.js").isFile()) {
                    Log.w("NASlaveConfig", "talos-js file is not exists");
                    return false;
                } else if (a && xy2.Y()) {
                    return true;
                } else {
                    boolean z = c != 0;
                    if (a) {
                        Log.d("NASlaveConfig", "isNARenderEnabled canUseNA: " + z);
                    }
                    return z;
                }
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static int b(@Nullable n33 n33Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, n33Var)) == null) {
            if (n33Var == null || !d()) {
                return 0;
            }
            return "na".equals(n33Var.r) ? 1 : 0;
        }
        return invokeL.intValue;
    }

    public static int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null) {
                return 0;
            }
            if (str.contains("?")) {
                str = str.substring(0, str.indexOf("?"));
            }
            int b2 = b(lo2.U().f(str));
            if (a) {
                Log.d("NASlaveConfig", "getSlaveType pageUrl: " + str + " slaveType:" + b2);
            }
            return b2;
        }
        return invokeL.intValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            Boolean bool = b;
            if (bool != null) {
                return bool.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(a());
            b = valueOf;
            return valueOf.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? c == 2 : invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? c == 1 : invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? c == 3 : invokeV.booleanValue;
    }

    public static boolean h(y23 y23Var) {
        InterceptResult invokeL;
        vn2.a W;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, y23Var)) == null) {
            if (y23Var == null || !y23Var.E()) {
                return false;
            }
            if (xy2.B(y23Var.W())) {
                str = ul2.b.g().getPath() + File.separator;
            } else {
                str = ul2.e.i(W.H(), W.v1()).getPath() + File.separator;
            }
            if (a) {
                Log.d("NASlaveConfig", "手动解析的basePath: " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            lo2.U().K(str);
            return true;
        }
        return invokeL.booleanValue;
    }
}
