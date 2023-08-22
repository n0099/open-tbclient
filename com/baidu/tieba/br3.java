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
public class br3 implements uw3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public br3() {
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

    @Override // com.baidu.tieba.vw3
    public void a(ac3 ac3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ac3Var) == null) {
            ac3Var.b(new ts3(ac3Var));
            ac3Var.b(new xs3(ac3Var));
            ac3Var.b(new rt3(ac3Var));
            ac3Var.b(new qt3(ac3Var));
            ac3Var.b(new gt3(ac3Var));
            ac3Var.b(new ys3(ac3Var));
            ac3Var.b(new vs3(ac3Var));
            ac3Var.b(new et3(ac3Var));
            ac3Var.b(new us3(ac3Var));
            ac3Var.b(new ss3(ac3Var));
            ac3Var.b(new rs3(ac3Var));
            ac3Var.b(new ws3(ac3Var));
            ac3Var.b(new vt3(ac3Var));
        }
    }

    @Override // com.baidu.tieba.vw3
    @Nullable
    public Map<String, Object> b(@NonNull ez1 ez1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ez1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(ez1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.vw3
    @Nullable
    public Map<String, Object> c(@NonNull ez1 ez1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ez1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(ez1Var);
        }
        return (Map) invokeL.objValue;
    }
}
