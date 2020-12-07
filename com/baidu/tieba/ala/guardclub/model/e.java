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
    private a gPb;
    private b gQB;
    private com.baidu.tieba.ala.guardclub.view.d gQz;
    private boolean hasMore;
    private int gQA = 1;
    private HttpMessageListener gQC = new HttpMessageListener(1021139) { // from class: com.baidu.tieba.ala.guardclub.model.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubJoinListHttpResponseMessage)) {
                if (e.this.gQz != null) {
                    e.this.gQz.bOX();
                    return;
                }
                return;
            }
            GuardClubJoinListHttpResponseMessage guardClubJoinListHttpResponseMessage = (GuardClubJoinListHttpResponseMessage) httpResponsedMessage;
            if (guardClubJoinListHttpResponseMessage.getError() != 0) {
                if (e.this.gQz != null) {
                    e.this.gQz.bOX();
                    return;
                }
                return;
            }
            e.this.hasMore = guardClubJoinListHttpResponseMessage.hasMore;
            if (e.this.gQz != null) {
                if (e.this.fVi) {
                    e.this.gQz.cp(guardClubJoinListHttpResponseMessage.gQx);
                    e.this.gQz.completePullRefresh();
                } else {
                    e.this.gQz.cq(guardClubJoinListHttpResponseMessage.gQx);
                }
                if (guardClubJoinListHttpResponseMessage.hasMore) {
                    e.this.gQz.bWk();
                } else if (!e.this.fVi) {
                    e.this.gQz.mO(e.this.gQA == 1);
                }
                e.this.gQA++;
            }
        }
    };
    private HttpMessageListener gQD = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.guardclub.model.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubQuitHttpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == e.this.unique_id && httpResponsedMessage.getError() == 0 && e.this.gQB != null) {
                e.this.gQB.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
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
        this.gPb = aVar;
        bWr();
        bWs();
        MessageManager.getInstance().registerListener(this.gQC);
        MessageManager.getInstance().registerListener(this.gQD);
    }

    public void a(com.baidu.tieba.ala.guardclub.view.d dVar) {
        this.gQz = dVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bWn() {
        return this.hasMore;
    }

    public void bWo() {
        mP(true);
    }

    public void mP(boolean z) {
        this.fVi = z;
        if (z) {
            this.gQA = 1;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            bWq();
        } else if (this.gQz != null) {
            this.gQz.bOX();
        }
    }

    public void bWp() {
        this.fVi = false;
        if (this.gQz != null) {
            this.gQz.bSb();
            bWq();
        }
    }

    private void bWq() {
        f fVar = new f();
        fVar.setPn(this.gQA);
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
        this.gQB = bVar;
    }

    private void bWr() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021139, TbConfig.SERVER_HOST + "liveserver/guardClub/joinlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bWs() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/guardClub/quit");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GuardClubQuitHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.gQC != null) {
            MessageManager.getInstance().unRegisterListener(this.gQC);
        }
        if (this.gQD != null) {
            MessageManager.getInstance().unRegisterListener(this.gQC);
        }
        MessageManager.getInstance().unRegisterTask(1021139);
    }
}
