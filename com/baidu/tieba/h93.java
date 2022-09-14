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
public final class h93 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa3 a;

        public a(aa3 aa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f93.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947778503, "Lcom/baidu/tieba/h93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947778503, "Lcom/baidu/tieba/h93;");
                return;
            }
        }
        a = ij1.a;
    }

    public static void a(aa3 aa3Var, vn2 vn2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, aa3Var, vn2Var) == null) || aa3Var == null || vn2Var == null) {
            return;
        }
        aa3Var.a = r93.n(vn2Var.G());
        aa3Var.f = vn2Var.H();
        aa3Var.c = vn2Var.T();
        aa3Var.a("swan", dc3.h(vn2Var.G()));
        aa3Var.a("appversion", vn2Var.v1());
        aa3Var.a("thirdversion", vn2Var.w1());
        aa3Var.b(r93.k(vn2Var.W()));
        aa3Var.d(vn2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
    }

    public static void b(ba3 ba3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ba3Var) == null) {
            if (ba3Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            aa3 aa3Var = new aa3();
            aa3Var.f = ba3Var.f;
            aa3Var.a = ba3Var.a;
            aa3Var.g = ba3Var.g;
            aa3Var.c = ba3Var.c;
            aa3Var.b = ba3Var.b;
            aa3Var.e = ba3Var.e;
            aa3Var.e(ba3Var.c());
            c(aa3Var);
        }
    }

    public static void c(aa3 aa3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, aa3Var) == null) {
            sf3.j(new a(aa3Var), "SwanAppFuncClickUBC");
        }
    }
}
