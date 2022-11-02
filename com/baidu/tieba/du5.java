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
public class du5 implements up3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public du5() {
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
        if ((interceptable == null || interceptable.invokeL(1048576, this, b53Var) == null) && b53Var != null) {
            b53Var.b(new fu5(b53Var));
            b53Var.b(new yt5(b53Var));
            b53Var.b(new ul3(b53Var));
            b53Var.b(new wl3(b53Var));
            b53Var.b(new yl3(b53Var));
            b53Var.b(new s63(b53Var));
            b53Var.b(new t63(b53Var));
            b53Var.b(new t83(b53Var));
            b53Var.b(new zl3(b53Var));
            b53Var.b(new wq1(b53Var));
            b53Var.b(new cu5(b53Var));
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
