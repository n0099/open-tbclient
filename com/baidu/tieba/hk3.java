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
/* loaded from: classes4.dex */
public class hk3 implements aq3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public hk3() {
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

    @Override // com.baidu.tieba.bq3
    public void a(g53 g53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, g53Var) == null) {
            g53Var.b(new zl3(g53Var));
            g53Var.b(new dm3(g53Var));
            g53Var.b(new xm3(g53Var));
            g53Var.b(new wm3(g53Var));
            g53Var.b(new mm3(g53Var));
            g53Var.b(new em3(g53Var));
            g53Var.b(new bm3(g53Var));
            g53Var.b(new km3(g53Var));
            g53Var.b(new am3(g53Var));
            g53Var.b(new yl3(g53Var));
            g53Var.b(new xl3(g53Var));
            g53Var.b(new cm3(g53Var));
            g53Var.b(new bn3(g53Var));
        }
    }

    @Override // com.baidu.tieba.bq3
    @Nullable
    public Map<String, Object> b(@NonNull ks1 ks1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ks1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(ks1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bq3
    @Nullable
    public Map<String, Object> c(@NonNull ks1 ks1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ks1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(ks1Var);
        }
        return (Map) invokeL.objValue;
    }
}
