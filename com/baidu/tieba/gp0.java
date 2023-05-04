package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class gp0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public q81 a;
    public aa1 b;

    public gp0(fp0 fp0Var, Context context) {
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fp0Var, context};
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
        if (fp0Var != null) {
            num = Integer.valueOf(fp0Var.b());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 1) {
            this.a = new q81(context);
        } else if (num != null && num.intValue() == 0) {
            this.b = new aa1(context);
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            aa1 aa1Var = this.b;
            if (aa1Var != null) {
                aa1Var.i();
            }
            q81 q81Var = this.a;
            if (q81Var != null) {
                q81Var.h();
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            aa1 aa1Var = this.b;
            if (aa1Var != null) {
                aa1Var.l();
            }
            q81 q81Var = this.a;
            if (q81Var != null) {
                q81Var.k();
            }
        }
    }

    public final void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            aa1 aa1Var = this.b;
            if (aa1Var != null) {
                aa1Var.o(z);
            }
            q81 q81Var = this.a;
            if (q81Var != null) {
                q81Var.n(z);
            }
        }
    }
}
