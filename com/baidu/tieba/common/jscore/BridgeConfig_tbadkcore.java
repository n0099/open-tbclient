package com.baidu.tieba.common.jscore;

import androidx.annotation.Keep;
import com.baidu.tieba.dj6;
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
import com.baidu.tieba.js4;
import com.baidu.tieba.ks4;
import com.baidu.tieba.ls4;
import com.baidu.tieba.ms4;
import com.baidu.tieba.ns4;
import com.baidu.tieba.os4;
import com.baidu.tieba.ps4;
import com.baidu.tieba.rs4;
import com.baidu.tieba.ss4;
import com.baidu.tieba.ts4;
import com.baidu.tieba.us4;
import com.baidu.tieba.vs4;
import com.baidu.tieba.ws4;
import com.baidu.tieba.xs4;
import com.baidu.tieba.ys4;
import com.baidu.tieba.zs4;
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
            ys4 ys4Var = new ys4();
            dj6.a().f(ys4Var, new ToastJsBridgePlugin_Proxy(ys4Var));
            us4 us4Var = new us4();
            dj6.a().f(us4Var, new RouterJsBridgePlugin_Proxy(us4Var));
            zs4 zs4Var = new zs4();
            dj6.a().f(zs4Var, new YabmentJsBridgePlugin_Proxy(zs4Var));
            rs4 rs4Var = new rs4();
            dj6.a().f(rs4Var, new LogJsBridgePlugin_Proxy(rs4Var));
            xs4 xs4Var = new xs4();
            dj6.a().f(xs4Var, new SystemJsBridgePlugin_Proxy(xs4Var));
            ms4 ms4Var = new ms4();
            dj6.a().f(ms4Var, new DeviceJsBridgePlugin_Proxy(ms4Var));
            js4 js4Var = new js4();
            dj6.a().f(js4Var, new AccountJsBridgePlugin_Proxy(js4Var));
            ks4 ks4Var = new ks4();
            dj6.a().f(ks4Var, new ActivityJsBridgePlugin_Proxy(ks4Var));
            vs4 vs4Var = new vs4();
            dj6.a().f(vs4Var, new ShareJsBridgePlugin_Proxy(vs4Var));
            ws4 ws4Var = new ws4();
            dj6.a().f(ws4Var, new SubscriptionJsBridgePlugin_Proxy(ws4Var));
            ls4 ls4Var = new ls4();
            dj6.a().f(ls4Var, new ClipperJsBridgePlugin_Proxy(ls4Var));
            ns4 ns4Var = new ns4();
            dj6.a().f(ns4Var, new HostJsBridgePlugin_Proxy(ns4Var));
            os4 os4Var = new os4();
            dj6.a().f(os4Var, new HybridDebugJsBridgePlugin_Proxy(os4Var));
            ss4 ss4Var = new ss4();
            dj6.a().f(ss4Var, new NavigationBarJsBridgePlugin_Proxy(ss4Var));
            ts4 ts4Var = new ts4();
            dj6.a().f(ts4Var, new PaymentJsBridgePlugin_Proxy(ts4Var));
            ps4 ps4Var = new ps4();
            dj6.a().f(ps4Var, new HybridJsBridgePlugin_Proxy(ps4Var));
        }
    }
}
