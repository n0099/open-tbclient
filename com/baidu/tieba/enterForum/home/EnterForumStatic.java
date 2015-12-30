package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.enterForum.square.ForumClassHttpResponseMessage;
import com.baidu.tieba.enterForum.square.ForumClassSocketResponseMessage;
/* loaded from: classes.dex */
public class EnterForumStatic {
    static {
        com.baidu.tieba.tbadkCore.a.a.c(309089, ForumClassSocketResponseMessage.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FORUM_CLASS_LIST, com.baidu.tieba.tbadkCore.a.a.ak(TbConfig.FORUM_CLASS_LIST, 309089));
        tbHttpMessageTask.setResponsedClass(ForumClassHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
