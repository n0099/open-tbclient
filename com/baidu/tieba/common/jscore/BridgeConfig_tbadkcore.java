package com.baidu.tieba.common.jscore;

import androidx.annotation.Keep;
import com.baidu.tieba.fx4;
import com.baidu.tieba.gx4;
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
import com.baidu.tieba.rk6;
import com.baidu.tieba.rx4;
import com.baidu.tieba.sx4;
import com.baidu.tieba.tx4;
import com.baidu.tieba.ux4;
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
            tx4 tx4Var = new tx4();
            rk6.a().f(tx4Var, new ToastJsBridgePlugin_Proxy(tx4Var));
            px4 px4Var = new px4();
            rk6.a().f(px4Var, new RouterJsBridgePlugin_Proxy(px4Var));
            ux4 ux4Var = new ux4();
            rk6.a().f(ux4Var, new YabmentJsBridgePlugin_Proxy(ux4Var));
            mx4 mx4Var = new mx4();
            rk6.a().f(mx4Var, new LogJsBridgePlugin_Proxy(mx4Var));
            sx4 sx4Var = new sx4();
            rk6.a().f(sx4Var, new SystemJsBridgePlugin_Proxy(sx4Var));
            ix4 ix4Var = new ix4();
            rk6.a().f(ix4Var, new DeviceJsBridgePlugin_Proxy(ix4Var));
            fx4 fx4Var = new fx4();
            rk6.a().f(fx4Var, new AccountJsBridgePlugin_Proxy(fx4Var));
            gx4 gx4Var = new gx4();
            rk6.a().f(gx4Var, new ActivityJsBridgePlugin_Proxy(gx4Var));
            qx4 qx4Var = new qx4();
            rk6.a().f(qx4Var, new ShareJsBridgePlugin_Proxy(qx4Var));
            rx4 rx4Var = new rx4();
            rk6.a().f(rx4Var, new SubscriptionJsBridgePlugin_Proxy(rx4Var));
            hx4 hx4Var = new hx4();
            rk6.a().f(hx4Var, new ClipperJsBridgePlugin_Proxy(hx4Var));
            jx4 jx4Var = new jx4();
            rk6.a().f(jx4Var, new HostJsBridgePlugin_Proxy(jx4Var));
            kx4 kx4Var = new kx4();
            rk6.a().f(kx4Var, new HybridDebugJsBridgePlugin_Proxy(kx4Var));
            nx4 nx4Var = new nx4();
            rk6.a().f(nx4Var, new NavigationBarJsBridgePlugin_Proxy(nx4Var));
            ox4 ox4Var = new ox4();
            rk6.a().f(ox4Var, new PaymentJsBridgePlugin_Proxy(ox4Var));
            lx4 lx4Var = new lx4();
            rk6.a().f(lx4Var, new HybridJsBridgePlugin_Proxy(lx4Var));
        }
    }
}
