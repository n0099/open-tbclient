package com.baidu.tieba.common.jscore;

import androidx.annotation.Keep;
import com.baidu.tieba.at4;
import com.baidu.tieba.bt4;
import com.baidu.tieba.ct4;
import com.baidu.tieba.dt4;
import com.baidu.tieba.et4;
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
import com.baidu.tieba.ns4;
import com.baidu.tieba.os4;
import com.baidu.tieba.ps4;
import com.baidu.tieba.qs4;
import com.baidu.tieba.rj6;
import com.baidu.tieba.rs4;
import com.baidu.tieba.ss4;
import com.baidu.tieba.ts4;
import com.baidu.tieba.vs4;
import com.baidu.tieba.ws4;
import com.baidu.tieba.xs4;
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
            at4 at4Var = new at4();
            rj6.a().f(at4Var, new ShareJsBridgePlugin_Proxy(at4Var));
            vs4 vs4Var = new vs4();
            rj6.a().f(vs4Var, new LogJsBridgePlugin_Proxy(vs4Var));
            ts4 ts4Var = new ts4();
            rj6.a().f(ts4Var, new HybridJsBridgePlugin_Proxy(ts4Var));
            rs4 rs4Var = new rs4();
            rj6.a().f(rs4Var, new HostJsBridgePlugin_Proxy(rs4Var));
            ws4 ws4Var = new ws4();
            rj6.a().f(ws4Var, new NavigationBarJsBridgePlugin_Proxy(ws4Var));
            qs4 qs4Var = new qs4();
            rj6.a().f(qs4Var, new DeviceJsBridgePlugin_Proxy(qs4Var));
            dt4 dt4Var = new dt4();
            rj6.a().f(dt4Var, new ToastJsBridgePlugin_Proxy(dt4Var));
            ss4 ss4Var = new ss4();
            rj6.a().f(ss4Var, new HybridDebugJsBridgePlugin_Proxy(ss4Var));
            bt4 bt4Var = new bt4();
            rj6.a().f(bt4Var, new SubscriptionJsBridgePlugin_Proxy(bt4Var));
            et4 et4Var = new et4();
            rj6.a().f(et4Var, new YabmentJsBridgePlugin_Proxy(et4Var));
            os4 os4Var = new os4();
            rj6.a().f(os4Var, new ActivityJsBridgePlugin_Proxy(os4Var));
            ns4 ns4Var = new ns4();
            rj6.a().f(ns4Var, new AccountJsBridgePlugin_Proxy(ns4Var));
            xs4 xs4Var = new xs4();
            rj6.a().f(xs4Var, new PaymentJsBridgePlugin_Proxy(xs4Var));
            zs4 zs4Var = new zs4();
            rj6.a().f(zs4Var, new RouterJsBridgePlugin_Proxy(zs4Var));
            ct4 ct4Var = new ct4();
            rj6.a().f(ct4Var, new SystemJsBridgePlugin_Proxy(ct4Var));
            ps4 ps4Var = new ps4();
            rj6.a().f(ps4Var, new ClipperJsBridgePlugin_Proxy(ps4Var));
        }
    }
}
