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
/* loaded from: classes2.dex */
public class g {
    public g() {
        azm();
        azn();
    }

    private void azm() {
        com.baidu.tbadk.task.b a = com.baidu.tieba.tbadkCore.a.a.a(309360, ResponseIncrForumAccessCountSocketMessage.class, false, false);
        a.setResponsedClass(ResponseIncrForumAccessCountSocketMessage.class);
        a.p(true);
        a.q(false);
        a.a(SocketMessageTask.DupLicateMode.NONE);
        MessageManager.getInstance().registerTask(a);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_INCREASE_FORUM_ACCESS_COUNT, com.baidu.tieba.tbadkCore.a.a.aO(TbConfig.INCR_FORUM_ACCESS_ACOUNT, 309360));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ResponseIncrForumAccessCountHttpMessage.class);
        tbHttpMessageTask.setIsImm(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void azn() {
        com.baidu.tbadk.task.b a = com.baidu.tieba.tbadkCore.a.a.a(309365, ResponseSetCommForumStateSocketMessage.class, false, false);
        a.setResponsedClass(ResponseSetCommForumStateSocketMessage.class);
        a.p(true);
        a.q(false);
        a.a(SocketMessageTask.DupLicateMode.NONE);
        MessageManager.getInstance().registerTask(a);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SET_COMMON_FORUM_STATE, com.baidu.tieba.tbadkCore.a.a.aO(TbConfig.SET_COMMON_FORUM_STATE, 309365));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ResponseSetCommForumStateHttpMessage.class);
        tbHttpMessageTask.setIsImm(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
