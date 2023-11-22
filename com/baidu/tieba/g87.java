package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g87 extends d87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public g87() {
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

    @Override // com.baidu.tieba.d87
    @Nullable
    public Object e(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (str.hashCode() == 155229553 && str.equals("click_back_card")) {
                c = 0;
            } else {
                c = 65535;
            }
            if (c != 0) {
                return super.e(str, str2);
            }
            return wz4.b(str2);
        }
        return invokeLL.objValue;
    }

    @Override // com.baidu.tieba.d87
    @NonNull
    public ab7<?> h(@NonNull f57<?> f57Var, @NonNull a67 a67Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f57Var, a67Var)) == null) {
            o57 o57Var = new o57();
            o57Var.c = f57Var;
            o57Var.b = a67Var.a();
            o57Var.a = a67Var.c();
            return o57Var;
        }
        return (ab7) invokeLL.objValue;
    }
}
