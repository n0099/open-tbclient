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
/* loaded from: classes5.dex */
public class fg4 implements wv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.wv2
    public boolean a(Context context, ly2 ly2Var, ey2 ey2Var, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, ly2Var, ey2Var, vb3Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public fg4() {
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

    @Override // com.baidu.tieba.wv2
    public boolean b(Context context, gy2 gy2Var, ey2 ey2Var, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, gy2Var, ey2Var, vb3Var)) == null) {
            return og4.e().c(context, gy2Var, ey2Var, vb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wv2
    public boolean c(Context context, hy2 hy2Var, ey2 ey2Var, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, hy2Var, ey2Var, vb3Var)) == null) {
            return ng4.d().c(context, hy2Var, ey2Var, vb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wv2
    public boolean e(Context context, fy2 fy2Var, ey2 ey2Var, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, fy2Var, ey2Var, vb3Var)) == null) {
            return lh4.h().c(context, fy2Var, ey2Var, vb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wv2
    public boolean g(Context context, hy2 hy2Var, ey2 ey2Var, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, hy2Var, ey2Var, vb3Var)) == null) {
            return ig4.e().c(context, hy2Var, ey2Var, vb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wv2
    public boolean h(Context context, jy2 jy2Var, ey2 ey2Var, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, jy2Var, ey2Var, vb3Var)) == null) {
            return qg4.e().c(context, jy2Var, ey2Var, vb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wv2
    public boolean j(Context context, ky2 ky2Var, ey2 ey2Var, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, ky2Var, ey2Var, vb3Var)) == null) {
            return rg4.e().c(context, ky2Var, ey2Var, vb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wv2
    public boolean k(Context context, hy2 hy2Var, ey2 ey2Var, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, hy2Var, ey2Var, vb3Var)) == null) {
            return lg4.d().c(context, hy2Var, ey2Var, vb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wv2
    public boolean l(Context context, hy2 hy2Var, ey2 ey2Var, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, hy2Var, ey2Var, vb3Var)) == null) {
            return jg4.d().c(context, hy2Var, ey2Var, vb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wv2
    public boolean m(Context context, hy2 hy2Var, ey2 ey2Var, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, hy2Var, ey2Var, vb3Var)) == null) {
            return pg4.f().c(context, hy2Var, ey2Var, vb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wv2
    public boolean n(Context context, hy2 hy2Var, ey2 ey2Var, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, hy2Var, ey2Var, vb3Var)) == null) {
            return mg4.d().c(context, hy2Var, ey2Var, vb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wv2
    public boolean update(Context context, hy2 hy2Var, ey2 ey2Var, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, hy2Var, ey2Var, vb3Var)) == null) {
            return kg4.d().c(context, hy2Var, ey2Var, vb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wv2
    public void d(by1 by1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, by1Var) == null) {
            eg4.h(by1Var);
        }
    }

    @Override // com.baidu.tieba.wv2
    public void f(by1 by1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, by1Var) == null) {
            eg4.d(by1Var);
        }
    }

    @Override // com.baidu.tieba.wv2
    public void i(by1 by1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, by1Var) == null) {
            eg4.e(by1Var);
        }
    }
}
