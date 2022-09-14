package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fm1 implements vo1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fm1() {
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

    @Override // com.baidu.tieba.vo1
    public void a(Context context, rh3<Boolean> rh3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, rh3Var) == null) || rh3Var == null) {
            return;
        }
        rh3Var.a(null);
    }

    @Override // com.baidu.tieba.vo1
    public void b(boolean z, rh3<String> rh3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, rh3Var) == null) || rh3Var == null) {
            return;
        }
        rh3Var.a(null);
    }

    @Override // com.baidu.tieba.vo1
    public void c(Context context, rh3<String> rh3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, rh3Var) == null) || rh3Var == null) {
            return;
        }
        rh3Var.a(null);
    }

    @Override // com.baidu.tieba.vo1
    public void d(rh3<Integer> rh3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, rh3Var) == null) || rh3Var == null) {
            return;
        }
        rh3Var.a(null);
    }
}
