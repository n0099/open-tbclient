package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class cr1 implements st1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public cr1() {
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

    @Override // com.baidu.tieba.st1
    public void a(Context context, om3<Boolean> om3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, om3Var) != null) || om3Var == null) {
            return;
        }
        om3Var.a(null);
    }

    @Override // com.baidu.tieba.st1
    public void b(boolean z, om3<String> om3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, om3Var) != null) || om3Var == null) {
            return;
        }
        om3Var.a(null);
    }

    @Override // com.baidu.tieba.st1
    public void c(Context context, om3<String> om3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, om3Var) != null) || om3Var == null) {
            return;
        }
        om3Var.a(null);
    }

    @Override // com.baidu.tieba.st1
    public void d(om3<Integer> om3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, om3Var) != null) || om3Var == null) {
            return;
        }
        om3Var.a(null);
    }
}
