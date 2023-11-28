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
public final class et6 extends is6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ur6 e;

    @Override // com.baidu.tieba.a1
    public void c(x0 engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, engine) == null) {
            Intrinsics.checkNotNullParameter(engine, "engine");
        }
    }

    @Override // com.baidu.tieba.is6
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public et6(fs6 context) {
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
                super((fs6) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.baidu.tieba.a1
    public void i(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
            m();
        }
    }

    public final void n(ur6 danmakuConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, danmakuConfig) == null) {
            Intrinsics.checkNotNullParameter(danmakuConfig, "danmakuConfig");
            this.e = danmakuConfig;
        }
    }

    public final ur6 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (ur6) invokeV.objValue;
    }

    public final void m() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ur6 ur6Var = this.e;
            if (ur6Var != null) {
                ur6 c = j().c();
                if (c.j() != ur6Var.j() || c.g() != ur6Var.g()) {
                    BdLog.w("DanmakuEngine [Config] density from " + c.j() + " to " + ur6Var.j());
                    ur6Var.G();
                    ur6Var.I();
                    ur6Var.F();
                    ur6Var.C();
                }
                boolean z2 = true;
                if (c.v() == ur6Var.v()) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    BdLog.w("DanmakuEngine [Config] textSizeScale change from " + c.v() + " to " + ur6Var.v());
                    ur6Var.I();
                    ur6Var.F();
                    ur6Var.G();
                    ur6Var.C();
                }
                if (c.w() != ur6Var.w()) {
                    ur6Var.J();
                }
                if (c.u() != ur6Var.u()) {
                    z2 = false;
                }
                if (!z2 || c.e() != ur6Var.e()) {
                    ur6Var.F();
                    ur6Var.J();
                    ur6Var.I();
                }
                if (c.n().size() != ur6Var.n().size() || c.l() != ur6Var.l()) {
                    ur6Var.D();
                }
                j().h(ur6Var);
            }
            this.e = null;
        }
    }
}
