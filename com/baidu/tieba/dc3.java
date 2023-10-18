package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.tieba.mq2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947699701, "Lcom/baidu/tieba/dc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947699701, "Lcom/baidu/tieba/dc3;");
                return;
            }
        }
        a = am1.a;
        b = false;
        c = false;
        wo2.g0().getSwitch("swan_app_use_route_statistic", false);
        d = false;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "mIsStartByApi = " + c);
            }
            boolean z = c;
            k(false);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "mIsStartFirstPage = " + b);
            }
            boolean z = b;
            l(false);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b;
        }
        return invokeV.booleanValue;
    }

    public static void d(pv2 pv2Var, String str, hs1 hs1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pv2Var, str, hs1Var) == null) {
            e(pv2Var, str, hs1Var, null);
        }
    }

    public static void e(pv2 pv2Var, String str, hs1 hs1Var, String str2) {
        p53 c0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65541, null, pv2Var, str, hs1Var, str2) != null) || !d || (c0 = p53.c0()) == null) {
            return;
        }
        mq2.a X = c0.X();
        sc3 sc3Var = new sc3();
        sc3Var.a = ic3.n(X.H());
        sc3Var.f = X.I();
        if (g32.d()) {
            sc3Var.c = "remote-debug";
        } else if (o13.D()) {
            sc3Var.c = "local-debug";
        } else {
            sc3Var.c = X.U();
        }
        sc3Var.b = "pageshow";
        if (!TextUtils.isEmpty(str)) {
            sc3Var.e = str;
        }
        if (pv2Var != null) {
            sc3Var.a("path", pv2Var.a);
            sc3Var.a("routeType", pv2Var.e);
            sc3Var.a("routeid", pv2Var.f);
        }
        if (!TextUtils.isEmpty(str2)) {
            sc3Var.a(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, str2);
        }
        if (hs1Var != null && hs1Var.c > 0) {
            sc3Var.a("valuetype", hs1Var.g);
        }
        Bundle Q = X.Q();
        if (Q != null) {
            sc3Var.d(Q.getString("ubc"));
        }
        sc3Var.b(ic3.k(X.X()));
        if (a) {
            Log.d("SwanAppRouteUbc", "onRouteEvent - " + sc3Var.f());
        }
        ic3.onEvent(sc3Var);
    }

    public static pv2 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            y42 W = cr2.V().W();
            pv2 pv2Var = null;
            if (W == null) {
                return null;
            }
            v42 j = W.j((W.k() - i) - 1);
            if (j instanceof x42) {
                pv2Var = ((x42) j).t3();
                pv2Var.e = "1";
                pv2Var.f = str;
            }
            g(pv2Var);
            return pv2Var;
        }
        return (pv2) invokeLI.objValue;
    }

    public static void g(pv2 pv2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, pv2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (!c()) {
                k(true);
                d(pv2Var, null, null);
            }
        }
    }

    public static void h(pv2 pv2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, pv2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(pv2Var, null, null);
        }
    }

    public static void i(pv2 pv2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, pv2Var) == null) {
            j(pv2Var, null);
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (dc3.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (dc3.class) {
                b = z;
            }
        }
    }

    public static void j(pv2 pv2Var, ih3 ih3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, pv2Var, ih3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + pv2Var + " errCode=" + ih3Var);
            }
            if (c) {
                if (ih3Var == null) {
                    ih3Var = new ih3();
                    ih3Var.k(5L);
                    ih3Var.i(58L);
                    ih3Var.d("route check fail");
                }
                e(pv2Var, "fail", null, String.valueOf(ih3Var.a()));
            }
        }
    }
}
