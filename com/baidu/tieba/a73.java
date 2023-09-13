package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.du2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes5.dex */
public class a73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947568044, "Lcom/baidu/tieba/a73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947568044, "Lcom/baidu/tieba/a73;");
                return;
            }
        }
        a = rr1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (list = du2.q().list()) != null && list.length > 0) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    ik4 ik4Var = new ik4();
                    ik4Var.g = str;
                    ik4Var.i = -1L;
                    ej4.i().f(ik4Var);
                }
            }
            du2.e.d();
        }
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && !TextUtils.isEmpty(str) && (s = du2.s(str)) != null && (list = s.list()) != null && list.length > 1) {
            List<ik4> q = o63.q(str);
            for (String str2 : list) {
                long j = -1;
                try {
                    j = Long.parseLong(str2);
                } catch (NumberFormatException e) {
                    if (a) {
                        z63.b(Log.getStackTraceString(e));
                    }
                }
                if (!c(j, q)) {
                    lr4.L(du2.t(str, str2));
                    z63.b("delete plugin name = " + str + " ; version = " + str2);
                }
            }
            ik4 ik4Var = null;
            if (q != null) {
                if (q.size() == 1) {
                    ik4Var = q.get(0);
                } else if (q.size() >= 2) {
                    ik4Var = q.get(1);
                }
            }
            if (ik4Var != null) {
                ej4.i().f(ik4Var);
            }
        }
    }

    public static boolean c(long j, List<ik4> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    ik4 ik4Var = list.get(i);
                    if (ik4Var != null && (j == ik4Var.i || j == wo3.c(ik4Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
