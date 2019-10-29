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
/* loaded from: classes6.dex */
public class h extends BdBaseModel<GuardClubJoinListActivity> {
    private a dMo;
    private b dOB;
    private com.baidu.tieba.ala.guardclub.view.b dOz;
    private boolean dbQ;
    private boolean hasMore;
    private int dOA = 1;
    private HttpMessageListener dOC = new HttpMessageListener(1021139) { // from class: com.baidu.tieba.ala.guardclub.model.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubJoinListHttpResponseMessage)) {
                if (h.this.dOz != null) {
                    h.this.dOz.aLt();
                    return;
                }
                return;
            }
            GuardClubJoinListHttpResponseMessage guardClubJoinListHttpResponseMessage = (GuardClubJoinListHttpResponseMessage) httpResponsedMessage;
            if (guardClubJoinListHttpResponseMessage.getError() != 0) {
                if (h.this.dOz != null) {
                    h.this.dOz.aLt();
                    return;
                }
                return;
            }
            h.this.hasMore = guardClubJoinListHttpResponseMessage.hasMore;
            if (h.this.dOz != null) {
                if (h.this.dbQ) {
                    h.this.dOz.bt(guardClubJoinListHttpResponseMessage.dOx);
                    h.this.dOz.completePullRefresh();
                } else {
                    h.this.dOz.bu(guardClubJoinListHttpResponseMessage.dOx);
                }
                if (guardClubJoinListHttpResponseMessage.hasMore) {
                    h.this.dOz.aLr();
                } else if (!h.this.dbQ) {
                    h.this.dOz.hf(h.this.dOA == 1);
                }
                h.this.dOA++;
            }
        }
    };
    private HttpMessageListener dOD = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.guardclub.model.h.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubQuitHttpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == h.this.unique_id && httpResponsedMessage.getError() == 0 && h.this.dOB != null) {
                h.this.dOB.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
    }

    /* loaded from: classes6.dex */
    public interface b {
        void b(int i, String str, Object obj);
    }

    public h(BdUniqueId bdUniqueId, a aVar) {
        this.unique_id = bdUniqueId;
        this.dMo = aVar;
        aLI();
        aLJ();
        MessageManager.getInstance().registerListener(this.dOC);
        MessageManager.getInstance().registerListener(this.dOD);
    }

    public void a(com.baidu.tieba.ala.guardclub.view.b bVar) {
        this.dOz = bVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean aLE() {
        return this.hasMore;
    }

    public void aLF() {
        hg(true);
    }

    public void hg(boolean z) {
        this.dbQ = z;
        if (z) {
            this.dOA = 1;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            aLH();
        } else if (this.dOz != null) {
            this.dOz.aLt();
        }
    }

    public void aLG() {
        this.dbQ = false;
        if (this.dOz != null) {
            this.dOz.aJl();
            aLH();
        }
    }

    private void aLH() {
        i iVar = new i();
        iVar.setPn(this.dOA);
        iVar.setPs(20);
        iVar.setParams();
        iVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(iVar);
    }

    public void a(String str, b bVar) {
        o oVar = new o();
        oVar.to(str);
        oVar.setParams();
        oVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(oVar);
        this.dOB = bVar;
    }

    private void aLI() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021139, TbConfig.SERVER_HOST + "liveserver/guardClub/joinlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void aLJ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/guardClub/quit");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GuardClubQuitHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.dOC != null) {
            MessageManager.getInstance().unRegisterListener(this.dOC);
        }
        if (this.dOD != null) {
            MessageManager.getInstance().unRegisterListener(this.dOC);
        }
        MessageManager.getInstance().unRegisterTask(1021139);
    }
}
