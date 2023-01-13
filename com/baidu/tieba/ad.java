package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ad implements dd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public char a;

    public ad(char c) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Character.valueOf(c)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = c;
    }

    @Override // com.baidu.tieba.dd
    public Object a(me meVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, meVar)) == null) {
            return String.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.dd
    public Object b(me meVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, meVar)) == null) {
            return Character.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.dd
    public Object c(me meVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, meVar)) == null) {
            return Character.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.dd
    public Object d(me meVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, meVar)) == null) {
            return Character.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.dd
    public Object e(me meVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, meVar)) == null) {
            return d(meVar);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.dd
    public Object f(me meVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, meVar)) == null) {
            return String.valueOf(this.a);
        }
        return invokeL.objValue;
    }
}
