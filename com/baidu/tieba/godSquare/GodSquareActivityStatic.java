package com.baidu.tieba.godSquare;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GodSquareActivityConfig;
import com.baidu.tieba.godSquare.model.res.GodSquareHttpResponsedMsg;
import com.baidu.tieba.godSquare.model.res.GodSquareSocketResponsedMsg;
/* loaded from: classes11.dex */
public class GodSquareActivityStatic {
    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_GET_HOT_GOD_CACHE, com.baidu.tieba.godSquare.model.req.a.class);
        com.baidu.tieba.tbadkCore.a.a.b(1003099, CmdConfigSocket.CMD_GET_HOT_GOD, TbConfig.GET_HOT_GOD, GodSquareHttpResponsedMsg.class, GodSquareSocketResponsedMsg.class);
        TbadkCoreApplication.getInst().RegisterIntent(GodSquareActivityConfig.class, GodSquareActivity.class);
    }
}
