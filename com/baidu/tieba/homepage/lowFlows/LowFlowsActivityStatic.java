package com.baidu.tieba.homepage.lowFlows;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.lowFlows.message.MoreTreasureTroveHttpResMsg;
import com.baidu.tieba.homepage.lowFlows.message.MoreTreasureTroveScoketResMsg;
import d.a.n0.e3.d0.a;
/* loaded from: classes4.dex */
public class LowFlowsActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(LowFlowsActivityConfig.class, LowFlowsActivity.class);
        a();
    }

    public static void a() {
        a.h(309691, MoreTreasureTroveScoketResMsg.class, false, false);
        a.c(309691, CmdConfigHttp.CMD_LOW_FLOWS_PAGE, TbConfig.MORE_TREASURE_TROVE, MoreTreasureTroveHttpResMsg.class, false, true, true, true);
    }
}
