package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.swan.bdprivate.api.SwanApi$$ModulesProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
@Service
/* loaded from: classes5.dex */
public class em3 implements xr3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public em3() {
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

    @Override // com.baidu.tieba.yr3
    public void a(d73 d73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, d73Var) == null) {
            d73Var.b(new wn3(d73Var));
            d73Var.b(new ao3(d73Var));
            d73Var.b(new uo3(d73Var));
            d73Var.b(new to3(d73Var));
            d73Var.b(new jo3(d73Var));
            d73Var.b(new bo3(d73Var));
            d73Var.b(new yn3(d73Var));
            d73Var.b(new ho3(d73Var));
            d73Var.b(new xn3(d73Var));
            d73Var.b(new vn3(d73Var));
            d73Var.b(new un3(d73Var));
            d73Var.b(new zn3(d73Var));
            d73Var.b(new yo3(d73Var));
        }
    }

    @Override // com.baidu.tieba.yr3
    @Nullable
    public Map<String, Object> b(@NonNull iu1 iu1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iu1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(iu1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.yr3
    @Nullable
    public Map<String, Object> c(@NonNull iu1 iu1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iu1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(iu1Var);
        }
        return (Map) invokeL.objValue;
    }
}
