package com.baidu.tieba.common.jscore;

import androidx.annotation.Keep;
import com.baidu.tieba.gu4;
import com.baidu.tieba.h5power.AccountJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.ActivityJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.ClipperJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.DeviceJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.HostJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.HybridDebugJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.HybridJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.LogJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.NavigationBarJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.PaymentJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.RouterJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.ShareJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.SubscriptionJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.SystemJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.ToastJsBridgePlugin_Proxy;
import com.baidu.tieba.hu4;
import com.baidu.tieba.iu4;
import com.baidu.tieba.ju4;
import com.baidu.tieba.ku4;
import com.baidu.tieba.lu4;
import com.baidu.tieba.mu4;
import com.baidu.tieba.nu4;
import com.baidu.tieba.ou4;
import com.baidu.tieba.pu4;
import com.baidu.tieba.qu4;
import com.baidu.tieba.ru4;
import com.baidu.tieba.su4;
import com.baidu.tieba.tu4;
import com.baidu.tieba.uu4;
import com.baidu.tieba.yf6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes3.dex */
public class BridgeConfig_tbadkcore {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BridgeConfig_tbadkcore() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void register() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            hu4 hu4Var = new hu4();
            yf6.a().f(hu4Var, new ActivityJsBridgePlugin_Proxy(hu4Var));
            su4 su4Var = new su4();
            yf6.a().f(su4Var, new SubscriptionJsBridgePlugin_Proxy(su4Var));
            pu4 pu4Var = new pu4();
            yf6.a().f(pu4Var, new PaymentJsBridgePlugin_Proxy(pu4Var));
            ru4 ru4Var = new ru4();
            yf6.a().f(ru4Var, new ShareJsBridgePlugin_Proxy(ru4Var));
            qu4 qu4Var = new qu4();
            yf6.a().f(qu4Var, new RouterJsBridgePlugin_Proxy(qu4Var));
            tu4 tu4Var = new tu4();
            yf6.a().f(tu4Var, new SystemJsBridgePlugin_Proxy(tu4Var));
            ku4 ku4Var = new ku4();
            yf6.a().f(ku4Var, new HostJsBridgePlugin_Proxy(ku4Var));
            mu4 mu4Var = new mu4();
            yf6.a().f(mu4Var, new HybridJsBridgePlugin_Proxy(mu4Var));
            ju4 ju4Var = new ju4();
            yf6.a().f(ju4Var, new DeviceJsBridgePlugin_Proxy(ju4Var));
            gu4 gu4Var = new gu4();
            yf6.a().f(gu4Var, new AccountJsBridgePlugin_Proxy(gu4Var));
            iu4 iu4Var = new iu4();
            yf6.a().f(iu4Var, new ClipperJsBridgePlugin_Proxy(iu4Var));
            ou4 ou4Var = new ou4();
            yf6.a().f(ou4Var, new NavigationBarJsBridgePlugin_Proxy(ou4Var));
            lu4 lu4Var = new lu4();
            yf6.a().f(lu4Var, new HybridDebugJsBridgePlugin_Proxy(lu4Var));
            nu4 nu4Var = new nu4();
            yf6.a().f(nu4Var, new LogJsBridgePlugin_Proxy(nu4Var));
            uu4 uu4Var = new uu4();
            yf6.a().f(uu4Var, new ToastJsBridgePlugin_Proxy(uu4Var));
        }
    }
}
