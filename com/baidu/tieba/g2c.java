package com.baidu.tieba;

import com.baidu.tieba.e1c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
/* loaded from: classes6.dex */
public abstract class g2c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e1c a;
    public boolean b;

    public abstract void A(r0c r0cVar);

    public abstract void B(w0c w0cVar);

    public abstract void C(x0c x0cVar);

    public abstract void D(y0c y0cVar);

    public abstract void E(int i);

    public abstract void F(int i, long j);

    public abstract void G();

    public abstract void e();

    public abstract void f();

    public abstract long g();

    public abstract long h();

    public abstract Object i();

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? "12.1.0.34" : (String) invokeV.objValue;
    }

    public abstract int k();

    public abstract int l();

    public abstract void m();

    public abstract void n();

    public abstract void o();

    public abstract void p();

    public abstract void q(Executor executor, e1c.d dVar);

    public abstract void r(long j);

    public abstract void s(j0c j0cVar);

    public abstract void t(j0c j0cVar);

    public abstract void u(int i);

    public abstract void v(int i);

    public abstract void w(Executor executor, l0c l0cVar);

    public abstract void x(m0c m0cVar);

    public abstract void y(o0c o0cVar);

    public abstract void z(q0c q0cVar);

    public g2c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
