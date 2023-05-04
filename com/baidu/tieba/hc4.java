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
public class hc4 implements yr2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.yr2
    public boolean a(Context context, nu2 nu2Var, gu2 gu2Var, x73 x73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, nu2Var, gu2Var, x73Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public hc4() {
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

    @Override // com.baidu.tieba.yr2
    public boolean b(Context context, iu2 iu2Var, gu2 gu2Var, x73 x73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, iu2Var, gu2Var, x73Var)) == null) {
            return qc4.e().c(context, iu2Var, gu2Var, x73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.yr2
    public boolean c(Context context, ju2 ju2Var, gu2 gu2Var, x73 x73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, ju2Var, gu2Var, x73Var)) == null) {
            return pc4.d().c(context, ju2Var, gu2Var, x73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.yr2
    public boolean e(Context context, hu2 hu2Var, gu2 gu2Var, x73 x73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, hu2Var, gu2Var, x73Var)) == null) {
            return nd4.h().c(context, hu2Var, gu2Var, x73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.yr2
    public boolean g(Context context, ju2 ju2Var, gu2 gu2Var, x73 x73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, ju2Var, gu2Var, x73Var)) == null) {
            return kc4.e().c(context, ju2Var, gu2Var, x73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.yr2
    public boolean h(Context context, lu2 lu2Var, gu2 gu2Var, x73 x73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, lu2Var, gu2Var, x73Var)) == null) {
            return sc4.e().c(context, lu2Var, gu2Var, x73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.yr2
    public boolean j(Context context, mu2 mu2Var, gu2 gu2Var, x73 x73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, mu2Var, gu2Var, x73Var)) == null) {
            return tc4.e().c(context, mu2Var, gu2Var, x73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.yr2
    public boolean k(Context context, ju2 ju2Var, gu2 gu2Var, x73 x73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, ju2Var, gu2Var, x73Var)) == null) {
            return nc4.d().c(context, ju2Var, gu2Var, x73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.yr2
    public boolean l(Context context, ju2 ju2Var, gu2 gu2Var, x73 x73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, ju2Var, gu2Var, x73Var)) == null) {
            return lc4.d().c(context, ju2Var, gu2Var, x73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.yr2
    public boolean m(Context context, ju2 ju2Var, gu2 gu2Var, x73 x73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, ju2Var, gu2Var, x73Var)) == null) {
            return rc4.f().c(context, ju2Var, gu2Var, x73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.yr2
    public boolean n(Context context, ju2 ju2Var, gu2 gu2Var, x73 x73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, ju2Var, gu2Var, x73Var)) == null) {
            return oc4.d().c(context, ju2Var, gu2Var, x73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.yr2
    public boolean update(Context context, ju2 ju2Var, gu2 gu2Var, x73 x73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, ju2Var, gu2Var, x73Var)) == null) {
            return mc4.d().c(context, ju2Var, gu2Var, x73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.yr2
    public void d(du1 du1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, du1Var) == null) {
            gc4.h(du1Var);
        }
    }

    @Override // com.baidu.tieba.yr2
    public void f(du1 du1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, du1Var) == null) {
            gc4.d(du1Var);
        }
    }

    @Override // com.baidu.tieba.yr2
    public void i(du1 du1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, du1Var) == null) {
            gc4.e(du1Var);
        }
    }
}
