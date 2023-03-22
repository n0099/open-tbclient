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
/* loaded from: classes3.dex */
public final class ce3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ve3 a;

        public a(ve3 ve3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ve3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ae3.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947671832, "Lcom/baidu/tieba/ce3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947671832, "Lcom/baidu/tieba/ce3;");
                return;
            }
        }
        a = do1.a;
    }

    public static void a(ve3 ve3Var, qs2 qs2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, ve3Var, qs2Var) == null) && ve3Var != null && qs2Var != null) {
            ve3Var.a = me3.n(qs2Var.G());
            ve3Var.f = qs2Var.H();
            ve3Var.c = qs2Var.T();
            ve3Var.a("swan", yg3.h(qs2Var.G()));
            ve3Var.a("appversion", qs2Var.v1());
            ve3Var.a("thirdversion", qs2Var.w1());
            ve3Var.b(me3.k(qs2Var.W()));
            ve3Var.d(qs2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        }
    }

    public static void b(we3 we3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, we3Var) == null) {
            if (we3Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            ve3 ve3Var = new ve3();
            ve3Var.f = we3Var.f;
            ve3Var.a = we3Var.a;
            ve3Var.g = we3Var.g;
            ve3Var.c = we3Var.c;
            ve3Var.b = we3Var.b;
            ve3Var.e = we3Var.e;
            ve3Var.e(we3Var.c());
            c(ve3Var);
        }
    }

    public static void c(ve3 ve3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, ve3Var) == null) {
            nk3.j(new a(ve3Var), "SwanAppFuncClickUBC");
        }
    }
}
