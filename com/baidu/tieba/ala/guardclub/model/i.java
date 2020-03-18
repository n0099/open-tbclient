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
    private m.a eHJ;
    private HttpMessageListener eHK;
    private HttpMessageListener eHL;

    public i() {
        tj();
        registerListener();
    }

    public void a(m.a aVar) {
        this.eHJ = aVar;
    }

    public void yz(String str) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        httpMessage.addParam("guard_club_id", str);
        httpMessage.addParam("scene_from", q.sN());
        httpMessage.addParam("client_type", 2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void b(String str, int i, int i2, int i3) {
        l lVar = new l();
        lVar.c(EncryptionHelper.getEncryptionUserId(str + ""), i, i2, i3);
        MessageManager.getInstance().sendMessage(lVar);
    }

    public void release() {
        this.eHJ = null;
        unRegisterListener();
        bfD();
    }

    private void tj() {
        bfE();
    }

    private void bfD() {
        MessageManager.getInstance().unRegisterTask(1021146);
    }

    private void bfE() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021146, TbConfig.SERVER_HOST + "liveserver/guardClub/clubRankList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubRankHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        bfF();
        bfG();
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.eHK);
        MessageManager.getInstance().unRegisterListener(this.eHL);
    }

    private void bfF() {
        this.eHK = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.model.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (i.this.eHJ != null) {
                    if (!(httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage)) {
                        i.this.eHJ.a(false, "", 0L, "", httpResponsedMessage.getErrorString());
                        return;
                    }
                    GuardClubJoinHttpResponseMessage guardClubJoinHttpResponseMessage = (GuardClubJoinHttpResponseMessage) httpResponsedMessage;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (!guardClubJoinHttpResponseMessage.aqt) {
                            guardClubJoinHttpResponseMessage.aqt = true;
                            i.this.eHJ.a(false, "", 0L, "", httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    i.this.eHJ.a(true, String.valueOf(guardClubJoinHttpResponseMessage.aqq), guardClubJoinHttpResponseMessage.aqi != null ? guardClubJoinHttpResponseMessage.aqi.apY : 0L, guardClubJoinHttpResponseMessage.aqi != null ? String.valueOf(guardClubJoinHttpResponseMessage.aqi.liveId) : "", httpResponsedMessage.getErrorString());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eHK);
    }

    private void bfG() {
        this.eHL = new HttpMessageListener(1021146) { // from class: com.baidu.tieba.ala.guardclub.model.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (i.this.eHJ != null && (httpResponsedMessage instanceof GuardClubRankHttpResponseMessage)) {
                    int i = ((l) httpResponsedMessage.getOrginalMessage()).type;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        i.this.eHJ.a(i, null, null, null, 0, false, false);
                        return;
                    }
                    GuardClubRankHttpResponseMessage guardClubRankHttpResponseMessage = (GuardClubRankHttpResponseMessage) httpResponsedMessage;
                    i.this.eHJ.a(i, guardClubRankHttpResponseMessage.eHO, guardClubRankHttpResponseMessage.eHN, guardClubRankHttpResponseMessage.aqo, guardClubRankHttpResponseMessage.pageIndex, guardClubRankHttpResponseMessage.hasMore, guardClubRankHttpResponseMessage.aqm);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eHL);
    }
}
