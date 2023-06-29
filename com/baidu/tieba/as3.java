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
public class as3 implements tx3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public as3() {
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

    @Override // com.baidu.tieba.ux3
    public void a(zc3 zc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zc3Var) == null) {
            zc3Var.b(new st3(zc3Var));
            zc3Var.b(new wt3(zc3Var));
            zc3Var.b(new qu3(zc3Var));
            zc3Var.b(new pu3(zc3Var));
            zc3Var.b(new fu3(zc3Var));
            zc3Var.b(new xt3(zc3Var));
            zc3Var.b(new ut3(zc3Var));
            zc3Var.b(new du3(zc3Var));
            zc3Var.b(new tt3(zc3Var));
            zc3Var.b(new rt3(zc3Var));
            zc3Var.b(new qt3(zc3Var));
            zc3Var.b(new vt3(zc3Var));
            zc3Var.b(new uu3(zc3Var));
        }
    }

    @Override // com.baidu.tieba.ux3
    @Nullable
    public Map<String, Object> b(@NonNull d02 d02Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d02Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(d02Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ux3
    @Nullable
    public Map<String, Object> c(@NonNull d02 d02Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d02Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(d02Var);
        }
        return (Map) invokeL.objValue;
    }
}
