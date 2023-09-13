package com.baidu.tieba.common.jscore;

import androidx.annotation.Keep;
import com.baidu.tieba.ay4;
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
import com.baidu.tieba.lx4;
import com.baidu.tieba.mx4;
import com.baidu.tieba.nx4;
import com.baidu.tieba.ox4;
import com.baidu.tieba.px4;
import com.baidu.tieba.qx4;
import com.baidu.tieba.rx4;
import com.baidu.tieba.sx4;
import com.baidu.tieba.tx4;
import com.baidu.tieba.um6;
import com.baidu.tieba.ux4;
import com.baidu.tieba.vx4;
import com.baidu.tieba.wx4;
import com.baidu.tieba.xx4;
import com.baidu.tieba.yx4;
import com.baidu.tieba.zx4;
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
            vx4 vx4Var = new vx4();
            um6.a().f(vx4Var, new RouterJsBridgePlugin_Proxy(vx4Var));
            rx4 rx4Var = new rx4();
            um6.a().f(rx4Var, new HybridJsBridgePlugin_Proxy(rx4Var));
            nx4 nx4Var = new nx4();
            um6.a().f(nx4Var, new ClipperJsBridgePlugin_Proxy(nx4Var));
            sx4 sx4Var = new sx4();
            um6.a().f(sx4Var, new LogJsBridgePlugin_Proxy(sx4Var));
            xx4 xx4Var = new xx4();
            um6.a().f(xx4Var, new SubscriptionJsBridgePlugin_Proxy(xx4Var));
            ux4 ux4Var = new ux4();
            um6.a().f(ux4Var, new PaymentJsBridgePlugin_Proxy(ux4Var));
            mx4 mx4Var = new mx4();
            um6.a().f(mx4Var, new ActivityJsBridgePlugin_Proxy(mx4Var));
            ox4 ox4Var = new ox4();
            um6.a().f(ox4Var, new DeviceJsBridgePlugin_Proxy(ox4Var));
            wx4 wx4Var = new wx4();
            um6.a().f(wx4Var, new ShareJsBridgePlugin_Proxy(wx4Var));
            qx4 qx4Var = new qx4();
            um6.a().f(qx4Var, new HybridDebugJsBridgePlugin_Proxy(qx4Var));
            yx4 yx4Var = new yx4();
            um6.a().f(yx4Var, new SystemJsBridgePlugin_Proxy(yx4Var));
            lx4 lx4Var = new lx4();
            um6.a().f(lx4Var, new AccountJsBridgePlugin_Proxy(lx4Var));
            zx4 zx4Var = new zx4();
            um6.a().f(zx4Var, new ToastJsBridgePlugin_Proxy(zx4Var));
            px4 px4Var = new px4();
            um6.a().f(px4Var, new HostJsBridgePlugin_Proxy(px4Var));
            ay4 ay4Var = new ay4();
            um6.a().f(ay4Var, new YabmentJsBridgePlugin_Proxy(ay4Var));
            tx4 tx4Var = new tx4();
            um6.a().f(tx4Var, new NavigationBarJsBridgePlugin_Proxy(tx4Var));
        }
    }
}
