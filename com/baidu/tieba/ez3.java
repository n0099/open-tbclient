package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.ic3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ez3 extends g62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947751595, "Lcom/baidu/tieba/ez3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947751595, "Lcom/baidu/tieba/ez3;");
                return;
            }
        }
        k = ij1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ez3(rh3<Exception> rh3Var) {
        super(rh3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rh3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((rh3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.g62
    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.g62
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? PMSDownloadType.SWAN_GAME_UPDATE_CORE : (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g62
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? q62.f() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g62
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? q62.e() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g62
    public re3 b0(tb4 tb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tb4Var)) == null) {
            if (tb4Var == null) {
                re3 re3Var = new re3();
                re3Var.k(14L);
                re3Var.b(2908L);
                re3Var.d("小游戏Extension包 Extension null");
                return re3Var;
            }
            ee2 ee2Var = new ee2();
            ee2Var.b = tb4Var.i;
            ee2Var.a = tb4Var.j;
            ee2Var.c = tb4Var.a;
            ee2Var.d = tb4Var.m;
            if (hd2.b(1, ee2Var) == null) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            re3 re3Var2 = new re3();
            re3Var2.k(14L);
            re3Var2.b(2908L);
            re3Var2.d("小游戏Extension包更新失败");
            return re3Var2;
        }
        return (re3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.g62
    public re3 c0(vb4 vb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, vb4Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + vb4Var);
            }
            if (vb4Var == null) {
                re3 re3Var = new re3();
                re3Var.k(13L);
                re3Var.b(2907L);
                re3Var.d("小游戏GameCore包 Framework null");
                return re3Var;
            }
            ic3.b c = ic3.c(vb4Var, 1);
            cj4.k(vb4Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = ic3.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            re3 re3Var2 = new re3();
            re3Var2.k(13L);
            re3Var2.b(2907L);
            re3Var2.d("小游戏GameCore包更新失败");
            return re3Var2;
        }
        return (re3) invokeL.objValue;
    }
}
