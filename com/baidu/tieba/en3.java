package com.baidu.tieba;

import android.util.Base64;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public final class en3 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static final String b;
    public static final String c;
    public static final String d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947740063, "Lcom/baidu/tieba/en3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947740063, "Lcom/baidu/tieba/en3;");
                return;
            }
        }
        a = a("b3Bwbw==");
        b = a("T1BQTw==");
        a("T3Bwbw==");
        c = a("cm8uYnVpbGQudmVyc2lvbi5vcHBvcm9t");
        d = a("Y29tLm9wcG8uZmVhdHVyZS5zY3JlZW4uaGV0ZXJvbW9ycGhpc20=");
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return new String(Base64.decode(str, 0));
        }
        return (String) invokeL.objValue;
    }
}
