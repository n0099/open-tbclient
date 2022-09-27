package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ad0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cd0 a;
    public gd0 b;
    public nd0 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947611196, "Lcom/baidu/tieba/ad0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947611196, "Lcom/baidu/tieba/ad0;");
        }
    }

    public ad0(nd0 nd0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nd0Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = nd0Var;
        this.a = new cd0(nd0Var.f(), 1);
        d();
    }

    public final void a(gd0 gd0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gd0Var) == null) {
            if (gd0Var == null) {
                this.b = new fd0();
            } else {
                this.b = gd0Var;
            }
            this.b.b(this.c.j(), this.c.i());
        }
    }

    public void b(long j) {
        nd0 nd0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.b == null || (nd0Var = this.c) == null) {
            return;
        }
        if (nd0Var.l()) {
            d();
        }
        if (j != 0) {
            this.c.h().h(j);
        }
        this.b.a(this.c.e(), this.c.h());
    }

    public cd0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (cd0) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            float[] b = this.c.h().b();
            pd0.b(b);
            ld0 c = this.c.c();
            pd0.e(b, c.g(), c.h());
            pd0.a(b, c.d());
            pd0.c(b, c.b());
            if ((c.f() + 360) % 180 == 0) {
                pd0.d(b, this.c.j(), this.c.i(), c.e(), c.c());
                return;
            }
            jd0 clone = this.c.i().clone();
            clone.e(this.c.i().b());
            clone.d(this.c.i().c());
            pd0.d(b, this.c.j(), clone, c.e(), c.c());
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            gd0 gd0Var = this.b;
            if (gd0Var != null) {
                gd0Var.release();
                this.b = null;
            }
            cd0 cd0Var = this.a;
            if (cd0Var != null) {
                cd0Var.f();
                this.a = null;
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            gd0 g = this.c.g();
            this.b = g;
            a(g);
        }
    }

    public void g(gd0 gd0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, gd0Var) == null) {
            nd0 nd0Var = this.c;
            if (nd0Var != null) {
                nd0Var.o(gd0Var);
            }
            this.b.release();
            a(gd0Var);
        }
    }
}
