package com.baidu.tieba.homepage.lowFlows;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.lowFlows.message.MoreTreasureTroveHttpResMsg;
import com.baidu.tieba.homepage.lowFlows.message.MoreTreasureTroveScoketResMsg;
/* loaded from: classes2.dex */
public class LowFlowsActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(LowFlowsActivityConfig.class, LowFlowsActivity.class);
        cQU();
    }

    private static void cQU() {
        com.baidu.tieba.tbadkCore.a.a.a(309691, MoreTreasureTroveScoketResMsg.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309691, CmdConfigHttp.CMD_LOW_FLOWS_PAGE, TbConfig.MORE_TREASURE_TROVE, MoreTreasureTroveHttpResMsg.class, false, true, true, true);
    }
}
