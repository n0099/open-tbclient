package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.gp2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes5.dex */
public class d23 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947652612, "Lcom/baidu/tieba/d23;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947652612, "Lcom/baidu/tieba/d23;");
                return;
            }
        }
        a = vm1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (list = gp2.q().list()) != null && list.length > 0) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    lf4 lf4Var = new lf4();
                    lf4Var.g = str;
                    lf4Var.i = -1L;
                    he4.i().f(lf4Var);
                }
            }
            gp2.e.d();
        }
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && !TextUtils.isEmpty(str) && (s = gp2.s(str)) != null && (list = s.list()) != null && list.length > 1) {
            List<lf4> q = r13.q(str);
            for (String str2 : list) {
                long j = -1;
                try {
                    j = Long.parseLong(str2);
                } catch (NumberFormatException e) {
                    if (a) {
                        c23.b(Log.getStackTraceString(e));
                    }
                }
                if (!c(j, q)) {
                    nm4.L(gp2.t(str, str2));
                    c23.b("delete plugin name = " + str + " ; version = " + str2);
                }
            }
            lf4 lf4Var = null;
            if (q != null) {
                if (q.size() == 1) {
                    lf4Var = q.get(0);
                } else if (q.size() >= 2) {
                    lf4Var = q.get(1);
                }
            }
            if (lf4Var != null) {
                he4.i().f(lf4Var);
            }
        }
    }

    public static boolean c(long j, List<lf4> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    lf4 lf4Var = list.get(i);
                    if (lf4Var != null && (j == lf4Var.i || j == zj3.c(lf4Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
