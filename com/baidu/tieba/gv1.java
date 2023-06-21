package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class gv1 implements wx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public gv1() {
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

    @Override // com.baidu.tieba.wx1
    public void a(Context context, sq3<Boolean> sq3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, sq3Var) != null) || sq3Var == null) {
            return;
        }
        sq3Var.a(null);
    }

    @Override // com.baidu.tieba.wx1
    public void b(boolean z, sq3<String> sq3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, sq3Var) != null) || sq3Var == null) {
            return;
        }
        sq3Var.a(null);
    }

    @Override // com.baidu.tieba.wx1
    public void c(Context context, sq3<String> sq3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, sq3Var) != null) || sq3Var == null) {
            return;
        }
        sq3Var.a(null);
    }

    @Override // com.baidu.tieba.wx1
    public void d(sq3<Integer> sq3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, sq3Var) != null) || sq3Var == null) {
            return;
        }
        sq3Var.a(null);
    }
}
