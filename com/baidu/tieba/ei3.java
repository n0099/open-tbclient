package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class ei3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xi3 a;

        public a(xi3 xi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xi3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ci3.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947735258, "Lcom/baidu/tieba/ei3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947735258, "Lcom/baidu/tieba/ei3;");
                return;
            }
        }
        a = fs1.a;
    }

    public static void a(xi3 xi3Var, sw2 sw2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, xi3Var, sw2Var) == null) && xi3Var != null && sw2Var != null) {
            xi3Var.a = oi3.n(sw2Var.G());
            xi3Var.f = sw2Var.H();
            xi3Var.c = sw2Var.T();
            xi3Var.a("swan", al3.h(sw2Var.G()));
            xi3Var.a("appversion", sw2Var.v1());
            xi3Var.a("thirdversion", sw2Var.w1());
            xi3Var.b(oi3.k(sw2Var.W()));
            xi3Var.d(sw2Var.s0().getString("ubc"));
        }
    }

    public static void b(yi3 yi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, yi3Var) == null) {
            if (yi3Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            xi3 xi3Var = new xi3();
            xi3Var.f = yi3Var.f;
            xi3Var.a = yi3Var.a;
            xi3Var.g = yi3Var.g;
            xi3Var.c = yi3Var.c;
            xi3Var.b = yi3Var.b;
            xi3Var.e = yi3Var.e;
            xi3Var.e(yi3Var.c());
            c(xi3Var);
        }
    }

    public static void c(xi3 xi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, xi3Var) == null) {
            po3.j(new a(xi3Var), "SwanAppFuncClickUBC");
        }
    }
}
