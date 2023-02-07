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
public final class ff3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yf3 a;

        public a(yf3 yf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yf3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                df3.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947762166, "Lcom/baidu/tieba/ff3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947762166, "Lcom/baidu/tieba/ff3;");
                return;
            }
        }
        a = gp1.a;
    }

    public static void a(yf3 yf3Var, tt2 tt2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, yf3Var, tt2Var) == null) && yf3Var != null && tt2Var != null) {
            yf3Var.a = pf3.n(tt2Var.G());
            yf3Var.f = tt2Var.H();
            yf3Var.c = tt2Var.T();
            yf3Var.a("swan", bi3.h(tt2Var.G()));
            yf3Var.a("appversion", tt2Var.v1());
            yf3Var.a("thirdversion", tt2Var.w1());
            yf3Var.b(pf3.k(tt2Var.W()));
            yf3Var.d(tt2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        }
    }

    public static void b(zf3 zf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, zf3Var) == null) {
            if (zf3Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            yf3 yf3Var = new yf3();
            yf3Var.f = zf3Var.f;
            yf3Var.a = zf3Var.a;
            yf3Var.g = zf3Var.g;
            yf3Var.c = zf3Var.c;
            yf3Var.b = zf3Var.b;
            yf3Var.e = zf3Var.e;
            yf3Var.e(zf3Var.c());
            c(yf3Var);
        }
    }

    public static void c(yf3 yf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, yf3Var) == null) {
            ql3.j(new a(yf3Var), "SwanAppFuncClickUBC");
        }
    }
}
