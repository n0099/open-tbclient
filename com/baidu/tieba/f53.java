package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.is2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes4.dex */
public class f53 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947715077, "Lcom/baidu/tieba/f53;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947715077, "Lcom/baidu/tieba/f53;");
                return;
            }
        }
        a = wp1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (list = is2.q().list()) != null && list.length > 0) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    ni4 ni4Var = new ni4();
                    ni4Var.g = str;
                    ni4Var.i = -1L;
                    jh4.i().f(ni4Var);
                }
            }
            is2.e.d();
        }
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && !TextUtils.isEmpty(str) && (s = is2.s(str)) != null && (list = s.list()) != null && list.length > 1) {
            List<ni4> q = t43.q(str);
            for (String str2 : list) {
                long j = -1;
                try {
                    j = Long.parseLong(str2);
                } catch (NumberFormatException e) {
                    if (a) {
                        e53.b(Log.getStackTraceString(e));
                    }
                }
                if (!c(j, q)) {
                    qp4.L(is2.t(str, str2));
                    e53.b("delete plugin name = " + str + " ; version = " + str2);
                }
            }
            ni4 ni4Var = null;
            if (q != null) {
                if (q.size() == 1) {
                    ni4Var = q.get(0);
                } else if (q.size() >= 2) {
                    ni4Var = q.get(1);
                }
            }
            if (ni4Var != null) {
                jh4.i().f(ni4Var);
            }
        }
    }

    public static boolean c(long j, List<ni4> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    ni4 ni4Var = list.get(i);
                    if (ni4Var != null && (j == ni4Var.i || j == bn3.c(ni4Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
