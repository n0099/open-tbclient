package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.tieba.ev1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
/* loaded from: classes5.dex */
public class es3 implements ev1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public es3() {
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

    @Override // com.baidu.tieba.ev1
    public void a(ev1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            aVar.onFinish();
        }
    }

    @Override // com.baidu.tieba.ev1
    public void c(vr1 vr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vr1Var) == null) {
            ir3.c(vr1Var);
        }
    }

    @Override // com.baidu.tieba.ev1
    public String d(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            return ir3.i(context);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ev1
    public boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            return ir3.F(context);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ev1
    public String f(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            return ir3.l(context);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ev1
    public void g(ev1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            cVar.a(true);
        }
    }

    @Override // com.baidu.tieba.ev1
    public String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            return ir3.y(context);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ev1
    public String i(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            return ir3.l(context);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ev1
    public void j(tr1 tr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tr1Var) == null) {
            new dt3().h(tr1Var);
        }
    }

    @Override // com.baidu.tieba.ev1
    public void b(Activity activity, Bundle bundle, tr1 tr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bundle, tr1Var) == null) {
            ir3.M(activity, false, bundle, tr1Var);
        }
    }
}
