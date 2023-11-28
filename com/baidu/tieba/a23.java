package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.dp2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes5.dex */
public class a23 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947563239, "Lcom/baidu/tieba/a23;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947563239, "Lcom/baidu/tieba/a23;");
                return;
            }
        }
        a = sm1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (list = dp2.q().list()) != null && list.length > 0) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    if4 if4Var = new if4();
                    if4Var.g = str;
                    if4Var.i = -1L;
                    ee4.i().f(if4Var);
                }
            }
            dp2.e.d();
        }
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && !TextUtils.isEmpty(str) && (s = dp2.s(str)) != null && (list = s.list()) != null && list.length > 1) {
            List<if4> q = o13.q(str);
            for (String str2 : list) {
                long j = -1;
                try {
                    j = Long.parseLong(str2);
                } catch (NumberFormatException e) {
                    if (a) {
                        z13.b(Log.getStackTraceString(e));
                    }
                }
                if (!c(j, q)) {
                    km4.L(dp2.t(str, str2));
                    z13.b("delete plugin name = " + str + " ; version = " + str2);
                }
            }
            if4 if4Var = null;
            if (q != null) {
                if (q.size() == 1) {
                    if4Var = q.get(0);
                } else if (q.size() >= 2) {
                    if4Var = q.get(1);
                }
            }
            if (if4Var != null) {
                ee4.i().f(if4Var);
            }
        }
    }

    public static boolean c(long j, List<if4> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    if4 if4Var = list.get(i);
                    if (if4Var != null && (j == if4Var.i || j == wj3.c(if4Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
