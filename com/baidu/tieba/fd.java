package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fd implements cd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    public fd(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = j;
    }

    @Override // com.baidu.tieba.cd
    public Object a(le leVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, leVar)) == null) {
            return Long.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.cd
    public Object b(le leVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, leVar)) == null) {
            return Long.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.cd
    public Object c(le leVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, leVar)) == null) {
            return Long.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.cd
    public Object d(le leVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, leVar)) == null) {
            return Long.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.cd
    public Object e(le leVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, leVar)) == null) {
            return d(leVar);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.cd
    public Object f(le leVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, leVar)) == null) {
            return Long.valueOf(this.a);
        }
        return invokeL.objValue;
    }
}
