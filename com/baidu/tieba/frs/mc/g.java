package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.ResponseIncrForumAccessCountHttpMessage;
import com.baidu.tieba.frs.ResponseIncrForumAccessCountSocketMessage;
import com.baidu.tieba.frs.ResponseSetCommForumStateHttpMessage;
import com.baidu.tieba.frs.ResponseSetCommForumStateSocketMessage;
/* loaded from: classes.dex */
public class g {
    public g() {
        anQ();
        anR();
    }

    private void anQ() {
        com.baidu.tbadk.task.b a = com.baidu.tieba.tbadkCore.a.a.a(309360, ResponseIncrForumAccessCountSocketMessage.class, false, false);
        a.setResponsedClass(ResponseIncrForumAccessCountSocketMessage.class);
        a.m(true);
        a.n(false);
        a.a(SocketMessageTask.DupLicateMode.NONE);
        MessageManager.getInstance().registerTask(a);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_INCREASE_FORUM_ACCESS_COUNT, com.baidu.tieba.tbadkCore.a.a.aE(TbConfig.INCR_FORUM_ACCESS_ACOUNT, 309360));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ResponseIncrForumAccessCountHttpMessage.class);
        tbHttpMessageTask.setIsImm(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void anR() {
        com.baidu.tbadk.task.b a = com.baidu.tieba.tbadkCore.a.a.a(309365, ResponseSetCommForumStateSocketMessage.class, false, false);
        a.setResponsedClass(ResponseSetCommForumStateSocketMessage.class);
        a.m(true);
        a.n(false);
        a.a(SocketMessageTask.DupLicateMode.NONE);
        MessageManager.getInstance().registerTask(a);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SET_COMMON_FORUM_STATE, com.baidu.tieba.tbadkCore.a.a.aE(TbConfig.SET_COMMON_FORUM_STATE, 309365));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ResponseSetCommForumStateHttpMessage.class);
        tbHttpMessageTask.setIsImm(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
