package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.fh3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b44 extends db2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.db2
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947594983, "Lcom/baidu/tieba/b44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947594983, "Lcom/baidu/tieba/b44;");
                return;
            }
        }
        k = fo1.a;
    }

    @Override // com.baidu.tieba.db2
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.db2
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return nb2.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.db2
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return nb2.e();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b44(om3<Exception> om3Var) {
        super(om3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {om3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((om3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.db2
    public oj3 b0(qg4 qg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, qg4Var)) == null) {
            if (qg4Var == null) {
                oj3 oj3Var = new oj3();
                oj3Var.k(14L);
                oj3Var.b(2908L);
                oj3Var.d("小游戏Extension包 Extension null");
                return oj3Var;
            }
            bj2 bj2Var = new bj2();
            bj2Var.b = qg4Var.i;
            bj2Var.a = qg4Var.j;
            bj2Var.c = qg4Var.a;
            bj2Var.d = qg4Var.m;
            boolean z = true;
            if (ei2.b(1, bj2Var) != null) {
                z = false;
            }
            if (z) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            oj3 oj3Var2 = new oj3();
            oj3Var2.k(14L);
            oj3Var2.b(2908L);
            oj3Var2.d("小游戏Extension包更新失败");
            return oj3Var2;
        }
        return (oj3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.db2
    public oj3 c0(sg4 sg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, sg4Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + sg4Var);
            }
            if (sg4Var == null) {
                oj3 oj3Var = new oj3();
                oj3Var.k(13L);
                oj3Var.b(2907L);
                oj3Var.d("小游戏GameCore包 Framework null");
                return oj3Var;
            }
            fh3.b c = fh3.c(sg4Var, 1);
            zn4.k(sg4Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = fh3.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            oj3 oj3Var2 = new oj3();
            oj3Var2.k(13L);
            oj3Var2.b(2907L);
            oj3Var2.d("小游戏GameCore包更新失败");
            return oj3Var2;
        }
        return (oj3) invokeL.objValue;
    }
}
