package com.baidu.tieba.common.jscore;

import androidx.annotation.Keep;
import com.baidu.tieba.as4;
import com.baidu.tieba.bs4;
import com.baidu.tieba.cs4;
import com.baidu.tieba.ds4;
import com.baidu.tieba.es4;
import com.baidu.tieba.fs4;
import com.baidu.tieba.gs4;
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
import com.baidu.tieba.hh6;
import com.baidu.tieba.hs4;
import com.baidu.tieba.is4;
import com.baidu.tieba.sr4;
import com.baidu.tieba.tr4;
import com.baidu.tieba.ur4;
import com.baidu.tieba.vr4;
import com.baidu.tieba.wr4;
import com.baidu.tieba.xr4;
import com.baidu.tieba.yr4;
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
            hs4 hs4Var = new hs4();
            hh6.a().f(hs4Var, new ToastJsBridgePlugin_Proxy(hs4Var));
            wr4 wr4Var = new wr4();
            hh6.a().f(wr4Var, new HostJsBridgePlugin_Proxy(wr4Var));
            vr4 vr4Var = new vr4();
            hh6.a().f(vr4Var, new DeviceJsBridgePlugin_Proxy(vr4Var));
            bs4 bs4Var = new bs4();
            hh6.a().f(bs4Var, new NavigationBarJsBridgePlugin_Proxy(bs4Var));
            cs4 cs4Var = new cs4();
            hh6.a().f(cs4Var, new PaymentJsBridgePlugin_Proxy(cs4Var));
            as4 as4Var = new as4();
            hh6.a().f(as4Var, new LogJsBridgePlugin_Proxy(as4Var));
            yr4 yr4Var = new yr4();
            hh6.a().f(yr4Var, new HybridJsBridgePlugin_Proxy(yr4Var));
            gs4 gs4Var = new gs4();
            hh6.a().f(gs4Var, new SystemJsBridgePlugin_Proxy(gs4Var));
            fs4 fs4Var = new fs4();
            hh6.a().f(fs4Var, new SubscriptionJsBridgePlugin_Proxy(fs4Var));
            xr4 xr4Var = new xr4();
            hh6.a().f(xr4Var, new HybridDebugJsBridgePlugin_Proxy(xr4Var));
            es4 es4Var = new es4();
            hh6.a().f(es4Var, new ShareJsBridgePlugin_Proxy(es4Var));
            tr4 tr4Var = new tr4();
            hh6.a().f(tr4Var, new ActivityJsBridgePlugin_Proxy(tr4Var));
            sr4 sr4Var = new sr4();
            hh6.a().f(sr4Var, new AccountJsBridgePlugin_Proxy(sr4Var));
            is4 is4Var = new is4();
            hh6.a().f(is4Var, new YabmentJsBridgePlugin_Proxy(is4Var));
            ds4 ds4Var = new ds4();
            hh6.a().f(ds4Var, new RouterJsBridgePlugin_Proxy(ds4Var));
            ur4 ur4Var = new ur4();
            hh6.a().f(ur4Var, new ClipperJsBridgePlugin_Proxy(ur4Var));
        }
    }
}
