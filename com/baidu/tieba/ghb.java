package com.baidu.tieba;

import com.baidu.tieba.egb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public abstract class ghb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public egb a;
    public boolean b;

    public abstract void A(rfb rfbVar);

    public abstract void B(wfb wfbVar);

    public abstract void C(xfb xfbVar);

    public abstract void D(yfb yfbVar);

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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? "12.1.0.24" : (String) invokeV.objValue;
    }

    public abstract int k();

    public abstract int l();

    public abstract void m();

    public abstract void n();

    public abstract void o();

    public abstract void p();

    public abstract void q(Executor executor, egb.d dVar);

    public abstract void r(long j);

    public abstract void s(jfb jfbVar);

    public abstract void t(jfb jfbVar);

    public abstract void u(int i);

    public abstract void v(int i);

    public abstract void w(Executor executor, lfb lfbVar);

    public abstract void x(mfb mfbVar);

    public abstract void y(ofb ofbVar);

    public abstract void z(qfb qfbVar);

    public ghb() {
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
