package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.download.util.LocalFilesFilterKt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class d64 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean a;
    public static volatile boolean b;
    public static volatile List<il2> c;
    public transient /* synthetic */ FieldHolder $fh;

    public static String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 6 ? LocalFilesFilterKt.FILTER_NAME_LOG : "debug" : "warn" : "error" : "info" : "debug" : (String) invokeI.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947656487, "Lcom/baidu/tieba/d64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947656487, "Lcom/baidu/tieba/d64;");
                return;
            }
        }
        c = new ArrayList();
    }

    public d64() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (d64.class) {
                c = new ArrayList();
            }
            b = false;
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && a && !b) {
            synchronized (d64.class) {
                if (c != null) {
                    for (int i = 0; i < c.size(); i++) {
                        uw2.T().m("console", c.get(i));
                    }
                    c.clear();
                    c = null;
                }
            }
            b = true;
        }
    }

    public static void d(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65541, null, i, str) == null) {
            e(b(i), str);
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, str, str2) == null) && a) {
            f(x54.t(str, str2));
        }
    }

    public static void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) && a) {
            f(x54.v(str, str2));
        }
    }

    public static void f(il2 il2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, il2Var) == null) {
            if (!b) {
                synchronized (d64.class) {
                    if (c != null) {
                        c.add(il2Var);
                        return;
                    }
                }
            }
            uw2.T().m("console", il2Var);
        }
    }

    public static void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            a = z;
            h82.n(z);
        }
    }
}
