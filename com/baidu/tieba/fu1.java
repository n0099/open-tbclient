package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class fu1 implements vw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fu1() {
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

    @Override // com.baidu.tieba.vw1
    public void a(Context context, rp3<Boolean> rp3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, rp3Var) != null) || rp3Var == null) {
            return;
        }
        rp3Var.a(null);
    }

    @Override // com.baidu.tieba.vw1
    public void b(boolean z, rp3<String> rp3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, rp3Var) != null) || rp3Var == null) {
            return;
        }
        rp3Var.a(null);
    }

    @Override // com.baidu.tieba.vw1
    public void c(Context context, rp3<String> rp3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, rp3Var) != null) || rp3Var == null) {
            return;
        }
        rp3Var.a(null);
    }

    @Override // com.baidu.tieba.vw1
    public void d(rp3<Integer> rp3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, rp3Var) != null) || rp3Var == null) {
            return;
        }
        rp3Var.a(null);
    }
}
