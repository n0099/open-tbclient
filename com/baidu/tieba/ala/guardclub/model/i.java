package com.baidu.tieba.ala.guardclub.model;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.guardclub.GuardClubJoinHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.utils.q;
import com.baidu.tieba.ala.guardclub.model.m;
/* loaded from: classes3.dex */
public class i implements m {
    private m.a fzX;
    private HttpMessageListener fzY;
    private HttpMessageListener fzZ;

    public i() {
        Fv();
        registerListener();
    }

    public void a(m.a aVar) {
        this.fzX = aVar;
    }

    public void BS(String str) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        httpMessage.addParam("guard_club_id", str);
        httpMessage.addParam("scene_from", q.yu());
        httpMessage.addParam("client_type", 2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void b(String str, int i, int i2, int i3) {
        l lVar = new l();
        lVar.c(EncryptionHelper.getEncryptionUserId(str + ""), i, i2, i3);
        MessageManager.getInstance().sendMessage(lVar);
    }

    public void release() {
        this.fzX = null;
        unRegisterListener();
        buM();
    }

    private void Fv() {
        buN();
    }

    private void buM() {
        MessageManager.getInstance().unRegisterTask(1021146);
    }

    private void buN() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021146, TbConfig.SERVER_HOST + "liveserver/guardClub/clubRankList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubRankHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        buO();
        buP();
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.fzY);
        MessageManager.getInstance().unRegisterListener(this.fzZ);
    }

    private void buO() {
        this.fzY = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.model.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (i.this.fzX != null) {
                    if (!(httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage)) {
                        i.this.fzX.a(false, "", 0L, "", httpResponsedMessage.getErrorString());
                        return;
                    }
                    GuardClubJoinHttpResponseMessage guardClubJoinHttpResponseMessage = (GuardClubJoinHttpResponseMessage) httpResponsedMessage;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (!guardClubJoinHttpResponseMessage.aOR) {
                            guardClubJoinHttpResponseMessage.aOR = true;
                            i.this.fzX.a(false, "", 0L, "", httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    i.this.fzX.a(true, String.valueOf(guardClubJoinHttpResponseMessage.aOO), guardClubJoinHttpResponseMessage.aOG != null ? guardClubJoinHttpResponseMessage.aOG.aOw : 0L, guardClubJoinHttpResponseMessage.aOG != null ? String.valueOf(guardClubJoinHttpResponseMessage.aOG.liveId) : "", httpResponsedMessage.getErrorString());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fzY);
    }

    private void buP() {
        this.fzZ = new HttpMessageListener(1021146) { // from class: com.baidu.tieba.ala.guardclub.model.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (i.this.fzX != null && (httpResponsedMessage instanceof GuardClubRankHttpResponseMessage)) {
                    int i = ((l) httpResponsedMessage.getOrginalMessage()).type;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        i.this.fzX.a(i, null, null, null, 0, false, false);
                        return;
                    }
                    GuardClubRankHttpResponseMessage guardClubRankHttpResponseMessage = (GuardClubRankHttpResponseMessage) httpResponsedMessage;
                    i.this.fzX.a(i, guardClubRankHttpResponseMessage.fAc, guardClubRankHttpResponseMessage.fAb, guardClubRankHttpResponseMessage.aOM, guardClubRankHttpResponseMessage.pageIndex, guardClubRankHttpResponseMessage.hasMore, guardClubRankHttpResponseMessage.aOK);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fzZ);
    }
}
