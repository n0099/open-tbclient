package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.eh3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a44 extends cb2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.cb2
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947565192, "Lcom/baidu/tieba/a44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947565192, "Lcom/baidu/tieba/a44;");
                return;
            }
        }
        k = eo1.a;
    }

    @Override // com.baidu.tieba.cb2
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cb2
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return mb2.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cb2
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return mb2.e();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a44(nm3<Exception> nm3Var) {
        super(nm3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nm3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((nm3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.cb2
    public nj3 b0(pg4 pg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, pg4Var)) == null) {
            if (pg4Var == null) {
                nj3 nj3Var = new nj3();
                nj3Var.k(14L);
                nj3Var.b(2908L);
                nj3Var.d("小游戏Extension包 Extension null");
                return nj3Var;
            }
            aj2 aj2Var = new aj2();
            aj2Var.b = pg4Var.i;
            aj2Var.a = pg4Var.j;
            aj2Var.c = pg4Var.a;
            aj2Var.d = pg4Var.m;
            boolean z = true;
            if (di2.b(1, aj2Var) != null) {
                z = false;
            }
            if (z) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            nj3 nj3Var2 = new nj3();
            nj3Var2.k(14L);
            nj3Var2.b(2908L);
            nj3Var2.d("小游戏Extension包更新失败");
            return nj3Var2;
        }
        return (nj3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.cb2
    public nj3 c0(rg4 rg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, rg4Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + rg4Var);
            }
            if (rg4Var == null) {
                nj3 nj3Var = new nj3();
                nj3Var.k(13L);
                nj3Var.b(2907L);
                nj3Var.d("小游戏GameCore包 Framework null");
                return nj3Var;
            }
            eh3.b c = eh3.c(rg4Var, 1);
            yn4.k(rg4Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = eh3.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            nj3 nj3Var2 = new nj3();
            nj3Var2.k(13L);
            nj3Var2.b(2907L);
            nj3Var2.d("小游戏GameCore包更新失败");
            return nj3Var2;
        }
        return (nj3) invokeL.objValue;
    }
}
