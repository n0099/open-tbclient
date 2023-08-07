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
public final class hh3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ai3 a;

        public a(ai3 ai3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ai3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ai3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                fh3.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947823670, "Lcom/baidu/tieba/hh3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947823670, "Lcom/baidu/tieba/hh3;");
                return;
            }
        }
        a = ir1.a;
    }

    public static void a(ai3 ai3Var, vv2 vv2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, ai3Var, vv2Var) == null) && ai3Var != null && vv2Var != null) {
            ai3Var.a = rh3.n(vv2Var.G());
            ai3Var.f = vv2Var.H();
            ai3Var.c = vv2Var.T();
            ai3Var.a("swan", dk3.h(vv2Var.G()));
            ai3Var.a("appversion", vv2Var.v1());
            ai3Var.a("thirdversion", vv2Var.w1());
            ai3Var.b(rh3.k(vv2Var.W()));
            ai3Var.d(vv2Var.s0().getString("ubc"));
        }
    }

    public static void b(bi3 bi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, bi3Var) == null) {
            if (bi3Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            ai3 ai3Var = new ai3();
            ai3Var.f = bi3Var.f;
            ai3Var.a = bi3Var.a;
            ai3Var.g = bi3Var.g;
            ai3Var.c = bi3Var.c;
            ai3Var.b = bi3Var.b;
            ai3Var.e = bi3Var.e;
            ai3Var.e(bi3Var.c());
            c(ai3Var);
        }
    }

    public static void c(ai3 ai3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, ai3Var) == null) {
            sn3.j(new a(ai3Var), "SwanAppFuncClickUBC");
        }
    }
}
