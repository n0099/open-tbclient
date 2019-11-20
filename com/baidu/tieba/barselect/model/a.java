package com.baidu.tieba.barselect.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.task.b;
/* loaded from: classes3.dex */
public class a {
    private TbPageContext ceu;

    public a(TbPageContext tbPageContext) {
        this.ceu = tbPageContext;
        b bVar = new b(309641);
        bVar.setResponsedClass(CandidateSearchSocketResMsg.class);
        MessageManager.getInstance().registerTask(bVar);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CANDIDATE_SEARCH, com.baidu.tieba.tbadkCore.a.a.bl(TbConfig.URL_CANDIDATE_SEARCH, 309641));
        tbHttpMessageTask.setResponsedClass(CandidateSearchHttpResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void p(int i, long j) {
        CandidateSearchReqMsg candidateSearchReqMsg = new CandidateSearchReqMsg();
        candidateSearchReqMsg.applyId = i;
        candidateSearchReqMsg.fid = j;
        candidateSearchReqMsg.setTag(this.ceu.getUniqueId());
        MessageManager.getInstance().sendMessage(candidateSearchReqMsg);
    }
}
