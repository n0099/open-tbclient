package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ad implements bd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    public ad(float f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = f;
    }

    @Override // com.baidu.tieba.bd
    public Object a(ke keVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, keVar)) == null) {
            return Float.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.bd
    public Object b(ke keVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, keVar)) == null) {
            return Float.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.bd
    public Object c(ke keVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, keVar)) == null) {
            return Float.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.bd
    public Object d(ke keVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, keVar)) == null) {
            return Float.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.bd
    public Object e(ke keVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, keVar)) == null) {
            return d(keVar);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.bd
    public Object f(ke keVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, keVar)) == null) {
            return Double.valueOf(this.a);
        }
        return invokeL.objValue;
    }
}
