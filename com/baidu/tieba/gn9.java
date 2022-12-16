package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.SimpleDateFormat;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes4.dex */
public class gn9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947799831, "Lcom/baidu/tieba/gn9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947799831, "Lcom/baidu/tieba/gn9;");
                return;
            }
        }
        new SimpleDateFormat("yyyy年MM月dd HH时mm分ss秒");
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str != null && str.trim().length() != 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i < 1000) {
                i = 1000;
            }
            return new Formatter(new StringBuilder(), Locale.getDefault()).format("%ds", Integer.valueOf(i / 1000)).toString();
        }
        return (String) invokeI.objValue;
    }
}
