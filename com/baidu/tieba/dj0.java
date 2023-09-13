package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes5.dex */
public abstract class dj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract String a();

    public dj0() {
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

    @CallSuper
    public boolean b(@NonNull Context context, @NonNull hj0 hj0Var, @Nullable Map<String, Object> map, @Nullable lj0 lj0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, hj0Var, map, lj0Var)) == null) {
            y31.b((String) j31.b(hj0Var.d(), "charge_url"));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public void c(lj0 lj0Var, @Nullable hj0 hj0Var, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{lj0Var, hj0Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            qj0.b(lj0Var, hj0Var, i, z);
        }
    }

    public void d(lj0 lj0Var, @Nullable hj0 hj0Var, @Nullable String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{lj0Var, hj0Var, str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            qj0.c(lj0Var, hj0Var, str, i, z);
        }
    }
}
