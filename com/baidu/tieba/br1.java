package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class br1 implements rt1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public br1() {
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

    @Override // com.baidu.tieba.rt1
    public void a(Context context, nm3<Boolean> nm3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, nm3Var) != null) || nm3Var == null) {
            return;
        }
        nm3Var.a(null);
    }

    @Override // com.baidu.tieba.rt1
    public void b(boolean z, nm3<String> nm3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, nm3Var) != null) || nm3Var == null) {
            return;
        }
        nm3Var.a(null);
    }

    @Override // com.baidu.tieba.rt1
    public void c(Context context, nm3<String> nm3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, nm3Var) != null) || nm3Var == null) {
            return;
        }
        nm3Var.a(null);
    }

    @Override // com.baidu.tieba.rt1
    public void d(nm3<Integer> nm3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, nm3Var) != null) || nm3Var == null) {
            return;
        }
        nm3Var.a(null);
    }
}
