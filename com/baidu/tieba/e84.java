package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.il3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e84 extends gf2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.gf2
    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947688200, "Lcom/baidu/tieba/e84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947688200, "Lcom/baidu/tieba/e84;");
                return;
            }
        }
        k = is1.a;
    }

    @Override // com.baidu.tieba.gf2
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gf2
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return qf2.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gf2
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return qf2.e();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e84(rq3<Exception> rq3Var) {
        super(rq3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rq3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((rq3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.gf2
    public rn3 b0(tk4 tk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tk4Var)) == null) {
            if (tk4Var == null) {
                rn3 rn3Var = new rn3();
                rn3Var.k(14L);
                rn3Var.b(2908L);
                rn3Var.d("小游戏Extension包 Extension null");
                return rn3Var;
            }
            en2 en2Var = new en2();
            en2Var.b = tk4Var.i;
            en2Var.a = tk4Var.j;
            en2Var.c = tk4Var.a;
            en2Var.d = tk4Var.m;
            boolean z = true;
            if (hm2.b(1, en2Var) != null) {
                z = false;
            }
            if (z) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            rn3 rn3Var2 = new rn3();
            rn3Var2.k(14L);
            rn3Var2.b(2908L);
            rn3Var2.d("小游戏Extension包更新失败");
            return rn3Var2;
        }
        return (rn3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.gf2
    public rn3 c0(vk4 vk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, vk4Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + vk4Var);
            }
            if (vk4Var == null) {
                rn3 rn3Var = new rn3();
                rn3Var.k(13L);
                rn3Var.b(2907L);
                rn3Var.d("小游戏GameCore包 Framework null");
                return rn3Var;
            }
            il3.b c = il3.c(vk4Var, 1);
            cs4.k(vk4Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = il3.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            rn3 rn3Var2 = new rn3();
            rn3Var2.k(13L);
            rn3Var2.b(2907L);
            rn3Var2.d("小游戏GameCore包更新失败");
            return rn3Var2;
        }
        return (rn3) invokeL.objValue;
    }
}
