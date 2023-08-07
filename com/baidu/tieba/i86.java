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
/* loaded from: classes6.dex */
public class i86 implements ow3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public i86() {
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

    @Override // com.baidu.tieba.qw3
    public void a(vb3 vb3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, vb3Var) == null) && vb3Var != null) {
            vb3Var.b(new k86(vb3Var));
            vb3Var.b(new d86(vb3Var));
            vb3Var.b(new os3(vb3Var));
            vb3Var.b(new qs3(vb3Var));
            vb3Var.b(new ss3(vb3Var));
            vb3Var.b(new md3(vb3Var));
            vb3Var.b(new nd3(vb3Var));
            vb3Var.b(new nf3(vb3Var));
            vb3Var.b(new ts3(vb3Var));
            vb3Var.b(new qx1(vb3Var));
            vb3Var.b(new h86(vb3Var));
        }
    }

    @Override // com.baidu.tieba.qw3
    @Nullable
    public Map<String, Object> b(@NonNull zy1 zy1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zy1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(zy1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.qw3
    @Nullable
    public Map<String, Object> c(@NonNull zy1 zy1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zy1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(zy1Var);
        }
        return (Map) invokeL.objValue;
    }
}
