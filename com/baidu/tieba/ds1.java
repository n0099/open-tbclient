package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ds1 implements tu1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ds1() {
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

    @Override // com.baidu.tieba.tu1
    public void a(Context context, pn3<Boolean> pn3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, pn3Var) != null) || pn3Var == null) {
            return;
        }
        pn3Var.a(null);
    }

    @Override // com.baidu.tieba.tu1
    public void b(boolean z, pn3<String> pn3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, pn3Var) != null) || pn3Var == null) {
            return;
        }
        pn3Var.a(null);
    }

    @Override // com.baidu.tieba.tu1
    public void c(Context context, pn3<String> pn3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, pn3Var) != null) || pn3Var == null) {
            return;
        }
        pn3Var.a(null);
    }

    @Override // com.baidu.tieba.tu1
    public void d(pn3<Integer> pn3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, pn3Var) != null) || pn3Var == null) {
            return;
        }
        pn3Var.a(null);
    }
}
