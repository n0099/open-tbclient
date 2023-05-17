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
public class i56 implements wu3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public i56() {
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

    @Override // com.baidu.tieba.yu3
    public void a(da3 da3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, da3Var) == null) && da3Var != null) {
            da3Var.b(new k56(da3Var));
            da3Var.b(new d56(da3Var));
            da3Var.b(new wq3(da3Var));
            da3Var.b(new yq3(da3Var));
            da3Var.b(new ar3(da3Var));
            da3Var.b(new ub3(da3Var));
            da3Var.b(new vb3(da3Var));
            da3Var.b(new vd3(da3Var));
            da3Var.b(new br3(da3Var));
            da3Var.b(new yv1(da3Var));
            da3Var.b(new h56(da3Var));
        }
    }

    @Override // com.baidu.tieba.yu3
    @Nullable
    public Map<String, Object> b(@NonNull hx1 hx1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hx1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(hx1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.yu3
    @Nullable
    public Map<String, Object> c(@NonNull hx1 hx1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hx1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(hx1Var);
        }
        return (Map) invokeL.objValue;
    }
}
