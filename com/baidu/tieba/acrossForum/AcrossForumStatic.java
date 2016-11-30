package com.baidu.tieba.acrossForum;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.acrossForum.message.AcrossForumHttpResMsg;
import com.baidu.tieba.acrossForum.message.AcrossForumSocketResMsg;
/* loaded from: classes.dex */
public class AcrossForumStatic {
    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigHttp.CMD_ACROSS_FORUM, 309424, TbConfig.ACROSS_FORUM, AcrossForumHttpResMsg.class, AcrossForumSocketResMsg.class);
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.CMD_EXIT_APP));
    }
}
