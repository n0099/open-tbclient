package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class ii3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bj3 a;

        public a(bj3 bj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bj3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bj3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gi3.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947854422, "Lcom/baidu/tieba/ii3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947854422, "Lcom/baidu/tieba/ii3;");
                return;
            }
        }
        a = js1.a;
    }

    public static void a(bj3 bj3Var, ww2 ww2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, bj3Var, ww2Var) == null) && bj3Var != null && ww2Var != null) {
            bj3Var.a = si3.n(ww2Var.G());
            bj3Var.f = ww2Var.H();
            bj3Var.c = ww2Var.T();
            bj3Var.a("swan", el3.h(ww2Var.G()));
            bj3Var.a("appversion", ww2Var.v1());
            bj3Var.a("thirdversion", ww2Var.w1());
            bj3Var.b(si3.k(ww2Var.W()));
            bj3Var.d(ww2Var.s0().getString("ubc"));
        }
    }

    public static void b(cj3 cj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, cj3Var) == null) {
            if (cj3Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            bj3 bj3Var = new bj3();
            bj3Var.f = cj3Var.f;
            bj3Var.a = cj3Var.a;
            bj3Var.g = cj3Var.g;
            bj3Var.c = cj3Var.c;
            bj3Var.b = cj3Var.b;
            bj3Var.e = cj3Var.e;
            bj3Var.e(cj3Var.c());
            c(bj3Var);
        }
    }

    public static void c(bj3 bj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bj3Var) == null) {
            to3.j(new a(bj3Var), "SwanAppFuncClickUBC");
        }
    }
}
