package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SelectForumConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.attention.AttentionResMsg;
/* loaded from: classes22.dex */
public class SelectForumStatic {
    public static String Tag = "tag";

    static {
        TbadkCoreApplication.getInst().RegisterIntent(SelectForumConfig.class, SelectForumActivity.class);
        bLF();
    }

    private static void bLF() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SELECT_FORUM_ATTENTION, TbConfig.SERVER_ADDRESS + Config.FORUM_LIKE_ADDRESS);
        tbHttpMessageTask.setResponsedClass(AttentionResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
