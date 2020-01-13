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
/* loaded from: classes7.dex */
public class i {
    public i() {
        bHW();
        bHX();
    }

    private void bHW() {
        com.baidu.tbadk.task.b a = com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.INCREASE_FORUM_ACCESS_COUNT, ResponseIncrForumAccessCountSocketMessage.class, false, false);
        a.setResponsedClass(ResponseIncrForumAccessCountSocketMessage.class);
        a.setNeedAck(true);
        a.setNeedCompress(false);
        a.a(SocketMessageTask.DupLicateMode.NONE);
        MessageManager.getInstance().registerTask(a);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003150, com.baidu.tieba.tbadkCore.a.a.bv(TbConfig.INCR_FORUM_ACCESS_ACOUNT, CmdConfigSocket.INCREASE_FORUM_ACCESS_COUNT));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ResponseIncrForumAccessCountHttpMessage.class);
        tbHttpMessageTask.setIsImm(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bHX() {
        com.baidu.tbadk.task.b a = com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.SET_COMMON_FORUM_STATE, ResponseSetCommForumStateSocketMessage.class, false, false);
        a.setResponsedClass(ResponseSetCommForumStateSocketMessage.class);
        a.setNeedAck(true);
        a.setNeedCompress(false);
        a.a(SocketMessageTask.DupLicateMode.NONE);
        MessageManager.getInstance().registerTask(a);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003151, com.baidu.tieba.tbadkCore.a.a.bv(TbConfig.SET_COMMON_FORUM_STATE, CmdConfigSocket.SET_COMMON_FORUM_STATE));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ResponseSetCommForumStateHttpMessage.class);
        tbHttpMessageTask.setIsImm(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
