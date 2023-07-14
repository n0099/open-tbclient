package com.baidu.tieba.common.jscore;

import androidx.annotation.Keep;
import com.baidu.tieba.ey4;
import com.baidu.tieba.fy4;
import com.baidu.tieba.gy4;
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
import com.baidu.tieba.hy4;
import com.baidu.tieba.iy4;
import com.baidu.tieba.jn6;
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
            fy4 fy4Var = new fy4();
            jn6.a().f(fy4Var, new ActivityJsBridgePlugin_Proxy(fy4Var));
            qy4 qy4Var = new qy4();
            jn6.a().f(qy4Var, new SubscriptionJsBridgePlugin_Proxy(qy4Var));
            ny4 ny4Var = new ny4();
            jn6.a().f(ny4Var, new PaymentJsBridgePlugin_Proxy(ny4Var));
            py4 py4Var = new py4();
            jn6.a().f(py4Var, new ShareJsBridgePlugin_Proxy(py4Var));
            oy4 oy4Var = new oy4();
            jn6.a().f(oy4Var, new RouterJsBridgePlugin_Proxy(oy4Var));
            ry4 ry4Var = new ry4();
            jn6.a().f(ry4Var, new SystemJsBridgePlugin_Proxy(ry4Var));
            ty4 ty4Var = new ty4();
            jn6.a().f(ty4Var, new YabmentJsBridgePlugin_Proxy(ty4Var));
            iy4 iy4Var = new iy4();
            jn6.a().f(iy4Var, new HostJsBridgePlugin_Proxy(iy4Var));
            ky4 ky4Var = new ky4();
            jn6.a().f(ky4Var, new HybridJsBridgePlugin_Proxy(ky4Var));
            hy4 hy4Var = new hy4();
            jn6.a().f(hy4Var, new DeviceJsBridgePlugin_Proxy(hy4Var));
            ey4 ey4Var = new ey4();
            jn6.a().f(ey4Var, new AccountJsBridgePlugin_Proxy(ey4Var));
            gy4 gy4Var = new gy4();
            jn6.a().f(gy4Var, new ClipperJsBridgePlugin_Proxy(gy4Var));
            my4 my4Var = new my4();
            jn6.a().f(my4Var, new NavigationBarJsBridgePlugin_Proxy(my4Var));
            jy4 jy4Var = new jy4();
            jn6.a().f(jy4Var, new HybridDebugJsBridgePlugin_Proxy(jy4Var));
            ly4 ly4Var = new ly4();
            jn6.a().f(ly4Var, new LogJsBridgePlugin_Proxy(ly4Var));
            sy4 sy4Var = new sy4();
            jn6.a().f(sy4Var, new ToastJsBridgePlugin_Proxy(sy4Var));
        }
    }
}
