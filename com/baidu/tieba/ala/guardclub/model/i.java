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
/* loaded from: classes10.dex */
public class i implements m {
    private m.a gXT;
    private HttpMessageListener gXU;
    private HttpMessageListener gXV;

    public i() {
        registerTask();
        registerListener();
    }

    public void a(m.a aVar) {
        this.gXT = aVar;
    }

    public void Gu(String str) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        httpMessage.addParam("guard_club_id", str);
        httpMessage.addParam("scene_from", q.Ef());
        httpMessage.addParam("client_type", 2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void c(String str, int i, int i2, int i3) {
        l lVar = new l();
        lVar.d(EncryptionHelper.getEncryptionUserId(str + ""), i, i2, i3);
        MessageManager.getInstance().sendMessage(lVar);
    }

    public void release() {
        this.gXT = null;
        unRegisterListener();
        unRegisterTask();
    }

    private void registerTask() {
        bVj();
    }

    private void unRegisterTask() {
        MessageManager.getInstance().unRegisterTask(1021146);
    }

    private void bVj() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021146, TbConfig.SERVER_HOST + "liveserver/guardClub/clubRankList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubRankHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        bVk();
        bVl();
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.gXU);
        MessageManager.getInstance().unRegisterListener(this.gXV);
    }

    private void bVk() {
        if (this.gXU == null) {
            this.gXU = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.model.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (i.this.gXT != null) {
                        if (!(httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage)) {
                            i.this.gXT.a(false, "", 0L, "", httpResponsedMessage.getErrorString());
                            return;
                        }
                        GuardClubJoinHttpResponseMessage guardClubJoinHttpResponseMessage = (GuardClubJoinHttpResponseMessage) httpResponsedMessage;
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            if (!guardClubJoinHttpResponseMessage.bgc) {
                                guardClubJoinHttpResponseMessage.bgc = true;
                                i.this.gXT.a(false, "", 0L, "", httpResponsedMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        i.this.gXT.a(true, String.valueOf(guardClubJoinHttpResponseMessage.bfZ), guardClubJoinHttpResponseMessage.bfP != null ? guardClubJoinHttpResponseMessage.bfP.bfE : 0L, guardClubJoinHttpResponseMessage.bfP != null ? String.valueOf(guardClubJoinHttpResponseMessage.bfP.liveId) : "", httpResponsedMessage.getErrorString());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gXU);
        }
    }

    private void bVl() {
        if (this.gXV == null) {
            this.gXV = new HttpMessageListener(1021146) { // from class: com.baidu.tieba.ala.guardclub.model.i.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (i.this.gXT != null && (httpResponsedMessage instanceof GuardClubRankHttpResponseMessage)) {
                        int i = ((l) httpResponsedMessage.getOrginalMessage()).type;
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            i.this.gXT.a(i, null, null, null, 0, false, false);
                            return;
                        }
                        GuardClubRankHttpResponseMessage guardClubRankHttpResponseMessage = (GuardClubRankHttpResponseMessage) httpResponsedMessage;
                        i.this.gXT.a(i, guardClubRankHttpResponseMessage.gXY, guardClubRankHttpResponseMessage.gXX, guardClubRankHttpResponseMessage.bfX, guardClubRankHttpResponseMessage.pageIndex, guardClubRankHttpResponseMessage.hasMore, guardClubRankHttpResponseMessage.bfV);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gXV);
        }
    }
}
