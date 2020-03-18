package com.baidu.tieba.barselect.data;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes8.dex */
public class c {
    private TbPageContext cVv;

    public c(TbPageContext tbPageContext) {
        this.cVv = tbPageContext;
        SocketMessageTask socketMessageTask = new SocketMessageTask(309643);
        socketMessageTask.setResponsedClass(CommitCardInfoSocketResMsg.class);
        MessageManager.getInstance().registerTask(socketMessageTask);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_COMMIT_CARD_INFO, com.baidu.tieba.tbadkCore.a.a.bu(TbConfig.URL_COMMIT_CARD_INFO, 309643));
        tbHttpMessageTask.setResponsedClass(CommitCardInfoHttpResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void p(String str, int i, String str2) {
        CommitCardInfoReqMsg commitCardInfoReqMsg = new CommitCardInfoReqMsg();
        commitCardInfoReqMsg.resource_id = str;
        commitCardInfoReqMsg.card_type = i;
        commitCardInfoReqMsg.image_info = str2;
        commitCardInfoReqMsg.setTag(this.cVv.getUniqueId());
        MessageManager.getInstance().sendMessage(commitCardInfoReqMsg);
    }
}
