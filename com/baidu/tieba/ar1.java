package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ar1 implements qt1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ar1() {
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

    @Override // com.baidu.tieba.qt1
    public void a(Context context, mm3<Boolean> mm3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, mm3Var) != null) || mm3Var == null) {
            return;
        }
        mm3Var.a(null);
    }

    @Override // com.baidu.tieba.qt1
    public void b(boolean z, mm3<String> mm3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, mm3Var) != null) || mm3Var == null) {
            return;
        }
        mm3Var.a(null);
    }

    @Override // com.baidu.tieba.qt1
    public void c(Context context, mm3<String> mm3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, mm3Var) != null) || mm3Var == null) {
            return;
        }
        mm3Var.a(null);
    }

    @Override // com.baidu.tieba.qt1
    public void d(mm3<Integer> mm3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, mm3Var) != null) || mm3Var == null) {
            return;
        }
        mm3Var.a(null);
    }
}
