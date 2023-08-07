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
/* loaded from: classes6.dex */
public class if4 implements zu2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.zu2
    public boolean a(Context context, ox2 ox2Var, hx2 hx2Var, ya3 ya3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, ox2Var, hx2Var, ya3Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public if4() {
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

    @Override // com.baidu.tieba.zu2
    public boolean b(Context context, jx2 jx2Var, hx2 hx2Var, ya3 ya3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jx2Var, hx2Var, ya3Var)) == null) {
            return rf4.e().c(context, jx2Var, hx2Var, ya3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zu2
    public boolean c(Context context, kx2 kx2Var, hx2 hx2Var, ya3 ya3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, kx2Var, hx2Var, ya3Var)) == null) {
            return qf4.d().c(context, kx2Var, hx2Var, ya3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zu2
    public boolean e(Context context, ix2 ix2Var, hx2 hx2Var, ya3 ya3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, ix2Var, hx2Var, ya3Var)) == null) {
            return og4.h().c(context, ix2Var, hx2Var, ya3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zu2
    public boolean g(Context context, kx2 kx2Var, hx2 hx2Var, ya3 ya3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, kx2Var, hx2Var, ya3Var)) == null) {
            return lf4.e().c(context, kx2Var, hx2Var, ya3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zu2
    public boolean h(Context context, mx2 mx2Var, hx2 hx2Var, ya3 ya3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, mx2Var, hx2Var, ya3Var)) == null) {
            return tf4.e().c(context, mx2Var, hx2Var, ya3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zu2
    public boolean j(Context context, nx2 nx2Var, hx2 hx2Var, ya3 ya3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, nx2Var, hx2Var, ya3Var)) == null) {
            return uf4.e().c(context, nx2Var, hx2Var, ya3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zu2
    public boolean k(Context context, kx2 kx2Var, hx2 hx2Var, ya3 ya3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, kx2Var, hx2Var, ya3Var)) == null) {
            return of4.d().c(context, kx2Var, hx2Var, ya3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zu2
    public boolean l(Context context, kx2 kx2Var, hx2 hx2Var, ya3 ya3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, kx2Var, hx2Var, ya3Var)) == null) {
            return mf4.d().c(context, kx2Var, hx2Var, ya3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zu2
    public boolean m(Context context, kx2 kx2Var, hx2 hx2Var, ya3 ya3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, kx2Var, hx2Var, ya3Var)) == null) {
            return sf4.f().c(context, kx2Var, hx2Var, ya3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zu2
    public boolean n(Context context, kx2 kx2Var, hx2 hx2Var, ya3 ya3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, kx2Var, hx2Var, ya3Var)) == null) {
            return pf4.d().c(context, kx2Var, hx2Var, ya3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zu2
    public boolean update(Context context, kx2 kx2Var, hx2 hx2Var, ya3 ya3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, kx2Var, hx2Var, ya3Var)) == null) {
            return nf4.d().c(context, kx2Var, hx2Var, ya3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zu2
    public void d(ex1 ex1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ex1Var) == null) {
            hf4.h(ex1Var);
        }
    }

    @Override // com.baidu.tieba.zu2
    public void f(ex1 ex1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ex1Var) == null) {
            hf4.d(ex1Var);
        }
    }

    @Override // com.baidu.tieba.zu2
    public void i(ex1 ex1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ex1Var) == null) {
            hf4.e(ex1Var);
        }
    }
}
