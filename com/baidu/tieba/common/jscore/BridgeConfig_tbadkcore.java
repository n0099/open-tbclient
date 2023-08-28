package com.baidu.tieba.common.jscore;

import androidx.annotation.Keep;
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
import com.baidu.tieba.h5power.YabmentJsBridgePlugin_Proxy;
import com.baidu.tieba.hx4;
import com.baidu.tieba.ix4;
import com.baidu.tieba.jx4;
import com.baidu.tieba.kx4;
import com.baidu.tieba.lx4;
import com.baidu.tieba.mx4;
import com.baidu.tieba.nx4;
import com.baidu.tieba.ox4;
import com.baidu.tieba.px4;
import com.baidu.tieba.qx4;
import com.baidu.tieba.rx4;
import com.baidu.tieba.sx4;
import com.baidu.tieba.tx4;
import com.baidu.tieba.ux4;
import com.baidu.tieba.vx4;
import com.baidu.tieba.wl6;
import com.baidu.tieba.wx4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes5.dex */
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
            ix4 ix4Var = new ix4();
            wl6.a().f(ix4Var, new ActivityJsBridgePlugin_Proxy(ix4Var));
            tx4 tx4Var = new tx4();
            wl6.a().f(tx4Var, new SubscriptionJsBridgePlugin_Proxy(tx4Var));
            qx4 qx4Var = new qx4();
            wl6.a().f(qx4Var, new PaymentJsBridgePlugin_Proxy(qx4Var));
            sx4 sx4Var = new sx4();
            wl6.a().f(sx4Var, new ShareJsBridgePlugin_Proxy(sx4Var));
            rx4 rx4Var = new rx4();
            wl6.a().f(rx4Var, new RouterJsBridgePlugin_Proxy(rx4Var));
            ux4 ux4Var = new ux4();
            wl6.a().f(ux4Var, new SystemJsBridgePlugin_Proxy(ux4Var));
            wx4 wx4Var = new wx4();
            wl6.a().f(wx4Var, new YabmentJsBridgePlugin_Proxy(wx4Var));
            lx4 lx4Var = new lx4();
            wl6.a().f(lx4Var, new HostJsBridgePlugin_Proxy(lx4Var));
            nx4 nx4Var = new nx4();
            wl6.a().f(nx4Var, new HybridJsBridgePlugin_Proxy(nx4Var));
            kx4 kx4Var = new kx4();
            wl6.a().f(kx4Var, new DeviceJsBridgePlugin_Proxy(kx4Var));
            hx4 hx4Var = new hx4();
            wl6.a().f(hx4Var, new AccountJsBridgePlugin_Proxy(hx4Var));
            jx4 jx4Var = new jx4();
            wl6.a().f(jx4Var, new ClipperJsBridgePlugin_Proxy(jx4Var));
            px4 px4Var = new px4();
            wl6.a().f(px4Var, new NavigationBarJsBridgePlugin_Proxy(px4Var));
            mx4 mx4Var = new mx4();
            wl6.a().f(mx4Var, new HybridDebugJsBridgePlugin_Proxy(mx4Var));
            ox4 ox4Var = new ox4();
            wl6.a().f(ox4Var, new LogJsBridgePlugin_Proxy(ox4Var));
            vx4 vx4Var = new vx4();
            wl6.a().f(vx4Var, new ToastJsBridgePlugin_Proxy(vx4Var));
        }
    }
}
