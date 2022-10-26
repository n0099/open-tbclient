package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.im2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes4.dex */
public class fz2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947781355, "Lcom/baidu/tieba/fz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947781355, "Lcom/baidu/tieba/fz2;");
                return;
            }
        }
        a = wj1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (list = im2.q().list()) != null && list.length > 0) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    nc4 nc4Var = new nc4();
                    nc4Var.g = str;
                    nc4Var.i = -1L;
                    jb4.i().f(nc4Var);
                }
            }
            im2.e.d();
        }
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && !TextUtils.isEmpty(str) && (s = im2.s(str)) != null && (list = s.list()) != null && list.length > 1) {
            List q = ty2.q(str);
            for (String str2 : list) {
                long j = -1;
                try {
                    j = Long.parseLong(str2);
                } catch (NumberFormatException e) {
                    if (a) {
                        ez2.b(Log.getStackTraceString(e));
                    }
                }
                if (!c(j, q)) {
                    qj4.L(im2.t(str, str2));
                    ez2.b("delete plugin name = " + str + " ; version = " + str2);
                }
            }
            nc4 nc4Var = null;
            if (q != null) {
                if (q.size() == 1) {
                    nc4Var = (nc4) q.get(0);
                } else if (q.size() >= 2) {
                    nc4Var = (nc4) q.get(1);
                }
            }
            if (nc4Var != null) {
                jb4.i().f(nc4Var);
            }
        }
    }

    public static boolean c(long j, List list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    nc4 nc4Var = (nc4) list.get(i);
                    if (nc4Var != null && (j == nc4Var.i || j == bh3.c(nc4Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
