package com.baidu.tieba.hottopic.controller;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.RelateTopicForumActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.hottopic.message.ResponseHttpGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotTopicMessage;
/* loaded from: classes.dex */
public class HotTopicStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(HotTopicActivityConfig.class, HotTopicActivity.class);
        TbadkCoreApplication.m411getInst().RegisterIntent(RelateTopicForumActivityConfig.class, RelateTopicForumActivity.class);
        XD();
        XE();
        XF();
        XG();
    }

    private static void XD() {
        com.baidu.tieba.tbadkCore.a.a.a(303050, ResponseSocketHotTopicMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(303050, CmdConfigHttp.CMD_HOT_TOPIC, TbConfig.URL_GET_HOT_TOPIC_DATA, ResponseHttpHotTopicMessage.class, false, false, true, false);
    }

    private static void XE() {
        com.baidu.tieba.tbadkCore.a.a.a(309005, ResponseSocketGetTopicRelateThreadMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309005, CmdConfigHttp.CMD_TOPIC_RELATE_THREAD, TbConfig.URL_GET_TOPIC_RELATE_THREAD, ResponseHttpGetTopicRelateThreadMessage.class, false, false, true, false);
    }

    private static void XF() {
        com.baidu.tieba.tbadkCore.a.a.a(309085, null, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309085, CmdConfigHttp.CMD_TOPIC_BLESS, TbConfig.URL_TOPIC_USER_PK, null, false, false, true, false);
    }

    private static void XG() {
        be.wt().a(new w());
    }
}
