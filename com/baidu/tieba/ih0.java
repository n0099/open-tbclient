package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
@Service
/* loaded from: classes6.dex */
public class ih0 extends dj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.dj0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "onDownloadBtnClick" : (String) invokeV.objValue;
    }

    public ih0() {
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

    @Override // com.baidu.tieba.dj0
    public boolean b(@NonNull Context context, @NonNull hj0 hj0Var, @Nullable Map<String, Object> map, @Nullable lj0 lj0Var) {
        InterceptResult invokeLLLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, hj0Var, map, lj0Var)) == null) {
            boolean b = super.b(context, hj0Var, map, lj0Var);
            if (b) {
                i = 0;
            } else {
                i = 1001;
            }
            c(lj0Var, hj0Var, i, b);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
