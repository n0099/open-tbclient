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
    private r.a dNX;
    private HttpMessageListener dNY;
    private HttpMessageListener dNZ;

    public n() {
        registerTask();
        registerListener();
    }

    public void a(r.a aVar) {
        this.dNX = aVar;
    }

    public void tn(String str) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        httpMessage.addParam("guard_club_id", str);
        httpMessage.addParam("scene_from", com.baidu.live.utils.o.wu());
        httpMessage.addParam("client_type", 2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void b(String str, int i, int i2, int i3) {
        q qVar = new q();
        qVar.c(EncryptionHelper.getEncryptionUserId(str + ""), i, i2, i3);
        MessageManager.getInstance().sendMessage(qVar);
    }

    public void release() {
        this.dNX = null;
        unRegisterListener();
        aLJ();
    }

    private void registerTask() {
        aLK();
    }

    private void aLJ() {
        MessageManager.getInstance().unRegisterTask(1021146);
    }

    private void aLK() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021146, TbConfig.SERVER_HOST + "liveserver/guardClub/clubRankList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubRankHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        aLL();
        aLM();
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.dNY);
        MessageManager.getInstance().unRegisterListener(this.dNZ);
    }

    private void aLL() {
        this.dNY = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.model.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (n.this.dNX != null) {
                    if (!(httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage)) {
                        n.this.dNX.a(false, "", 0L, "", httpResponsedMessage.getErrorString());
                        return;
                    }
                    GuardClubJoinHttpResponseMessage guardClubJoinHttpResponseMessage = (GuardClubJoinHttpResponseMessage) httpResponsedMessage;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (!guardClubJoinHttpResponseMessage.dNC) {
                            guardClubJoinHttpResponseMessage.dNC = true;
                            n.this.dNX.a(false, "", 0L, "", httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    n.this.dNX.a(true, String.valueOf(guardClubJoinHttpResponseMessage.dNz), guardClubJoinHttpResponseMessage.dKm != null ? guardClubJoinHttpResponseMessage.dKm.dNi : 0L, guardClubJoinHttpResponseMessage.dKm != null ? String.valueOf(guardClubJoinHttpResponseMessage.dKm.liveId) : "", httpResponsedMessage.getErrorString());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dNY);
    }

    private void aLM() {
        this.dNZ = new HttpMessageListener(1021146) { // from class: com.baidu.tieba.ala.guardclub.model.n.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (n.this.dNX != null && (httpResponsedMessage instanceof GuardClubRankHttpResponseMessage)) {
                    int i = ((q) httpResponsedMessage.getOrginalMessage()).type;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        n.this.dNX.a(i, null, null, null, 0, false, false);
                        return;
                    }
                    GuardClubRankHttpResponseMessage guardClubRankHttpResponseMessage = (GuardClubRankHttpResponseMessage) httpResponsedMessage;
                    n.this.dNX.a(i, guardClubRankHttpResponseMessage.dOc, guardClubRankHttpResponseMessage.dOb, guardClubRankHttpResponseMessage.dNv, guardClubRankHttpResponseMessage.pageIndex, guardClubRankHttpResponseMessage.hasMore, guardClubRankHttpResponseMessage.dNt);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dNZ);
    }
}
