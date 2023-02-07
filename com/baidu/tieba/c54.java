package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.gi3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c54 extends ec2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ec2
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947625735, "Lcom/baidu/tieba/c54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947625735, "Lcom/baidu/tieba/c54;");
                return;
            }
        }
        k = gp1.a;
    }

    @Override // com.baidu.tieba.ec2
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ec2
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return oc2.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ec2
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return oc2.e();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c54(pn3<Exception> pn3Var) {
        super(pn3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pn3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((pn3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.ec2
    public pk3 b0(rh4 rh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rh4Var)) == null) {
            if (rh4Var == null) {
                pk3 pk3Var = new pk3();
                pk3Var.k(14L);
                pk3Var.b(2908L);
                pk3Var.d("小游戏Extension包 Extension null");
                return pk3Var;
            }
            ck2 ck2Var = new ck2();
            ck2Var.b = rh4Var.i;
            ck2Var.a = rh4Var.j;
            ck2Var.c = rh4Var.a;
            ck2Var.d = rh4Var.m;
            boolean z = true;
            if (fj2.b(1, ck2Var) != null) {
                z = false;
            }
            if (z) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            pk3 pk3Var2 = new pk3();
            pk3Var2.k(14L);
            pk3Var2.b(2908L);
            pk3Var2.d("小游戏Extension包更新失败");
            return pk3Var2;
        }
        return (pk3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ec2
    public pk3 c0(th4 th4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, th4Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + th4Var);
            }
            if (th4Var == null) {
                pk3 pk3Var = new pk3();
                pk3Var.k(13L);
                pk3Var.b(2907L);
                pk3Var.d("小游戏GameCore包 Framework null");
                return pk3Var;
            }
            gi3.b c = gi3.c(th4Var, 1);
            ap4.k(th4Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = gi3.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            pk3 pk3Var2 = new pk3();
            pk3Var2.k(13L);
            pk3Var2.b(2907L);
            pk3Var2.d("小游戏GameCore包更新失败");
            return pk3Var2;
        }
        return (pk3) invokeL.objValue;
    }
}
