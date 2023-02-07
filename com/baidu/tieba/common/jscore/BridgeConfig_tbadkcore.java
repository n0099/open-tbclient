package com.baidu.tieba.common.jscore;

import androidx.annotation.Keep;
import com.baidu.tieba.h5power.AccountModuleJsBridge_Proxy;
import com.baidu.tieba.h5power.CommonModuleJsBridge_Proxy;
import com.baidu.tieba.h5power.OfflineDebugJsBridge_Proxy;
import com.baidu.tieba.h5power.RouterModuleJsBridge_Proxy;
import com.baidu.tieba.h5power.ShareModuleJsBridge_Proxy;
import com.baidu.tieba.tu4;
import com.baidu.tieba.uu4;
import com.baidu.tieba.vu4;
import com.baidu.tieba.wb6;
import com.baidu.tieba.wu4;
import com.baidu.tieba.xu4;
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
            xu4 xu4Var = new xu4();
            wb6.a().c(xu4Var, new ShareModuleJsBridge_Proxy(xu4Var));
            wu4 wu4Var = new wu4();
            wb6.a().c(wu4Var, new RouterModuleJsBridge_Proxy(wu4Var));
            vu4 vu4Var = new vu4();
            wb6.a().c(vu4Var, new OfflineDebugJsBridge_Proxy(vu4Var));
            uu4 uu4Var = new uu4();
            wb6.a().c(uu4Var, new CommonModuleJsBridge_Proxy(uu4Var));
            tu4 tu4Var = new tu4();
            wb6.a().c(tu4Var, new AccountModuleJsBridge_Proxy(tu4Var));
        }
    }
}
