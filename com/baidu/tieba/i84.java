package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.ml3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class i84 extends kf2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.kf2
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947807364, "Lcom/baidu/tieba/i84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947807364, "Lcom/baidu/tieba/i84;");
                return;
            }
        }
        k = ms1.a;
    }

    @Override // com.baidu.tieba.kf2
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kf2
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return uf2.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kf2
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return uf2.e();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i84(vq3<Exception> vq3Var) {
        super(vq3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vq3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vq3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.kf2
    public vn3 b0(xk4 xk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, xk4Var)) == null) {
            if (xk4Var == null) {
                vn3 vn3Var = new vn3();
                vn3Var.k(14L);
                vn3Var.b(2908L);
                vn3Var.d("小游戏Extension包 Extension null");
                return vn3Var;
            }
            in2 in2Var = new in2();
            in2Var.b = xk4Var.i;
            in2Var.a = xk4Var.j;
            in2Var.c = xk4Var.a;
            in2Var.d = xk4Var.m;
            boolean z = true;
            if (lm2.b(1, in2Var) != null) {
                z = false;
            }
            if (z) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            vn3 vn3Var2 = new vn3();
            vn3Var2.k(14L);
            vn3Var2.b(2908L);
            vn3Var2.d("小游戏Extension包更新失败");
            return vn3Var2;
        }
        return (vn3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.kf2
    public vn3 c0(zk4 zk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, zk4Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + zk4Var);
            }
            if (zk4Var == null) {
                vn3 vn3Var = new vn3();
                vn3Var.k(13L);
                vn3Var.b(2907L);
                vn3Var.d("小游戏GameCore包 Framework null");
                return vn3Var;
            }
            ml3.b c = ml3.c(zk4Var, 1);
            gs4.k(zk4Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = ml3.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            vn3 vn3Var2 = new vn3();
            vn3Var2.k(13L);
            vn3Var2.b(2907L);
            vn3Var2.d("小游戏GameCore包更新失败");
            return vn3Var2;
        }
        return (vn3) invokeL.objValue;
    }
}
