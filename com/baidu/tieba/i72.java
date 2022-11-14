package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.event.SwanJSVersionUpdateEvent;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.tieba.pd3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class i72 extends n72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean k;

    @Override // com.baidu.tieba.n72
    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947806341, "Lcom/baidu/tieba/i72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947806341, "Lcom/baidu/tieba/i72;");
                return;
            }
        }
        l = pk1.a;
    }

    @Override // com.baidu.tieba.n72
    public PMSDownloadType V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return PMSDownloadType.SWAN_APP_UPDATE_CORE;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.n72
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return x72.d();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.n72
    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return x72.h();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i72(yi3<Exception> yi3Var) {
        this(yi3Var, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yi3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((yi3) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i72(yi3<Exception> yi3Var, boolean z) {
        super(yi3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yi3Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((yi3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.k = z;
    }

    @Override // com.baidu.tieba.ac4
    public Map<String, String> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Map<String, String> B = super.B();
            if (this.k && lg4.a) {
                if (B == null) {
                    B = new HashMap<>();
                }
                B.put("hb_type", "1");
                B.put("lastsynctime", String.valueOf(lg4.c));
                B.put("SWAN-TIMEOUT-SETTING", String.valueOf(lg4.b(60) * 1000));
            }
            return B;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.tieba.n72
    public yf3 b0(ad4 ad4Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ad4Var)) == null) {
            if (ad4Var == null) {
                yf3 yf3Var = new yf3();
                yf3Var.k(14L);
                yf3Var.b(2908L);
                yf3Var.d("小程序Extension包 Extension null");
                return yf3Var;
            }
            lf2 lf2Var = new lf2();
            lf2Var.b = ad4Var.i;
            lf2Var.a = ad4Var.j;
            lf2Var.c = ad4Var.a;
            lf2Var.d = ad4Var.m;
            if (oe2.b(0, lf2Var) == null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (l) {
                    Log.i("SwanAppUpdateCore", "小程序Extension包解压成功");
                }
                boolean m = mn2.g0().m();
                if (l) {
                    Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: extension js 热应用实验开关 " + m);
                }
                if (m) {
                    if (l) {
                        Log.d("SwanAppUpdateCore", "onExtensionDownloadFinish: 命中 extension js 热应用实验");
                    }
                    re2 f = oe2.f(0);
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
            yf3 yf3Var2 = new yf3();
            yf3Var2.k(14L);
            yf3Var2.b(2908L);
            yf3Var2.d("小程序Extension包更新失败");
            return yf3Var2;
        }
        return (yf3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.n72
    public yf3 c0(cd4 cd4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cd4Var)) == null) {
            if (l) {
                Log.d("SwanAppUpdateCore", "onFrameworkDownloadFinish framework = " + cd4Var);
            }
            if (cd4Var == null) {
                yf3 yf3Var = new yf3();
                yf3Var.k(13L);
                yf3Var.b(2907L);
                yf3Var.d("小程序Core包 Framework null");
                return yf3Var;
            }
            pd3.b c = pd3.c(cd4Var, 0);
            f12.k("SwanAppUpdateCore", "SwanCore RemoteCoreUpdateStatus: " + c);
            jk4.k(cd4Var.a);
            if (c.c()) {
                long e = pd3.e(0);
                if (e > 0) {
                    SwanJSVersionUpdateEvent.sendEvent(e);
                    SwanAppMessengerService.sendMessageWithDataToAllClient(114, e);
                    return null;
                }
                return null;
            }
            yf3 yf3Var2 = new yf3();
            yf3Var2.k(13L);
            yf3Var2.b(2907L);
            yf3Var2.d("小程序Core包更新失败");
            return yf3Var2;
        }
        return (yf3) invokeL.objValue;
    }
}
