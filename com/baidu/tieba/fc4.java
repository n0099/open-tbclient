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
public class fc4 implements wr2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.wr2
    public boolean a(Context context, lu2 lu2Var, eu2 eu2Var, v73 v73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, lu2Var, eu2Var, v73Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public fc4() {
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

    @Override // com.baidu.tieba.wr2
    public boolean b(Context context, gu2 gu2Var, eu2 eu2Var, v73 v73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, gu2Var, eu2Var, v73Var)) == null) {
            return oc4.e().c(context, gu2Var, eu2Var, v73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wr2
    public boolean c(Context context, hu2 hu2Var, eu2 eu2Var, v73 v73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, hu2Var, eu2Var, v73Var)) == null) {
            return nc4.d().c(context, hu2Var, eu2Var, v73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wr2
    public boolean e(Context context, fu2 fu2Var, eu2 eu2Var, v73 v73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, fu2Var, eu2Var, v73Var)) == null) {
            return ld4.h().c(context, fu2Var, eu2Var, v73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wr2
    public boolean g(Context context, hu2 hu2Var, eu2 eu2Var, v73 v73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, hu2Var, eu2Var, v73Var)) == null) {
            return ic4.e().c(context, hu2Var, eu2Var, v73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wr2
    public boolean h(Context context, ju2 ju2Var, eu2 eu2Var, v73 v73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, ju2Var, eu2Var, v73Var)) == null) {
            return qc4.e().c(context, ju2Var, eu2Var, v73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wr2
    public boolean j(Context context, ku2 ku2Var, eu2 eu2Var, v73 v73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, ku2Var, eu2Var, v73Var)) == null) {
            return rc4.e().c(context, ku2Var, eu2Var, v73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wr2
    public boolean k(Context context, hu2 hu2Var, eu2 eu2Var, v73 v73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, hu2Var, eu2Var, v73Var)) == null) {
            return lc4.d().c(context, hu2Var, eu2Var, v73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wr2
    public boolean l(Context context, hu2 hu2Var, eu2 eu2Var, v73 v73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, hu2Var, eu2Var, v73Var)) == null) {
            return jc4.d().c(context, hu2Var, eu2Var, v73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wr2
    public boolean m(Context context, hu2 hu2Var, eu2 eu2Var, v73 v73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, hu2Var, eu2Var, v73Var)) == null) {
            return pc4.f().c(context, hu2Var, eu2Var, v73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wr2
    public boolean n(Context context, hu2 hu2Var, eu2 eu2Var, v73 v73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, hu2Var, eu2Var, v73Var)) == null) {
            return mc4.d().c(context, hu2Var, eu2Var, v73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wr2
    public boolean update(Context context, hu2 hu2Var, eu2 eu2Var, v73 v73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, hu2Var, eu2Var, v73Var)) == null) {
            return kc4.d().c(context, hu2Var, eu2Var, v73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wr2
    public void d(bu1 bu1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bu1Var) == null) {
            ec4.h(bu1Var);
        }
    }

    @Override // com.baidu.tieba.wr2
    public void f(bu1 bu1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bu1Var) == null) {
            ec4.d(bu1Var);
        }
    }

    @Override // com.baidu.tieba.wr2
    public void i(bu1 bu1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bu1Var) == null) {
            ec4.e(bu1Var);
        }
    }
}
