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
/* loaded from: classes3.dex */
public class as5 implements oo3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public as5() {
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

    @Override // com.baidu.tieba.qo3
    public void a(v33 v33Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, v33Var) == null) || v33Var == null) {
            return;
        }
        v33Var.b(new cs5(v33Var));
        v33Var.b(new vr5(v33Var));
        v33Var.b(new ok3(v33Var));
        v33Var.b(new qk3(v33Var));
        v33Var.b(new sk3(v33Var));
        v33Var.b(new m53(v33Var));
        v33Var.b(new n53(v33Var));
        v33Var.b(new n73(v33Var));
        v33Var.b(new tk3(v33Var));
        v33Var.b(new qp1(v33Var));
        v33Var.b(new zr5(v33Var));
    }

    @Override // com.baidu.tieba.qo3
    @Nullable
    public Map<String, Object> b(@NonNull zq1 zq1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zq1Var)) == null) ? SwanApi$$ModulesProvider.getV8ApiModules(zq1Var) : (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.qo3
    @Nullable
    public Map<String, Object> c(@NonNull zq1 zq1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zq1Var)) == null) ? SwanApi$$ModulesProvider.getWebviewApiModules(zq1Var) : (Map) invokeL.objValue;
    }
}
