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
/* loaded from: classes6.dex */
public class fs4 implements yv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fs4() {
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

    @Override // com.baidu.tieba.yv1
    public or2 a(ZeusPluginFactory.Invoker invoker, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, invoker, str)) == null) {
            return new hs4();
        }
        return (or2) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.yv1
    public ot2 b(ZeusPluginFactory.Invoker invoker, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, invoker, str)) == null) {
            return new ks4(invoker, str);
        }
        return (ot2) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.yv1
    public ot2 c(ZeusPluginFactory.Invoker invoker, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, invoker, str)) == null) {
            return new js4(invoker, str);
        }
        return (ot2) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.yv1
    public nr2 d(ZeusPluginFactory.Invoker invoker, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, invoker, str)) == null) {
            return new gs4();
        }
        return (nr2) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.yv1
    public lp2 e(ZeusPluginFactory.Invoker invoker, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, invoker, str)) == null) {
            return new us4(invoker, str);
        }
        return (lp2) invokeLL.objValue;
    }
}
