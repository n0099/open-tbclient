package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c8 implements b8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    public c8(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
    }

    @Override // com.baidu.tieba.b8
    public Object a(k9 k9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k9Var)) == null) {
            return Integer.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.b8
    public Object b(k9 k9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k9Var)) == null) {
            return Integer.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.b8
    public Object c(k9 k9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k9Var)) == null) {
            return Integer.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.b8
    public Object d(k9 k9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, k9Var)) == null) {
            return Integer.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.b8
    public Object e(k9 k9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, k9Var)) == null) {
            return d(k9Var);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.b8
    public Object f(k9 k9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, k9Var)) == null) {
            return Integer.valueOf(this.a);
        }
        return invokeL.objValue;
    }
}
