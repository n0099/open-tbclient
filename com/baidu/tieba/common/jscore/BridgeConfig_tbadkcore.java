package com.baidu.tieba.common.jscore;

import androidx.annotation.Keep;
import com.baidu.tieba.aw4;
import com.baidu.tieba.bw4;
import com.baidu.tieba.cw4;
import com.baidu.tieba.dw4;
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
import com.baidu.tieba.kh6;
import com.baidu.tieba.pv4;
import com.baidu.tieba.qv4;
import com.baidu.tieba.rv4;
import com.baidu.tieba.sv4;
import com.baidu.tieba.tv4;
import com.baidu.tieba.uv4;
import com.baidu.tieba.vv4;
import com.baidu.tieba.wv4;
import com.baidu.tieba.xv4;
import com.baidu.tieba.yv4;
import com.baidu.tieba.zv4;
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
            qv4 qv4Var = new qv4();
            kh6.a().f(qv4Var, new ActivityJsBridgePlugin_Proxy(qv4Var));
            bw4 bw4Var = new bw4();
            kh6.a().f(bw4Var, new SubscriptionJsBridgePlugin_Proxy(bw4Var));
            yv4 yv4Var = new yv4();
            kh6.a().f(yv4Var, new PaymentJsBridgePlugin_Proxy(yv4Var));
            aw4 aw4Var = new aw4();
            kh6.a().f(aw4Var, new ShareJsBridgePlugin_Proxy(aw4Var));
            zv4 zv4Var = new zv4();
            kh6.a().f(zv4Var, new RouterJsBridgePlugin_Proxy(zv4Var));
            cw4 cw4Var = new cw4();
            kh6.a().f(cw4Var, new SystemJsBridgePlugin_Proxy(cw4Var));
            tv4 tv4Var = new tv4();
            kh6.a().f(tv4Var, new HostJsBridgePlugin_Proxy(tv4Var));
            vv4 vv4Var = new vv4();
            kh6.a().f(vv4Var, new HybridJsBridgePlugin_Proxy(vv4Var));
            sv4 sv4Var = new sv4();
            kh6.a().f(sv4Var, new DeviceJsBridgePlugin_Proxy(sv4Var));
            pv4 pv4Var = new pv4();
            kh6.a().f(pv4Var, new AccountJsBridgePlugin_Proxy(pv4Var));
            rv4 rv4Var = new rv4();
            kh6.a().f(rv4Var, new ClipperJsBridgePlugin_Proxy(rv4Var));
            xv4 xv4Var = new xv4();
            kh6.a().f(xv4Var, new NavigationBarJsBridgePlugin_Proxy(xv4Var));
            uv4 uv4Var = new uv4();
            kh6.a().f(uv4Var, new HybridDebugJsBridgePlugin_Proxy(uv4Var));
            wv4 wv4Var = new wv4();
            kh6.a().f(wv4Var, new LogJsBridgePlugin_Proxy(wv4Var));
            dw4 dw4Var = new dw4();
            kh6.a().f(dw4Var, new ToastJsBridgePlugin_Proxy(dw4Var));
        }
    }
}
