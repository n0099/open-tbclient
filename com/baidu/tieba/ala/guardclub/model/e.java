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
    private boolean fVi;
    private a gPd;
    private com.baidu.tieba.ala.guardclub.view.d gQB;
    private b gQD;
    private boolean hasMore;
    private int gQC = 1;
    private HttpMessageListener gQE = new HttpMessageListener(1021139) { // from class: com.baidu.tieba.ala.guardclub.model.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubJoinListHttpResponseMessage)) {
                if (e.this.gQB != null) {
                    e.this.gQB.bOY();
                    return;
                }
                return;
            }
            GuardClubJoinListHttpResponseMessage guardClubJoinListHttpResponseMessage = (GuardClubJoinListHttpResponseMessage) httpResponsedMessage;
            if (guardClubJoinListHttpResponseMessage.getError() != 0) {
                if (e.this.gQB != null) {
                    e.this.gQB.bOY();
                    return;
                }
                return;
            }
            e.this.hasMore = guardClubJoinListHttpResponseMessage.hasMore;
            if (e.this.gQB != null) {
                if (e.this.fVi) {
                    e.this.gQB.cp(guardClubJoinListHttpResponseMessage.gQz);
                    e.this.gQB.completePullRefresh();
                } else {
                    e.this.gQB.cq(guardClubJoinListHttpResponseMessage.gQz);
                }
                if (guardClubJoinListHttpResponseMessage.hasMore) {
                    e.this.gQB.bWl();
                } else if (!e.this.fVi) {
                    e.this.gQB.mO(e.this.gQC == 1);
                }
                e.this.gQC++;
            }
        }
    };
    private HttpMessageListener gQF = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.guardclub.model.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubQuitHttpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == e.this.unique_id && httpResponsedMessage.getError() == 0 && e.this.gQD != null) {
                e.this.gQD.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
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
        this.gPd = aVar;
        bWs();
        bWt();
        MessageManager.getInstance().registerListener(this.gQE);
        MessageManager.getInstance().registerListener(this.gQF);
    }

    public void a(com.baidu.tieba.ala.guardclub.view.d dVar) {
        this.gQB = dVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bWo() {
        return this.hasMore;
    }

    public void bWp() {
        mP(true);
    }

    public void mP(boolean z) {
        this.fVi = z;
        if (z) {
            this.gQC = 1;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            bWr();
        } else if (this.gQB != null) {
            this.gQB.bOY();
        }
    }

    public void bWq() {
        this.fVi = false;
        if (this.gQB != null) {
            this.gQB.bSc();
            bWr();
        }
    }

    private void bWr() {
        f fVar = new f();
        fVar.setPn(this.gQC);
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
        this.gQD = bVar;
    }

    private void bWs() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021139, TbConfig.SERVER_HOST + "liveserver/guardClub/joinlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bWt() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/guardClub/quit");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GuardClubQuitHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.gQE != null) {
            MessageManager.getInstance().unRegisterListener(this.gQE);
        }
        if (this.gQF != null) {
            MessageManager.getInstance().unRegisterListener(this.gQE);
        }
        MessageManager.getInstance().unRegisterTask(1021139);
    }
}
