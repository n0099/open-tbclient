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
/* loaded from: classes3.dex */
public class dk3 implements wp3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public dk3() {
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

    @Override // com.baidu.tieba.xp3
    public void a(c53 c53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, c53Var) == null) {
            c53Var.b(new vl3(c53Var));
            c53Var.b(new zl3(c53Var));
            c53Var.b(new tm3(c53Var));
            c53Var.b(new sm3(c53Var));
            c53Var.b(new im3(c53Var));
            c53Var.b(new am3(c53Var));
            c53Var.b(new xl3(c53Var));
            c53Var.b(new gm3(c53Var));
            c53Var.b(new wl3(c53Var));
            c53Var.b(new ul3(c53Var));
            c53Var.b(new tl3(c53Var));
            c53Var.b(new yl3(c53Var));
            c53Var.b(new xm3(c53Var));
        }
    }

    @Override // com.baidu.tieba.xp3
    @Nullable
    public Map<String, Object> b(@NonNull gs1 gs1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gs1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(gs1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xp3
    @Nullable
    public Map<String, Object> c(@NonNull gs1 gs1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gs1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(gs1Var);
        }
        return (Map) invokeL.objValue;
    }
}
