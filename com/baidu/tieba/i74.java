package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
/* loaded from: classes4.dex */
public class i74 implements zm2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public i74() {
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

    @Override // com.baidu.tieba.zm2
    public boolean a(Context context, op2 op2Var, hp2 hp2Var, y23 y23Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, op2Var, hp2Var, y23Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zm2
    public boolean b(Context context, jp2 jp2Var, hp2 hp2Var, y23 y23Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jp2Var, hp2Var, y23Var)) == null) ? r74.e().c(context, jp2Var, hp2Var, y23Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zm2
    public boolean c(Context context, kp2 kp2Var, hp2 hp2Var, y23 y23Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, kp2Var, hp2Var, y23Var)) == null) ? q74.d().c(context, kp2Var, hp2Var, y23Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zm2
    public void d(ep1 ep1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ep1Var) == null) {
            h74.h(ep1Var);
        }
    }

    @Override // com.baidu.tieba.zm2
    public boolean e(Context context, ip2 ip2Var, hp2 hp2Var, y23 y23Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, ip2Var, hp2Var, y23Var)) == null) ? o84.h().c(context, ip2Var, hp2Var, y23Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zm2
    public void f(ep1 ep1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ep1Var) == null) {
            h74.d(ep1Var);
        }
    }

    @Override // com.baidu.tieba.zm2
    public boolean g(Context context, kp2 kp2Var, hp2 hp2Var, y23 y23Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, kp2Var, hp2Var, y23Var)) == null) ? l74.e().c(context, kp2Var, hp2Var, y23Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zm2
    public boolean h(Context context, mp2 mp2Var, hp2 hp2Var, y23 y23Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, mp2Var, hp2Var, y23Var)) == null) ? t74.e().c(context, mp2Var, hp2Var, y23Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zm2
    public void i(ep1 ep1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ep1Var) == null) {
            h74.e(ep1Var);
        }
    }

    @Override // com.baidu.tieba.zm2
    public boolean j(Context context, np2 np2Var, hp2 hp2Var, y23 y23Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, np2Var, hp2Var, y23Var)) == null) ? u74.e().c(context, np2Var, hp2Var, y23Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zm2
    public boolean k(Context context, kp2 kp2Var, hp2 hp2Var, y23 y23Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, kp2Var, hp2Var, y23Var)) == null) ? o74.d().c(context, kp2Var, hp2Var, y23Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zm2
    public boolean l(Context context, kp2 kp2Var, hp2 hp2Var, y23 y23Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, kp2Var, hp2Var, y23Var)) == null) ? m74.d().c(context, kp2Var, hp2Var, y23Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zm2
    public boolean m(Context context, kp2 kp2Var, hp2 hp2Var, y23 y23Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, kp2Var, hp2Var, y23Var)) == null) ? s74.f().c(context, kp2Var, hp2Var, y23Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zm2
    public boolean n(Context context, kp2 kp2Var, hp2 hp2Var, y23 y23Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, kp2Var, hp2Var, y23Var)) == null) ? p74.d().c(context, kp2Var, hp2Var, y23Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zm2
    public boolean update(Context context, kp2 kp2Var, hp2 hp2Var, y23 y23Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, kp2Var, hp2Var, y23Var)) == null) ? n74.d().c(context, kp2Var, hp2Var, y23Var) : invokeLLLL.booleanValue;
    }
}
