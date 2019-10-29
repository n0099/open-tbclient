package com.baidu.tieba.ala.guardclub.model;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.guardclub.model.r;
/* loaded from: classes6.dex */
public class n implements r {
    private r.a dOO;
    private HttpMessageListener dOP;
    private HttpMessageListener dOQ;

    public n() {
        registerTask();
        registerListener();
    }

    public void a(r.a aVar) {
        this.dOO = aVar;
    }

    public void tn(String str) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        httpMessage.addParam("guard_club_id", str);
        httpMessage.addParam("scene_from", com.baidu.live.utils.o.wt());
        httpMessage.addParam("client_type", 2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void b(String str, int i, int i2, int i3) {
        q qVar = new q();
        qVar.c(EncryptionHelper.getEncryptionUserId(str + ""), i, i2, i3);
        MessageManager.getInstance().sendMessage(qVar);
    }

    public void release() {
        this.dOO = null;
        unRegisterListener();
        aLL();
    }

    private void registerTask() {
        aLM();
    }

    private void aLL() {
        MessageManager.getInstance().unRegisterTask(1021146);
    }

    private void aLM() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021146, TbConfig.SERVER_HOST + "liveserver/guardClub/clubRankList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubRankHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        aLN();
        aLO();
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.dOP);
        MessageManager.getInstance().unRegisterListener(this.dOQ);
    }

    private void aLN() {
        this.dOP = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.model.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (n.this.dOO != null) {
                    if (!(httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage)) {
                        n.this.dOO.a(false, "", 0L, "", httpResponsedMessage.getErrorString());
                        return;
                    }
                    GuardClubJoinHttpResponseMessage guardClubJoinHttpResponseMessage = (GuardClubJoinHttpResponseMessage) httpResponsedMessage;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (!guardClubJoinHttpResponseMessage.dOt) {
                            guardClubJoinHttpResponseMessage.dOt = true;
                            n.this.dOO.a(false, "", 0L, "", httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    n.this.dOO.a(true, String.valueOf(guardClubJoinHttpResponseMessage.dOq), guardClubJoinHttpResponseMessage.dLd != null ? guardClubJoinHttpResponseMessage.dLd.dNZ : 0L, guardClubJoinHttpResponseMessage.dLd != null ? String.valueOf(guardClubJoinHttpResponseMessage.dLd.liveId) : "", httpResponsedMessage.getErrorString());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dOP);
    }

    private void aLO() {
        this.dOQ = new HttpMessageListener(1021146) { // from class: com.baidu.tieba.ala.guardclub.model.n.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (n.this.dOO != null && (httpResponsedMessage instanceof GuardClubRankHttpResponseMessage)) {
                    int i = ((q) httpResponsedMessage.getOrginalMessage()).type;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        n.this.dOO.a(i, null, null, null, 0, false, false);
                        return;
                    }
                    GuardClubRankHttpResponseMessage guardClubRankHttpResponseMessage = (GuardClubRankHttpResponseMessage) httpResponsedMessage;
                    n.this.dOO.a(i, guardClubRankHttpResponseMessage.dOT, guardClubRankHttpResponseMessage.dOS, guardClubRankHttpResponseMessage.dOm, guardClubRankHttpResponseMessage.pageIndex, guardClubRankHttpResponseMessage.hasMore, guardClubRankHttpResponseMessage.dOk);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dOQ);
    }
}
