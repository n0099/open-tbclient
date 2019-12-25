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
/* loaded from: classes2.dex */
public class h extends BdBaseModel<GuardClubJoinListActivity> {
    private boolean dOT;
    private com.baidu.tieba.ala.guardclub.view.b eBP;
    private b eBR;
    private a ezJ;
    private boolean hasMore;
    private int eBQ = 1;
    private HttpMessageListener eBS = new HttpMessageListener(1021139) { // from class: com.baidu.tieba.ala.guardclub.model.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubJoinListHttpResponseMessage)) {
                if (h.this.eBP != null) {
                    h.this.eBP.aYQ();
                    return;
                }
                return;
            }
            GuardClubJoinListHttpResponseMessage guardClubJoinListHttpResponseMessage = (GuardClubJoinListHttpResponseMessage) httpResponsedMessage;
            if (guardClubJoinListHttpResponseMessage.getError() != 0) {
                if (h.this.eBP != null) {
                    h.this.eBP.aYQ();
                    return;
                }
                return;
            }
            h.this.hasMore = guardClubJoinListHttpResponseMessage.hasMore;
            if (h.this.eBP != null) {
                if (h.this.dOT) {
                    h.this.eBP.bs(guardClubJoinListHttpResponseMessage.eBN);
                    h.this.eBP.completePullRefresh();
                } else {
                    h.this.eBP.bt(guardClubJoinListHttpResponseMessage.eBN);
                }
                if (guardClubJoinListHttpResponseMessage.hasMore) {
                    h.this.eBP.bcz();
                } else if (!h.this.dOT) {
                    h.this.eBP.im(h.this.eBQ == 1);
                }
                h.this.eBQ++;
            }
        }
    };
    private HttpMessageListener eBT = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.guardclub.model.h.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubQuitHttpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == h.this.unique_id && httpResponsedMessage.getError() == 0 && h.this.eBR != null) {
                h.this.eBR.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
    }

    /* loaded from: classes2.dex */
    public interface b {
        void b(int i, String str, Object obj);
    }

    public h(BdUniqueId bdUniqueId, a aVar) {
        this.unique_id = bdUniqueId;
        this.ezJ = aVar;
        bcP();
        bcQ();
        MessageManager.getInstance().registerListener(this.eBS);
        MessageManager.getInstance().registerListener(this.eBT);
    }

    public void a(com.baidu.tieba.ala.guardclub.view.b bVar) {
        this.eBP = bVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bcL() {
        return this.hasMore;
    }

    public void bcM() {
        in(true);
    }

    public void in(boolean z) {
        this.dOT = z;
        if (z) {
            this.eBQ = 1;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            bcO();
        } else if (this.eBP != null) {
            this.eBP.aYQ();
        }
    }

    public void bcN() {
        this.dOT = false;
        if (this.eBP != null) {
            this.eBP.aZH();
            bcO();
        }
    }

    private void bcO() {
        i iVar = new i();
        iVar.setPn(this.eBQ);
        iVar.setPs(20);
        iVar.setParams();
        iVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(iVar);
    }

    public void a(String str, b bVar) {
        o oVar = new o();
        oVar.xZ(str);
        oVar.setParams();
        oVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(oVar);
        this.eBR = bVar;
    }

    private void bcP() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021139, TbConfig.SERVER_HOST + "liveserver/guardClub/joinlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bcQ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/guardClub/quit");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GuardClubQuitHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.eBS != null) {
            MessageManager.getInstance().unRegisterListener(this.eBS);
        }
        if (this.eBT != null) {
            MessageManager.getInstance().unRegisterListener(this.eBS);
        }
        MessageManager.getInstance().unRegisterTask(1021139);
    }
}
