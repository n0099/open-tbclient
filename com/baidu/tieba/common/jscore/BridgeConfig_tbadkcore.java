package com.baidu.tieba.common.jscore;

import androidx.annotation.Keep;
import com.baidu.tieba.fe6;
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
import com.baidu.tieba.kv4;
import com.baidu.tieba.lv4;
import com.baidu.tieba.mv4;
import com.baidu.tieba.nv4;
import com.baidu.tieba.ov4;
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
            lv4 lv4Var = new lv4();
            fe6.a().d(lv4Var, new ActivityJsBridgePlugin_Proxy(lv4Var));
            wv4 wv4Var = new wv4();
            fe6.a().d(wv4Var, new SubscriptionJsBridgePlugin_Proxy(wv4Var));
            tv4 tv4Var = new tv4();
            fe6.a().d(tv4Var, new PaymentJsBridgePlugin_Proxy(tv4Var));
            vv4 vv4Var = new vv4();
            fe6.a().d(vv4Var, new ShareJsBridgePlugin_Proxy(vv4Var));
            uv4 uv4Var = new uv4();
            fe6.a().d(uv4Var, new RouterJsBridgePlugin_Proxy(uv4Var));
            xv4 xv4Var = new xv4();
            fe6.a().d(xv4Var, new SystemJsBridgePlugin_Proxy(xv4Var));
            ov4 ov4Var = new ov4();
            fe6.a().d(ov4Var, new HostJsBridgePlugin_Proxy(ov4Var));
            pv4 pv4Var = new pv4();
            fe6.a().d(pv4Var, new HybridJsBridgePlugin_Proxy(pv4Var));
            nv4 nv4Var = new nv4();
            fe6.a().d(nv4Var, new DeviceJsBridgePlugin_Proxy(nv4Var));
            kv4 kv4Var = new kv4();
            fe6.a().d(kv4Var, new AccountJsBridgePlugin_Proxy(kv4Var));
            mv4 mv4Var = new mv4();
            fe6.a().d(mv4Var, new ClipperJsBridgePlugin_Proxy(mv4Var));
            rv4 rv4Var = new rv4();
            fe6.a().d(rv4Var, new NavigationBarJsBridgePlugin_Proxy(rv4Var));
            qv4 qv4Var = new qv4();
            fe6.a().d(qv4Var, new LogJsBridgePlugin_Proxy(qv4Var));
            sv4 sv4Var = new sv4();
            fe6.a().d(sv4Var, new OfflineJsBridgePlugin_Proxy(sv4Var));
            yv4 yv4Var = new yv4();
            fe6.a().d(yv4Var, new ToastJsBridgePlugin_Proxy(yv4Var));
        }
    }
}
