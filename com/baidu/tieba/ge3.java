package com.baidu.tieba;

import android.util.Log;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class ge3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ze3 a;

        public a(ze3 ze3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ze3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ee3.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947790996, "Lcom/baidu/tieba/ge3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947790996, "Lcom/baidu/tieba/ge3;");
                return;
            }
        }
        a = ho1.a;
    }

    public static void a(ze3 ze3Var, us2 us2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, ze3Var, us2Var) == null) && ze3Var != null && us2Var != null) {
            ze3Var.a = qe3.n(us2Var.G());
            ze3Var.f = us2Var.H();
            ze3Var.c = us2Var.T();
            ze3Var.a("swan", ch3.h(us2Var.G()));
            ze3Var.a("appversion", us2Var.v1());
            ze3Var.a("thirdversion", us2Var.w1());
            ze3Var.b(qe3.k(us2Var.W()));
            ze3Var.d(us2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        }
    }

    public static void b(af3 af3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, af3Var) == null) {
            if (af3Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            ze3 ze3Var = new ze3();
            ze3Var.f = af3Var.f;
            ze3Var.a = af3Var.a;
            ze3Var.g = af3Var.g;
            ze3Var.c = af3Var.c;
            ze3Var.b = af3Var.b;
            ze3Var.e = af3Var.e;
            ze3Var.e(af3Var.c());
            c(ze3Var);
        }
    }

    public static void c(ze3 ze3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, ze3Var) == null) {
            rk3.j(new a(ze3Var), "SwanAppFuncClickUBC");
        }
    }
}
