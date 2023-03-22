package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class gj6 extends ki6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wh6 e;

    @Override // com.baidu.tieba.a0
    public void c(x engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, engine) == null) {
            Intrinsics.checkNotNullParameter(engine, "engine");
        }
    }

    @Override // com.baidu.tieba.ki6
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gj6(hi6 context) {
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
                super((hi6) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final wh6 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (wh6) invokeV.objValue;
    }

    public final void l() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            wh6 wh6Var = this.e;
            if (wh6Var != null) {
                wh6 c = i().c();
                if (c.j() != wh6Var.j() || c.g() != wh6Var.g()) {
                    BdLog.w("DanmakuEngine [Config] density from " + c.j() + " to " + wh6Var.j());
                    wh6Var.G();
                    wh6Var.I();
                    wh6Var.F();
                    wh6Var.C();
                }
                boolean z2 = true;
                if (c.v() == wh6Var.v()) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    BdLog.w("DanmakuEngine [Config] textSizeScale change from " + c.v() + " to " + wh6Var.v());
                    wh6Var.I();
                    wh6Var.F();
                    wh6Var.G();
                    wh6Var.C();
                }
                if (c.w() != wh6Var.w()) {
                    wh6Var.J();
                }
                if (c.u() != wh6Var.u()) {
                    z2 = false;
                }
                if (!z2 || c.e() != wh6Var.e()) {
                    wh6Var.F();
                    wh6Var.J();
                    wh6Var.I();
                }
                if (c.n().size() != wh6Var.n().size() || c.l() != wh6Var.l()) {
                    wh6Var.D();
                }
                i().h(wh6Var);
            }
            this.e = null;
        }
    }

    public final void m(wh6 danmakuConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, danmakuConfig) == null) {
            Intrinsics.checkNotNullParameter(danmakuConfig, "danmakuConfig");
            this.e = danmakuConfig;
        }
    }

    @Override // com.baidu.tieba.a0
    public void update(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            l();
        }
    }
}
