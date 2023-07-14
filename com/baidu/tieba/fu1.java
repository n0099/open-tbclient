package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.tieba.dp2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class fu1 implements kw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.kw1
    public boolean a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, activity)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.kw1
    public void b(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
        }
    }

    @Override // com.baidu.tieba.kw1
    public void c(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.kw1
    public void e(vb3 vb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, vb3Var) == null) {
        }
    }

    @Override // com.baidu.tieba.kw1
    public void g(vb3 vb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vb3Var) == null) {
        }
    }

    public fu1() {
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

    @Override // com.baidu.tieba.kw1
    public void d(@NonNull CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, callbackHandler) == null) {
            callbackHandler.handleSchemeDispatchCallback("", "");
        }
    }

    @Override // com.baidu.tieba.kw1
    public String f(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            return context.getString(R.string.obfuscated_res_0x7f0f0189);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.kw1
    public void h(@NonNull Activity activity, String str, String str2, cp2 cp2Var, dp2.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(1048583, this, activity, str, str2, cp2Var, bVar) == null) && bVar != null) {
            bVar.a();
        }
    }
}
