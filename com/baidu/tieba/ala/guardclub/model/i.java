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
/* loaded from: classes7.dex */
public class i implements m {
    private HttpMessageListener gcA;
    private m.a gcy;
    private HttpMessageListener gcz;

    public i() {
        registerTask();
        registerListener();
    }

    public void a(m.a aVar) {
        this.gcy = aVar;
    }

    public void Fx(String str) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        httpMessage.addParam("guard_club_id", str);
        httpMessage.addParam("scene_from", p.EZ());
        httpMessage.addParam("client_type", 2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void c(String str, int i, int i2, int i3) {
        l lVar = new l();
        lVar.d(EncryptionHelper.getEncryptionUserId(str + ""), i, i2, i3);
        MessageManager.getInstance().sendMessage(lVar);
    }

    public void release() {
        this.gcy = null;
        unRegisterListener();
        unRegisterTask();
    }

    private void registerTask() {
        bKs();
    }

    private void unRegisterTask() {
        MessageManager.getInstance().unRegisterTask(1021146);
    }

    private void bKs() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021146, TbConfig.SERVER_HOST + "liveserver/guardClub/clubRankList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubRankHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        bKt();
        bKu();
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.gcz);
        MessageManager.getInstance().unRegisterListener(this.gcA);
    }

    private void bKt() {
        if (this.gcz == null) {
            this.gcz = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.model.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (i.this.gcy != null) {
                        if (!(httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage)) {
                            i.this.gcy.a(false, "", 0L, "", httpResponsedMessage.getErrorString());
                            return;
                        }
                        GuardClubJoinHttpResponseMessage guardClubJoinHttpResponseMessage = (GuardClubJoinHttpResponseMessage) httpResponsedMessage;
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            if (!guardClubJoinHttpResponseMessage.aYe) {
                                guardClubJoinHttpResponseMessage.aYe = true;
                                i.this.gcy.a(false, "", 0L, "", httpResponsedMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        i.this.gcy.a(true, String.valueOf(guardClubJoinHttpResponseMessage.aYb), guardClubJoinHttpResponseMessage.aXT != null ? guardClubJoinHttpResponseMessage.aXT.aXJ : 0L, guardClubJoinHttpResponseMessage.aXT != null ? String.valueOf(guardClubJoinHttpResponseMessage.aXT.liveId) : "", httpResponsedMessage.getErrorString());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gcz);
        }
    }

    private void bKu() {
        if (this.gcA == null) {
            this.gcA = new HttpMessageListener(1021146) { // from class: com.baidu.tieba.ala.guardclub.model.i.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (i.this.gcy != null && (httpResponsedMessage instanceof GuardClubRankHttpResponseMessage)) {
                        int i = ((l) httpResponsedMessage.getOrginalMessage()).type;
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            i.this.gcy.a(i, null, null, null, 0, false, false);
                            return;
                        }
                        GuardClubRankHttpResponseMessage guardClubRankHttpResponseMessage = (GuardClubRankHttpResponseMessage) httpResponsedMessage;
                        i.this.gcy.a(i, guardClubRankHttpResponseMessage.gcD, guardClubRankHttpResponseMessage.gcC, guardClubRankHttpResponseMessage.aXZ, guardClubRankHttpResponseMessage.pageIndex, guardClubRankHttpResponseMessage.hasMore, guardClubRankHttpResponseMessage.aXX);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gcA);
        }
    }
}
