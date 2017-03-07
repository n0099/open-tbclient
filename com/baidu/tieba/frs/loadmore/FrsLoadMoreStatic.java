package com.baidu.tieba.frs.loadmore;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class FrsLoadMoreStatic {
    static {
        com.baidu.tieba.tbadkCore.a.a.c(301002, LoadMoreResponseSocketMessage.class, false);
        acL();
    }

    private static void acL() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_LOAD_MORE_CMD, com.baidu.tieba.tbadkCore.a.a.av(FrsLoadMoreModel.LOAD_MORE_URL, 301002));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(LoadMoreHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
