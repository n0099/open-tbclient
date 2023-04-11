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
public class ec4 implements vr2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.vr2
    public boolean a(Context context, ku2 ku2Var, du2 du2Var, u73 u73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, ku2Var, du2Var, u73Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public ec4() {
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

    @Override // com.baidu.tieba.vr2
    public boolean b(Context context, fu2 fu2Var, du2 du2Var, u73 u73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, fu2Var, du2Var, u73Var)) == null) {
            return nc4.e().c(context, fu2Var, du2Var, u73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.vr2
    public boolean c(Context context, gu2 gu2Var, du2 du2Var, u73 u73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, gu2Var, du2Var, u73Var)) == null) {
            return mc4.d().c(context, gu2Var, du2Var, u73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.vr2
    public boolean e(Context context, eu2 eu2Var, du2 du2Var, u73 u73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, eu2Var, du2Var, u73Var)) == null) {
            return kd4.h().c(context, eu2Var, du2Var, u73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.vr2
    public boolean g(Context context, gu2 gu2Var, du2 du2Var, u73 u73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, gu2Var, du2Var, u73Var)) == null) {
            return hc4.e().c(context, gu2Var, du2Var, u73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.vr2
    public boolean h(Context context, iu2 iu2Var, du2 du2Var, u73 u73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, iu2Var, du2Var, u73Var)) == null) {
            return pc4.e().c(context, iu2Var, du2Var, u73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.vr2
    public boolean j(Context context, ju2 ju2Var, du2 du2Var, u73 u73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, ju2Var, du2Var, u73Var)) == null) {
            return qc4.e().c(context, ju2Var, du2Var, u73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.vr2
    public boolean k(Context context, gu2 gu2Var, du2 du2Var, u73 u73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, gu2Var, du2Var, u73Var)) == null) {
            return kc4.d().c(context, gu2Var, du2Var, u73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.vr2
    public boolean l(Context context, gu2 gu2Var, du2 du2Var, u73 u73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, gu2Var, du2Var, u73Var)) == null) {
            return ic4.d().c(context, gu2Var, du2Var, u73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.vr2
    public boolean m(Context context, gu2 gu2Var, du2 du2Var, u73 u73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, gu2Var, du2Var, u73Var)) == null) {
            return oc4.f().c(context, gu2Var, du2Var, u73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.vr2
    public boolean n(Context context, gu2 gu2Var, du2 du2Var, u73 u73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, gu2Var, du2Var, u73Var)) == null) {
            return lc4.d().c(context, gu2Var, du2Var, u73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.vr2
    public boolean update(Context context, gu2 gu2Var, du2 du2Var, u73 u73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, gu2Var, du2Var, u73Var)) == null) {
            return jc4.d().c(context, gu2Var, du2Var, u73Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.vr2
    public void d(au1 au1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, au1Var) == null) {
            dc4.h(au1Var);
        }
    }

    @Override // com.baidu.tieba.vr2
    public void f(au1 au1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, au1Var) == null) {
            dc4.d(au1Var);
        }
    }

    @Override // com.baidu.tieba.vr2
    public void i(au1 au1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, au1Var) == null) {
            dc4.e(au1Var);
        }
    }
}
