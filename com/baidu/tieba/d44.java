package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.hh3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d44 extends fb2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.fb2
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947654565, "Lcom/baidu/tieba/d44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947654565, "Lcom/baidu/tieba/d44;");
                return;
            }
        }
        k = ho1.a;
    }

    @Override // com.baidu.tieba.fb2
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return PMSDownloadType.SWAN_GAME_UPDATE_CORE;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fb2
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return pb2.f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fb2
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return pb2.e();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d44(qm3<Exception> qm3Var) {
        super(qm3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qm3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((qm3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.fb2
    public qj3 b0(sg4 sg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sg4Var)) == null) {
            if (sg4Var == null) {
                qj3 qj3Var = new qj3();
                qj3Var.k(14L);
                qj3Var.b(2908L);
                qj3Var.d("小游戏Extension包 Extension null");
                return qj3Var;
            }
            dj2 dj2Var = new dj2();
            dj2Var.b = sg4Var.i;
            dj2Var.a = sg4Var.j;
            dj2Var.c = sg4Var.a;
            dj2Var.d = sg4Var.m;
            boolean z = true;
            if (gi2.b(1, dj2Var) != null) {
                z = false;
            }
            if (z) {
                if (k) {
                    Log.i("SwanGameUpdateCore", "小游戏Extension包解压成功");
                    return null;
                }
                return null;
            }
            qj3 qj3Var2 = new qj3();
            qj3Var2.k(14L);
            qj3Var2.b(2908L);
            qj3Var2.d("小游戏Extension包更新失败");
            return qj3Var2;
        }
        return (qj3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.fb2
    public qj3 c0(ug4 ug4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ug4Var)) == null) {
            if (k) {
                Log.d("SwanGameUpdateCore", "onFrameworkDownloadFinish framework = " + ug4Var);
            }
            if (ug4Var == null) {
                qj3 qj3Var = new qj3();
                qj3Var.k(13L);
                qj3Var.b(2907L);
                qj3Var.d("小游戏GameCore包 Framework null");
                return qj3Var;
            }
            hh3.b c = hh3.c(ug4Var, 1);
            bo4.k(ug4Var.a);
            if (c.c()) {
                if (k) {
                    Log.d("SwanGameUpdateCore", "小游戏GameCore解压成功");
                }
                long e = hh3.e(1);
                if (e > 0) {
                    SwanAppMessengerService.sendMessageWithDataToAllClient(117, e);
                    return null;
                }
                return null;
            }
            qj3 qj3Var2 = new qj3();
            qj3Var2.k(13L);
            qj3Var2.b(2907L);
            qj3Var2.d("小游戏GameCore包更新失败");
            return qj3Var2;
        }
        return (qj3) invokeL.objValue;
    }
}
