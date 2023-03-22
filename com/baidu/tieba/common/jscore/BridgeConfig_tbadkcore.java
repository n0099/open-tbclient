package com.baidu.tieba.common.jscore;

import androidx.annotation.Keep;
import com.baidu.tieba.au4;
import com.baidu.tieba.bu4;
import com.baidu.tieba.cu4;
import com.baidu.tieba.du4;
import com.baidu.tieba.eu4;
import com.baidu.tieba.fu4;
import com.baidu.tieba.h5power.AccountJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.ActivityJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.ClipperJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.DeviceJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.HostJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.HybridJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.LogJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.NavigationBarJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.OfflineJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.PaymentJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.RouterJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.ShareJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.SubscriptionJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.SystemJsBridgePlugin_Proxy;
import com.baidu.tieba.h5power.ToastJsBridgePlugin_Proxy;
import com.baidu.tieba.kd6;
import com.baidu.tieba.rt4;
import com.baidu.tieba.st4;
import com.baidu.tieba.tt4;
import com.baidu.tieba.ut4;
import com.baidu.tieba.vt4;
import com.baidu.tieba.wt4;
import com.baidu.tieba.xt4;
import com.baidu.tieba.yt4;
import com.baidu.tieba.zt4;
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
            st4 st4Var = new st4();
            kd6.a().d(st4Var, new ActivityJsBridgePlugin_Proxy(st4Var));
            du4 du4Var = new du4();
            kd6.a().d(du4Var, new SubscriptionJsBridgePlugin_Proxy(du4Var));
            au4 au4Var = new au4();
            kd6.a().d(au4Var, new PaymentJsBridgePlugin_Proxy(au4Var));
            cu4 cu4Var = new cu4();
            kd6.a().d(cu4Var, new ShareJsBridgePlugin_Proxy(cu4Var));
            bu4 bu4Var = new bu4();
            kd6.a().d(bu4Var, new RouterJsBridgePlugin_Proxy(bu4Var));
            eu4 eu4Var = new eu4();
            kd6.a().d(eu4Var, new SystemJsBridgePlugin_Proxy(eu4Var));
            vt4 vt4Var = new vt4();
            kd6.a().d(vt4Var, new HostJsBridgePlugin_Proxy(vt4Var));
            wt4 wt4Var = new wt4();
            kd6.a().d(wt4Var, new HybridJsBridgePlugin_Proxy(wt4Var));
            ut4 ut4Var = new ut4();
            kd6.a().d(ut4Var, new DeviceJsBridgePlugin_Proxy(ut4Var));
            rt4 rt4Var = new rt4();
            kd6.a().d(rt4Var, new AccountJsBridgePlugin_Proxy(rt4Var));
            tt4 tt4Var = new tt4();
            kd6.a().d(tt4Var, new ClipperJsBridgePlugin_Proxy(tt4Var));
            yt4 yt4Var = new yt4();
            kd6.a().d(yt4Var, new NavigationBarJsBridgePlugin_Proxy(yt4Var));
            xt4 xt4Var = new xt4();
            kd6.a().d(xt4Var, new LogJsBridgePlugin_Proxy(xt4Var));
            zt4 zt4Var = new zt4();
            kd6.a().d(zt4Var, new OfflineJsBridgePlugin_Proxy(zt4Var));
            fu4 fu4Var = new fu4();
            kd6.a().d(fu4Var, new ToastJsBridgePlugin_Proxy(fu4Var));
        }
    }
}
