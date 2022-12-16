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
public class ck3 implements vp3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ck3() {
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

    @Override // com.baidu.tieba.wp3
    public void a(b53 b53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, b53Var) == null) {
            b53Var.b(new ul3(b53Var));
            b53Var.b(new yl3(b53Var));
            b53Var.b(new sm3(b53Var));
            b53Var.b(new rm3(b53Var));
            b53Var.b(new hm3(b53Var));
            b53Var.b(new zl3(b53Var));
            b53Var.b(new wl3(b53Var));
            b53Var.b(new fm3(b53Var));
            b53Var.b(new vl3(b53Var));
            b53Var.b(new tl3(b53Var));
            b53Var.b(new sl3(b53Var));
            b53Var.b(new xl3(b53Var));
            b53Var.b(new wm3(b53Var));
        }
    }

    @Override // com.baidu.tieba.wp3
    @Nullable
    public Map<String, Object> b(@NonNull fs1 fs1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fs1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(fs1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.wp3
    @Nullable
    public Map<String, Object> c(@NonNull fs1 fs1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fs1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(fs1Var);
        }
        return (Map) invokeL.objValue;
    }
}
