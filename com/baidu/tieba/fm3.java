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
/* loaded from: classes6.dex */
public class fm3 implements yr3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fm3() {
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

    @Override // com.baidu.tieba.zr3
    public void a(e73 e73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, e73Var) == null) {
            e73Var.b(new xn3(e73Var));
            e73Var.b(new bo3(e73Var));
            e73Var.b(new vo3(e73Var));
            e73Var.b(new uo3(e73Var));
            e73Var.b(new ko3(e73Var));
            e73Var.b(new co3(e73Var));
            e73Var.b(new zn3(e73Var));
            e73Var.b(new io3(e73Var));
            e73Var.b(new yn3(e73Var));
            e73Var.b(new wn3(e73Var));
            e73Var.b(new vn3(e73Var));
            e73Var.b(new ao3(e73Var));
            e73Var.b(new zo3(e73Var));
        }
    }

    @Override // com.baidu.tieba.zr3
    @Nullable
    public Map<String, Object> b(@NonNull ju1 ju1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ju1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(ju1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.zr3
    @Nullable
    public Map<String, Object> c(@NonNull ju1 ju1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ju1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(ju1Var);
        }
        return (Map) invokeL.objValue;
    }
}
