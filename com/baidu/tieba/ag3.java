package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.tieba.ju2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class ag3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947614172, "Lcom/baidu/tieba/ag3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947614172, "Lcom/baidu/tieba/ag3;");
                return;
            }
        }
        a = wp1.a;
        b = false;
        c = false;
        ts2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(mz2 mz2Var, String str, dw1 dw1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, mz2Var, str, dw1Var) == null) {
            e(mz2Var, str, dw1Var, null);
        }
    }

    public static void e(mz2 mz2Var, String str, dw1 dw1Var, String str2) {
        m93 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65541, null, mz2Var, str, dw1Var, str2) != null) || !d || (b0 = m93.b0()) == null) {
            return;
        }
        ju2.a W = b0.W();
        pg3 pg3Var = new pg3();
        pg3Var.a = fg3.n(W.G());
        pg3Var.f = W.H();
        if (d72.d()) {
            pg3Var.c = "remote-debug";
        } else if (l53.D()) {
            pg3Var.c = "local-debug";
        } else {
            pg3Var.c = W.T();
        }
        pg3Var.b = "pageshow";
        if (!TextUtils.isEmpty(str)) {
            pg3Var.e = str;
        }
        if (mz2Var != null) {
            pg3Var.a("path", mz2Var.a);
            pg3Var.a("routeType", mz2Var.e);
            pg3Var.a("routeid", mz2Var.f);
        }
        if (!TextUtils.isEmpty(str2)) {
            pg3Var.a("errcode", str2);
        }
        if (dw1Var != null && dw1Var.c > 0) {
            pg3Var.a("valuetype", dw1Var.g);
        }
        Bundle P = W.P();
        if (P != null) {
            pg3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        }
        pg3Var.b(fg3.k(W.W()));
        if (a) {
            Log.d("SwanAppRouteUbc", "onRouteEvent - " + pg3Var.f());
        }
        fg3.onEvent(pg3Var);
    }

    public static mz2 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            v82 V = zu2.U().V();
            mz2 mz2Var = null;
            if (V == null) {
                return null;
            }
            s82 j = V.j((V.k() - i) - 1);
            if (j instanceof u82) {
                mz2Var = ((u82) j).m3();
                mz2Var.e = "1";
                mz2Var.f = str;
            }
            g(mz2Var);
            return mz2Var;
        }
        return (mz2) invokeLI.objValue;
    }

    public static void g(mz2 mz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, mz2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (!c()) {
                k(true);
                d(mz2Var, null, null);
            }
        }
    }

    public static void h(mz2 mz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, mz2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(mz2Var, null, null);
        }
    }

    public static void i(mz2 mz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, mz2Var) == null) {
            j(mz2Var, null);
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (ag3.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (ag3.class) {
                b = z;
            }
        }
    }

    public static void j(mz2 mz2Var, fl3 fl3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, mz2Var, fl3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + mz2Var + " errCode=" + fl3Var);
            }
            if (c) {
                if (fl3Var == null) {
                    fl3Var = new fl3();
                    fl3Var.k(5L);
                    fl3Var.i(58L);
                    fl3Var.d("route check fail");
                }
                e(mz2Var, com.baidu.pass.biometrics.face.liveness.b.a.g0, null, String.valueOf(fl3Var.a()));
            }
        }
    }
}
