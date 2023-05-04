package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class er1 implements ut1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public er1() {
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

    @Override // com.baidu.tieba.ut1
    public void a(Context context, qm3<Boolean> qm3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, qm3Var) != null) || qm3Var == null) {
            return;
        }
        qm3Var.a(null);
    }

    @Override // com.baidu.tieba.ut1
    public void b(boolean z, qm3<String> qm3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, qm3Var) != null) || qm3Var == null) {
            return;
        }
        qm3Var.a(null);
    }

    @Override // com.baidu.tieba.ut1
    public void c(Context context, qm3<String> qm3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, qm3Var) != null) || qm3Var == null) {
            return;
        }
        qm3Var.a(null);
    }

    @Override // com.baidu.tieba.ut1
    public void d(qm3<Integer> qm3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, qm3Var) != null) || qm3Var == null) {
            return;
        }
        qm3Var.a(null);
    }
}
