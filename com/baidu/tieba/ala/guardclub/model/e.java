package com.baidu.tieba.ala.guardclub.model;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.guardclub.GuardClubJoinListActivity;
/* loaded from: classes4.dex */
public class e extends BdBaseModel<GuardClubJoinListActivity> {
    private boolean eZg;
    private a fOO;
    private com.baidu.tieba.ala.guardclub.view.d fQp;
    private b fQr;
    private boolean hasMore;
    private int fQq = 1;
    private HttpMessageListener fQs = new HttpMessageListener(1021139) { // from class: com.baidu.tieba.ala.guardclub.model.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubJoinListHttpResponseMessage)) {
                if (e.this.fQp != null) {
                    e.this.fQp.buK();
                    return;
                }
                return;
            }
            GuardClubJoinListHttpResponseMessage guardClubJoinListHttpResponseMessage = (GuardClubJoinListHttpResponseMessage) httpResponsedMessage;
            if (guardClubJoinListHttpResponseMessage.getError() != 0) {
                if (e.this.fQp != null) {
                    e.this.fQp.buK();
                    return;
                }
                return;
            }
            e.this.hasMore = guardClubJoinListHttpResponseMessage.hasMore;
            if (e.this.fQp != null) {
                if (e.this.eZg) {
                    e.this.fQp.bL(guardClubJoinListHttpResponseMessage.fQn);
                    e.this.fQp.completePullRefresh();
                } else {
                    e.this.fQp.bM(guardClubJoinListHttpResponseMessage.fQn);
                }
                if (guardClubJoinListHttpResponseMessage.hasMore) {
                    e.this.fQp.bAM();
                } else if (!e.this.eZg) {
                    e.this.fQp.kR(e.this.fQq == 1);
                }
                e.this.fQq++;
            }
        }
    };
    private HttpMessageListener fQt = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.guardclub.model.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubQuitHttpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == e.this.unique_id && httpResponsedMessage.getError() == 0 && e.this.fQr != null) {
                e.this.fQr.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
    }

    /* loaded from: classes4.dex */
    public interface b {
        void b(int i, String str, Object obj);
    }

    public e(BdUniqueId bdUniqueId, a aVar) {
        this.unique_id = bdUniqueId;
        this.fOO = aVar;
        bAV();
        bAW();
        MessageManager.getInstance().registerListener(this.fQs);
        MessageManager.getInstance().registerListener(this.fQt);
    }

    public void a(com.baidu.tieba.ala.guardclub.view.d dVar) {
        this.fQp = dVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bAR() {
        return this.hasMore;
    }

    public void bAS() {
        kS(true);
    }

    public void kS(boolean z) {
        this.eZg = z;
        if (z) {
            this.fQq = 1;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            bAU();
        } else if (this.fQp != null) {
            this.fQp.buK();
        }
    }

    public void bAT() {
        this.eZg = false;
        if (this.fQp != null) {
            this.fQp.bwT();
            bAU();
        }
    }

    private void bAU() {
        f fVar = new f();
        fVar.setPn(this.fQq);
        fVar.setPs(20);
        fVar.setParams();
        fVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(fVar);
    }

    public void a(String str, b bVar) {
        j jVar = new j();
        jVar.Dd(str);
        jVar.setParams();
        jVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(jVar);
        this.fQr = bVar;
    }

    private void bAV() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021139, TbConfig.SERVER_HOST + "liveserver/guardClub/joinlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bAW() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/guardClub/quit");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GuardClubQuitHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.fQs != null) {
            MessageManager.getInstance().unRegisterListener(this.fQs);
        }
        if (this.fQt != null) {
            MessageManager.getInstance().unRegisterListener(this.fQs);
        }
        MessageManager.getInstance().unRegisterTask(1021139);
    }
}
