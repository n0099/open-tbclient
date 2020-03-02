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
    private m.a eHa;
    private HttpMessageListener eHb;
    private HttpMessageListener eHc;

    public i() {
        te();
        registerListener();
    }

    public void a(m.a aVar) {
        this.eHa = aVar;
    }

    public void yy(String str) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        httpMessage.addParam("guard_club_id", str);
        httpMessage.addParam("scene_from", q.sI());
        httpMessage.addParam("client_type", 2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void b(String str, int i, int i2, int i3) {
        l lVar = new l();
        lVar.c(EncryptionHelper.getEncryptionUserId(str + ""), i, i2, i3);
        MessageManager.getInstance().sendMessage(lVar);
    }

    public void release() {
        this.eHa = null;
        unRegisterListener();
        bfx();
    }

    private void te() {
        bfy();
    }

    private void bfx() {
        MessageManager.getInstance().unRegisterTask(1021146);
    }

    private void bfy() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021146, TbConfig.SERVER_HOST + "liveserver/guardClub/clubRankList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubRankHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        bfz();
        bfA();
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.eHb);
        MessageManager.getInstance().unRegisterListener(this.eHc);
    }

    private void bfz() {
        this.eHb = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.model.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (i.this.eHa != null) {
                    if (!(httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage)) {
                        i.this.eHa.a(false, "", 0L, "", httpResponsedMessage.getErrorString());
                        return;
                    }
                    GuardClubJoinHttpResponseMessage guardClubJoinHttpResponseMessage = (GuardClubJoinHttpResponseMessage) httpResponsedMessage;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        if (!guardClubJoinHttpResponseMessage.aqi) {
                            guardClubJoinHttpResponseMessage.aqi = true;
                            i.this.eHa.a(false, "", 0L, "", httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    i.this.eHa.a(true, String.valueOf(guardClubJoinHttpResponseMessage.aqf), guardClubJoinHttpResponseMessage.apX != null ? guardClubJoinHttpResponseMessage.apX.apN : 0L, guardClubJoinHttpResponseMessage.apX != null ? String.valueOf(guardClubJoinHttpResponseMessage.apX.liveId) : "", httpResponsedMessage.getErrorString());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eHb);
    }

    private void bfA() {
        this.eHc = new HttpMessageListener(1021146) { // from class: com.baidu.tieba.ala.guardclub.model.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (i.this.eHa != null && (httpResponsedMessage instanceof GuardClubRankHttpResponseMessage)) {
                    int i = ((l) httpResponsedMessage.getOrginalMessage()).type;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        i.this.eHa.a(i, null, null, null, 0, false, false);
                        return;
                    }
                    GuardClubRankHttpResponseMessage guardClubRankHttpResponseMessage = (GuardClubRankHttpResponseMessage) httpResponsedMessage;
                    i.this.eHa.a(i, guardClubRankHttpResponseMessage.eHf, guardClubRankHttpResponseMessage.eHe, guardClubRankHttpResponseMessage.aqd, guardClubRankHttpResponseMessage.pageIndex, guardClubRankHttpResponseMessage.hasMore, guardClubRankHttpResponseMessage.aqb);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eHc);
    }
}
