package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ad implements xc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    public ad(long j) {
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

    @Override // com.baidu.tieba.xc
    public Object a(ge geVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, geVar)) == null) {
            return Long.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.xc
    public Object b(ge geVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, geVar)) == null) {
            return Long.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.xc
    public Object c(ge geVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, geVar)) == null) {
            return Long.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.xc
    public Object d(ge geVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, geVar)) == null) {
            return Long.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.xc
    public Object e(ge geVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, geVar)) == null) {
            return d(geVar);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.xc
    public Object f(ge geVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, geVar)) == null) {
            return Long.valueOf(this.a);
        }
        return invokeL.objValue;
    }
}
