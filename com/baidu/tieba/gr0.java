package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class gr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qa1 a;
    public ac1 b;

    public gr0(fr0 fr0Var, Context context) {
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fr0Var, context};
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
        if (fr0Var != null) {
            num = Integer.valueOf(fr0Var.b());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 1) {
            this.a = new qa1(context);
        } else if (num != null && num.intValue() == 0) {
            this.b = new ac1(context);
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ac1 ac1Var = this.b;
            if (ac1Var != null) {
                ac1Var.i();
            }
            qa1 qa1Var = this.a;
            if (qa1Var != null) {
                qa1Var.h();
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ac1 ac1Var = this.b;
            if (ac1Var != null) {
                ac1Var.l();
            }
            qa1 qa1Var = this.a;
            if (qa1Var != null) {
                qa1Var.k();
            }
        }
    }

    public final void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            ac1 ac1Var = this.b;
            if (ac1Var != null) {
                ac1Var.o(z);
            }
            qa1 qa1Var = this.a;
            if (qa1Var != null) {
                qa1Var.n(z);
            }
        }
    }
}
