package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class cp0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m81 a;
    public w91 b;

    public cp0(bp0 bp0Var, Context context) {
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bp0Var, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (bp0Var != null) {
            num = Integer.valueOf(bp0Var.b());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 1) {
            this.a = new m81(context);
        } else if (num != null && num.intValue() == 0) {
            this.b = new w91(context);
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            w91 w91Var = this.b;
            if (w91Var != null) {
                w91Var.i();
            }
            m81 m81Var = this.a;
            if (m81Var != null) {
                m81Var.h();
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            w91 w91Var = this.b;
            if (w91Var != null) {
                w91Var.l();
            }
            m81 m81Var = this.a;
            if (m81Var != null) {
                m81Var.k();
            }
        }
    }

    public final void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            w91 w91Var = this.b;
            if (w91Var != null) {
                w91Var.o(z);
            }
            m81 m81Var = this.a;
            if (m81Var != null) {
                m81Var.n(z);
            }
        }
    }
}
