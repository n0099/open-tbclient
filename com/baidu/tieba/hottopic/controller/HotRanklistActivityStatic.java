package com.baidu.tieba.hottopic.controller;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.hottopic.message.ResponseHttpHotRanklistMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotRanklistMessage;
/* loaded from: classes.dex */
public class HotRanklistActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(HotRanklistActivityConfig.class, HotRanklistActivity.class);
        Xv();
    }

    private static void Xv() {
        com.baidu.tieba.tbadkCore.a.a.a(309289, ResponseSocketHotRanklistMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309289, CmdConfigHttp.CMD_HOT_TOPIC_RANKLIST, TbConfig.URL_GET_HOT_RANKLIST_DATA, ResponseHttpHotRanklistMessage.class, false, false, true, false);
    }
}
