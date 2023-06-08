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
import com.baidu.tieba.hy4;
import com.baidu.tieba.iy4;
import com.baidu.tieba.jy4;
import com.baidu.tieba.ky4;
import com.baidu.tieba.ly4;
import com.baidu.tieba.my4;
import com.baidu.tieba.ny4;
import com.baidu.tieba.oy4;
import com.baidu.tieba.py4;
import com.baidu.tieba.qy4;
import com.baidu.tieba.ry4;
import com.baidu.tieba.sy4;
import com.baidu.tieba.ty4;
import com.baidu.tieba.uy4;
import com.baidu.tieba.vl6;
import com.baidu.tieba.vy4;
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
            iy4 iy4Var = new iy4();
            vl6.a().f(iy4Var, new ActivityJsBridgePlugin_Proxy(iy4Var));
            ty4 ty4Var = new ty4();
            vl6.a().f(ty4Var, new SubscriptionJsBridgePlugin_Proxy(ty4Var));
            qy4 qy4Var = new qy4();
            vl6.a().f(qy4Var, new PaymentJsBridgePlugin_Proxy(qy4Var));
            sy4 sy4Var = new sy4();
            vl6.a().f(sy4Var, new ShareJsBridgePlugin_Proxy(sy4Var));
            ry4 ry4Var = new ry4();
            vl6.a().f(ry4Var, new RouterJsBridgePlugin_Proxy(ry4Var));
            uy4 uy4Var = new uy4();
            vl6.a().f(uy4Var, new SystemJsBridgePlugin_Proxy(uy4Var));
            ly4 ly4Var = new ly4();
            vl6.a().f(ly4Var, new HostJsBridgePlugin_Proxy(ly4Var));
            ny4 ny4Var = new ny4();
            vl6.a().f(ny4Var, new HybridJsBridgePlugin_Proxy(ny4Var));
            ky4 ky4Var = new ky4();
            vl6.a().f(ky4Var, new DeviceJsBridgePlugin_Proxy(ky4Var));
            hy4 hy4Var = new hy4();
            vl6.a().f(hy4Var, new AccountJsBridgePlugin_Proxy(hy4Var));
            jy4 jy4Var = new jy4();
            vl6.a().f(jy4Var, new ClipperJsBridgePlugin_Proxy(jy4Var));
            py4 py4Var = new py4();
            vl6.a().f(py4Var, new NavigationBarJsBridgePlugin_Proxy(py4Var));
            my4 my4Var = new my4();
            vl6.a().f(my4Var, new HybridDebugJsBridgePlugin_Proxy(my4Var));
            oy4 oy4Var = new oy4();
            vl6.a().f(oy4Var, new LogJsBridgePlugin_Proxy(oy4Var));
            vy4 vy4Var = new vy4();
            vl6.a().f(vy4Var, new ToastJsBridgePlugin_Proxy(vy4Var));
        }
    }
}
