package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.asynctask.BdAsyncTaskParallelType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
/* loaded from: classes5.dex */
public class fa0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ld0 a;
    public BdAsyncTaskParallelType b;
    public int c;

    public fa0(BdAsyncTaskParallelType bdAsyncTaskParallelType, ld0 ld0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdAsyncTaskParallelType, ld0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.c = 1;
        if (bdAsyncTaskParallelType != null && ld0Var != null) {
            this.b = bdAsyncTaskParallelType;
            this.a = ld0Var;
            return;
        }
        throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ld0 ld0Var = this.a;
            if (ld0Var == null) {
                return 0;
            }
            return ld0Var.b();
        }
        return invokeV.intValue;
    }

    public BdAsyncTaskParallelType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (BdAsyncTaskParallelType) invokeV.objValue;
    }
}
