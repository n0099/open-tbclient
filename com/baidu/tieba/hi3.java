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
public final class hi3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aj3 a;

        public a(aj3 aj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aj3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aj3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                fi3.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947824631, "Lcom/baidu/tieba/hi3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947824631, "Lcom/baidu/tieba/hi3;");
                return;
            }
        }
        a = is1.a;
    }

    public static void a(aj3 aj3Var, vw2 vw2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, aj3Var, vw2Var) == null) && aj3Var != null && vw2Var != null) {
            aj3Var.a = ri3.n(vw2Var.G());
            aj3Var.f = vw2Var.H();
            aj3Var.c = vw2Var.T();
            aj3Var.a("swan", dl3.h(vw2Var.G()));
            aj3Var.a("appversion", vw2Var.v1());
            aj3Var.a("thirdversion", vw2Var.w1());
            aj3Var.b(ri3.k(vw2Var.W()));
            aj3Var.d(vw2Var.s0().getString("ubc"));
        }
    }

    public static void b(bj3 bj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, bj3Var) == null) {
            if (bj3Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            aj3 aj3Var = new aj3();
            aj3Var.f = bj3Var.f;
            aj3Var.a = bj3Var.a;
            aj3Var.g = bj3Var.g;
            aj3Var.c = bj3Var.c;
            aj3Var.b = bj3Var.b;
            aj3Var.e = bj3Var.e;
            aj3Var.e(bj3Var.c());
            c(aj3Var);
        }
    }

    public static void c(aj3 aj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, aj3Var) == null) {
            so3.j(new a(aj3Var), "SwanAppFuncClickUBC");
        }
    }
}
