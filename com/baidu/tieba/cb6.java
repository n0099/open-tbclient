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
public class cb6 implements lx3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public cb6() {
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

    @Override // com.baidu.tieba.nx3
    public void a(sc3 sc3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, sc3Var) == null) && sc3Var != null) {
            sc3Var.b(new eb6(sc3Var));
            sc3Var.b(new xa6(sc3Var));
            sc3Var.b(new lt3(sc3Var));
            sc3Var.b(new nt3(sc3Var));
            sc3Var.b(new pt3(sc3Var));
            sc3Var.b(new je3(sc3Var));
            sc3Var.b(new ke3(sc3Var));
            sc3Var.b(new kg3(sc3Var));
            sc3Var.b(new qt3(sc3Var));
            sc3Var.b(new ny1(sc3Var));
            sc3Var.b(new bb6(sc3Var));
        }
    }

    @Override // com.baidu.tieba.nx3
    @Nullable
    public Map<String, Object> b(@NonNull wz1 wz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wz1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(wz1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.nx3
    @Nullable
    public Map<String, Object> c(@NonNull wz1 wz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wz1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(wz1Var);
        }
        return (Map) invokeL.objValue;
    }
}
