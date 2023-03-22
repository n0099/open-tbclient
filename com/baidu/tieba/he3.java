package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.tieba.qs2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class he3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947820787, "Lcom/baidu/tieba/he3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947820787, "Lcom/baidu/tieba/he3;");
                return;
            }
        }
        a = do1.a;
        b = false;
        c = false;
        ar2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(tx2 tx2Var, String str, ku1 ku1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tx2Var, str, ku1Var) == null) {
            e(tx2Var, str, ku1Var, null);
        }
    }

    public static void e(tx2 tx2Var, String str, ku1 ku1Var, String str2) {
        t73 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65541, null, tx2Var, str, ku1Var, str2) != null) || !d || (b0 = t73.b0()) == null) {
            return;
        }
        qs2.a W = b0.W();
        we3 we3Var = new we3();
        we3Var.a = me3.n(W.G());
        we3Var.f = W.H();
        if (k52.d()) {
            we3Var.c = "remote-debug";
        } else if (s33.D()) {
            we3Var.c = "local-debug";
        } else {
            we3Var.c = W.T();
        }
        we3Var.b = "pageshow";
        if (!TextUtils.isEmpty(str)) {
            we3Var.e = str;
        }
        if (tx2Var != null) {
            we3Var.a("path", tx2Var.a);
            we3Var.a("routeType", tx2Var.e);
            we3Var.a("routeid", tx2Var.f);
        }
        if (!TextUtils.isEmpty(str2)) {
            we3Var.a("errcode", str2);
        }
        if (ku1Var != null && ku1Var.c > 0) {
            we3Var.a("valuetype", ku1Var.g);
        }
        Bundle P = W.P();
        if (P != null) {
            we3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        }
        we3Var.b(me3.k(W.W()));
        if (a) {
            Log.d("SwanAppRouteUbc", "onRouteEvent - " + we3Var.f());
        }
        me3.onEvent(we3Var);
    }

    public static tx2 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            c72 V = gt2.U().V();
            tx2 tx2Var = null;
            if (V == null) {
                return null;
            }
            z62 j = V.j((V.k() - i) - 1);
            if (j instanceof b72) {
                tx2Var = ((b72) j).p3();
                tx2Var.e = "1";
                tx2Var.f = str;
            }
            g(tx2Var);
            return tx2Var;
        }
        return (tx2) invokeLI.objValue;
    }

    public static void g(tx2 tx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, tx2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (!c()) {
                k(true);
                d(tx2Var, null, null);
            }
        }
    }

    public static void h(tx2 tx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, tx2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(tx2Var, null, null);
        }
    }

    public static void i(tx2 tx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, tx2Var) == null) {
            j(tx2Var, null);
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (he3.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (he3.class) {
                b = z;
            }
        }
    }

    public static void j(tx2 tx2Var, mj3 mj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, tx2Var, mj3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + tx2Var + " errCode=" + mj3Var);
            }
            if (c) {
                if (mj3Var == null) {
                    mj3Var = new mj3();
                    mj3Var.k(5L);
                    mj3Var.i(58L);
                    mj3Var.d("route check fail");
                }
                e(tx2Var, com.baidu.pass.biometrics.face.liveness.b.a.g0, null, String.valueOf(mj3Var.a()));
            }
        }
    }
}
