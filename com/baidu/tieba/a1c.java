package com.baidu.tieba;

import com.baidu.tieba.yzb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public abstract class a1c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yzb a;
    public boolean b;

    public abstract void A(lzb lzbVar);

    public abstract void B(qzb qzbVar);

    public abstract void C(rzb rzbVar);

    public abstract void D(szb szbVar);

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

    public abstract void q(Executor executor, yzb.d dVar);

    public abstract void r(long j);

    public abstract void s(dzb dzbVar);

    public abstract void t(dzb dzbVar);

    public abstract void u(int i);

    public abstract void v(int i);

    public abstract void w(Executor executor, fzb fzbVar);

    public abstract void x(gzb gzbVar);

    public abstract void y(izb izbVar);

    public abstract void z(kzb kzbVar);

    public a1c() {
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
