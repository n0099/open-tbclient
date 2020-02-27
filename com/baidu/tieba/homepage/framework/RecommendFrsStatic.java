package com.baidu.tieba.homepage.framework;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.deletethread.DeleteThreadHttpResponseMessage;
import com.baidu.tieba.homepage.personalize.bigday.BigdayActivity;
/* loaded from: classes9.dex */
public class RecommendFrsStatic {
    static {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003184, TbConfig.SERVER_ADDRESS + TbConfig.NEG_FEED_BACK);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        messageManager.registerTask(tbHttpMessageTask);
        MessageManager messageManager2 = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_NEG_DELETE_THREAD, TbConfig.SERVER_ADDRESS + TbConfig.NEG_DELETE_THREAD);
        tbHttpMessageTask2.setResponsedClass(DeleteThreadHttpResponseMessage.class);
        tbHttpMessageTask2.setIsNeedAddCommenParam(true);
        tbHttpMessageTask2.setIsNeedTbs(true);
        tbHttpMessageTask2.setRetry(3);
        messageManager2.registerTask(tbHttpMessageTask2);
        TbadkCoreApplication.getInst().RegisterIntent(BigdayActivityConfig.class, BigdayActivity.class);
    }
}
