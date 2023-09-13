package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.sac;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class hfc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Deprecated
    public <T> sac.a<T> a(sac.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? aVar : (sac.a) invokeL.objValue;
    }

    @Deprecated
    public <T, R> sac.b<? extends R, ? super T> b(sac.b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) ? bVar : (sac.b) invokeL.objValue;
    }

    @Deprecated
    public <T> Throwable c(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th)) == null) ? th : (Throwable) invokeL.objValue;
    }

    @Deprecated
    public <T> zac d(zac zacVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, zacVar)) == null) ? zacVar : (zac) invokeL.objValue;
    }

    @Deprecated
    public <T> sac.a<T> e(sac<? extends T> sacVar, sac.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, sacVar, aVar)) == null) ? aVar : (sac.a) invokeLL.objValue;
    }

    public hfc() {
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
}
