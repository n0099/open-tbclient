package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.event.SwanJSVersionUpdateEvent;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.ic3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class b62 extends g62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947596843, "Lcom/baidu/tieba/b62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947596843, "Lcom/baidu/tieba/b62;");
                return;
            }
        }
        l = ij1.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b62(rh3<Exception> rh3Var) {
        this(rh3Var, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rh3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((rh3) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.ta4
    public Map<String, String> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Map<String, String> B = super.B();
            if (this.k && ef4.a) {
                if (B == null) {
                    B = new HashMap<>();
                }
                B.put("hb_type", "1");
                B.put("lastsynctime", String.valueOf(ef4.c));
                B.put("SWAN-TIMEOUT-SETTING", String.valueOf(ef4.b(60) * 1000));
            }
            return B;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g62
    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.g62
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? PMSDownloadType.SWAN_APP_UPDATE_CORE : (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g62
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? q62.d() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g62
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? q62.h() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g62
    public re3 b0(tb4 tb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, tb4Var)) == null) {
            if (tb4Var == null) {
                re3 re3Var = new re3();
                re3Var.k(14L);
                re3Var.b(2908L);
                re3Var.d("小程序Extension包 Extension null");
                return re3Var;
            }
            ee2 ee2Var = new ee2();
            ee2Var.b = tb4Var.i;
            ee2Var.a = tb4Var.j;
            ee2Var.c = tb4Var.a;
            ee2Var.d = tb4Var.m;
            if (hd2.b(0, ee2Var) == null) {
                if (l) {
                    Log.i("SwanAppUpdateCore", "小程序Extension包解压成功");
                }
                boolean m = fm2.g0().m();
                if (l) {
                    Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: extension js 热应用实验开关 " + m);
                }
                if (m) {
                    if (l) {
                        Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: 命中 extension js 热应用实验");
                    }
                    kd2 f = hd2.f(0);
                    if (f == null) {
                        return null;
                    }
                    long g = f.f().g();
                    if (g > 0) {
                        if (l) {
                            Log.d("SwanAppUpdateCore", "发送extension core更新事件");
                        }
                        SwanAppMessengerService.sendMessageWithDataToAllClient(121, g);
                    }
                }
                return null;
            }
            re3 re3Var2 = new re3();
            re3Var2.k(14L);
            re3Var2.b(2908L);
            re3Var2.d("小程序Extension包更新失败");
            return re3Var2;
        }
        return (re3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.g62
    public re3 c0(vb4 vb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, vb4Var)) == null) {
            if (l) {
                Log.d("SwanAppUpdateCore", "onFrameworkDownloadFinish framework = " + vb4Var);
            }
            if (vb4Var == null) {
                re3 re3Var = new re3();
                re3Var.k(13L);
                re3Var.b(2907L);
                re3Var.d("小程序Core包 Framework null");
                return re3Var;
            }
            ic3.b c = ic3.c(vb4Var, 0);
            yz1.k("SwanAppUpdateCore", "SwanCore RemoteCoreUpdateStatus: " + c);
            cj4.k(vb4Var.a);
            if (c.c()) {
                long e = ic3.e(0);
                if (e > 0) {
                    SwanJSVersionUpdateEvent.sendEvent(e);
                    SwanAppMessengerService.sendMessageWithDataToAllClient(114, e);
                    return null;
                }
                return null;
            }
            re3 re3Var2 = new re3();
            re3Var2.k(13L);
            re3Var2.b(2907L);
            re3Var2.d("小程序Core包更新失败");
            return re3Var2;
        }
        return (re3) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b62(rh3<Exception> rh3Var, boolean z) {
        super(rh3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rh3Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((rh3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.k = z;
    }
}
