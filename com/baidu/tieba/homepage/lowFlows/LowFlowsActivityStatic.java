package com.baidu.tieba.homepage.lowFlows;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.lowFlows.message.MoreTreasureTroveHttpResMsg;
import com.baidu.tieba.homepage.lowFlows.message.MoreTreasureTroveScoketResMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jk8;
/* loaded from: classes3.dex */
public class LowFlowsActivityStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1741906178, "Lcom/baidu/tieba/homepage/lowFlows/LowFlowsActivityStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1741906178, "Lcom/baidu/tieba/homepage/lowFlows/LowFlowsActivityStatic;");
                return;
            }
        }
        TbadkCoreApplication.getInst().RegisterIntent(LowFlowsActivityConfig.class, LowFlowsActivity.class);
        a();
    }

    public LowFlowsActivityStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            jk8.h(309691, MoreTreasureTroveScoketResMsg.class, false, false);
            jk8.c(309691, CmdConfigHttp.CMD_LOW_FLOWS_PAGE, TbConfig.MORE_TREASURE_TROVE, MoreTreasureTroveHttpResMsg.class, false, true, true, true);
        }
    }
}
