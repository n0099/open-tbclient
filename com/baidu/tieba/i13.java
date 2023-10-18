package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.lo2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes6.dex */
public class i13 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947800606, "Lcom/baidu/tieba/i13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947800606, "Lcom/baidu/tieba/i13;");
                return;
            }
        }
        a = am1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (list = lo2.q().list()) != null && list.length > 0) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    qe4 qe4Var = new qe4();
                    qe4Var.g = str;
                    qe4Var.i = -1L;
                    md4.i().f(qe4Var);
                }
            }
            lo2.e.d();
        }
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && !TextUtils.isEmpty(str) && (s = lo2.s(str)) != null && (list = s.list()) != null && list.length > 1) {
            List<qe4> q = w03.q(str);
            for (String str2 : list) {
                long j = -1;
                try {
                    j = Long.parseLong(str2);
                } catch (NumberFormatException e) {
                    if (a) {
                        h13.b(Log.getStackTraceString(e));
                    }
                }
                if (!c(j, q)) {
                    sl4.L(lo2.t(str, str2));
                    h13.b("delete plugin name = " + str + " ; version = " + str2);
                }
            }
            qe4 qe4Var = null;
            if (q != null) {
                if (q.size() == 1) {
                    qe4Var = q.get(0);
                } else if (q.size() >= 2) {
                    qe4Var = q.get(1);
                }
            }
            if (qe4Var != null) {
                md4.i().f(qe4Var);
            }
        }
    }

    public static boolean c(long j, List<qe4> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    qe4 qe4Var = list.get(i);
                    if (qe4Var != null && (j == qe4Var.i || j == ej3.c(qe4Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
