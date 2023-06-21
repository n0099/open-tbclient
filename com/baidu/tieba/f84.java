package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.jl3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f84 extends hf2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.hf2
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947717991, "Lcom/baidu/tieba/f84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947717991, "Lcom/baidu/tieba/f84;");
                return;
            }
        }
        k = js1.a;
    }

    @Override // com.baidu.tieba.hf2
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hf2
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return rf2.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hf2
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return rf2.e();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f84(sq3<Exception> sq3Var) {
        super(sq3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sq3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((sq3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.hf2
    public sn3 b0(uk4 uk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, uk4Var)) == null) {
            if (uk4Var == null) {
                sn3 sn3Var = new sn3();
                sn3Var.k(14L);
                sn3Var.b(2908L);
                sn3Var.d("小游戏Extension包 Extension null");
                return sn3Var;
            }
            fn2 fn2Var = new fn2();
            fn2Var.b = uk4Var.i;
            fn2Var.a = uk4Var.j;
            fn2Var.c = uk4Var.a;
            fn2Var.d = uk4Var.m;
            boolean z = true;
            if (im2.b(1, fn2Var) != null) {
                z = false;
            }
            if (z) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            sn3 sn3Var2 = new sn3();
            sn3Var2.k(14L);
            sn3Var2.b(2908L);
            sn3Var2.d("小游戏Extension包更新失败");
            return sn3Var2;
        }
        return (sn3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.hf2
    public sn3 c0(wk4 wk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, wk4Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + wk4Var);
            }
            if (wk4Var == null) {
                sn3 sn3Var = new sn3();
                sn3Var.k(13L);
                sn3Var.b(2907L);
                sn3Var.d("小游戏GameCore包 Framework null");
                return sn3Var;
            }
            jl3.b c = jl3.c(wk4Var, 1);
            ds4.k(wk4Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = jl3.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            sn3 sn3Var2 = new sn3();
            sn3Var2.k(13L);
            sn3Var2.b(2907L);
            sn3Var2.d("小游戏GameCore包更新失败");
            return sn3Var2;
        }
        return (sn3) invokeL.objValue;
    }
}
