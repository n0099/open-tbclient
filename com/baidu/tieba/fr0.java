package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class fr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pa1 a;
    public zb1 b;

    public fr0(er0 er0Var, Context context) {
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {er0Var, context};
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
        if (er0Var != null) {
            num = Integer.valueOf(er0Var.b());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 1) {
            this.a = new pa1(context);
        } else if (num != null && num.intValue() == 0) {
            this.b = new zb1(context);
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            zb1 zb1Var = this.b;
            if (zb1Var != null) {
                zb1Var.i();
            }
            pa1 pa1Var = this.a;
            if (pa1Var != null) {
                pa1Var.h();
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            zb1 zb1Var = this.b;
            if (zb1Var != null) {
                zb1Var.l();
            }
            pa1 pa1Var = this.a;
            if (pa1Var != null) {
                pa1Var.k();
            }
        }
    }

    public final void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            zb1 zb1Var = this.b;
            if (zb1Var != null) {
                zb1Var.o(z);
            }
            pa1 pa1Var = this.a;
            if (pa1Var != null) {
                pa1Var.n(z);
            }
        }
    }
}
