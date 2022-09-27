package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.hm2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes3.dex */
public class ez2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947751564, "Lcom/baidu/tieba/ez2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947751564, "Lcom/baidu/tieba/ez2;");
                return;
            }
        }
        a = vj1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (list = hm2.q().list()) == null || list.length <= 0) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                mc4 mc4Var = new mc4();
                mc4Var.g = str;
                mc4Var.i = -1L;
                ib4.i().f(mc4Var);
            }
        }
        hm2.e.d();
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || TextUtils.isEmpty(str) || (s = hm2.s(str)) == null || (list = s.list()) == null || list.length <= 1) {
            return;
        }
        List<mc4> q = sy2.q(str);
        for (String str2 : list) {
            long j = -1;
            try {
                j = Long.parseLong(str2);
            } catch (NumberFormatException e) {
                if (a) {
                    dz2.b(Log.getStackTraceString(e));
                }
            }
            if (!c(j, q)) {
                pj4.L(hm2.t(str, str2));
                dz2.b("delete plugin name = " + str + " ; version = " + str2);
            }
        }
        mc4 mc4Var = null;
        if (q != null) {
            if (q.size() == 1) {
                mc4Var = q.get(0);
            } else if (q.size() >= 2) {
                mc4Var = q.get(1);
            }
        }
        if (mc4Var != null) {
            ib4.i().f(mc4Var);
        }
    }

    public static boolean c(long j, List<mc4> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    mc4 mc4Var = list.get(i);
                    if (mc4Var != null && (j == mc4Var.i || j == ah3.c(mc4Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
