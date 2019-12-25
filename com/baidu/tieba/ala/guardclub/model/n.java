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
/* loaded from: classes2.dex */
public class n implements r {
    private r.a eCe;
    private HttpMessageListener eCf;
    private HttpMessageListener eCg;

    public n() {
        rG();
        registerListener();
    }

    public void a(r.a aVar) {
        this.eCe = aVar;
    }

    public void xY(String str) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        httpMessage.addParam("guard_club_id", str);
        httpMessage.addParam("scene_from", com.baidu.live.utils.p.yu());
        httpMessage.addParam("client_type", 2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void b(String str, int i, int i2, int i3) {
        q qVar = new q();
        qVar.c(EncryptionHelper.getEncryptionUserId(str + ""), i, i2, i3);
        MessageManager.getInstance().sendMessage(qVar);
    }

    public void release() {
        this.eCe = null;
        unRegisterListener();
        bcS();
    }

    private void rG() {
        bcT();
    }

    private void bcS() {
        MessageManager.getInstance().unRegisterTask(1021146);
    }

    private void bcT() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021146, TbConfig.SERVER_HOST + "liveserver/guardClub/clubRankList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubRankHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        bcU();
        bcV();
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.eCf);
        MessageManager.getInstance().unRegisterListener(this.eCg);
    }

    private void bcU() {
        this.eCf = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.model.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (n.this.eCe != null) {
                    if (!(httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage)) {
                        n.this.eCe.a(false, "", 0L, "", httpResponsedMessage.getErrorString());
                        return;
                    }
                    GuardClubJoinHttpResponseMessage guardClubJoinHttpResponseMessage = (GuardClubJoinHttpResponseMessage) httpResponsedMessage;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (!guardClubJoinHttpResponseMessage.eBK) {
                            guardClubJoinHttpResponseMessage.eBK = true;
                            n.this.eCe.a(false, "", 0L, "", httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    n.this.eCe.a(true, String.valueOf(guardClubJoinHttpResponseMessage.eBH), guardClubJoinHttpResponseMessage.eyC != null ? guardClubJoinHttpResponseMessage.eyC.eBq : 0L, guardClubJoinHttpResponseMessage.eyC != null ? String.valueOf(guardClubJoinHttpResponseMessage.eyC.liveId) : "", httpResponsedMessage.getErrorString());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eCf);
    }

    private void bcV() {
        this.eCg = new HttpMessageListener(1021146) { // from class: com.baidu.tieba.ala.guardclub.model.n.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (n.this.eCe != null && (httpResponsedMessage instanceof GuardClubRankHttpResponseMessage)) {
                    int i = ((q) httpResponsedMessage.getOrginalMessage()).type;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        n.this.eCe.a(i, null, null, null, 0, false, false);
                        return;
                    }
                    GuardClubRankHttpResponseMessage guardClubRankHttpResponseMessage = (GuardClubRankHttpResponseMessage) httpResponsedMessage;
                    n.this.eCe.a(i, guardClubRankHttpResponseMessage.eCj, guardClubRankHttpResponseMessage.eCi, guardClubRankHttpResponseMessage.eBD, guardClubRankHttpResponseMessage.pageIndex, guardClubRankHttpResponseMessage.hasMore, guardClubRankHttpResponseMessage.eBB);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eCg);
    }
}
