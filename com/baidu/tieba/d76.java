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
/* loaded from: classes5.dex */
public class d76 implements as3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d76() {
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

    @Override // com.baidu.tieba.cs3
    public void a(h73 h73Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, h73Var) == null) && h73Var != null) {
            h73Var.b(new f76(h73Var));
            h73Var.b(new y66(h73Var));
            h73Var.b(new ao3(h73Var));
            h73Var.b(new co3(h73Var));
            h73Var.b(new eo3(h73Var));
            h73Var.b(new y83(h73Var));
            h73Var.b(new z83(h73Var));
            h73Var.b(new za3(h73Var));
            h73Var.b(new fo3(h73Var));
            h73Var.b(new dt1(h73Var));
            h73Var.b(new c76(h73Var));
        }
    }

    @Override // com.baidu.tieba.cs3
    @Nullable
    public Map<String, Object> b(@NonNull mu1 mu1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mu1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(mu1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.cs3
    @Nullable
    public Map<String, Object> c(@NonNull mu1 mu1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mu1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(mu1Var);
        }
        return (Map) invokeL.objValue;
    }
}
