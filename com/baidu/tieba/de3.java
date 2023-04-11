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
public final class de3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ we3 a;

        public a(we3 we3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {we3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = we3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                be3.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947701623, "Lcom/baidu/tieba/de3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947701623, "Lcom/baidu/tieba/de3;");
                return;
            }
        }
        a = eo1.a;
    }

    public static void a(we3 we3Var, rs2 rs2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, we3Var, rs2Var) == null) && we3Var != null && rs2Var != null) {
            we3Var.a = ne3.n(rs2Var.G());
            we3Var.f = rs2Var.H();
            we3Var.c = rs2Var.T();
            we3Var.a("swan", zg3.h(rs2Var.G()));
            we3Var.a("appversion", rs2Var.v1());
            we3Var.a("thirdversion", rs2Var.w1());
            we3Var.b(ne3.k(rs2Var.W()));
            we3Var.d(rs2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        }
    }

    public static void b(xe3 xe3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, xe3Var) == null) {
            if (xe3Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            we3 we3Var = new we3();
            we3Var.f = xe3Var.f;
            we3Var.a = xe3Var.a;
            we3Var.g = xe3Var.g;
            we3Var.c = xe3Var.c;
            we3Var.b = xe3Var.b;
            we3Var.e = xe3Var.e;
            we3Var.e(xe3Var.c());
            c(we3Var);
        }
    }

    public static void c(we3 we3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, we3Var) == null) {
            ok3.j(new a(we3Var), "SwanAppFuncClickUBC");
        }
    }
}
