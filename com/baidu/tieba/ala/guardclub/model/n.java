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
    private r.a eDp;
    private HttpMessageListener eDq;
    private HttpMessageListener eDr;

    public n() {
        rT();
        registerListener();
    }

    public void a(r.a aVar) {
        this.eDp = aVar;
    }

    public void yd(String str) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        httpMessage.addParam("guard_club_id", str);
        httpMessage.addParam("scene_from", com.baidu.live.utils.q.yN());
        httpMessage.addParam("client_type", 2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void b(String str, int i, int i2, int i3) {
        q qVar = new q();
        qVar.c(EncryptionHelper.getEncryptionUserId(str + ""), i, i2, i3);
        MessageManager.getInstance().sendMessage(qVar);
    }

    public void release() {
        this.eDp = null;
        unRegisterListener();
        bdn();
    }

    private void rT() {
        bdo();
    }

    private void bdn() {
        MessageManager.getInstance().unRegisterTask(1021146);
    }

    private void bdo() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021146, TbConfig.SERVER_HOST + "liveserver/guardClub/clubRankList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubRankHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        bdp();
        bdq();
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.eDq);
        MessageManager.getInstance().unRegisterListener(this.eDr);
    }

    private void bdp() {
        this.eDq = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.model.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (n.this.eDp != null) {
                    if (!(httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage)) {
                        n.this.eDp.a(false, "", 0L, "", httpResponsedMessage.getErrorString());
                        return;
                    }
                    GuardClubJoinHttpResponseMessage guardClubJoinHttpResponseMessage = (GuardClubJoinHttpResponseMessage) httpResponsedMessage;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (!guardClubJoinHttpResponseMessage.eCV) {
                            guardClubJoinHttpResponseMessage.eCV = true;
                            n.this.eDp.a(false, "", 0L, "", httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    n.this.eDp.a(true, String.valueOf(guardClubJoinHttpResponseMessage.eCS), guardClubJoinHttpResponseMessage.ezN != null ? guardClubJoinHttpResponseMessage.ezN.eCB : 0L, guardClubJoinHttpResponseMessage.ezN != null ? String.valueOf(guardClubJoinHttpResponseMessage.ezN.liveId) : "", httpResponsedMessage.getErrorString());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eDq);
    }

    private void bdq() {
        this.eDr = new HttpMessageListener(1021146) { // from class: com.baidu.tieba.ala.guardclub.model.n.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (n.this.eDp != null && (httpResponsedMessage instanceof GuardClubRankHttpResponseMessage)) {
                    int i = ((q) httpResponsedMessage.getOrginalMessage()).type;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        n.this.eDp.a(i, null, null, null, 0, false, false);
                        return;
                    }
                    GuardClubRankHttpResponseMessage guardClubRankHttpResponseMessage = (GuardClubRankHttpResponseMessage) httpResponsedMessage;
                    n.this.eDp.a(i, guardClubRankHttpResponseMessage.eDu, guardClubRankHttpResponseMessage.eDt, guardClubRankHttpResponseMessage.eCO, guardClubRankHttpResponseMessage.pageIndex, guardClubRankHttpResponseMessage.hasMore, guardClubRankHttpResponseMessage.eCM);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eDr);
    }
}
