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
public class gd4 implements xs2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.xs2
    public boolean a(Context context, mv2 mv2Var, fv2 fv2Var, w83 w83Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, mv2Var, fv2Var, w83Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public gd4() {
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

    @Override // com.baidu.tieba.xs2
    public boolean b(Context context, hv2 hv2Var, fv2 fv2Var, w83 w83Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, hv2Var, fv2Var, w83Var)) == null) {
            return pd4.e().c(context, hv2Var, fv2Var, w83Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.xs2
    public boolean c(Context context, iv2 iv2Var, fv2 fv2Var, w83 w83Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, iv2Var, fv2Var, w83Var)) == null) {
            return od4.d().c(context, iv2Var, fv2Var, w83Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.xs2
    public boolean e(Context context, gv2 gv2Var, fv2 fv2Var, w83 w83Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, gv2Var, fv2Var, w83Var)) == null) {
            return me4.h().c(context, gv2Var, fv2Var, w83Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.xs2
    public boolean g(Context context, iv2 iv2Var, fv2 fv2Var, w83 w83Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, iv2Var, fv2Var, w83Var)) == null) {
            return jd4.e().c(context, iv2Var, fv2Var, w83Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.xs2
    public boolean h(Context context, kv2 kv2Var, fv2 fv2Var, w83 w83Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, kv2Var, fv2Var, w83Var)) == null) {
            return rd4.e().c(context, kv2Var, fv2Var, w83Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.xs2
    public boolean j(Context context, lv2 lv2Var, fv2 fv2Var, w83 w83Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, lv2Var, fv2Var, w83Var)) == null) {
            return sd4.e().c(context, lv2Var, fv2Var, w83Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.xs2
    public boolean k(Context context, iv2 iv2Var, fv2 fv2Var, w83 w83Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, iv2Var, fv2Var, w83Var)) == null) {
            return md4.d().c(context, iv2Var, fv2Var, w83Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.xs2
    public boolean l(Context context, iv2 iv2Var, fv2 fv2Var, w83 w83Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, iv2Var, fv2Var, w83Var)) == null) {
            return kd4.d().c(context, iv2Var, fv2Var, w83Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.xs2
    public boolean m(Context context, iv2 iv2Var, fv2 fv2Var, w83 w83Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, iv2Var, fv2Var, w83Var)) == null) {
            return qd4.f().c(context, iv2Var, fv2Var, w83Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.xs2
    public boolean n(Context context, iv2 iv2Var, fv2 fv2Var, w83 w83Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, iv2Var, fv2Var, w83Var)) == null) {
            return nd4.d().c(context, iv2Var, fv2Var, w83Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.xs2
    public boolean update(Context context, iv2 iv2Var, fv2 fv2Var, w83 w83Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, iv2Var, fv2Var, w83Var)) == null) {
            return ld4.d().c(context, iv2Var, fv2Var, w83Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.xs2
    public void d(cv1 cv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cv1Var) == null) {
            fd4.h(cv1Var);
        }
    }

    @Override // com.baidu.tieba.xs2
    public void f(cv1 cv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cv1Var) == null) {
            fd4.d(cv1Var);
        }
    }

    @Override // com.baidu.tieba.xs2
    public void i(cv1 cv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cv1Var) == null) {
            fd4.e(cv1Var);
        }
    }
}
