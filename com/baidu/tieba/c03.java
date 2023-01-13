package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.fn2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes3.dex */
public class c03 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947620899, "Lcom/baidu/tieba/c03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947620899, "Lcom/baidu/tieba/c03;");
                return;
            }
        }
        a = tk1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (list = fn2.q().list()) != null && list.length > 0) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    kd4 kd4Var = new kd4();
                    kd4Var.g = str;
                    kd4Var.i = -1L;
                    gc4.i().f(kd4Var);
                }
            }
            fn2.e.d();
        }
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && !TextUtils.isEmpty(str) && (s = fn2.s(str)) != null && (list = s.list()) != null && list.length > 1) {
            List<kd4> q = qz2.q(str);
            for (String str2 : list) {
                long j = -1;
                try {
                    j = Long.parseLong(str2);
                } catch (NumberFormatException e) {
                    if (a) {
                        b03.b(Log.getStackTraceString(e));
                    }
                }
                if (!c(j, q)) {
                    nk4.L(fn2.t(str, str2));
                    b03.b("delete plugin name = " + str + " ; version = " + str2);
                }
            }
            kd4 kd4Var = null;
            if (q != null) {
                if (q.size() == 1) {
                    kd4Var = q.get(0);
                } else if (q.size() >= 2) {
                    kd4Var = q.get(1);
                }
            }
            if (kd4Var != null) {
                gc4.i().f(kd4Var);
            }
        }
    }

    public static boolean c(long j, List<kd4> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    kd4 kd4Var = list.get(i);
                    if (kd4Var != null && (j == kd4Var.i || j == yh3.c(kd4Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
