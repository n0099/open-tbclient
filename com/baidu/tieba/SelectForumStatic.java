package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SelectForumConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.attention.AttentionResMsg;
/* loaded from: classes4.dex */
public class SelectForumStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(SelectForumConfig.class, SelectForumActivity.class);
        a();
    }

    public static void a() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SELECT_FORUM_ATTENTION, TbConfig.SERVER_ADDRESS + "c/f/forum/like");
        tbHttpMessageTask.setResponsedClass(AttentionResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
