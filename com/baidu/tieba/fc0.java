package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fc0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hc0 a;
    public lc0 b;
    public sc0 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947759190, "Lcom/baidu/tieba/fc0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947759190, "Lcom/baidu/tieba/fc0;");
        }
    }

    public fc0(sc0 sc0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sc0Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = sc0Var;
        this.a = new hc0(sc0Var.f(), 1);
        d();
    }

    public void b(long j) {
        sc0 sc0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && this.b != null && (sc0Var = this.c) != null) {
            if (sc0Var.m()) {
                d();
            }
            if (j != 0) {
                this.c.i().h(j);
            }
            this.b.a(this.c.e(), this.c.i());
        }
    }

    public final void a(lc0 lc0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lc0Var) == null) {
            if (lc0Var == null) {
                this.b = new kc0();
            } else {
                this.b = lc0Var;
            }
            this.b.b(this.c.k(), this.c.j());
        }
    }

    public void g(lc0 lc0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, lc0Var) == null) {
            sc0 sc0Var = this.c;
            if (sc0Var != null) {
                sc0Var.p(lc0Var);
            }
            this.b.release();
            a(lc0Var);
        }
    }

    public hc0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (hc0) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            lc0 lc0Var = this.b;
            if (lc0Var != null) {
                lc0Var.release();
                this.b = null;
            }
            hc0 hc0Var = this.a;
            if (hc0Var != null) {
                hc0Var.f();
                this.a = null;
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            lc0 g = this.c.g();
            this.b = g;
            a(g);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            float[] b = this.c.i().b();
            uc0.b(b);
            qc0 c = this.c.c();
            uc0.e(b, c.g(), c.h());
            uc0.a(b, c.d());
            uc0.c(b, c.b());
            if ((c.f() + 360) % 180 == 0) {
                uc0.d(b, this.c.k(), this.c.j(), c.e(), c.c());
                return;
            }
            oc0 clone = this.c.j().clone();
            clone.e(this.c.j().b());
            clone.d(this.c.j().c());
            uc0.d(b, this.c.k(), clone, c.e(), c.c());
        }
    }
}
