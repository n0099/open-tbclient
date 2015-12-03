package com.baidu.tieba.frs.collect;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyCollectFrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class MyCollectFrsActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(MyCollectFrsActivityConfig.class, MyCollectFrsActivity.class);
        com.baidu.tieba.tbadkCore.a.a.a(309112, GetUserForumStoreSocketResponseMessage.class, false, SocketMessageTask.DupLicateMode.REMOVE_ME, true);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_USER_FORUM_STORE, com.baidu.tieba.tbadkCore.a.a.aj("c/f/livegroup/getUserForumStore", 309112));
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(GetUserForumStoreHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
