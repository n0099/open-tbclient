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
    private boolean fNx;
    private a gFU;
    private com.baidu.tieba.ala.guardclub.view.d gHs;
    private b gHu;
    private boolean hasMore;
    private int gHt = 1;
    private HttpMessageListener gHv = new HttpMessageListener(1021139) { // from class: com.baidu.tieba.ala.guardclub.model.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubJoinListHttpResponseMessage)) {
                if (e.this.gHs != null) {
                    e.this.gHs.bLo();
                    return;
                }
                return;
            }
            GuardClubJoinListHttpResponseMessage guardClubJoinListHttpResponseMessage = (GuardClubJoinListHttpResponseMessage) httpResponsedMessage;
            if (guardClubJoinListHttpResponseMessage.getError() != 0) {
                if (e.this.gHs != null) {
                    e.this.gHs.bLo();
                    return;
                }
                return;
            }
            e.this.hasMore = guardClubJoinListHttpResponseMessage.hasMore;
            if (e.this.gHs != null) {
                if (e.this.fNx) {
                    e.this.gHs.cl(guardClubJoinListHttpResponseMessage.gHq);
                    e.this.gHs.completePullRefresh();
                } else {
                    e.this.gHs.cm(guardClubJoinListHttpResponseMessage.gHq);
                }
                if (guardClubJoinListHttpResponseMessage.hasMore) {
                    e.this.gHs.bSA();
                } else if (!e.this.fNx) {
                    e.this.gHs.mt(e.this.gHt == 1);
                }
                e.this.gHt++;
            }
        }
    };
    private HttpMessageListener gHw = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.guardclub.model.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubQuitHttpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == e.this.unique_id && httpResponsedMessage.getError() == 0 && e.this.gHu != null) {
                e.this.gHu.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
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
        this.gFU = aVar;
        bSH();
        bSI();
        MessageManager.getInstance().registerListener(this.gHv);
        MessageManager.getInstance().registerListener(this.gHw);
    }

    public void a(com.baidu.tieba.ala.guardclub.view.d dVar) {
        this.gHs = dVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bSD() {
        return this.hasMore;
    }

    public void bSE() {
        mu(true);
    }

    public void mu(boolean z) {
        this.fNx = z;
        if (z) {
            this.gHt = 1;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            bSG();
        } else if (this.gHs != null) {
            this.gHs.bLo();
        }
    }

    public void bSF() {
        this.fNx = false;
        if (this.gHs != null) {
            this.gHs.bOq();
            bSG();
        }
    }

    private void bSG() {
        f fVar = new f();
        fVar.setPn(this.gHt);
        fVar.setPs(20);
        fVar.setParams();
        fVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(fVar);
    }

    public void a(String str, b bVar) {
        j jVar = new j();
        jVar.GT(str);
        jVar.setParams();
        jVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(jVar);
        this.gHu = bVar;
    }

    private void bSH() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021139, TbConfig.SERVER_HOST + "liveserver/guardClub/joinlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bSI() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/guardClub/quit");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GuardClubQuitHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.gHv != null) {
            MessageManager.getInstance().unRegisterListener(this.gHv);
        }
        if (this.gHw != null) {
            MessageManager.getInstance().unRegisterListener(this.gHv);
        }
        MessageManager.getInstance().unRegisterTask(1021139);
    }
}
