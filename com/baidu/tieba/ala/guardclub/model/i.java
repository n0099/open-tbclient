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
/* loaded from: classes3.dex */
public class i implements m {
    private m.a fLg;
    private HttpMessageListener fLh;
    private HttpMessageListener fLi;

    public i() {
        xp();
        registerListener();
    }

    public void a(m.a aVar) {
        this.fLg = aVar;
    }

    public void Cq(String str) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        httpMessage.addParam("guard_club_id", str);
        httpMessage.addParam("scene_from", p.yU());
        httpMessage.addParam("client_type", 2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void b(String str, int i, int i2, int i3) {
        l lVar = new l();
        lVar.c(EncryptionHelper.getEncryptionUserId(str + ""), i, i2, i3);
        MessageManager.getInstance().sendMessage(lVar);
    }

    public void release() {
        this.fLg = null;
        unRegisterListener();
        bxI();
    }

    private void xp() {
        bxJ();
    }

    private void bxI() {
        MessageManager.getInstance().unRegisterTask(1021146);
    }

    private void bxJ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021146, TbConfig.SERVER_HOST + "liveserver/guardClub/clubRankList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubRankHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        bxK();
        bxL();
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.fLh);
        MessageManager.getInstance().unRegisterListener(this.fLi);
    }

    private void bxK() {
        if (this.fLh == null) {
            this.fLh = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.guardclub.model.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (i.this.fLg != null) {
                        if (!(httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage)) {
                            i.this.fLg.a(false, "", 0L, "", httpResponsedMessage.getErrorString());
                            return;
                        }
                        GuardClubJoinHttpResponseMessage guardClubJoinHttpResponseMessage = (GuardClubJoinHttpResponseMessage) httpResponsedMessage;
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            if (!guardClubJoinHttpResponseMessage.aRx) {
                                guardClubJoinHttpResponseMessage.aRx = true;
                                i.this.fLg.a(false, "", 0L, "", httpResponsedMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        i.this.fLg.a(true, String.valueOf(guardClubJoinHttpResponseMessage.aRu), guardClubJoinHttpResponseMessage.aRm != null ? guardClubJoinHttpResponseMessage.aRm.aRc : 0L, guardClubJoinHttpResponseMessage.aRm != null ? String.valueOf(guardClubJoinHttpResponseMessage.aRm.liveId) : "", httpResponsedMessage.getErrorString());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.fLh);
        }
    }

    private void bxL() {
        if (this.fLi == null) {
            this.fLi = new HttpMessageListener(1021146) { // from class: com.baidu.tieba.ala.guardclub.model.i.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (i.this.fLg != null && (httpResponsedMessage instanceof GuardClubRankHttpResponseMessage)) {
                        int i = ((l) httpResponsedMessage.getOrginalMessage()).type;
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            i.this.fLg.a(i, null, null, null, 0, false, false);
                            return;
                        }
                        GuardClubRankHttpResponseMessage guardClubRankHttpResponseMessage = (GuardClubRankHttpResponseMessage) httpResponsedMessage;
                        i.this.fLg.a(i, guardClubRankHttpResponseMessage.fLl, guardClubRankHttpResponseMessage.fLk, guardClubRankHttpResponseMessage.aRs, guardClubRankHttpResponseMessage.pageIndex, guardClubRankHttpResponseMessage.hasMore, guardClubRankHttpResponseMessage.aRq);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.fLi);
        }
    }
}
