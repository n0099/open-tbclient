package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.apps.api.SwanApi$$ModulesProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
@Singleton
@Service
/* loaded from: classes4.dex */
public class i26 implements cv3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public i26() {
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

    @Override // com.baidu.tieba.ev3
    public void a(ja3 ja3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, ja3Var) == null) && ja3Var != null) {
            ja3Var.b(new k26(ja3Var));
            ja3Var.b(new d26(ja3Var));
            ja3Var.b(new cr3(ja3Var));
            ja3Var.b(new er3(ja3Var));
            ja3Var.b(new gr3(ja3Var));
            ja3Var.b(new ac3(ja3Var));
            ja3Var.b(new bc3(ja3Var));
            ja3Var.b(new be3(ja3Var));
            ja3Var.b(new hr3(ja3Var));
            ja3Var.b(new ew1(ja3Var));
            ja3Var.b(new h26(ja3Var));
        }
    }

    @Override // com.baidu.tieba.ev3
    @Nullable
    public Map<String, Object> b(@NonNull nx1 nx1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nx1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(nx1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ev3
    @Nullable
    public Map<String, Object> c(@NonNull nx1 nx1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nx1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(nx1Var);
        }
        return (Map) invokeL.objValue;
    }
}
