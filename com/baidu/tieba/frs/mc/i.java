package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.ResponseIncrForumAccessCountHttpMessage;
import com.baidu.tieba.frs.ResponseIncrForumAccessCountSocketMessage;
import com.baidu.tieba.frs.ResponseSetCommForumStateHttpMessage;
import com.baidu.tieba.frs.ResponseSetCommForumStateSocketMessage;
/* loaded from: classes22.dex */
public class i {
    public i() {
        cEH();
        cEI();
    }

    private void cEH() {
        com.baidu.tbadk.task.b a2 = com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.INCREASE_FORUM_ACCESS_COUNT, ResponseIncrForumAccessCountSocketMessage.class, false, false);
        a2.setResponsedClass(ResponseIncrForumAccessCountSocketMessage.class);
        a2.setNeedAck(true);
        a2.setNeedCompress(false);
        a2.a(SocketMessageTask.DupLicateMode.NONE);
        MessageManager.getInstance().registerTask(a2);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003150, com.baidu.tieba.tbadkCore.a.a.bL(TbConfig.INCR_FORUM_ACCESS_ACOUNT, CmdConfigSocket.INCREASE_FORUM_ACCESS_COUNT));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ResponseIncrForumAccessCountHttpMessage.class);
        tbHttpMessageTask.setIsImm(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void cEI() {
        com.baidu.tbadk.task.b a2 = com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.SET_COMMON_FORUM_STATE, ResponseSetCommForumStateSocketMessage.class, false, false);
        a2.setResponsedClass(ResponseSetCommForumStateSocketMessage.class);
        a2.setNeedAck(true);
        a2.setNeedCompress(false);
        a2.a(SocketMessageTask.DupLicateMode.NONE);
        MessageManager.getInstance().registerTask(a2);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003151, com.baidu.tieba.tbadkCore.a.a.bL(TbConfig.SET_COMMON_FORUM_STATE, CmdConfigSocket.SET_COMMON_FORUM_STATE));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ResponseSetCommForumStateHttpMessage.class);
        tbHttpMessageTask.setIsImm(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
