package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class dr6 extends hq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tp6 e;

    @Override // com.baidu.tieba.k0
    public void c(h0 engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, engine) == null) {
            Intrinsics.checkNotNullParameter(engine, "engine");
        }
    }

    @Override // com.baidu.tieba.hq6
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dr6(eq6 context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((eq6) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.baidu.tieba.k0
    public void i(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
            m();
        }
    }

    public final void n(tp6 danmakuConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, danmakuConfig) == null) {
            Intrinsics.checkNotNullParameter(danmakuConfig, "danmakuConfig");
            this.e = danmakuConfig;
        }
    }

    public final tp6 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (tp6) invokeV.objValue;
    }

    public final void m() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            tp6 tp6Var = this.e;
            if (tp6Var != null) {
                tp6 c = j().c();
                if (c.j() != tp6Var.j() || c.g() != tp6Var.g()) {
                    BdLog.w("DanmakuEngine [Config] density from " + c.j() + " to " + tp6Var.j());
                    tp6Var.G();
                    tp6Var.I();
                    tp6Var.F();
                    tp6Var.C();
                }
                boolean z2 = true;
                if (c.v() == tp6Var.v()) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    BdLog.w("DanmakuEngine [Config] textSizeScale change from " + c.v() + " to " + tp6Var.v());
                    tp6Var.I();
                    tp6Var.F();
                    tp6Var.G();
                    tp6Var.C();
                }
                if (c.w() != tp6Var.w()) {
                    tp6Var.J();
                }
                if (c.u() != tp6Var.u()) {
                    z2 = false;
                }
                if (!z2 || c.e() != tp6Var.e()) {
                    tp6Var.F();
                    tp6Var.J();
                    tp6Var.I();
                }
                if (c.n().size() != tp6Var.n().size() || c.l() != tp6Var.l()) {
                    tp6Var.D();
                }
                j().h(tp6Var);
            }
            this.e = null;
        }
    }
}
