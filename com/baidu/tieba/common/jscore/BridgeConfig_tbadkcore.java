package com.baidu.tieba.common.jscore;

import androidx.annotation.Keep;
import com.baidu.tieba.gq4;
import com.baidu.tieba.h5power.AccountModuleJsBridge_Proxy;
import com.baidu.tieba.h5power.CommonModuleJsBridge_Proxy;
import com.baidu.tieba.h5power.OfflineDebugJsBridge_Proxy;
import com.baidu.tieba.h5power.RouterModuleJsBridge_Proxy;
import com.baidu.tieba.h5power.ShareModuleJsBridge_Proxy;
import com.baidu.tieba.hq4;
import com.baidu.tieba.iq4;
import com.baidu.tieba.jq4;
import com.baidu.tieba.k76;
import com.baidu.tieba.kq4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes4.dex */
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
            kq4 kq4Var = new kq4();
            k76.a().c(kq4Var, new ShareModuleJsBridge_Proxy(kq4Var));
            jq4 jq4Var = new jq4();
            k76.a().c(jq4Var, new RouterModuleJsBridge_Proxy(jq4Var));
            iq4 iq4Var = new iq4();
            k76.a().c(iq4Var, new OfflineDebugJsBridge_Proxy(iq4Var));
            hq4 hq4Var = new hq4();
            k76.a().c(hq4Var, new CommonModuleJsBridge_Proxy(hq4Var));
            gq4 gq4Var = new gq4();
            k76.a().c(gq4Var, new AccountModuleJsBridge_Proxy(gq4Var));
        }
    }
}
