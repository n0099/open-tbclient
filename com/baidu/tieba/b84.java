package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.fl3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b84 extends df2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.df2
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947598827, "Lcom/baidu/tieba/b84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947598827, "Lcom/baidu/tieba/b84;");
                return;
            }
        }
        k = fs1.a;
    }

    @Override // com.baidu.tieba.df2
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.df2
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return nf2.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.df2
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return nf2.e();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b84(oq3<Exception> oq3Var) {
        super(oq3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oq3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((oq3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.df2
    public on3 b0(qk4 qk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, qk4Var)) == null) {
            if (qk4Var == null) {
                on3 on3Var = new on3();
                on3Var.k(14L);
                on3Var.b(2908L);
                on3Var.d("小游戏Extension包 Extension null");
                return on3Var;
            }
            bn2 bn2Var = new bn2();
            bn2Var.b = qk4Var.i;
            bn2Var.a = qk4Var.j;
            bn2Var.c = qk4Var.a;
            bn2Var.d = qk4Var.m;
            boolean z = true;
            if (em2.b(1, bn2Var) != null) {
                z = false;
            }
            if (z) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            on3 on3Var2 = new on3();
            on3Var2.k(14L);
            on3Var2.b(2908L);
            on3Var2.d("小游戏Extension包更新失败");
            return on3Var2;
        }
        return (on3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.df2
    public on3 c0(sk4 sk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, sk4Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + sk4Var);
            }
            if (sk4Var == null) {
                on3 on3Var = new on3();
                on3Var.k(13L);
                on3Var.b(2907L);
                on3Var.d("小游戏GameCore包 Framework null");
                return on3Var;
            }
            fl3.b c = fl3.c(sk4Var, 1);
            zr4.k(sk4Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = fl3.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            on3 on3Var2 = new on3();
            on3Var2.k(13L);
            on3Var2.b(2907L);
            on3Var2.d("小游戏GameCore包更新失败");
            return on3Var2;
        }
        return (on3) invokeL.objValue;
    }
}
