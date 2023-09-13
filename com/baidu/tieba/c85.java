package com.baidu.tieba;

import com.baidu.tbadk.util.AppLaunchInfoFetcher;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c85 implements AppLaunchInfoFetcher.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c85() {
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

    @Override // com.baidu.tbadk.util.AppLaunchInfoFetcher.a
    public void onFinish(jx5 jx5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jx5Var) == null) && jx5Var != null) {
            d85.a().c(jx5Var.b);
        }
    }
}
