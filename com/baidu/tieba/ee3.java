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
public final class ee3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xe3 a;

        public a(xe3 xe3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xe3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xe3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ce3.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947731414, "Lcom/baidu/tieba/ee3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947731414, "Lcom/baidu/tieba/ee3;");
                return;
            }
        }
        a = fo1.a;
    }

    public static void a(xe3 xe3Var, ss2 ss2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, xe3Var, ss2Var) == null) && xe3Var != null && ss2Var != null) {
            xe3Var.a = oe3.n(ss2Var.G());
            xe3Var.f = ss2Var.H();
            xe3Var.c = ss2Var.T();
            xe3Var.a("swan", ah3.h(ss2Var.G()));
            xe3Var.a("appversion", ss2Var.v1());
            xe3Var.a("thirdversion", ss2Var.w1());
            xe3Var.b(oe3.k(ss2Var.W()));
            xe3Var.d(ss2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        }
    }

    public static void b(ye3 ye3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ye3Var) == null) {
            if (ye3Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            xe3 xe3Var = new xe3();
            xe3Var.f = ye3Var.f;
            xe3Var.a = ye3Var.a;
            xe3Var.g = ye3Var.g;
            xe3Var.c = ye3Var.c;
            xe3Var.b = ye3Var.b;
            xe3Var.e = ye3Var.e;
            xe3Var.e(ye3Var.c());
            c(xe3Var);
        }
    }

    public static void c(xe3 xe3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, xe3Var) == null) {
            pk3.j(new a(xe3Var), "SwanAppFuncClickUBC");
        }
    }
}
