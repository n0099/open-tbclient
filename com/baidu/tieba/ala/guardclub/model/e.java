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
/* loaded from: classes11.dex */
public class e extends BdBaseModel<GuardClubJoinListActivity> {
    private boolean geO;
    private a haQ;
    private boolean hasMore;
    private com.baidu.tieba.ala.guardclub.view.d hco;
    private b hcq;
    private int hcp = 1;
    private HttpMessageListener hcr = new HttpMessageListener(1021139) { // from class: com.baidu.tieba.ala.guardclub.model.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubJoinListHttpResponseMessage)) {
                if (e.this.hco != null) {
                    e.this.hco.bRy();
                    return;
                }
                return;
            }
            GuardClubJoinListHttpResponseMessage guardClubJoinListHttpResponseMessage = (GuardClubJoinListHttpResponseMessage) httpResponsedMessage;
            if (guardClubJoinListHttpResponseMessage.getError() != 0) {
                if (e.this.hco != null) {
                    e.this.hco.bRy();
                    return;
                }
                return;
            }
            e.this.hasMore = guardClubJoinListHttpResponseMessage.hasMore;
            if (e.this.hco != null) {
                if (e.this.geO) {
                    e.this.hco.cw(guardClubJoinListHttpResponseMessage.hcm);
                    e.this.hco.completePullRefresh();
                } else {
                    e.this.hco.cx(guardClubJoinListHttpResponseMessage.hcm);
                }
                if (guardClubJoinListHttpResponseMessage.hasMore) {
                    e.this.hco.bYQ();
                } else if (!e.this.geO) {
                    e.this.hco.no(e.this.hcp == 1);
                }
                e.this.hcp++;
            }
        }
    };
    private HttpMessageListener hcs = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.guardclub.model.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubQuitHttpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == e.this.unique_id && httpResponsedMessage.getError() == 0 && e.this.hcq != null) {
                e.this.hcq.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
    }

    /* loaded from: classes11.dex */
    public interface b {
        void b(int i, String str, Object obj);
    }

    public e(BdUniqueId bdUniqueId, a aVar) {
        this.unique_id = bdUniqueId;
        this.haQ = aVar;
        bYX();
        bYY();
        MessageManager.getInstance().registerListener(this.hcr);
        MessageManager.getInstance().registerListener(this.hcs);
    }

    public void a(com.baidu.tieba.ala.guardclub.view.d dVar) {
        this.hco = dVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bYT() {
        return this.hasMore;
    }

    public void bYU() {
        np(true);
    }

    public void np(boolean z) {
        this.geO = z;
        if (z) {
            this.hcp = 1;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            bYW();
        } else if (this.hco != null) {
            this.hco.bRy();
        }
    }

    public void bYV() {
        this.geO = false;
        if (this.hco != null) {
            this.hco.bUE();
            bYW();
        }
    }

    private void bYW() {
        f fVar = new f();
        fVar.setPn(this.hcp);
        fVar.setPs(20);
        fVar.setParams();
        fVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(fVar);
    }

    public void a(String str, b bVar) {
        j jVar = new j();
        jVar.HH(str);
        jVar.setParams();
        jVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(jVar);
        this.hcq = bVar;
    }

    private void bYX() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021139, TbConfig.SERVER_HOST + "liveserver/guardClub/joinlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bYY() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/guardClub/quit");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GuardClubQuitHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.hcr != null) {
            MessageManager.getInstance().unRegisterListener(this.hcr);
        }
        if (this.hcs != null) {
            MessageManager.getInstance().unRegisterListener(this.hcr);
        }
        MessageManager.getInstance().unRegisterTask(1021139);
    }
}
