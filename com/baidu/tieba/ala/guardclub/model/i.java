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
import com.baidu.live.utils.p;
import com.baidu.tieba.ala.guardclub.model.m;
/* loaded from: classes4.dex */
public class i implements m {
    private m.a gQM;
    private HttpMessageListener gQN;
    private HttpMessageListener gQO;

    public i() {
        registerTask();
        registerListener();
    }

    public void a(m.a aVar) {
        this.gQM = aVar;
    }

    public void HG(String str) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        httpMessage.addParam("guard_club_id", str);
        httpMessage.addParam("scene_from", p.Iz());
        httpMessage.addParam("client_type", 2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void c(String str, int i, int i2, int i3) {
        l lVar = new l();
        lVar.d(EncryptionHelper.getEncryptionUserId(str + ""), i, i2, i3);
        MessageManager.getInstance().sendMessage(lVar);
    }

    public void release() {
        this.gQM = null;
        unRegisterListener();
        unRegisterTask();
    }

    private void registerTask() {
        bWv();
    }

    private void unRegisterTask() {
        MessageManager.getInstance().unRegisterTask(1021146);
    }

    private void bWv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021146, TbConfig.SERVER_HOST + "liveserver/guardClub/clubRankList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubRankHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        bWw();
        bWx();
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.gQN);
        MessageManager.getInstance().unRegisterListener(this.gQO);
    }

    private void bWw() {
        if (this.gQN == null) {
            this.gQN = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.model.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (i.this.gQM != null) {
                        if (!(httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage)) {
                            i.this.gQM.a(false, "", 0L, "", httpResponsedMessage.getErrorString());
                            return;
                        }
                        GuardClubJoinHttpResponseMessage guardClubJoinHttpResponseMessage = (GuardClubJoinHttpResponseMessage) httpResponsedMessage;
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            if (!guardClubJoinHttpResponseMessage.bjn) {
                                guardClubJoinHttpResponseMessage.bjn = true;
                                i.this.gQM.a(false, "", 0L, "", httpResponsedMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        i.this.gQM.a(true, String.valueOf(guardClubJoinHttpResponseMessage.bjk), guardClubJoinHttpResponseMessage.bja != null ? guardClubJoinHttpResponseMessage.bja.biP : 0L, guardClubJoinHttpResponseMessage.bja != null ? String.valueOf(guardClubJoinHttpResponseMessage.bja.liveId) : "", httpResponsedMessage.getErrorString());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gQN);
        }
    }

    private void bWx() {
        if (this.gQO == null) {
            this.gQO = new HttpMessageListener(1021146) { // from class: com.baidu.tieba.ala.guardclub.model.i.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (i.this.gQM != null && (httpResponsedMessage instanceof GuardClubRankHttpResponseMessage)) {
                        int i = ((l) httpResponsedMessage.getOrginalMessage()).type;
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            i.this.gQM.a(i, null, null, null, 0, false, false);
                            return;
                        }
                        GuardClubRankHttpResponseMessage guardClubRankHttpResponseMessage = (GuardClubRankHttpResponseMessage) httpResponsedMessage;
                        i.this.gQM.a(i, guardClubRankHttpResponseMessage.gQR, guardClubRankHttpResponseMessage.gQQ, guardClubRankHttpResponseMessage.bji, guardClubRankHttpResponseMessage.pageIndex, guardClubRankHttpResponseMessage.hasMore, guardClubRankHttpResponseMessage.bjg);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gQO);
        }
    }
}
