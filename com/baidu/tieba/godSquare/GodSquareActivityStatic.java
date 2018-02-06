package com.baidu.tieba.godSquare;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GodSquareActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.godSquare.model.res.GodSquareHttpResponsedMsg;
import com.baidu.tieba.godSquare.model.res.GodSquareSocketResponsedMsg;
/* loaded from: classes3.dex */
public class GodSquareActivityStatic {
    static {
        com.baidu.tieba.tbadkCore.a.a.b(2016446, com.baidu.tieba.godSquare.model.req.a.class);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigHttp.CMD_GET_HOT_GOD, 309315, TbConfig.GET_HOT_GOD, GodSquareHttpResponsedMsg.class, GodSquareSocketResponsedMsg.class);
        TbadkCoreApplication.getInst().RegisterIntent(GodSquareActivityConfig.class, GodSquareActivity.class);
    }
}
