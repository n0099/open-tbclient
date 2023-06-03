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
public class ig4 implements zv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.zv2
    public boolean a(Context context, oy2 oy2Var, hy2 hy2Var, yb3 yb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, oy2Var, hy2Var, yb3Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public ig4() {
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

    @Override // com.baidu.tieba.zv2
    public boolean b(Context context, jy2 jy2Var, hy2 hy2Var, yb3 yb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jy2Var, hy2Var, yb3Var)) == null) {
            return rg4.e().c(context, jy2Var, hy2Var, yb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zv2
    public boolean c(Context context, ky2 ky2Var, hy2 hy2Var, yb3 yb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, ky2Var, hy2Var, yb3Var)) == null) {
            return qg4.d().c(context, ky2Var, hy2Var, yb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zv2
    public boolean e(Context context, iy2 iy2Var, hy2 hy2Var, yb3 yb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, iy2Var, hy2Var, yb3Var)) == null) {
            return oh4.h().c(context, iy2Var, hy2Var, yb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zv2
    public boolean g(Context context, ky2 ky2Var, hy2 hy2Var, yb3 yb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, ky2Var, hy2Var, yb3Var)) == null) {
            return lg4.e().c(context, ky2Var, hy2Var, yb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zv2
    public boolean h(Context context, my2 my2Var, hy2 hy2Var, yb3 yb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, my2Var, hy2Var, yb3Var)) == null) {
            return tg4.e().c(context, my2Var, hy2Var, yb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zv2
    public boolean j(Context context, ny2 ny2Var, hy2 hy2Var, yb3 yb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, ny2Var, hy2Var, yb3Var)) == null) {
            return ug4.e().c(context, ny2Var, hy2Var, yb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zv2
    public boolean k(Context context, ky2 ky2Var, hy2 hy2Var, yb3 yb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, ky2Var, hy2Var, yb3Var)) == null) {
            return og4.d().c(context, ky2Var, hy2Var, yb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zv2
    public boolean l(Context context, ky2 ky2Var, hy2 hy2Var, yb3 yb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, ky2Var, hy2Var, yb3Var)) == null) {
            return mg4.d().c(context, ky2Var, hy2Var, yb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zv2
    public boolean m(Context context, ky2 ky2Var, hy2 hy2Var, yb3 yb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, ky2Var, hy2Var, yb3Var)) == null) {
            return sg4.f().c(context, ky2Var, hy2Var, yb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zv2
    public boolean n(Context context, ky2 ky2Var, hy2 hy2Var, yb3 yb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, ky2Var, hy2Var, yb3Var)) == null) {
            return pg4.d().c(context, ky2Var, hy2Var, yb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zv2
    public boolean update(Context context, ky2 ky2Var, hy2 hy2Var, yb3 yb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, ky2Var, hy2Var, yb3Var)) == null) {
            return ng4.d().c(context, ky2Var, hy2Var, yb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zv2
    public void d(ey1 ey1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ey1Var) == null) {
            hg4.h(ey1Var);
        }
    }

    @Override // com.baidu.tieba.zv2
    public void f(ey1 ey1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ey1Var) == null) {
            hg4.d(ey1Var);
        }
    }

    @Override // com.baidu.tieba.zv2
    public void i(ey1 ey1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ey1Var) == null) {
            hg4.e(ey1Var);
        }
    }
}
