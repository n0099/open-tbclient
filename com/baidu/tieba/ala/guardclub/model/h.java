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
    private boolean dPb;
    private a eAU;
    private com.baidu.tieba.ala.guardclub.view.b eDa;
    private b eDc;
    private boolean hasMore;
    private int eDb = 1;
    private HttpMessageListener eDd = new HttpMessageListener(1021139) { // from class: com.baidu.tieba.ala.guardclub.model.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof GuardClubJoinListHttpResponseMessage)) {
                if (h.this.eDa != null) {
                    h.this.eDa.aZk();
                    return;
                }
                return;
            }
            GuardClubJoinListHttpResponseMessage guardClubJoinListHttpResponseMessage = (GuardClubJoinListHttpResponseMessage) httpResponsedMessage;
            if (guardClubJoinListHttpResponseMessage.getError() != 0) {
                if (h.this.eDa != null) {
                    h.this.eDa.aZk();
                    return;
                }
                return;
            }
            h.this.hasMore = guardClubJoinListHttpResponseMessage.hasMore;
            if (h.this.eDa != null) {
                if (h.this.dPb) {
                    h.this.eDa.bs(guardClubJoinListHttpResponseMessage.eCY);
                    h.this.eDa.completePullRefresh();
                } else {
                    h.this.eDa.bt(guardClubJoinListHttpResponseMessage.eCY);
                }
                if (guardClubJoinListHttpResponseMessage.hasMore) {
                    h.this.eDa.bcU();
                } else if (!h.this.dPb) {
                    h.this.eDa.iw(h.this.eDb == 1);
                }
                h.this.eDb++;
            }
        }
    };
    private HttpMessageListener eDe = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.guardclub.model.h.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubQuitHttpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == h.this.unique_id && httpResponsedMessage.getError() == 0 && h.this.eDc != null) {
                h.this.eDc.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
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
        this.eAU = aVar;
        bdk();
        bdl();
        MessageManager.getInstance().registerListener(this.eDd);
        MessageManager.getInstance().registerListener(this.eDe);
    }

    public void a(com.baidu.tieba.ala.guardclub.view.b bVar) {
        this.eDa = bVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bdg() {
        return this.hasMore;
    }

    public void bdh() {
        ix(true);
    }

    public void ix(boolean z) {
        this.dPb = z;
        if (z) {
            this.eDb = 1;
        }
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            bdj();
        } else if (this.eDa != null) {
            this.eDa.aZk();
        }
    }

    public void bdi() {
        this.dPb = false;
        if (this.eDa != null) {
            this.eDa.bac();
            bdj();
        }
    }

    private void bdj() {
        i iVar = new i();
        iVar.setPn(this.eDb);
        iVar.setPs(20);
        iVar.setParams();
        iVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(iVar);
    }

    public void a(String str, b bVar) {
        o oVar = new o();
        oVar.ye(str);
        oVar.setParams();
        oVar.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(oVar);
        this.eDc = bVar;
    }

    private void bdk() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021139, TbConfig.SERVER_HOST + "liveserver/guardClub/joinlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bdl() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/guardClub/quit");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GuardClubQuitHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void onDestory() {
        if (this.eDd != null) {
            MessageManager.getInstance().unRegisterListener(this.eDd);
        }
        if (this.eDe != null) {
            MessageManager.getInstance().unRegisterListener(this.eDd);
        }
        MessageManager.getInstance().unRegisterTask(1021139);
    }
}
