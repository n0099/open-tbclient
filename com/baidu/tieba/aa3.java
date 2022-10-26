package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.tieba.jo2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class aa3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947608406, "Lcom/baidu/tieba/aa3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947608406, "Lcom/baidu/tieba/aa3;");
                return;
            }
        }
        a = wj1.a;
        b = false;
        c = false;
        tm2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(mt2 mt2Var, String str, dq1 dq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, mt2Var, str, dq1Var) == null) {
            e(mt2Var, str, dq1Var, null);
        }
    }

    public static void e(mt2 mt2Var, String str, dq1 dq1Var, String str2) {
        m33 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65541, null, mt2Var, str, dq1Var, str2) != null) || !d || (b0 = m33.b0()) == null) {
            return;
        }
        jo2.a W = b0.W();
        pa3 pa3Var = new pa3();
        pa3Var.a = fa3.n(W.G());
        pa3Var.f = W.H();
        if (d12.d()) {
            pa3Var.c = "remote-debug";
        } else if (lz2.D()) {
            pa3Var.c = "local-debug";
        } else {
            pa3Var.c = W.T();
        }
        pa3Var.b = "pageshow";
        if (!TextUtils.isEmpty(str)) {
            pa3Var.e = str;
        }
        if (mt2Var != null) {
            pa3Var.a("path", mt2Var.a);
            pa3Var.a("routeType", mt2Var.e);
            pa3Var.a("routeid", mt2Var.f);
        }
        if (!TextUtils.isEmpty(str2)) {
            pa3Var.a("errcode", str2);
        }
        if (dq1Var != null && dq1Var.c > 0) {
            pa3Var.a("valuetype", dq1Var.g);
        }
        Bundle P = W.P();
        if (P != null) {
            pa3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        }
        pa3Var.b(fa3.k(W.W()));
        if (a) {
            Log.d("SwanAppRouteUbc", "onRouteEvent - " + pa3Var.f());
        }
        fa3.onEvent(pa3Var);
    }

    public static mt2 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            v22 V = zo2.U().V();
            mt2 mt2Var = null;
            if (V == null) {
                return null;
            }
            s22 j = V.j((V.k() - i) - 1);
            if (j instanceof u22) {
                mt2Var = ((u22) j).m3();
                mt2Var.e = "1";
                mt2Var.f = str;
            }
            g(mt2Var);
            return mt2Var;
        }
        return (mt2) invokeLI.objValue;
    }

    public static void g(mt2 mt2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, mt2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (!c()) {
                k(true);
                d(mt2Var, null, null);
            }
        }
    }

    public static void h(mt2 mt2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, mt2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(mt2Var, null, null);
        }
    }

    public static void i(mt2 mt2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, mt2Var) == null) {
            j(mt2Var, null);
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (aa3.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (aa3.class) {
                b = z;
            }
        }
    }

    public static void j(mt2 mt2Var, ff3 ff3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, mt2Var, ff3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + mt2Var + " errCode=" + ff3Var);
            }
            if (c) {
                if (ff3Var == null) {
                    ff3Var = new ff3();
                    ff3Var.k(5L);
                    ff3Var.i(58L);
                    ff3Var.d("route check fail");
                }
                e(mt2Var, com.baidu.pass.biometrics.face.liveness.b.a.g0, null, String.valueOf(ff3Var.a()));
            }
        }
    }
}
