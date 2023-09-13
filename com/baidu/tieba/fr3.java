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
public class fr3 implements yw3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fr3() {
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

    @Override // com.baidu.tieba.zw3
    public void a(ec3 ec3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ec3Var) == null) {
            ec3Var.b(new xs3(ec3Var));
            ec3Var.b(new bt3(ec3Var));
            ec3Var.b(new vt3(ec3Var));
            ec3Var.b(new ut3(ec3Var));
            ec3Var.b(new kt3(ec3Var));
            ec3Var.b(new ct3(ec3Var));
            ec3Var.b(new zs3(ec3Var));
            ec3Var.b(new it3(ec3Var));
            ec3Var.b(new ys3(ec3Var));
            ec3Var.b(new ws3(ec3Var));
            ec3Var.b(new vs3(ec3Var));
            ec3Var.b(new at3(ec3Var));
            ec3Var.b(new zt3(ec3Var));
        }
    }

    @Override // com.baidu.tieba.zw3
    @Nullable
    public Map<String, Object> b(@NonNull iz1 iz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iz1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(iz1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.zw3
    @Nullable
    public Map<String, Object> c(@NonNull iz1 iz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iz1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(iz1Var);
        }
        return (Map) invokeL.objValue;
    }
}
