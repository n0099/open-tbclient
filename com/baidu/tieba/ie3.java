package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.tieba.rs2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ie3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947850578, "Lcom/baidu/tieba/ie3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947850578, "Lcom/baidu/tieba/ie3;");
                return;
            }
        }
        a = eo1.a;
        b = false;
        c = false;
        br2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(ux2 ux2Var, String str, lu1 lu1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ux2Var, str, lu1Var) == null) {
            e(ux2Var, str, lu1Var, null);
        }
    }

    public static void e(ux2 ux2Var, String str, lu1 lu1Var, String str2) {
        u73 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65541, null, ux2Var, str, lu1Var, str2) != null) || !d || (b0 = u73.b0()) == null) {
            return;
        }
        rs2.a W = b0.W();
        xe3 xe3Var = new xe3();
        xe3Var.a = ne3.n(W.G());
        xe3Var.f = W.H();
        if (l52.d()) {
            xe3Var.c = "remote-debug";
        } else if (t33.D()) {
            xe3Var.c = "local-debug";
        } else {
            xe3Var.c = W.T();
        }
        xe3Var.b = "pageshow";
        if (!TextUtils.isEmpty(str)) {
            xe3Var.e = str;
        }
        if (ux2Var != null) {
            xe3Var.a("path", ux2Var.a);
            xe3Var.a("routeType", ux2Var.e);
            xe3Var.a("routeid", ux2Var.f);
        }
        if (!TextUtils.isEmpty(str2)) {
            xe3Var.a("errcode", str2);
        }
        if (lu1Var != null && lu1Var.c > 0) {
            xe3Var.a("valuetype", lu1Var.g);
        }
        Bundle P = W.P();
        if (P != null) {
            xe3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        }
        xe3Var.b(ne3.k(W.W()));
        if (a) {
            Log.d("SwanAppRouteUbc", "onRouteEvent - " + xe3Var.f());
        }
        ne3.onEvent(xe3Var);
    }

    public static ux2 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            d72 V = ht2.U().V();
            ux2 ux2Var = null;
            if (V == null) {
                return null;
            }
            a72 j = V.j((V.k() - i) - 1);
            if (j instanceof c72) {
                ux2Var = ((c72) j).p3();
                ux2Var.e = "1";
                ux2Var.f = str;
            }
            g(ux2Var);
            return ux2Var;
        }
        return (ux2) invokeLI.objValue;
    }

    public static void g(ux2 ux2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, ux2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (!c()) {
                k(true);
                d(ux2Var, null, null);
            }
        }
    }

    public static void h(ux2 ux2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, ux2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(ux2Var, null, null);
        }
    }

    public static void i(ux2 ux2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, ux2Var) == null) {
            j(ux2Var, null);
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (ie3.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (ie3.class) {
                b = z;
            }
        }
    }

    public static void j(ux2 ux2Var, nj3 nj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, ux2Var, nj3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + ux2Var + " errCode=" + nj3Var);
            }
            if (c) {
                if (nj3Var == null) {
                    nj3Var = new nj3();
                    nj3Var.k(5L);
                    nj3Var.i(58L);
                    nj3Var.d("route check fail");
                }
                e(ux2Var, com.baidu.pass.biometrics.face.liveness.b.a.g0, null, String.valueOf(nj3Var.a()));
            }
        }
    }
}
