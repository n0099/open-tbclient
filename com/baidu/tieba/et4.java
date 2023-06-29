package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
@Service
/* loaded from: classes5.dex */
public class et4 implements xw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public et4() {
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

    @Override // com.baidu.tieba.xw1
    public ns2 a(ZeusPluginFactory.Invoker invoker, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, invoker, str)) == null) {
            return new gt4();
        }
        return (ns2) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.xw1
    public nu2 b(ZeusPluginFactory.Invoker invoker, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, invoker, str)) == null) {
            return new jt4(invoker, str);
        }
        return (nu2) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.xw1
    public nu2 c(ZeusPluginFactory.Invoker invoker, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, invoker, str)) == null) {
            return new it4(invoker, str);
        }
        return (nu2) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.xw1
    public ms2 d(ZeusPluginFactory.Invoker invoker, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, invoker, str)) == null) {
            return new ft4();
        }
        return (ms2) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.xw1
    public kq2 e(ZeusPluginFactory.Invoker invoker, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, invoker, str)) == null) {
            return new tt4(invoker, str);
        }
        return (kq2) invokeLL.objValue;
    }
}
