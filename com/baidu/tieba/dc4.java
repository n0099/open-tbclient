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
public class dc4 implements ur2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ur2
    public boolean a(Context context, ju2 ju2Var, cu2 cu2Var, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, ju2Var, cu2Var, t73Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public dc4() {
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

    @Override // com.baidu.tieba.ur2
    public boolean b(Context context, eu2 eu2Var, cu2 cu2Var, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, eu2Var, cu2Var, t73Var)) == null) {
            return mc4.e().c(context, eu2Var, cu2Var, t73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ur2
    public boolean c(Context context, fu2 fu2Var, cu2 cu2Var, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, fu2Var, cu2Var, t73Var)) == null) {
            return lc4.d().c(context, fu2Var, cu2Var, t73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ur2
    public boolean e(Context context, du2 du2Var, cu2 cu2Var, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, du2Var, cu2Var, t73Var)) == null) {
            return jd4.h().c(context, du2Var, cu2Var, t73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ur2
    public boolean g(Context context, fu2 fu2Var, cu2 cu2Var, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, fu2Var, cu2Var, t73Var)) == null) {
            return gc4.e().c(context, fu2Var, cu2Var, t73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ur2
    public boolean h(Context context, hu2 hu2Var, cu2 cu2Var, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, hu2Var, cu2Var, t73Var)) == null) {
            return oc4.e().c(context, hu2Var, cu2Var, t73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ur2
    public boolean j(Context context, iu2 iu2Var, cu2 cu2Var, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, iu2Var, cu2Var, t73Var)) == null) {
            return pc4.e().c(context, iu2Var, cu2Var, t73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ur2
    public boolean k(Context context, fu2 fu2Var, cu2 cu2Var, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, fu2Var, cu2Var, t73Var)) == null) {
            return jc4.d().c(context, fu2Var, cu2Var, t73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ur2
    public boolean l(Context context, fu2 fu2Var, cu2 cu2Var, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, fu2Var, cu2Var, t73Var)) == null) {
            return hc4.d().c(context, fu2Var, cu2Var, t73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ur2
    public boolean m(Context context, fu2 fu2Var, cu2 cu2Var, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, fu2Var, cu2Var, t73Var)) == null) {
            return nc4.f().c(context, fu2Var, cu2Var, t73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ur2
    public boolean n(Context context, fu2 fu2Var, cu2 cu2Var, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, fu2Var, cu2Var, t73Var)) == null) {
            return kc4.d().c(context, fu2Var, cu2Var, t73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ur2
    public boolean update(Context context, fu2 fu2Var, cu2 cu2Var, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, fu2Var, cu2Var, t73Var)) == null) {
            return ic4.d().c(context, fu2Var, cu2Var, t73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ur2
    public void d(zt1 zt1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, zt1Var) == null) {
            cc4.h(zt1Var);
        }
    }

    @Override // com.baidu.tieba.ur2
    public void f(zt1 zt1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, zt1Var) == null) {
            cc4.d(zt1Var);
        }
    }

    @Override // com.baidu.tieba.ur2
    public void i(zt1 zt1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zt1Var) == null) {
            cc4.e(zt1Var);
        }
    }
}
