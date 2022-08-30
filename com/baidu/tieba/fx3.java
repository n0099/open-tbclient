package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.ka3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fx3 extends i42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947779464, "Lcom/baidu/tieba/fx3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947779464, "Lcom/baidu/tieba/fx3;");
                return;
            }
        }
        k = kh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fx3(tf3<Exception> tf3Var) {
        super(tf3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tf3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((tf3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.i42
    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.i42
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? PMSDownloadType.SWAN_GAME_UPDATE_CORE : (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i42
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? s42.f() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i42
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? s42.e() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i42
    public tc3 b0(t94 t94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, t94Var)) == null) {
            if (t94Var == null) {
                tc3 tc3Var = new tc3();
                tc3Var.k(14L);
                tc3Var.b(2908L);
                tc3Var.d("小游戏Extension包 Extension null");
                return tc3Var;
            }
            gc2 gc2Var = new gc2();
            gc2Var.b = t94Var.i;
            gc2Var.a = t94Var.j;
            gc2Var.c = t94Var.a;
            gc2Var.d = t94Var.m;
            if (jb2.b(1, gc2Var) == null) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            tc3 tc3Var2 = new tc3();
            tc3Var2.k(14L);
            tc3Var2.b(2908L);
            tc3Var2.d("小游戏Extension包更新失败");
            return tc3Var2;
        }
        return (tc3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.i42
    public tc3 c0(v94 v94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, v94Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + v94Var);
            }
            if (v94Var == null) {
                tc3 tc3Var = new tc3();
                tc3Var.k(13L);
                tc3Var.b(2907L);
                tc3Var.d("小游戏GameCore包 Framework null");
                return tc3Var;
            }
            ka3.b c = ka3.c(v94Var, 1);
            ch4.k(v94Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = ka3.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            tc3 tc3Var2 = new tc3();
            tc3Var2.k(13L);
            tc3Var2.b(2907L);
            tc3Var2.d("小游戏GameCore包更新失败");
            return tc3Var2;
        }
        return (tc3) invokeL.objValue;
    }
}
